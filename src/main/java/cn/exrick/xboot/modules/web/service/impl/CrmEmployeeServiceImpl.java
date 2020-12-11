package cn.exrick.xboot.modules.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.CrmEmployeeInfo;
import cn.exrick.xboot.modules.web.mapper.CrmEmployeeDao;
import cn.exrick.xboot.modules.web.service.CrmEmployeeService;

@Service
public class CrmEmployeeServiceImpl implements CrmEmployeeService {

    @Autowired
    CrmEmployeeDao dao;

    @Override
    public BaseDao<CrmEmployeeInfo> getDao() {
        return dao;
    }

}

