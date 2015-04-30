package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table( name = "WorkUnit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class WorkUnit  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;				//	主键	标识ID，自增
    private String province;	//		省份code
    private String city;		//	市code
    private String country;		// 	县区code
    private String workUnitName;	//	工作单位名称
    private String workUnitCode;	//	工作单位code
    private String location;		//	工作单位所在地名称
    
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=10)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(length=10)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=10)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(length=40)
	public String getWorkUnitName() {
		return workUnitName;
	}
	public void setWorkUnitName(String workUnitName) {
		this.workUnitName = workUnitName;
	}
	@Column(length=15)
	public String getWorkUnitCode() {
		return workUnitCode;
	}
	public void setWorkUnitCode(String workUnitCode) {
		this.workUnitCode = workUnitCode;
	}
	@Column(length=40)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
