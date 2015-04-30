package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TeachingUnitInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class TeachingUnitInfoDao {

	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(TeachingUnitInfo entity){
		try{
			entity.setId(null);
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void delete(TeachingUnitInfo entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(TeachingUnitInfo.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(TeachingUnitInfo entity){
		try{
			EntityManagerHelper.beginTransaction();
			getEntityManager().merge(entity);
            EntityManagerHelper.commit();			
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public TeachingUnitInfo findTeachingUnitInfoById(String id){
		try{
			TeachingUnitInfo instance = getEntityManager().find(TeachingUnitInfo.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public boolean batchDeleteTeachingUnitInfo(JSONObject teachingUnitInfoIds) throws JSONException{
		 
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<teachingUnitInfoIds.length();i++){
			queryString.append("?");
			if(i < (teachingUnitInfoIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete TeachingUnitInfo where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<teachingUnitInfoIds.length();i++){
				query.setParameter(i+1, teachingUnitInfoIds.getString(i+""));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
			return true;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyID(String coagencyID){

		List<TeachingUnitInfo> teachingUnitInfoList = null;
		try{
			String queryString = "select model from TeachingUnitInfo model where model.status=1 and model.coagencyId= :coagencyID";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("coagencyID", coagencyID);
			teachingUnitInfoList = (List<TeachingUnitInfo>)query.getResultList();
			return teachingUnitInfoList;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllTeachingUnitInfosByCoagency(String coagencyID){
		
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.teachingUnitName) from TeachingUnitInfo model where model.status=1 and model.coagencyId= :coagencyID";
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("coagencyID", coagencyID);
			List<UtilObject> results = query.getResultList();
			
			return results;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getTeachingUnitInfosByManageCenter(String manageCenterID){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.teachingUnitName) from TeachingUnitInfo model,Coagency coagency where model.status=1 and model.coagencyId = coagency.id and coagency.manageCenter= :manageCenterID";
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("manageCenterID", manageCenterID);
			List<UtilObject> results = query.getResultList();
			return results;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TeachingUnitInfo> getAllTeachingUnitInfos(){
		List<TeachingUnitInfo> result = new ArrayList<TeachingUnitInfo>();
		try{
			String queryString = "select model from TeachingUnitInfo model order by convert(model.teachingUnitName,'gbk')";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<TeachingUnitInfo>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TeachingUnitInfoVO> findTeachingUnitInfoVOByConditions(String coagency,String teachingUnitInfoNum,String teachingUnitInfoName,String status, int pageNo, int pageSize){
		
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.TeachingUnitInfoVO(model.id,model.teachingUnitNum,model.teachingUnitName,coagency.coagencyName,model.official,model.address,model.zipCode,model.mobilePhone,model.tel,model.email,model.status,model.remark) from TeachingUnitInfo model, Coagency coagency where model.coagencyId = coagency.id ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				queryString.append(" and model.coagency= :coagency");
			}
			if(teachingUnitInfoNum != null && !teachingUnitInfoNum.trim().equals("null") &&  !teachingUnitInfoNum.trim().equals("")){
				queryString.append(" and model.teachingUnitNum= :teachingUnitInfoNum");
			}
			if(teachingUnitInfoName != null && !teachingUnitInfoName.trim().equals("null") && !teachingUnitInfoName.trim().equals("")){
				queryString.append(" and model.teachingUnitName like :teachingUnitInfoName");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				query.setParameter("coagency", coagency);
			}
			
			if(teachingUnitInfoNum != null && !teachingUnitInfoNum.trim().equals("null") &&  !teachingUnitInfoNum.trim().equals("")){
				query.setParameter("teachingUnitInfoNum", teachingUnitInfoNum);
			}
			if(teachingUnitInfoName != null && !teachingUnitInfoName.trim().equals("null") && !teachingUnitInfoName.trim().equals("")){
				query.setParameter("teachingUnitInfoName", "%"+teachingUnitInfoName+"%");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<TeachingUnitInfoVO> result = query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String coagency,String teachingUnitInfoNum,String teachingUnitInfoName,String status){
		int total = 0;
		try{
			String queryBasic = "select count(*) from TeachingUnitInfo model, Coagency coagency where model.coagencyId = coagency.id ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				queryString.append(" and model.coagency= :coagency");
			}
			if(teachingUnitInfoNum != null && !teachingUnitInfoNum.trim().equals("null") &&  !teachingUnitInfoNum.trim().equals("")){
				queryString.append(" and model.teachingUnitNum= :teachingUnitInfoNum");
			}
			if(teachingUnitInfoName != null && !teachingUnitInfoName.trim().equals("null") && !teachingUnitInfoName.trim().equals("")){
				queryString.append(" and model.teachingUnitName like :teachingUnitInfoName");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(coagency != null && !coagency.trim().equals("null") && !coagency.trim().equals("")){
				query.setParameter("coagency", coagency);
			}
			
			if(teachingUnitInfoNum != null && !teachingUnitInfoNum.trim().equals("null") &&  !teachingUnitInfoNum.trim().equals("")){
				query.setParameter("teachingUnitInfoNum", teachingUnitInfoNum);
			}
			if(teachingUnitInfoName != null && !teachingUnitInfoName.trim().equals("null") && !teachingUnitInfoName.trim().equals("")){
				query.setParameter("teachingUnitInfoName", "%"+teachingUnitInfoName+"%");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
			}
			
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllTeachingUnitInfosByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.teachingUnitName) from TeachingUnitInfo model where model.status=1";
		try{
			Query query = getEntityManager().createQuery(queryString);
			List<UtilObject> results = query.getResultList();
			return results;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	
	//add 20121211 删除验证 begin
		public boolean teachingUnitInfoOfficialIsExist(String teachingUnitInfoID){
			String queryString = "select model.id from TeachingUnitInfoOfficial model where model.teachingUnitInfo= :teachingUnitInfoID limit 1";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("teachingUnitInfoID", teachingUnitInfoID);
				String result = query.getSingleResult().toString();
				if(result != null){
					return true;
				}
				return false;
			}catch (NoResultException noResultException) {
				return false;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		
		public boolean studentIsExist(String teachingUnitInfoID){
			String queryString = "select model.id from StudentInfo model where model.teachingUnitInfo= :teachingUnitInfoID limit 1";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("teachingUnitInfoID",teachingUnitInfoID);
				String result = query.getSingleResult().toString();
				if(result != null){
					return true;
				}
				return false;
			}catch (NoResultException noResultException) {
				return false;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		//---end
		
		/**
		 * @param teachingUnitName
		 * @return
		 */
		public boolean teachingUnitNameIsExist(String teachingUnitName){
			String queryString = "select count(model.id) from TeachingUnitInfo model where model.teachingUnitName= :teachingUnitName";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("teachingUnitName", teachingUnitName);
				int result = Integer.parseInt(query.getSingleResult().toString());
				if(result > 0){
					return true;
				}
				return false;
			}catch (NoResultException noResultException) {
				return false;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		public boolean teachingUnitNumIsExist(String teachingUnitNum){
			String queryString = "select count(model.id) from TeachingUnitInfo model where model.teachingUnitName= :teachingUnitNum";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("teachingUnitNum", teachingUnitNum);
				int result = Integer.parseInt(query.getSingleResult().toString());
				if(result > 0){
					return true;
				}
				return false;
			}catch (NoResultException noResultException) {
				return false;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		
		public String getTeachingUnitInfoIDByName(String teachingUnitInfoName){
			String queryString = "select model.id from TeachingUnitInfo model where model.teachingUnitName= :teachingUnitInfoName";
			try{
				Query query = getEntityManager().createQuery(queryString);
				query.setParameter("teachingUnitInfoName", teachingUnitInfoName.trim());
				String result = query.getSingleResult().toString();
				return result;
			}
			catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
	
	//----------wxl begin
 
		public String getTeachingUnitInfoNameById(String teachingUnitInfoId){

			final String queryString = "select r.teachingUnitName from TeachingUnitInfo r where r.id= :teachingUnitInfoId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("teachingUnitInfoId", teachingUnitInfoId);

				String name =  query.getSingleResult().toString();
				
				return  name;
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
	
	public String getTeachingUnitInfoIdByName(String teachingUnitInfoName){

		final String queryString = "select r.id from TeachingUnitInfo r where r.teachingUnitName= :teachingUnitInfoName";
		try{
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter("teachingUnitInfoName", teachingUnitInfoName);

			 String list =  query.getResultList().get(0).toString();
			
			return   list ;
		}catch(RuntimeException re){
		throw re;
		}finally{
		getEntityManager().close();
		}
	}
	
	public ArrayList<UtilObject> getAllUtilObjectRpnAndRpIdbySCId(String coagencyId){
		ArrayList<UtilObject> result = new ArrayList<UtilObject>();
		try{
			String queryBasic = "select distinct new TeachingUnitInfo(rp.id,rp.teachingUnitName)  from TeachingUnitInfo rp  where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(coagencyId != null  && !coagencyId.trim().equals("")&&!coagencyId.equals("null")){
				queryString.append(" and  rp.coagencyId= :propertyValue");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
		
			if(coagencyId != null  && !coagencyId.trim().equals("")&&!coagencyId.equals("null")){
				query.setParameter("propertyValue", coagencyId);
			}
			
			
			for(Object o : query.getResultList()){

				UtilObject uo = new UtilObject();
				uo.setId(((TeachingUnitInfo)o).getId());
				uo.setName(((TeachingUnitInfo)o).getTeachingUnitName());
				result.add(uo);
			}
			return result;
		 }catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
	}
	
	public ArrayList<TeachingUnitInfo>  getAllRpnRpIdAndSCId(){
		ArrayList<TeachingUnitInfo> rpList = new ArrayList<TeachingUnitInfo>();
		try{
			String queryBasic = "select distinct new TeachingUnitInfo(rp.id,rp.teachingUnitName,rp.coagencyId)  from TeachingUnitInfo rp  where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);

			Query query = getEntityManager().createQuery(queryString.toString());
			
			for(Object o : query.getResultList()){
				TeachingUnitInfo uo = (TeachingUnitInfo)o;
				rpList.add(uo);
			}
			return rpList;
		 }catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
	}
	
	/**
	 * 根据多选的合作机构的ids和培训批次ids来查询满足条件的教学点
	 * @author yangsen
	 * @date 2014-05-20
	 * @param ids
	 * 			合作结构的ids,例如ids = 1,2,3,4
	 * @return
	 * 			教学点列表List<TeachingUnitInfo>
	 */
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyIds(String ids, String batchIds){
		String queryString = "select distinct model from TeachingUnitInfo model, TrainingBatch_teachingUnitInfo tbUnit " +
				" where model.coagencyId in ( '" + ids.replace(",", "','") + "') and model.id = tbUnit.teachingUnitInfoId " +
				" and tbUnit.trainingBatchId in ( '" + batchIds.replace(",", "','") + "')";
		List<TeachingUnitInfo> teachingUnitInfoList = null;
		try{
			Query query = getEntityManager().createQuery(queryString);
			teachingUnitInfoList = query.getResultList();		
			return teachingUnitInfoList;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * 根据多选的合作机构的来查询满足条件的教学点
	 * @author pjz
	 * @date 2014-06-09
	 * @param ids
	 * 			教学点的ids,例如ids = 1,2,3,4
	 * @return
	 * 			教学点列表List<TeachingUnitInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<TeachingUnitInfo> getTeachingUnitInfoListByIds(String ids){
		String queryString = " from TeachingUnitInfo model where model.id in ( '" + ids.replace(",", "','") + "')";
		List<TeachingUnitInfo> teachingUnitInfoList = null;
		try{
			Query query = getEntityManager().createQuery(queryString);
			teachingUnitInfoList = query.getResultList();		
			return teachingUnitInfoList;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
   
	/** 验证属性值在表中是否存在(通用)
	 * @param property 属性
	 * @param propertyValue 属性值
	 * @param tableName 表映射，如 StudentInfo 
	 * @return true-已存在，false-不存在
	 */
	public boolean propertyIsExistInTable(String property,String propertyValue,String tableName) {
		String queryString = "select count(model."+property+") from "+tableName+" model where model."+property+" = '"+propertyValue+"' ";
		try {
			Query query = getEntityManager().createQuery(queryString.toString());
			int result = Integer.parseInt(query.getSingleResult().toString());
			return  (result>0?true:false);
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}
	
	/*public static void main(String[] args){
		TeachingUnitInfoDao dao = new TeachingUnitInfoDao();
		String propertyValue="0120102001";
		String property="courseCode";
		String tableName="CourseInfo";
		System.out.println("------测试-------"+dao.propertyIsExistInTable( "courseCode", "0120102001", "CourseInfo"));
	}*/
}
