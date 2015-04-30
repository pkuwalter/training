package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "specialdirection")
@XmlRootElement
public class SpecialDirection implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;                    //标识ID
	
	private String specialId;            //所属学科
	
	private String specialDirectionCode;           //学科方向编码
	
	private String specialDirectionName;         // 学科方向名称
 
	
	public SpecialDirection(){
		
	}
	
	@Id 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column(length=40)
	public String getSpecialId() {
		return specialId;
	}

	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	
	@Column(length=20)
	public String getSpecialDirectionCode() {
		return specialDirectionCode;
	}

	public void setSpecialDirectionCode(String specialDirectionCode) {
		this.specialDirectionCode = specialDirectionCode;
	}
	
	@Column(length=50)
	public String getSpecialDirectionName() {
		return specialDirectionName;
	}

	public void setSpecialDirectionName(String specialDirectionName) {
		this.specialDirectionName = specialDirectionName;
	}
	
	
	 
	
	
}
