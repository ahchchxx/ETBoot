package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.CrmClientInfo;
import com.etboot.modules.web.mapper.CrmClientDao;
import com.etboot.modules.web.service.CrmClientService;

@Service
public class CrmClientServiceImpl implements CrmClientService {

    @Autowired
    CrmClientDao dao;

    @Override
    public BaseDao<CrmClientInfo> getDao() {
        return dao;
    }

}

