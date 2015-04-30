package org.wy.ccnu.edu.entity.persist;

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
@Table( name = "TrainingProjectInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrainingProjectInfo {
	
	private static final long serialVersionUID = 1L;
	private int id;//Id，自增
	private String trainingProjectCode;//培训项目编号
	private String trainingProjectName;//培训项目名称
	private String trainingTypeCode;//培训项目类别、性质
	
	public TrainingProjectInfo(){
		
	}
	public TrainingProjectInfo(int id, String trainingProjectCode,
			String trainingProjectName, String trainingTypeCode) {
		super();
		this.id = id;
		this.trainingProjectCode = trainingProjectCode;
		this.trainingProjectName = trainingProjectName;
		this.trainingTypeCode = trainingTypeCode;
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
	@Column(length=20,nullable=false)
	public String getTrainingProjectCode() {
		return trainingProjectCode;
	}
	public void setTrainingProjectCode(String trainingProjectCode) {
		this.trainingProjectCode = trainingProjectCode;
	}
	@Column(length=30,nullable=false)
	public String getTrainingProjectName() {
		return trainingProjectName;
	}
	public void setTrainingProjectName(String trainingProjectName) {
		this.trainingProjectName = trainingProjectName;
	}
	@Column(length=6,nullable=false)
	public String getTrainingTypeCode() {
		return trainingTypeCode;
	}
	public void setTrainingTypeCode(String trainingTypeCode) {
		this.trainingTypeCode = trainingTypeCode;
	}

}
