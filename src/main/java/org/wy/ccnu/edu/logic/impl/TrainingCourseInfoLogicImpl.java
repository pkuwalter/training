package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.wy.ccnu.edu.dao.TrainingCourseInfoDao;
import org.wy.ccnu.edu.entity.persist.TrainingCourseInfo;
import org.wy.ccnu.edu.logic.TrainingCourseInfoLogic;

public class TrainingCourseInfoLogicImpl implements TrainingCourseInfoLogic {

	TrainingCourseInfoDao dao = new TrainingCourseInfoDao();
	
	/**
	 * 增加培训课程信息
	 */
	public void save(TrainingCourseInfo entity) {
		dao.save(entity);

	}

	/**
	 * 删除培训课程信息
	 */
	public void delete(TrainingCourseInfo entity) {
		dao.delete(entity);

	}

	/**
	 * 修改培训课程信息
	 */
	public void update(TrainingCourseInfo entity) {
		dao.update(entity);

	}

	/**
	 * 获取培训课程信息的最大的Id
	 */
	public int getMaxTrainingCourseInfoId() {
		return dao.getMaxTrainingCourseInfoId();
	}

	/**
	 * 获取所有培训课程的列表
	 */
	public List<TrainingCourseInfo> getAllTrainingCourseInfo() {
		return dao.getAllTrainingCourseInfo();
	}

	/**
	 * 根据ID获取培训课程信息
	 */
	public TrainingCourseInfo getTrainingCourseInfoById(int id) {
		return dao.getTrainingCourseInfoById(id);
	}

}
