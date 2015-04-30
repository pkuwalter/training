package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeachingUnitInfoOfficialVO {
	private String id;                           //教学点人员标识ID
	private String officialNum;         //教学点人员编号
	private String realName;                     //姓名
	private String loginName;                    //用户名
	private String teachingUnitName;            //所属教学点
	private String tel;                          //联系电话
	private String email;                           //Email
	private int status;                          //状态
	
	public TeachingUnitInfoOfficialVO(){}

	public TeachingUnitInfoOfficialVO(String id, String officialNum,
			String realName, String loginName, String teachingUnitName,
			String tel, String email, int status) {
		this.id = id;
		this.officialNum = officialNum;
		this.realName = realName;
		this.loginName = loginName;
		this.teachingUnitName = teachingUnitName;
		this.tel = tel;
		this.email = email;
		this.status = status;
	}

	/**
	 * @return the teachingUnitName
	 */
	public String getTeachingUnitName() {
		return teachingUnitName;
	}

	/**
	 * @param teachingUnitName the teachingUnitName to set
	 */
	public void setTeachingUnitName(String teachingUnitName) {
		this.teachingUnitName = teachingUnitName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
