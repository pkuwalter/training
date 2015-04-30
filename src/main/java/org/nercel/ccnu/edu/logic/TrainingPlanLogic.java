package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.entity.TrainingPlanVO;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan;

public interface TrainingPlanLogic {
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingPlan entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingPlan entity);
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
	public TrainingPlan findOne(String id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingPlan> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	/**
	 * 根据给定的属性及属性值来模糊查询培养计划
	 * @param property
	 * @param proValue
	 * @return
	 */
	public List<TrainingPlan> getTrainingPlanListByProperty(String property,String proValue);
	
	/**
	 * 根据给定的属性及属性值来查询指定的培养计划
	 * @param property
	 * @param proValue
	 * @return
	 */
	public TrainingPlan getTrainingPlanByProperty(String property,
			String proValue);
	
	/**
	 * 查找满足条件的培训计划库
	 * @param trainingProjectId
	 * 			所属项目id
	 * @param trainingProjectCode
	 * 			所属项目的代码
	 * @param trainingPlanId
	 * 			培训计划id
	 * @param trainingPlanCode
	 * 			培训计划代码
	 * @param specialID
	 * 			学科id
	 * @param eduLevelId
	 * 			培训类型id
	 * @param version
	 * 			培训计划版本
	 * @param beginTime
	 * 			开始时间
	 * @param endTime
	 * 			结束时间
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List<TrainingPlanVO> searchTrainingPlanInfo(
			int trainingProjectId, String trainingProjectCode,
			String trainingPlanId, String trainingPlanCode, String specialID,
			String eduLevelId, String version, String beginTime, String endTime,
			int pageSize, int pageNo);
	
	/**
	 * 查找满足条件的培训计划库的记录数
	 * @param trainingProjectId
	 * 			所属项目id
	 * @param trainingProjectCode
	 * 			所属项目的代码
	 * @param trainingPlanId
	 * 			培训计划id
	 * @param trainingPlanCode
	 * 			培训计划代码
	 * @param specialID
	 * 			学科id
	 * @param eduLevelId
	 * 			培训类型id
	 * @param version
	 * 			培训计划版本
	 * @param beginTime
	 * 			开始时间
	 * @param endTime
	 * 			结束时间
	 * @return
	 */
	public int countTrainingPlanInfo(
			int trainingProjectId, String trainingProjectCode,
			String trainingPlanId, String trainingPlanCode, String specialID,
			String eduLevelId, String version, String beginTime, String endTime);
}
