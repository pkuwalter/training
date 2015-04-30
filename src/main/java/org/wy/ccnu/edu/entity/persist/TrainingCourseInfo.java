package org.wy.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 培训课程信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "trainingCourseInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingCourseInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;			//标识ID，自增
	
	private int courseId;	//课程Id
	
	private String stage;	//学习阶段（开课学期）
	
	private int credit;		//学分
	
	private int learningTime;	//总学时
	
	private String examTypeCode;	//考试方式，存code
	
	private String courseClassCode;	//课程课类，存code
	
	private String scales;			//适用对象
	
	private String courseTypeCode;	//课程类别，存code
	
	private String trainingTypeCode;	//培训类别，存code
	
	private String specialId;			//培训学科,存id
	
	private String remark;			//说明
	
	public TrainingCourseInfo(){
		super();
	}

	@Id
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

	@Column(name="stage",length=4)
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

	@Column(name="scales",length=3000)
	public String getScales() {
		return scales;
	}

	public void setScales(String scales) {
		this.scales = scales;
	}

	@Column(name="courseTypeCode",length=10)
	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	@Column(name="trainingTypeCode",length=10)
	public String getTrainingTypeCode() {
		return trainingTypeCode;
	}

	public void setTrainingTypeCode(String trainingTypeCode) {
		this.trainingTypeCode = trainingTypeCode;
	}

	@Column(name="specialId",length=40)
	public String getSpecialId() {
		return specialId;
	}

	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	@Column(name="remark",length=500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
