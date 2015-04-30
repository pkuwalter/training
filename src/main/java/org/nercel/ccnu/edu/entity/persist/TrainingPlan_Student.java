package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "trainingplan_student")
@XmlRootElement
public class TrainingPlan_Student implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String coagencyId;
    private String teachingUnitId;
    private int trainingBatchId;
    private String educationLevelId;
    private String  specialId;
    private String studentId;
    private String trainingPlanId;
    private String  trainingPlanTemplateId;
    private String  addTime;
    private String loginName;
    private int  belongProject;
    
    
    
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
	@Column(length=40) 
	public String getCoagencyId() {
		return coagencyId;
	}
	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}
	@Column(length=40) 
	public String getTeachingUnitId() {
		return teachingUnitId;
	}
	public void setTeachingUnitId(String teachingUnitId) {
		this.teachingUnitId = teachingUnitId;
	}
	public int getTrainingBatchId() {
		return trainingBatchId;
	}
	public void setTrainingBatchId(int trainingBatchId) {
		this.trainingBatchId = trainingBatchId;
	}
	@Column(length=40) 
	public String getEducationLevelId() {
		return educationLevelId;
	}
	public void setEducationLevelId(String educationLevelId) {
		this.educationLevelId = educationLevelId;
	}
	@Column(length=40) 
	public String getSpecialId() {
		return specialId;
	}
	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}
	@Column(length=40) 
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	@Column(length=40) 
	public String getTrainingPlanId() {
		return trainingPlanId;
	}
	public void setTrainingPlanId(String trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}
	@Column(length=40) 
	public String getTrainingPlanTemplateId() {
		return trainingPlanTemplateId;
	}
	public void setTrainingPlanTemplateId(String trainingPlanTemplateId) {
		this.trainingPlanTemplateId = trainingPlanTemplateId;
	}
	@Column(length=40) 
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	@Column(length=40) 
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getBelongProject() {
		return belongProject;
	}
	public void setBelongProject(int belongProject) {
		this.belongProject = belongProject;
	}

	
	
	
	
}
