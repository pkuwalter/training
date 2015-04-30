package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class TrainingPlanCourseInfoVO{

	private String id;
	private String courseName;
	private String courseCode;
	private String stage;
	private int credit;
	private int learningTime;
	private String examTypeName;
	private String courseClassName;
	private String courseTypeName;
	private String scales;
	private String isExemptCourse;/*是否为免考课 是，否*/
	private String isXKYTH;/*是否支持选开一体化，是，否*/
	private String isInTotalCredit;/*是否纳入课程总学分,是，否*/
	private String isInAvgScore;/*是否纳入平均分, 是，否*/
	private String isDegreeCourse;/*是否为学位课程，是，否*/
	private String remark;
	private int courseId;
	
	public TrainingPlanCourseInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainingPlanCourseInfoVO(String id, String courseName,
			String courseCode, String stage, int credit, int learningTime,
			String examTypeName, String courseClassName,String courseTypeName, String scales,
			String isXKYTH, String isInTotalCredit, String isInAvgScore,
			String isDegreeCourse, String remark,int courseId) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.stage = stage;
		this.credit = credit;
		this.learningTime = learningTime;
		this.examTypeName = examTypeName;
		this.courseClassName = courseClassName;
		this.courseTypeName = courseTypeName;
		this.scales = scales;
		this.isXKYTH = isXKYTH;
		this.isInTotalCredit = isInTotalCredit;
		this.isInAvgScore = isInAvgScore;
		this.isDegreeCourse = isDegreeCourse;
		this.remark = remark;
		this.courseId = courseId;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
	
	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public String getScales() {
		return scales;
	}

	public void setScales(String scales) {
		this.scales = scales;
	}

	public String getIsExemptCourse() {
		return isExemptCourse;
	}

	public void setIsExemptCourse(String isExemptCourse) {
		this.isExemptCourse = isExemptCourse;
	}

	public String getIsXKYTH() {
		return isXKYTH;
	}

	public void setIsXKYTH(String isXKYTH) {
		this.isXKYTH = isXKYTH;
	}

	public String getIsInTotalCredit() {
		return isInTotalCredit;
	}

	public void setIsInTotalCredit(String isInTotalCredit) {
		this.isInTotalCredit = isInTotalCredit;
	}

	public String getIsInAvgScore() {
		return isInAvgScore;
	}

	public void setIsInAvgScore(String isInAvgScore) {
		this.isInAvgScore = isInAvgScore;
	}

	public String getIsDegreeCourse() {
		return isDegreeCourse;
	}

	public void setIsDegreeCourse(String isDegreeCourse) {
		this.isDegreeCourse = isDegreeCourse;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
}
