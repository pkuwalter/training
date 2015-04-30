package org.nercel.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.EducationLevel;

public interface EducationLevelLogic {
	
	public void addEducationLevel(EducationLevel entity);
	
	public boolean batchDeleteEducationLevel(JSONObject educationLevelIds) throws JSONException;
	//public void deleteEducationLevel(EducationLevel entity);
	
	public void updateEducationLevel(EducationLevel entity);
	
	public EducationLevel getEducationLevelById(String educationLevelID);
	
	public List<EducationLevel> getAllEducationLevels();
	
	//通过学习层次的Id集合获取对应的学习层次名称集合
	public ArrayList<UtilObject> getEducationLevelNameUtilObjectByIdList(ArrayList<String> educationLevelIdList);
		
	public String getEducationLevelNameById(String educationLevelId);
	
	public boolean teachingPlanExistOrNot(String educationLevelID);
	
	public List<UtilObject> getAllEducationLevelsByUtilObject();
	
	//add by zt @ 20121226
		public String getIdByName(String educationLevelName);
}
