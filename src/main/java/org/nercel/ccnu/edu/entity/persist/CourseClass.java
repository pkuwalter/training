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
@Table( name = "courseClass")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CourseClass implements Serializable{//课程课类管理
	
	private static final long serialVersionUID = 1L;
	
	
	 
	private int id;//标识Id
	
	
	private String courseClassName;//课程课类名称
	
	
	private String courseClassCode;//课程课类代码
	
	
	public CourseClass() {
		super();
	}


	@Id
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name="courseClassName",length=20)
	public String getCourseClassName() {
		return courseClassName;
	}


	public void setCourseClassName(String courseClassName) {
		this.courseClassName = courseClassName;
	}

	@Column(name="courseClassCode",length=2)
	public String getCourseClassCode() {
		return courseClassCode;
	}


	public void setCourseClassCode(String courseClassCode) {
		this.courseClassCode = courseClassCode;
	}

	
	

}
