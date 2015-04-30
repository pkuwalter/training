package org.nercel.ccnu.edu.logic; 

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch_teachingUnitInfo;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午4:27:16 
 * 类说明 
 */
public interface TrainingBatch_teachingUnitInfoLogic {

	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingBatch_teachingUnitInfo entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingBatch_teachingUnitInfo entity);
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
	public TrainingBatch_teachingUnitInfo findOne(String id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingBatch_teachingUnitInfo> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	public TrainingBatch_teachingUnitInfo findByProperty(String propertyName, Object value);
	public List<TrainingBatch_teachingUnitInfo> findAllByBatchId(int id);
	public List<TeachingUnitInfo> getUseTeachingUnitInfo(String id);
	public  List<TrainingBatch_teachingUnitInfo> findByCoId(String id);
	public TrainingBatch_teachingUnitInfo findByTeachingUnitId(String id);
}
 