package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.TrainingPlanCourseInfoVO;
import org.wy.ccnu.edu.entity.persist.TrainingPlan_CourseInfo;
import org.wy.ccnu.edu.entity.persist.TrainingPlan_CourseTypeCredit;
import org.wy.ccnu.edu.util.EntityManagerHelper;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

public class TrainingPlan_CourseInfoDao extends
		BaseDaoImpl<TrainingPlan_CourseInfo> {

	/**
	 * 删除
	 * 
	 * @param ids
	 * 
	 * @throws JSONException
	 */
	public void delete(String ids) throws JSONException {
		String sql = "delete TrainingPlan_CourseInfo where id in ( '" + ids.replace(",", "','")
				+ "')";
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
		String sql = "select count(*) from TrainingPlan_CourseInfo ";
		Query query = getEntityManager().createQuery(sql);
		int count = 0;
		count = Integer.parseInt(query.getSingleResult().toString());
		return count;

	}

	/**
	 * 根据给定的属性及属性值来查询指定的培养计划课程信息
	 * 
	 * @param property
	 * @param proValue
	 * @return
	 */
	public TrainingPlan_CourseInfo getTrainingPlan_CourseInfoByProperty(
			String property, String proValue) {
		String queryString = "from TrainingPlan_CourseInfo model where model."
				+ property + " = '" + proValue + "' and model.studentId is null  ";
		TrainingPlan_CourseInfo entity = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			List list = query.getResultList();
			if(null != list && !list.isEmpty()){
				entity = (TrainingPlan_CourseInfo) list.get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return entity;
	}

	/**
	 * 根据培养计划 的id、课程类别的code和学生id查询培养计划课程信息
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别code
	 * @param studentId
	 * 			学生id
	 * @return
	 * 			培养计划课程信息列表List
	 */
	public List<TrainingPlanCourseInfoVO> getTPCourseVOByPlanIdAndCodeAndStuId(
			String trainingPlanId, String courseTypeCode, String studentId) {
		String queryBasic = "select new org.wy.ccnu.edu.entity.TrainingPlanCourseInfoVO(model.id, course.courseName, course.courseCode, " +
				" model.stage, model.credit,model.learningTime,examType.examTypeName, courseClass.courseClassName,courseType.courseTypeName, " +
				" model.scales, case when model.isXKYTH=1 then '是' else '否'  end, case when model.isInTotalCredit=1 then '是' else '否'  end, " +
				" case when model.isInAvgScore=1 then '是' else '否'  end,  case when model.isDegreeCourse=1 then '是' else '否'  end, " +
				" model.remark, course.id)  from TrainingPlan_CourseInfo model,CourseInfo course, ExamType examType, CourseClass courseClass, " +
				" CourseType courseType where model.examTypeCode = examType.examTypeCode and " +
				" model.courseClassCode = courseClass.courseClassCode " +
				" and model.courseId = course.id and model.courseTypeCode = courseType.courseTypeCode ";
		StringBuilder queryString = new StringBuilder();
		List<TrainingPlanCourseInfoVO> list = null;
		queryString.append(queryBasic);
		try {
			if (StringUtils.isNotBlank(trainingPlanId)) {
				queryString.append(" and model.trainingPlanId =:trainingPlanId ");
			}
			if (StringUtils.isNotBlank(courseTypeCode)) {
				queryString.append(" and model.courseTypeCode =:courseTypeCode ");
			}
			if (StringUtils.isNotBlank(studentId)) {
				queryString.append(" and model.studentId =:studentId ");
			}else{
				queryString.append(" and model.studentId is null ");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			if (StringUtils.isNotBlank(trainingPlanId)) {
				query.setParameter("trainingPlanId", trainingPlanId);
			}
			if (StringUtils.isNotBlank(courseTypeCode)) {
				query.setParameter("courseTypeCode", courseTypeCode);
			}
			if (StringUtils.isNotBlank(studentId)) {
				query.setParameter("studentId", studentId);
			}
			list = query.getResultList();
			return list;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据培养计划id和课程类别代码来查询该培养计划该课程类别已经选修的学分
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别代码
	 * @return
	 * 			返回countCredit
	 */
	public int countCreditOfChooseCourseType(String trainingPlanId, String courseTypeCode) {
		String hql ="select sum(model.credit) from TrainingPlan_CourseInfo model where model.trainingPlanId =:trainingPlanId " +
				" and model.courseTypeCode =:courseTypeCode and model.studentId is null  ";
		int countCredit = 0;
		try{
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("trainingPlanId", trainingPlanId);
			query.setParameter("courseTypeCode", courseTypeCode);
			List list = query.getResultList();
			if(null != list && !list.isEmpty()){
				countCredit = new Integer(list.get(0).toString());
			}
			return countCredit;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * 根据培养计划id来查询课程信息列表
	 * @param trainingPlanId
	 * 			培养计划id
	 * @return
	 * 			List<TrainingPlan_CourseInfo>
	 */
	public List<TrainingPlan_CourseInfo> getTrainingPlan_CourseInfoByPlanId(String trainingPlanId){
		String hql = "from TrainingPlan_CourseInfo model where model.trainingPlanId =:trainingPlanId " +
				" and model.studentId is null ";
		List<TrainingPlan_CourseInfo> list = null;
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
