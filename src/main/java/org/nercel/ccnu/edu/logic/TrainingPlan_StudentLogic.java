package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.TrainingPlan_StudentVO;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan_Student;

public interface TrainingPlan_StudentLogic {
	public void save(TrainingPlan_Student entity);
	public void update(TrainingPlan_Student entity);
	public TrainingPlan_Student getById(String id);
	public boolean batchDeleteByIds(String ids);
	
	/**
	 * 根据条件查询学生培训计划信息
	 * @param trainingProjectId
	 * @param traningPlanId
	 * @param teachingPlanPemplateId
	 * @param trainingBatchId
	 * @param stuInputType
	 * @param stuInputValue
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param educationLevelId
	 * @param specialId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<TrainingPlan_StudentVO> getTrainingPlan_StudentByConditions(int trainingProjectId,
			String traningPlanId,String teachingPlanTemplateId,int trainingBatchId, int stuInputType,
			String stuInputValue,String coagencyId,String teachingUnitInfoId,String educationLevelId,
			String specialId,int pageNo,int pageSize);
	
	/**
	 * 根据条件查询学生培训计划信息记录数
	 * @param trainingProjectId
	 * @param traningPlanId
	 * @param teachingPlanPemplateId
	 * @param trainingBatchId
	 * @param stuInputType
	 * @param stuInputValue
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param educationLevelId
	 * @param specialId
	 * @return
	 */
	public int getRecordsOfTrainingPlan_StudentByConditions(int trainingProjectId,
			String traningPlanId,String teachingPlanPemplateId,int trainingBatchId, int stuInputType,
			String stuInputValue,String coagencyId,String teachingUnitInfoId,String educationLevelId,
			String specialId);
	
	/**
	 * 批量设置学生培训计划
	 * @param ids						--学生培训计划ids
	 * @param traningPlanId				--培训计划库id
	 * @param teachingPlanPemplateId	--培训计划模板库id
	 */
	public void batchUpdateTrainingPlan_Student(String ids, String trainingPlanId,String teachingPlanPemplateId);
}
