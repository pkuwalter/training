package org.wy.ccnu.edu.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.wy.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.wy.ccnu.edu.entity.TrainingProjectInfoVO;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class TrainingProjectInfoDao extends BaseDaoImpl<TrainingProjectInfo>{
	 /* 删除
		 * @param ids
		 * @throws JSONException 
		 */
		public void delete(String ids) throws JSONException{
			String sql = "delete TrainingProjectInfo where id in ( " + ids + ")";
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
			String sql="select count(*) from TrainingProjectInfo";
			Query query=getEntityManager().createQuery(sql);
			int count=0;
			count=Integer.parseInt(query.getSingleResult().toString());
			return count;
			
		}

	public List<TrainingProjectInfoVO> getTrainingProjectInfoVOList() {
		List<TrainingProjectInfoVO> entityList=new ArrayList<TrainingProjectInfoVO>();
		String sql = "select new org.wy.ccnu.edu.entity.TrainingProjectInfoVO(trainingProjectInfo.id," +
																			"trainingProjectInfo.trainingProjectCode," +
																			"trainingProjectInfo.trainingProjectName," +
																			"trainingType.id," +
																			"trainingType.trainingTypeCode," +
																			"trainingType.trainingTypeName)" +
				"from TrainingProjectInfo trainingProjectInfo,TrainingType trainingType where trainingProjectInfo.trainingTypeCode=trainingType.trainingTypeCode ";
		Query query=null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			entityList=query.getResultList();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return entityList;

	}
	public List<TrainingProjectInfo> entityLsit(){
		List<TrainingProjectInfo> entityList=new ArrayList<TrainingProjectInfo>();
		String sql="from TrainingProjectInfo";
		Query query=null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			entityList=query.getResultList();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return entityList;
	}
	public List<TrainingProjectInfo> findByName(String name){
		List<TrainingProjectInfo> entityList=new ArrayList<TrainingProjectInfo>();
		String sql="select t from TrainingProjectInfo t where t.trainingProjectName like '%"+name+"%' ";
		Query query=null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			entityList=query.getResultList();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return entityList;
	}

}
