package org.wy.ccnu.edu.entity.persist;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 政治面貌信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "Political")
@XmlRootElement
public class Political implements Serializable  {
	private static final long serialVersionUID = 3141561582259381349L;
	private int id;				//政治面貌ID
	private String politicalName;		//政治面貌名称
	
	@Id 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=30)
	public String getPoliticalName() {
		return politicalName;
	}
	
	public void setPoliticalName(String politicalName) {
		this.politicalName = politicalName;
	}

	

}
