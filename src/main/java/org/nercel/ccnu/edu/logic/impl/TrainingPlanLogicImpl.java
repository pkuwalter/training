package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.TrainingPlanDao;
import org.nercel.ccnu.edu.dao.TrainingTypeDao;
import org.nercel.ccnu.edu.entity.TrainingPlanVO;
import org.nercel.ccnu.edu.entity.persist.CourseType;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan;
import org.nercel.ccnu.edu.entity.persist.TrainingType;
import org.nercel.ccnu.edu.logic.TrainingPlanLogic;
import org.nercel.ccnu.edu.logic.TrainingTypeLogic;

public class TrainingPlanLogicImpl implements TrainingPlanLogic {
	TrainingPlanDao dao = new TrainingPlanDao();

	/**
	 * 创建
	 * 
	 * @param entity
	 */
	public void create(TrainingPlan entity) {
		dao.save(entity);

	};

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(TrainingPlan entity) {
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
	public TrainingPlan findOne(String id) {
		return dao.getById(id);

	};

	/**
	 * 所有记录
	 * 
	 * @return
	 */
	public List<TrainingPlan> findAll() {
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
	 * 根据给定的属性及属性值来模糊查询培养计划列表
	 * @param property
	 * @param proValue
	 * @return
	 */
	public List<TrainingPlan> getTrainingPlanListByProperty(String property,
			String proValue) {
		return dao.getTrainingPlanListByProperty(property, proValue);
	}
	
	/**
	 * 根据给定的属性及属性值来查询指定的培养计划
	 * @param property
	 * @param proValue
	 * @return
	 */
	public TrainingPlan getTrainingPlanByProperty(String property,
			String proValue){
		return dao.getTrainingPlanByProperty(property, proValue);
	}

	/**
	 * 查找满足条件的培训计划库
	 * 
	 * @param trainingProjectId
	 *            所属项目id
	 * @param trainingProjectCode
	 *            所属项目的代码
	 * @param trainingPlanId
	 *            培训计划id
	 * @param trainingPlanCode
	 *            培训计划代码
	 * @param specialID
	 *            学科id
	 * @param eduLevelId
	 *            培训类型id
	 * @param version
	 *            培训计划版本
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List<TrainingPlanVO> searchTrainingPlanInfo(
			int trainingProjectId, String trainingProjectCode,
			String trainingPlanId, String trainingPlanCode, String specialID,
			String eduLevelId, String version, String beginTime,
			String endTime, int pageSize, int pageNo) {
		return dao.searchTrainingPlanInfo(trainingProjectId,
				trainingProjectCode, trainingPlanId, trainingPlanCode,
				specialID, eduLevelId, version, beginTime, endTime,
				pageSize, pageNo);
	}

	/**
	 * 查找满足条件的培训计划库的记录数
	 * 
	 * @param trainingProjectId
	 *            所属项目id
	 * @param trainingProjectCode
	 *            所属项目的代码
	 * @param trainingPlanId
	 *            培训计划id
	 * @param trainingPlanCode
	 *            培训计划代码
	 * @param specialID
	 *            学科id
	 * @param eduLevelId
	 *            培训类型id
	 * @param version
	 *            培训计划版本
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	public int countTrainingPlanInfo(int trainingProjectId,
			String trainingProjectCode, String trainingPlanId,
			String trainingPlanCode, String specialID, String eduLevelId,
			String version, String beginTime, String endTime) {
		return dao.countTrainingPlanInfo(trainingProjectId,
				trainingProjectCode, trainingPlanId, trainingPlanCode,
				specialID, eduLevelId, version, beginTime, endTime);
	}

}
