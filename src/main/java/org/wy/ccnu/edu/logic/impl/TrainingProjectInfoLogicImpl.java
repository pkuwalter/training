package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.dao.TrainingProjectInfoDao;
import org.wy.ccnu.edu.entity.TrainingProjectInfoVO;
import org.wy.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.wy.ccnu.edu.logic.TrainingProjectInfoLogic;

public class TrainingProjectInfoLogicImpl implements TrainingProjectInfoLogic{

	TrainingProjectInfoDao dao=new TrainingProjectInfoDao();
	public void create(TrainingProjectInfo entity) {
		
		dao.save(entity);
	}

	public void update(TrainingProjectInfo entity) {
		dao.update(entity);
		
	}

	public void delete(String ids) throws JSONException {
		dao.delete(ids);
		
	}

	public TrainingProjectInfo findOne(int id) {
		return dao.getById(id);
	}

	public List<TrainingProjectInfo> findAll() {
		return dao.getAll();
	}

	public int countAll() {
		return dao.countAll();
	}

	public TrainingProjectInfo findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}
	public List<TrainingProjectInfoVO> getTrainingProjectInfoVOList(){
		return dao.getTrainingProjectInfoVOList();
		
	}
	public List<TrainingProjectInfo> entityLsit(){
		return dao.entityLsit();
	}
	public List<TrainingProjectInfo> findByName(String name){
		return dao.findByName(name);
	}

}
