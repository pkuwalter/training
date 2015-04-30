package org.wy.ccnu.edu.logic;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CourseClass;



public interface CourseClassLogic {
	//增加课程课类
	public void addCourseClass(CourseClass entity);
	//批量删除课程课类
	public boolean batchDeleteCourseClass(JSONObject courseClassIds) throws JSONException;	
	//更新课程课类
	public void updateCourseClass(CourseClass entity);
	//通过Id找到课程课类对象
	public CourseClass getCourseClassById(String courseClassID);
	//获取所有课程课类
	public List<CourseClass> getAllCourseClasss();

	//获取最大的课程课类的Id
		public int getMaxCourseClassId();
		/**
	     * 根据courseClass的属性来查找课程类别信息
	     * @param property
	     * 			课程类别属性
	     * @param proValue
	     * 			属性的值
	     * @return
	     * 		课程类别实体
	     */
	    public CourseClass getCourseClassByProperty(String property,String proValue,int id);
	    
	    
	    /**
	     * 根据courseTClass的属性来查找课程课类信息（没有id）
	     * @author yangyingjie
	     * @param property
	     * @param proValue
	     * @return
	     */
	    public CourseClass getCourseClassByOneProperty(String property,String proValue);
	    
}
