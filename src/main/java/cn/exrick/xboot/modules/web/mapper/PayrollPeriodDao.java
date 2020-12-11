package cn.exrick.xboot.modules.web.mapper;

import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import cn.exrick.xboot.modules.web.entity.PayrollPeriodInfo;
import org.apache.ibatis.annotations.Select;

public interface PayrollPeriodDao extends BaseDao<PayrollPeriodInfo> {

    @Select("select * from t_payroll_period order by create_time desc limit 1")
    PayrollPeriodInfo getLast();
}
