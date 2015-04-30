package org.wy.ccnu.edu.entity.persist; 

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
 * @author Jo 
 * @version 创建时间：2014年6月19日 下午2:25:56 
 * 课堂作业模板
 */
@Entity
@Table(name = "AssignmentRuleTemplate")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AssignmentRuleTemplate implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;//ID
	private String templateName;//模版名称
	private int ruleValue;//规则的具体要求值，如：30
	private String ruleName;//模板规则说明，例如：已学习30个小时
	private String remark;//备注说明
	private int status=Status.STATUS_ON;//状态
	private int ruleType=RuleType.TYPE_DURATION;//类型
	
	@Id 
	@Column(name = "id",length=40)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(length=40,nullable=false)
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	@Column(length=11,nullable=false)
	public int getRuleValue() {
		return ruleValue;
	}
	public void setRuleValue(int ruleValue) {
		this.ruleValue = ruleValue;
	}
	@Column(length=100,nullable=false)
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	@Column(length=100,nullable=true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(length=11,nullable=false)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(length=11,nullable=false)
	public int getRuleType() {
		return ruleType;
	}
	public void setRuleType(int ruleType) {
		this.ruleType = ruleType;
	}
	public interface Status{
		public static final int STATUS_OFF = 0;//停用
		public static final int STATUS_ON = 1;//启用
	}
	public interface RuleType{
		public static final int TYPE_DURATION=1;//学习时长
		public static final int TYPE_TIME=2;//登陆次数
		public static final int TYPE_SCORE=3;//学分
	}
}
 