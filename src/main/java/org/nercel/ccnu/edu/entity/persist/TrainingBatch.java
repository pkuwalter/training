package org.nercel.ccnu.edu.entity.persist; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/** 
 * @author Jo 
 * @version 创建时间：2014-5-22 下午3:05:02 
 * 培训批次基础信息 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingBatch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;//主键
	private int trainingProjectId;//培训项目ID
	private String trainingBatchName;//培训批次名称
	private String trainingBeginTime;//培训开始时间
	private String trainingEndTime;//培训截止时间
	private String planBeginTime;//培训计划开始时间
	private String planEndTime;//培训计划截止时间
	private int status;//状态，：1-启用；0-停用。主要用于逻辑删除
	
	public TrainingBatch(){
		
	}
	
	public TrainingBatch(int id, int trainingProjectId, String trainingBatchName, String trainingBeginTime,
			String trainingEndTime, String planBeginTime, String planEndTime, int status) {
		super();
		this.id = id;
		this.trainingProjectId = trainingProjectId;
		this.trainingBatchName = trainingBatchName;
		this.trainingBeginTime = trainingBeginTime;
		this.trainingEndTime = trainingEndTime;
		this.planBeginTime = planBeginTime;
		this.planEndTime = planEndTime;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=40,nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=40)
	public int getTrainingProjectId() {
		return trainingProjectId;
	}
	public void setTrainingProjectId(int trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}
	@Column(length=20)
	public String getTrainingBatchName() {
		return trainingBatchName;
	}
	public void setTrainingBatchName(String trainingBatchName) {
		this.trainingBatchName = trainingBatchName;
	}
	public String getTrainingBeginTime() {
		return trainingBeginTime;
	}
	public void setTrainingBeginTime(String trainingBeginTime) {
		this.trainingBeginTime = trainingBeginTime;
	}
	public String getTrainingEndTime() {
		return trainingEndTime;
	}
	public void setTrainingEndTime(String trainingEndTime) {
		this.trainingEndTime = trainingEndTime;
	}
	public String getPlanBeginTime() {
		return planBeginTime;
	}
	public void setPlanBeginTime(String planBeginTime) {
		this.planBeginTime = planBeginTime;
	}
	public String getPlanEndTime() {
		return planEndTime;
	}
	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
 