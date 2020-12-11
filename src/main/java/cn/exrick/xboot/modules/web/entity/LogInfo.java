package cn.exrick.xboot.modules.web.entity;

import cn.exrick.xboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_log")
@ApiModel(value = "LogInfo")
public class LogInfo extends BaseEntity {
	@ApiModelProperty(value = "costTime")
	private Long costTime;
	@ApiModelProperty(value = "ip")
	private String ip;
	@ApiModelProperty(value = "ipInfo")
	private String ipInfo;
	@ApiModelProperty(value = "name")
	private String name;
	@ApiModelProperty(value = "requestParam")
	private String requestParam;
	@ApiModelProperty(value = "requestType")
	private String requestType;
	@ApiModelProperty(value = "requestUrl")
	private String requestUrl;
	@ApiModelProperty(value = "username")
	private String username;
	@ApiModelProperty(value = "logType")
	private Long logType;

}
