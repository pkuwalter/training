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
@Table( name = "trainingPlan")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingPlan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String trainingPlanName; /*培训计划名称*/
	private String trainingPlanCode;/*培训计划代码*/
	private int trainingProjectId;/*培训项目，存id*/
	private int trainingType;/*培训类型，存id*/
	private String eudcationLevel;/*培训层次，存id*/
	private String special;/*培训学科（专业），存id*/
	private String version;/*版本信息*/
	private String addTime;/*制定日期*/
	private String scales;/*适用对象*/
	private int totalCredit;/*总学分*/
	private Double schoolSystem;/*学制*/
	private Double studyYear;/*修业年限*/
	private String degree;/*授予学位*/
	private String coagency;/*适用的合作机构*/
	private String teachingUnit;/*适用的合作机构下的教学点*/
	private String description;/*详细说明*/
	private String remark;/*备注说明*/
	
	
	public TrainingPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(length=40)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(length=60)
	public String getTrainingPlanName() {
		return trainingPlanName;
	}
	
	public void setTrainingPlanName(String trainingPlanName) {
		this.trainingPlanName = trainingPlanName;
	}
	
	@Column(length=8)
	public String getTrainingPlanCode() {
		return trainingPlanCode;
	}
	
	public void setTrainingPlanCode(String trainingPlanCode) {
		this.trainingPlanCode = trainingPlanCode;
	}
	
	public int getTrainingProjectId() {
		return trainingProjectId;
	}
	
	public void setTrainingProjectId(int trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}
	
	public int getTrainingType() {
		return trainingType;
	}
	
	public void setTrainingType(int trainingType) {
		this.trainingType = trainingType;
	}
	
	@Column(length=40)
	public String getEudcationLevel() {
		return eudcationLevel;
	}
	
	public void setEudcationLevel(String eudcationLevel) {
		this.eudcationLevel = eudcationLevel;
	}
	
	@Column(length=40)
	public String getSpecial() {
		return special;
	}
	
	public void setSpecial(String special) {
		this.special = special;
	}
	
	@Column(length=10)
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	@Column(length=10)
	public String getAddTime() {
		return addTime;
	}
	
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	@Column(length=3000)
	public String getScales() {
		return scales;
	}
	
	public void setScales(String scales) {
		this.scales = scales;
	}
	
	public int getTotalCredit() {
		return totalCredit;
	}
	
	public void setTotalCredit(int totalCredit) {
		this.totalCredit = totalCredit;
	}
	
	public Double getSchoolSystem() {
		return schoolSystem;
	}
	
	public void setSchoolSystem(Double schoolSystem) {
		this.schoolSystem = schoolSystem;
	}
	
	public Double getStudyYear() {
		return studyYear;
	}
	
	public void setStudyYear(Double studyYear) {
		this.studyYear = studyYear;
	}
	
	@Column(length=40)
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	@Column(length=3000)
	public String getCoagency() {
		return coagency;
	}
	
	public void setCoagency(String coagency) {
		this.coagency = coagency;
	}
	
	@Column(length=3000)
	public String getTeachingUnit() {
		return teachingUnit;
	}
	
	public void setTeachingUnit(String teachingUnit) {
		this.teachingUnit = teachingUnit;
	}
	
	@Column(length=3000)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(length=500)
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
