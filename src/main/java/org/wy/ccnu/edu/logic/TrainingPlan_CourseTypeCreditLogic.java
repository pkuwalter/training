package org.wy.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.persist.TrainingPlan_CourseTypeCredit;

public interface TrainingPlan_CourseTypeCreditLogic {
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingPlan_CourseTypeCredit entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingPlan_CourseTypeCredit entity);
	/**
	 * 删除
	 * @param ids
	 * @throws JSONException 
	 */
	public void delete(String ids) throws JSONException;
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public TrainingPlan_CourseTypeCredit findOne(String id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingPlan_CourseTypeCredit> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	
	/**
	 * 根据培养计划id、课程类别代码和学生id来查询该培养计划该课程类别的最大选修学分
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别代码
	 * @param studentId
	 * 			学生id
	 * @return
	 * 			返回单个对象TrainingPlan_CourseTypeCredit
	 */
	public TrainingPlan_CourseTypeCredit getTPTypeCreditByPlanIdAndCodeAndStuId(
			String trainingPlanId, String courseTypeCode, String studentId) ;
	
	/**
	 * 根据培养计划id来查询其所有类别的课程的最大选修学分的信息
	 * @param trainingPlanId
	 * @return
	 */
	public List<TrainingPlan_CourseTypeCredit> getTrainingPlan_CourseTypeCreditByPlanId(String trainingPlanId);
}
