package org.nercel.ccnu.edu.entity; 
/** 
 * @author Jo 
 * @version 创建时间：2014-5-17 下午5:55:34 
 * 类说明 
 */
public class TrainingProjectInfoVO {
	private static final long serialVersionUID = 1L;
	private int trainingProjectInfoId;//培训项目Id
	private String trainingProjectCode;//培训项目编号
	private String trainingProjectName;//培训项目名称
	private int trainingTypeId;//培训ID
	private String trainingTypeCode;//培训类别、性质
	private String trainingTypeName;//培训名称
	public TrainingProjectInfoVO(){
		
	}
	public TrainingProjectInfoVO(int trainingProjectInfoId, String trainingProjectCode, String trainingProjectName,
			int trainingTypeId, String trainingTypeCode, String trainingTypeName) {
		super();
		this.trainingProjectInfoId = trainingProjectInfoId;
		this.trainingProjectCode = trainingProjectCode;
		this.trainingProjectName = trainingProjectName;
		this.trainingTypeId = trainingTypeId;
		this.trainingTypeCode = trainingTypeCode;
		this.trainingTypeName = trainingTypeName;
	}
	public int getTrainingProjectInfoId() {
		return trainingProjectInfoId;
	}
	public void setTrainingProjectInfoId(int trainingProjectInfoId) {
		this.trainingProjectInfoId = trainingProjectInfoId;
	}
	public String getTrainingProjectCode() {
		return trainingProjectCode;
	}
	public void setTrainingProjectCode(String trainingProjectCode) {
		this.trainingProjectCode = trainingProjectCode;
	}
	public String getTrainingProjectName() {
		return trainingProjectName;
	}
	public void setTrainingProjectName(String trainingProjectName) {
		this.trainingProjectName = trainingProjectName;
	}
	public int getTrainingTypeId() {
		return trainingTypeId;
	}
	public void setTrainingTypeId(int trainingTypeId) {
		this.trainingTypeId = trainingTypeId;
	}
	public String getTrainingTypeCode() {
		return trainingTypeCode;
	}
	public void setTrainingTypeCode(String trainingTypeCode) {
		this.trainingTypeCode = trainingTypeCode;
	}
	public String getTrainingTypeName() {
		return trainingTypeName;
	}
	public void setTrainingTypeName(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}

	
}
 