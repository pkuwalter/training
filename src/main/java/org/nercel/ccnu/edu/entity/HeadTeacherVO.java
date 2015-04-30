package org.nercel.ccnu.edu.entity;

/**
 * 班主任 VO
 * @author Demon
 *
 */
public class HeadTeacherVO {

	private int id; // 自增主键

	private String realName; // 姓名

	private String loginName; // 用户名
	
	private String sex;		// 性别

	private String password; // 密码
	
	private String identityNum; // 身份证号

	private String address; // 通讯地址
	
	private int workUnitId; // 工作单位(工作单位)
	private String workUnitName; // 工作单位名称
	private String location; // 工作单位地址

	private String qq; // qq号码

	private String mobilePhone; // 移动电话

	private String tel; // 电话

	private String email; // 邮箱

	private int status; // 状态(0:停用，1:启用)
	
	private String dutyType; // 职责类型(取值：非教师、助教和主讲教师)

	private String coagencyId; // 合作机构id
	private String coagencyName;	// 合作机构名称

	private String teachingUnitId; // 教学点id
	private String teachingUnitName; // 教学点名称

	private String trainingProjectId; // 所属培训项目
	private String trainingProjectName; // 培训项目名称
	private String trainingProjectCode; // 培训项目代码
	
	public HeadTeacherVO(){
		
	}
	
	public HeadTeacherVO(int id, String realName, String loginName,String identityNum, String sex,
			int workUnitId, String workUnitName, String location, String qq,
			String mobilePhone, String email, int status, String coagencyId,
			String coagencyName, String teachingUnitId,
			String teachingUnitName, String trainingProjectId,
			String trainingProjectName,String trainingProjectCode) {
		this.id = id;
		this.realName = realName;
		this.loginName = loginName;
		this.identityNum = identityNum;
		this.sex = sex;
		this.workUnitId = workUnitId;
		this.workUnitName = workUnitName;
		this.location = location;
		this.qq = qq;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.status = status;
		this.coagencyId = coagencyId;
		this.coagencyName = coagencyName;
		this.teachingUnitId = teachingUnitId;
		this.teachingUnitName = teachingUnitName;
		this.trainingProjectId = trainingProjectId;
		this.trainingProjectName = trainingProjectName;
		this.trainingProjectCode = trainingProjectCode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getWorkUnitId() {
		return workUnitId;
	}

	public void setWorkUnitId(int workUnitId) {
		this.workUnitId = workUnitId;
	}

	public String getWorkUnitName() {
		return workUnitName;
	}
	public void setWorkUnitName(String workUnitName) {
		this.workUnitName = workUnitName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDutyType() {
		return dutyType;
	}
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}
	public String getCoagencyId() {
		return coagencyId;
	}
	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}
	public String getCoagencyName() {
		return coagencyName;
	}
	public void setCoagencyName(String coagencyName) {
		this.coagencyName = coagencyName;
	}
	public String getTeachingUnitId() {
		return teachingUnitId;
	}
	public void setTeachingUnitId(String teachingUnitId) {
		this.teachingUnitId = teachingUnitId;
	}
	public String getTeachingUnitName() {
		return teachingUnitName;
	}
	public void setTeachingUnitName(String teachingUnitName) {
		this.teachingUnitName = teachingUnitName;
	}
	public String getTrainingProjectId() {
		return trainingProjectId;
	}
	public void setTrainingProjectId(String trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}
	public String getTrainingProjectName() {
		return trainingProjectName;
	}
	public void setTrainingProjectName(String trainingProjectName) {
		this.trainingProjectName = trainingProjectName;
	}

	public String getTrainingProjectCode() {
		return trainingProjectCode;
	}

	public void setTrainingProjectCode(String trainingProjectCode) {
		this.trainingProjectCode = trainingProjectCode;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	
}
