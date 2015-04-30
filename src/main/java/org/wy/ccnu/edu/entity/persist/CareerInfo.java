package org.wy.ccnu.edu.entity.persist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CareerInfo")
@XmlRootElement
public class CareerInfo implements Serializable{  //入学考试科目
	
	private static final long serialVersionUID = 1L;	
	private String id;               //标识ID
	private String Career;	//	varchar	20		ְҵ���	
	public CareerInfo(){		
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
	@Column(length=20)
	public String getCareer() {
		return Career;
	}

	public void setCareer(String career) {
		Career = career;
	}

	
}
