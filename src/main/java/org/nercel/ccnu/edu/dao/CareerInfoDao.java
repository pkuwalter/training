package org.nercel.ccnu.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.CareerInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class CareerInfoDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	/*
	 * 得到所有职业的信息
	 * 
	 * */
	
	public List<CareerInfo> getCareerInfoList(){
		
		String queryString = "select model from CareerInfo model";
		Query query = null;
		List<CareerInfo> list = null;
		try{
			
			query = getEntityManager().createQuery(queryString);
		
			list = (List<CareerInfo>)query.getResultList();
			
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		
	}
	/*
	 * 分页显示
	 * */
	public List<CareerInfo> getCareerInfoListPage(String career,int pageNo,int pageSize){
		
		String queryString = "select model from CareerInfo model where 1=1";
		StringBuilder sql=new StringBuilder();
		sql.append(queryString);
		if(career!=null&&!(career=career.trim()).isEmpty()){
			sql.append(" and model.career like :career");
		}
		queryString=sql.toString();
	
		Query query = null;
		List<CareerInfo> list = null;
		try{
			
			query = getEntityManager().createQuery(queryString);
		    if(career!=null&&!career.isEmpty()){
		    	query.setParameter("career", "%"+career+"%");
		    }
		    
		    query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			
			list = (List<CareerInfo>)query.getResultList();
			
			
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/*
	 * 记录数目
	 * */
	public int getCareerInfoNum(String career){
		
		String queryString = "select count(*) from CareerInfo model where 1=1";
		StringBuilder sql=new StringBuilder();
		sql.append(queryString);
		if(career!=null&&!(career=career.trim()).isEmpty()){
			sql.append(" and model.career like :career");
		}
		queryString=sql.toString();
		
		Query query = null;
	
		try{
			
			query = getEntityManager().createQuery(queryString);
			
		    if(career!=null&&!career.isEmpty()){
			   	query.setParameter("career", "%"+career+"%");
		    }
		    int total=0;
		    if(query.getSingleResult()!=null){
		
		    	total=Integer.parseInt(query.getSingleResult().toString());
		    }
			
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}	
		
	
	/*
	 * 根据id号批量删除职业信息
	 * */
	
	public void deleteCareerInfoByIds(JSONObject ids) throws JSONException{
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<ids.length();i++){
			queryString.append("?");
			if(i < (ids.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete CareerInfo where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			
			for(int i = 0;i<ids.length();i++){
				query.setParameter(i+1, ids.getString(i+""));
			}
			
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/*
	 * 增加职业信息
	 * */
	
	public void save(CareerInfo entity){
		try{
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

}
