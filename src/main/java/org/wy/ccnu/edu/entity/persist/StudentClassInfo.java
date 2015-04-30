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
 * 学生-班级
 * 
 * @author Demon
 * 
 */
@Entity
@Table(name = "studentClassInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class StudentClassInfo implements Serializable {

	private int id; // 自增主键

	private int classId; // 班级id

	private String studentId; // 学生id

	public StudentClassInfo() {

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

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
