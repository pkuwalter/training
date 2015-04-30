package org.nercel.ccnu.edu.entity.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "teachingUnitInfo")
@XmlRootElement
public class TeachingUnitInfo {

	 private static final long serialVersionUID = 1L;
		
		private String id;                           //教学点标识ID
		private String teachingUnitNum;         //教学点编号
		private String teachingUnitName;        //教学点名称
		private String coagencyId;                  //所属机构
		private String official;                     //联系人
		private String address;                      //办公地址
		private String zipCode;                      //邮编
		private String mobilePhone;                  //移动电话
		private String tel;                          //联系电话
		private String email;                        //Email
		private int status;                          //状态
		private String remark;  					//备注
		
		public TeachingUnitInfo(){
			
		}
		public TeachingUnitInfo(String id, String teachingUnitNum,
				String teachingUnitName, String coagencyId, String official,
				String address, String zipCode, String mobilePhone, String tel,
				String email, int status, String remark) {
			super();
			this.id = id;
			this.teachingUnitNum = teachingUnitNum;
			this.teachingUnitName = teachingUnitName;
			this.coagencyId = coagencyId;
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
		public String getTeachingUnitNum() {
			return teachingUnitNum;
		}
		public void setTeachingUnitNum(String teachingUnitNum) {
			this.teachingUnitNum = teachingUnitNum;
		}
		@Column(length=40)
		public String getTeachingUnitName() {
			return teachingUnitName;
		}
		public void setTeachingUnitName(String teachingUnitName) {
			this.teachingUnitName = teachingUnitName;
		}
		@Column(length=40)
		public String getCoagencyId() {
			return coagencyId;
		}
		public void setCoagencyId(String coagencyId) {
			this.coagencyId = coagencyId;
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
