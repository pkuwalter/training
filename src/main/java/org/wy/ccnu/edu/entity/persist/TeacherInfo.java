package org.wy.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * 教师
 * 
 * @author Demon
 * 
 */
@Entity
@Table(name = "teacherInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TeacherInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id; // 自增主键

	private String name; // 姓名

	private String loginName; // 用户名(唯一)

	private String password; // 密码

	private String sex; // 性别

	private String departName; // 单位名称(工作单位)

	private String position; // 职位

	private String departTel; // 单位电话

	private String mobilePhone; // 手机

	private String coagencyId; // 所属合作机构

	private String teachingUnitId; // 教学点

	private int status; // 状态(0：停用，1：启用)

	private String smartPhone; // 住宅电话

	private String lastSpecial; // 最高学历专业

	private String lastEduBackground; // 最高学历

	private String lastDegree; // 最高学位

	private String identityNum; // 身份证号

	private String birthday; // 生日
	
	private String careerId;	// 职业

	private int academicTitleId; // 职称

	private String graduateSchool; // 毕业院校

	private String email; // 邮箱

	private String researchAchievement; // 学科教学研究成果

	private int isPaperDirector; // 是否论文教师(0:否，1:是，默认0)

	private int teacherTypeId; // 教师类别

	private String address; // 通讯地址

	private String qq; // qq号码

	private String zipCode; // 邮编

	private String remark; // 个人简介

	public TeacherInfo() {

	}

	@Id
	@Column(name = "id", length = 10)
	@GenericGenerator(name = "id", strategy = "identity")
	@GeneratedValue(generator = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(length = 30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 6)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(length = 30)
	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	@Column(length = 15)
	public String getDepartTel() {
		return departTel;
	}

	public void setDepartTel(String departTel) {
		this.departTel = departTel;
	}

	@Column(length = 24)
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(length = 15)
	public String getSmartPhone() {
		return smartPhone;
	}

	public void setSmartPhone(String smartphone) {
		this.smartPhone = smartphone;
	}

	@Column(length = 20)
	public String getLastSpecial() {
		return lastSpecial;
	}

	public void setLastSpecial(String lastSpecial) {
		this.lastSpecial = lastSpecial;
	}

	@Column(length = 16)
	public String getLastEduBackground() {
		return lastEduBackground;
	}

	public void setLastEduBackground(String lastEduBackground) {
		this.lastEduBackground = lastEduBackground;
	}

	@Column(length = 10)
	public String getLastDegree() {
		return lastDegree;
	}

	public void setLastDegree(String lastDegree) {
		this.lastDegree = lastDegree;
	}

	@Column(length = 20)
	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCareerId() {
		return careerId;
	}

	public void setCareerId(String careerId) {
		this.careerId = careerId;
	}

	public int getAcademicTitleId() {
		return academicTitleId;
	}

	public void setAcademicTitleId(int academicTitleId) {
		this.academicTitleId = academicTitleId;
	}

	@Column(length = 30)
	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 500)
	public String getResearchAchievement() {
		return researchAchievement;
	}

	public void setResearchAchievement(String researchAchievement) {
		this.researchAchievement = researchAchievement;
	}

	public int getIsPaperDirector() {
		return isPaperDirector;
	}

	public void setIsPaperDirector(int isPaperDirector) {
		this.isPaperDirector = isPaperDirector;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public int getTeacherTypeId() {
		return teacherTypeId;
	}

	public void setTeacherTypeId(int teacherTypeId) {
		this.teacherTypeId = teacherTypeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
