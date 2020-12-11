package com.etboot.modules.base.entity;

import com.etboot.modules.base.jpabase.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Data
@TableName("t_setting")
@ApiModel(value = "配置")
@NoArgsConstructor
public class Setting extends XbootBaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置值value")
    private String value;

    public Setting(String id){
        super.setId(id);
    }
}