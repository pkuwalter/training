package org.wy.ccnu.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.CoagencyOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CoagencyOfficial;
import org.wy.ccnu.edu.entity.persist.StudentSourceOfficial;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class CoagencyOfficialDao {

	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(CoagencyOfficial entity){
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

	public void delete(CoagencyOfficial entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(CoagencyOfficial.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void batchDeleteCoagencyOfficial(JSONObject coagencyOfficialIds) throws JSONException{
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<coagencyOfficialIds.length();i++){
			queryString.append("?");
			if(i < (coagencyOfficialIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete CoagencyOfficial where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<coagencyOfficialIds.length();i++){
				query.setParameter(i+1, coagencyOfficialIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(CoagencyOfficial entity){
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
	
	public CoagencyOfficial findCoagencyOfficialById(String id){
		try{
			CoagencyOfficial instance = getEntityManager().find(CoagencyOfficial.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/**
	 * 根据条件查询合作机构人员信息
	 * @param coagency
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CoagencyOfficialVO> findCoagencyOfficialVOByConditions(String coagency, String status, String realName, String loginName, int pageNo, int pageSize){
		
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.CoagencyOfficialVO(model.id,model.officialNum,model.realName,model.loginName,coagency.coagencyName,model.tel,model.email,model.status) from CoagencyOfficial model, Coagency coagency where model.coagency = coagency.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				queryString.append(" and model.coagency= :coagency");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				queryString.append(" and model.realName= :realName");
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				query.setParameter("coagency",coagency);
			}
			
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				query.setParameter("realName", realName);
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				query.setParameter("loginName", loginName);
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<CoagencyOfficialVO> result = query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String coagency, String status, String realName, String loginName){
		int total = 0;
		try{
			String queryBasic = "select count(*) from CoagencyOfficial model, Coagency coagency where model.coagency = coagency.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				queryString.append(" and model.coagency= :coagency");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			if(realName != null && !realName.trim().equals("null") && !realName.trim().equals("")){
				queryString.append(" and model.realName= :realName");
			}
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				query.setParameter("coagency",coagency);
			}
			
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
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
	 * 获得所有的合作机构UtilObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllCoagencyByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.coagencyName) from Coagency model where model.status=1 order by convert(model.coagencyName,'gbk')";
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
