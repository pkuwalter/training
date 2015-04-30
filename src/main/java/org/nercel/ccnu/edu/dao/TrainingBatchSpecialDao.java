package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.nercel.ccnu.edu.entity.TrainingSpecialDetailVO;
import org.nercel.ccnu.edu.entity.persist.EducationLevel;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectPlan;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class TrainingBatchSpecialDao {
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public List<TrainingSpecialDetailVO> getAllSpecialList(String educationLevelId) {
		try {
			String queryBasic = "select new org.wy.ccnu.edu.entity.TrainingSpecialDetailVO(special.id, special.specialName) from Special special where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if (educationLevelId != null && !educationLevelId.trim().equals("")) {
				queryString
						.append(" and special.educationLevel = :educationLevelId");
			}
			// 根据专业首字母排序 mysql 中没有convert这个函数所以要实现这个方面不能简单的用个sql解决了
			// queryString.append(" order by convert(specialName using gbk) COLLATE gbk_chinese_ci asc");

			Query query = getEntityManager()
					.createQuery(queryString.toString());
			if (educationLevelId != null && !educationLevelId.trim().equals("")) {
				query.setParameter("educationLevelId", educationLevelId);
			}
			return (List<TrainingSpecialDetailVO>) query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List<TrainingSpecialDetailVO> getSpecialByProjectAndBatchAndLevel(
			int trainingProjectId,int trainingBatchId, String educationLevelId) {
		try {
			String queryBasic = "select new org.wy.ccnu.edu.entity.TrainingSpecialDetailVO( special.id,special.specialName) from TrainingProjectPlan t,Special special where  t.specialId = special.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			
			if (trainingProjectId != 0) {
				queryString
				.append(" and t.trainingProjectId = :trainingProjectId");
			}
			if (trainingBatchId != 0 ) {
				queryString
				.append(" and t.trainingBatchId = :trainingBatchId");
			}
			if (educationLevelId != null && !educationLevelId.trim().equals("")) {
				queryString
				.append(" and t.educationLevel = :educationLevelId");
			}
			
			
			Query query = getEntityManager().createQuery(queryString.toString());
			if (trainingProjectId != 0) {
				query.setParameter("trainingProjectId", trainingProjectId);
			}
			if (trainingBatchId != 0) {
				query.setParameter("trainingBatchId", trainingBatchId);
			}
			if (educationLevelId != null && !educationLevelId.trim().equals("")) {
				query.setParameter("educationLevelId", educationLevelId);
			}
			return (List<TrainingSpecialDetailVO>) query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 判断表中是否已经有数据了
	 * 
	 * @param trainingProjectId
	 * @param trainingBatchId
	 * @param educationLevelId
	 * @param specialId
	 * @return
	 */
	public int ifExistTrainingProjectPlanId(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId) {
		int trainingProjectPlanId = 0;
		String queryString = "select trainingProjectPlan.id from TrainingProjectPlan trainingProjectPlan where trainingProjectPlan.trainingProjectId = :trainingProjectId and trainingProjectPlan.trainingBatchId= :trainingBatchId and trainingProjectPlan.educationLevelId= :educationLevelId and trainingProjectPlan.specialId= :specialId ";
		Query query = null;
		try {
			query = getEntityManager().createQuery(queryString);
			query.setParameter("trainingProjectId", trainingProjectId);
			query.setParameter("trainingBatchId", trainingBatchId);
			query.setParameter("educationLevelId", educationLevelId);
			query.setParameter("specialId", specialId);

			if (query.getResultList() != null
					&& query.getResultList().size() != 0) {
				trainingProjectPlanId = Integer.parseInt(query.getResultList()
						.get(0).toString());
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return trainingProjectPlanId;
	}
	public int getFeeStandard(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId) {
		int feeStandard = 0;
		String queryString = "select trainingProjectPlan.feeStandard from TrainingProjectPlan trainingProjectPlan where trainingProjectPlan.trainingProjectId = :trainingProjectId and trainingProjectPlan.trainingBatchId= :trainingBatchId and trainingProjectPlan.educationLevelId= :educationLevelId and trainingProjectPlan.specialId= :specialId ";
		Query query = null;
		try {
			query = getEntityManager().createQuery(queryString);
			query.setParameter("trainingProjectId", trainingProjectId);
			query.setParameter("trainingBatchId", trainingBatchId);
			query.setParameter("educationLevelId", educationLevelId);
			query.setParameter("specialId", specialId);
			
			if (query.getResultList() != null
					&& query.getResultList().size() != 0) {
				feeStandard = Integer.parseInt(query.getResultList()
						.get(0).toString());
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return feeStandard;
	}

	/**
	 * 根据培训项目和培训批次获取培训类别
	 * 
	 * @param id
	 * @return
	 */
	public List<EducationLevel> findByProjectIdBatchId(int projectId,
			int batchId) {
		List<EducationLevel> educationLevelList = new ArrayList<EducationLevel>();
		String sql = "select e from EducationLevel e  where e.id in (select t.educationLevelId from TrainingProjectPlan t where t.trainingProjectId=:projectId and t.trainingBatchId=:batchId)";
		// String
		// sql="select e.id,e.code,e.educationLevelName,e.type from EducationLevel e ,TrainingProjectPlan t where e.id=t.educationLevelId and t.trainingProjectId=:projectId and t.trainingBatchId=:batchId";
		try {
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("projectId", projectId);
			query.setParameter("batchId", batchId);
			educationLevelList = query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return educationLevelList;
	}

	public TrainingProjectPlan checkTrainingProjectPlan(int trainingProjectId,
			int trainingBatchId, String educationLevelId, String specialId) {
		String queryString = "select trainingProjectPlan from TrainingProjectPlan trainingProjectPlan where trainingProjectPlan.trainingProjectId = :trainingProjectId and trainingProjectPlan.trainingBatchId= :trainingBatchId and trainingProjectPlan.educationLevelId= :educationLevelId and trainingProjectPlan.specialId= :specialId ";
		Query query = null;
		try {
			query = getEntityManager().createQuery(queryString);
			query.setParameter("trainingProjectId", trainingProjectId);
			query.setParameter("trainingBatchId", trainingBatchId);
			query.setParameter("educationLevelId", educationLevelId);
			query.setParameter("specialId", specialId);
			TrainingProjectPlan trainingProjectPlan = null;
			if (query.getResultList().size() == 0) {
				return trainingProjectPlan;
			}

			trainingProjectPlan = (TrainingProjectPlan) query.getSingleResult();
			return trainingProjectPlan;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 增加TrainingProjectPlan
	 * 
	 * @param entity
	 */
	public void save(TrainingProjectPlan entity) {
		EntityTransaction tran = getEntityManager().getTransaction();
		try {
			tran.begin();
			getEntityManager().persist(entity);
			tran.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据id获取TrainingProjectPlan的一个List
	 * 
	 * @param id
	 * @return
	 */
	public List<TrainingProjectPlan> getTrainingProjectPlanById(int id) {
		String sql = "select model from TrainingProjectPlan model where model.id=:id";
		Query query = null;
		List<TrainingProjectPlan> result = null;
		try {

			query = getEntityManager().createQuery(sql);
			query.setParameter("id", id);
			if (query.getResultList() != null
					&& query.getResultList().size() != 0) {
				result = query.getResultList();
			}
			return result;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据id获取enrollProjectPlan的一个实体，用来删除
	 * 
	 * @param trainingProjectPlanId
	 * @return
	 */
	public TrainingProjectPlan getTrainingProjectPlanByIdForDelete(
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
	 * 删除enrollProjectPlan
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
		} finally {
			getEntityManager().close();
		}
	}
}
