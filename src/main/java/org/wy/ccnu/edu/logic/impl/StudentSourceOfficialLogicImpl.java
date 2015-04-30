package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.StudentSourceOfficialDao;
import org.wy.ccnu.edu.entity.StudentSourceOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentSourceOfficial;
import org.wy.ccnu.edu.logic.StudentSourceOfficialLogic;

public class StudentSourceOfficialLogicImpl implements
		StudentSourceOfficialLogic {

	private StudentSourceOfficialDao dao = new StudentSourceOfficialDao();
	
	public void addStudentSourceOfficial(StudentSourceOfficial entity) {
		dao.save(entity);
	}

	public void deleteStudentSourceOfficial(StudentSourceOfficial entity) {
		dao.delete(entity);
	}

	public void updateStudentSourceOfficial(StudentSourceOfficial entity) {
		dao.update(entity);

	}

	public StudentSourceOfficial getStudentSourceOfficialById(String id) {
		return dao.findStudentSourceOfficialById(id);
	}

	
	public String getStudentSourceIDByLoginName(String loginName){
		return dao.getStudentSourceIDByLoginName(loginName);
	}

	public void batchDeleteStudentSourceOfficial(
			JSONObject studentSourceOfficialIds) throws JSONException {
		dao.batchDeleteStudentSourceOfficial(studentSourceOfficialIds);
	}

	public List<StudentSourceOfficialVO> findStudentSourceOfficialVOByConditions(
			String agency, String status, String realName,
			String loginName, int pageNo, int pageSize) {
		return dao.findStudentSourceOfficialVOByConditions(agency, status, realName, loginName, pageNo, pageSize);
	}

	public int getTotalRecords(String agency, String status,
			String realName, String loginName) {
		return dao.getTotalRecords(agency, status, realName, loginName);
	}
	public List<UtilObject> getAllStudentSourceByUtilObject() {
		return dao.getAllStudentSourceByUtilObject();
	}
}
