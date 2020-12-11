package cn.exrick.xboot.modules.web.entity;

import cn.exrick.xboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@TableName("t_payroll_period")
@ApiModel(value = "PayrollPeriodInfo")
public class PayrollPeriodInfo extends BaseEntity {
	@ApiModelProperty(value = "Name")
	private String name;
	@ApiModelProperty(value = "Code")
	private String code;
	@ApiModelProperty(value = "StartDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@ApiModelProperty(value = "EndDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	@ApiModelProperty(value = "WorkdayNum")
	private Long workdayNum;

}
