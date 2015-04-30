package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.SupervisorOfficialDao;
import org.nercel.ccnu.edu.entity.persist.SupervisorOfficial;
import org.nercel.ccnu.edu.logic.SupervisorOfficialLogic;

public class SupervisorOfficialLogicImpl implements SupervisorOfficialLogic {

	private SupervisorOfficialDao dao=new SupervisorOfficialDao();

	 
	public void save(SupervisorOfficial entity) {
		dao.save(entity);
		
	}

	 
	public void batchDeleteSupervisorOfficial(JSONObject supervisorOfficialIds)
			throws JSONException {
		dao.batchDeleteSupervisorOfficial(supervisorOfficialIds);
		
	}

	 
	public void update(SupervisorOfficial entity) {
		dao.update(entity);
	}

	 
	public SupervisorOfficial findSupervisorOfficialById(String id) {
		return dao.findSupervisorOfficialById(id);
	}

	 
	public List<SupervisorOfficial> findSupervisorOfficialListByConditions(
			String realName, String loginName, int status, int pageNo,
			int pageSize) {
		return dao.findSupervisorOfficialListByConditions(realName, loginName, status, pageNo, pageSize);
	}

	 
	public int getTotalRecords(String realName, String loginName, int status) {
		return dao.getTotalRecords(realName, loginName, status);
	}

	public int isLoginNameExist(String loginName) {
		return dao.isLoginNameExist(loginName); 
	}
	 
	 
}
