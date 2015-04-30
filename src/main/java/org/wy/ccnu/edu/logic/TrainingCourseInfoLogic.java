package org.wy.ccnu.edu.logic;

import java.util.List;

import org.wy.ccnu.edu.entity.persist.TrainingCourseInfo;

public interface TrainingCourseInfoLogic {
	
	/**
	 * 增加培训课程信息
	 * 
	 * @param entity
	 */
	public void save(TrainingCourseInfo entity);

	/**
	 * 删除培训课程信息
	 * 
	 * @param entity
	 */
	public void delete(TrainingCourseInfo entity); 
	
	/**
	 * 修改培训课程信息
	 * 
	 * @param entity
	 */
	public void update(TrainingCourseInfo entity);
	
	/**
	 * 获取培训课程信息的最大的Id
	 * @return
	 */
	public int getMaxTrainingCourseInfoId();

	/**
	 * 获取所有培训课程的列表
	 * 
	 * @return
	 */
	public List<TrainingCourseInfo> getAllTrainingCourseInfo();

	/**
	 * 根据ID获取培训课程信息
	 * 
	 * @param id
	 * @return
	 */
	public TrainingCourseInfo getTrainingCourseInfoById(int id);

}
