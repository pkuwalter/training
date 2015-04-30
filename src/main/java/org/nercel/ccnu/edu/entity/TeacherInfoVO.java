package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 教师VO(教师管理页面显示教师使用)
 * 
 * @author Demon
 */
@XmlRootElement
public class TeacherInfoVO {

	private int id; // 自增主键

	private String name; // 姓名

	private String loginName; // 用户名(唯一)

	private String sex; // 性别

	private String teacherTypeName; // 教师类别

	private String departName; // 单位名称(工作单位)

	private String mobilePhone; // 手机

	private String coagencyId; // 所属合作机构id

	private String coagencyName; // 合作机构名称

	private String teachingUnitId; // 教学点id

	private String teachingUnitInfoName; // 教学点名称

	private int status; // 状态(0：停用，1：启用)

	private String academicTitle; // 职称

	private String email; // 邮箱

	private int teacherTypeId; // 教师类别

	private String qq; // qq号码

	public TeacherInfoVO(){
		
	}
	
	public TeacherInfoVO(int id, String name, String loginName, String sex,
			String teacherTypeName, String departName, String mobilePhone,
			String coagencyId, String coagencyName, String teachingUnitId,
			String teachingUnitInfoName, int status, String academicTitle,
			String email, int teacherTypeId, String qq) {
		this.id = id;
		this.name = name;
		this.loginName = loginName;
		this.sex = sex;
		this.teacherTypeName = teacherTypeName;
		this.departName = departName;
		this.mobilePhone = mobilePhone;
		this.coagencyId = coagencyId;
		this.coagencyName = coagencyName;
		this.teachingUnitId = teachingUnitId;
		this.teachingUnitInfoName = teachingUnitInfoName;
		this.status = status;
		this.academicTitle = academicTitle;
		this.email = email;
		this.teacherTypeId = teacherTypeId;
		this.qq = qq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTeacherTypeName() {
		return teacherTypeName;
	}

	public void setTeacherTypeName(String teacherTypeName) {
		this.teacherTypeName = teacherTypeName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	public String getTeachingUnitInfoName() {
		return teachingUnitInfoName;
	}

	public void setTeachingUnitInfoName(String teachingUnitInfoName) {
		this.teachingUnitInfoName = teachingUnitInfoName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAcademicTitle() {
		return academicTitle;
	}

	public void setAcademicTitle(String academicTitle) {
		this.academicTitle = academicTitle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTeacherTypeId() {
		return teacherTypeId;
	}

	public void setTeacherTypeId(int teacherTypeId) {
		this.teacherTypeId = teacherTypeId;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
}
