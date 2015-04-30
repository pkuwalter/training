package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
import org.nercel.ccnu.edu.entity.HeadTeacherVO;

/**
 * 班主任
 * 
 * @author Demon
 */
@Entity
@Table(name = "headTeacher")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class HeadTeacher implements Serializable {

	private int id; // 自增主键

	private String realName; // 姓名

	private String loginName; // 用户名

	private String sex; // 性别

	private String password; // 密码
	
	private String identityNum; // 身份证号

	private String address; // 通讯地址

	private int workUnitId; // 工作单位(工作单位)

	private String qq; // qq号码

	private String mobilePhone; // 移动电话

	private String tel; // 电话

	private String email; // 邮箱

	private int status; // 状态(0:停用，1:启用)

	private String dutyType; // 职责类型(取值：非教师、助教和主讲教师)

	private String coagencyId; // 合作机构id

	private String teachingUnitId; // 教学点id

	private String trainingProjectId; // 所属培训项目
	
	private String remark;	// 备注

	public HeadTeacher() {

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public int getWorkUnitId() {
		return workUnitId;
	}

	public void setWorkUnitId(int workUnitId) {
		this.workUnitId = workUnitId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCoagencyId() {
		return coagencyId;
	}

	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}

	public String getDutyType() {
		return dutyType;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	public String getTeachingUnitId() {
		return teachingUnitId;
	}

	public void setTeachingUnitId(String teachingUnitId) {
		this.teachingUnitId = teachingUnitId;
	}

	public String getTrainingProjectId() {
		return trainingProjectId;
	}

	public void setTrainingProjectId(String trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}

	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
