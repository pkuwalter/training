package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.wy.ccnu.edu.dao.TrainingBatchSpecialDao;
import org.wy.ccnu.edu.entity.TrainingSpecialDetailVO;
import org.wy.ccnu.edu.entity.persist.EducationLevel;
import org.wy.ccnu.edu.entity.persist.TrainingProjectPlan;
import org.wy.ccnu.edu.logic.TrainingBatchSpecialLogic;

public class TrainingBatchSpecialLogicImpl implements TrainingBatchSpecialLogic {

	private TrainingBatchSpecialDao dao = new TrainingBatchSpecialDao();

	public List<TrainingSpecialDetailVO> getAllSpecialList(String educationLevelId) {
		return dao.getAllSpecialList(educationLevelId);
	}

	
	  public List<TrainingSpecialDetailVO> getSpecialByProjectAndBatchAndLevel(
	  int trainingProjectId,int trainingBatchId, String educationLevelId) {
	  return
	  dao.getSpecialByProjectAndBatchAndLevel(trainingProjectId,trainingBatchId
	  , educationLevelId); }
	 

	public List<EducationLevel> findByProjectIdBatchId(int projectId,
			int batchId) {
		return dao.findByProjectIdBatchId(projectId, batchId);
	}

	public int ifExistTrainingProjectPlanId(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId) {
		return dao.ifExistTrainingProjectPlanId(trainingProjectId,
				trainingBatchId, educationLevelId, specialId);
	}

	public int getFeeStandard(int trainingProjectId, int trainingBatchId,
			String educationLevelId, String specialId) {
		return dao.getFeeStandard(trainingProjectId, trainingBatchId,
				educationLevelId, specialId);
	}

	public TrainingProjectPlan checkTrainingProjectPlan(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId) {
		return dao.checkTrainingProjectPlan(trainingProjectId, trainingBatchId,
				educationLevelId, specialId);
	}

	public void addTrainingProjectPlan(TrainingProjectPlan entity) {
		dao.save(entity);
	}

	public List<TrainingProjectPlan> getTrainingProjectPlanById(int id) {
		return dao.getTrainingProjectPlanById(id);
	}

	public TrainingProjectPlan getTrainingProjectPlanByIdForDelete(
			int trainingProjectPlanId) {
		return dao.getTrainingProjectPlanByIdForDelete(trainingProjectPlanId);

	}

	public void delete(TrainingProjectPlan entity) {
		dao.delete(entity);

	}
}
