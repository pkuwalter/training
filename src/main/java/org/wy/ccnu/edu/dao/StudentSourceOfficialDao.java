package org.wy.ccnu.edu.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.StudentSourceOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentSourceOfficial;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class StudentSourceOfficialDao {
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(StudentSourceOfficial entity){
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
	
	public void delete(StudentSourceOfficial entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(StudentSourceOfficial.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void batchDeleteStudentSourceOfficial(JSONObject registrationPointOfficialIds) throws JSONException{
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<registrationPointOfficialIds.length();i++){
			queryString.append("?");
			if(i < (registrationPointOfficialIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete StudentSourceOfficial where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<registrationPointOfficialIds.length();i++){
				query.setParameter(i+1, registrationPointOfficialIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(StudentSourceOfficial entity){
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
	/**
	 * 根据id查找渠道人员
	 * @param id
	 * @return
	 */
	public StudentSourceOfficial findStudentSourceOfficialById(String id){
		try{
			StudentSourceOfficial instance = getEntityManager().find(StudentSourceOfficial.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/**
	 * 根据条件查询渠道人员信息
	 * @param agency
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StudentSourceOfficialVO> findStudentSourceOfficialVOByConditions(String agency, String status, String realName, String loginName, int pageNo, int pageSize){
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.StudentSourceOfficialVO(model.id,model.officialNum,model.realName,model.loginName,studentSourceInfo.studentSourceName,model.tel,model.email,model.status) from StudentSourceOfficial model, StudentSourceInfo studentSourceInfo where model.agency = studentSourceInfo.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(agency != null && !agency.trim().equals("null") && !agency.trim().equals("")){
				queryString.append(" and model.agency= :agency");
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
			
			if(agency != null && !agency.trim().equals("null") && !agency.trim().equals("")){
				query.setParameter("agency", agency);
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
			
			List<StudentSourceOfficialVO> result = query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String agency, String status, String realName, String loginName){
		int total = 0;
		try{
			String queryBasic = "select count(*) from StudentSourceOfficial model, StudentSourceInfo studentSourceInfo where model.agency = studentSourceInfo.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(agency != null && !agency.trim().equals("null") && !agency.trim().equals("")){
				queryString.append(" and model.agency= :agency");
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
			
			if(agency != null && !agency.trim().equals("null") && !agency.trim().equals("")){
				query.setParameter("agency", agency);
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
	/**
	 * 获得所有渠道的UtilObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllStudentSourceByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentSourceName) from StudentSourceInfo model where model.status=1 order by convert(model.studentSourceName,'gbk')";
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
	
	public String getStudentSourceIDByLoginName(String loginName){
		String registrationPointID = "";
		String queryString = "select model.agency from StudentSourceOfficial model where model.loginName= :loginName";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("loginName", loginName.trim());
			registrationPointID = query.getSingleResult().toString();
			return registrationPointID;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
}
