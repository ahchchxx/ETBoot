package com.etboot.modules.web.service;

import com.etboot.modules.base.mpbase.BaseService;
import com.etboot.modules.web.entity.PayrollPeriodInfo;

public interface PayrollPeriodService extends BaseService<PayrollPeriodInfo, String> {
    PayrollPeriodInfo getLast();
}

