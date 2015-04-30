package org.wy.ccnu.edu.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.CourseClassDao;
import org.wy.ccnu.edu.dao.CourseTypeDao;
import org.wy.ccnu.edu.dao.EducationLevelDao;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CourseClass;

import org.wy.ccnu.edu.logic.CourseClassLogic;
import org.wy.ccnu.edu.logic.CourseTypeLogic;


public class CourseClassLogicImpl implements CourseClassLogic {

	CourseClassDao dao = new CourseClassDao();
	//增加课程课类
	public void addCourseClass(CourseClass entity) {
		dao.save(entity);
	}

	/*
	public void deleteEducationLevel(EducationLevel entity) {
		dao.delete(entity);
	}*/
	//批量删除课程课类
	public boolean batchDeleteCourseClass(JSONObject courseClassIds) throws JSONException{
		return dao.batchDeleteCourseClass(courseClassIds);
	}

	//更新课程课类
	public void updateCourseClass(CourseClass entity) {
		dao.update(entity);

	}
   //通过Id获取课程课类信息
	public CourseClass getCourseClassById(String courseClassID) {
		return dao.getCourseClassById(courseClassID);
	}
	//获取所有课程课类信息
	public List<CourseClass> getAllCourseClasss(){
		return dao.getAllCourseClasss();
	}

	//获取最大的Id
	public int getMaxCourseClassId() {
		
		return dao.getMaxCourseClassId();
	}
	/**
     * 根据courseClass的属性来查找课程课类信息
     * @param property
     * 			课程类别属性
     * @param proValue
     * 			属性的值
     * @return
     * 			课程课类实体
     */
    public CourseClass getCourseClassByProperty(String property,String proValue,int id){
    	return dao.getCourseClassByProperty(property, proValue, id);
    }

	/**
	 * 根据courseTClass的属性来查找课程课类信息（没有id）
	 * @author yangyingjie
	 */
	public CourseClass getCourseClassByOneProperty(String property,
			String proValue) {
		return dao.getCourseClassByOneProperty(property, proValue);
	}
}
