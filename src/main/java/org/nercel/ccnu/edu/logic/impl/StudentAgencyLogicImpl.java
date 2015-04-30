package org.nercel.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.StudentAgencyDao;
import org.nercel.ccnu.edu.entity.StudentAgencyVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentAgency;
import org.nercel.ccnu.edu.logic.StudentAgencyLogic;

public class StudentAgencyLogicImpl implements StudentAgencyLogic {

	private StudentAgencyDao dao = new StudentAgencyDao();

	public void addStudentAgency(StudentAgency entity) {
		dao.save(entity);
	}

	public void deleteStudentAgency(StudentAgency entity) {
		
		dao.delete(entity);
	}

	public void updateStudentAgency(StudentAgency entity) {
		dao.update(entity);

	}

	public StudentAgency getStudentAgencyById(String id) {
		return dao.findStudentAgencyById(id);
	}
	
	public List<StudentAgency> getAllStudentAgencys(){
		return dao.getAllStudentAgencys();
	}
	
	public List<StudentAgencyVO> findStudentAgencyVOByConditions(String studentAgencyNum,String studentAgencyName,
			String manageCenter,String jwNum,String jwName,String provinceCode,int pageNo, int pageSize){
		return dao.findStudentAgencyVOByConditions(studentAgencyNum, studentAgencyName, manageCenter, jwNum,jwName,provinceCode, pageNo, pageSize);
	}

	public int getTotalRecords(String studentAgencyNum,String studentAgencyName,String manageCenterName,String jwNum,String jwName,String provinceCode){
		return dao.getTotalRecords(studentAgencyNum, studentAgencyName, manageCenterName, jwNum,jwName,provinceCode);
	}

	public String getStudentAgencyNameById(String studentAgencyId) {
		// TODO Auto-generated method stub
		return dao.getStudentAgencyNameById(studentAgencyId);
	}

	public ArrayList<UtilObject> getStudentAgencyUtilObjectByIdList(
			ArrayList<String> studycenterlist) {
		// TODO Auto-generated method stub
		return dao.getStudentAgencyUtilObjectByIdList(studycenterlist);
	}

	public boolean batchDeleteStudentAgency(JSONObject studentAgencyIds)
			throws JSONException {
		return dao.batchDeleteStudentAgency(studentAgencyIds);
	}

	public List<UtilObject> getAllStudentAgencysByUtilObject() {
		return dao.getAllStudentAgencysByUtilObject();
	}

	public List<UtilObject> getStudentAgencyUtilByManageCenterID(
			String manageCenterID) {
		return dao.getStudentAgencyUtilByManageCenterID(manageCenterID);
	}

	public String getStudentAgencyIDByName(String studentAgencyName) {
		return dao.getStudentAgencyIDByName(studentAgencyName);
	}
	
	/*
	public List<StudentAgency> getStudentAgencyByConditions(String studentAgencyNum,
			String studentAgencyName, String manageCenterName, String jwNum,
			int pageNo, int pageSize) {
		return dao.findStudentAgencyByConditions(studentAgencyNum, studentAgencyName, manageCenterName, jwNum, pageNo, pageSize);
	}
	*/
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
    public StudentAgency getStudentAgencyByProperty(String property,String proValue){
    	return dao.getStudentAgencyByProperty(property, proValue);
    }
}
