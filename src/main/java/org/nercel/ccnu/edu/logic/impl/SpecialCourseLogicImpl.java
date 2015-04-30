package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.SpecialCourseDao;
import org.nercel.ccnu.edu.entity.CourseInfoVO;
import org.nercel.ccnu.edu.entity.SpecialCourseVO;
import org.nercel.ccnu.edu.entity.persist.CourseInfo;
import org.nercel.ccnu.edu.entity.persist.SpecialCourse;
import org.nercel.ccnu.edu.logic.SpecialCourseLogic;

public class SpecialCourseLogicImpl implements SpecialCourseLogic {
	
	SpecialCourseDao dao = new SpecialCourseDao();

	
	public void save(SpecialCourse entity) {

		dao.save(entity);
		
	}


	public void delete(SpecialCourse entity) {
		dao.delete(entity);

	}

	public void update(SpecialCourse entity) {
		dao.update(entity);

	}

	public int getMaxSpecialCourseId() {
		return dao.getMaxSpecialCourseId();
	}

	public List<SpecialCourse> getAllSpecialCourse() {
		return dao.getAllSpecialCourse();
	}

	public SpecialCourse getSpecialCourseById(int specialCourseId) {
		return dao.getSpecialCourseById(specialCourseId);
	}

	public SpecialCourse getSpecialCourseByProperty(String property,
			String proValue) {
		return dao.getSpecialCourseByProperty(property, proValue);
	}

	public boolean batchDeleteSpecialCourse(JSONObject SpecialCourseIds) throws JSONException {
		return dao.batchDeleteSpecialCourse(SpecialCourseIds);
	}

	public List<CourseInfoVO> getAllSpecialCourseInfoVOInPage(String specialId,
			String courseName, String examTypeCode, String courseTypeCode,
			String courseClassCode, String stage, String scale, int pageNo,
			int pageSize) {
		return dao.getAllSpecialCourseInfoVOInPage(specialId, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale, pageNo, pageSize);
	}

	public int getTotalSpecialCourseInfoVO(String specialId, String courseName,
			String examTypeCode, String courseTypeCode, String courseClassCode,
			String stage, String scale) {
		return dao.getTotalSpecialCourseInfoVO(specialId, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale);
	}


	/**
	 * 根据专业id获取课程列表
	 */
	public List<SpecialCourseVO> getSpecialCourseVOListBySpecialId(
			String specialId) {
		return dao.getSpecialCourseVOListBySpecialId(specialId);
	}


	/**
	 * 根据专业id和课程id获取学科课程
	 */
	public SpecialCourse getSpecialCourseBySpecialIdAndCourseId(
			String specialId, int courseId) {
		return dao.getSpecialCourseBySpecialIdAndCourseId(specialId, courseId);
	}


	/**
	 * 根据专业id列表获取课程列表
	 */
	public List<CourseInfo> getCourseInfoListBySpecialIds(String specialIds) {
		
		return dao.getCourseInfoListBySpecialIds(specialIds);
	}

	
	
}
