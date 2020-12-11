package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.PayrollPeriodInfo;
import com.etboot.modules.web.mapper.PayrollPeriodDao;
import com.etboot.modules.web.service.PayrollPeriodService;

@Service
public class PayrollPeriodServiceImpl implements PayrollPeriodService {

    @Autowired
    PayrollPeriodDao dao;

    @Override
    public BaseDao<PayrollPeriodInfo> getDao() {
        return dao;
    }

    @Override
    public PayrollPeriodInfo getLast() {
        return dao.getLast();
    }
}

