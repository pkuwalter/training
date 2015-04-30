package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.dao.TrainingPlan_StudentDao;
import org.nercel.ccnu.edu.entity.TrainingPlan_StudentVO;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan_Student;
import org.nercel.ccnu.edu.logic.TrainingPlan_StudentLogic;

public class TrainingPlan_StudentLogicImpl implements TrainingPlan_StudentLogic {

	TrainingPlan_StudentDao dao = new TrainingPlan_StudentDao();

	public void save(TrainingPlan_Student entity) {
		dao.save(entity);
	}

	public void update(TrainingPlan_Student entity) {
		dao.update(entity);
	}

	public TrainingPlan_Student getById(String id) {
		return dao.getById(id);
	}

	public boolean batchDeleteByIds(String ids) {
		return dao.batchDeleteByIds(ids);
	}
	
	/**
	 * 根据条件查询学生培训计划信息
	 * @param trainingProjectId
	 * @param trainingPlanId
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
	public List<TrainingPlan_StudentVO> getTrainingPlan_StudentByConditions(
			int trainingProjectId, String trainingPlanId,
			String teachingPlanTemplateId, int trainingBatchId,
			int stuInputType, String stuInputValue, String coagencyId,
			String teachingUnitInfoId, String educationLevelId,
			String specialId, int pageNo, int pageSize) {
		return dao.getTrainingPlan_StudentByConditions(trainingProjectId,
				trainingPlanId, teachingPlanTemplateId, trainingBatchId,
				stuInputType, stuInputValue, coagencyId, teachingUnitInfoId,
				educationLevelId, specialId, pageNo, pageSize);
	}

	/**
	 * 根据条件查询学生培训计划信息记录数
	 * @param trainingProjectId
	 * @param trainingPlanId
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
	public int getRecordsOfTrainingPlan_StudentByConditions(
			int trainingProjectId, String trainingPlanId,
			String teachingPlanPemplateId, int trainingBatchId,
			int stuInputType, String stuInputValue, String coagencyId,
			String teachingUnitInfoId, String educationLevelId, String specialId) {
		return dao.getRecordsOfTrainingPlan_StudentByConditions(
				trainingProjectId, trainingPlanId, teachingPlanPemplateId,
				trainingBatchId, stuInputType, stuInputValue, coagencyId,
				teachingUnitInfoId, educationLevelId, specialId);
	}

	/**
	 * 批量设置学生培训计划
	 * @param ids						--学生培训计划ids
	 * @param trainingPlanId				--培训计划库id
	 * @param teachingPlanPemplateId	--培训计划模板库id
	 */
	public void batchUpdateTrainingPlan_Student(String ids,
			String trainingPlanId, String teachingPlanPemplateId) {
		dao.batchUpdateTrainingPlan_Student(ids, trainingPlanId,
				teachingPlanPemplateId);
	}

}
