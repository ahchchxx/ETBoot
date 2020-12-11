package com.etboot.modules.web.mapper;

import com.etboot.modules.base.mpbase.mapper.BaseDao;
import com.etboot.modules.web.entity.PayrollPeriodInfo;
import org.apache.ibatis.annotations.Select;

public interface PayrollPeriodDao extends BaseDao<PayrollPeriodInfo> {

    @Select("select * from t_payroll_period order by create_time desc limit 1")
    PayrollPeriodInfo getLast();
}
