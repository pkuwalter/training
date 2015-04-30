package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import org.wy.ccnu.edu.entity.persist.Political;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class PoliticalDao {
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * * @param entity
	 */
	
	public void save(Political entity){
		EntityManager em = EntityManagerHelper.getMyOwnEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			System.out.println(entity.getId() + "   " + entity.getPoliticalName());
			em.persist(entity);
			et.commit();
			 
		} catch (RuntimeException re) {
		 
			throw re;
		} finally {
			em.close();
		}
	}


	public void delete(Political entity){
		try {
			
			EntityManagerHelper.beginTransaction();

			entity = getEntityManager().getReference(Political.class,
					entity.getId());
			getEntityManager().remove(entity);
			
			EntityManagerHelper.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void  update(Political entity){
		
		try {
			EntityManager em = EntityManagerHelper.getEntityManager();

			em.getTransaction().begin();
 
			em.merge(entity);

			em.getTransaction().commit();
 
			 
		} catch (RuntimeException re) {
			 
			throw re;
		} finally {
			// em.close();
		}
		
	}
	
	public Political findPoliticalByID(int politicalId){
		
		try {
			Political instance = getEntityManager().find(Political.class, politicalId);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public List<Political> getAllPolitical(){
		
		try {
			final String queryString = "select model from Political model where 1=1 order by model.id asc";

			Query query = getEntityManager().createQuery(queryString);

			return (List<Political>) query.getResultList();
		} catch (RuntimeException re) {
		 
			throw re;
		}
	}
	
	public int getMaxPoliticalId(){
		try {
			
					
			final String queryString = "select max(model.id) from Political model where 1=1";
			Query query = getEntityManager().createQuery(queryString);		
			
			// System.out.println(query.getFirstResult());
			Integer maxId = (Integer) query.getSingleResult();
			
			return  maxId==null?0:maxId;	
			
			// "select max(user.userId) from user user"; 
			
		} catch (RuntimeException re) {
			throw re;
		}
		
		
	}
	 /**
     * 返回总数
     * @return
     */
    public int getTotalPoliticals(){
    	int total = 0;
		String queryString = "select count(*) from Political ";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
    	
    }
    /**
     * 以翻页的形式返回当前页的角色列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Political> getAllPoliticalInPage(int pageNo, int pageSize){
    
    	List<Political> list = new ArrayList<Political>();
    	
    	try{
			String queryString = "select model from Political model";
			Query query = getEntityManager().createQuery(queryString);
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			for(Object o : query.getResultList()){
			   list.add((Political)o);	
			}
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
    }


	
}
