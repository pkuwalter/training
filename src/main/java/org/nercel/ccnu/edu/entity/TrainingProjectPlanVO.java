package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TrainingProjectPlanVO {
	
	private int id;							//标识
	
	private int trainingProjectPlanId;		//培训计划id
	
	private String trainingProjectName;		//培训项目名称
	
	private String trainingBatchName;		//培训批次名称
	
	private String coagencyName;      		//合作机构名称
	
	private String teachingUnitName;        //教学点名称
	
	private String educationLevelName;   	//层次名称（培养类别）
	
	private String specialName;           	//专业名称
	
	private int amount; 					// 培训人数

	private int feeStandard; 				// 费用价格，默认为0
	
	public TrainingProjectPlanVO(){
		super();
	}
	
	/**
	 * 构造函数（没有id）
	 * @param trainingProjectPlanId
	 * @param trainingProjectName
	 * @param trainingBatchName
	 * @param coagencyName
	 * @param teachingUnitName
	 * @param educationLevelName
	 * @param specialName
	 * @param amount
	 * @param feeStandard
	 */
	public TrainingProjectPlanVO(int trainingProjectPlanId,String trainingProjectName,
			String trainingBatchName,String coagencyName, String teachingUnitName,
			String educationLevelName, String specialName, int amount,
			int feeStandard) {
		super();
		this.trainingProjectPlanId = trainingProjectPlanId;
		this.trainingProjectName = trainingProjectName;
		this.trainingBatchName = trainingBatchName;
		this.coagencyName = coagencyName;
		this.teachingUnitName = teachingUnitName;
		this.educationLevelName = educationLevelName;
		this.specialName = specialName;
		this.amount = amount;
		this.feeStandard = feeStandard;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainingProjectName() {
		return trainingProjectName;
	}

	public void setTrainingProjectName(String trainingProjectName) {
		this.trainingProjectName = trainingProjectName;
	}

	public String getTrainingBatchName() {
		return trainingBatchName;
	}

	public void setTrainingBatchName(String trainingBatchName) {
		this.trainingBatchName = trainingBatchName;
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

	public int getTrainingProjectPlanId() {
		return trainingProjectPlanId;
	}

	public void setTrainingProjectPlanId(int trainingProjectPlanId) {
		this.trainingProjectPlanId = trainingProjectPlanId;
	}

}
