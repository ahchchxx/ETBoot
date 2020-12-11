package cn.exrick.xboot.modules.web.service.impl;

import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.LogInfo;
import cn.exrick.xboot.modules.web.mapper.LogDao1;
import cn.exrick.xboot.modules.web.service.LogService1;
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
