package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.TrainingPlan_StudentVO;
import org.wy.ccnu.edu.entity.persist.TrainingPlan_Student;
import org.wy.ccnu.edu.util.EntityManagerHelper;

/**
 * 学生培训计划
 * @author liyong
 * 2014.0611
 */
public class TrainingPlan_StudentDao extends BaseDaoImpl<TrainingPlan_Student> {
	
	public boolean batchDeleteByIds(String ids){
		
		//条件判断，ifBeUsed(ids)
		
		String sql = "delete TrainingPlan_Student where id in ('" + ids.replace(",", "','") + "')";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);			
			query.executeUpdate();
			EntityManagerHelper.commit();
			return true;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	//约定：选择了培训计划名称或者培训计划模板名称，则默认显示已设置了培训计划的学生信息，
	//若没选择，则先分页查询学生，再为学生set培训计划相关的属性值，然后返回结果
	
	//学生报名的时候培训计划有初始化过程，就不必那么麻烦的分两种情况做了
	/**
	 * 根据条件查询学生培训计划信息
	 * @param trainingProjectId
	 * @param trainingPlanId
	 * @param teachingPlanPemplateId
	 * @param trainingBatchId
	 * @param stuInputType
	 * @param stuInputValue
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param educationLevelId
	 * @param specialId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TrainingPlan_StudentVO> getTrainingPlan_StudentByConditions(int trainingProjectId,
			String trainingPlanId,String teachingPlanTemplateId,int trainingBatchId, int stuInputType,
			String stuInputValue,String coagencyId,String teachingUnitInfoId,String educationLevelId,
			String specialId,int pageNo,int pageSize){

    	List<TrainingPlan_StudentVO> list = new ArrayList<TrainingPlan_StudentVO>();
    	StringBuilder queryString=new StringBuilder();
		
    	String queryBasic = "select new org.wy.ccnu.edu.entity.TrainingPlan_StudentVO(model.id, " +
    			"coagency.coagencyName,teachingUnitInfo.teachingUnitName,trainingBatch.trainingBatchName," +
    			"educationLevel.educationLevelName,special.specialName,model.studentId,studentInfo.realName," +
    			"studentInfo.studentNum,model.trainingPlanId,trainingPlan.trainingPlanName,model.trainingPlanTemplateId," +
    			"teachingPlanTemplate.tpTemplateName,model.addTime,model.loginName,tpi.trainingProjectName) " +
    			"from TrainingPlan_Student model, TrainingProjectInfo tpi, TrainingPlan trainingPlan," +
    			"TeachingPlanTemplate teachingPlanTemplate, TrainingBatch trainingBatch, Coagency coagency," +
    			"TeachingUnitInfo teachingUnitInfo, EducationLevel educationLevel,Special special," +
    			"StudentInfo studentInfo where tpi.id = model.belongProject and trainingPlan.id = model.trainingPlanId " +
    			"and teachingPlanTemplate.id = model.trainingPlanTemplateId and trainingBatch.id = model.trainingBatchId" +
    			" and coagency.id = model.coagencyId " +
    			"and teachingUnitInfo.id = model.teachingUnitId and educationLevel.id = model.educationLevelId " +
    			"and special.id = model.specialId and studentInfo.id = model.studentId  ";
    	queryString.append(queryBasic);
    	if(trainingProjectId != 0){
    		queryString.append(" and model.belongProject=:trainingProjectId ");
    	}
    	if(trainingPlanId!= null && !trainingPlanId.equals("null")  && !trainingPlanId.equals("")){
    		queryString.append(" and model.trainingPlanId=:trainingPlanId ");
    	}
    	if(teachingPlanTemplateId != null && !teachingPlanTemplateId.equals("null")  && !teachingPlanTemplateId.equals("")){
    		queryString.append(" and model.teachingPlanTemplateId=:teachingPlanTemplateId ");
    	}
    	
    	if(coagencyId!= null && !coagencyId.equals("null")  && !coagencyId.equals("")){
    		queryString.append(" and model.coagencyId=:coagencyId ");
    	}
    	if(teachingUnitInfoId != null && !teachingUnitInfoId.equals("null")  && !teachingUnitInfoId.equals("")){
    		queryString.append(" and model.teachingUnitInfoId=:teachingUnitInfoId ");
    	}
    	
    	if(trainingBatchId !=0){
    		queryString.append(" and model.trainingBatchId=:trainingBatchId ");
    	}    	
    	if(educationLevelId!= null && !educationLevelId.equals("null")  && !educationLevelId.equals("")){
    		queryString.append(" and model.educationLevelId=:educationLevelId ");
    	}
    	if(specialId != null && !specialId.equals("null")  && !specialId.equals("")){
    		queryString.append(" and model.specialId=:specialId ");
    	}
    	
    	if(stuInputType !=0 && (stuInputValue!= null && !stuInputValue.equals("null")  && !stuInputValue.equals(""))){
    			switch(stuInputType){
	    			case 1:queryString.append(" and studentInfo.realName like '%"+stuInputValue+"%'");break;	//姓名
	    			case 2:queryString.append(" and studentInfo.studentNum like '%"+stuInputValue+"%'");break;	//学号
	    			case 3:queryString.append(" and studentInfo.loginName like '%"+stuInputValue+"%'");break;	//用户名    			
	    		} 
    		  		
    	}
    	
    	queryString.append(" order by model.coagencyId asc");
    	 
    	try{
			
			Query query = getEntityManager().createQuery(queryString.toString());
			if(trainingProjectId != 0){
	    		query.setParameter("trainingProjectId", trainingProjectId);
	    	}
	    	if(trainingPlanId!= null && !trainingPlanId.equals("null")  && !trainingPlanId.equals("")){
	    		query.setParameter("trainingPlanId", trainingPlanId);
	    	}
	    	if(teachingPlanTemplateId != null && !teachingPlanTemplateId.equals("null")  && !teachingPlanTemplateId.equals("")){
	    		query.setParameter("teachingPlanTemplateId", teachingPlanTemplateId);
	    	}
	    	
	    	if(coagencyId!= null && !coagencyId.equals("null")  && !coagencyId.equals("")){
	    		query.setParameter("coagencyId", coagencyId);
	    	}
	    	if(teachingUnitInfoId != null && !teachingUnitInfoId.equals("null")  && !teachingUnitInfoId.equals("")){
	    		query.setParameter("teachingUnitInfoId", teachingUnitInfoId);
	    	}
	    	
	    	if(trainingBatchId !=0){
	    		query.setParameter("trainingBatchId", trainingBatchId);
	    	}    	
	    	if(educationLevelId!= null && !educationLevelId.equals("null")  && !educationLevelId.equals("")){
	    		query.setParameter("educationLevelId", educationLevelId);
	    	}
	    	if(specialId != null && !specialId.equals("null")  && !specialId.equals("")){
	    		query.setParameter("specialId", specialId);
	    	}
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			list = query.getResultList();
			if(list == null || list.size() == 0)
				list = null;
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		
	}
	
	/**
	 * 根据条件查询学生培训计划信息记录数
	 * @param trainingProjectId
	 * @param trainingPlanId
	 * @param teachingPlanPemplateId
	 * @param trainingBatchId
	 * @param stuInputType
	 * @param stuInputValue
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param educationLevelId
	 * @param specialId
	 * @return
	 */
	public int getRecordsOfTrainingPlan_StudentByConditions(int trainingProjectId,
			String trainingPlanId,String teachingPlanTemplateId,int trainingBatchId, int stuInputType,
			String stuInputValue,String coagencyId,String teachingUnitInfoId,String educationLevelId,
			String specialId){
		int result = 0;
		StringBuilder queryString=new StringBuilder();
    	String queryBasic = "select count(model) from TrainingPlan_Student model where 1=1 ";
    	if(stuInputType !=0 && (stuInputValue!= null && !stuInputValue.equals("null")  && !stuInputValue.equals("")))
    		queryBasic = "select count(model) from TrainingPlan_Student model, StudentInfo studentInfo where 1=1 ";
    	queryString.append(queryBasic);
    	if(trainingProjectId != 0){
    		queryString.append(" and model.belongProject=:trainingProjectId ");
    	}
    	if(trainingPlanId!= null && !trainingPlanId.equals("null")  && !trainingPlanId.equals("")){
    		queryString.append(" and model.trainingPlanId=:trainingPlanId ");
    	}
    	if(teachingPlanTemplateId != null && !teachingPlanTemplateId.equals("null")  && !teachingPlanTemplateId.equals("")){
    		queryString.append(" and model.teachingPlanTemplateId=:teachingPlanTemplateId ");
    	}
    	
    	if(coagencyId!= null && !coagencyId.equals("null")  && !coagencyId.equals("")){
    		queryString.append(" and model.coagencyId=:coagencyId ");
    	}
    	if(teachingUnitInfoId != null && !teachingUnitInfoId.equals("null")  && !teachingUnitInfoId.equals("")){
    		queryString.append(" and model.teachingUnitInfoId=:teachingUnitInfoId ");
    	}
    	
    	if(trainingBatchId !=0){
    		queryString.append(" and model.trainingBatchId=:trainingBatchId ");
    	}    	
    	if(educationLevelId!= null && !educationLevelId.equals("null")  && !educationLevelId.equals("")){
    		queryString.append(" and model.educationLevelId=:educationLevelId ");
    	}
    	if(specialId != null && !specialId.equals("null")  && !specialId.equals("")){
    		queryString.append(" and model.specialId=:specialId ");
    	}
    	
    	if(stuInputType !=0 && (stuInputValue!= null && !stuInputValue.equals("null")  && !stuInputValue.equals(""))){
			switch(stuInputType){
    			case 1:queryString.append(" and studentInfo.realName like '%"+stuInputValue+"%'");break;	//姓名
    			case 2:queryString.append(" and studentInfo.studentNum like '%"+stuInputValue+"%'");break;	//学号
    			case 3:queryString.append(" and studentInfo.loginName like '%"+stuInputValue+"%'");break;	//用户名    			
    		} 
    	}
    	try{
			Query query = getEntityManager().createQuery(queryString.toString());
			if(trainingProjectId != 0){
	    		query.setParameter("trainingProjectId", trainingProjectId);
	    	}
	    	if(trainingPlanId!= null && !trainingPlanId.equals("null")  && !trainingPlanId.equals("")){
	    		query.setParameter("trainingPlanId", trainingPlanId);
	    	}
	    	if(teachingPlanTemplateId != null && !teachingPlanTemplateId.equals("null")  && !teachingPlanTemplateId.equals("")){
	    		query.setParameter("teachingPlanPemplateId", teachingPlanTemplateId);
	    	}
	    	
	    	if(coagencyId!= null && !coagencyId.equals("null")  && !coagencyId.equals("")){
	    		query.setParameter("coagencyId", coagencyId);
	    	}
	    	if(teachingUnitInfoId != null && !teachingUnitInfoId.equals("null")  && !teachingUnitInfoId.equals("")){
	    		query.setParameter("teachingUnitInfoId", teachingUnitInfoId);
	    	}
	    	
	    	if(trainingBatchId !=0){
	    		query.setParameter("trainingBatchId", trainingBatchId);
	    	}    	
	    	if(educationLevelId!= null && !educationLevelId.equals("null")  && !educationLevelId.equals("")){
	    		query.setParameter("educationLevelId", educationLevelId);
	    	}
	    	if(specialId != null && !specialId.equals("null")  && !specialId.equals("")){
	    		query.setParameter("specialId", specialId);
	    	}
			
	    	Long count = (Long) query.getSingleResult();
	    	
			result = count.intValue();
		
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * 批量设置学生培训计划
	 * @param ids						--学生培训计划ids
	 * @param trainingPlanId				--培训计划库id
	 * @param teachingPlanPemplateId	--培训计划模板库id
	 */
	public void batchUpdateTrainingPlan_Student(String ids, String trainingPlanId,String teachingPlanPemplateId){
		String sql = "update TrainingPlan_Student set trainingPlanId=:trainingPlanId, " +
				"teachingPlanPemplateId=:teachingPlanPemplateId where id in ('" + ids.replace(",", "','") + "')";
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
}
