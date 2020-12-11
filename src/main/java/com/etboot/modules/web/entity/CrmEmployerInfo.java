package com.etboot.modules.web.entity;

import com.etboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_crm_employer")
@ApiModel(value = "CrmEmployerInfo")
public class CrmEmployerInfo extends BaseEntity {
	@ApiModelProperty(value = "Name")
	private String name;
	@ApiModelProperty(value = "Code")
	private String code;
	@ApiModelProperty(value = "Type")
	private String type;
	@ApiModelProperty(value = "ClientId")
	private String clientId;

}
