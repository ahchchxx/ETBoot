package cn.exrick.xboot.modules.web.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.base.mpbase.controller.BaseController;
import cn.exrick.xboot.modules.base.mpbase.BaseService;
import cn.exrick.xboot.modules.web.entity.CrmEmployerInfo;
import cn.exrick.xboot.modules.web.service.CrmEmployerService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/xboot/crmEmployer")
public class CrmEmployerController extends BaseController<CrmEmployerInfo, String> {
	@Autowired
	HttpServletRequest request;
	@Autowired
	CrmEmployerService service;
	@Override
	public BaseService<CrmEmployerInfo, String> getService() {
		return service;
	}

	// get list by query and page
	@RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "分页获取")
	public Result<Page<CrmEmployerInfo>> getByConditionPage(PageVo page, CrmEmployerInfo bean) {
		QueryWrapper<CrmEmployerInfo> qw = new QueryWrapper<>();
		if (!StringUtils.isEmpty(bean.getCreateBy())) {
			qw.like("create_by", bean.getCreateBy());
		}
		if (!StringUtils.isEmpty(request.getParameter("createTime_01"))) {
			String[] dateRange = request.getParameter("createTime_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("create_time", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("create_time", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(bean.getUpdateBy())) {
			qw.like("update_by", bean.getUpdateBy());
		}
		if (!StringUtils.isEmpty(request.getParameter("updateTime_01"))) {
			String[] dateRange = request.getParameter("updateTime_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("update_time", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("update_time", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(bean.getName())) {
			qw.like("name", bean.getName());
		}
		if (!StringUtils.isEmpty(bean.getCode())) {
			qw.like("code", bean.getCode());
		}
		if (!StringUtils.isEmpty(bean.getType())) {
			qw.like("type", bean.getType());
		}
		if (!StringUtils.isEmpty(bean.getClientId())) {
			qw.like("client_id", bean.getClientId());
		}

		Page<CrmEmployerInfo> data = service.findAll(PageUtil.initMpPage(page), qw);
		return new ResultUtil<Page<CrmEmployerInfo>>().setData(data);
	}

}

