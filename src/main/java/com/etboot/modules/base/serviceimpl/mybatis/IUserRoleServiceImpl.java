package com.etboot.modules.base.serviceimpl.mybatis;

import com.etboot.modules.base.dao.mapper.UserRoleMapper;
import com.etboot.modules.base.entity.Role;
import com.etboot.modules.base.entity.UserRole;
import com.etboot.modules.base.service.mybatis.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Exrickx
 */
@Service
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findByUserId(String userId) {
        return userRoleMapper.findByUserId(userId);
    }

    @Override
    public List<String> findDepIdsByUserId(String userId) {
        return userRoleMapper.findDepIdsByUserId(userId);
    }
}
