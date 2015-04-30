package org.wy.ccnu.edu.logic;

import java.util.List;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.CourseInfoVO;
import org.wy.ccnu.edu.entity.SpecialCourseVO;
import org.wy.ccnu.edu.entity.persist.CourseInfo;
import org.wy.ccnu.edu.entity.persist.SpecialCourse;

public interface SpecialCourseLogic {
	
	/**
	 * 增加学科课程
	 * 
	 * @param entity
	 */
	public void save(SpecialCourse entity);
	

	/**
	 * 删除学科课程
	 * 
	 * @param entity
	 */
	public void delete(SpecialCourse entity);
	

	/**
	 * 修改学科课程信息
	 * 
	 * @param entity
	 */
	public void update(SpecialCourse entity);
	

	/**
	 * 获取学科课程信息的最大的Id
	 * 
	 * @return
	 */
	public int getMaxSpecialCourseId() ;
	

	/**
	 * 获取所有学科课程的列表
	 * 
	 * @return
	 */
	public List<SpecialCourse> getAllSpecialCourse() ;
	

	/**
	 * 根据学科课程ID获取学科课程信息
	 * 
	 * @param specialCourseId
	 * @return
	 */
	public SpecialCourse getSpecialCourseById(int specialCourseId);
	

	/**
	 * 根据SpecialCourse的属性来查找学科课程信息
	 * 
	 * @param property课程属性
	 * @param proValue属性的值
	 * @return
	 */
	public SpecialCourse getSpecialCourseByProperty(String property,
			String proValue);

	
	/**
	 * 批量删除学科课程信息
	 * 
	 * @param SpecialCourseIds
	 * @return
	 * @throws JSONException
	 */
	public boolean batchDeleteSpecialCourse(JSONObject SpecialCourseIds) throws JSONException;
	

	/**
	 * 条件查询：获取学科课程管理的详细信息-分页查询
	 * 
	 * @param specialId
	 *            专业id
	 * @param courseName
	 *            课程名称（内部）（模糊查询）
	 * @param examTypeCode
	 *            考试方式
	 * @param courseTypeCode
	 *            课程类别
	 * @param courseClassCode
	 *            课程课类
	 * @param stage
	 *            学习阶段（开课学期）
	 * @param scale
	 *            适用对象（模糊查询）
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CourseInfoVO> getAllSpecialCourseInfoVOInPage(String specialId,
			String courseName, String examTypeCode, String courseTypeCode,
			String courseClassCode, String stage, String scale, int pageNo,
			int pageSize) ;
	
	/**
	 * 条件查询：获取学科课程管理的详细信息的总记录数
	 * 
	 * @param specialId
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @return
	 */
	public int getTotalSpecialCourseInfoVO(String specialId, String courseName,
			String examTypeCode, String courseTypeCode, String courseClassCode,
			String stage, String scale) ;
	
	
	/**
	 * 根据专业id获取课程id与课程名称列表
	 * @param specialId
	 * @return
	 */
	public List<SpecialCourseVO> getSpecialCourseVOListBySpecialId(String specialId);
	
	/**
	 * 根据专业id和课程id获取学科课程
	 * @param specialId
	 * @param courseId
	 * @return
	 */
	public SpecialCourse getSpecialCourseBySpecialIdAndCourseId(String specialId,
			int courseId);
	
	/**
	 * 根据专业id列表获取课程列表
	 * @param specialIds
	 * @return
	 */
	public List<CourseInfo> getCourseInfoListBySpecialIds(String specialIds);

}
