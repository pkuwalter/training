package org.nercel.ccnu.edu.entity;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TeachingPlanTemplateVO{
 
	private String id;              
	private String tpTemplateName;    //培训计划模板名称
	private String tpTemplateCode;    //培训计划模板代码	  
	private int deductionModel;   	  //扣费模式
	private int deductionRule;		  //扣费规则
	private int dropTimeCode;		  //??
	private String dropTimeName;	  //退费退课点
	private int refundRate;			  //退费比例
	private String belongProject;
	

	public TeachingPlanTemplateVO(){}
	public TeachingPlanTemplateVO(String id,String tpTemplateName,String tpTemplateCode,
			int deductionModel,int deductionRule,int dropTimeCode,String dropTimeName,
			int refundRate, String belongProject){
		this.id=id;
		this.tpTemplateName=tpTemplateName;
		this.tpTemplateCode=tpTemplateCode;
		this.deductionModel=deductionModel;
		this.deductionRule=deductionRule;
		this.dropTimeCode=dropTimeCode;
		this.dropTimeName=dropTimeName;
		this.refundRate=refundRate;
		this.belongProject = belongProject;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTpTemplateName() {
		return tpTemplateName;
	}
	public void setTpTemplateName(String tpTemplateName) {
		this.tpTemplateName = tpTemplateName;
	}
	public String getTpTemplateCode() {
		return tpTemplateCode; 
	}
	public void setTpTemplateCode(String tpTemplateCode) {
		this.tpTemplateCode = tpTemplateCode;
	}
	public int getDeductionModel() {
		return deductionModel;
	}
	public void setDeductionModel(int deductionModel) {
		this.deductionModel = deductionModel;
	}
	public int getDeductionRule() {
		return deductionRule;
	}
	public void setDeductionRule(int deductionRule) {
		this.deductionRule = deductionRule;
	}
	public int getDropTimeCode() {
		return dropTimeCode;
	}
	public void setDropTimeCode(int dropTimeCode) {
		this.dropTimeCode = dropTimeCode;
	}
	public String getDropTimeName() {
		return dropTimeName;
	}
	public void setDropTimeName(String dropTimeName) {
		this.dropTimeName = dropTimeName;
	}
	public int getRefundRate() {
		return refundRate;
	}
	public void setRefundRate(int refundRate) {
		this.refundRate = refundRate;
	}
	public String getBelongProject() {
		return belongProject;
	}
	public void setBelongProject(String belongProject) {
		this.belongProject = belongProject;
	}
	
	 
}
