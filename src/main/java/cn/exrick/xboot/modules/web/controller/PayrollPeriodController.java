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
import cn.exrick.xboot.modules.web.entity.PayrollPeriodInfo;
import cn.exrick.xboot.modules.web.service.PayrollPeriodService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/xboot/payrollPeriod")
public class PayrollPeriodController extends BaseController<PayrollPeriodInfo, String> {
	@Autowired
	HttpServletRequest request;
	@Autowired
	PayrollPeriodService service;
	@Override
	public BaseService<PayrollPeriodInfo, String> getService() {
		return service;
	}

	// get list by query and page
	@RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
	@ApiOperation(value = "分页获取")
	public Result<Page<PayrollPeriodInfo>> getByConditionPage(PageVo page, PayrollPeriodInfo bean) {
		QueryWrapper<PayrollPeriodInfo> qw = new QueryWrapper<>();
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
		if (!StringUtils.isEmpty(request.getParameter("startDate_01"))) {
			String[] dateRange = request.getParameter("startDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("start_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("start_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(request.getParameter("endDate_01"))) {
			String[] dateRange = request.getParameter("endDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("end_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("end_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (bean.getWorkdayNum() != null) {
			qw.eq("workday_num", bean.getWorkdayNum());
		}

		Page<PayrollPeriodInfo> data = service.findAll(PageUtil.initMpPage(page), qw);
		return new ResultUtil<Page<PayrollPeriodInfo>>().setData(data);
	}

	@RequestMapping(value = "/getNext", method = RequestMethod.GET)
	@ApiOperation(value = "为下一条数据填充数据")
	public Result<PayrollPeriodInfo> getNext() {
		PayrollPeriodInfo last = service.getLast();
		if (last == null) {
			last = new PayrollPeriodInfo();
			last.setStartDate(DateUtil.parse(DateUtil.date().year() - 1 + "1201", "yyyyMMdd")); // last year
		}
		Date startOfMonth = DateUtil.offsetMonth(last.getStartDate(), 1);
		last.setName("PP" + DateUtil.format(startOfMonth, "yyyyMM"));
		last.setCode(DateUtil.format(startOfMonth, "yyyyMM"));
		last.setStartDate(startOfMonth);
		Date endOfMonth = DateUtil.endOfMonth(startOfMonth);
		last.setEndDate(endOfMonth);
		long dayCount = DateUtil.betweenDay(startOfMonth, endOfMonth, true) + 1;
		Date start1 = startOfMonth;
		while (!DateUtil.isSameDay(start1, DateUtil.offsetDay(endOfMonth, 1))) {
			if (DateUtil.dayOfWeek(start1) == 1 || DateUtil.dayOfWeek(start1) == 7) { // weekend
				dayCount--;
			}
			start1 = DateUtil.offsetDay(start1, 1);
		};
		last.setWorkdayNum(dayCount);

		return ResultUtil.data(last);
	}
}

