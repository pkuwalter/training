package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.Special;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class SpecialDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(Special entity){
		try{
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			//throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public boolean batchDeleteSpecial(JSONObject specialIds) throws JSONException{
		
		String specialID = "";
		
		/*for(int i = 0;i<specialIds.length();i++){
			specialID = specialIds.getString(i+"");
			if(teachingPlanExistOrNot(specialID)){ //存在关联数据，不能删除
				return false;
			}
		}*/
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<specialIds.length();i++){
			queryString.append("?");
			if(i < (specialIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete Special where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<specialIds.length();i++){
				query.setParameter(i+1, specialIds.getString(i+""));
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
	
	public void update(Special entity){
		try{
			EntityManagerHelper.beginTransaction();
			getEntityManager().merge(entity);
            EntityManagerHelper.commit();			
		}catch(RuntimeException re){
			//throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public Special getSpecialById(String specialID){
		try{
			Special instance = getEntityManager().find(Special.class, specialID);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public Special getSpecialByName(String specialName){
	 
		String queryString = "select model from Special model where model.specialName= :specialName";
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("specialName", specialName);
			Special special = (Special)query.getSingleResult();
			return special;
		}catch(NoResultException noResultException){
			return null;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Special> getSpecialbyEducationLevelID(String educationLevelID){
		List<Special> result = null;
		String queryString = "select model from Special model where model.educationLevel= :educationLevelID order by model.specialNum_jw asc";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("educationLevelID", educationLevelID);
			result = (List<Special>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Special> getAllSpecials(){
		List<Special> result = new ArrayList<Special>();
		try{
			String queryString = "from Special";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<Special>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getSpecialUtilsByGradeAndEducationLevel(String gradeID,String educationLevelID){
		String queryBasic= "select distinct new org.wy.ccnu.edu.entity.UtilObject(model.id,model.specialName) from Special model,TeachingPlan teachingPlan where model.id = teachingPlan.special";
		StringBuilder queryString = new StringBuilder();
		queryString.append(queryBasic);
		if(gradeID != null && !gradeID.trim().equals("")){
			queryString.append(" and teachingPlan.grade= :gradeID");
		}
		if(educationLevelID != null && !educationLevelID.trim().equals("")){
			queryString.append(" and teachingPlan.educationLevel= :educationLevelID");
		}
		Query query = getEntityManager().createQuery(queryString.toString());
		
		if(gradeID != null && !gradeID.trim().equals("")){
			query.setParameter("gradeID", gradeID);
		}
		if(educationLevelID != null && !educationLevelID.trim().equals("")){
			query.setParameter("educationLevelID", educationLevelID);
		}
		
		List<UtilObject> results = query.getResultList();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllSpecialsByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.specialName) from Special model";
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
	
	@SuppressWarnings("unchecked")
	public List<Special> getAllSpecialsInTeachingPlan(){
		List<Special> result = new ArrayList<Special>();
		try{
			String queryString = "select distinct model from Special model,TeachingPlan teachingPlan where model.id = teachingPlan.special";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<Special>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	//add 20121211 删除验证 begin
		public boolean teachingPlanExistOrNot(String specialID){
			String queryString = "select model.id from TeachingPlan model where model.special= :specialID limit 1";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("specialID", specialID);
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
	
		@SuppressWarnings("unchecked")
		public List<UtilObject> getSpecialsInTeachingPlanByUtilObject(){
			String queryString = "select distinct new org.wy.ccnu.edu.entity.UtilObject(model.id,model.specialName) from Special model,TeachingPlan teachingPlan where model.id = teachingPlan.special";
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
		
	//-----------wxl begin
	//add by wxl
		public String getSpecialIdByName(String specialName){
			final String queryString = "select s.id from Special s where s.specialName= :specialName";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("specialName", specialName);

				List list =  query.getResultList();
				
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		

		public String getSpecialNameById(String specialId){
			final String queryString = "select s.specialName from Special s where s.id= :specialId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("specialId", specialId);

				List list =  query.getResultList();
				
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		
	 
	 
		
		
		//add by wxl
		public ArrayList<UtilObject> getSpecialNameUtilObjectByIdList(ArrayList<String> specialIdList){
			final String queryString = "select s.specialName from Special s where s.id= :specialIdList";
			ArrayList<UtilObject> specialByIdList = new ArrayList<UtilObject>();
			try{
				for(Object o : specialIdList){
					UtilObject uo = new UtilObject();
					Query query = getEntityManager().createQuery(queryString.toString());
					query.setParameter("specialIdList", o.toString());

					List list =  query.getResultList();
					uo.setId(o.toString());
					uo.setName(list.get(0).toString());
					specialByIdList.add(uo);
				}
				
				return specialByIdList;
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
	
		@SuppressWarnings("unchecked")
		public ArrayList<UtilObject> getAllUtilObjectSpecialIdAndSN(){
			ArrayList<UtilObject> result = new ArrayList<UtilObject>();
			try{
				String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(s.id,s.specialName) from Special s";
				Query query = getEntityManager().createQuery(queryString);
				result = (ArrayList<UtilObject>)query.getResultList();
				return result;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
	//-----------wxl end
	
	
}
