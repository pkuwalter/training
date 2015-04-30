package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "CityInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CityInfo implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private int id;
	 
	private String name;			//县市名称
	
	private int belongProvinceId;	//所属省份
	
	private int belongCityId;		//所属市,默认为-1，表示所属市为本身
	
	private String code;			//市县的编码，6位
 
	 	
	public CityInfo(){
		super();
	}

	@Id
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(length=30)
	public int getBelongProvinceId() {
		return belongProvinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBelongProvinceId(int belongProvinceId) {
		this.belongProvinceId = belongProvinceId;
	}

	public int getBelongCityId() {
		return belongCityId;
	}

	public void setBelongCityId(int belongCityId) {
		this.belongCityId = belongCityId;
	}

	@Column(length=10)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
