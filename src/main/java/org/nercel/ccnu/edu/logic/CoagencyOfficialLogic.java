package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.CoagencyOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.CoagencyOfficial;

public interface CoagencyOfficialLogic {

public void addCoagencyOfficial(CoagencyOfficial entity);
	
	public void deleteCoagencyOfficial(CoagencyOfficial entity);
	
	public void batchDeleteCoagencyOfficial(JSONObject coagencyOfficialIds) throws JSONException;
	
	public void updateCoagencyOfficial(CoagencyOfficial entity);
	
	public CoagencyOfficial getCoagencyOfficialById(String id);
	
	public List<CoagencyOfficialVO> getCoagencyOfficialByConditions(String coagency, String status, String realName, String loginName, int pageNo, int pageSize);
	
	public int getTotalRecords(String coagency, String status, String realName, String loginName);
	
	public List<UtilObject> getAllCoagencyByUtilObject();
}
