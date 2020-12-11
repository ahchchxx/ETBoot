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
import cn.exrick.xboot.modules.web.entity.CrmEmployeeInfo;
import cn.exrick.xboot.modules.web.service.CrmEmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/xboot/crmEmployee")
public class CrmEmployeeController extends BaseController<CrmEmployeeInfo, String> {
	@Autowired
	HttpServletRequest request;
	@Autowired
	CrmEmployeeService service;
	@Override
	public BaseService<CrmEmployeeInfo, String> getService() {
		return service;
	}

	// get list by query and page
	@RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "分页获取")
	public Result<Page<CrmEmployeeInfo>> getByConditionPage(PageVo page, CrmEmployeeInfo bean) {
		QueryWrapper<CrmEmployeeInfo> qw = new QueryWrapper<>();
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
		if (!StringUtils.isEmpty(bean.getErId())) {
			qw.like("er_id", bean.getErId());
		}
		if (!StringUtils.isEmpty(bean.getCostCenter())) {
			qw.like("cost_center", bean.getCostCenter());
		}
		if (!StringUtils.isEmpty(bean.getDepartment())) {
			qw.like("department", bean.getDepartment());
		}
		if (!StringUtils.isEmpty(bean.getCustomCode())) {
			qw.like("custom_code", bean.getCustomCode());
		}
		if (!StringUtils.isEmpty(bean.getIsErLi())) {
			qw.like("is_er_li", bean.getIsErLi());
		}
		if (bean.getErLiRate() != null) {
			qw.eq("er_li_rate", bean.getErLiRate());
		}
		if (!StringUtils.isEmpty(bean.getCode())) {
			qw.like("code", bean.getCode());
		}
		if (!StringUtils.isEmpty(bean.getName())) {
			qw.like("name", bean.getName());
		}
		if (!StringUtils.isEmpty(bean.getPosition())) {
			qw.like("position", bean.getPosition());
		}
		if (!StringUtils.isEmpty(bean.getStatus())) {
			qw.like("status", bean.getStatus());
		}
		if (!StringUtils.isEmpty(bean.getType())) {
			qw.like("type", bean.getType());
		}
		if (!StringUtils.isEmpty(request.getParameter("hireDate_01"))) {
			String[] dateRange = request.getParameter("hireDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("hire_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("hire_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(request.getParameter("departureDate_01"))) {
			String[] dateRange = request.getParameter("departureDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("departure_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("departure_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(bean.getContractId())) {
			qw.like("contract_id", bean.getContractId());
		}
		if (bean.getProbationSalary() != null) {
			qw.eq("probation_salary", bean.getProbationSalary());
		}
		if (!StringUtils.isEmpty(request.getParameter("probationEndDate_01"))) {
			String[] dateRange = request.getParameter("probationEndDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("probation_end_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("probation_end_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (bean.getBaseSalary() != null) {
			qw.eq("base_salary", bean.getBaseSalary());
		}
		if (bean.getNetBaseSalary() != null) {
			qw.eq("net_base_salary", bean.getNetBaseSalary());
		}
		if (bean.getDailySalary() != null) {
			qw.eq("daily_salary", bean.getDailySalary());
		}
		if (bean.getExpartsSubsistenceAllowance() != null) {
			qw.eq("exparts_subsistence_allowance", bean.getExpartsSubsistenceAllowance());
		}
		if (bean.getFixedAllowance() != null) {
			qw.eq("fixed_allowance", bean.getFixedAllowance());
		}
		if (bean.getTransportationAllowance() != null) {
			qw.eq("transportation_allowance", bean.getTransportationAllowance());
		}
		if (bean.getMobileAllowance() != null) {
			qw.eq("mobile_allowance", bean.getMobileAllowance());
		}
		if (bean.getMealAllowance() != null) {
			qw.eq("meal_allowance", bean.getMealAllowance());
		}
		if (bean.getHeatingAllowance() != null) {
			qw.eq("heating_allowance", bean.getHeatingAllowance());
		}
		if (bean.getOtherFixedAllowance() != null) {
			qw.eq("other_fixed_allowance", bean.getOtherFixedAllowance());
		}
		if (bean.getMiddleShiftAllowance() != null) {
			qw.eq("middle_shift_allowance", bean.getMiddleShiftAllowance());
		}
		if (bean.getNightShiftAllowance() != null) {
			qw.eq("night_shift_allowance", bean.getNightShiftAllowance());
		}
		if (bean.getBirthdayAllowance() != null) {
			qw.eq("birthday_allowance", bean.getBirthdayAllowance());
		}
		if (bean.getEnterpriseAnnuityDeduction() != null) {
			qw.eq("enterprise_annuity_deduction", bean.getEnterpriseAnnuityDeduction());
		}
		if (bean.getOneChildAllowance() != null) {
			qw.eq("one_child_allowance", bean.getOneChildAllowance());
		}
		if (!StringUtils.isEmpty(bean.getUnionFee())) {
			qw.like("union_fee", bean.getUnionFee());
		}
		if (!StringUtils.isEmpty(bean.getThirteenthBonusMonth())) {
			qw.like("thirteenth_bonus_month", bean.getThirteenthBonusMonth());
		}
		if (!StringUtils.isEmpty(bean.getIs13salaryAnnulTax())) {
			qw.like("is_13salary_annul_tax", bean.getIs13salaryAnnulTax());
		}
		if (!StringUtils.isEmpty(bean.getIsAbEriit())) {
			qw.like("is_ab_eriit", bean.getIsAbEriit());
		}
		if (bean.getF001() != null) {
			qw.eq("f001", bean.getF001());
		}
		if (bean.getF002() != null) {
			qw.eq("f002", bean.getF002());
		}
		if (bean.getF003() != null) {
			qw.eq("f003", bean.getF003());
		}
		if (bean.getErWithdraw() != null) {
			qw.eq("er_withdraw", bean.getErWithdraw());
		}
		if (bean.getF005() != null) {
			qw.eq("f005", bean.getF005());
		}
		if (!StringUtils.isEmpty(bean.getSihfLocation())) {
			qw.like("sihf_location", bean.getSihfLocation());
		}
		if (!StringUtils.isEmpty(bean.getResidenceType())) {
			qw.like("residence_type", bean.getResidenceType());
		}
		if (!StringUtils.isEmpty(bean.getResidenceAddress())) {
			qw.like("residence_address", bean.getResidenceAddress());
		}
		if (!StringUtils.isEmpty(bean.getSiAccount())) {
			qw.like("si_account", bean.getSiAccount());
		}
		if (!StringUtils.isEmpty(bean.getSiProvince())) {
			qw.like("si_province", bean.getSiProvince());
		}
		if (!StringUtils.isEmpty(bean.getSiCity())) {
			qw.like("si_city", bean.getSiCity());
		}
		if (!StringUtils.isEmpty(bean.getSiStatus())) {
			qw.like("si_status", bean.getSiStatus());
		}
		if (!StringUtils.isEmpty(bean.getSiBase())) {
			qw.like("si_base", bean.getSiBase());
		}
		if (!StringUtils.isEmpty(bean.getSiErBase())) {
			qw.like("si_er_base", bean.getSiErBase());
		}
		if (!StringUtils.isEmpty(bean.getSiStartdate())) {
			qw.like("si_startdate", bean.getSiStartdate());
		}
		if (!StringUtils.isEmpty(bean.getSiEnddate())) {
			qw.like("si_enddate", bean.getSiEnddate());
		}
		if (!StringUtils.isEmpty(bean.getSiLocationId())) {
			qw.like("si_location_id", bean.getSiLocationId());
		}
		if (!StringUtils.isEmpty(bean.getHfAccount())) {
			qw.like("hf_account", bean.getHfAccount());
		}
		if (!StringUtils.isEmpty(bean.getHfSupAccount())) {
			qw.like("hf_sup_account", bean.getHfSupAccount());
		}
		if (!StringUtils.isEmpty(bean.getHfProvince())) {
			qw.like("hf_province", bean.getHfProvince());
		}
		if (!StringUtils.isEmpty(bean.getHfCity())) {
			qw.like("hf_city", bean.getHfCity());
		}
		if (!StringUtils.isEmpty(bean.getHfBase())) {
			qw.like("hf_base", bean.getHfBase());
		}
		if (!StringUtils.isEmpty(bean.getHfErBase())) {
			qw.like("hf_er_base", bean.getHfErBase());
		}
		if (!StringUtils.isEmpty(bean.getHfStartdate())) {
			qw.like("hf_startdate", bean.getHfStartdate());
		}
		if (!StringUtils.isEmpty(bean.getHfEnddate())) {
			qw.like("hf_enddate", bean.getHfEnddate());
		}
		if (!StringUtils.isEmpty(bean.getHfLocationId())) {
			qw.like("hf_location_id", bean.getHfLocationId());
		}
		if (!StringUtils.isEmpty(bean.getIsNewSihfAcctount())) {
			qw.like("is_new_sihf_acctount", bean.getIsNewSihfAcctount());
		}
		if (!StringUtils.isEmpty(bean.getFourHospital())) {
			qw.like("four_hospital", bean.getFourHospital());
		}
		if (!StringUtils.isEmpty(bean.getIitLocation())) {
			qw.like("iit_location", bean.getIitLocation());
		}
		if (bean.getTaxRefundRate() != null) {
			qw.eq("tax_refund_rate", bean.getTaxRefundRate());
		}
		if (bean.getCommercialInsurance() != null) {
			qw.eq("commercial_insurance", bean.getCommercialInsurance());
		}
		if (bean.getTotalCostOfCi() != null) {
			qw.eq("total_cost_of_ci", bean.getTotalCostOfCi());
		}
		if (!StringUtils.isEmpty(bean.getNameEn())) {
			qw.like("name_en", bean.getNameEn());
		}
		if (!StringUtils.isEmpty(bean.getGender())) {
			qw.like("gender", bean.getGender());
		}
		if (!StringUtils.isEmpty(bean.getNation())) {
			qw.like("nation", bean.getNation());
		}
		if (!StringUtils.isEmpty(bean.getIdType())) {
			qw.like("id_type", bean.getIdType());
		}
		if (!StringUtils.isEmpty(bean.getIdNum())) {
			qw.like("id_num", bean.getIdNum());
		}
		if (!StringUtils.isEmpty(request.getParameter("birthday_01"))) {
			String[] dateRange = request.getParameter("birthday_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("birthday", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("birthday", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(bean.getPhone())) {
			qw.like("phone", bean.getPhone());
		}
		if (!StringUtils.isEmpty(bean.getEmail())) {
			qw.like("email", bean.getEmail());
		}
		if (!StringUtils.isEmpty(bean.getHomeAddress())) {
			qw.like("home_address", bean.getHomeAddress());
		}
		if (!StringUtils.isEmpty(bean.getZipCode())) {
			qw.like("zip_code", bean.getZipCode());
		}
		if (!StringUtils.isEmpty(bean.getBankAccount())) {
			qw.like("bank_account", bean.getBankAccount());
		}
		if (!StringUtils.isEmpty(bean.getBankName())) {
			qw.like("bank_name", bean.getBankName());
		}
		if (!StringUtils.isEmpty(bean.getBankAccountHolder())) {
			qw.like("bank_account_holder", bean.getBankAccountHolder());
		}
		if (!StringUtils.isEmpty(bean.getBankAddress())) {
			qw.like("bank_address", bean.getBankAddress());
		}
		if (!StringUtils.isEmpty(bean.getBankCode())) {
			qw.like("bank_code", bean.getBankCode());
		}
		if (bean.getArchiveFee() != null) {
			qw.eq("archive_fee", bean.getArchiveFee());
		}
		if (!StringUtils.isEmpty(bean.getIsPortal())) {
			qw.like("is_portal", bean.getIsPortal());
		}
		if (!StringUtils.isEmpty(bean.getIfSalary())) {
			qw.like("if_salary", bean.getIfSalary());
		}
		if (!StringUtils.isEmpty(bean.getIfSi())) {
			qw.like("if_si", bean.getIfSi());
		}
		if (!StringUtils.isEmpty(bean.getIfHf())) {
			qw.like("if_hf", bean.getIfHf());
		}
		if (!StringUtils.isEmpty(bean.getIfIit())) {
			qw.like("if_iit", bean.getIfIit());
		}
		if (bean.getDepositRate() != null) {
			qw.eq("deposit_rate", bean.getDepositRate());
		}
		if (!StringUtils.isEmpty(bean.getHeatingFeeEr())) {
			qw.like("heating_fee_er", bean.getHeatingFeeEr());
		}
		if (!StringUtils.isEmpty(bean.getWithholdAgentId())) {
			qw.like("withhold_agent_id", bean.getWithholdAgentId());
		}
		if (!StringUtils.isEmpty(bean.getSalaryLocationId())) {
			qw.like("salary_location_id", bean.getSalaryLocationId());
		}
		if (!StringUtils.isEmpty(bean.getTaxFormula())) {
			qw.like("tax_formula", bean.getTaxFormula());
		}
		if (!StringUtils.isEmpty(request.getParameter("ciEndDate_01"))) {
			String[] dateRange = request.getParameter("ciEndDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("ci_end_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("ci_end_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(request.getParameter("erLiEndDate_01"))) {
			String[] dateRange = request.getParameter("erLiEndDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("er_li_end_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("er_li_end_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(request.getParameter("uionFeeEndDate_01"))) {
			String[] dateRange = request.getParameter("uionFeeEndDate_01").split(",");
			if (dateRange.length > 1) {// date range
				Date end = DateUtil.parse(dateRange[1]);
				qw.between("uion_fee_end_date", dateRange[0], DateUtil.endOfDay(end));
			} else if (dateRange.length == 1) {// date
				Date end = DateUtil.parse(dateRange[0]);
				qw.between("uion_fee_end_date", dateRange[0], DateUtil.endOfDay(end));
			}
		}
		if (!StringUtils.isEmpty(bean.getDepartureReasonType())) {
			qw.like("departure_reason_type", bean.getDepartureReasonType());
		}
		if (!StringUtils.isEmpty(bean.getDepartureReason())) {
			qw.like("departure_reason", bean.getDepartureReason());
		}
		if (!StringUtils.isEmpty(bean.getRemark())) {
			qw.like("remark", bean.getRemark());
		}

		Page<CrmEmployeeInfo> data = service.findAll(PageUtil.initMpPage(page), qw);
		return new ResultUtil<Page<CrmEmployeeInfo>>().setData(data);
	}

}

