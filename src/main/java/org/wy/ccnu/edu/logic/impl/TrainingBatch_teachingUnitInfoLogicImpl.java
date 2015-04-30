package org.wy.ccnu.edu.logic.impl; 

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.dao.TrainingBatchDao;
import org.wy.ccnu.edu.dao.TrainingBatch_teachingUnitInfoDao;
import org.wy.ccnu.edu.entity.persist.Coagency;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.wy.ccnu.edu.entity.persist.TrainingBatch;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_teachingUnitInfo;
import org.wy.ccnu.edu.logic.TrainingBatch_teachingUnitInfoLogic;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午6:20:12 
 * 类说明 
 */
public class TrainingBatch_teachingUnitInfoLogicImpl implements TrainingBatch_teachingUnitInfoLogic{

	TrainingBatch_teachingUnitInfoDao dao=new TrainingBatch_teachingUnitInfoDao();
	public void create(TrainingBatch_teachingUnitInfo entity) {
		
		dao.save(entity);
	}

	public void update(TrainingBatch_teachingUnitInfo entity) {
		dao.update(entity);
		
	}

	public void delete(String ids) throws JSONException {
		dao.delete(ids);
		
	}

	public TrainingBatch_teachingUnitInfo findOne(String id) {
		return dao.getById(id);
	}

	public List<TrainingBatch_teachingUnitInfo> findAll() {
		return dao.getAll();
	}

	public int countAll() {
		return dao.countAll();
	}

	public TrainingBatch_teachingUnitInfo findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}
	public List<TrainingBatch_teachingUnitInfo> findAllByBatchId(int id){
		return dao.findAllByBatchId(id);
	}
	public List<TeachingUnitInfo> getUseTeachingUnitInfo(String id){
		return dao.getUseTeachingUnitInfo(id);
	}

	public  List<TrainingBatch_teachingUnitInfo> findByCoId(String id){
		return dao.findByCoId(id);
	}
	public TrainingBatch_teachingUnitInfo findByTeachingUnitId(String id){
		return dao.findByTeachingUnitId(id);
	}
}
 