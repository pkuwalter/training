package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentSourceInfoVO {
	private String id;                           //教学点标识ID
	private String studentSourceNum;         //教学点编号
	private String studentSourceName;        //教学点名称
	private String studentAgencyName;              //所属合作机构
	private String official;                     //联系人
	private String address;                      //办公地址
	private String tel;                          //联系电话
	private String email;                        //Email
	private int status;
	
	public StudentSourceInfoVO(){
		
	}
	public StudentSourceInfoVO(String id, String studentSourceNum,
			String studentSourceName, String studentAgencyName,
			String official, String address, String tel, String email,
			int status) {
		super();
		this.id = id;
		this.studentSourceNum = studentSourceNum;
		this.studentSourceName = studentSourceName;
		this.studentAgencyName = studentAgencyName;
		this.official = official;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentSourceNum() {
		return studentSourceNum;
	}
	public void setStudentSourceNum(String studentSourceNum) {
		this.studentSourceNum = studentSourceNum;
	}
	public String getStudentSourceName() {
		return studentSourceName;
	}
	public void setStudentSourceName(String studentSourceName) {
		this.studentSourceName = studentSourceName;
	}
	public String getStudentAgencyName() {
		return studentAgencyName;
	}
	public void setStudentAgencyName(String studentAgencyName) {
		this.studentAgencyName = studentAgencyName;
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
	

}
