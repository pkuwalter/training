package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class CityInfoVO{

	
	private int id;
	 
	private String name;			//县市名称
	
	private int belongProvinceId;	//所属省份
	
	private int belongCityId;		//所属市,默认为-1，表示所属市为本身
	
	private String code;			//市县编码，6位
	
	private String belongCityName; //所属市名称
	
	 	
	public CityInfoVO(int id, String name, int belongProvinceId,
			int belongCityId, String code, String belongCityName) {
		super();
		this.id = id;
		this.name = name;
		this.belongProvinceId = belongProvinceId;
		this.belongCityId = belongCityId;
		this.code = code;
		this.belongCityName = belongCityName;
	}

	public CityInfoVO(){
		super();
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

	public int getBelongProvinceId() {
		return belongProvinceId;
	}


	public void setBelongProvinceId(int belongProvinceId) {
		this.belongProvinceId = belongProvinceId;
	}

	public int getBelongCityId() {
		return belongCityId;
	}

	public void setBelongCityId(int belongCityId) {
		this.belongCityId = belongCityId;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBelongCityName() {
		return belongCityName;
	}

	public void setBelongCityName(String belongCityName) {
		this.belongCityName = belongCityName;
	}

	public String toStringAdd(){
		String jsonStr = "{\"id\":\""+this.id+"\",\"name\":\""+this.name+"\",\"belongProvinceId\":\""+this.belongProvinceId+"\"," +
				"\"belongCityId\":\""+this.belongCityId+"\",\"code\":\""+this.code+"\"}";
		return jsonStr;
	}
	public String toStringUpdate(){
		String jsonStr = "{\"id\":\""+this.id+"\",\"name\":\""+this.name+"\",\"belongProvinceId\":\""+this.belongProvinceId+"\"," +
				"\"belongCityId\":\""+this.belongCityId+"\",\"code\":\""+this.code+"\"}";
		return jsonStr;
	}

}
