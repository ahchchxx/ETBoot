package com.etboot.modules.base.dao;

import com.etboot.modules.base.entity.Role;
import com.etboot.modules.base.jpabase.XbootBaseDao;

import java.util.List;

/**
 * 角色数据处理层
 * @author Exrickx
 */
public interface RoleDao extends XbootBaseDao<Role, String> {
    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
