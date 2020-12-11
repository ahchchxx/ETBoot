package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.CrmEmployeeInfo;
import com.etboot.modules.web.mapper.CrmEmployeeDao;
import com.etboot.modules.web.service.CrmEmployeeService;

@Service
public class CrmEmployeeServiceImpl implements CrmEmployeeService {

    @Autowired
    CrmEmployeeDao dao;

    @Override
    public BaseDao<CrmEmployeeInfo> getDao() {
        return dao;
    }

}

