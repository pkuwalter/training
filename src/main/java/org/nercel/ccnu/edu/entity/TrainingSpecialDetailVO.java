package org.nercel.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TrainingSpecialDetailVO {

	private int id;
	private String specialId; // 专业id
	private String specialName; // 专业名称

	private int flag;

	public TrainingSpecialDetailVO() {
	}

	public TrainingSpecialDetailVO(String specialId, String specialName) {
		super();
		this.specialId = specialId;
		this.specialName = specialName;
	}

	public TrainingSpecialDetailVO(int id, String specialId, String specialName) {
		super();
		this.id = id;
		this.specialId = specialId;
		this.specialName = specialName;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the specialId
	 */
	public String getSpecialId() {
		return specialId;
	}

	/**
	 * @param specialId
	 *            the specialId to set
	 */
	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

	/*
	 * public String toStringforAdd() {
	 * 
	 * String s =
	 * "{\"grade\":\""+this.grade+"\",\"educationLevel\":\""+this.educationLevel
	 * +
	 * "\",\"special\":\""+this.special+"\",\"teachingPlan_SpecialDetailID\":\""
	 * +
	 * this.teachingPlan_SpecialDetailID+"\",\"teachingPlan_CourseDetailID\":\""
	 * +this.teachingPlan_CourseDetailID +"\"}"; return s; }
	 */

}
