package org.nercel.ccnu.edu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * 学生信息 VO
 * 
 * @author Demon
 * 
 */
@XmlRootElement
public class StudentInfoVO {

	private String id; // 标识ID
	private String realName; // 姓名
	private String loginName; // 用户名
	private String password; // 密码
	private String sex; // 性别
	private String birthday; // 出生日期yyyy-mm-dd
	private String nation; // 民族
	private String address; // 通信地址
	private String photo; // 学生照片
	private String political; // 政治面貌
	private String credentialType; // 证件类型
	private String credentialNum; // 证件号码
	private String addTime; // 填表日期
	private String email; // 电子邮件
	private String zipCode; // 邮编
	private String qq; // qq号码
	private String mobilePhone; // 移动电话

	private String workUnitId; // 工作单位
	private String workUnitName; // 工作单位名称

	private String career; // 职业
	private String academicTitle; // 职称

	private String household; // 户籍所在地
	private String bornPlace; // 籍贯

	private String coagencyId; // 合作机构id(UUID)
	private String teachingUnitId; // 教学点id(UUID)

	private String coagencyName; // 合作机构名称
	private String teachingUnitName; // 教学点名称

	private int trainingProjectId; // 培训项目id(自增)
	private int trainingBatchId; // 培训批次id
	private String educationLevelId; // 培养类别id(UUID,对应原层次)
	private String specialId; // 学科(UUID,对应原专业)

	private String trainingProjectName; // 培训项目名称
	private String trainingBatchName; // 培训批次名称
	private String educationLevelName; // 培养类别名称
	private String specialName; // 学科名称

	private int registration_status; // 报名确认状态:0-未确认;1-已确认
	private int validation_status; // 入学资格审核的审核状态：0-等待审核；1-审核通过；2-审核未通过
	private int enroll_status; // 录取状态：0-未录取;1-已录取;2-不录取

	private String studentNum; // 学号
	private String registrationNum; // 报名号
	private String enrollNum; // 录取通知书编号
	private String admissionNum; // 准考证号

	private String confirmer; // 确认人
	private String confirmDate; // 确认日期
	private String varifier; // 审核人 add by 20121114
	private String varifyDate; // 审核日期 add by 20121114

	private int feeExam; // 入学考试费
	private int feeRegistration; // 报名费
	private int feeStandard; // 收费标准

	private String tel; // 单位/住宅电话
	private String littleSmart; // 小灵通
	private String graduateLevel_former; // 原毕业层次
	private String graduateTime_former; // 原毕业时间
	private String graduateSchool_former; // 原毕业学校
	private String graduateSchoolNum_former; // 原毕业学校编号
	private String graduateSpecial_former; // 原毕业专业
	private String diplomaNum_former; // 原毕业证书编号
	private String diplomaType_former; // 原毕业证书类型

	private String workdatebegin; // 参加工作时间
	private int agree2adjust; // 是否同意专业调剂
	private int crossSpecial; // 是否跨专业
	private String enrollType; // 入学方式
	private String examptReason; // 免试原因
	private String englishLevel; // 英语水平
	private String computerLevel; // 计算机水平

	private String enrollExamSubject; // 入学考试科目
	private String examSubject; // 需考试科目
	private String examptSubject; // 免考科目
	private int passEnrollExam; // 入学考试是否通过：0-未通过；1-通过

	private String pic_sfz; // 身份证图片
	private String pic_xlz; // 原学历证书图片
	private String pic_xlbg; // 学历认证报告图片
	private String pic_hk; // 户口图片
	private String pic_jszm; // 教师证明材料图片

	private String suggestion; // 网院意见

	private int supplementInfo; // 是否完善基本信息:0-未完善；1-完善

	private int workStatus; // 职业状态 1-从业；2-待业

	// add by xl 20130315
	private int forceUpdateStatus; // 强制更新标识：0-未更新；1-已更新
	private String forceUpdateDate; // 强制更新时间

	public StudentInfoVO() {

	}

	// 培训报名信息管理调用
	public StudentInfoVO(String id, String realName, String credentialNum,
			String coagencyId, String coagencyName, String teachingUnitId,
			String teachingUnitName, int trainingProjectId,
			String trainingProjectName, int trainingBatchId,
			String trainingBatchName, String educationLevelId,
			String educationLevelName, String specialId, String specialName,
			int registration_status, int validation_status, int enroll_status) {
		this.id = id;
		this.realName = realName;
		this.credentialNum = credentialNum;
		this.coagencyId = coagencyId;
		this.teachingUnitId = teachingUnitId;
		this.coagencyName = coagencyName;
		this.teachingUnitName = teachingUnitName;
		this.trainingProjectId = trainingProjectId;
		this.trainingBatchId = trainingBatchId;
		this.educationLevelId = educationLevelId;
		this.specialId = specialId;
		this.trainingProjectName = trainingProjectName;
		this.trainingBatchName = trainingBatchName;
		this.educationLevelName = educationLevelName;
		this.specialName = specialName;
		this.registration_status = registration_status;
		this.validation_status = validation_status;
		this.enroll_status = enroll_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}

	public String getCredentialNum() {
		return credentialNum;
	}

	public void setCredentialNum(String credentialNum) {
		this.credentialNum = credentialNum;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getHousehold() {
		return household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public String getWorkdatebegin() {
		return workdatebegin;
	}

	public void setWorkdatebegin(String workdatebegin) {
		this.workdatebegin = workdatebegin;
	}

	public String getBornPlace() {
		return bornPlace;
	}

	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	public String getWorkUnitId() {
		return workUnitId;
	}

	public void setWorkUnitId(String workUnitId) {
		this.workUnitId = workUnitId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getLittleSmart() {
		return littleSmart;
	}

	public void setLittleSmart(String littleSmart) {
		this.littleSmart = littleSmart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGraduateLevel_former() {
		return graduateLevel_former;
	}

	public void setGraduateLevel_former(String graduateLevel_former) {
		this.graduateLevel_former = graduateLevel_former;
	}

	public String getGraduateTime_former() {
		return graduateTime_former;
	}

	public void setGraduateTime_former(String graduateTime_former) {
		this.graduateTime_former = graduateTime_former;
	}

	public String getVarifyDate() {
		return varifyDate;
	}

	public String getGraduateSchool_former() {
		return graduateSchool_former;
	}

	public void setGraduateSchool_former(String graduateSchool_former) {
		this.graduateSchool_former = graduateSchool_former;
	}

	public String getGraduateSchoolNum_former() {
		return graduateSchoolNum_former;
	}

	public void setGraduateSchoolNum_former(String graduateSchoolNum_former) {
		this.graduateSchoolNum_former = graduateSchoolNum_former;
	}

	public String getGraduateSpecial_former() {
		return graduateSpecial_former;
	}

	public void setGraduateSpecial_former(String graduateSpecial_former) {
		this.graduateSpecial_former = graduateSpecial_former;
	}

	public String getDiplomaNum_former() {
		return diplomaNum_former;
	}

	public void setDiplomaNum_former(String diplomaNum_former) {
		this.diplomaNum_former = diplomaNum_former;
	}

	public String getDiplomaType_former() {
		return diplomaType_former;
	}

	public void setDiplomaType_former(String diplomaType_former) {
		this.diplomaType_former = diplomaType_former;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public int getAgree2adjust() {
		return agree2adjust;
	}

	public void setAgree2adjust(int agree2adjust) {
		this.agree2adjust = agree2adjust;
	}

	public int getCrossSpecial() {
		return crossSpecial;
	}

	public void setCrossSpecial(int crossSpecial) {
		this.crossSpecial = crossSpecial;
	}

	public String getEnrollType() {
		return enrollType;
	}

	public void setEnrollType(String enrollType) {
		this.enrollType = enrollType;
	}

	public String getExamptReason() {
		return examptReason;
	}

	public void setExamptReason(String examptReason) {
		this.examptReason = examptReason;
	}

	public String getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	public String getComputerLevel() {
		return computerLevel;
	}

	public void setComputerLevel(String computerLevel) {
		this.computerLevel = computerLevel;
	}

	public int getFeeStandard() {
		return feeStandard;
	}

	public void setFeeStandard(int feeStandard) {
		this.feeStandard = feeStandard;
	}

	public String getEnrollExamSubject() {
		return enrollExamSubject;
	}

	public void setEnrollExamSubject(String enrollExamSubject) {
		this.enrollExamSubject = enrollExamSubject;
	}

	public String getExamSubject() {
		return examSubject;
	}

	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}

	public String getExamptSubject() {
		return examptSubject;
	}

	public void setExamptSubject(String examptSubject) {
		this.examptSubject = examptSubject;
	}

	public int getPassEnrollExam() {
		return passEnrollExam;
	}

	public void setPassEnrollExam(int passEnrollExam) {
		this.passEnrollExam = passEnrollExam;
	}

	public int getFeeRegistration() {
		return feeRegistration;
	}

	public void setFeeRegistration(int feeRegistration) {
		this.feeRegistration = feeRegistration;
	}

	public int getFeeExam() {
		return feeExam;
	}

	public void setFeeExam(int feeExam) {
		this.feeExam = feeExam;
	}

	public String getAdmissionNum() {
		return admissionNum;
	}

	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
	}

	public String getConfirmer() {
		return confirmer;
	}

	public void setConfirmer(String confirmer) {
		this.confirmer = confirmer;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public void setVarifyDate(String varifyDate) {
		this.varifyDate = varifyDate;
	}

	public String getVarifier() {
		return varifier;
	}

	public void setVarifier(String varifier) {
		this.varifier = varifier;
	}

	public String getPic_sfz() {
		return pic_sfz;
	}

	public void setPic_sfz(String pic_sfz) {
		this.pic_sfz = pic_sfz;
	}

	public String getPic_xlz() {
		return pic_xlz;
	}

	public void setPic_xlz(String pic_xlz) {
		this.pic_xlz = pic_xlz;
	}

	public String getPic_xlbg() {
		return pic_xlbg;
	}

	public void setPic_xlbg(String pic_xlbg) {
		this.pic_xlbg = pic_xlbg;
	}

	public String getPic_hk() {
		return pic_hk;
	}

	public void setPic_hk(String pic_hk) {
		this.pic_hk = pic_hk;
	}

	public String getPic_jszm() {
		return pic_jszm;
	}

	public void setPic_jszm(String pic_jszm) {
		this.pic_jszm = pic_jszm;
	}

	public int getRegistration_status() {
		return registration_status;
	}

	public void setRegistration_status(int registration_status) {
		this.registration_status = registration_status;
	}

	public int getValidation_status() {
		return validation_status;
	}

	public void setValidation_status(int validation_status) {
		this.validation_status = validation_status;
	}

	public int getEnroll_status() {
		return enroll_status;
	}

	public void setEnroll_status(int enroll_status) {
		this.enroll_status = enroll_status;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getSupplementInfo() {
		return supplementInfo;
	}

	public void setSupplementInfo(int supplementInfo) {
		this.supplementInfo = supplementInfo;
	}

	public int getForceUpdateStatus() {
		return forceUpdateStatus;
	}

	public void setForceUpdateStatus(int forceUpdateStatus) {
		this.forceUpdateStatus = forceUpdateStatus;
	}

	public String getForceUpdateDate() {
		return forceUpdateDate;
	}

	public void setForceUpdateDate(String forceUpdateDate) {
		this.forceUpdateDate = forceUpdateDate;
	}

	public String getEnrollNum() {
		return enrollNum;
	}

	public void setEnrollNum(String enrollNum) {
		this.enrollNum = enrollNum;
	}

	public int getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(int workStatus) {
		this.workStatus = workStatus;
	}

	public String getAcademicTitle() {
		return academicTitle;
	}

	public void setAcademicTitle(String academicTitle) {
		this.academicTitle = academicTitle;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCoagencyId() {
		return coagencyId;
	}

	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}

	public String getTeachingUnitId() {
		return teachingUnitId;
	}

	public void setTeachingUnitId(String teachingUnitId) {
		this.teachingUnitId = teachingUnitId;
	}

	public int getTrainingProjectId() {
		return trainingProjectId;
	}

	public void setTrainingProjectId(int trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}

	public int getTrainingBatchId() {
		return trainingBatchId;
	}

	public void setTrainingBatchId(int trainingBatchId) {
		this.trainingBatchId = trainingBatchId;
	}

	public String getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(String educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public String getSpecialId() {
		return specialId;
	}

	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	public String getWorkUnitName() {
		return workUnitName;
	}

	public void setWorkUnitName(String workUnitName) {
		this.workUnitName = workUnitName;
	}

	public String getCoagencyName() {
		return coagencyName;
	}

	public void setCoagencyName(String coagencyName) {
		this.coagencyName = coagencyName;
	}

	public String getTeachingUnitName() {
		return teachingUnitName;
	}

	public void setTeachingUnitName(String teachingUnitName) {
		this.teachingUnitName = teachingUnitName;
	}


	public String getTrainingProjectName() {
		return trainingProjectName;
	}

	public void setTrainingProjectName(String trainingProjectName) {
		this.trainingProjectName = trainingProjectName;
	}

	public String getTrainingBatchName() {
		return trainingBatchName;
	}

	public void setTrainingBatchName(String trainingBatchName) {
		this.trainingBatchName = trainingBatchName;
	}

	public String getEducationLevelName() {
		return educationLevelName;
	}

	public void setEducationLevelName(String educationLevelName) {
		this.educationLevelName = educationLevelName;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}
}
