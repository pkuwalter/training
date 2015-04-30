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
 * 教师-课程
 * 
 * @author Demon
 * 
 */
@Entity
@Table(name = "teacherCourse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TeacherCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id; // 自增主键

	private int teacherId; // 教师id

	private String batchName; // 培训批次名称

	private int projectId; // 培训项目id

	public TeacherCourse() {
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

	public int getTeacherId() {
		return teacherId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
