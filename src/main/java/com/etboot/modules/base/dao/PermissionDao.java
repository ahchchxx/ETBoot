package com.etboot.modules.base.dao;

import com.etboot.modules.base.entity.Permission;
import com.etboot.modules.base.jpabase.XbootBaseDao;

import java.util.List;

/**
 * 权限数据处理层
 * @author Exrick
 */
public interface PermissionDao extends XbootBaseDao<Permission, String> {
    /**
     * 通过parendId查找
     * @param parentId
     * @return
     */
    List<Permission> findByParentIdOrderBySortOrder(String parentId);

    /**
     * 通过类型和状态获取
     * @param type
     * @param status
     * @return
     */
    List<Permission> findByTypeAndStatusOrderBySortOrder(Integer type, Integer status);

    /**
     * 通过名称获取
     * @param title
     * @return
     */
    List<Permission> findByTitle(String title);

    /**
     * 模糊搜索
     * @param title
     * @return
     */
    List<Permission> findByTitleLikeOrderBySortOrder(String title);
}