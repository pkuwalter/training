package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.EducationLevel;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class EducationLevelDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(EducationLevel entity){
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
	
	/*
	public void delete(EducationLevel entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(EducationLevel.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}*/
	
	public boolean batchDeleteEducationLevel(JSONObject educationLevelIds) throws JSONException{
		
		String educationLevelID = "";
		
	/*	for(int i = 0;i<educationLevelIds.length();i++){
			educationLevelID = educationLevelIds.getString(i+"");
			if(teachingPlanExistOrNot(educationLevelID)){ //存在关联数据，不能删除
				return false;
			}
		}*/
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<educationLevelIds.length();i++){
			queryString.append("?");
			if(i < (educationLevelIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete EducationLevel where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<educationLevelIds.length();i++){
				query.setParameter(i+1, educationLevelIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
			return true;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(EducationLevel entity){
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
	
	public EducationLevel getEducationLevelById(String educationLevelID){
		try{
			EducationLevel instance = getEntityManager().find(EducationLevel.class, educationLevelID);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EducationLevel> getAllEducationLevels(){
		List<EducationLevel> result = new ArrayList<EducationLevel>();
		try{
			String queryString = "from EducationLevel";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<EducationLevel>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllEducationLevelsByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.educationLevelName) from EducationLevel model";
		try{
			Query query = getEntityManager().createQuery(queryString);
			List<UtilObject> results = query.getResultList();
			return results;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	//add 20121211 删除验证 begin
	public boolean teachingPlanExistOrNot(String educationLevelID){
		String queryString = "select model.id from TeachingPlan model where model.educationLevel= :educationLevelID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("educationLevelID", educationLevelID);
			String result = query.getSingleResult().toString();
			if(result != null){
				return true;
			}
			return false;
		}catch (NoResultException noResultException) {
			return false;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	//---end
	
	//add by wxl
		public ArrayList<UtilObject> getEducationLevelNameUtilObjectByIdList(ArrayList<String> educationLevelIdList){
			final String queryString = "select e.educationLevelName from EducationLevel e where e.id= :educationLevelId";
			ArrayList<UtilObject> educationLevelByIdList = new ArrayList<UtilObject>();
			try{
				for(Object o : educationLevelIdList){
					UtilObject uo = new UtilObject();
					Query query = getEntityManager().createQuery(queryString.toString());
					query.setParameter("educationLevelId", o.toString());

					List list =  query.getResultList();
					uo.setId(o.toString());
					uo.setName(list.get(0).toString());
					educationLevelByIdList.add(uo);
				}
				
				return educationLevelByIdList;
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		
		@SuppressWarnings("unchecked")
		public ArrayList<UtilObject> getAllUtilObjectELIdAndELN(){
			ArrayList<UtilObject> result = new ArrayList<UtilObject>();
			try{
				String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(el.id,el.educationLevelName) from EducationLevel el";
				Query query = getEntityManager().createQuery(queryString);
				result = (ArrayList<UtilObject>)query.getResultList();
				return result;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		
		public String getEducationLevelNameById(String educationLevelId){
			final String queryString = "select e.educationLevelName from EducationLevel e where e.id= :educationLevelId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("educationLevelId", educationLevelId);

				List list =  query.getResultList();
		
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		
		//----------wxl end
		
		//add by zt @ 20121226
		public String getIdByName(String educationLevelName){
			final String queryString = "select e.id from EducationLevel e where e.educationLevelName= :educationLevelName";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("educationLevelName", educationLevelName);

				List list =  query.getResultList();
				if(list.size()==0)return null;
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
}
