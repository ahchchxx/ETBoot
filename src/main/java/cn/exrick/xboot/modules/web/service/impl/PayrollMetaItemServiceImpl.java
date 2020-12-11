package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.PayrollMetaItemInfo;
import cn.exrick.xboot.modules.web.mapper.PayrollMetaItemDao;
import cn.exrick.xboot.modules.web.service.PayrollMetaItemService;

@Service
public class PayrollMetaItemServiceImpl implements PayrollMetaItemService {

    @Autowired
    PayrollMetaItemDao dao;

    @Override
    public BaseDao<PayrollMetaItemInfo> getDao() {
        return dao;
    }

}

