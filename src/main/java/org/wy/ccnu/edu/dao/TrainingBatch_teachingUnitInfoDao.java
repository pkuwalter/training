package org.wy.ccnu.edu.dao; 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.persist.Coagency;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_teachingUnitInfo;
import org.wy.ccnu.edu.util.EntityManagerHelper;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午4:22:03 
 * 类说明 
 */
public class TrainingBatch_teachingUnitInfoDao extends BaseDaoImpl<TrainingBatch_teachingUnitInfo>{

	 /* 删除
	 * @param ids
	 * @throws JSONException 
	 */
	public void delete(String ids) throws JSONException{
		String sql = "delete TrainingBatch_teachingUnitInfo where id in ( " + ids + ")";
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
	/**
	 * 记录总数
	 * @return
	 */
	public int countAll(){
		String sql="select count(*) from TrainingBatch_teachingUnitInfo";
		Query query=getEntityManager().createQuery(sql);
		int count=0;
		count=Integer.parseInt(query.getSingleResult().toString());
		return count;
		
	}
	/**
	 * 通过批次ID获得所有记录
	 */
	public List<TrainingBatch_teachingUnitInfo> findAllByBatchId(int id) {
		String sql = "from TrainingBatch_teachingUnitInfo bt where bt.trainingBatchId=" + id;
		List<TrainingBatch_teachingUnitInfo> entityList = new ArrayList<TrainingBatch_teachingUnitInfo>();
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
	public  List<TrainingBatch_teachingUnitInfo> findByCoId(String id){
		String sql="select tt from TrainingBatch_teachingUnitInfo tt where tt.teachingUnitInfoId in("
				+ "select tu.id from TeachingUnitInfo tu where tu.coagencyId= :id)";
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			query.setParameter("id", id);
			List<TrainingBatch_teachingUnitInfo> entityList = query.getResultList();
			return entityList;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		
	}
	public List<TeachingUnitInfo> getUseTeachingUnitInfo(String id){
		List<TeachingUnitInfo> result = null;
		String queryString = "select TeachingUnitInfo from TeachingUnitInfo teachingUnitInfo where not teachingUnitInfo.id in (select model.teachingUnitInfoId from TrainingBatch_teachingUnitInfo model where model.trainingBatchId =:id)";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("id", Integer.parseInt(id));
			result = (List<TeachingUnitInfo>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

	public TrainingBatch_teachingUnitInfo findByTeachingUnitId(String id){
		String sql="select tt from TrainingBatch_teachingUnitInfo tt where tt.teachingUnitInfoId= :id";
		Query query=null;
		try{
			query = getEntityManager().createQuery(sql);
			query.setParameter("id", id);
			TrainingBatch_teachingUnitInfo entity = (TrainingBatch_teachingUnitInfo) query.getSingleResult();
			return entity;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

}
 