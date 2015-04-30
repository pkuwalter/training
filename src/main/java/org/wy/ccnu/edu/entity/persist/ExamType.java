package org.wy.ccnu.edu.entity.persist;

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
@Table(name = "examType")
@XmlRootElement
public class ExamType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;                   //标识ID
	     
	private String examTypeCode;         //考试方式编码
	
	private String examTypeName;         //考试方式名称
	
	public ExamType(){
		
	}
   @Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(length=2)
	public String getExamTypeCode() {
		return examTypeCode;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}
	@Column(length=20)
	public String getExamTypeName() {
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}	
}
