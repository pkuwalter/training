package org.wy.ccnu.edu.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.StudentAgencyOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentAgencyOfficial;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class StudentAgencyOfficialDao {
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(StudentAgencyOfficial entity){
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
	
	public void delete(StudentAgencyOfficial entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(StudentAgencyOfficial.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void batchDeleteStudentAgencyOfficial(JSONObject studentAgencyOfficialIds) throws JSONException{
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<studentAgencyOfficialIds.length();i++){
			queryString.append("?");
			if(i < (studentAgencyOfficialIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete StudentAgencyOfficial where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<studentAgencyOfficialIds.length();i++){
				query.setParameter(i+1, studentAgencyOfficialIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(StudentAgencyOfficial entity){
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
	
	public StudentAgencyOfficial findStudentAgencyOfficialById(String id){
		try{
			StudentAgencyOfficial instance = getEntityManager().find(StudentAgencyOfficial.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/**
	 * 根据条件查询学员单位人员信息
	 * @param agency
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StudentAgencyOfficialVO> findStudentAgencyOfficialVOByConditions(String agency, String status, String realName, String loginName, int pageNo, int pageSize){
		
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.StudentAgencyOfficialVO(model.id,model.officialNum,model.realName,model.loginName,studentAgency.studentAgencyName,model.tel,model.email,model.status) from StudentAgencyOfficial model, StudentAgency studentAgency where model.agency = studentAgency.id";
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
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(agency != null && !agency.trim().equals("null") && !agency.trim().equals("")){
				query.setParameter("agency",agency);
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
			List<StudentAgencyOfficialVO> result = query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllStudentAgencyByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentAgencyName) from StudentAgency model where model.status=1 order by convert(model.studentAgencyName,'gbk')";
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
	/**
	 */
	public int getTotalRecords(String agency, String status, String realName, String loginName){
		int total = 0;
		try{
			String queryBasic = "select count(*) from StudentAgencyOfficial model, StudentAgency studentAgency where model.agency = studentAgency.id";
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
			if(loginName != null && !loginName.trim().equals("null") &&  !loginName.trim().equals("")){
				queryString.append(" and model.loginName= :loginName");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(agency != null && !agency.trim().equals("null") && !agency.trim().equals("")){
				query.setParameter("agency",agency);
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
     * 判断用户名是否存在，包括学生、教师和管理员的用户名
     * @param loginName
     * @return 1-表示存在，0-表示不存在
     */
    @SuppressWarnings("unchecked")
	public int isLoginNameExist(String loginName){
    	
    	int flag = 0;
        
    	String queryString_1 = "select model from StudentAgencyOfficial model where model.loginName =:loginName";
    	
//    	String queryString_2 = "select model from StudentInfo model where model.loginName =:loginName";
//    	
//    	String queryString_3 = "select model from TeacherInfo model where model.loginName =:loginName";
    	
    	
    	try {

  			Query query_1 = getEntityManager().createQuery(queryString_1);
  			
  			query_1.setParameter("loginName", loginName);
  			
  			List<StudentAgencyOfficial> list_1 =(List<StudentAgencyOfficial>) query_1.getResultList();
  			
//  			Query query_2 = getEntityManager().createQuery(queryString_2);
//  			
//  			query_2.setParameter("loginName", loginName);
//  			
//  			List<StudentInfo> list_2 =(List<StudentInfo>) query_2.getResultList();
//  			
//  			Query query_3 = getEntityManager().createQuery(queryString_3);
//  			
//  			query_3.setParameter("loginName", loginName);
//  			
//  			List<TeacherInfo> list_3 =(List<TeacherInfo>) query_3.getResultList();
//  		
  			
//  			if(list_1.size()>0||list_2.size()>0||list_3.size()>0){
  			if(list_1.size()>0){
  				flag = 1;
  			}
  			
  		} catch (RuntimeException re) {
  		 
  			throw re;
  		}
    	
    	return flag;
    	
    }
}
