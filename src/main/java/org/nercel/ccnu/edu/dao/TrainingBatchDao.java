package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.nercel.ccnu.edu.entity.TrainingBatchVO;
import org.nercel.ccnu.edu.entity.TrainingBatch_teachingUnitInfoVO;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

/**
 * @author Jo
 * @version 创建时间：2014年5月23日 下午4:17:33 类说明
 */
public class TrainingBatchDao extends BaseDaoImpl<TrainingBatch> {
	/*
	 * 删除
	 * 
	 * 
	 * @param ids
	 * 
	 * @throws JSONException
	 */
	public void delete(String ids) throws JSONException {
		String sql = "delete TrainingBatch where id in ( " + ids + ")";
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
		String sql = "select count(*) from TrainingBatch";
		Query query = getEntityManager().createQuery(sql);
		int count = 0;
		count = Integer.parseInt(query.getSingleResult().toString());
		return count;

	}
	public int countAll(int trainingProjectId) {
		int  count = 0;
		try{
			
		String sql = "select count(*) from TrainingBatch batch where 1 = 1";
		if (trainingProjectId != 0) {
			sql += " and batch.trainingProjectId = :trainingProjectId ";
		}
		Query query = getEntityManager().createQuery(sql);
		if (trainingProjectId != 0) {
			query.setParameter("trainingProjectId", trainingProjectId);
		}
		count = Integer.parseInt(query.getSingleResult().toString());
		}catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return count;

	}

	public List<TrainingBatchVO> getTrainingBatchVOList() {
		List<TrainingBatchVO> entityList = new ArrayList<TrainingBatchVO>();
		String sql = "select " + "new org.wy.ccnu.edu.entity.TrainingBatchVO(" + "batch.id," + "project.id,"
				+ "project.trainingProjectName," + "project.trainingProjectCode," + "batch.trainingBatchName,"
				+ "batch.trainingBeginTime," + "batch.trainingEndTime," + "batch.planBeginTime," + "batch.planEndTime,"
				+ "batch.status) " + "from " + "TrainingBatch batch," + "TrainingProjectInfo project " + "where "
				+ "batch.trainingProjectId=project.id";
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
	public List<TrainingBatchVO> getTrainingBatchVOPage(int pageSize,int pageNo,int trainingProjectId ) {
		List<TrainingBatchVO> entityList = new ArrayList<TrainingBatchVO>();
		try {
		String sql = "select " + "new org.wy.ccnu.edu.entity.TrainingBatchVO(" + "batch.id," + "project.id,"
				+ "project.trainingProjectName," + "project.trainingProjectCode," + "batch.trainingBatchName,"
				+ "batch.trainingBeginTime," + "batch.trainingEndTime," + "batch.planBeginTime," + "batch.planEndTime,"
				+ "batch.status) " + "from " + "TrainingBatch batch," + "TrainingProjectInfo project " + "where "
				+ "batch.trainingProjectId=project.id";
		if (trainingProjectId != 0) {
			sql += " and batch.trainingProjectId = :trainingProjectId ";
		}
		Query query = getEntityManager().createQuery(sql);
		if (trainingProjectId != 0) {
			query.setParameter("trainingProjectId", trainingProjectId);
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		entityList = query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return entityList;
	}
	
	/**
	 * 根据培训项目id查询培训批次
	 * @param id 培训项目id
	 * @return 培训批次List
	 */
	public List<TrainingBatch> findByProjectId(String id){
		List<TrainingBatch> trainingBatchList =new ArrayList<TrainingBatch>();
		String sql="from TrainingBatch t where t.trainingProjectId=:id";
		try{
			Query query = getEntityManager().createQuery(sql);
			query.setParameter("id", Integer.parseInt(id));
			trainingBatchList =  query.getResultList();
		}catch(RuntimeException re){
			re.printStackTrace();
		}finally{
			getEntityManager().close();
		}
		return trainingBatchList;
	}
	public TrainingProjectInfo findProjectByBatchId(String id){
		TrainingProjectInfo entity=new TrainingProjectInfo();
		String sql="select tp from TrainingProjectInfo tp where tp.id in(select tb.trainingProjectId from TrainingBatch tb where tb.id=:id)";
		Query query = null;
		try{
			query = getEntityManager().createQuery(sql);
			query.setParameter("id", Integer.parseInt(id));
			entity = (TrainingProjectInfo) query.getSingleResult();
			return entity;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	public List<TrainingBatch_teachingUnitInfoVO> findTrainingBatch_teachingUnitInfoVOBycoagencyId(String id){
		List<TrainingBatch_teachingUnitInfoVO> entityList=new ArrayList<TrainingBatch_teachingUnitInfoVO>();
		String sql="select new org.wy.ccnu.edu.entity.TrainingBatch_teachingUnitInfoVO"
				+ "(tt.id,"
				+ "tt.trainingBatchId,"
				+ "tu.coagencyId,"
				+ "tt.teachingUnitInfoId,"
				+ "tu.teachingUnitNum,"
				+ "tu.teachingUnitName,"
				+ "tt.checkEndTime) "
				+ "from TrainingBatch_teachingUnitInfo tt,TeachingUnitInfo tu "
				+ "where tt.teachingUnitInfoId=tu.id and coagencyId= :id";
		Query query=null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			query.setParameter("id", id);
			entityList=query.getResultList();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return entityList;
		
	}
	/**
	 * 批量查询
	 */
	public List<TrainingBatch> findByIds(String ids){
		String sql = "select tb from TrainingBatch tb where tb.id in ("+ids+")";
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			List<TrainingBatch> entityList=query.getResultList();
			return entityList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

	}
	public TrainingBatch findByName(String name){
		String sql="select tb from TrainingBatch tb where tb.trainingBatchName=:name";
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			query.setParameter("name", name);
			TrainingBatch entity=(TrainingBatch) query.getSingleResult();
			return entity;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		
	}
}
