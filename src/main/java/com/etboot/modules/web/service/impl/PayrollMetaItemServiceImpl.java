package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.PayrollMetaItemInfo;
import com.etboot.modules.web.mapper.PayrollMetaItemDao;
import com.etboot.modules.web.service.PayrollMetaItemService;

@Service
public class PayrollMetaItemServiceImpl implements PayrollMetaItemService {

    @Autowired
    PayrollMetaItemDao dao;

    @Override
    public BaseDao<PayrollMetaItemInfo> getDao() {
        return dao;
    }

}

