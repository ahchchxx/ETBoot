package cn.exrick.xboot.modules.web.entity;

import cn.exrick.xboot.modules.base.mpbase.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@TableName("t_crm_employee")
@ApiModel(value = "CrmEmployeeInfo")
public class CrmEmployeeInfo extends BaseEntity {
	@ApiModelProperty(value = "ErId")
	private String erId;
	@ApiModelProperty(value = "CostCenter")
	private String costCenter;
	@ApiModelProperty(value = "Department")
	private String department;
	@ApiModelProperty(value = "CustomCode")
	private String customCode;
	@ApiModelProperty(value = "IsErLi")
	private String isErLi;
	@ApiModelProperty(value = "ErLiRate")
	private Double erLiRate;
	@ApiModelProperty(value = "Code")
	private String code;
	@ApiModelProperty(value = "Name")
	private String name;
	@ApiModelProperty(value = "Position")
	private String position;
	@ApiModelProperty(value = "Status")
	private String status;
	@ApiModelProperty(value = "Type")
	private String type;
	@ApiModelProperty(value = "HireDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	@ApiModelProperty(value = "DepartureDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;
	@ApiModelProperty(value = "ContractId")
	private String contractId;
	@ApiModelProperty(value = "ProbationSalary")
	private Double probationSalary;
	@ApiModelProperty(value = "ProbationEndDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date probationEndDate;
	@ApiModelProperty(value = "BaseSalary")
	private Double baseSalary;
	@ApiModelProperty(value = "NetBaseSalary")
	private Double netBaseSalary;
	@ApiModelProperty(value = "DailySalary")
	private Double dailySalary;
	@ApiModelProperty(value = "ExpartsSubsistenceAllowance")
	private Double expartsSubsistenceAllowance;
	@ApiModelProperty(value = "FixedAllowance")
	private Double fixedAllowance;
	@ApiModelProperty(value = "TransportationAllowance")
	private Double transportationAllowance;
	@ApiModelProperty(value = "MobileAllowance")
	private Double mobileAllowance;
	@ApiModelProperty(value = "MealAllowance")
	private Double mealAllowance;
	@ApiModelProperty(value = "HeatingAllowance")
	private Double heatingAllowance;
	@ApiModelProperty(value = "OtherFixedAllowance")
	private Double otherFixedAllowance;
	@ApiModelProperty(value = "MiddleShiftAllowance")
	private Double middleShiftAllowance;
	@ApiModelProperty(value = "NightShiftAllowance")
	private Double nightShiftAllowance;
	@ApiModelProperty(value = "BirthdayAllowance")
	private Double birthdayAllowance;
	@ApiModelProperty(value = "EnterpriseAnnuityDeduction")
	private Double enterpriseAnnuityDeduction;
	@ApiModelProperty(value = "OneChildAllowance")
	private Double oneChildAllowance;
	@ApiModelProperty(value = "UnionFee")
	private String unionFee;
	@ApiModelProperty(value = "ThirteenthBonusMonth")
	private String thirteenthBonusMonth;
	@ApiModelProperty(value = "Is13salaryAnnulTax")
	private String is13salaryAnnulTax;
	@ApiModelProperty(value = "IsAbEriit")
	private String isAbEriit;
	@ApiModelProperty(value = "F001")
	private Double f001;
	@ApiModelProperty(value = "F002")
	private Double f002;
	@ApiModelProperty(value = "F003")
	private Double f003;
	@ApiModelProperty(value = "ErWithdraw")
	private Double erWithdraw;
	@ApiModelProperty(value = "F005")
	private Double f005;
	@ApiModelProperty(value = "SihfLocation")
	private String sihfLocation;
	@ApiModelProperty(value = "ResidenceType")
	private String residenceType;
	@ApiModelProperty(value = "ResidenceAddress")
	private String residenceAddress;
	@ApiModelProperty(value = "SiAccount")
	private String siAccount;
	@ApiModelProperty(value = "SiProvince")
	private String siProvince;
	@ApiModelProperty(value = "SiCity")
	private String siCity;
	@ApiModelProperty(value = "SiStatus")
	private String siStatus;
	@ApiModelProperty(value = "SiBase")
	private String siBase;
	@ApiModelProperty(value = "SiErBase")
	private String siErBase;
	@ApiModelProperty(value = "SiStartdate")
	private String siStartdate;
	@ApiModelProperty(value = "SiEnddate")
	private String siEnddate;
	@ApiModelProperty(value = "SiLocationId")
	private String siLocationId;
	@ApiModelProperty(value = "HfAccount")
	private String hfAccount;
	@ApiModelProperty(value = "HfSupAccount")
	private String hfSupAccount;
	@ApiModelProperty(value = "HfProvince")
	private String hfProvince;
	@ApiModelProperty(value = "HfCity")
	private String hfCity;
	@ApiModelProperty(value = "HfBase")
	private String hfBase;
	@ApiModelProperty(value = "HfErBase")
	private String hfErBase;
	@ApiModelProperty(value = "HfStartdate")
	private String hfStartdate;
	@ApiModelProperty(value = "HfEnddate")
	private String hfEnddate;
	@ApiModelProperty(value = "HfLocationId")
	private String hfLocationId;
	@ApiModelProperty(value = "IsNewSihfAcctount")
	private String isNewSihfAcctount;
	@ApiModelProperty(value = "FourHospital")
	private String fourHospital;
	@ApiModelProperty(value = "IitLocation")
	private String iitLocation;
	@ApiModelProperty(value = "TaxRefundRate")
	private Double taxRefundRate;
	@ApiModelProperty(value = "CommercialInsurance")
	private Double commercialInsurance;
	@ApiModelProperty(value = "TotalCostOfCi")
	private Double totalCostOfCi;
	@ApiModelProperty(value = "NameEn")
	private String nameEn;
	@ApiModelProperty(value = "Gender")
	private String gender;
	@ApiModelProperty(value = "Nation")
	private String nation;
	@ApiModelProperty(value = "IdType")
	private String idType;
	@ApiModelProperty(value = "IdNum")
	private String idNum;
	@ApiModelProperty(value = "Birthday")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	@ApiModelProperty(value = "Phone")
	private String phone;
	@ApiModelProperty(value = "Email")
	private String email;
	@ApiModelProperty(value = "HomeAddress")
	private String homeAddress;
	@ApiModelProperty(value = "ZipCode")
	private String zipCode;
	@ApiModelProperty(value = "BankAccount")
	private String bankAccount;
	@ApiModelProperty(value = "BankName")
	private String bankName;
	@ApiModelProperty(value = "BankAccountHolder")
	private String bankAccountHolder;
	@ApiModelProperty(value = "BankAddress")
	private String bankAddress;
	@ApiModelProperty(value = "BankCode")
	private String bankCode;
	@ApiModelProperty(value = "ArchiveFee")
	private Double archiveFee;
	@ApiModelProperty(value = "IsPortal")
	private String isPortal;
	@ApiModelProperty(value = "IfSalary")
	private String ifSalary;
	@ApiModelProperty(value = "IfSi")
	private String ifSi;
	@ApiModelProperty(value = "IfHf")
	private String ifHf;
	@ApiModelProperty(value = "IfIit")
	private String ifIit;
	@ApiModelProperty(value = "DepositRate")
	private Double depositRate;
	@ApiModelProperty(value = "HeatingFeeEr")
	private String heatingFeeEr;
	@ApiModelProperty(value = "WithholdAgentId")
	private String withholdAgentId;
	@ApiModelProperty(value = "SalaryLocationId")
	private String salaryLocationId;
	@ApiModelProperty(value = "TaxFormula")
	private String taxFormula;
	@ApiModelProperty(value = "CiEndDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ciEndDate;
	@ApiModelProperty(value = "ErLiEndDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date erLiEndDate;
	@ApiModelProperty(value = "UionFeeEndDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date uionFeeEndDate;
	@ApiModelProperty(value = "DepartureReasonType")
	private String departureReasonType;
	@ApiModelProperty(value = "DepartureReason")
	private String departureReason;
	@ApiModelProperty(value = "Remark")
	private String remark;

}
