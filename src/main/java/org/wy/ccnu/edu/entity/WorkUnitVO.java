package org.wy.ccnu.edu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkUnitVO {
    private int id;				//	主键	标识ID，自增
    private String provinceName;	//		省份名称
    private String cityName;		//	市名称
    private String country;		// 	县区名称，从数据库取出来为code，然后处理成名称
    private String workUnitName;	//	工作单位名称
    private String workUnitCode;	//	工作单位code
    private String location;		//	工作单位所在地名称
    private int status;				//状态：是否已使用
    


	public WorkUnitVO(int id, String provinceName, String cityName,
			String country, String workUnitName, String workUnitCode,
			String location) {
		super();
		this.id = id;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.country = country;
		this.workUnitName = workUnitName;
		this.workUnitCode = workUnitCode;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWorkUnitName() {
		return workUnitName;
	}

	public void setWorkUnitName(String workUnitName) {
		this.workUnitName = workUnitName;
	}

	public String getWorkUnitCode() {
		return workUnitCode;
	}

	public void setWorkUnitCode(String workUnitCode) {
		this.workUnitCode = workUnitCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
    
    
}
