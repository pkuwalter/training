package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.CourseType;
import org.nercel.ccnu.edu.entity.persist.TrainingType;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class TrainingTypeDao extends BaseDaoImpl<TrainingType>{

	 /* 删除
	 * @param ids
	 * @throws JSONException 
	 */
	public void delete(String ids) throws JSONException{
		String sql = "delete TrainingType where id in ( " + ids + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		
	}
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll(){
		String sql="select count(*) from TrainingType";
		Query query=getEntityManager().createQuery(sql);
		int count=0;
		count=Integer.parseInt(query.getSingleResult().toString());
		return count;
		
	}
	 public TrainingType getTrainingTypeByProperty(String property,String proValue,int id){
	    	String queryString = "from TrainingType model where model."+property+" = '"+proValue +"' and model.id <> " + id;
	    	TrainingType entity = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
				List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			entity = (TrainingType) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return entity;	
	    }
}
