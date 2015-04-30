package org.wy.ccnu.edu.entity; 

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @author Jo 
 * @version 创建时间：2014年6月5日 上午11:06:31 
 * 类说明 
 */
@XmlRootElement
public class TrainingBatch_teachingUnitInfoVO {
	private static final long serialVersionUID = 1L;
	private int trainingBatch_teachingUnitInfoId;
	private int trainingBatchId;//培训批次ID
	private String coagencyId;//合作机构ID
	private String teachingUnitInfoId;//教学点ID
	private String teachingUnitNum;//教学点编号
	private String teachingUnitName;//教学点名称
	private String checkEndTime;//教学点审核结束时间
	public TrainingBatch_teachingUnitInfoVO(){
		
	}
	public TrainingBatch_teachingUnitInfoVO(int trainingBatch_teachingUnitInfoId, int trainingBatchId,
			String coagencyId, String teachingUnitInfoId, String teachingUnitNum, String teachingUnitName,
			String checkEndTime) {
		super();
		this.trainingBatch_teachingUnitInfoId = trainingBatch_teachingUnitInfoId;
		this.trainingBatchId = trainingBatchId;
		this.coagencyId = coagencyId;
		this.teachingUnitInfoId = teachingUnitInfoId;
		this.teachingUnitNum = teachingUnitNum;
		this.teachingUnitName = teachingUnitName;
		this.checkEndTime = checkEndTime;
	}
	public int getTrainingBatch_teachingUnitInfoId() {
		return trainingBatch_teachingUnitInfoId;
	}
	public void setTrainingBatch_teachingUnitInfoId(int trainingBatch_teachingUnitInfoId) {
		this.trainingBatch_teachingUnitInfoId = trainingBatch_teachingUnitInfoId;
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
	public String getTeachingUnitInfoId() {
		return teachingUnitInfoId;
	}
	public void setTeachingUnitInfoId(String teachingUnitInfoId) {
		this.teachingUnitInfoId = teachingUnitInfoId;
	}
	public String getTeachingUnitNum() {
		return teachingUnitNum;
	}
	public void setTeachingUnitNum(String teachingUnitNum) {
		this.teachingUnitNum = teachingUnitNum;
	}
	public String getTeachingUnitName() {
		return teachingUnitName;
	}
	public void setTeachingUnitName(String teachingUnitName) {
		this.teachingUnitName = teachingUnitName;
	}
	public String getCheckEndTime() {
		return checkEndTime;
	}
	public void setCheckEndTime(String checkEndTime) {
		this.checkEndTime = checkEndTime;
	}
	
}
 