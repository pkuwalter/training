package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentSourceOfficialVO {  //渠道人员信息
	
	private String id;                           //渠道人员标识ID
	private String officialNum;                  //渠道人员编号
	private String realName;                     //姓名
	private String loginName;                    //用户名
	private String studentAgencyName;                       //所属渠道
	private String tel;                          //联系电话
	private String email;                           //Email
	private int status;                          //状态
	
	public StudentSourceOfficialVO(){}

	public StudentSourceOfficialVO(String id, String officialNum,
			String realName, String loginName, String studentAgencyName,
			String tel, String email, int status) {
		this.id = id;
//		this.registrationPointNum = registrationPointNum;
		this.officialNum = officialNum;
		this.realName = realName;
		this.loginName = loginName;
//		this.registrationPointName = registrationPointName;
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


	/**
	 * @return the officialNum
	 */
	public String getOfficialNum() {
		return officialNum;
	}

	/**
	 * @param officialNum the officialNum to set
	 */
	public void setOfficialNum(String officialNum) {
		this.officialNum = officialNum;
	}


	/**
	 * @return the studentAgencyName
	 */
	public String getStudentAgencyName() {
		return studentAgencyName;
	}

	/**
	 * @param studentAgencyName the studentAgencyName to set
	 */
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
