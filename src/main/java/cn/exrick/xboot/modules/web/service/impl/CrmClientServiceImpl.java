package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.CrmClientInfo;
import cn.exrick.xboot.modules.web.mapper.CrmClientDao;
import cn.exrick.xboot.modules.web.service.CrmClientService;

@Service
public class CrmClientServiceImpl implements CrmClientService {

    @Autowired
    CrmClientDao dao;

    @Override
    public BaseDao<CrmClientInfo> getDao() {
        return dao;
    }

}

