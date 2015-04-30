package org.nercel.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.EducationLevelDao;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.EducationLevel;
import org.nercel.ccnu.edu.logic.EducationLevelLogic;

public class EducationLevelLogicImpl implements EducationLevelLogic {

	EducationLevelDao dao = new EducationLevelDao();
	
	public void addEducationLevel(EducationLevel entity) {
		dao.save(entity);
	}

	/*
	public void deleteEducationLevel(EducationLevel entity) {
		dao.delete(entity);
	}*/
	
	public boolean batchDeleteEducationLevel(JSONObject educationLevelIds) throws JSONException{
		return dao.batchDeleteEducationLevel(educationLevelIds);
	}

	public String getIdByName(String educationLevelName) {
		return dao.getIdByName(educationLevelName);
	}

	public void updateEducationLevel(EducationLevel entity) {
		dao.update(entity);

	}

	public EducationLevel getEducationLevelById(String educationLevelID) {
		return dao.getEducationLevelById(educationLevelID);
	}
	
	public List<EducationLevel> getAllEducationLevels(){
		return dao.getAllEducationLevels();
	}

	public ArrayList<UtilObject> getEducationLevelNameUtilObjectByIdList(
			ArrayList<String> educationLevelIdList) {
		return dao.getEducationLevelNameUtilObjectByIdList(educationLevelIdList);
	}

	public String getEducationLevelNameById(String educationLevelId) {
		return dao.getEducationLevelNameById(educationLevelId);
	}

	public boolean teachingPlanExistOrNot(String educationLevelID) {
		return dao.teachingPlanExistOrNot(educationLevelID);
	}

	public List<UtilObject> getAllEducationLevelsByUtilObject() {
		return dao.getAllEducationLevelsByUtilObject();
	}

}
