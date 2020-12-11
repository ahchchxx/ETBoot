package com.etboot.modules.web.entity;

import com.etboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_payroll_meta_item")
@ApiModel(value = "PayrollMetaItemInfo")
public class PayrollMetaItemInfo extends BaseEntity {
	@ApiModelProperty(value = "Name")
	private String name;
	@ApiModelProperty(value = "Code")
	private String code;
	@ApiModelProperty(value = "ValueType")
	private String valueType;
	@ApiModelProperty(value = "SourceId")
	private String sourceId;
	@ApiModelProperty(value = "Sequence")
	@TableField("`sequence`")
	private Long sequence;
	@ApiModelProperty(value = "Precision")
	@TableField("`precision`")
	private Integer precision;

}
