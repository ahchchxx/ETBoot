package cn.exrick.xboot.modules.web.entity;

import cn.exrick.xboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_crm_client")
@ApiModel(value = "CrmClientInfo")
public class CrmClientInfo extends BaseEntity {
	@ApiModelProperty(value = "Name")
	private String name;
	@ApiModelProperty(value = "Code")
	private String code;
	@ApiModelProperty(value = "ServiceType")
	private String serviceType;
	@ApiModelProperty(value = "Status")
	private String status;

}
