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
 * @version 创建时间：2014年5月23日 下午3:52:39 
 * 教学点审核时间
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingBatch_teachingUnitInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//主键
	private int trainingBatchId;//培训批次ID
	private String teachingUnitInfoId;//教学点ID
	private String checkEndTime;//教学点审核结束时间
	
	public TrainingBatch_teachingUnitInfo(){
		
	}
	public TrainingBatch_teachingUnitInfo(int id, int trainingBatchId, String teachingUnitInfoId,
			String checkEndTime) {
		super();
		this.id = id;
		this.trainingBatchId = trainingBatchId;
		this.teachingUnitInfoId = teachingUnitInfoId;
		this.checkEndTime = checkEndTime;
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
	public String getTeachingUnitInfoId() {
		return teachingUnitInfoId;
	}
	public void setTeachingUnitInfoId(String teachingUnitInfoId) {
		this.teachingUnitInfoId = teachingUnitInfoId;
	}
	public String getCheckEndTime() {
		return checkEndTime;
	}
	public void setCheckEndTime(String checkEndTime) {
		this.checkEndTime = checkEndTime;
	}
	
}
 