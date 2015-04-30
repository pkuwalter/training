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
 * 教师类别
 * 
 * @author Demon
 * 
 */
@Entity
@Table(name = "teacherType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TeacherType implements Serializable {

	private int id; // 自增主键

	private String teacherTypeName; // 教师类别名称

	public TeacherType() {

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

	public String getTeacherTypeName() {
		return teacherTypeName;
	}

	public void setTeacherTypeName(String teacherTypeName) {
		this.teacherTypeName = teacherTypeName;
	}

}
