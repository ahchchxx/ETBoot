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
import cn.exrick.xboot.modules.web.entity.PayrollPayitemInfo;
import cn.exrick.xboot.modules.web.service.PayrollPayitemService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/xboot/payrollPayitem")
public class PayrollPayitemController extends BaseController<PayrollPayitemInfo, String> {
	@Autowired
	HttpServletRequest request;
	@Autowired
	PayrollPayitemService service;
	@Override
	public BaseService<PayrollPayitemInfo, String> getService() {
		return service;
	}

	@RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
	@ApiOperation(value = "Get list by query and page")
	public Result<Page<PayrollPayitemInfo>> getByConditionPage(PageVo page, PayrollPayitemInfo bean) {
		QueryWrapper<PayrollPayitemInfo> qw = new QueryWrapper<>();
		if (!StringUtils.isEmpty(bean.getCreateBy())) {
			qw.like("`create_by`", bean.getCreateBy());
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
			qw.like("`update_by`", bean.getUpdateBy());
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
			qw.like("`name`", bean.getName());
		}
		if (!StringUtils.isEmpty(bean.getCode())) {
			qw.like("`code`", bean.getCode());
		}
		if (bean.getSequence() != null) {
			qw.eq("`sequence`", bean.getSequence());
		}
		if (bean.getPayslipCatId() != null) {
			qw.eq("`payslip_cat_id`", bean.getPayslipCatId());
		}
		if (bean.getGroupId() != null) {
			qw.eq("`group_id`", bean.getGroupId());
		}
		if (bean.getMetaId() != null) {
			qw.eq("`meta_id`", bean.getMetaId());
		}
		if (!StringUtils.isEmpty(bean.getValueType())) {
			qw.like("`value_type`", bean.getValueType());
		}
		if (!StringUtils.isEmpty(bean.getSourceId())) {
			qw.like("`source_id`", bean.getSourceId());
		}
		if (bean.getPrecision() != null) {
			qw.eq("`precision`", bean.getPrecision());
		}
		if (!StringUtils.isEmpty(bean.getScriptCode())) {
			qw.like("`script_code`", bean.getScriptCode());
		}

		Page<PayrollPayitemInfo> data = service.findAll(PageUtil.initMpPage(page), qw);
		return new ResultUtil<Page<PayrollPayitemInfo>>().setData(data);
	}

}

