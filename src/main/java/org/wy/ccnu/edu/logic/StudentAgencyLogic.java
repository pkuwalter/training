package org.wy.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.StudentAgencyVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentAgency;

public interface StudentAgencyLogic {

	public void addStudentAgency(StudentAgency entity);
	
	public void deleteStudentAgency(StudentAgency entity);
	
	public boolean batchDeleteStudentAgency(JSONObject studentAgencyIds) throws JSONException;
	
	public void updateStudentAgency(StudentAgency entity);
	
	public StudentAgency getStudentAgencyById(String id);
	
	public List<StudentAgency> getAllStudentAgencys();
	
	//public List<StudentAgency> getStudentAgencyByConditions(String studentAgencyNum,String studentAgencyName,String manageCenterName,String jwNum,int pageNo, int pageSize);
	
	public List<StudentAgencyVO> findStudentAgencyVOByConditions(String studentAgencyNum,String studentAgencyName,String manageCenter,String jwNum,String jwName,String provinceCode,int pageNo, int pageSize);
	
	public int getTotalRecords(String studentAgencyNum,String studentAgencyName,String manageCenterName,String jwNum,String jwName,String provinceCode);
	
	public List<UtilObject> getAllStudentAgencysByUtilObject();

	public String getStudentAgencyNameById(String studentAgencyId);
	
	public ArrayList<UtilObject> getStudentAgencyUtilObjectByIdList(ArrayList<String> studycenterlist);
	
	public List<UtilObject> getStudentAgencyUtilByManageCenterID(String manageCenterID);
	
	public String getStudentAgencyIDByName(String studentAgencyName);
	/**
     * 根据StudentAgency的属性来查找
     * @author yangse 2013-12-04
     * @param property
     * 			学习中心属性
     * @param proValue
     * 			学习中心属性的值
     * @return
     * 			学习中心实体
     */
    public StudentAgency getStudentAgencyByProperty(String property,String proValue);


}
