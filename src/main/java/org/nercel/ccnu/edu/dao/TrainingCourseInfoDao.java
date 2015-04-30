package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.nercel.ccnu.edu.entity.persist.TrainingCourseInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class TrainingCourseInfoDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 增加培训课程信息
	 * 
	 * @param entity
	 */
	public void save(TrainingCourseInfo entity) {

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
	 * 删除培训课程信息
	 * 
	 * @param entity
	 */
	public void delete(TrainingCourseInfo entity) {

		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(TrainingCourseInfo.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	/**
	 * 修改培训课程信息
	 * 
	 * @param entity
	 */
	public void update(TrainingCourseInfo entity) {

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
	 * 获取培训课程信息的最大的Id
	 * @return
	 */
	public int getMaxTrainingCourseInfoId(){
		try {
			
					
			final String queryString = "select max(model.id) from TrainingCourseInfo model where 1=1";
			Query query = getEntityManager().createQuery(queryString);		
			
            Integer maxId = (Integer) query.getSingleResult();
			
			return  maxId==null?0:maxId;	
							
		} catch (RuntimeException re) {
			throw re;
		}
		
		
	}

	/**
	 * 获取所有培训课程的列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TrainingCourseInfo> getAllTrainingCourseInfo() {
		List<TrainingCourseInfo> result = new ArrayList<TrainingCourseInfo>();
		try {
			String queryString = "select model from TrainingCourseInfo model where 1=1";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<TrainingCourseInfo>) query.getResultList();
			return result;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据ID获取培训课程信息
	 * 
	 * @param id
	 * @return
	 */
	public TrainingCourseInfo getTrainingCourseInfoById(int id) {
		try {
			TrainingCourseInfo instance = getEntityManager().find(TrainingCourseInfo.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

}
