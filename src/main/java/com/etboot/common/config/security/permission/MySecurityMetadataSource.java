package com.etboot.common.config.security.permission;

import com.etboot.common.config.properties.IgnoredUrlsProperties;
import com.etboot.common.constant.CommonConstant;
import com.etboot.common.utils.SecurityUtil;
import com.etboot.common.vo.RoleDTO;
import com.etboot.modules.base.entity.Permission;
import com.etboot.modules.base.service.PermissionService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * 权限资源管理器
 * 为权限决断器提供支持
 * @author Exrickx
 */
@Slf4j
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    IgnoredUrlsProperties ignoredUrlsProperties;
    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PathMatcher pathMatcher; // new AntPathMatcher(); ？

    private Map<String, Collection<ConfigAttribute>> map = null;

    /**
     * 加载权限表中所有操作请求权限
     */
    public void loadResourceDefine() {
        map = new HashMap<>(16);
        Collection<ConfigAttribute> configAttributes;
        ConfigAttribute cfg;
        // 获取启用的权限操作请求
        List<Permission> permissions = permissionService.findByTypeAndStatusOrderBySortOrder(
                CommonConstant.PERMISSION_OPERATION, CommonConstant.STATUS_NORMAL);
        for (Permission permission : permissions) {
            if (StrUtil.isBlank(permission.getTitle()) || StrUtil.isBlank(permission.getPath())) {
                continue;
            }
            configAttributes = new ArrayList<>();
            cfg = new SecurityConfig(permission.getTitle());
            // 作为MyAccessDecisionManager类的decide的第三个参数
            configAttributes.add(cfg);
            // 用权限的path作为map的key，用ConfigAttribute的集合作为value
            map.put(permission.getPath(), configAttributes);
        }
    }

    /**
     * 判定用户请求的url是否在权限表中
     * 如果在权限表中，则返回给decide方法，用来判定用户是否有此权限
     * 如果不在权限表中则放行
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (map == null) {
            loadResourceDefine();
        }
        // Object中包含用户请求request
        String url = ((FilterInvocation) o).getRequestUrl();

        // TODO 不做校验 0， 未登录的情况下？？？  这个和未登录判断哪个在前，哪个在后。是否会有安全问题
        if(!securityUtil.isCurrUserLogin()) {
            return null;
        }
        // 不做校验 1，admin 角色的用户
        List<RoleDTO> roles = securityUtil.getCurrUser().getRoles();
        for (RoleDTO role : roles) {
            if ("ROLE_ADMIN".equals(role.getName()))
                return null;
        }
        // 不做校验 2，被 ignore 的链接
        for (String ignoreUrl : ignoredUrlsProperties.getUrls()) {
            if (StrUtil.isNotBlank(ignoreUrl) && pathMatcher.match(ignoreUrl, url))
                return null;
        }

        // 判断受访问的URL资源，是否在权限表中进行管控，并返回用 SecurityConfig 封装的资源
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String resURL = iterator.next();
            if (StrUtil.isNotBlank(resURL) && pathMatcher.match(resURL, url)) {
                return map.get(resURL);
            }
        }
        // return null;
        // TODO 管理员默认可以访问任意资源，角色名称不能换
        // URL不存在permission 表里的情况下，只能管理员可以访问
        // 按下面这样写的话，每一个接口（URL资源）都要加上访问权限管控
        Collection<ConfigAttribute> configAttributes = new ArrayList<>();
        configAttributes.add(new SecurityConfig("ROLE_ADMIN"));
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
