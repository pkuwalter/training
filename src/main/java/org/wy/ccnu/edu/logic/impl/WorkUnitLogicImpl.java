package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.CityInfoDao;
import org.wy.ccnu.edu.dao.WorkUnitDao;
import org.wy.ccnu.edu.entity.WorkUnitVO;
import org.wy.ccnu.edu.entity.persist.CityInfo;
import org.wy.ccnu.edu.entity.persist.WorkUnit;
import org.wy.ccnu.edu.logic.WorkUnitLogic;

public class WorkUnitLogicImpl implements WorkUnitLogic {
	
	WorkUnitDao dao = new WorkUnitDao();
	CityInfoDao cityDao = new CityInfoDao();

	public void save(WorkUnit entity) {
		dao.save(entity);
	}

	public void update(WorkUnit entity) {
		dao.update(entity);
	}

	
	public boolean delete(WorkUnit entity) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("1", entity.getId());
		
		if(dao.checkIfInUse(json))
			return false;
		
		dao.delete(entity);
		return true;
	}

	public boolean batchDeleteByIds(JSONObject ids) throws JSONException{
		return dao.batchDeleteByIds(ids);
	}

	public WorkUnit getById(Object id) {
		return dao.getById(id);
	}

	public List<WorkUnitVO> getWorkUnitByConditions(String provinceCode,
			String cityCode, String countryCode, String workUnitName,
			String workUnitCode, int pageNo, int pageSize) {
		List<WorkUnitVO> list = dao.getWorkUnitByConditions(provinceCode, cityCode, countryCode, workUnitName, workUnitCode, pageNo, pageSize);
		if(list == null || list.size() == 0)
			return null;
		for(WorkUnitVO o:list){
			
			CityInfo cityInfo = cityDao.getCityInfoByProperty("code", o.getCityName());
			o.setCityName(cityInfo.getName());
			
			cityInfo = cityDao.getCityInfoByProperty("code", o.getCountry());
			o.setCountry(cityInfo.getName());			
			
		}
		
		return list;	
		
	}

	public int getWorkUnitRecords(String provinceCode, String cityCode,
			String countryCode, String workUnitName, String workUnitCode) {
		return dao.getWorkUnitRecords(provinceCode, cityCode, countryCode, workUnitName, workUnitCode);
	}

	public WorkUnit findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	public List<WorkUnit> findListByProperty(String propertyName, Object value) {
		return dao.findListByProperty(propertyName, value);
	}

}
