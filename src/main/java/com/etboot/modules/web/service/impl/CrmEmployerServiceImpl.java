package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.CrmEmployerInfo;
import com.etboot.modules.web.mapper.CrmEmployerDao;
import com.etboot.modules.web.service.CrmEmployerService;

@Service
public class CrmEmployerServiceImpl implements CrmEmployerService {

    @Autowired
    CrmEmployerDao dao;

    @Override
    public BaseDao<CrmEmployerInfo> getDao() {
        return dao;
    }

}

