package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.TeachingUnitInfoOfficialDao;
import org.wy.ccnu.edu.entity.TeachingUnitInfoOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfoOfficial;
import org.wy.ccnu.edu.logic.TeachingUnitInfoOfficialLogic;

public class TeachingUnitInfoOfficialLogicImpl implements TeachingUnitInfoOfficialLogic{

private TeachingUnitInfoOfficialDao dao = new TeachingUnitInfoOfficialDao();
	
	public void addTeachingUnitInfoOfficial(TeachingUnitInfoOfficial entity) {
		dao.save(entity);
	}

	public void deleteTeachingUnitInfoOfficial(TeachingUnitInfoOfficial entity) {
		dao.delete(entity);
	}

	public void updateTeachingUnitInfoOfficial(TeachingUnitInfoOfficial entity) {
		dao.update(entity);

	}

	public TeachingUnitInfoOfficial getTeachingUnitInfoOfficialById(String id) {
		return dao.findTeachingUnitInfoOfficialById(id);
	}

	
	public String getTeachingUnitInfoIDByLoginName(String loginName){
		return dao.getTeachingUnitInfoIDByLoginName(loginName);
	}

	public void batchDeleteTeachingUnitInfoOfficial(
			JSONObject teachingUnitInfoOfficialIds) throws JSONException {
		dao.batchDeleteTeachingUnitInfoOfficial(teachingUnitInfoOfficialIds);
	}

	public List<TeachingUnitInfoOfficialVO> findTeachingUnitInfoOfficialVOByConditions(
			String teachingUnitInfoId, String status, String realName,
			String loginName, int pageNo, int pageSize) {
		return dao.findTeachingUnitInfoOfficialVOByConditions(teachingUnitInfoId, status, realName, loginName, pageNo, pageSize);
	}

	public int getTotalRecords(String teachingUnitInfoId, String status,
			String realName, String loginName) {
		return dao.getTotalRecords(teachingUnitInfoId, status, realName, loginName);
	}
	
	public List<UtilObject> getAllTeachingUnitInfoByUtilObject() {
	return dao.getAllTeachingUnitInfoByUtilObject();
}

}
