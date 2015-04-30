package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.TrainingProjectPlanVO;
import org.wy.ccnu.edu.entity.persist.TrainingProjectPlan;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class TrainingProjectPlanDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 增加培训计划信息
	 * 
	 * @param entity
	 */
	public void save(TrainingProjectPlan entity) {

		try {
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

	}

	/**
	 * 删除培训计划信息
	 * 
	 * @param entity
	 */
	public void delete(TrainingProjectPlan entity) {

		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(TrainingProjectPlan.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	/**
	 * 修改培训计划信息
	 * 
	 * @param entity
	 */
	public void update(TrainingProjectPlan entity) {

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

	/**
	 * 获取培训计划信息的最大的Id
	 * 
	 * @return
	 */
	public int getMaxTrainingProjectPlanId() {
		try {

			final String queryString = "select max(model.id) from TrainingProjectPlan model where 1=1";
			Query query = getEntityManager().createQuery(queryString);

			Integer maxId = (Integer) query.getSingleResult();

			return maxId == null ? 0 : maxId;

		} catch (RuntimeException re) {
			throw re;
		}

	}

	/**
	 * 获取所有培训计划的列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TrainingProjectPlan> getAllTrainingProjectPlan() {
		List<TrainingProjectPlan> result = new ArrayList<TrainingProjectPlan>();
		try {
			String queryString = "select model from TrainingProjectPlan model where 1=1";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<TrainingProjectPlan>) query.getResultList();
			return result;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据培训计划ID获取培训计划信息
	 * 
	 * @param trainingProjectPlanId
	 * @return
	 */
	public TrainingProjectPlan getTrainingProjectPlanById(
			int trainingProjectPlanId) {
		try {
			TrainingProjectPlan instance = getEntityManager().find(
					TrainingProjectPlan.class, trainingProjectPlanId);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据TrainingProjectPlan的属性来查找培训计划信息
	 * 
	 * @param property培训计划属性
	 * @param proValue属性的值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public TrainingProjectPlan getTrainingProjectPlanByProperty(
			String property, String proValue) {
		String queryString = "from TrainingProjectPlan model where model."
				+ property + " = '" + proValue + "'";
		TrainingProjectPlan entity = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			List list = query.getResultList();
			if (!list.toString().equals("[]")) {
				entity = (TrainingProjectPlan) list.get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return entity;
	}

	/**
	 * 批量删除培训计划信息
	 * 
	 * @param trainingProjectPlanIds
	 * @return
	 * @throws JSONException
	 */
	public boolean batchDeleteTrainingProjectPlan(
			JSONObject trainingProjectPlanIds) throws JSONException {

		StringBuilder queryString = new StringBuilder();
		for (int i = 0; i < trainingProjectPlanIds.length(); i++) {
			queryString.append("?");
			if (i < (trainingProjectPlanIds.length() - 1)) {
				queryString.append(",");
			}
		}
		String sql = "delete TrainingProjectPlan where id in ( "
				+ queryString.toString() + ")";
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for (int i = 0; i < trainingProjectPlanIds.length(); i++) {
				query.setParameter(
						i + 1,
						Integer.parseInt(trainingProjectPlanIds.getString(i
								+ "")));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
			return true;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 条件查询：获取培训计划设置的详细信息（获取培训计划设置的学费标准查看界面详细信息）
	 * 
	 * @param trainingProjectId
	 * @param trainingProjectCode
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TrainingProjectPlanVO> getAllTrainingProjectPlanVOInPage(
			int trainingProjectId, String trainingProjectCode,
			int trainingBatchId, String coagencyId, String teachingUnitId,
			int pageNo, int pageSize) {

		List<TrainingProjectPlanVO> list = new ArrayList<TrainingProjectPlanVO>();

		String basicString = "select new org.wy.ccnu.edu.entity.TrainingProjectPlanVO(trainingprojectplan.id,trainingprojectinfo.trainingProjectName,"
				+ "trainingbatch.trainingBatchName,coagency.coagencyName,teachingunitinfo.teachingUnitName,educationlevel.educationLevelName,special.specialName,"
				+ "trainingprojectplan.amount,trainingprojectplan.feeStandard) "
				+ "from TrainingProjectInfo trainingprojectinfo,TrainingBatch trainingbatch,Coagency coagency,"
				+ "TrainingProjectPlan trainingprojectplan,TeachingUnitInfo teachingunitinfo,EducationLevel educationlevel,Special special "
				+ "where trainingprojectplan.trainingProjectId = trainingprojectinfo.id and trainingprojectplan.trainingBatchId = trainingbatch.id "
				+ "and trainingprojectplan.coagencyId = coagency.id and trainingprojectplan.teachingUnitInfoId = teachingunitinfo.id "
				+ "and trainingprojectplan.specialId = special.id and trainingprojectplan.educationLevelId = educationLevel.id ";

		StringBuilder queryString = new StringBuilder(basicString);

		if (trainingProjectId != 0 && !"".equals(trainingProjectId)) {
			queryString
					.append(" and trainingprojectinfo.id = :trainingProjectId");
		}

		if (trainingProjectCode != null
				&& !trainingProjectCode.trim().equals("")
				&& !trainingProjectCode.equals("null")) {

			queryString
					.append(" and trainingprojectinfo.trainingProjectCode = :trainingProjectCode");
		}

		if (trainingBatchId != 0 && !"".equals(trainingBatchId)) {
			queryString.append(" and trainingbatch.id = :trainingBatchId");
		}

		if (coagencyId != null && !coagencyId.trim().equals("")
				&& !coagencyId.equals("null")) {

			queryString.append(" and coagency.id = :coagencyId");
		}

		if (teachingUnitId != null && !teachingUnitId.trim().equals("")
				&& !teachingUnitId.equals("null")) {

			queryString.append(" and teachingunitinfo.id = :teachingUnitId");
		}

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (trainingProjectId != 0 && !"".equals(trainingProjectId)) {

				query.setParameter("trainingProjectId", trainingProjectId);
			}
			if (trainingProjectCode != null
					&& !trainingProjectCode.trim().equals("")
					&& !trainingProjectCode.equals("null")) {

				query.setParameter("trainingProjectCode", trainingProjectCode);
			}

			if (trainingBatchId != 0 && !"".equals(trainingBatchId)) {

				query.setParameter("trainingBatchId", trainingBatchId);
			}

			if (coagencyId != null && !coagencyId.trim().equals("")
					&& !coagencyId.equals("null")) {
				query.setParameter("coagencyId", coagencyId);
			}

			if (teachingUnitId != null && !teachingUnitId.trim().equals("")
					&& !teachingUnitId.equals("null")) {
				query.setParameter("teachingUnitId", teachingUnitId);

			}

			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = (List<TrainingProjectPlanVO>) query.getResultList();
			if (list.size() == 0) {
				list = null;
			}
			return list;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

	}

	/**
	 * 条件查询：获取培训计划设置的总记录数
	 * 
	 * @param trainingProjectId
	 * @param trainingProjectCode
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitId
	 * @return
	 */
	public int getTotalTrainingProjectPlanVO(int trainingProjectId,
			String trainingProjectCode, int trainingBatchId, String coagencyId,
			String teachingUnitId) {

		int total = 0;
		String basicString = "select count(*) "
				+ "from TrainingProjectInfo trainingprojectinfo,TrainingBatch trainingbatch,Coagency coagency,"
				+ "TrainingProjectPlan trainingprojectplan,TeachingUnitInfo teachingunitinfo,EducationLevel educationlevel,Special special "
				+ "where trainingprojectplan.trainingProjectId = trainingprojectinfo.id and trainingprojectplan.trainingBatchId = trainingbatch.id "
				+ "and trainingprojectplan.coagencyId = coagency.id and trainingprojectplan.teachingUnitInfoId = teachingunitinfo.id "
				+ "and trainingprojectplan.specialId = special.id and trainingprojectplan.educationLevelId = educationLevel.id ";

		StringBuilder queryString = new StringBuilder(basicString);

		if (trainingProjectId != 0 && !"".equals(trainingProjectId)) {
			queryString
					.append(" and trainingprojectinfo.id = :trainingProjectId");
		}

		if (trainingProjectCode != null
				&& !trainingProjectCode.trim().equals("")
				&& !trainingProjectCode.equals("null")) {

			queryString
					.append(" and trainingprojectinfo.trainingProjectCode = :trainingProjectCode");
		}

		if (trainingBatchId != 0 && !"".equals(trainingBatchId)) {
			queryString.append(" and trainingbatch.id = :trainingBatchId");
		}

		if (coagencyId != null && !coagencyId.trim().equals("")
				&& !coagencyId.equals("null")) {

			queryString.append(" and coagency.id = :coagencyId");
		}

		if (teachingUnitId != null && !teachingUnitId.trim().equals("")
				&& !teachingUnitId.equals("null")) {

			queryString.append(" and teachingunitinfo.id = :teachingUnitId");
		}

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (trainingProjectId != 0 && !"".equals(trainingProjectId)) {

				query.setParameter("trainingProjectId", trainingProjectId);
			}
			if (trainingProjectCode != null
					&& !trainingProjectCode.trim().equals("")
					&& !trainingProjectCode.equals("null")) {

				query.setParameter("trainingProjectCode", trainingProjectCode);
			}

			if (trainingBatchId != 0 && !"".equals(trainingBatchId)) {

				query.setParameter("trainingBatchId", trainingBatchId);
			}

			if (coagencyId != null && !coagencyId.trim().equals("")
					&& !coagencyId.equals("null")) {
				query.setParameter("coagencyId", coagencyId);
			}

			if (teachingUnitId != null && !teachingUnitId.trim().equals("")
					&& !teachingUnitId.equals("null")) {
				query.setParameter("teachingUnitId", teachingUnitId);

			}

			if (query.getSingleResult() != null) {
				total = Integer.parseInt(query.getSingleResult().toString());
			}

		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

		return total;

	}



	/**
	 * 根据项目id，批次id，合作机构id，教学点id，学科id，类别id获取费用价格
	 * @param trainingProjectId
	 *            培训项目Id
	 * @param trainingBatchId
	 *            培训批次id
	 * @param coagencyId
	 *            合作机构id
	 * @param teachingUnitInfoId
	 *            教学点id
	 * @param specialId
	 *            培训学科id
	 * @param educationLevelId
	 *            培训批次类型ID（培养类别）
	 * @return
	 */
	public int getFeeStandardByConditions(int trainingProjectId,
			int trainingBatchId, String coagencyId, String teachingUnitInfoId,
			String specialId, String educationLevelId) {

		int result = 0;

		String basicString = "select model.feeStandard from TrainingProjectPlan model where 1=1 ";

		StringBuilder queryString = new StringBuilder(basicString);

		if (trainingProjectId != 0 && !"".equals(trainingProjectId)) {
			queryString
					.append(" and model.trainingProjectId = :trainingProjectId");
		}

		
		if (trainingBatchId != 0 && !"".equals(trainingBatchId)) {
			queryString.append(" and model.trainingBatchId = :trainingBatchId");
		}

		if (coagencyId != null && !coagencyId.trim().equals("")
				&& !coagencyId.equals("null")) {

			queryString.append(" and model.coagencyId = :coagencyId");
		}

		if (teachingUnitInfoId != null && !teachingUnitInfoId.trim().equals("")
				&& !teachingUnitInfoId.equals("null")) {

			queryString.append(" and model.teachingUnitInfoId = :teachingUnitInfoId");
		}
		if (specialId != null && !specialId.trim().equals("")
				&& !specialId.equals("null")) {
			
			queryString.append(" and model.specialId = :specialId");
		}
		if (educationLevelId != null && !educationLevelId.trim().equals("")
				&& !educationLevelId.equals("null")) {
			
			queryString.append(" and model.educationLevelId = :educationLevelId");
		}

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (trainingProjectId != 0 && !"".equals(trainingProjectId)) {

				query.setParameter("trainingProjectId", trainingProjectId);
			}
			

			if (trainingBatchId != 0 && !"".equals(trainingBatchId)) {

				query.setParameter("trainingBatchId", trainingBatchId);
			}

			if (coagencyId != null && !coagencyId.trim().equals("")
					&& !coagencyId.equals("null")) {
				query.setParameter("coagencyId", coagencyId);
			}

			if (teachingUnitInfoId != null && !teachingUnitInfoId.trim().equals("")
					&& !teachingUnitInfoId.equals("null")) {
				query.setParameter("teachingUnitInfoId", teachingUnitInfoId);

			}
			if (specialId != null && !specialId.trim().equals("")
					&& !specialId.equals("null")) {
				query.setParameter("specialId", specialId);
				
			}
			if (educationLevelId != null && !educationLevelId.trim().equals("")
					&& !educationLevelId.equals("null")) {
				query.setParameter("educationLevelId", educationLevelId);
				
			}


			
			if (query.getSingleResult() != null) {
				result = Integer.parseInt(query.getSingleResult().toString());
			}
			
			return result;
	
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

	}
}
