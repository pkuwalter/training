package org.nercel.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.CoagencyVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.Coagency;

public interface CoagencyLogic{
	

	public void addCoagency(Coagency entity);
	
	public void deleteCoagency(Coagency entity);
	
	public boolean batchDeleteCoagency(JSONObject coagencyIds) throws JSONException;
	
	public void updateCoagency(Coagency entity);
	
	public Coagency getCoagencyById(String id);
	
	public List<Coagency> getAllCoagencys();
	
	//public List<Coagency> getCoagencyByConditions(String coagencyNum,String coagencyName,String manageCenterName,String jwNum,int pageNo, int pageSize);
	
	public List<CoagencyVO> findCoagencyVOByConditions(String coagencyNum,String coagencyName,String manageCenter,String jwNum,String jwName,String provinceCode,int pageNo, int pageSize);
	
	public int getTotalRecords(String coagencyNum,String coagencyName,String manageCenterName,String jwNum,String jwName,String provinceCode);
	
	public List<UtilObject> getAllCoagencysByUtilObject();

	public String getCoagencyNameById(String coagencyId);
	
	public ArrayList<UtilObject> getCoagencyUtilObjectByIdList(ArrayList<String> studycenterlist);
	
	public List<UtilObject> getCoagencyUtilByManageCenterID(String manageCenterID);
	
	public String getCoagencyIDByName(String coagencyName);
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
    public Coagency getCoagencyByProperty(String property,String proValue);
	public List<Coagency> getCoagencysByIds(String ids);
	
	/**
	 * 根据培训批次刷新合作机构列表
	 * @author yangsen
	 * @date 2014-06-18
	 * @param batchIds
	 * 		培训批次batchIds，例如batchIds=1,2,3,4
	 * @return
	 * 		List<Coagency>
	 */
	public List<Coagency> getCoagencysByBatchIds(String batchIds);
}
