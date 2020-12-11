package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.PayrollPayitemInfo;
import com.etboot.modules.web.mapper.PayrollPayitemDao;
import com.etboot.modules.web.service.PayrollPayitemService;

@Service
public class PayrollPayitemServiceImpl implements PayrollPayitemService {

    @Autowired
    PayrollPayitemDao dao;

    @Override
    public BaseDao<PayrollPayitemInfo> getDao() {
        return dao;
    }

}

