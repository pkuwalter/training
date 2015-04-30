package org.wy.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "special")
@XmlRootElement
public class Special implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;                    //标识ID
	
	private String specialNum;            //专业代码
	
	private String specialName;           //专业名称
	
	private String specialNum_jw;         //就读专业代码（上报教委）
	
	private String specialName_jw;        //就读专业名称(上报教委)
	
	private String educationLevel;        //学历层次
	
	public Special(){
		
	}
	@Id 
	@Column(length=40)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(length=20)
	public String getSpecialNum() {
		return specialNum;
	}

	public void setSpecialNum(String specialNum) {
		this.specialNum = specialNum;
	}
	
	@Column(length=40)
	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}
	
	@Column(length=20)
	public String getSpecialNum_jw() {
		return specialNum_jw;
	}

	public void setSpecialNum_jw(String specialNum_jw) {
		this.specialNum_jw = specialNum_jw;
	}
	
	@Column(length=40)
	public String getSpecialName_jw() {
		return specialName_jw;
	}

	public void setSpecialName_jw(String specialName_jw) {
		this.specialName_jw = specialName_jw;
	}

	@Column(length=40)
	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	
}
