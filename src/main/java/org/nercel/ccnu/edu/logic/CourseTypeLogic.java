package org.nercel.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.CourseType;
import org.nercel.ccnu.edu.entity.persist.ProvinceInfo;


public interface CourseTypeLogic {
	//增加课程类别
	public void addCourseType(CourseType entity);
	//批量删除课程类别
	public boolean batchDeleteCourseType(JSONObject courseTypeIds) throws JSONException;	
	//更新课程类别
	public void updateCourseType(CourseType entity);
	//通过Id获取课程类别
	public CourseType getCourseTypeById(String courseTypeID);
	//获取所有课程类别
	public List<CourseType> getAllCourseTypes();
    //获取最大Id
		public int getMaxCourseTypeId();
		/**
	     * 根据courseType的属性来查找课程类别信息
	     * @param property
	     * 			课程类别属性
	     * @param proValue
	     * 			属性的值
	     * @return
	     * 		课程类别实体
	     */
	    public CourseType getCourseTypeByProperty(String property,String proValue,int id);
	    
	    /**
	     * 根据courseType的属性来查找课程类别信息（参数有两个，没有id）
	     * @author yangyingjie
	     * @param property
	     * @param proValue
	     * @return
	     */
	    public CourseType getCourseTypeByOneProperty(String property,String proValue);
	    
}
