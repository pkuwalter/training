package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.WorkUnitVO;
import org.nercel.ccnu.edu.entity.persist.WorkUnit;

public interface WorkUnitLogic {
	
	public void save(WorkUnit entity);
	
	public void update(WorkUnit entity);
	
	/*
	 * 删除工作单位
	 * 若没被使用，则删除并返回true
	 * 否则不删除，并返回false
	 * */	
	public boolean delete(WorkUnit entity)  throws JSONException;
	
	/*
	 * 根据id号批量删除工作单位信息
	 * 若没被使用，则删除并返回true
	 * 否则不删除，并返回false
	 * */	
	public boolean batchDeleteByIds(JSONObject ids)  throws JSONException;
	
	public WorkUnit getById(Object id);
	
	/**
	 * 根据条件查询工作单位信息列表
	 * @param provinceCode
	 * @param cityCode
	 * @param countryCode
	 * @param workUnitName
	 * @param woekUnitCode
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<WorkUnitVO> getWorkUnitByConditions(String provinceCode, String cityCode,
			String countryCode, String workUnitName, String workUnitCode, int pageNo, int pageSize);
	
	/**
	 * 根据条件得到工作单位记录数
	 * @param provinceCode
	 * @param cityCode
	 * @param countryCode
	 * @param workUnitName
	 * @param woekUnitCode
	 * @return
	 */
	public int getWorkUnitRecords(String provinceCode, String cityCode,
			String countryCode, String workUnitName, String workUnitCode);
	
	
	/**
	 * 根据属性名和属性值查询工作单位
	 * 					-若有多个，返回第一个
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public WorkUnit findByProperty(String propertyName, Object value);
	
	/**
	 * 根据属性名模糊查询工作单位列表信息
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<WorkUnit> findListByProperty(String propertyName, Object value);
	
}
