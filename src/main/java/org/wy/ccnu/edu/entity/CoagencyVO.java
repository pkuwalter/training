package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoagencyVO {
	private String id;                            //学习中心标识ID
	private String coagencyNum;                //学习中心编号
	private String coagencyName;               //学习中心名称
	private String manageCenterName;              //所属管理中心名称
	private String official;                      //负责人
	private String address;                       //详细地址
	private String mobilePhone;                   //移动电话
	private String email;                         //Email
	private String jwNum;                         //教委学习中心编号
	private String jwName;                        //教委学习中心名称
	private int status;    						//0 未开启， 1 已开启
	private String provinceName;				  //生源地,省市名称，对应POJO中的city
	
	public CoagencyVO(){
		
	}
	public CoagencyVO(String id, String coagencyNum, String coagencyName,
			String manageCenterName, String official, String address,
			String mobilePhone, String email, String jwNum, String jwName,
			int status, String provinceName) {
		super();
		this.id = id;
		this.coagencyNum = coagencyNum;
		this.coagencyName = coagencyName;
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
	public String getCoagencyNum() {
		return coagencyNum;
	}
	public void setCoagencyNum(String coagencyNum) {
		this.coagencyNum = coagencyNum;
	}
	public String getCoagencyName() {
		return coagencyName;
	}
	public void setCoagencyName(String coagencyName) {
		this.coagencyName = coagencyName;
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
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	

}
