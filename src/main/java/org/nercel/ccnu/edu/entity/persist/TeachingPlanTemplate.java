package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TeachingPlanTemplate")
@XmlRootElement
public class TeachingPlanTemplate implements Serializable {
 
	private static final long serialVersionUID = 1L; 
    
	private String id;              
	private String tpTemplateName;    //培训计划模板名称
	private String tpTemplateCode;    //培训计划模板代码	  
	private int deductionModel;   	  //扣费模式
	private int deductionRule;		  //扣费规则
	private int dropTimeCode;		  //??
	private String dropTimeName;	  //退费退课点
	private int refundRate;			  //退费比例
	private int belongProject;
	

	public TeachingPlanTemplate(){}
	public TeachingPlanTemplate(String id,String tpTemplateName,String tpTemplateCode,
			int deductionModel,int deductionRule,int dropTimeCode,String dropTimeName,
			int refundRate, int belongProject){
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
	 @Id 
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name="system-uuid",strategy = "uuid")
	 @Column(length=40)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(length=100)
	public String getTpTemplateName() {
		return tpTemplateName;
	}
	public void setTpTemplateName(String tpTemplateName) {
		this.tpTemplateName = tpTemplateName;
	}
	@Column(length=10)
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
	@Column(length=40)
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
	public int getBelongProject() {
		return belongProject;
	}
	public void setBelongProject(int belongProject) {
		this.belongProject = belongProject;
	}
	
	 
}
