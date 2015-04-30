package org.nercel.ccnu.edu.logic.impl; 

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.dao.TrainingBatch_coagencyDao;
import org.nercel.ccnu.edu.entity.TrainingBatch_coagencyVO;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.nercel.ccnu.edu.logic.TrainingBatch_coagencyLogic;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午4:31:11 
 * 类说明 
 */
public class TrainingBatch_coagencyLogicImpl implements TrainingBatch_coagencyLogic{
	TrainingBatch_coagencyDao dao=new TrainingBatch_coagencyDao();
	public void create(TrainingBatch_coagency entity) {
		
		dao.save(entity);
	}

	public void update(TrainingBatch_coagency entity) {
		dao.update(entity);
		
	}

	public void delete(String ids) throws JSONException {
		dao.delete(ids);
		
	}

	public TrainingBatch_coagency findOne(String id) {
		return dao.getById(id);
	}

	public List<TrainingBatch_coagency> findAll() {
		return dao.getAll();
	}

	public int countAll() {
		return dao.countAll();
	}

	public TrainingBatch_coagency findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}
	/**
	 * 通过批次ID获得所有记录
	 */
	public List<TrainingBatch_coagency> findAllByBatchId(int id){
		return dao.findAllByBatchId(id);
	}
	public List<TrainingBatch_coagencyVO> getTrainingBatch_coagencyVOListById(int id){
		return dao.getTrainingBatch_coagencyVOListById(id);
	}
	public List<Coagency> getUseCoagency(String id){
		return dao.getUseCoagency(id);
	}
	public List<Coagency> getUnuseCoagency(String id){
		return dao.getUnuseCoagency(id);
	}

}
 