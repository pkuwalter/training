package org.nercel.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
 
import org.nercel.ccnu.edu.dao.StudentSourceInfoDao;
import org.nercel.ccnu.edu.entity.StudentSourceInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentSourceInfo;
import org.nercel.ccnu.edu.logic.StudentSourceInfoLogic;
 
 

public class StudentSourceInfoLogicImpl implements StudentSourceInfoLogic{

private StudentSourceInfoDao dao = new StudentSourceInfoDao();

@Override
public void save(StudentSourceInfo entity) {
	dao.save(entity);
}

@Override
public void delete(StudentSourceInfo entity) {
	dao.delete(entity);
}

@Override
public void update(StudentSourceInfo entity) {
	dao.update(entity);
}

@Override
public StudentSourceInfo findStudentSourceInfoById(String id) {
	return dao.findStudentSourceInfoById(id);
}

@Override
public boolean batchDeleteStudentSourceInfo(JSONObject studentSourceInfoIds)
		throws JSONException {
	return dao.batchDeleteStudentSourceInfo(studentSourceInfoIds);
}

@Override
public List<StudentSourceInfo> getStudentSourceInfoListByStudentAgencyID(
		String studentAgencyID) {
	return dao.getStudentSourceInfoListByStudentAgencyID(studentAgencyID);
}

@Override
public List<UtilObject> getAllStudentSourceInfosByStudentAgency(
		String studentAgencyID) {
	return dao.getAllStudentSourceInfosByStudentAgency(studentAgencyID);
}

@Override
public List<UtilObject> getStudentSourceInfosByManageCenter(
		String manageCenterID) {
	return dao.getStudentSourceInfosByManageCenter(manageCenterID);
}

@Override
public List<StudentSourceInfo> getAllStudentSourceInfos() {
	return dao.getAllStudentSourceInfos();
}

@Override
public List<StudentSourceInfoVO> findStudentSourceInfoVOByConditions(
		String studentAgency, String studentSourceInfoNum,
		String studentSourceInfoName, String status, int pageNo, int pageSize) {
	return dao.findStudentSourceInfoVOByConditions(studentAgency, studentSourceInfoNum, studentSourceInfoName, status, pageNo, pageSize);
}

@Override
public int getTotalRecords(String studentAgency, String studentSourceInfoNum,
		String studentSourceInfoName, String status) {
	return dao.getTotalRecords(studentAgency, studentSourceInfoNum, studentSourceInfoName, status);
}

@Override
public List<UtilObject> getAllStudentSourceInfosByUtilObject() {
	return dao.getAllStudentSourceInfosByUtilObject();
}

@Override
public boolean studentSourceInfoOfficialIsExist(String studentSourceInfoID) {
	return dao.studentSourceInfoOfficialIsExist(studentSourceInfoID);
}

@Override
public boolean studentIsExist(String studentSourceInfoID) {
	return dao.studentIsExist(studentSourceInfoID);
}

@Override
public boolean studentSourceInfoIsExist(String studentSourceInfoName) {
	return dao.studentSourceInfoIsExist(studentSourceInfoName);
}

@Override
public String getStudentSourceInfoIDByName(String studentSourceInfoName) {
	return dao.getStudentSourceInfoIDByName(studentSourceInfoName);
}

@Override
public String getStudentSourceInfoNameById(String studentSourceInfoId) {
	return dao.getStudentSourceInfoNameById(studentSourceInfoId);
}

@Override
public String getStudentSourceInfoIdByName(String studentSourceInfoName) {
	return dao.getStudentSourceInfoIdByName(studentSourceInfoName);
}

@Override
public ArrayList<UtilObject> getAllUtilObjectRpnAndRpIdbySCId(
		String studentAgencyId) {
	return dao.getAllUtilObjectRpnAndRpIdbySCId(studentAgencyId);
}

@Override
public ArrayList<StudentSourceInfo> getAllRpnRpIdAndSCId() {
	return dao.getAllRpnRpIdAndSCId();
}

@Override
public boolean studentSourceNumIsExist(String studentSourceNum) {
	return dao.studentSourceNumIsExist(studentSourceNum) ;
}
	 
}
