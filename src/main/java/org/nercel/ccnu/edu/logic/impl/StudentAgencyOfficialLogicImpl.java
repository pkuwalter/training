package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.StudentAgencyOfficialDao;
import org.nercel.ccnu.edu.entity.StudentAgencyOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentAgencyOfficial;
import org.nercel.ccnu.edu.logic.StudentAgencyOfficialLogic;

public class StudentAgencyOfficialLogicImpl implements StudentAgencyOfficialLogic {

	private StudentAgencyOfficialDao dao = new StudentAgencyOfficialDao();
	
	public void addStudentAgencyOfficial(StudentAgencyOfficial entity) {
		dao.save(entity);
	}

	public void deleteStudentAgencyOfficial(StudentAgencyOfficial entity) {
		dao.delete(entity);
	}

	public void updateStudentAgencyOfficial(StudentAgencyOfficial entity) {
		dao.update(entity);
	}

	public StudentAgencyOfficial getStudentAgencyOfficialById(String id) {
		return dao.findStudentAgencyOfficialById(id);
	}

	public List<StudentAgencyOfficialVO> getStudentAgencyOfficialByConditions(
			String agency, String status, String realName,
			String loginName, int pageNo, int pageSize) {
		return dao.findStudentAgencyOfficialVOByConditions(agency, status, realName, loginName, pageNo, pageSize);
	}

	public void batchDeleteStudentAgencyOfficial(JSONObject studentAgencyOfficialIds)
			throws JSONException {
		dao.batchDeleteStudentAgencyOfficial(studentAgencyOfficialIds);
	}

	public int getTotalRecords(String agency, String status,
			String realName, String loginName) {
		return dao.getTotalRecords(agency, status, realName, loginName);
	}

	public List<UtilObject> getAllStudentAgencyByUtilObject() {
		return dao.getAllStudentAgencyByUtilObject();
	}

	public int isLoginNameExist(String loginName) {

		return dao.isLoginNameExist(loginName);
	}
}
