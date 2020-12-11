package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.PayslipItemCategoryInfo;
import cn.exrick.xboot.modules.web.mapper.PayslipItemCategoryDao;
import cn.exrick.xboot.modules.web.service.PayslipItemCategoryService;

@Service
public class PayslipItemCategoryServiceImpl implements PayslipItemCategoryService {

    @Autowired
    PayslipItemCategoryDao dao;

    @Override
    public BaseDao<PayslipItemCategoryInfo> getDao() {
        return dao;
    }

}

