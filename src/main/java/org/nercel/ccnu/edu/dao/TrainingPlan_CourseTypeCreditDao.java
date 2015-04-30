package org.nercel.ccnu.edu.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan_CourseTypeCredit;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class TrainingPlan_CourseTypeCreditDao extends
		BaseDaoImpl<TrainingPlan_CourseTypeCredit> {

	/**
	 * 删除
	 * 
	 * @param ids
	 * 
	 * @throws JSONException
	 */
	public void delete(String ids) throws JSONException {
		String sql = "delete TrainingPlan_CourseTypeCredit where id in ( '"
				+ ids.replace(",", "','") + "' )";
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
		String sql = "select count(*) from TrainingPlan_CourseTypeCredit";
		Query query = getEntityManager().createQuery(sql);
		int count = 0;
		count = Integer.parseInt(query.getSingleResult().toString());
		return count;

	}

	/**
	 * 根据培养计划id、课程类别代码和学生id来查询该培养计划该课程类别的最大选修学分
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别代码
	 * @param studentId
	 * 			学生id
	 * @return
	 * 			返回单个对象TrainingPlan_CourseTypeCredit
	 */
	public TrainingPlan_CourseTypeCredit getTPTypeCreditByPlanIdAndCodeAndStuId(
			String trainingPlanId, String courseTypeCode, String studentId) {
		String hql ="from TrainingPlan_CourseTypeCredit model where model.trainingPlanId =:trainingPlanId " +
				" and model.courseTypeCode =:courseTypeCode ";
		TrainingPlan_CourseTypeCredit instance = null;
		try{
			if (StringUtils.isNotBlank(studentId)) {
				hql += " and model.studentId =:studentId ";
			}else{
				hql += " and model.studentId is null ";
			}
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("trainingPlanId", trainingPlanId);
			query.setParameter("courseTypeCode", courseTypeCode);
			if (StringUtils.isNotBlank(studentId)) {
				query.setParameter("studentId", studentId);
			}
			List list = query.getResultList();
			if(null != list && !list.isEmpty()){
				instance = (TrainingPlan_CourseTypeCredit) list.get(0);
			}
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

	/**
	 * 根据培养计划id来查询其所有类别的课程的最大选修学分的信息
	 * @param trainingPlanId
	 * @return
	 */
	public List<TrainingPlan_CourseTypeCredit> getTrainingPlan_CourseTypeCreditByPlanId(String trainingPlanId){
		String hql ="from TrainingPlan_CourseTypeCredit model where model.trainingPlanId =:trainingPlanId " +
				" and model.studentId is null ";
		List<TrainingPlan_CourseTypeCredit> list = null;
		try{
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("trainingPlanId", trainingPlanId);
			list = query.getResultList();
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
}
