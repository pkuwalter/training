package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.StudentAgencyOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentAgencyOfficial;

public interface StudentAgencyOfficialLogic {
	
	public void addStudentAgencyOfficial(StudentAgencyOfficial entity);
	
	public void deleteStudentAgencyOfficial(StudentAgencyOfficial entity);
	
	public void batchDeleteStudentAgencyOfficial(JSONObject studentAgencyOfficialIds) throws JSONException;
	
	public void updateStudentAgencyOfficial(StudentAgencyOfficial entity);
	
	public StudentAgencyOfficial getStudentAgencyOfficialById(String id);
	
	public List<StudentAgencyOfficialVO> getStudentAgencyOfficialByConditions(String agency, String status, String realName, String loginName, int pageNo, int pageSize);
	
	public int getTotalRecords(String agency, String status, String realName, String loginName);
	
	public List<UtilObject> getAllStudentAgencyByUtilObject();
	
	public int isLoginNameExist(String loginName);
}

