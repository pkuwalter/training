package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.ExamType;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class ExamTypeDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	//增加考试方式
	public void save(ExamType entity){
		
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
	
   
	//批量删除考试方式
	public boolean batchDeleteExamType(JSONObject examTypeIds) throws JSONException{
				
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<examTypeIds.length();i++){
			queryString.append("?");
			if(i < (examTypeIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete ExamType where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<examTypeIds.length();i++){
				query.setParameter(i+1, Integer.parseInt(examTypeIds.getString(i+"")));
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
	

	//更新考试方式
	public void update(ExamType entity){
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
	
	//通过id获取考试方式
	public ExamType getExamTypeById(int examTypeID){
		try{
			ExamType instance = getEntityManager().find(ExamType.class, examTypeID);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	//得到所有的考试方式
	@SuppressWarnings("unchecked")
	public List<ExamType> getAllExamTypes(){
		List<ExamType> result = new ArrayList<ExamType>();
		try{
			String queryString = "from ExamType";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<ExamType>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllExamTypesByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.examTypeName) from ExamType model";
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
	
	//暂时不需要
	public boolean teachingPlanExistOrNot(String examTypeID){
		return false;
	}
	
	//---end
	
	//add by wxl
		public ArrayList<UtilObject> getExamTypeNameUtilObjectByIdList(ArrayList<String> examTypeIdList){
			final String queryString = "select e.examTypeName from ExamType e where e.id= :examTypeId";
			ArrayList<UtilObject> examTypeByIdList = new ArrayList<UtilObject>();
			try{
				for(Object o : examTypeIdList){
					UtilObject uo = new UtilObject();
					Query query = getEntityManager().createQuery(queryString.toString());
					query.setParameter("examTypeId", o.toString());

					List list =  query.getResultList();
					uo.setId(o.toString());
					uo.setName(list.get(0).toString());
					examTypeByIdList.add(uo);
				}
				
				return examTypeByIdList;
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		
		@SuppressWarnings("unchecked")
		public ArrayList<UtilObject> getAllUtilObjectELIdAndELN(){
			ArrayList<UtilObject> result = new ArrayList<UtilObject>();
			try{
				String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(el.id,el.examTypeName) from ExamType el";
				Query query = getEntityManager().createQuery(queryString);
				result = (ArrayList<UtilObject>)query.getResultList();
				return result;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		
		public String getExamTypeNameById(String examTypeId){
			final String queryString = "select e.examTypeName from ExamType e where e.id= :examTypeId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("examTypeId", examTypeId);

				List list =  query.getResultList();
		
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		
		//----------wxl end
		
		//add by zt @ 20121226
		public String getIdByName(String examTypeName){
			final String queryString = "select e.id from ExamType e where e.examTypeName= :examTypeName";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("examTypeName", examTypeName);

				List list =  query.getResultList();
				if(list.size()==0)return null;
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
		
		/**
		 * 根据examType的属性来查找考试方式信息
		 * @param property
		 * @param proValue
		 * @return
		 */
	    public ExamType getExamTypeByProperty(String property,String proValue,int id){
	    	String queryString = "from ExamType model where model."+property+" = '"+proValue +"' and model.id <> " + id;
			ExamType examType = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
	    		List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			examType = (ExamType) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return examType;	
	    }
	    
	    
	    /**
	     * 根据examType的属性来查找考试方式信息（没有id）
	     * @author yangyingjie
	     * @param property
	     * @param proValue
	     * @return
	     */
	    public ExamType getExamTypeByOneProperty(String property,String proValue){
	    	String queryString = "from ExamType model where model."+property+" = '"+proValue +"'" ;
			ExamType examType = null;
	    	try{
	    		Query query = getEntityManager().createQuery(queryString);
	    		List list = query.getResultList();
	    		if(!list.toString().equals("[]")){
	    			examType = (ExamType) list.get(0);
	    		}
	    	}catch(RuntimeException re){
	    		throw re;
	    	}finally{
	    		getEntityManager().close();
	    	}
	    	return examType;	
	    }
	    
//	    public CourseClass getCourseClassByProperty(String property,String proValue,int id){
//	    	String queryString = "from CourseClass model where model."+property+" = '"+proValue +"' and model.id <> " + id;
//	    	CourseClass courseClass = null;
//	    	try{
//	    		Query query = getEntityManager().createQuery(queryString);
//	    		List list = query.getResultList();
//	    		if(!list.toString().equals("[]")){
//	    			courseClass = (CourseClass) list.get(0);
//	    		}
//	    	}catch(RuntimeException re){
//	    		throw re;
//	    	}finally{
//	    		getEntityManager().close();
//	    	}
//	    	return courseClass;	

	    //得到最大id
	    public int getMaxExamTypeId(){
			String queryString = "select max(model.id) from ExamType model ";
			int maxExamTypeId=0;
			try{
				Query query= getEntityManager().createQuery(queryString);
				List list =query.getResultList();
				System.out.println("list="+list);
				if(!list.toString().equals("[null]")){
					maxExamTypeId = (Integer) list.get(0);
				}
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
			return maxExamTypeId;
		}

	
		
}
