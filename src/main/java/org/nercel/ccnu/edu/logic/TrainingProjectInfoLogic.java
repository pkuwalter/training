package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.entity.TrainingProjectInfoVO;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectInfo;

public interface TrainingProjectInfoLogic {
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingProjectInfo entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingProjectInfo entity);
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
	public TrainingProjectInfo findOne(int id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingProjectInfo> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	public TrainingProjectInfo findByProperty(String propertyName, Object value);
	public List<TrainingProjectInfoVO> getTrainingProjectInfoVOList();
	public List<TrainingProjectInfo> entityLsit();
	public List<TrainingProjectInfo> findByName(String name);

}
