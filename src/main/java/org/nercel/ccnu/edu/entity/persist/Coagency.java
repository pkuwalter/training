package org.nercel.ccnu.edu.entity.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "coagency")
@XmlRootElement
public class Coagency {

	private static final long serialVersionUID = 1L;
	
	private String id;                            //合作机构标识ID
	private String coagencyNum;                //合作机构编号
	private String coagencyName;               //合作机构名称
	private String manageCenter;                  //所属管理中心
	private String official;                      //负责人
	private String address;                       //详细地址
	private String zipCode;                       //邮编
	private String mobilePhone;                   //移动电话
	private String tel;                           //联系电话
	private String email;                         //Email
	private String url;                           //合作机构网址
	private String jwNum;                         //教委合作机构编号
	private String jwName;                        //教委合作机构名称
	private int status;                          //状态，：1-启用；0-停用。主要用于逻辑删除
	private String city;						//所属生源地，工作所在地，精确到地级市，存名称
	private String cityCode;				 //所属生源地，存地级市/区的编码
	
	public Coagency(){
		
	}
	public Coagency(String id, String coagencyNum, String coagencyName,
			String manageCenter, String official, String address,
			String zipCode, String mobilePhone, String tel, String email,
			String url, String jwNum, String jwName, int status, String city,
			String cityCode) {
		super();
		this.id = id;
		this.coagencyNum = coagencyNum;
		this.coagencyName = coagencyName;
		this.manageCenter = manageCenter;
		this.official = official;
		this.address = address;
		this.zipCode = zipCode;
		this.mobilePhone = mobilePhone;
		this.tel = tel;
		this.email = email;
		this.url = url;
		this.jwNum = jwNum;
		this.jwName = jwName;
		this.status = status;
		this.city = city;
		this.cityCode = cityCode;
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
	public String getCoagencyNum() {
		return coagencyNum;
	}
	public void setCoagencyNum(String coagencyNum) {
		this.coagencyNum = coagencyNum;
	}
	@Column(length=40)
	public String getCoagencyName() {
		return coagencyName;
	}
	public void setCoagencyName(String coagencyName) {
		this.coagencyName = coagencyName;
	}
	@Column(length=40)
	public String getManageCenter() {
		return manageCenter;
	}
	public void setManageCenter(String manageCenter) {
		this.manageCenter = manageCenter;
	}
	@Column(length=20)
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}
	@Column(length=100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length=6)
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
	@Column(length=100)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(length=10)
	public String getJwNum() {
		return jwNum;
	}
	public void setJwNum(String jwNum) {
		this.jwNum = jwNum;
	}
	@Column(length=50)
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
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=10)
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	
}
