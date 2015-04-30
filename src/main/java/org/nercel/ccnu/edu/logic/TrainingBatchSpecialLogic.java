package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.TrainingSpecialDetailVO;
import org.nercel.ccnu.edu.entity.persist.EducationLevel;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectPlan;

public interface TrainingBatchSpecialLogic {
	public List<TrainingSpecialDetailVO> getAllSpecialList( String educationLevelId);
	public List<TrainingSpecialDetailVO> getSpecialByProjectAndBatchAndLevel(int trainingProjectId,int trainingBatchId, String educationLevelId);
	public int ifExistTrainingProjectPlanId(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId);
	public int getFeeStandard(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId);
	public List<EducationLevel>  findByProjectIdBatchId(int projectId,int batchId);
	public TrainingProjectPlan checkTrainingProjectPlan(int trainingProjectId,int trainingBatchId,String educationLevelId,String specialId);
	public void addTrainingProjectPlan(TrainingProjectPlan entity);
	public List<TrainingProjectPlan> getTrainingProjectPlanById(int id);
	public TrainingProjectPlan getTrainingProjectPlanByIdForDelete(int trainingProjectPlanId);
	public void delete(TrainingProjectPlan entity);
}
