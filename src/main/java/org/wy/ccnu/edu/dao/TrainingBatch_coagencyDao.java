package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.TrainingBatch_coagencyVO;
import org.wy.ccnu.edu.entity.persist.Coagency;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.wy.ccnu.edu.util.EntityManagerHelper;

/**
 * @author Jo
 * @version 创建时间：2014年5月23日 下午4:21:24 类说明
 */
public class TrainingBatch_coagencyDao extends BaseDaoImpl<TrainingBatch_coagency> {

	/*
	 * 删除
	 * 
	 * @param ids
	 * 
	 * @throws JSONException
	 */
	public void delete(String ids) throws JSONException {
		String sql = "delete TrainingBatch_coagency where id in ( " + ids + ")";
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
		String sql = "select count(*) from TrainingBatch_coagency";
		Query query = getEntityManager().createQuery(sql);
		int count = 0;
		count = Integer.parseInt(query.getSingleResult().toString());
		return count;

	}

	/**
	 * 通过批次ID获得所有记录
	 */
	public List<TrainingBatch_coagency> findAllByBatchId(int id) {
		String sql = "from TrainingBatch_coagency bc where bc.trainingBatchId=" + id;
		List<TrainingBatch_coagency> entityList = new ArrayList<TrainingBatch_coagency>();
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			entityList = query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return entityList;

	}

	public List<TrainingBatch_coagencyVO> getTrainingBatch_coagencyVOListById(int id) {
		List<TrainingBatch_coagencyVO> entityList = new ArrayList<TrainingBatch_coagencyVO>();
		String sql = "select new org.wy.ccnu.edu.entity.TrainingBatch_coagencyVO(bc.id,bc.trainingBatchId,bc.coagencyId,c.coagencyName,bc.enrollBeginTime,bc.enrollEndTime) from  TrainingBatch_coagency bc,Coagency c where bc.coagencyId=c.id";
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			entityList = query.getResultList();
			System.err.println(entityList.size());
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return entityList;

	}
	public List<Coagency> getUseCoagency(String id){
		List<Coagency> result = null;
		String queryString = "select coagency from Coagency coagency where coagency.id in (select model.coagencyId from TrainingBatch_coagency model where model.trainingBatchId =:id)";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("id", Integer.parseInt(id));
			result = (List<Coagency>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	public List<Coagency> getUnuseCoagency(String id){
		List<Coagency> result = null;
		String queryString = "select coagency from Coagency coagency where not coagency.id in (select model.coagencyId from TrainingBatch_coagency model where model.trainingBatchId =:id)";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("id", Integer.parseInt(id));
			result = (List<Coagency>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

}
