package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.CrmEmployerInfo;
import cn.exrick.xboot.modules.web.mapper.CrmEmployerDao;
import cn.exrick.xboot.modules.web.service.CrmEmployerService;

@Service
public class CrmEmployerServiceImpl implements CrmEmployerService {

    @Autowired
    CrmEmployerDao dao;

    @Override
    public BaseDao<CrmEmployerInfo> getDao() {
        return dao;
    }

}

