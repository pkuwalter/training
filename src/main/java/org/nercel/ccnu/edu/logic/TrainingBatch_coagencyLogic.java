package org.nercel.ccnu.edu.logic; 

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.entity.TrainingBatch_coagencyVO;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch_coagency;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午4:26:17 
 * 类说明 
 */
public interface TrainingBatch_coagencyLogic {
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingBatch_coagency entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingBatch_coagency entity);
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
	public TrainingBatch_coagency findOne(String id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingBatch_coagency> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	public TrainingBatch_coagency findByProperty(String propertyName, Object value);

	/**
	 * 通过批次ID获得所有记录
	 */
	public List<TrainingBatch_coagency> findAllByBatchId(int id);
	public List<TrainingBatch_coagencyVO> getTrainingBatch_coagencyVOListById(int id);
	public List<Coagency> getUseCoagency(String id);
	public List<Coagency> getUnuseCoagency(String id);
}
 