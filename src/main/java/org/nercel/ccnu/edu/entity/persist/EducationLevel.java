package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "educationLevel")
@XmlRootElement
public class EducationLevel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;                   //标识ID
	
	private int type;                    //类型：1-学历；2-非学历

	private String code;                 //层次编码
	
	private String educationLevelName;   //层次名称
	
	public EducationLevel(){
		
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	@Column(length=20)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(length=20)
	public String getEducationLevelName() {
		return educationLevelName;
	}

	public void setEducationLevelName(String educationLevelName) {
		this.educationLevelName = educationLevelName;
	}
	
}
