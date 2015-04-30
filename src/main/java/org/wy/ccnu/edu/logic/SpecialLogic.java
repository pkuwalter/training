package org.wy.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.Special;

public interface SpecialLogic {
	
    public void addSpecial(Special entity);
	
	public boolean batchDeleteSpecial(JSONObject specialIds) throws JSONException;
	
	public void updateSpecial(Special entity);
	
	public Special getSpecialById(String specialID);
	
	public Special getSpecialByName(String specialName);
	
	public List<Special> getSpecialbyEducationLevelID(String educationLevelID);
	
	public List<Special> getAllSpecials();
	
	public List<Special> getAllSpecialsInTeachingPlan();
	
	public ArrayList<UtilObject> getSpecialUtilObjectByIdList(ArrayList<String> specialIdList);
	
	public String getSpecialNameById(String specialId);
	
	public boolean teachingPlanExistOrNot(String specialID);
	
	public List<UtilObject> getAllSpecialsByUtilObject();
	
	public List<UtilObject> getSpecialUtilsByGradeAndEducationLevel(String gradeID,String educationLevelID);
	
	public List<UtilObject> getSpecialsInTeachingPlanByUtilObject();
}
