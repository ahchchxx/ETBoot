package cn.exrick.xboot.modules.web.service;

import cn.exrick.xboot.modules.base.mpbase.BaseService;
import cn.exrick.xboot.modules.web.entity.PayrollPeriodInfo;

public interface PayrollPeriodService extends BaseService<PayrollPeriodInfo, String> {
    PayrollPeriodInfo getLast();
}

