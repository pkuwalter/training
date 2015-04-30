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
@Table( name = "ProvinceInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ProvinceInfo implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private int id;
	 
	private String provinceName;//省份名称
	
	private String code;		//省份(包含直辖市)编码
 
	 	
	public ProvinceInfo(){
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
	public String getProvinceName() {
		return provinceName;
	}
	
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	@Column(length=2)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	
	

	 
	
}
