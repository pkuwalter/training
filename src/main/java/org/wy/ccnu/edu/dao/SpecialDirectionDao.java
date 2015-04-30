package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
 
import org.wy.ccnu.edu.entity.SpecialDirectionVO;
import org.wy.ccnu.edu.entity.UtilObject;
 
import org.wy.ccnu.edu.entity.persist.SpecialDirection;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class SpecialDirectionDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(SpecialDirection entity){
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
	
	public void deleteSpecialDirection(int specialDirectionId)  {
	 
		String sql = "delete Special where id = "+specialDirectionId;
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
		 
			query.executeUpdate();
			EntityManagerHelper.commit();
			 
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(SpecialDirection entity){
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
	
    public SpecialDirectionVO getSpecialDirectionVOById(int specialDirectionId){
    	
    	SpecialDirectionVO sdvo = null;
    	
    	String queryBasic = "select new org.wy.ccnu.edu.entity.SpecialDirectionVO(model.id,model.specialId," +
    			"special.specialName,model.specialDirectionCode,model.specialDirectionName)" +
				" from SpecialDirection model,Special special" +
				" where model.id=:specialDirectionId and model.specialId=special.id " ;
 
    	try{
    		
		Query query = getEntityManager().createQuery(queryBasic);
		
		query.setParameter("specialDirectionId", specialDirectionId);
 
		@SuppressWarnings("unchecked")
		List<SpecialDirectionVO> list = (List<SpecialDirectionVO>) query.getResultList();
		
		if(list!=null && list.size()>0){
			
			sdvo = list.get(0);
			
		}
		
		return sdvo;
		
		}catch(RuntimeException re){
		
			throw re;
		}finally{
			getEntityManager().close();
		}
    	
    }
	
	/**
	 * 根据学科方向代码，查询学科方向对象
	 * @param specialDirectionCode
	 * @return
	 */
	public SpecialDirectionVO getSpecialDirectionVOByCode(String specialDirectionCode)
	{
	SpecialDirectionVO sdvo = null;
	
	String queryBasic = "select new org.wy.ccnu.edu.entity.SpecialDirectionVO(model.id,model.specialId," +
			"special.specialName,model.specialDirectionCode,model.specialDirectionName)" +
			" from SpecialDirection model,Special special" +
			" where model.specialDirectionCode=:specialDirectionCode and model.specialId=special.id " ;

	try{
		
	Query query = getEntityManager().createQuery(queryBasic);
	
	query.setParameter("specialDirectionCode", specialDirectionCode);

	@SuppressWarnings("unchecked")
	List<SpecialDirectionVO> list = (List<SpecialDirectionVO>) query.getResultList();
	
	if(list!=null && list.size()>0){
		
		sdvo = list.get(0);
		
	}
	
	return sdvo;
	
	}
	catch(RuntimeException re){
	
		throw re;
	}
	finally{
		getEntityManager().close();
	}
	
	}
	
	/**
	 * 根据培养学科或专业id,学科方向代码，学科方向名称，组合查询，获取学科方向VO列表
	 * 分页查询
	 * @param specialId
	 * @return
	 */
	public List<SpecialDirectionVO> getSpecialDirectionVOListByCondition(
			String specialId,String specialDirectionCode,String specialDirectionName,int pageNo,int pageSize){
		
		List<SpecialDirectionVO> result = new ArrayList<SpecialDirectionVO>();
		
		String queryBasic = "select new org.wy.ccnu.edu.entity.SpecialDirectionVO(model.id,model.specialId," +
				"special.specialName,model.specialDirectionCode,model.specialDirectionName)" +
				" from SpecialDirection model,Special special" +
				" where model.specialId=special.id " ;
		
		if(specialId!=null && !specialId.equals("")){
			
			queryBasic += " and model.specialId ='"+specialId+"' ";
		}
		
		if(specialDirectionCode!=null && !specialDirectionCode.equals("")){
			
			queryBasic += " and model.specialDirectionCode ='"+specialDirectionCode+"' ";
		}

		if(specialDirectionName!=null && !specialDirectionName.equals("")){
			
			queryBasic += " and model.specialDirectionName ='"+specialDirectionName+"' ";
		}

		try{
			
		Query query = getEntityManager().createQuery(queryBasic);
		
		query.setFirstResult((pageNo-1)*pageSize);
		
		query.setMaxResults(pageSize);
		 
		result = (List<SpecialDirectionVO>) query.getResultList();
		
		return result;
		
		}
		catch(RuntimeException re){
		
			throw re;
		}
		finally{
			getEntityManager().close();
		}
		
		
	}
	
	
	/**
	 * 根据培养学科或专业id,学科方向代码，学科方向名称，获取学科方向VO列表
	 * 分页查询
	 * @param specialId
	 * @return
	 */
	public int getSpecialDirectionVOListSizeByCondition(
			String specialId,String specialDirectionCode,String specialDirectionName){
		
		
		int total = 0 ;
		
		String queryBasic = "select new org.wy.ccnu.edu.entity.SpecialDirectionVO(model.id,model.specialId," +
				"special.specialName,model.specialDirectionCode,model.specialDirectionName)" +
				" from SpecialDirection model,Special special" +
				" where model.specialId=special.id " ;
		
		if(specialId!=null && !specialId.equals("")){
			
			queryBasic += " and model.specialId ='"+specialId+"' ";
		}
		
		if(specialDirectionCode!=null && !specialDirectionCode.equals("")){
			
			queryBasic += " and model.specialDirectionCode ='"+specialDirectionCode+"' ";
		}

		if(specialDirectionName!=null && !specialDirectionName.equals("")){
			
			queryBasic += " and model.specialDirectionName ='"+specialDirectionName+"' ";
		}

		try{
			
		Query query = getEntityManager().createQuery(queryBasic);
		 
		List<SpecialDirectionVO> result = (List<SpecialDirectionVO>) query.getResultList();
		
       if(result!=null && result.size()>0)
       {
    	   total = result.size();
       }
		
		return total;
		
		}
		catch(RuntimeException re){
		
			throw re;
		}
		finally{
			getEntityManager().close();
		}
		
		
	}
	
	
	
}
