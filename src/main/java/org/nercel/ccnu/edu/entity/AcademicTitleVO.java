package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 职业-职称VO
 * @author Demon
 *
 */
@XmlRootElement
public class AcademicTitleVO {

	private int id;				// 职称id
	private String name;		// 职称名称
	private String careerId;	// 职业id
	private String careerName;	// 职业名称
	
	public AcademicTitleVO(){
		
	}
	
	public AcademicTitleVO(int id, String name, String careerId,
			String careerName) {
		this.id = id;
		this.name = name;
		this.careerId = careerId;
		this.careerName = careerName;
	}

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
	public String getCareerName() {
		return careerName;
	}
	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}
}
