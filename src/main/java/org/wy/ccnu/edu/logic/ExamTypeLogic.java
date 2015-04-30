package org.wy.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.ExamType;

public interface ExamTypeLogic {
	
	public void addExamType(ExamType entity);
	
	public boolean batchDeleteExamType(JSONObject examTypeIds) throws JSONException;
	//public void deleteExamType(ExamType entity);
	
	public void updateExamType(ExamType entity);
	
	public ExamType getExamTypeById(int examTypeID);
	
	public List<ExamType> getAllExamTypes();
	
	//通过考试方式的Id集合获取对应的考试方式名称集合
	public ArrayList<UtilObject> getExamTypeNameUtilObjectByIdList(ArrayList<String> examTypeIdList);
		
	public String getExamTypeNameById(String examTypeId);
	
	public boolean teachingPlanExistOrNot(String examTypeID);
	
	public List<UtilObject> getAllExamTypesByUtilObject();
	

    public String getIdByName(String examTypeName);
    
    /**
     * 根据examType的属性来查找考试方式信息
     * @param property
     * @param proValue
     * @return
     */
    public ExamType getExamTypeByProperty(String property,String proValue,int id);
    
    public int getMaxExamTypeId();
    
    /**
     * 根据examType的属性来查找考试方式信息（没有id）
     * @author yangyingjie
     * @param property
     * @param proValue
     * @return
     */
    public ExamType getExamTypeByOneProperty(String property,String proValue);
}
