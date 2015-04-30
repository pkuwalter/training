package org.nercel.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.SpecialDao;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.Special;
import org.nercel.ccnu.edu.logic.SpecialLogic;

public class SpecialLogicImpl implements SpecialLogic {

	SpecialDao dao = new SpecialDao();
	
	public void addSpecial(Special entity) {
		dao.save(entity);
	}

	public boolean batchDeleteSpecial(JSONObject specialIds) throws JSONException {
		return dao.batchDeleteSpecial(specialIds);
	}

	public void updateSpecial(Special entity) {
		dao.update(entity);
	}

	public Special getSpecialById(String specialID) {
		return dao.getSpecialById(specialID);
	}
	
	public List<Special> getSpecialbyEducationLevelID(String educationLevelID){
		return dao.getSpecialbyEducationLevelID(educationLevelID);
	}

	public List<Special> getAllSpecials() {
		return dao.getAllSpecials();
	}
	
	public List<Special> getAllSpecialsInTeachingPlan(){
		return dao.getAllSpecialsInTeachingPlan();
	}

	public Special getSpecialByName(String specialName) {
		return dao.getSpecialByName(specialName);
	}

	public ArrayList<UtilObject> getSpecialUtilObjectByIdList(
			ArrayList<String> specialIdList) {
		return dao.getSpecialNameUtilObjectByIdList(specialIdList);
	}

	public String getSpecialNameById(String specialId) {
		return dao.getSpecialNameById(specialId);
	}

	public boolean teachingPlanExistOrNot(String specialID) {
		return dao.teachingPlanExistOrNot(specialID);
	}

	public List<UtilObject> getAllSpecialsByUtilObject() {
		return dao.getAllSpecialsByUtilObject();
	}

	public List<UtilObject> getSpecialUtilsByGradeAndEducationLevel(
			String gradeID, String educationLevelID) {
		return dao.getSpecialUtilsByGradeAndEducationLevel(gradeID, educationLevelID);
	}

	public List<UtilObject> getSpecialsInTeachingPlanByUtilObject() {
		return dao.getSpecialsInTeachingPlanByUtilObject();
	}

}
