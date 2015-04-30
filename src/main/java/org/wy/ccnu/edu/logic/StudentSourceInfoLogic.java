package org.wy.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.StudentSourceInfoVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentSourceInfo;
 
public interface StudentSourceInfoLogic {

	public void save(StudentSourceInfo entity);
	public void delete(StudentSourceInfo entity);
	public void update(StudentSourceInfo entity);
	public StudentSourceInfo findStudentSourceInfoById(String id);
	public boolean batchDeleteStudentSourceInfo(JSONObject studentSourceInfoIds) throws JSONException;
	public List<StudentSourceInfo> getStudentSourceInfoListByStudentAgencyID(String studentAgencyID);
	public List<UtilObject> getAllStudentSourceInfosByStudentAgency(String studentAgencyID);
	public List<UtilObject> getStudentSourceInfosByManageCenter(String manageCenterID);
	public List<StudentSourceInfo> getAllStudentSourceInfos();
	public List<StudentSourceInfoVO> findStudentSourceInfoVOByConditions(String studentAgency,String studentSourceInfoNum,String studentSourceInfoName,String status, int pageNo, int pageSize);
	public int getTotalRecords(String studentAgency,String studentSourceInfoNum,String studentSourceInfoName,String status);
	public List<UtilObject> getAllStudentSourceInfosByUtilObject();
	public boolean studentSourceInfoOfficialIsExist(String studentSourceInfoID);
	public boolean studentIsExist(String studentSourceInfoID);
	public boolean studentSourceInfoIsExist(String studentSourceInfoName);
	public boolean studentSourceNumIsExist(String studentSourceNum);
	public String getStudentSourceInfoIDByName(String studentSourceInfoName);
	public String getStudentSourceInfoNameById(String studentSourceInfoId);
	public String getStudentSourceInfoIdByName(String studentSourceInfoName);
	public ArrayList<UtilObject> getAllUtilObjectRpnAndRpIdbySCId(String studentAgencyId);
	public ArrayList<StudentSourceInfo>  getAllRpnRpIdAndSCId();
	
}
