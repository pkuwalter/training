package org.wy.ccnu.edu.entity.persist; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 上午10:02:29 
 * 培训批次合作机构关联表 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingBatch_coagency implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//主键
	private int trainingBatchId;//培训批次ID
	private String coagencyId;//合作机构ID
	private String enrollBeginTime;//教学点审核开始时间
	private String enrollEndTime;//教学点审核结束时间
	public TrainingBatch_coagency(){
		
	}
	
	public TrainingBatch_coagency(int id, int trainingBatchId, String coagencyId, String enrollBeginTime,
			String enrollEndTime) {
		super();
		this.id = id;
		this.trainingBatchId = trainingBatchId;
		this.coagencyId = coagencyId;
		this.enrollBeginTime = enrollBeginTime;
		this.enrollEndTime = enrollEndTime;
	}
	@Id
	@Column(name = "id", length = 40)
	@GenericGenerator(name = "id", strategy = "identity")
	@GeneratedValue(generator = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=40)
	public int getTrainingBatchId() {
		return trainingBatchId;
	}
	public void setTrainingBatchId(int trainingBatchId) {
		this.trainingBatchId = trainingBatchId;
	}
	@Column(length=40)
	public String getCoagencyId() {
		return coagencyId;
	}
	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}
	public String getEnrollBeginTime() {
		return enrollBeginTime;
	}
	public void setEnrollBeginTime(String enrollBeginTime) {
		this.enrollBeginTime = enrollBeginTime;
	}
	public String getEnrollEndTime() {
		return enrollEndTime;
	}
	public void setEnrollEndTime(String enrollEndTime) {
		this.enrollEndTime = enrollEndTime;
	}
	
	

}
 