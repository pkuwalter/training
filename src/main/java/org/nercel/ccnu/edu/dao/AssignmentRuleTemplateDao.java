package org.nercel.ccnu.edu.dao; 

import java.util.List;

import javax.persistence.Query;

import org.nercel.ccnu.edu.entity.persist.AssignmentRuleTemplate;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

/** 
 * @author Jo 
 * @version 创建时间：2014年6月19日 下午2:52:59 
 * 类说明 
 */
public class AssignmentRuleTemplateDao extends BaseDaoImpl<AssignmentRuleTemplate> {
	public void delete(String ids){
		String sql="delete AssignmentRuleTemplate where id in ( " + ids + ")";
		Query query=null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			query.executeUpdate();
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}
	public int countAll(){
		String sql="select count(*) from AssignmentRuleTemplate";
		Query query=getEntityManager().createQuery(sql);
		int count=0;
		count=Integer.parseInt(query.getSingleResult().toString());
		return count;
		
	}
	public List<AssignmentRuleTemplate> findByPage(int pageNo,int pageSize){
		String sql="from AssignmentRuleTemplate";
		Query query=null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<AssignmentRuleTemplate> entityList=query.getResultList();
			return entityList;
			
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		
	}
	

}
 