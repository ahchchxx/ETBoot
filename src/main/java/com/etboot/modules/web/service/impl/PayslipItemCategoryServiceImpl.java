package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etboot.modules.web.entity.PayslipItemCategoryInfo;
import com.etboot.modules.web.mapper.PayslipItemCategoryDao;
import com.etboot.modules.web.service.PayslipItemCategoryService;

@Service
public class PayslipItemCategoryServiceImpl implements PayslipItemCategoryService {

    @Autowired
    PayslipItemCategoryDao dao;

    @Override
    public BaseDao<PayslipItemCategoryInfo> getDao() {
        return dao;
    }

}

