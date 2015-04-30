package org.nercel.ccnu.edu.entity.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "studentSourceInfo")
@XmlRootElement
public class StudentSourceInfo {
	private static final long serialVersionUID = 1L;
	
	private String id;                           //教学点标识ID
	private String studentSourceNum;         //生源渠道编号
	private String studentSourceName;        //生源渠道名称
	private String studentAgencyId;                  //所属机构
	private String official;                     //联系人
	private String address;                      //办公地址
	private String zipCode;                      //邮编
	private String mobilePhone;                  //移动电话
	private String tel;                          //联系电话
	private String email;                        //Email
	private int status;                          //状态
	private String remark;  					//备注
	
	public StudentSourceInfo(){
		
	}
	public StudentSourceInfo(String id, String studentSourceNum,
			String studentSourceName, String studentAgencyId, String official,
			String address, String zipCode, String mobilePhone, String tel,
			String email, int status, String remark) {
		super();
		this.id = id;
		this.studentSourceNum = studentSourceNum;
		this.studentSourceName = studentSourceName;
		this.studentAgencyId = studentAgencyId;
		this.official = official;
		this.address = address;
		this.zipCode = zipCode;
		this.mobilePhone = mobilePhone;
		this.tel = tel;
		this.email = email;
		this.status = status;
		this.remark = remark;
	}
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@Column(length=40)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(length=10)
	public String getStudentSourceNum() {
		return studentSourceNum;
	}
	public void setStudentSourceNum(String studentSourceNum) {
		this.studentSourceNum = studentSourceNum;
	}
	@Column(length=40)
	public String getStudentSourceName() {
		return studentSourceName;
	}
	public void setStudentSourceName(String studentSourceName) {
		this.studentSourceName = studentSourceName;
	}
	@Column(length=40)
	public String getStudentAgencyId() {
		return studentAgencyId;
	}
	public void setStudentAgencyId(String studentAgencyId) {
		this.studentAgencyId = studentAgencyId;
	}
	@Column(length=30)
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}
	@Column(length=30)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length=40)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(length=40)
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	@Column(length=20)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(length=60)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=2)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(length=500)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}