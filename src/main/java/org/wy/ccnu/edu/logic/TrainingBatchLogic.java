package org.wy.ccnu.edu.logic; 

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.TrainingBatchVO;
import org.wy.ccnu.edu.entity.TrainingBatch_teachingUnitInfoVO;
import org.wy.ccnu.edu.entity.persist.TrainingBatch;
import org.wy.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.wy.ccnu.edu.util.PageModel;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午4:24:40 
 * 类说明 
 */
public interface TrainingBatchLogic {
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingBatch entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingBatch entity);
	/**
	 * 删除
	 * @param ids
	 * @throws JSONException 
	 */
	public void delete(String ids) throws JSONException;
	public void deleteById(String id);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public TrainingBatch findOne(int id);
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingBatch> findAll();
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll();
	public int countAll(int trainingProjectId);
	public TrainingBatch findByProperty(String propertyName, Object value);
	public List<TrainingBatchVO> getTrainingBatchVOList();
	public PageModel<TrainingBatchVO> getTrainingBatchVOPage(int pageSize,int pageNo,int trainingProjectId);
	/**
	 * 根据培训项目id查询培训批次
	 * @param id 培训项目id
	 * @return 培训批次List
	 */
	public List<TrainingBatch> findByProjectId(String id);
	public TrainingProjectInfo findProjectByBatchId(String id);
	public List<TrainingBatch_teachingUnitInfoVO> findTrainingBatch_teachingUnitInfoVOBycoagencyId(String id);
	public List<TrainingBatch> findByIds(String ids);
	public TrainingBatch findByName(String name);
}
 