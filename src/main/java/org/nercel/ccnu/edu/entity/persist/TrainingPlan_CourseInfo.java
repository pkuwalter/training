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
@Table( name = "trainingplan_courseinfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingPlan_CourseInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private int courseId;/*课程Id*/
	private String trainingPlanId;/*培训计划，存id*/
	private String stage;/*学习阶段（学期）*/
	private int credit;/*学分*/
	private int learningTime;/*总学时*/
	private String examTypeCode;/*考试方式，存code*/
	private String courseClassCode;/*课程课类，存code*/
	private String scales;/*适用对象*/
	private String courseTypeCode;/*课程类别，存code*/
	private int isExemptCourse;/*是否为免考课1 -是，0-否*/
	private int isXKYTH;/*是否支持选开一体化，1 -是，0-否*/
	private int isInTotalCredit;/*是否纳入课程总学分,1 -是，0-否*/
	private int isInAvgScore;/*是否纳入平均分, 1 -是，0-否*/
	private int isDegreeCourse;/*是否为学位课程，1 -是，0-否*/
	private String remark;/*说明*/
	private String studentId;/*学生id*/
	
	public TrainingPlan_CourseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@Column(length=40)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(length=40)
	public String getTrainingPlanId() {
		return trainingPlanId;
	}

	public void setTrainingPlanId(String trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}

	@Column(length=4)
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

	@Column(length=10)
	public String getExamTypeCode() {
		return examTypeCode;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}

	@Column(length=10)
	public String getCourseClassCode() {
		return courseClassCode;
	}

	public void setCourseClassCode(String courseClassCode) {
		this.courseClassCode = courseClassCode;
	}

	@Column(length=3000)
	public String getScales() {
		return scales;
	}

	public void setScales(String scales) {
		this.scales = scales;
	}

	@Column(length=10)
	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	public int getIsExemptCourse() {
		return isExemptCourse;
	}

	public void setIsExemptCourse(int isExemptCourse) {
		this.isExemptCourse = isExemptCourse;
	}

	public int getIsXKYTH() {
		return isXKYTH;
	}

	public void setIsXKYTH(int isXKYTH) {
		this.isXKYTH = isXKYTH;
	}

	public int getIsInTotalCredit() {
		return isInTotalCredit;
	}

	public void setIsInTotalCredit(int isInTotalCredit) {
		this.isInTotalCredit = isInTotalCredit;
	}

	public int getIsInAvgScore() {
		return isInAvgScore;
	}

	public void setIsInAvgScore(int isInAvgScore) {
		this.isInAvgScore = isInAvgScore;
	}

	public int getIsDegreeCourse() {
		return isDegreeCourse;
	}

	public void setIsDegreeCourse(int isDegreeCourse) {
		this.isDegreeCourse = isDegreeCourse;
	}

	@Column(length=500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(length=40)
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
