package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.persist.SupervisorOfficial;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class SupervisorOfficialDao {
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(SupervisorOfficial entity){
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
	
public void batchDeleteSupervisorOfficial(JSONObject supervisorOfficialIds) throws JSONException{
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<supervisorOfficialIds.length();i++){
			queryString.append("?");
			if(i < (supervisorOfficialIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete SupervisorOfficial where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<supervisorOfficialIds.length();i++){
				query.setParameter(i+1, supervisorOfficialIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

	public void update(SupervisorOfficial entity){
		try{
			EntityManagerHelper.beginTransaction();
			getEntityManager().merge(entity);
			EntityManagerHelper.commit();			
		}catch(RuntimeException re){
		throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public SupervisorOfficial findSupervisorOfficialById(String id){
		try{
			SupervisorOfficial instance = getEntityManager().find(SupervisorOfficial.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public List<SupervisorOfficial> findSupervisorOfficialListByConditions(String realName, String loginName, int status,  int pageNo, int pageSize){
		
		try{
			String queryBasic = "select  model  from SupervisorOfficial model  where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			 
			if(status !=3){
				queryString.append(" and model.status= :status");
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				queryString.append(" and model.realName= :realName");
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(status != 3){
				query.setParameter("status", status);
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				query.setParameter("realName", realName);
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				query.setParameter("loginName", loginName);
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<SupervisorOfficial> result = new ArrayList<SupervisorOfficial>();
			for(Object o : query.getResultList()){
				result.add((SupervisorOfficial)o);	
			}
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(   String realName, String loginName,int status){
		int total = 0;
		try{
			String queryBasic = "select count(*) from SupervisorOfficial model  where  1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			 
			if(status != 3){
				queryString.append(" and model.status= :status");
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				queryString.append(" and model.realName= :realName");
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(status != 3){
				query.setParameter("status", status);
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				query.setParameter("realName", realName);
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				query.setParameter("loginName", loginName);
			}
			total =  Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
     * 判断用户名是否存在，包括学生、教师和管理员的用户名
     * @param loginName
     * @return 1-表示存在，0-表示不存在
     */
	public int isLoginNameExist(String loginName){
    	
    	int flag = 0;
         
    	String queryString_2 = "select count(distinct model.id) from SupervisorOfficial model where model.loginName =:loginName";
    	  
    	try {

  			 
  			
  			Query query_2 = getEntityManager().createQuery(queryString_2);
  			
  			query_2.setParameter("loginName", loginName);
  			
  			int count =Integer.parseInt(query_2.getSingleResult().toString());
  			
  			 
  		
  			
  			if(count>0 ){
  				flag = 1;
  			}
  			
  		} catch (RuntimeException re) {
  		 
  			throw re;
  		}
    	
    	return flag;
    	
    }
	
	/*public static void main(String [] args){
		SupervisorOfficialDao dao = new SupervisorOfficialDao();
		String realName ="彭建洲";
		String loginName="";
		int status = 3;
		List<SupervisorOfficial> so =null;
		so=dao.findSupervisorOfficialListByConditions(realName, loginName, status, 1, 3);
		System.out.println("------------realName="+so.get(0).getRealName());
	}*/
}
