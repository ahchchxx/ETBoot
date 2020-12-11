package com.etboot.modules.base.service.mybatis;

import com.etboot.modules.base.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Exrickx
 */
public interface IPermissionService extends IService<Permission> {
    /**
     * 通过用户id获取
     * @param userId
     * @return
     */
    List<Permission> findByUserId(String userId);
}
