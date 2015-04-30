package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.CourseClass;


import org.wy.ccnu.edu.util.EntityManagerHelper;

public class CourseClassDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	//保存
	public void save(CourseClass entity){
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
	//批量删除
	public boolean batchDeleteCourseClass(JSONObject courseClassIds) throws JSONException{
		
		/*String courseTypeID = "";
		for(int i = 0;i<courseTypeIds.length();i++){
			courseTypeID = courseTypeIds.getString(i+"");
		if(teachingPlanExistOrNot(courseTypeID)){ //存在关联数据，不能删除
				return false;
			}	
		}*/
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<courseClassIds.length();i++){
			queryString.append("?");
			if(i < (courseClassIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete CourseClass where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<courseClassIds.length();i++){
				query.setParameter(i+1, Integer.parseInt(courseClassIds.getString(i+"")));
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
	//更新
	public void update(CourseClass entity){
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
	//通过Id获取对象
	public CourseClass getCourseClassById(String courseClassID){
		try{
			CourseClass instance = getEntityManager().find(CourseClass.class, Integer.parseInt(courseClassID));
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	//获取所有的列表
	@SuppressWarnings("unchecked")
	public List<CourseClass> getAllCourseClasss(){
		List<CourseClass> result = new ArrayList<CourseClass>();
		try{
			String queryString = "from CourseClass";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<CourseClass>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	
		//获取最大的Id
		public int getMaxCourseClassId(){
			try {
				
						
				final String queryString = "select max(model.id) from CourseClass model where 1=1";
				Query query = getEntityManager().createQuery(queryString);		
				
	            Integer maxId = (Integer) query.getSingleResult();
				
				return  maxId==null?0:maxId;	
								
			} catch (RuntimeException re) {
				throw re;
			}
			
			
		}
		 /**
	     * 根据courseTClass的属性来查找课程课类信息
	     * @param property
	     * 			省份属性
	     * @param proValue
	     * 			属性的值
	     * @return
	     * 			课程课类实体
	     */
	    public CourseClass getCourseClassByProperty(String property,String proValue,int id){
	    	String queryString = "from CourseClass model where model."+property+" = '"+proValue +"' and model.id <> " + id;
	    	CourseClass courseClass = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
	    		List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			courseClass = (CourseClass) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return courseClass;	
	    }
	    
	    /**
	     * 根据courseTClass的属性来查找课程课类信息（没有id）
	     * @author yangyingjie
	     * @param property
	     * @param proValue
	     * @return
	     */
	    @SuppressWarnings("rawtypes")
		public CourseClass getCourseClassByOneProperty(String property,String proValue){
	    	String queryString = "from CourseClass model where model."+property+" = '"+proValue +"'";
	    	CourseClass courseClass = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
	    		List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			courseClass = (CourseClass) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return courseClass;	
	    }
	    
}
