package org.nercel.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.CoagencyDao;
import org.nercel.ccnu.edu.entity.CoagencyVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.logic.CoagencyLogic;

public class CoagencyLogicImpl implements CoagencyLogic {

	private CoagencyDao dao = new CoagencyDao();

	public void addCoagency(Coagency entity) {
		dao.save(entity);
	}

	public void deleteCoagency(Coagency entity) {
		
		dao.delete(entity);
	}

	public void updateCoagency(Coagency entity) {
		dao.update(entity);

	}

	public Coagency getCoagencyById(String id) {
		return dao.findCoagencyById(id);
	}
	
	public List<Coagency> getAllCoagencys(){
		return dao.getAllCoagencys();
	}
	
	public List<CoagencyVO> findCoagencyVOByConditions(String coagencyNum,String coagencyName,
			String manageCenter,String jwNum,String jwName,String provinceCode,int pageNo, int pageSize){
		return dao.findCoagencyVOByConditions(coagencyNum, coagencyName, manageCenter, jwNum,jwName,provinceCode, pageNo, pageSize);
	}

	public int getTotalRecords(String coagencyNum,String coagencyName,String manageCenterName,String jwNum,String jwName,String provinceCode){
		return dao.getTotalRecords(coagencyNum, coagencyName, manageCenterName, jwNum,jwName,provinceCode);
	}

	public String getCoagencyNameById(String coagencyId) {
		// TODO Auto-generated method stub
		return dao.getCoagencyNameById(coagencyId);
	}

	public ArrayList<UtilObject> getCoagencyUtilObjectByIdList(
			ArrayList<String> studycenterlist) {
		// TODO Auto-generated method stub
		return dao.getCoagencyUtilObjectByIdList(studycenterlist);
	}

	public boolean batchDeleteCoagency(JSONObject coagencyIds)
			throws JSONException {
		return dao.batchDeleteCoagency(coagencyIds);
	}

	public List<UtilObject> getAllCoagencysByUtilObject() {
		return dao.getAllCoagencysByUtilObject();
	}

	public List<UtilObject> getCoagencyUtilByManageCenterID(
			String manageCenterID) {
		return dao.getCoagencyUtilByManageCenterID(manageCenterID);
	}

	public String getCoagencyIDByName(String coagencyName) {
		return dao.getCoagencyIDByName(coagencyName);
	}
	
	/*
	public List<Coagency> getCoagencyByConditions(String coagencyNum,
			String coagencyName, String manageCenterName, String jwNum,
			int pageNo, int pageSize) {
		return dao.findCoagencyByConditions(coagencyNum, coagencyName, manageCenterName, jwNum, pageNo, pageSize);
	}
	*/
	/**
     * 根据Coagency的属性来查找
     * @author yangse 2013-12-04
     * @param property
     * 			学习中心属性
     * @param proValue
     * 			学习中心属性的值
     * @return
     * 			学习中心实体
     */
    public Coagency getCoagencyByProperty(String property,String proValue){
    	return dao.getCoagencyByProperty(property, proValue);
    }

	/**
	 * 根据Id串"id1,id2..."获取合作机构列表
	 * @param ids
	 * @return
	 */
	public List<Coagency> getCoagencysByIds(String ids){
		return dao.getCoagencysByIds(ids);
	}
	
	/**
	 * 根据培训批次刷新合作机构列表
	 * @author yangsen
	 * @date 2014-06-18
	 * @param batchIds
	 * 		培训批次batchIds，例如batchIds=1,2,3,4
	 * @return
	 * 		List<Coagency>
	 */
	public List<Coagency> getCoagencysByBatchIds(String batchIds){
		return dao.getCoagencysByBatchIds(batchIds);
	}
}
