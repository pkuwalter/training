package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class TrainingPlan_StudentVO {
	
    private String id;
    private String coagencyName;
    private String teachingUnitName;
    private String trainingBatchName;
    private String educationLevelName;
    private String  specialName;
    private String studentId;		//以备不时之需
    private String studentName;
   
	private String studentNum;
    private String trainingPlanId;
    private String trainingPlanName;
    private String trainingPlanTemplateId;
    private String  trainingPlanTemplateName;
    private String  addTime;
    private String loginName;
    private String  belongProject;
    
	public TrainingPlan_StudentVO(String id, String coagencyName,
			String teachingUnitName, String trainingBatchName,
			String educationLevelName, String specialName, String studentId,
			String studentName, String studentNum, String trainingPlanId, 
			String trainingPlanName, String trainingPlanTemplateId,
			String trainingPlanTemplateName, String addTime, String loginName,
			String belongProject) {
		super();
		this.id = id;
		this.coagencyName = coagencyName;
		this.teachingUnitName = teachingUnitName;
		this.trainingBatchName = trainingBatchName;
		this.educationLevelName = educationLevelName;
		this.specialName = specialName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentNum = studentNum;
		this.trainingPlanId = trainingPlanId;
		this.trainingPlanName = trainingPlanName;
		this.trainingPlanTemplateId = trainingPlanTemplateId;
		this.trainingPlanTemplateName = trainingPlanTemplateName;
		this.addTime = addTime;
		this.loginName = loginName;
		this.belongProject = belongProject;
	}
	 public String getTrainingPlanId() {
		return trainingPlanId;
	}
	public void setTrainingPlanId(String trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}
	public String getTrainingPlanTemplateId() {
		return trainingPlanTemplateId;
	}
	public void setTrainingPlanTemplateId(String trainingPlanTemplateId) {
		this.trainingPlanTemplateId = trainingPlanTemplateId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCoagencyName() {
		return coagencyName;
	}
	public void setCoagencyName(String coagencyName) {
		this.coagencyName = coagencyName;
	}
	public String getTeachingUnitName() {
		return teachingUnitName;
	}
	public void setTeachingUnitName(String teachingUnitName) {
		this.teachingUnitName = teachingUnitName;
	}
	public String getTrainingBatchName() {
		return trainingBatchName;
	}
	public void setTrainingBatchName(String trainingBatchName) {
		this.trainingBatchName = trainingBatchName;
	}
	public String getEducationLevelName() {
		return educationLevelName;
	}
	public void setEducationLevelName(String educationLevelName) {
		this.educationLevelName = educationLevelName;
	}
	public String getSpecialName() {
		return specialName;
	}
	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getTrainingPlanName() {
		return trainingPlanName;
	}
	public void setTrainingPlanName(String trainingPlanName) {
		this.trainingPlanName = trainingPlanName;
	}
	public String getTrainingPlanTemplateName() {
		return trainingPlanTemplateName;
	}
	public void setTrainingPlanTemplateName(String trainingPlanTemplateName) {
		this.trainingPlanTemplateName = trainingPlanTemplateName;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getBelongProject() {
		return belongProject;
	}
	public void setBelongProject(String belongProject) {
		this.belongProject = belongProject;
	}
	
	
	
}
