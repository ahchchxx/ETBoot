package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.PayrollPeriodInfo;
import cn.exrick.xboot.modules.web.mapper.PayrollPeriodDao;
import cn.exrick.xboot.modules.web.service.PayrollPeriodService;

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

