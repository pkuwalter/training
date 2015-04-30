package org.nercel.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.ExamTypeDao;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.ExamType;
import org.nercel.ccnu.edu.logic.ExamTypeLogic;

public  class ExamTypeLogicImpl implements ExamTypeLogic {

	ExamTypeDao dao = new ExamTypeDao();
	
	public void addExamType(ExamType entity) {
		dao.save(entity);
	}

	/*
	public void deleteExamType(ExamType entity) {
		dao.delete(entity);
	}*/
	
	public boolean batchDeleteExamType(JSONObject examTypeIds) throws JSONException{
		return dao.batchDeleteExamType(examTypeIds);
	}

	public String getIdByName(String examTypeName) {
		return dao.getIdByName(examTypeName);
	}

	public void updateExamType(ExamType entity) {
		dao.update(entity);

	}

	public ExamType getExamTypeById(int examTypeID) {
		return dao.getExamTypeById(examTypeID);
	}
	
	public List<ExamType> getAllExamTypes(){
		return dao.getAllExamTypes();
	}

	public ArrayList<UtilObject> getExamTypeNameUtilObjectByIdList(
			ArrayList<String> examTypeIdList) {
		return dao.getExamTypeNameUtilObjectByIdList(examTypeIdList);
	}

	public String getExamTypeNameById(String examTypeId) {
		return dao.getExamTypeNameById(examTypeId);
	}

	public boolean teachingPlanExistOrNot(String examTypeID) {
		return dao.teachingPlanExistOrNot(examTypeID);
	}

	public List<UtilObject> getAllExamTypesByUtilObject() {
		return dao.getAllExamTypesByUtilObject();
	}
    
	 /**
	  * 根据examType的属性来查找考试方式信息
	  */
	 public ExamType getExamTypeByProperty(String property,String proValue,int id){
		 return dao.getExamTypeByProperty(property, proValue,id);
	 }
	 
	 public int getMaxExamTypeId(){
		 return dao.getMaxExamTypeId();
	 }

	/**
	 * 根据examType的属性来查找考试方式信息（没有id）
	 * @author yangyingjie
	 */
	public ExamType getExamTypeByOneProperty(String property, String proValue) {
		return dao.getExamTypeByOneProperty(property, proValue);
	}
}
