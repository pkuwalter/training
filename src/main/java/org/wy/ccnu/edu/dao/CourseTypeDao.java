package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CourseType;


import org.wy.ccnu.edu.util.EntityManagerHelper;

public class CourseTypeDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	//增加保存课程课类
	public void save(CourseType entity){
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
	
	
	/*public void delete(CourseType entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(CourseType.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}*/
	//批量删除课程课类
	public boolean batchDeleteCourseType(JSONObject courseTypeIds) throws JSONException{
		
		/*String courseTypeID = "";
		for(int i = 0;i<courseTypeIds.length();i++){
			courseTypeID = courseTypeIds.getString(i+"");
		if(teachingPlanExistOrNot(courseTypeID)){ //存在关联数据，不能删除
				return false;
			}	
		}*/
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<courseTypeIds.length();i++){
			queryString.append("?");
			if(i < (courseTypeIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete CourseType where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<courseTypeIds.length();i++){
				query.setParameter(i+1, Integer.parseInt(courseTypeIds.getString(i+"")));
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
	//更新课程课类
	public void update(CourseType entity){
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
	//通过Id获取课程课类
	public CourseType getCourseTypeById(String courseTypeID){
		try{
			CourseType instance = getEntityManager().find(CourseType.class, Integer.parseInt(courseTypeID));
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	//获取所有的课程课类
	@SuppressWarnings("unchecked")
	public List<CourseType> getAllCourseTypes(){
		List<CourseType> result = new ArrayList<CourseType>();
		try{
			String queryString = "from CourseType";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<CourseType>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	
		//获取最大的Id
		public int getMaxCourseTypeId(){
			try {
				
						
				final String queryString = "select max(model.id) from CourseType model where 1=1";
				Query query = getEntityManager().createQuery(queryString);		
				
	            Integer maxId = (Integer) query.getSingleResult();
				
				return  maxId==null?0:maxId;	
								
			} catch (RuntimeException re) {
				throw re;
			}
			
			
		}
		 /**
	     * 根据courseType的属性来查找课程类别信息
	     * @param property
	     * 			省份属性
	     * @param proValue
	     * 			属性的值
	     * @return
	     * 			课程类别实体
	     */
	    public CourseType getCourseTypeByProperty(String property,String proValue,int id){
	    	String queryString = "from CourseType model where model."+property+" = '"+proValue +"' and model.id <> " + id;
	    	CourseType courseType = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
	    		List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			courseType = (CourseType) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return courseType;	
	    }
	    
	    /**
	     *根据courseType的属性来查找课程类别信息 （参数有两个，没有id）
	     * @author yangyingjie
	     * @param property
	     * @param proValue
	     * @return
	     */
	    public CourseType getCourseTypeByOneProperty(String property,String proValue){
	    	String queryString = "from CourseType model where model."+property+" = '"+proValue +"' ";
	    	CourseType courseType = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
	    		List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			courseType = (CourseType) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return courseType;	
	    }
	    
	    
	    
	    
	    
}
