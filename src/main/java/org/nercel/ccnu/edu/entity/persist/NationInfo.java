package org.nercel.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "NationInfo")
@XmlRootElement
public class NationInfo implements Serializable{  
	
	private static final long serialVersionUID = 1L;	
	private int id;               //标识ID
	private String nationName;	//	varchar	30			
	public NationInfo(){		
	}
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(length=30)
	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName=nationName;
	}

	
}
