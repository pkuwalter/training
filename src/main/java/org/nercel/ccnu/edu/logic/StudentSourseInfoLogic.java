package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TeachingUnitInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingUnitInfo;

public interface StudentSourseInfoLogic {


	public void addTeachingUnitInfo(TeachingUnitInfo entity);
	
	public void deleteTeachingUnitInfo(TeachingUnitInfo entity);
	
	public void updateTeachingUnitInfo(TeachingUnitInfo entity);
	
	public TeachingUnitInfo getTeachingUnitInfoById(String id);
	
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyID(String coagencyID);
	
	public List<TeachingUnitInfo> getAllTeachingUnitInfos();
	
	public List<TeachingUnitInfoVO> getTeachingUnitInfoVOByConditions(String coagency,String teachingUnitInfoNum,String teachingUnitInfoName,String status, int pageNo, int pageSize);
	
	public int getTotalRecords(String coagency,String teachingUnitInfoNum,String teachingUnitInfoName,String status);
	
	public List<UtilObject> getAllTeachingUnitInfosByUtilObject();
	
	public boolean batchDeleteTeachingUnitInfo(JSONObject teachingUnitInfoIds) throws JSONException;
	
	public List<UtilObject> getAllTeachingUnitInfosByCoagency(String coagencyID);
	
	public List<UtilObject> getTeachingUnitInfosByManageCenter(String manageCenterID);
	
	public boolean teachingUnitInfoIsExist(String teachingUnitInfoName);
	
	public String getTeachingUnitInfoIDByName(String teachingUnitInfoName);
}
