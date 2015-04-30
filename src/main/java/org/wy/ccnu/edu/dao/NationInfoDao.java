package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query; 
import org.wy.ccnu.edu.entity.persist.NationInfo;
import org.wy.ccnu.edu.util.EntityManagerHelper; 


public class NationInfoDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * * @param entity
	 */
	public void save(NationInfo entity){
		EntityManager em = EntityManagerHelper.getMyOwnEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(entity);
			et.commit();
			 
		} catch (RuntimeException re) {
		 
			throw re;
		} finally {
			em.close();
		}
	}
	
	public void delete(NationInfo entity){
		try {
			
			EntityManagerHelper.beginTransaction();

			entity = getEntityManager().getReference(NationInfo.class,
					entity.getId());
			getEntityManager().remove(entity);
			
			EntityManagerHelper.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void  update(NationInfo entity){
		
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
	
	public NationInfo findNationById(int nationId){
		
		try {
			NationInfo instance = getEntityManager().find(NationInfo.class,nationId);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<NationInfo> getAllNationInfo(){
		
		try {
			final String queryString = "from NationInfo model where 1=1 order by model.id asc";

			Query query = getEntityManager().createQuery(queryString);

			return (List<NationInfo>) query.getResultList();
		} catch (RuntimeException re) {
		 
			throw re;
		}
	}
	public int getMaxNationId(){
		try {
			
					
			final String queryString = "select max(model.id) from NationInfo model where 1=1";
			Query query = getEntityManager().createQuery(queryString);		
			
            Integer maxId = (Integer) query.getSingleResult();
			
			return  maxId==null?0:maxId;	
							
		} catch (RuntimeException re) {
			throw re;
		}
		
		
	}

	 /**
     * 以翻页的形式返回当前页的角色列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<NationInfo> getAllNationInPage(int pageNo, int pageSize){
    
    	List<NationInfo> list = new ArrayList<NationInfo>();
    	
    	try{
			String queryString = "select model from NationInfo model";
			Query query = getEntityManager().createQuery(queryString);
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			for(Object o : query.getResultList()){
			   list.add((NationInfo)o);	
			}
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
    }
    
    
    /**
     * 返回总数
     * @return
     */
    public int getTotalNations(){
    	int total = 0;
		String queryString = "select count(*) from NationInfo ";
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
    
	
}
