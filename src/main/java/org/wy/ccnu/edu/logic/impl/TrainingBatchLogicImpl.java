package org.wy.ccnu.edu.logic.impl; 

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.dao.TrainingBatchDao;
import org.wy.ccnu.edu.entity.TrainingBatchVO;
import org.wy.ccnu.edu.entity.TrainingBatch_teachingUnitInfoVO;
import org.wy.ccnu.edu.entity.persist.TrainingBatch;
import org.wy.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.wy.ccnu.edu.logic.TrainingBatchLogic;
import org.wy.ccnu.edu.util.PageModel;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午4:29:18 
 * 类说明 
 */
public class TrainingBatchLogicImpl implements TrainingBatchLogic{
	TrainingBatchDao dao=new TrainingBatchDao();
	public void create(TrainingBatch entity) {
		
		dao.save(entity);
	}

	public void update(TrainingBatch entity) {
		dao.update(entity);
		
	}

	public void delete(String ids) throws JSONException {
		dao.delete(ids);
		
	}
	public void deleteById(String id) {
		dao.deleteById(id);
	}

	public TrainingBatch findOne(int id) {
		return dao.getById(id);
	}

	public List<TrainingBatch> findAll() {
		return dao.getAll();
	}

	public int countAll() {
		return dao.countAll();
	}
	public int countAll(int trainingProjectId){
		return dao.countAll(trainingProjectId);
	}

	public TrainingBatch findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}
	public List<TrainingBatchVO> getTrainingBatchVOList(){
		return dao.getTrainingBatchVOList();
	}
	public PageModel<TrainingBatchVO> getTrainingBatchVOPage(int pageSize,int pageNo,int trainingProjectId){
		PageModel<TrainingBatchVO> pageModel=new PageModel<TrainingBatchVO>();
		int count=dao.countAll(trainingProjectId);
		if(count!=0){
			List<TrainingBatchVO> entityList=dao.getTrainingBatchVOPage(pageSize, pageNo, trainingProjectId);
			pageModel.setList(entityList);
		}
		pageModel.setTotalRecords(count);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}

	/**
	 * 根据培训项目id查询培训批次
	 * @param id 培训项目id
	 * @return 培训批次List
	 */
	public List<TrainingBatch> findByProjectId(String id){
		return dao.findByProjectId(id);
	}
	public TrainingProjectInfo findProjectByBatchId(String id){
		return dao.findProjectByBatchId(id);
	}
	public List<TrainingBatch_teachingUnitInfoVO> findTrainingBatch_teachingUnitInfoVOBycoagencyId(String id){
		return dao.findTrainingBatch_teachingUnitInfoVOBycoagencyId(id);
	}
	public List<TrainingBatch> findByIds(String ids){
		return dao.findByIds(ids);
	}
	public TrainingBatch findByName(String name){
		return dao.findByName(name);
	}
}
 