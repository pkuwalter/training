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
 * 职称
 * @author Demon
 *
 */
@Entity
@Table(name = "academicTitle")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AcademicTitle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;			// 职称id(自增)
	private String name;	// 职称名称
	private String careerId;// 职业id(引用职业主键)
	
	public AcademicTitle(){
		
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCareerId() {
		return careerId;
	}
	public void setCareerId(String careerId) {
		this.careerId = careerId;
	}
	
}
