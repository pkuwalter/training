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

/**
 * 培训计划信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "trainingProjectPlan")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingProjectPlan implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id; // 标识ID，自增

	private int trainingProjectId; // 培训项目Id

	private int trainingBatchId; // 培训批次id

	private String coagencyId; // 合作机构id

	private String teachingUnitInfoId; // 教学点id

	private String specialId; // 培训学科id

	private String educationLevelId; // 培训批次类型

	private int amount; // 培训人数

	private int feeStandard; // 费用价格，默认为0

	public TrainingProjectPlan() {
		super();

	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public int getTrainingProjectId() {
		return trainingProjectId;
	}

	
	public void setTrainingProjectId(int trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}

	
	public int getTrainingBatchId() {
		return trainingBatchId;
	}

	
	public void setTrainingBatchId(int trainingBatchId) {
		this.trainingBatchId = trainingBatchId;
	}

	@Column(name="coagencyId",length=40)
	public String getCoagencyId() {
		return coagencyId;
	}

	
	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}

	@Column(name="teachingUnitInfoId",length=40)
	public String getTeachingUnitInfoId() {
		return teachingUnitInfoId;
	}

	
	public void setTeachingUnitInfoId(String teachingUnitInfoId) {
		this.teachingUnitInfoId = teachingUnitInfoId;
	}

	@Column(name="specialId",length=40)
	public String getSpecialId() {
		return specialId;
	}

	
	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	@Column(name="educationLevelId",length=40)
	public String getEducationLevelId() {
		return educationLevelId;
	}

	
	public void setEducationLevelId(String educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	
	public int getAmount() {
		return amount;
	}

	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	public int getFeeStandard() {
		return feeStandard;
	}

	
	public void setFeeStandard(int feeStandard) {
		this.feeStandard = feeStandard;
	}


}
