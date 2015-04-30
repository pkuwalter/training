package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.TrainingPlan_CourseInfoDao;
import org.wy.ccnu.edu.entity.TrainingPlanCourseInfoVO;
import org.wy.ccnu.edu.entity.persist.CourseType;
import org.wy.ccnu.edu.entity.persist.TrainingPlan_CourseInfo;
import org.wy.ccnu.edu.logic.TrainingPlan_CourseInfoLogic;

public class TrainingPlan_CourseInfoLogicImpl implements TrainingPlan_CourseInfoLogic {
	
	TrainingPlan_CourseInfoDao dao = new TrainingPlan_CourseInfoDao();

	/**
	 * 创建
	 * 
	 * @param entity
	 */
	public void create(TrainingPlan_CourseInfo entity) {
		dao.save(entity);

	};

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(TrainingPlan_CourseInfo entity) {
		dao.update(entity);
	};

	/**
	 * 删除
	 * 
	 * @param ids
	 * @throws JSONException
	 */
	public void delete(String ids) throws JSONException {
		dao.delete(ids);
	};

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	public TrainingPlan_CourseInfo findOne(String id) {
		return dao.getById(id);

	};

	/**
	 * 所有记录
	 * 
	 * @return
	 */
	public List<TrainingPlan_CourseInfo> findAll() {
		return dao.getAll();

	};

	/**
	 * 记录总数
	 * 
	 * @return
	 */
	public int countAll() {
		return dao.countAll();

	};

	/**
	 * 根据给定的属性及属性值来查询指定的培养计划课程信息
	 * @param property
	 * @param proValue
	 * @return
	 */
	public TrainingPlan_CourseInfo getTrainingPlan_CourseInfoByProperty(String property,
			String proValue){
		return dao.getTrainingPlan_CourseInfoByProperty(property, proValue);
	}

	/**
	  * 根据培养计划 的id、课程类别的code和学生id查询培养计划课程信息
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别code
	 * @param studentId
	 * 			学生id
	 * @return
	 * 			培养计划课程信息列表List
	 */
	public List<TrainingPlanCourseInfoVO> getTPCourseVOByPlanIdAndCodeAndStuId(
			String trainingPlanId, String courseTypeCode, String studentId) {
		return dao.getTPCourseVOByPlanIdAndCodeAndStuId(trainingPlanId, courseTypeCode, studentId);
	}
	
	/**
	 * 根据培养计划id和课程类别代码来查询该培养计划该课程类别已经选修的学分
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别代码
	 * @return
	 * 			返回countCredit
	 */
	public int countCreditOfChooseCourseType(String trainingPlanId, String courseTypeCode) {
		return dao.countCreditOfChooseCourseType(trainingPlanId, courseTypeCode);
	}
	
	/**
	 * 根据培养计划id来查询课程信息列表
	 * @param trainingPlanId
	 * 			培养计划id
	 * @return
	 * 			List<TrainingPlan_CourseInfo>
	 */
	public List<TrainingPlan_CourseInfo> getTrainingPlan_CourseInfoByPlanId(String trainingPlanId){
		return dao.getTrainingPlan_CourseInfoByPlanId(trainingPlanId);
	}
}
