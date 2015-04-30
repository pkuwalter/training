package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeachingUnitInfoVO {

	private String id;                           //报名点标识ID
	private String teachingUnitNum;         //报名点编号
	private String teachingUnitName;        //报名点名称
	private String coagency;                  //所属学习中心
	private String official;                     //联系人
	private String address;                      //办公地址
	private String zipCode;                      //邮编
	private String mobilePhone;                  //移动电话
	private String tel;                          //联系电话
	private String email;                        //Email
	private int status;                          //状态
	private String remark;
	public TeachingUnitInfoVO(){
		
	}
	
	public TeachingUnitInfoVO(String id, String teachingUnitNum,
			String teachingUnitName, String coagency, String official,
			String address, String zipCode, String mobilePhone, String tel,
			String email, int status, String remark) {
		super();
		this.id = id;
		this.teachingUnitNum = teachingUnitNum;
		this.teachingUnitName = teachingUnitName;
		this.coagency = coagency;
		this.official = official;
		this.address = address;
		this.zipCode = zipCode;
		this.mobilePhone = mobilePhone;
		this.tel = tel;
		this.email = email;
		this.status = status;
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeachingUnitNum() {
		return teachingUnitNum;
	}
	public void setTeachingUnitNum(String teachingUnitNum) {
		this.teachingUnitNum = teachingUnitNum;
	}
	public String getTeachingUnitName() {
		return teachingUnitName;
	}
	public void setTeachingUnitName(String teachingUnitName) {
		this.teachingUnitName = teachingUnitName;
	}
	public String getCoagency() {
		return coagency;
	}
	public void setCoagency(String coagency) {
		this.coagency = coagency;
	}
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}   
	
}
