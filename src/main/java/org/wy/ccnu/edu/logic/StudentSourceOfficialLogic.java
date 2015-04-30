package org.wy.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.StudentSourceOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentSourceOfficial;

public interface StudentSourceOfficialLogic {
	
	public void addStudentSourceOfficial(StudentSourceOfficial entity);
	
	public void deleteStudentSourceOfficial(StudentSourceOfficial entity);
	
	public void batchDeleteStudentSourceOfficial(JSONObject studentSourceOfficialIds) throws JSONException;
	
	public void updateStudentSourceOfficial(StudentSourceOfficial entity);
	
	public StudentSourceOfficial getStudentSourceOfficialById(String id);
	
	public List<StudentSourceOfficialVO> findStudentSourceOfficialVOByConditions(String agency, String status, String realName, String loginName, int pageNo, int pageSize);
	
	public String getStudentSourceIDByLoginName(String loginName);
	
	public int getTotalRecords(String agency, String status, String realName, String loginName);

	public List<UtilObject> getAllStudentSourceByUtilObject();
}
