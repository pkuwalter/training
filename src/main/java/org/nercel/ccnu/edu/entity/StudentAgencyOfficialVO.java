package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentAgencyOfficialVO {
	
	private String id;                 //学员单位人员标识ID
	
	private String officialNum;        //学员单位人员编号
	
	private String realName;           //姓名
	
	private String loginName;          //用户名
	
	private String studentAgencyName;        //所属学员单位
	
	private String tel;                //联系电话
	
	private String email;              //Email
	
	private int status;                //状态̬
	
	public StudentAgencyOfficialVO(){
		super();
	}
	
	public StudentAgencyOfficialVO(String id,String officialNum,String realName,String loginName,String studentAgencyName,String tel,String email,int status){
		this.id = id;
		this.officialNum = officialNum;
		this.realName = realName;
		this.loginName = loginName;
		this.studentAgencyName = studentAgencyName;
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

	public String getOfficialNum() {
		return officialNum;
	}

	public void setOfficialNum(String officialNum) {
		this.officialNum = officialNum;
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

	public String getStudentAgencyName() {
		return studentAgencyName;
	}

	public void setStudentAgencyName(String studentAgencyName) {
		this.studentAgencyName = studentAgencyName;
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
