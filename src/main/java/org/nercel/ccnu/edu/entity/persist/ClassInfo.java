package org.nercel.ccnu.edu.entity.persist;

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
 * 班级
 * 
 * @author Demon
 */
@Entity
@Table(name = "classInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ClassInfo implements Serializable {

	private int id; // 自增主键
	
	private String classNum; // 编辑编号
	
	private String className; // 班级名称
	
	private String batchName; // 培训批次名称
	
	private int projectId; // 培训项目id
	
	private int headTeacherId; // 班主任id
	
	private int specialId; // 所属学科
	
	private String remark; // 说明

	public ClassInfo() {

	}

	@Id
	@Column(name = "id", length = 10)
	@GenericGenerator(name = "id", strategy = "identity")
	@GeneratedValue(generator = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getHeadTeacherId() {
		return headTeacherId;
	}

	public void setHeadTeacherId(int headTeacherId) {
		this.headTeacherId = headTeacherId;
	}

	public int getSpecialId() {
		return specialId;
	}

	public void setSpecialId(int specialId) {
		this.specialId = specialId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
