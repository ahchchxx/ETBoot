package cn.exrick.xboot.modules.web.entity;

import cn.exrick.xboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_payslip_item_category")
@ApiModel(value = "PayslipItemCategoryInfo")
public class PayslipItemCategoryInfo extends BaseEntity {
	@ApiModelProperty(value = "Name")
	@TableField("`name`")
	private String name;
	@ApiModelProperty(value = "Sequence")
	@TableField("`sequence`")
	private Long sequence;

}
