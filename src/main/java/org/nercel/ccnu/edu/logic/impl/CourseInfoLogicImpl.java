package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.CourseInfoDao;
import org.nercel.ccnu.edu.entity.CourseInfoVO;
import org.nercel.ccnu.edu.entity.persist.CourseInfo;
import org.nercel.ccnu.edu.logic.CourseInfoLogic;


public class CourseInfoLogicImpl implements CourseInfoLogic {
	
	CourseInfoDao dao = new CourseInfoDao();

	/**
	 * 增加课程
	 */
	public void save(CourseInfo entity) {
		
		dao.save(entity);

	}

	/**
	 * 删除课程
	 */
	public void delete(CourseInfo entity) {
		dao.delete(entity);

	}

	/**
	 * 修改课程
	 */
	public void update(CourseInfo entity) {
		dao.update(entity);

	}
	
	/**
	 * 获取课程信息的最大的Id
	 */
	public int getMaxCourseInfoId() {
		return dao.getMaxCourseInfoId();
	}

	/**
	 * 获取所有课程的列表
	 */
	public List<CourseInfo> getAllCourseInfo() {
		return dao.getAllCourseInfo();
	}

	/**
	 * 根据课程ID获取课程信息
	 */
	public CourseInfo getCourseInfoById(int courseId) {
		return dao.getCourseInfoById(courseId);
	}

	/**
	 * 根据内部代码获取内部课程名称
	 */
	public String getCourseNameByCourseCode(String courseCode) {
		return dao.getCourseNameByCourseCode(courseCode);
	}

	/**
	 * 根据外部代码获取外部课程名称
	 */
	public String getCourseNameOutByCourseCodeOut(String courseCodeOut) {
		return dao.getCourseNameOutByCourseCodeOut(courseCodeOut);
	}

	/**
	 * 条件查询：获取课程管理的详细信息-分页查询
	 */
	public List<CourseInfoVO> getAllCourseInfoVOInPage(String courseCode,
			String courseName, String examTypeCode, String courseTypeCode,
			String courseClassCode, String stage, String scale, int pageNo,
			int pageSize) {
		return dao.getAllCourseInfoVOInPage(courseCode, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale, pageNo, pageSize);
	}

	/**
	 * 条件查询：获取课程管理的详细信息的总记录数
	 */
	public int getTotalCourseInfoVO(String courseCode, String courseName,
			String examTypeCode, String courseTypeCode, String courseClassCode,
			String stage, String scale) {
		return dao.getTotalCourseInfoVO(courseCode, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale);
	}

	/**
	 * 根据CourseInfo的属性来查找课程信息
	 */
	public CourseInfo getCourseInfoByProperty(String property, String proValue) {
		return dao.getCourseInfoByProperty(property, proValue);
	}

	/**
	 * 批量删除课程信息
	 */
	public boolean batchDeleteCourseInfo(JSONObject CourseIds) throws JSONException{
		
		return dao.batchDeleteCourseInfo(CourseIds);
	}



}
