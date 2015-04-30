package org.wy.ccnu.edu.entity; 

/** 
 * @author Jo 
 * @version 创建时间：2014年5月26日 下午5:55:26 
 * 类说明 
 */
public class TrainingBatchVO {
	private int trainingBatchId;//培训批次id
	private int trainingProjectId;//培训项目id
	private String trainingProjectName;//培训项目名称
	private String trainingProjectCode;//培训项目代码
	private String trainingBatchName;//培训批次名称
	private String trainingBeginTime;//培训开始时间
	private String trainingEndTime;//培训截止时间
	private String planBeginTime;//培训计划开始时间
	private String planEndTime;//培训计划截止时间
	private int status;//状态，：1/是-启用；0/否-停用
	
	public TrainingBatchVO(){
		
	}
	public TrainingBatchVO(int trainingBatchId, int trainingProjectId, String trainingProjectName,
			String trainingProjectCode, String trainingBatchName, String trainingBeginTime, String trainingEndTime,
			String planBeginTime, String planEndTime, int status) {
		super();
		this.trainingBatchId = trainingBatchId;
		this.trainingProjectId = trainingProjectId;
		this.trainingProjectName = trainingProjectName;
		this.trainingProjectCode = trainingProjectCode;
		this.trainingBatchName = trainingBatchName;
		this.trainingBeginTime = trainingBeginTime;
		this.trainingEndTime = trainingEndTime;
		this.planBeginTime = planBeginTime;
		this.planEndTime = planEndTime;
		this.status = status;
	}
	public int getTrainingBatchId() {
		return trainingBatchId;
	}
	public void setTrainingBatchId(int trainingBatchId) {
		this.trainingBatchId = trainingBatchId;
	}
	public int getTrainingProjectId() {
		return trainingProjectId;
	}
	public void setTrainingProjectId(int trainingProjectId) {
		this.trainingProjectId = trainingProjectId;
	}
	public String getTrainingProjectName() {
		return trainingProjectName;
	}
	public void setTrainingProjectName(String trainingProjectName) {
		this.trainingProjectName = trainingProjectName;
	}
	public String getTrainingProjectCode() {
		return trainingProjectCode;
	}
	public void setTrainingProjectCode(String trainingProjectCode) {
		this.trainingProjectCode = trainingProjectCode;
	}
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
 