package com.etboot.modules.base.controller.manage;

import com.etboot.common.constant.CommonConstant;
import com.etboot.common.redis.RedisTemplateHelper;
import com.etboot.common.utils.ResultUtil;
import com.etboot.common.utils.SecurityUtil;
import com.etboot.common.vo.Result;
import com.etboot.common.config.security.permission.MySecurityMetadataSource;
import com.etboot.modules.base.entity.Permission;
import com.etboot.modules.base.entity.RolePermission;
import com.etboot.modules.base.entity.User;
import com.etboot.modules.base.service.PermissionService;
import com.etboot.modules.base.service.RolePermissionService;
import com.etboot.modules.base.service.mybatis.IPermissionService;
import com.etboot.modules.base.utils.VoUtil;
import com.etboot.modules.base.vo.MenuVo;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Exrick
 */
@Slf4j
@RestController
@Api(description = "菜单/权限管理接口")
@RequestMapping("/xboot/permission")
@CacheConfig(cacheNames = "permission")
@Transactional
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private IPermissionService iPermissionService;

    @Autowired
    private RedisTemplateHelper redisTemplate;

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private MySecurityMetadataSource mySecurityMetadataSource;

    @RequestMapping(value = "/getMenuList", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户页面菜单数据")
    public Result<List<MenuVo>> getAllMenuList() {
        List<MenuVo> menuList;
        // 读取缓存
        User u = securityUtil.getCurrUser();
        String key = "permission::userMenuList:" + u.getId();
        String v = redisTemplate.get(key);
        if (StrUtil.isNotBlank(v)) {
            menuList = new Gson().fromJson(v, new TypeToken<List<MenuVo>>() {}.getType());
            return new ResultUtil<List<MenuVo>>().setData(menuList);
        }

        // 用户所有权限，已排序去重。 xml mapper 里的原生 sql 实现
        List<Permission> list = iPermissionService.findByUserId(u.getId());

        // 筛选0级页面
        menuList = list.stream().filter(p -> CommonConstant.PERMISSION_NAV.equals(p.getType())) // Type -1 顶部菜单
                .sorted(Comparator.comparing(Permission::getSortOrder))
                .map(VoUtil::permissionToMenuVo).collect(Collectors.toList());
        getMenuByRecursion(menuList, list);// set 层级树状的菜单，

        // 缓存不存在时，缓存当前用户的菜单数据
        redisTemplate.set(key, new Gson().toJson(menuList), 15L, TimeUnit.DAYS);
        return new ResultUtil<List<MenuVo>>().setData(menuList);
    }

    private void getMenuByRecursion(List<MenuVo> curr, List<Permission> list) {
        curr.forEach(e -> {
            if (CommonConstant.LEVEL_TWO.equals(e.getLevel())) {// level：2 二级终端菜单       到二级菜单后，就跳出递归了
                List<String> buttonPermissions = list.stream() // Type 1 操作按钮
                        .filter(p -> (e.getId()).equals(p.getParentId()) && CommonConstant.PERMISSION_OPERATION.equals(p.getType()))
                        .sorted(Comparator.comparing(Permission::getSortOrder))
                        .map(Permission::getButtonType).collect(Collectors.toList());
                e.setPermTypes(buttonPermissions);
            } else {
                List<MenuVo> children = list.stream()   // Type 0 页面菜单 （包含：level为 1 一级菜单，2 二级终端菜单 两级菜单）
                        .filter(p -> (e.getId()).equals(p.getParentId()) && CommonConstant.PERMISSION_PAGE.equals(p.getType()))
                        .sorted(Comparator.comparing(Permission::getSortOrder))
                        .map(VoUtil::permissionToMenuVo).collect(Collectors.toList());
                e.setChildren(children);
                if (e.getLevel() < 3) { // level：0 顶部菜单，1 一级菜单，2 二级终端菜单，无3 操作按钮
                    getMenuByRecursion(children, list);
                }
            }
        });
    }

    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    @ApiOperation(value = "获取权限菜单树")
    @Cacheable(key = "'allList'")
    public Result<List<Permission>> getAllList() {
        List<Permission> list = permissionService.getAll();
        // 0级
        List<Permission> list0 = list.stream().filter(e -> (CommonConstant.LEVEL_ZERO).equals(e.getLevel()))
                .sorted(Comparator.comparing(Permission::getSortOrder)).collect(Collectors.toList());
        getAllByRecursion(list0, list);
        return new ResultUtil<List<Permission>>().setData(list0);
    }

    private void getAllByRecursion(List<Permission> curr, List<Permission> list) {
        curr.forEach(e -> {
            List<Permission> children = list.stream().filter(p -> (e.getId()).equals(p.getParentId()))
                    .sorted(Comparator.comparing(Permission::getSortOrder)).collect(Collectors.toList());
            e.setChildren(children);
            if (e.getLevel() < 3) {
                getAllByRecursion(children, list);
            }
        });
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加")
    @CacheEvict(key = "'menuList'")
    public Result<Permission> add(Permission permission) {
        // 判断拦截请求的操作权限按钮名是否已存在
        if (CommonConstant.PERMISSION_OPERATION.equals(permission.getType())) {
            List<Permission> list = permissionService.findByTitle(permission.getTitle());
            if (list != null && list.size() > 0) {
                return new ResultUtil<Permission>().setErrorMsg("名称已存在");
            }
        }
        Permission u = permissionService.save(permission);
        //重新加载权限
        mySecurityMetadataSource.loadResourceDefine();
        //手动删除缓存
        redisTemplate.delete("permission::allList");
        return new ResultUtil<Permission>().setData(u);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "编辑")
    public Result<Permission> edit(Permission permission) {
        // 判断拦截请求的操作权限按钮名是否已存在
        if (CommonConstant.PERMISSION_OPERATION.equals(permission.getType())) {
            // 若名称修改
            Permission p = permissionService.get(permission.getId());
            if (!p.getTitle().equals(permission.getTitle())) {
                List<Permission> list = permissionService.findByTitle(permission.getTitle());
                if (list != null && list.size() > 0) {
                    return new ResultUtil<Permission>().setErrorMsg("名称已存在");
                }
            }
        }
        Permission u = permissionService.update(permission);
        // 重新加载权限
        mySecurityMetadataSource.loadResourceDefine();
        // 手动批量删除缓存
        redisTemplate.deleteByPattern("user:" + "*");
        redisTemplate.deleteByPattern("permission::userMenuList:*");
        redisTemplate.delete("permission::allList");
        return new ResultUtil<Permission>().setData(u);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    @CacheEvict(key = "'menuList'")
    public Result<Object> delByIds(@RequestParam String[] ids) {
        for (String id : ids) {
            List<RolePermission> list = rolePermissionService.findByPermissionId(id);
            if (list != null && list.size() > 0) {
                return ResultUtil.error("删除失败，包含正被角色使用关联的菜单或权限");
            }
        }
        for (String id : ids) {
            permissionService.delete(id);
        }
        // 重新加载权限
        mySecurityMetadataSource.loadResourceDefine();
        // 手动删除缓存
        redisTemplate.delete("permission::allList");
        return ResultUtil.success("批量通过id删除数据成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiOperation(value = "搜索菜单")
    public Result<List<Permission>> searchPermissionList(@RequestParam String title) {
        List<Permission> list = permissionService.findByTitleLikeOrderBySortOrder("%" + title + "%");
        return new ResultUtil<List<Permission>>().setData(list);
    }
}
