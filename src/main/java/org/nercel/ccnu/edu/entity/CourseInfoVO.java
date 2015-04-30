package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CourseInfoVO {

	private int id;				//标识
	
	private int specialCourseId;	//学科课程id
	
	private int courseId;			//课程id
	
	private String courseTypeName;	//课程类别名称
	
	private String courseCode;		//课程内部代码
	
	private String courseCodeOut;	//课程外部代码
	
	private String courseName;		//课程内部名称
	
	private String courseNameOut;	//课程外部名称
	
	private String stage;			//学习阶段（开课学期）
	
	private int credit;				//学分
	
	private int learningTime;		//总学时
	
	private String examTypeName;	//考试方式名称
	
	private String courseClassName;	//课程课类名称
	
	private String scales;			//适用对象
	
	private String remark;			//说明

	public CourseInfoVO(){
		super();
	}
	
	/**
	 * 所有参数的构造函数（没有specialCourseId）
	 * @param id
	 * @param courseId
	 * @param courseTypeName
	 * @param courseCode
	 * @param courseCodeOut
	 * @param courseName
	 * @param courseNameOut
	 * @param stage
	 * @param credit
	 * @param learningTime
	 * @param examTypeName
	 * @param courseClassName
	 * @param scales
	 * @param remark
	 */
	public CourseInfoVO(int id, int courseId, String courseTypeName,
			String courseCode, String courseCodeOut, String courseName,
			String courseNameOut, String stage, int credit, int learningTime,
			String examTypeName, String courseClassName, String scales,
			String remark) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseTypeName = courseTypeName;
		this.courseCode = courseCode;
		this.courseCodeOut = courseCodeOut;
		this.courseName = courseName;
		this.courseNameOut = courseNameOut;
		this.stage = stage;
		this.credit = credit;
		this.learningTime = learningTime;
		this.examTypeName = examTypeName;
		this.courseClassName = courseClassName;
		this.scales = scales;
		this.remark = remark;
	}

	/**
	 * 没有标识id的构造函数
	 * @param courseId
	 * @param courseTypeName
	 * @param courseCode
	 * @param courseCodeOut
	 * @param courseName
	 * @param courseNameOut
	 * @param stage
	 * @param credit
	 * @param learningTime
	 * @param examTypeName
	 * @param courseClassName
	 * @param scales
	 * @param remark
	 */
	public CourseInfoVO(String courseTypeName,int courseId,  String courseCode,
			String courseCodeOut, String courseName, String courseNameOut,
			String stage, int credit, int learningTime, String examTypeName,
			String courseClassName, String scales, String remark) {
		super();
		this.courseId = courseId;
		this.courseTypeName = courseTypeName;
		this.courseCode = courseCode;
		this.courseCodeOut = courseCodeOut;
		this.courseName = courseName;
		this.courseNameOut = courseNameOut;
		this.stage = stage;
		this.credit = credit;
		this.learningTime = learningTime;
		this.examTypeName = examTypeName;
		this.courseClassName = courseClassName;
		this.scales = scales;
		this.remark = remark;
	}

	/**
	 * 没有标识id,stage,scales,remark的构造函数
	 * @param courseId
	 * @param courseTypeName
	 * @param courseCode
	 * @param courseCodeOut
	 * @param courseName
	 * @param courseNameOut
	 * @param credit
	 * @param learningTime
	 * @param examTypeName
	 * @param courseClassName
	 */
	public CourseInfoVO(String courseTypeName,int courseId, String courseCode,
			String courseCodeOut, String courseName, String courseNameOut,
			int credit, int learningTime, String examTypeName,
			String courseClassName) {
		super();
		this.courseId = courseId;
		this.courseTypeName = courseTypeName;
		this.courseCode = courseCode;
		this.courseCodeOut = courseCodeOut;
		this.courseName = courseName;
		this.courseNameOut = courseNameOut;
		this.credit = credit;
		this.learningTime = learningTime;
		this.examTypeName = examTypeName;
		this.courseClassName = courseClassName;
	}
	
	
	/**
	 * 没有标识id,courseCodeOut,courseNameOut,stage,scales,的构造函数
	 * @param specialCourseId
	 * @param courseId
	 * @param courseTypeName
	 * @param courseCode
	 * @param courseName
	 * @param credit
	 * @param learningTime
	 * @param examTypeName
	 * @param courseClassName
	 * @param remark
	 */
	public CourseInfoVO(int specialCourseId,int courseId, String courseCode,
			String courseName,String courseTypeName, int credit, int learningTime,
			String examTypeName, String courseClassName, String remark) {
		super();
		this.specialCourseId = specialCourseId;
		this.courseId = courseId;
		this.courseTypeName = courseTypeName;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credit = credit;
		this.learningTime = learningTime;
		this.examTypeName = examTypeName;
		this.courseClassName = courseClassName;
		this.remark = remark;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getSpecialCourseId() {
		return specialCourseId;
	}

	public void setSpecialCourseId(int specialCourseId) {
		this.specialCourseId = specialCourseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseCodeOut() {
		return courseCodeOut;
	}

	public void setCourseCodeOut(String courseCodeOut) {
		this.courseCodeOut = courseCodeOut;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNameOut() {
		return courseNameOut;
	}

	public void setCourseNameOut(String courseNameOut) {
		this.courseNameOut = courseNameOut;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
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

	public String getExamTypeName() {
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}

	public String getCourseClassName() {
		return courseClassName;
	}

	public void setCourseClassName(String courseClassName) {
		this.courseClassName = courseClassName;
	}

	public String getScales() {
		return scales;
	}

	public void setScales(String scales) {
		this.scales = scales;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}


