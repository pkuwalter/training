package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.TrainingProjectPlanDao;
import org.nercel.ccnu.edu.entity.TrainingProjectPlanVO;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectPlan;
import org.nercel.ccnu.edu.logic.TrainingProjectPlanLogic;

public class TrainingProjectPlanLogicImpl implements TrainingProjectPlanLogic {

	TrainingProjectPlanDao dao = new TrainingProjectPlanDao();
	
	public void save(TrainingProjectPlan entity) {
		
		dao.save(entity);

	}

	public void delete(TrainingProjectPlan entity) {
		
		dao.delete(entity);

	}

	public void update(TrainingProjectPlan entity) {
		
		dao.update(entity);

	}

	public int getMaxTrainingProjectPlanId() {
		
		return dao.getMaxTrainingProjectPlanId();
		
	}

	public List<TrainingProjectPlan> getAllTrainingProjectPlan() {
		
		return dao.getAllTrainingProjectPlan();
		
	}

	public TrainingProjectPlan getTrainingProjectPlanById(
			int trainingProjectPlanId) {
		
		return dao.getTrainingProjectPlanById(trainingProjectPlanId);
		
	}

	public TrainingProjectPlan getTrainingProjectPlanByProperty(
			String property, String proValue) {
		
		return dao.getTrainingProjectPlanByProperty(property, proValue);
		
	}

	public boolean batchDeleteTrainingProjectPlan(
			JSONObject trainingProjectPlanIds) throws JSONException {
		
		return dao.batchDeleteTrainingProjectPlan(trainingProjectPlanIds);
		
	}

	public List<TrainingProjectPlanVO> getAllTrainingProjectPlanVOInPage(
			int trainingProjectId, String trainingProjectCode,
			int trainingBatchId, String coagencyId, String teachingUnitId,
			int pageNo, int pageSize) {
		
		return dao.getAllTrainingProjectPlanVOInPage(trainingProjectId, trainingProjectCode, trainingBatchId, coagencyId, teachingUnitId, pageNo, pageSize);
		
	}

	public int getTotalTrainingProjectPlanVO(int trainingProjectId,
			String trainingProjectCode, int trainingBatchId, String coagencyId,
			String teachingUnitId) {
		
		return dao.getTotalTrainingProjectPlanVO(trainingProjectId, trainingProjectCode, trainingBatchId, coagencyId, teachingUnitId);
		
	}

	
	public int getFeeStandardByConditions(int trainingProjectId,
			int trainingBatchId, String coagencyId, String teachingUnitInfoId,
			String specialId, String educationLevelId) {
		return dao.getFeeStandardByConditions(trainingProjectId, trainingBatchId, coagencyId, teachingUnitInfoId, specialId, educationLevelId);
	}

}
