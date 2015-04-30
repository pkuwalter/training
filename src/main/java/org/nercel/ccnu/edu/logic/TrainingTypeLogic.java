package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.CourseType;
import org.nercel.ccnu.edu.entity.persist.TrainingType;

public interface TrainingTypeLogic {
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingType entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingType entity);
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
	public TrainingType findOne(int id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingType> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	public TrainingType getTrainingTypeByProperty(String property,String proValue,int id);
}
