package org.nercel.ccnu.edu.entity; 
/** 
 * @author Jo 
 * @version 创建时间：2014年5月28日 下午3:02:33 
 * 类说明 
 */
public class TrainingBatch_coagencyVO {

	private int trainingBatch_coagencyId;//主键
	private int trainingBatchId;//培训批次ID
	private String coagencyId;//合作机构ID
	private String coagencyName;//合作机构名称
	private String enrollBeginTime;//教学点审核开始时间
	private String enrollEndTime;//教学点审核结束时间
	public TrainingBatch_coagencyVO(){
		
	}
	public TrainingBatch_coagencyVO(int trainingBatch_coagencyId, int trainingBatchId,
			String coagencyId, String coagencyName, String enrollBeginTime, String enrollEndTime) {
		super();
		this.trainingBatch_coagencyId = trainingBatch_coagencyId;
		this.trainingBatchId = trainingBatchId;
		this.coagencyId = coagencyId;
		this.coagencyName = coagencyName;
		this.enrollBeginTime = enrollBeginTime;
		this.enrollEndTime = enrollEndTime;
	}
	public int getTrainingBatch_coagencyId() {
		return trainingBatch_coagencyId;
	}
	public void setTrainingBatch_coagencyId(int trainingBatch_coagencyId) {
		this.trainingBatch_coagencyId = trainingBatch_coagencyId;
	}
	public int getTrainingBatchId() {
		return trainingBatchId;
	}
	public void setTrainingBatchId(int trainingBatchId) {
		this.trainingBatchId = trainingBatchId;
	}
	public String getCoagencyId() {
		return coagencyId;
	}
	public void setCoagencyId(String coagencyId) {
		this.coagencyId = coagencyId;
	}
	public String getCoagencyName() {
		return coagencyName;
	}
	public void setCoagencyName(String coagencyName) {
		this.coagencyName = coagencyName;
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
 