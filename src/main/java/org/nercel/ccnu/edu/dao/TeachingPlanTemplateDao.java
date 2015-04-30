package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query; 

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TeachingPlanTemplateVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingPlanTemplate;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan;
import org.nercel.ccnu.edu.util.EntityManagerHelper;


public class TeachingPlanTemplateDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**添加
	 * * @param entity
	 */
	public void save(TeachingPlanTemplate entity){
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
	/*//删除
	public void delete(TeachingPlanTemplate entity){
		try {
			
			EntityManagerHelper.beginTransaction();

			entity = getEntityManager().getReference(TeachingPlanTemplate.class,
					entity.getId());
			getEntityManager().remove(entity);
			
			EntityManagerHelper.commit();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}*/
	//批量删除
	public boolean batchDelete(JSONObject ids) throws JSONException{
		/*String manageCenterID = "";
		for(int i = 0;i<ids.length();i++){
			manageCenterID = ids.getString(i+"");
			if(manageCenterOfficialIsExist(manageCenterID) || studyCenterIsExist(manageCenterID)){ //存在关联数据，不能删除
				return false;
			}
		}*/
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<ids.length();i++){
			queryString.append("?");
			if(i < (ids.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete TeachingPlanTemplate where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<ids.length();i++){
				query.setParameter(i+1, ids.getString(i+""));
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
	//修改
	public void  update(TeachingPlanTemplate entity){
		try {
			EntityManagerHelper.beginTransaction();
 
			getEntityManager().merge(entity);

			EntityManagerHelper.commit();
 
			 
		} catch (RuntimeException re) {
			 
			throw re;
		} finally {
			getEntityManager().close();
		}
		
	}
	
	public TeachingPlanTemplate findTemplateById(String id){
		
		try {
			TeachingPlanTemplate instance = getEntityManager().find(TeachingPlanTemplate.class,id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	public int getMaxTpTemplateCode(){
		try {
			
					
			final String queryString = "select max(model.tpTemplateCode) from TeachingPlanTemplate model where 1=1";
			Query query = getEntityManager().createQuery(queryString);		
			
            Integer maxCode = (Integer) query.getSingleResult();
			
			return  maxCode==null?0:maxCode;	
							
		} catch (RuntimeException re) {
			throw re;
		}
		
		
	}

	 /**
     * 条件查询
     * @param tptName 教学计划模板名
     * @param tptCode 教学计划模板代码
     * @param deductionModel 扣费模式
     * @param deductionRule 扣费规则
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<TeachingPlanTemplateVO> getTemplate(int belongProject,String tptName,String tptCode,int deductionModel,int deductionRule, int pageNo, int pageSize){
       
    	List<TeachingPlanTemplateVO> list = new ArrayList<TeachingPlanTemplateVO>();
    	StringBuilder queryString=new StringBuilder();
    	String queryBasic = "select new org.wy.ccnu.edu.entity.TeachingPlanTemplateVO(model.id," +
    			"model.tpTemplateName,model.tpTemplateCode,model.deductionModel,model.deductionRule," +
    			"model.dropTimeCode,model.dropTimeName,model.refundRate, tpi.trainingProjectName) " +
    			"from TeachingPlanTemplate model, TrainingProjectInfo tpi where tpi.id=model.belongProject ";
    	queryString.append(queryBasic);
    	if(belongProject !=0){
    		queryString.append(" and model.belongProject=:belongProject ");
    	}
    	if(!tptName.equals("null")  && !tptName.equals("")){
    		queryString.append(" and model.tpTemplateName=:tptName ");
    	}else if(!tptCode.equals("null") && !tptCode.equals("")){
    		queryString.append(" and model.tpTemplateCode like :tptCode ");
    	}
    	if(deductionModel !=0){
    		queryString.append(" and model.deductionModel=:deductionModel ");
    	}
    	if(deductionRule !=0){
    		queryString.append(" and model.deductionRule=:deductionRule ");
    	}
    	queryString.append(" order by model.tpTemplateCode asc");
    	
    	try{
			
			Query query = getEntityManager().createQuery(queryString.toString());
			 if(belongProject !=0){
		    		query.setParameter("belongProject", belongProject);
		    	}
			if(!tptName.equals("null") && !tptName.equals("")){
	    		query.setParameter("tptName", tptName);
	    	}else if(!tptCode.equals("null") && !tptCode.equals("")){
	    		query.setParameter("tptCode", "%"+tptCode+"%");
	    	}
	    	if(deductionModel !=0){
	    		query.setParameter("deductionModel", deductionModel);
	    	}
	    	if(deductionRule !=0){
	    		query.setParameter("deductionRule", deductionRule);
	    	}
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			for(Object o : query.getResultList()){
			   list.add((TeachingPlanTemplateVO)o);
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
    public int getTotalTemplates(int belongProject,String tptName,String tptCode,int deductionModel,int deductionRule){
    	int total = 0;
    	StringBuilder queryString=new StringBuilder();
		String queryBasic = "select count(model) from TeachingPlanTemplate model where 1=1 ";
		
		queryString.append(queryBasic);
    	if(belongProject !=0){
    		queryString.append(" and model.belongProject=:belongProject ");
    	}
    	if(!tptName.equals("null")  && !tptName.equals("")){
    		queryString.append(" and model.tpTemplateName=:tptName ");
    	}else if(!tptCode.equals("null") && !tptCode.equals("")){
    		queryString.append(" and model.tpTemplateCode like :tptCode ");
    	}
    	if(deductionModel !=0){
    		queryString.append(" and model.deductionModel=:deductionModel ");
    	}
    	if(deductionRule !=0){
    		queryString.append(" and model.deductionRule=:deductionRule ");
    	}
		
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString.toString());
			 if(belongProject !=0){
		    		query.setParameter("belongProject", belongProject);
		    	}
			if(!tptName.equals("null") && !tptName.equals("")){
	    		query.setParameter("tptName", tptName);
	    	}else if(!tptCode.equals("null") && !tptCode.equals("")){
	    		query.setParameter("tptCode", "%"+tptCode+"%");
	    	}
	    	if(deductionModel !=0){
	    		query.setParameter("deductionModel", deductionModel);
	    	}
	    	if(deductionRule !=0){
	    		query.setParameter("deductionRule", deductionRule);
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
     * 返回总数
     * @return
     */
    public int getTotalTemplates(){
    	int total = 0;
		String queryString = "select count(distinct model.tpTemplateName) from TeachingPlanTemplate model ";
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
     
    @SuppressWarnings("unchecked")
	public List<UtilObject> getAllCodeAndNameByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.tpTemplateCode,model.tpTemplateName) from TeachingPlanTemplate model order by model.tpTemplateName asc";
		try{
			List<UtilObject> results=null;
			Query query = getEntityManager().createQuery(queryString);
			 results = query.getResultList();
			 
			return results;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		 
		}
	}
    
    //依据名字获得代码 存到UtilObject对象中
    
 
	public UtilObject getCodeByNameByUtilObject(String tpTemplateName ){
    	String queryString = "select model.tpTemplateCode from TeachingPlanTemplate model where model.tpTemplateName=:tpTemplateName ";
		try{
			UtilObject result = new UtilObject(); 
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("tpTemplateName", tpTemplateName);
			result.setName(tpTemplateName);
		    result.setId(query.getSingleResult().toString());
			 
			 
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		 
		}
    	 
	}  
	 
	public boolean checkName(String tpTemplateName,String formalName){
		 
		String queryString ="select model.tpTemplateName from TeachingPlanTemplate model where model.tpTemplateName=:tpTemplateName ";
		if(!formalName.equals("")&&!formalName.equals("null")){
			 queryString =queryString+ " and model.tpTemplateName != :formalName ";
		}
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("tpTemplateName", tpTemplateName);
			if(!formalName.equals("")&&!formalName.equals("null")){
				query.setParameter("formalName", formalName);
			}
			String result = query.getSingleResult().toString();
			if(result != null){
				return true;
			}
			return false;
		}catch (NoResultException noResultException) {
			return false;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	public boolean checkCode(String tpTemplateCode,String formalCode){
		//System.out.println("======dao===="+tpTemplateCode);
		String queryString ="select model.tpTemplateCode from TeachingPlanTemplate model where model.tpTemplateCode=:tpTemplateCode ";
		if(!formalCode.equals("")&&!formalCode.equals("null")){
			 queryString =queryString+ " and model.tpTemplateCode != :formalCode ";
		}
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("tpTemplateCode", tpTemplateCode);
			if(!formalCode.equals("")&&!formalCode.equals("null")){
				query.setParameter("formalCode", formalCode);
			}
			String result = query.getSingleResult().toString();
			if(result != null){
				return true;
			}
			return false;
		}catch (NoResultException noResultException) {
			return false;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TeachingPlanTemplate> getTeachingPlanTemplateListByProperty(String property, String proValue){
		String queryString = "from TeachingPlanTemplate model where model." + property
				+ " like '%" + proValue + "%' ";
		List<TeachingPlanTemplate> list = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			list = query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return list;
	}
	
}
