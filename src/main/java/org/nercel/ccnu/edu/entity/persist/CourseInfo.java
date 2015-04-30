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
 * 课程基本信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "courseInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CourseInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;					//标识ID，自增
	
	private String courseCode;		//课程内部代码
	
	private String courseCodeOut;	//课程外部代码
	
	private String courseName;		//课程内部名称
	
	private String courseNameOut;	//课程外部名称
	
	private int credit;		//学分
	
	private int learningTime;	//总学时
	
	private String examTypeCode;	//考试方式，存code
	
	private String courseClassCode;	//课程课类，存code
	
	private String courseTypeCode;	//课程类别，存code
	
	public CourseInfo(){
		super();
	}
	
	

	/**
	 * 所有参数
	 * @param id
	 * @param courseCode
	 * @param courseCodeOut
	 * @param courseName
	 * @param courseNameOut
	 * @param credit
	 * @param learningTime
	 * @param examTypeCode
	 * @param courseClassCode
	 * @param courseTypeCode
	 */
	public CourseInfo(int id, String courseCode, String courseCodeOut,
			String courseName, String courseNameOut, int credit,
			int learningTime, String examTypeCode, String courseClassCode,
			String courseTypeCode) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.courseCodeOut = courseCodeOut;
		this.courseName = courseName;
		this.courseNameOut = courseNameOut;
		this.credit = credit;
		this.learningTime = learningTime;
		this.examTypeCode = examTypeCode;
		this.courseClassCode = courseClassCode;
		this.courseTypeCode = courseTypeCode;
	}



	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="courseCode",length=15)
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Column(name="courseCodeOut",length=20)
	public String getCourseCodeOut() {
		return courseCodeOut;
	}

	public void setCourseCodeOut(String courseCodeOut) {
		this.courseCodeOut = courseCodeOut;
	}

	@Column(name="courseName",length=50)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name="courseNameOut",length=50)
	public String getCourseNameOut() {
		return courseNameOut;
	}

	public void setCourseNameOut(String courseNameOut) {
		this.courseNameOut = courseNameOut;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getLearningTime() {
		return learningTime;
	}

	public void setLearningTime(int learningTime) {
		this.learningTime = learningTime;
	}

	@Column(name="examTypeCode",length=10)
	public String getExamTypeCode() {
		return examTypeCode;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}

	@Column(name="courseClassCode",length=10)
	public String getCourseClassCode() {
		return courseClassCode;
	}

	public void setCourseClassCode(String courseClassCode) {
		this.courseClassCode = courseClassCode;
	}

	@Column(name="courseTypeCode",length=10)
	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

}
