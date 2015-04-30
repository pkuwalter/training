package org.wy.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.persist.SupervisorOfficial;
 
public interface SupervisorOfficialLogic {
 
	public void save(SupervisorOfficial entity);
	
	public void batchDeleteSupervisorOfficial(JSONObject supervisorOfficialIds) throws JSONException; 
	
	public void update(SupervisorOfficial entity);
	
	public SupervisorOfficial findSupervisorOfficialById(String id);

	public List<SupervisorOfficial> findSupervisorOfficialListByConditions(String realName, String loginName, int status,  int pageNo, int pageSize);
	public int getTotalRecords(   String realName, String loginName,int status);
	public int isLoginNameExist(String loginName);
}
