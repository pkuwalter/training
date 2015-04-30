package org.wy.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table( name = "trainingplan_coursetypecredit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingPlan_CourseTypeCredit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String trainingPlanId;/*培训计划，存id*/
	private String courseTypeCode;/*课程类别，存code*/
	private int maxCredit;/* 能选修的最大学分*/
	private int minCredit;/*能选修的最小学分*/
	private String studentId;/*学生id*/
	
	public TrainingPlan_CourseTypeCredit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=40)
	public String getTrainingPlanId() {
		return trainingPlanId;
	}

	public void setTrainingPlanId(String trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}

	@Column(length=10)
	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	public int getMaxCredit() {
		return maxCredit;
	}

	public void setMaxCredit(int maxCredit) {
		this.maxCredit = maxCredit;
	}

	public int getMinCredit() {
		return minCredit;
	}

	public void setMinCredit(int minCredit) {
		this.minCredit = minCredit;
	}

	@Column(length=40)
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	
}
