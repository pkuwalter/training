package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class TrainingPlanVO{

	private String id;
	private String trainingProName;
	private String trainingProCode;
	private String trainingPlanName;
	private String trainingPlanCode;
	private String trainingTypeName;
	private String specialName;
	private String version;
	private String addTime;
	private String remark;
	
	public TrainingPlanVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainingPlanVO(String id, String trainingProName, String trainingProCode,
			String trainingPlanName, String trainingPlanCode,String trainingTypeName,
			String specialName, String version, String addTime, String remark) {
		super();
		this.id = id;
		this.trainingProName = trainingProName;
		this.trainingProCode = trainingProCode;
		this.trainingPlanName = trainingPlanName;
		this.trainingPlanCode = trainingPlanCode;
		this.trainingTypeName = trainingTypeName;
		this.specialName = specialName;
		this.version = version;
		this.addTime = addTime;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrainingProName() {
		return trainingProName;
	}

	public void setTrainingProName(String trainingProName) {
		this.trainingProName = trainingProName;
	}

	public String getTrainingProCode() {
		return trainingProCode;
	}

	public void setTrainingProCode(String trainingProCode) {
		this.trainingProCode = trainingProCode;
	}

	public String getTrainingPlanName() {
		return trainingPlanName;
	}

	public void setTrainingPlanName(String trainingPlanName) {
		this.trainingPlanName = trainingPlanName;
	}

	public String getTrainingPlanCode() {
		return trainingPlanCode;
	}

	public void setTrainingPlanCode(String trainingPlanCode) {
		this.trainingPlanCode = trainingPlanCode;
	}

	public String getTrainingTypeName() {
		return trainingTypeName;
	}

	public void setTrainingTypeName(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
