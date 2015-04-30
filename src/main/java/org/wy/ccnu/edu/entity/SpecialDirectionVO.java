package org.wy.ccnu.edu.entity;

import java.io.Serializable;

 
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class SpecialDirectionVO  {
	
	private int id;                    //标识ID
	
	private String specialId;            //所属学科Id
	
	private String specialName;      //所属学科名称
	
	private String specialDirectionCode;           //学科方向编码
	
	private String specialDirectionName;         // 学科方向名称
 
	
	public SpecialDirectionVO(){
		
	}
	
	public SpecialDirectionVO(int id,String specialId, String specialName,
		String specialDirectionCode,String specialDirectionName)
       {
	
	  this.id = id;
	  
	  this.specialId = specialId;
	  
	  this.specialName = specialName;
	  
	  this.specialDirectionCode = specialDirectionCode;
	  
	  this.specialDirectionName =  specialDirectionName;
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSpecialId() {
		return specialId;
	}


	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}


	public String getSpecialName() {
		return specialName;
	}


	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}


	public String getSpecialDirectionCode() {
		return specialDirectionCode;
	}


	public void setSpecialDirectionCode(String specialDirectionCode) {
		this.specialDirectionCode = specialDirectionCode;
	}


	public String getSpecialDirectionName() {
		return specialDirectionName;
	}


	public void setSpecialDirectionName(String specialDirectionName) {
		this.specialDirectionName = specialDirectionName;
	}
	
	
	 
	
	
}
