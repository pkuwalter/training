package org.wy.ccnu.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.TeachingUnitInfoOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfoOfficial;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class TeachingUnitInfoOfficialDao {

	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	} 
	
	public void save(TeachingUnitInfoOfficial entity){
		try{
			entity.setId(null);
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void delete(TeachingUnitInfoOfficial entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(TeachingUnitInfoOfficial.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void batchDeleteTeachingUnitInfoOfficial(JSONObject teachingUnitInfoOfficialIds) throws JSONException{
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<teachingUnitInfoOfficialIds.length();i++){
			queryString.append("?");
			if(i < (teachingUnitInfoOfficialIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete TeachingUnitInfoOfficial where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<teachingUnitInfoOfficialIds.length();i++){
				query.setParameter(i+1, teachingUnitInfoOfficialIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(TeachingUnitInfoOfficial entity){
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
	
	public TeachingUnitInfoOfficial findTeachingUnitInfoOfficialById(String id){
		try{
			TeachingUnitInfoOfficial instance = getEntityManager().find(TeachingUnitInfoOfficial.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/**
	 * 根据条件查询教学点信息
	 * @param teachingUnitInfo
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TeachingUnitInfoOfficialVO> findTeachingUnitInfoOfficialVOByConditions(String teachingUnitInfoId, String status, String realName, String loginName, int pageNo, int pageSize){
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.TeachingUnitInfoOfficialVO(model.id,model.officialNum,model.realName,model.loginName,teachingUnitInfo.teachingUnitName,model.tel,model.email,model.status) from TeachingUnitInfoOfficial model, TeachingUnitInfo teachingUnitInfo where model.agency = teachingUnitInfo.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(teachingUnitInfoId != null && !teachingUnitInfoId.trim().equals("null") && !teachingUnitInfoId.trim().equals("")){
				queryString.append(" and model.agency= :teachingUnitInfoId");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				queryString.append(" and model.realName= :realName");
			}
			if(loginName != null && !loginName.trim().equals("null") && !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(teachingUnitInfoId != null && !teachingUnitInfoId.trim().equals("null") && !teachingUnitInfoId.trim().equals("")){
				query.setParameter("teachingUnitInfoId", teachingUnitInfoId);
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				query.setParameter("realName", realName);
			}
			if(loginName != null && !loginName.trim().equals("null") && !loginName.trim().equals("")){
				query.setParameter("loginName", loginName.trim());
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			List<TeachingUnitInfoOfficialVO> result = query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String teachingUnitInfoId, String status, String realName, String loginName){
		int total = 0;
		try{
			String queryBasic = "select count(*) from TeachingUnitInfoOfficial model, TeachingUnitInfo teachingUnitInfo where model.agency = teachingUnitInfo.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(teachingUnitInfoId != null && !teachingUnitInfoId.trim().equals("null") && !teachingUnitInfoId.trim().equals("")){
				queryString.append(" and model.agency= :teachingUnitInfoId");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				queryString.append(" and model.realName= :realName");
			}
			if(loginName != null && !loginName.trim().equals("null") && !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(teachingUnitInfoId != null && !teachingUnitInfoId.trim().equals("null") && !teachingUnitInfoId.trim().equals("")){
				query.setParameter("teachingUnitInfoId", teachingUnitInfoId);
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				query.setParameter("realName", realName);
			}
			if(loginName != null && !loginName.trim().equals("null") && !loginName.trim().equals("")){
				query.setParameter("loginName", loginName.trim());
			}
			
			
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public String getTeachingUnitInfoIDByLoginName(String loginName){
		System.out.println("loginName: "+loginName);
		String teachingUnitInfoID = "";
		String queryString = "select model.agency from TeachingUnitInfoOfficial model where model.loginName= :loginName";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("loginName", loginName.trim());
			teachingUnitInfoID = query.getSingleResult().toString();
			return teachingUnitInfoID;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllTeachingUnitInfoByUtilObject(){
		
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.teachingUnitName) from TeachingUnitInfo model where model.status=1 order by convert(model.teachingUnitName,'gbk')";
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
}
