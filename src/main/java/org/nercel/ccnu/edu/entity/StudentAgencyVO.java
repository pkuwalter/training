package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentAgencyVO {
	private String id;                            //学员单位标识ID
	private String studentAgencyNum;                //学员单位编号
	private String studentAgencyName;               //学员单位名称
	private String manageCenterName;              //所属管理中心名称
	private String official;                      //负责人
	private String address;                       //详细地址
	private String mobilePhone;                   //移动电话
	private String email;                         //Email
	private String jwNum;                         //教委学员单位编号
	private String jwName;                        //教委学员单位名称
	private int status;    							//状态，：1-启用；0-停用。主要用于逻辑删除
	private String provinceName;				  //生源地,省市名，精确到地级市/区
	
	
	public StudentAgencyVO(){
		
	}
	public StudentAgencyVO(String id, String studentAgencyNum,
			String studentAgencyName, String manageCenterName, String official,
			String address, String mobilePhone, String email, String jwNum,
			String jwName, int status, String provinceName) {
		super();
		this.id = id;
		this.studentAgencyNum = studentAgencyNum;
		this.studentAgencyName = studentAgencyName;
		this.manageCenterName = manageCenterName;
		this.official = official;
		this.address = address;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.jwNum = jwNum;
		this.jwName = jwName;
		this.status = status;
		this.provinceName = provinceName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentAgencyNum() {
		return studentAgencyNum;
	}
	public void setStudentAgencyNum(String studentAgencyNum) {
		this.studentAgencyNum = studentAgencyNum;
	}
	public String getStudentAgencyName() {
		return studentAgencyName;
	}
	public void setStudentAgencyName(String studentAgencyName) {
		this.studentAgencyName = studentAgencyName;
	}
	public String getManageCenterName() {
		return manageCenterName;
	}
	public void setManageCenterName(String manageCenterName) {
		this.manageCenterName = manageCenterName;
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
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJwNum() {
		return jwNum;
	}
	public void setJwNum(String jwNum) {
		this.jwNum = jwNum;
	}
	public String getJwName() {
		return jwName;
	}
	public void setJwName(String jwName) {
		this.jwName = jwName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setCity(String provinceName) {
		this.provinceName = provinceName;
	}
	

}
