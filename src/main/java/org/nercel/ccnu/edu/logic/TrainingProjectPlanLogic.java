package org.nercel.ccnu.edu.logic;

import java.util.List;



import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TrainingProjectPlanVO;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectPlan;

public interface TrainingProjectPlanLogic {
	
	/**
	 * 增加培训计划信息
	 * 
	 * @param entity
	 */
	public void save(TrainingProjectPlan entity);
	
	
	/**
	 * 删除培训计划信息
	 * 
	 * @param entity
	 */
	public void delete(TrainingProjectPlan entity);
	

	/**
	 * 修改培训计划信息
	 * 
	 * @param entity
	 */
	public void update(TrainingProjectPlan entity);
	

	/**
	 * 获取培训计划信息的最大的Id
	 * 
	 * @return
	 */
	public int getMaxTrainingProjectPlanId();
	
	
	/**
	 * 获取所有培训计划的列表
	 * 
	 * @return
	 */
	public List<TrainingProjectPlan> getAllTrainingProjectPlan();
	

	/**
	 * 根据培训计划ID获取培训计划信息
	 * 
	 * @param TrainingProjectPlanId
	 * @return
	 */
	public TrainingProjectPlan getTrainingProjectPlanById(int trainingProjectPlanId);
	

	/**
	 * 根据TrainingProjectPlan的属性来查找培训计划信息
	 * 
	 * @param property培训计划属性
	 * @param proValue属性的值
	 * @return
	 */
	public TrainingProjectPlan getTrainingProjectPlanByProperty(String property,
			String proValue);

	
	/**
	 * 批量删除培训计划信息
	 * 
	 * @param trainingProjectPlanIds
	 * @return
	 * @throws JSONException
	 */
	public boolean batchDeleteTrainingProjectPlan(JSONObject trainingProjectPlanIds)
			throws JSONException;
	

	/**
	 * 条件查询：获取培训计划设置的详细信息
	 * 
	 * @param trainingProjectId
	 * @param trainingProjectCode
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<TrainingProjectPlanVO> getAllTrainingProjectPlanVOInPage(
			int trainingProjectId, String trainingProjectCode,
			int trainingBatchId, String coagencyId, String teachingUnitId,
			int pageNo, int pageSize);
	

	/**
	 * 条件查询：获取培训计划设置的总记录数
	 * 
	 * @param trainingProjectId
	 * @param trainingProjectCode
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitId
	 * @return
	 */
	public int getTotalTrainingProjectPlanVO(int trainingProjectId,
			String trainingProjectCode, int trainingBatchId, String coagencyId,
			String teachingUnitId);
	
	
	/**
	 * 根据项目id，批次id，合作机构id，教学点id，学科id，类别id获取费用价格
	 * @param trainingProjectId
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param specialId
	 * @param educationLevelId
	 * @return
	 */
	public int getFeeStandardByConditions(int trainingProjectId,
			int trainingBatchId, String coagencyId, String teachingUnitInfoId,
			String specialId, String educationLevelId);

}
