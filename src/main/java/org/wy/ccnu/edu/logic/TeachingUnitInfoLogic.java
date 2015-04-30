package org.wy.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.TeachingUnitInfoVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfo;

public interface TeachingUnitInfoLogic {


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
	
	public boolean teachingUnitNameIsExist(String teachingUnitName);
	public boolean teachingUnitNumIsExist(String teachingUnitNaum);
	public boolean propertyIsExistInTable(String property,String propertyValue, String tableName);
	
	public String getTeachingUnitInfoIDByName(String teachingUnitInfoName);
	
	/**
	 * 根据多选的合作机构的ids和培训批次ids来查询满足条件的教学点
	 * @author yangsen
	 * @date 2014-05-20
	 * @param ids
	 * 			合作结构的ids,例如ids = 1,2,3,4
	 * @param batchIds
	 * 			培训批次的batchIds,例如batchIds = 1,2,3,4
	 * @return
	 * 			教学点列表List<TeachingUnitInfo>
	 */
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyIds(String ids, String batchIds);
	public List<TeachingUnitInfo> getTeachingUnitInfoListByIds(String ids);
}
