package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.CoagencyOfficialDao;
import org.wy.ccnu.edu.entity.CoagencyOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CoagencyOfficial;
import org.wy.ccnu.edu.logic.CoagencyOfficialLogic;

public class CoagencyOfficialLogicImpl implements CoagencyOfficialLogic{


	private CoagencyOfficialDao dao = new CoagencyOfficialDao();
	
	public void addCoagencyOfficial(CoagencyOfficial entity) {
		dao.save(entity);
	}

	public void deleteCoagencyOfficial(CoagencyOfficial entity) {
		dao.delete(entity);
	}

	public void updateCoagencyOfficial(CoagencyOfficial entity) {
		dao.update(entity);
	}

	public CoagencyOfficial getCoagencyOfficialById(String id) {
		return dao.findCoagencyOfficialById(id);
	}

	public List<CoagencyOfficialVO> getCoagencyOfficialByConditions(
			String coagency, String status, String realName,
			String loginName, int pageNo, int pageSize) {
		return dao.findCoagencyOfficialVOByConditions(coagency, status, realName, loginName, pageNo, pageSize);
	}

	public void batchDeleteCoagencyOfficial(JSONObject coagencyOfficialIds)
			throws JSONException {
		dao.batchDeleteCoagencyOfficial(coagencyOfficialIds);
	}

	public int getTotalRecords(String coagency, String status,
			String realName, String loginName) {
		return dao.getTotalRecords(coagency, status, realName, loginName);
	}

	public List<UtilObject> getAllCoagencyByUtilObject() {
	return dao.getAllCoagencyByUtilObject();
}
}
