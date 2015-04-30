package org.nercel.ccnu.edu.logic;

import java.util.List;



import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.CourseInfoVO;
import org.nercel.ccnu.edu.entity.persist.CourseInfo;

public interface CourseInfoLogic {
	
	/**
	 * 增加课程
	 * 
	 * @param entity
	 */
	public void save(CourseInfo entity);

	/**
	 * 删除课程
	 * 
	 * @param entity
	 */
	public void delete(CourseInfo entity);

	/**
	 * 修改课程信息
	 * 
	 * @param entity
	 */
	public void update(CourseInfo entity);
	
	/**
	 * 获取课程信息的最大的Id
	 */
	public int getMaxCourseInfoId();


	/**
	 * 获取所有课程的列表
	 * 
	 * @return
	 */
	public List<CourseInfo> getAllCourseInfo() ;

	/**
	 * 根据课程ID获取课程信息
	 * 
	 * @param CourseId
	 * @return
	 */
	public CourseInfo getCourseInfoById(int courseId);

	/**
	 * 根据内部代码获取内部课程名称
	 * 
	 * @param courseCode
	 * @return
	 */
	public String getCourseNameByCourseCode(String courseCode);

	/**
	 * 根据外部代码获取外部课程名称
	 * 
	 * @param courseCodeOut
	 * @return
	 */
	public String getCourseNameOutByCourseCodeOut(String courseCodeOut);

	
	/**
	 * 条件查询：获取课程管理的详细信息-分页查询
	 * @param courseCode		课程代码（内部）
	 * @param courseName		课程名称（内部）（模糊查询）
	 * @param examTypeCode		考试方式
	 * @param courseTypeCode	课程类别
	 * @param courseClassCode	课程课类
	 * @param stage				学习阶段（开课学期）
	 * @param scale				适用对象（模糊查询）
	 * @param pageNo			
	 * @param pageSize			
	 * @return
	 */
	public List<CourseInfoVO> getAllCourseInfoVOInPage(String courseCode,
			String courseName, String examTypeCode, String courseTypeCode,
			String courseClassCode, String stage, String scale, int pageNo,
			int pageSize);
	/**
	 * 条件查询：获取课程管理的详细信息的总记录数
	 * @param courseCode
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @return
	 */
	public int getTotalCourseInfoVO(String courseCode, String courseName,
			String examTypeCode, String courseTypeCode, String courseClassCode,
			String stage, String scale);
	
	
	/**
	 * 根据CourseInfo的属性来查找课程信息
	 * @param property课程属性
	 * @param proValue属性的值
	 * @return
	 */
    public CourseInfo getCourseInfoByProperty(String property,String proValue);
    
    /**
     * 批量删除课程
     * @param CourseIds
     * @return
     * @throws JSONException 
     */
	public boolean batchDeleteCourseInfo(JSONObject CourseIds) throws JSONException;
	

}
