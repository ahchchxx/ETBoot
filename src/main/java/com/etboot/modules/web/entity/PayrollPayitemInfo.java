package com.etboot.modules.web.entity;

import com.etboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_payroll_payitem")
@ApiModel(value = "PayrollPayitemInfo")
public class PayrollPayitemInfo extends BaseEntity {
	@ApiModelProperty(value = "Name")
	@TableField("`name`")
	private String name;
	@ApiModelProperty(value = "Code")
	@TableField("`code`")
	private String code;
	@ApiModelProperty(value = "Sequence")
	@TableField("`sequence`")
	private Long sequence;
	@ApiModelProperty(value = "PayslipCatId")
	@TableField("`payslip_cat_id`")
	private Long payslipCatId;
	@ApiModelProperty(value = "GroupId")
	@TableField("`group_id`")
	private Long groupId;
	@ApiModelProperty(value = "MetaId")
	@TableField("`meta_id`")
	private Long metaId;
	@ApiModelProperty(value = "ValueType")
	@TableField("`value_type`")
	private String valueType;
	@ApiModelProperty(value = "SourceId")
	@TableField("`source_id`")
	private String sourceId;
	@ApiModelProperty(value = "Precision")
	@TableField("`precision`")
	private Long precision;
	@ApiModelProperty(value = "ScriptCode")
	@TableField("`script_code`")
	private String scriptCode;

}
