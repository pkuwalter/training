package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpecialCourseVO {

	private int id;				//标识
	
	private int courseId;		//课程id
	
	private String courseName;	//课程内部名称
	
	public SpecialCourseVO(){
		super();
	}

	
/**
 * 所有参数的构造函数
 * @param id
 * @param courseId
 * @param courseName
 */
	public SpecialCourseVO(int id, int courseId, String courseName) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
	}


	/**
	 * 构造函数
	 * @param courseId  课程id
	 * @param courseName 课程名称
	 */
	public SpecialCourseVO(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


}


