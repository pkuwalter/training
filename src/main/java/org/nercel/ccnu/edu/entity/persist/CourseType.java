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
@Table( name = "courseType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CourseType implements Serializable{//课程类别管理
	
	private static final long serialVersionUID = 1L;
	
	
	 
	private int id;//标识Id
	
	
	private String courseTypeName;//课程类别名称
	
	
	private String courseTypeCode;//课程类别代码
	
	
	public CourseType() {
		super();
	}


	@Id
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name="courseTypeName",length=20)
	public String getCourseTypeName() {
		return courseTypeName;
	}


	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	@Column(name="courseTypeCode",length=2)
	public String getCourseTypeCode() {
		return courseTypeCode;
	}


	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	
	

}
