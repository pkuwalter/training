package org.nercel.ccnu.edu.entity.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table( name = "TrainingType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingType {

	private static final long serialVersionUID = 1L;
	private int id;//Id，自增
	private String trainingTypeCode;//培训类别编号
	private String trainingTypeName;//培训类别名称
	
	public TrainingType(){
		
	}
	public TrainingType(int id, String trainingTypeCode, String trainingTypeName) {
		super();
		this.id = id;
		this.trainingTypeCode = trainingTypeCode;
		this.trainingTypeName = trainingTypeName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=10,nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=6,nullable=false)
	public String getTrainingTypeCode() {
		return trainingTypeCode;
	}
	public void setTrainingTypeCode(String trainingTypeCode) {
		this.trainingTypeCode = trainingTypeCode;
	}
	@Column(length=30,nullable=false)
	public String getTrainingTypeName() {
		return trainingTypeName;
	}
	public void setTrainingTypeName(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}
	
}
