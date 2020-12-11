package com.etboot.modules.web.service.impl;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import com.etboot.modules.web.service.LogService1;
import com.etboot.modules.web.entity.LogInfo;
import com.etboot.modules.web.mapper.LogDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//public class LogServiceImpl extends BaseServiceImpl<LogInfo, String> implements LogService {
@Service
public class LogService1Impl implements LogService1 {
    @Autowired
    LogDao1 logDao;
    @Override
    public BaseDao<LogInfo> getDao() {
        return logDao;
    }

}
