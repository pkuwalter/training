package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.TeachingUnitInfoDao;
import org.nercel.ccnu.edu.entity.TeachingUnitInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.nercel.ccnu.edu.logic.TeachingUnitInfoLogic;

public class TeachingUnitInfoLogicImpl implements TeachingUnitInfoLogic{

	private TeachingUnitInfoDao dao = new TeachingUnitInfoDao();
	
	public void addTeachingUnitInfo(TeachingUnitInfo entity) {
		dao.save(entity);
	}

	public void deleteTeachingUnitInfo(TeachingUnitInfo entity) {
		dao.delete(entity);
	}

	public void updateTeachingUnitInfo(TeachingUnitInfo entity) {
		dao.update(entity);
	}

	public TeachingUnitInfo getTeachingUnitInfoById(String id) {
		return dao.findTeachingUnitInfoById(id);
	}
	
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyID(String coagencyID){
		return dao.getTeachingUnitInfoListByCoagencyID(coagencyID);
	}
	
	public List<TeachingUnitInfo> getAllTeachingUnitInfos(){
		return dao.getAllTeachingUnitInfos();
	}

	public List<TeachingUnitInfoVO> getTeachingUnitInfoVOByConditions(
			String coagency, String teachingUnitInfoNum,
			String teachingUnitInfoName, String status, int pageNo,
			int pageSize) {
		return dao.findTeachingUnitInfoVOByConditions(coagency, teachingUnitInfoNum, teachingUnitInfoName, status, pageNo, pageSize);
	}

	public int getTotalRecords(String coagency, String teachingUnitInfoNum,
			String teachingUnitInfoName, String status) {
		return dao.getTotalRecords(coagency, teachingUnitInfoNum, teachingUnitInfoName, status);
	}

	public List<UtilObject> getAllTeachingUnitInfosByUtilObject() {
		return dao.getAllTeachingUnitInfosByUtilObject();
	}

	public boolean batchDeleteTeachingUnitInfo(JSONObject teachingUnitInfoIds)
			throws JSONException {
		return dao.batchDeleteTeachingUnitInfo(teachingUnitInfoIds);
	}

	public List<UtilObject> getAllTeachingUnitInfosByCoagency(
			String coagencyID) {
		return dao.getAllTeachingUnitInfosByCoagency(coagencyID);
	}

	public List<UtilObject> getTeachingUnitInfosByManageCenter(
			String manageCenterID) {
		return dao.getTeachingUnitInfosByManageCenter(manageCenterID);
	}

	public boolean teachingUnitNameIsExist(String teachingUnitName) {
		return dao.teachingUnitNameIsExist(teachingUnitName);
	}
	public boolean teachingUnitNumIsExist(String teachingUnitNum) {
		return dao.teachingUnitNumIsExist(teachingUnitNum);
	}
	public boolean propertyIsExistInTable(String property,String propertyValue, String tableName) {
		return dao.propertyIsExistInTable(property, propertyValue, tableName);
	}
	public String getTeachingUnitInfoIDByName(String teachingUnitInfoName) {
		return dao.getTeachingUnitInfoIDByName(teachingUnitInfoName);
	}

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
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyIds(String ids, String batchIds){
		return dao.getTeachingUnitInfoListByCoagencyIds(ids,batchIds);
	}

	@Override
	public List<TeachingUnitInfo> getTeachingUnitInfoListByIds(String ids) {
		return dao.getTeachingUnitInfoListByIds(ids); 
	}
}
