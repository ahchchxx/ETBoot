package com.etboot.modules.base.serviceimpl;

import com.etboot.modules.base.dao.DepartmentHeaderDao;
import com.etboot.modules.base.entity.DepartmentHeader;
import com.etboot.modules.base.service.DepartmentHeaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门负责人接口实现
 * @author Exrick
 */
@Slf4j
@Service
@Transactional
public class DepartmentHeaderServiceImpl implements DepartmentHeaderService {
    @Autowired
    private DepartmentHeaderDao departmentHeaderDao;

    @Override
    public DepartmentHeaderDao getRepository() {
        return departmentHeaderDao;
    }


    @Override
    public List<String> findHeaderByDepartmentId(String departmentId, Integer type) {
        List<String> list = new ArrayList<>();
        List<DepartmentHeader> headers = departmentHeaderDao.findByDepartmentIdAndType(departmentId, type);
        headers.forEach(e -> {
            list.add(e.getUserId());
        });
        return list;
    }

    @Override
    public void deleteByDepartmentId(String departmentId) {
        departmentHeaderDao.deleteByDepartmentId(departmentId);
    }

    @Override
    public void deleteByUserId(String userId) {
        departmentHeaderDao.deleteByUserId(userId);
    }
}