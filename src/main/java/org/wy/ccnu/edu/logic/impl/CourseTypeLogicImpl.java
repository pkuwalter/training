package org.wy.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.CourseTypeDao;
import org.wy.ccnu.edu.dao.EducationLevelDao;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CourseType;
import org.wy.ccnu.edu.entity.persist.ProvinceInfo;
import org.wy.ccnu.edu.logic.CourseTypeLogic;


public class CourseTypeLogicImpl implements CourseTypeLogic {

	CourseTypeDao dao = new CourseTypeDao();
	//增加课程类别
	public void addCourseType(CourseType entity) {
		dao.save(entity);
	}

	/*
	public void deleteEducationLevel(EducationLevel entity) {
		dao.delete(entity);
	}*/
	//批量删除课程类别
	public boolean batchDeleteCourseType(JSONObject courseTypeIds) throws JSONException{
		return dao.batchDeleteCourseType(courseTypeIds);
	}

	//更新课程类别
	public void updateCourseType(CourseType entity) {
		dao.update(entity);

	}
    //通过Id获取课程类别信息
	public CourseType getCourseTypeById(String courseTypeID) {
		return dao.getCourseTypeById(courseTypeID);
	}
	//获取所有课程类别信息
	public List<CourseType> getAllCourseTypes(){
		return dao.getAllCourseTypes();
	}

	//获取最大的Id
	public int getMaxCourseTypeId() {
		
		return dao.getMaxCourseTypeId();
	}
	/**
     * 根据courseType的属性来查找课程类别信息
     * @param property
     * 			课程类别属性
     * @param proValue
     * 			属性的值
     * @return
     * 			课程类别实体
     */
    public CourseType getCourseTypeByProperty(String property,String proValue,int id){
    	return dao.getCourseTypeByProperty(property, proValue,id);
    }

    
    /**
     * 根据courseType的属性来查找课程类别信息（参数有两个，没有id）
     * @author yangyingjie
     */
	public CourseType getCourseTypeByOneProperty(String property,
			String proValue) {
		return dao.getCourseTypeByOneProperty(property, proValue);
	}
}
