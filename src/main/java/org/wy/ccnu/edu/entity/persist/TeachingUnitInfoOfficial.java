package org.wy.ccnu.edu.entity.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "teachingUnitOfficial")
@XmlRootElement
public class TeachingUnitInfoOfficial {

	 private static final long serialVersionUID = 1L;
		
		private String id;                           //教学点人员标识ID
		private String officialNum;               //教学点人员编号
		private String realName;                     //姓名
		private String loginName;                    //用户名
		private String password;                     //密码
		private String rePassword;                   //验证密码
		private String agency;            //所属教学点
		private String mobilePhone;                  //移动电话
		private String tel;                          //联系电话
		private String email;                           //Email
		private int status;                          //状态̬
		private String remark;                       //备注
		
		public TeachingUnitInfoOfficial(){
			
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


		@Column(length=40)
		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}

		@Column(length=40)
		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		@Column(length=30)
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(length=30)
		public String getRePassword() {
			return rePassword;
		}

		public void setRePassword(String rePassword) {
			this.rePassword = rePassword;
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
		 * @return the agency
		 */
		public String getAgency() {
			return agency;
		}
		/**
		 * @param agency the agency to set
		 */
		public void setAgency(String agency) {
			this.agency = agency;
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
