package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TeachingUnitInfoOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingUnitInfoOfficial;

public interface TeachingUnitInfoOfficialLogic {

public void addTeachingUnitInfoOfficial(TeachingUnitInfoOfficial entity);
	
	public void deleteTeachingUnitInfoOfficial(TeachingUnitInfoOfficial entity);
	
	public void batchDeleteTeachingUnitInfoOfficial(JSONObject teachingUnitInfoOfficialIds) throws JSONException;
	
	public void updateTeachingUnitInfoOfficial(TeachingUnitInfoOfficial entity);
	
	public TeachingUnitInfoOfficial getTeachingUnitInfoOfficialById(String id);
	
	public List<TeachingUnitInfoOfficialVO> findTeachingUnitInfoOfficialVOByConditions(String teachingUnitInfoId, String status, String realName, String loginName, int pageNo, int pageSize);
	
	public String getTeachingUnitInfoIDByLoginName(String loginName);
	
	public int getTotalRecords(String teachingUnitInfoId, String status, String realName, String loginName);
	
	public List<UtilObject> getAllTeachingUnitInfoByUtilObject();

}
