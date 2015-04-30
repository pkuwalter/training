package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.TrainingPlanVO;
import org.wy.ccnu.edu.entity.persist.TrainingPlan;
import org.wy.ccnu.edu.util.EntityManagerHelper;


public class TrainingPlanDao extends BaseDaoImpl<TrainingPlan> {

	/*
	 * 删除
	 * 
	 * @param ids
	 * 
	 * @throws JSONException
	 */
	public void delete(String ids) throws JSONException {
		String sql = "delete TrainingPlan where id in ( '" + ids.replace("", "','") + "')";
		Query query = null;
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

	/**
	 * 记录总数
	 * 
	 * @return
	 */
	public int countAll() {
		String sql = "select count(*) from TrainingPlan";
		Query query = getEntityManager().createQuery(sql);
		int count = 0;
		count = Integer.parseInt(query.getSingleResult().toString());
		return count;
		
	}

	/**
	 * 根据给定的属性及属性值来模糊查询培养计划列表
	 * @param property
	 * @param proValue
	 * @return
	 */
	public List<TrainingPlan> getTrainingPlanListByProperty(String property,
			String proValue) {
		String queryString = "from TrainingPlan model where model." + property
				+ " like '%" + proValue + "%' ";
		List<TrainingPlan> planList = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			planList = query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return planList;
	}
	
	/**
	 * 根据给定的属性及属性值来查询指定的培养计划
	 * @param property
	 * @param proValue
	 * @return
	 */
	public TrainingPlan getTrainingPlanByProperty(String property,
			String proValue) {
		String queryString = "from TrainingPlan model where model." + property
				+ " = '" + proValue + "' ";
		TrainingPlan entity = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			List list = query.getResultList();
			if(null != list && !list.isEmpty()){
				entity = (TrainingPlan) list.get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return entity;
	}

	/**
	 * 查找满足条件的培训计划库
	 * @param trainingProjectId
	 * 			所属项目id
	 * @param trainingProjectCode
	 * 			所属项目的代码
	 * @param trainingPlanId
	 * 			培训计划id
	 * @param trainingPlanCode
	 * 			培训计划代码
	 * @param specialID
	 * 			学科id
	 * @param eduLevelId
	 * 			培训类型id
	 * @param version
	 * 			培训计划版本
	 * @param beginTime
	 * 			开始时间
	 * @param endTime
	 * 			结束时间
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List<TrainingPlanVO> searchTrainingPlanInfo(
			int trainingProjectId, String trainingProjectCode,
			String trainingPlanId, String trainingPlanCode, String specialID,
			String eduLevelId, String version, String beginTime, String endTime,
			int pageSize, int pageNo) {
		String queryBasic = "select new org.wy.ccnu.edu.entity.TrainingPlanVO(model.id, proInfo.trainingProjectName, " +
				" proInfo.trainingProjectCode, model.trainingPlanName, model.trainingPlanCode, level.educationLevelName, " +
				" special.specialName, model.version, model.addTime,model.remark) from TrainingPlan model,TrainingProjectInfo proInfo," +
				" Special special, EducationLevel level where model.trainingProjectId = proInfo.id and model.special = special.id " +
				" and model.eudcationLevel = level.id ";
		StringBuilder queryString = new StringBuilder();
		queryString.append(queryBasic);
		List<TrainingPlanVO> list = null;
		try{
			if(0 != trainingProjectId){
				queryString.append(" and proInfo.id =:trainingProjectId ");
			}
			if(!"0".equals(trainingProjectCode) && StringUtils.isNotBlank(trainingProjectCode)){
				queryString.append(" and proInfo.trainingProjectCode =:trainingProjectCode ");
			}
			if(!"0".equals(trainingPlanId) && StringUtils.isNotBlank(trainingPlanId)){
				queryString.append(" and model.id =:trainingPlanId ");
			}
			if(!"0".equals(trainingPlanCode) && StringUtils.isNotBlank(trainingPlanCode)){
				queryString.append(" and model.trainingPlanCode =:trainingPlanCode ");
			}
			if(!"0".equals(specialID) && StringUtils.isNotBlank(specialID)){
				queryString.append(" and special.id =:specialID ");
			}
			if(!"0".equals(eduLevelId) && StringUtils.isNotBlank(eduLevelId)){
				queryString.append(" and level.id =:eduLevelId ");
			}
			if(!"0".equals(version) && StringUtils.isNotBlank(version)){
				queryString.append(" and model.version =:version ");
			}
			if(!"0".equals(beginTime) && StringUtils.isNotBlank(beginTime)){
				queryString.append(" and model.addTime >=:beginTime ");
			}
			if(!"0".equals(endTime) && StringUtils.isNotBlank(endTime)){
				queryString.append(" and model.addTime <=:endTime ");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(0 != trainingProjectId){
				query.setParameter("trainingProjectId", trainingProjectId);
			}
			if(!"0".equals(trainingProjectCode) && StringUtils.isNotBlank(trainingProjectCode)){
				query.setParameter("trainingProjectCode", trainingProjectCode);
			}
			if(!"0".equals(trainingPlanId) && StringUtils.isNotBlank(trainingPlanId)){
				query.setParameter("trainingPlanId", trainingPlanId);
			}
			if(!"0".equals(trainingPlanCode) && StringUtils.isNotBlank(trainingPlanCode)){
				query.setParameter("trainingPlanCode", trainingPlanCode);
			}
			if(!"0".equals(specialID) && StringUtils.isNotBlank(specialID)){
				query.setParameter("specialID", specialID);
			}
			if(!"0".equals(eduLevelId) && StringUtils.isNotBlank(eduLevelId)){
				query.setParameter("eduLevelId", eduLevelId);
			}
			if(!"0".equals(version) && StringUtils.isNotBlank(version)){
				query.setParameter("version", version);
			}
			if(!"0".equals(beginTime) && StringUtils.isNotBlank(beginTime)){
				query.setParameter("beginTime", beginTime);
			}
			if(!"0".equals(endTime) && StringUtils.isNotBlank(endTime)){
				query.setParameter("endTime", endTime);
			}
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			list = query.getResultList();
			return list;
			
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	/**
	 * 查找满足条件的培训计划库的记录数
	 * @param trainingProjectId
	 * 			所属项目id
	 * @param trainingProjectCode
	 * 			所属项目的代码
	 * @param trainingPlanId
	 * 			培训计划id
	 * @param trainingPlanCode
	 * 			培训计划代码
	 * @param specialID
	 * 			学科id
	 * @param eduLevelId
	 * 			培训类型id
	 * @param version
	 * 			培训计划版本
	 * @param beginTime
	 * 			开始时间
	 * @param endTime
	 * 			结束时间
	 * @return
	 */
	public int countTrainingPlanInfo(
			int trainingProjectId, String trainingProjectCode,
			String trainingPlanId, String trainingPlanCode, String specialID,
			String eduLevelId, String version, String beginTime, String endTime) {
		String queryBasic = "select new org.wy.ccnu.edu.entity.TrainingPlanVO(model.id, proInfo.trainingProjectName, " +
				" proInfo.trainingProjectCode, model.trainingPlanName, model.trainingPlanCode, level.educationLevelName, " +
				" special.specialName, model.version, model.addTime,model.remark) from TrainingPlan model,TrainingProjectInfo proInfo," +
				" Special special, EducationLevel level where model.trainingProjectId = proInfo.id and model.special = special.id " +
				" and model.eudcationLevel = level.id ";
		StringBuilder queryString = new StringBuilder();
		queryString.append(queryBasic);
		int totalRecord = 0;
		try{
			if(0 != trainingProjectId){
				queryString.append(" and proInfo.id =:trainingProjectId ");
			}
			if(!"0".equals(trainingProjectCode) && StringUtils.isNotBlank(trainingProjectCode)){
				queryString.append(" and proInfo.trainingProjectCode =:trainingProjectCode ");
			}
			if(!"0".equals(trainingPlanId) && StringUtils.isNotBlank(trainingPlanId)){
				queryString.append(" and model.id =:trainingPlanId ");
			}
			if(!"0".equals(trainingPlanCode) && StringUtils.isNotBlank(trainingPlanCode)){
				queryString.append(" and model.trainingPlanCode =:trainingPlanCode ");
			}
			if(!"0".equals(specialID) && StringUtils.isNotBlank(specialID)){
				queryString.append(" and special.id =:specialID ");
			}
			if(!"0".equals(eduLevelId) && StringUtils.isNotBlank(eduLevelId)){
				queryString.append(" and level.id =:eduLevelId ");
			}
			if(!"0".equals(version) && StringUtils.isNotBlank(version)){
				queryString.append(" and model.version =:version ");
			}
			if(!"0".equals(beginTime) && StringUtils.isNotBlank(beginTime)){
				queryString.append(" and model.addTime >=:beginTime ");
			}
			if(!"0".equals(endTime) && StringUtils.isNotBlank(endTime)){
				queryString.append(" and model.addTime <=:endTime ");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(0 != trainingProjectId){
				query.setParameter("trainingProjectId", trainingProjectId);
			}
			if(!"0".equals(trainingProjectCode) && StringUtils.isNotBlank(trainingProjectCode)){
				query.setParameter("trainingProjectCode", trainingProjectCode);
			}
			if(!"0".equals(trainingPlanId) && StringUtils.isNotBlank(trainingPlanId)){
				query.setParameter("trainingPlanId", trainingPlanId);
			}
			if(!"0".equals(trainingPlanCode) && StringUtils.isNotBlank(trainingPlanCode)){
				query.setParameter("trainingPlanCode", trainingPlanCode);
			}
			if(!"0".equals(specialID) && StringUtils.isNotBlank(specialID)){
				query.setParameter("specialID", specialID);
			}
			if(!"0".equals(eduLevelId) && StringUtils.isNotBlank(eduLevelId)){
				query.setParameter("eduLevelId", eduLevelId);
			}
			if(!"0".equals(version) && StringUtils.isNotBlank(version)){
				query.setParameter("version", version);
			}
			if(!"0".equals(beginTime) && StringUtils.isNotBlank(beginTime)){
				query.setParameter("beginTime", beginTime);
			}
			if(!"0".equals(endTime) && StringUtils.isNotBlank(endTime)){
				query.setParameter("endTime", endTime);
			}
			List list = query.getResultList();
			if(null != list && !list.isEmpty()){
				totalRecord = list.size();
			}
			return totalRecord;
			
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
}
