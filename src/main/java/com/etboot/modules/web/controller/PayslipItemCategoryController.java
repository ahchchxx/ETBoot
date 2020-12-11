package com.etboot.modules.web.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.etboot.modules.base.mpbase.BaseService;
import com.etboot.modules.base.mpbase.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.etboot.common.utils.PageUtil;
import com.etboot.common.utils.ResultUtil;
import com.etboot.common.vo.PageVo;
import com.etboot.common.vo.Result;
import com.etboot.modules.web.entity.PayslipItemCategoryInfo;
import com.etboot.modules.web.service.PayslipItemCategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/xboot/payslipItemCategory")
public class PayslipItemCategoryController extends BaseController<PayslipItemCategoryInfo, String> {
	@Autowired
	HttpServletRequest request;
	@Autowired
	PayslipItemCategoryService service;
	@Override
	public BaseService<PayslipItemCategoryInfo, String> getService() {
		return service;
	}

	@RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
	@ApiOperation(value = "Get list by query and page")
	public Result<Page<PayslipItemCategoryInfo>> getByConditionPage(PageVo page, PayslipItemCategoryInfo bean) {
		QueryWrapper<PayslipItemCategoryInfo> qw = new QueryWrapper<>();
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
		if (bean.getSequence() != null) {
			qw.eq("`sequence`", bean.getSequence());
		}

		Page<PayslipItemCategoryInfo> data = service.findAll(PageUtil.initMpPage(page), qw);
		return new ResultUtil<Page<PayslipItemCategoryInfo>>().setData(data);
	}

}

