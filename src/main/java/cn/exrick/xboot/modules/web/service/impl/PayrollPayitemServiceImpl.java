package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.PayrollPayitemInfo;
import cn.exrick.xboot.modules.web.mapper.PayrollPayitemDao;
import cn.exrick.xboot.modules.web.service.PayrollPayitemService;

@Service
public class PayrollPayitemServiceImpl implements PayrollPayitemService {

    @Autowired
    PayrollPayitemDao dao;

    @Override
    public BaseDao<PayrollPayitemInfo> getDao() {
        return dao;
    }

}

