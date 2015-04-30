package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 学科课程信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "specialCourse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SpecialCourse implements Serializable{
	
	private static final long serialVersionUID = 1L;	

	private int id;			//标识ID，自增
	
	private String specialId;	//学科id
	
	private int courseId;	//课程id，关联CourseInfo
	
	private String remark;	//说明
	
	public SpecialCourse(){
		super();
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="specialId",length=40)
	public String getSpecialId() {
		return specialId;
	}

	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(name="remark",length=200)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
