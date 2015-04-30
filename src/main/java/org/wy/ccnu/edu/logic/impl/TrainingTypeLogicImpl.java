package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.TrainingTypeDao;
import org.wy.ccnu.edu.entity.persist.CourseType;
import org.wy.ccnu.edu.entity.persist.TrainingType;
import org.wy.ccnu.edu.logic.TrainingTypeLogic;

public class TrainingTypeLogicImpl implements TrainingTypeLogic{
	TrainingTypeDao dao=new TrainingTypeDao();
	/**
	 * 创建
	 * @param entity
	 */
	public void create(TrainingType entity){
		dao.save(entity);
		
	}
	/**
	 * 修改
	 * @param entity
	 */
	public void update(TrainingType entity){
		dao.update(entity);
	}
	/**
	 * 删除
	 * @param ids
	 * @throws JSONException 
	 */
	public void delete(String ids) throws JSONException{
		dao.delete(ids);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public TrainingType findOne(int id){
		return dao.getById(id);
		
	}
	/**
	 * 所有记录
	 * @return
	 */
	public List<TrainingType> findAll(){
		return dao.getAll();
		
	}
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll(){
		return dao.countAll();
		
	}
	
	 public TrainingType getTrainingTypeByProperty(String property,String proValue,int id){
	    	return dao.getTrainingTypeByProperty(property, proValue,id);
	    }

}
