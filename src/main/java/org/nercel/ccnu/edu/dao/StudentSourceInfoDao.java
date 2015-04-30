package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.StudentSourceInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentSourceInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class StudentSourceInfoDao {

	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(StudentSourceInfo entity){
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
	
	public void delete(StudentSourceInfo entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(StudentSourceInfo.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public void update(StudentSourceInfo entity){
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
	
	public StudentSourceInfo findStudentSourceInfoById(String id){
		try{
			StudentSourceInfo instance = getEntityManager().find(StudentSourceInfo.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public boolean batchDeleteStudentSourceInfo(JSONObject studentSourceInfoIds) throws JSONException{
		 
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<studentSourceInfoIds.length();i++){
			queryString.append("?");
			if(i < (studentSourceInfoIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete StudentSourceInfo where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<studentSourceInfoIds.length();i++){
				query.setParameter(i+1, studentSourceInfoIds.getString(i+""));
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
	public List<StudentSourceInfo> getStudentSourceInfoListByStudentAgencyID(String studentAgencyIdID){

		List<StudentSourceInfo> studentSourceInfoList = null;
		try{
			String queryString = "select model from StudentSourceInfo model where model.status=0 and model.studentAgencyId= :studentAgencyIdID";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("studentAgencyIdID", studentAgencyIdID);
			studentSourceInfoList = (List<StudentSourceInfo>)query.getResultList();
			return studentSourceInfoList;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllStudentSourceInfosByStudentAgency(String studentAgencyIdID){
		
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentSourceName) from StudentSourceInfo model where model.status=0 and model.studentAgencyId= :studentAgencyIdID";
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("studentAgencyIdID", studentAgencyIdID);
			List<UtilObject> results = query.getResultList();
			
			return results;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getStudentSourceInfosByManageCenter(String manageCenterID){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentSourceName) from StudentSourceInfo model,StudentAgency studentAgency where model.status=0 and model.studentAgencyId = studentAgency.id and studentAgencyId.manageCenter= :manageCenterID";
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
	public List<StudentSourceInfo> getAllStudentSourceInfos(){
		List<StudentSourceInfo> result = new ArrayList<StudentSourceInfo>();
		try{
			String queryString = "select model from StudentSourceInfo model order by convert(model.studentSourceName,'gbk')";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<StudentSourceInfo>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentSourceInfoVO> findStudentSourceInfoVOByConditions(String studentAgencyId,String studentSourceNum,String studentSourceName,String status, int pageNo, int pageSize){
		
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.StudentSourceInfoVO(model.id,model.studentSourceNum,model.studentSourceName,studentAgency.studentAgencyName,model.official,model.address,model.tel,model.email,model.status) from StudentSourceInfo model, StudentAgency studentAgency where model.studentAgencyId = studentAgency.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(studentAgencyId != null && !studentAgencyId.trim().equals("null") && !studentAgencyId.trim().equals("")){
				queryString.append(" and model.studentAgencyId= :studentAgencyId");
			}
			if(studentSourceNum != null && !studentSourceNum.trim().equals("null") &&  !studentSourceNum.trim().equals("")){
				queryString.append(" and model.studentSourceNum= :studentSourceNum");
			}
			if(studentSourceName != null && !studentSourceName.trim().equals("null") && !studentSourceName.trim().equals("")){
				queryString.append(" and model.studentSourceName like :studentSourceName");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			queryString.append("  order by model.studentSourceNum asc ");
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(studentAgencyId != null && !studentAgencyId.trim().equals("null") && !studentAgencyId.trim().equals("")){
				query.setParameter("studentAgencyId", studentAgencyId);
			}
			
			if(studentSourceNum != null && !studentSourceNum.trim().equals("null") &&  !studentSourceNum.trim().equals("")){
				query.setParameter("studentSourceNum", studentSourceNum);
			}
			if(studentSourceName != null && !studentSourceName.trim().equals("null") && !studentSourceName.trim().equals("")){
				query.setParameter("studentSourceName", "%"+studentSourceName+"%");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				query.setParameter("status", Integer.parseInt(status));
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<StudentSourceInfoVO> result = query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String studentAgencyId,String studentSourceNum,String studentSourceName,String status){
		int total = 0;
		try{
			String queryBasic = "select count(*) from StudentSourceInfo model, StudentAgency studentAgency where model.studentAgencyId = studentAgency.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(studentAgencyId != null && !studentAgencyId.trim().equals("null") && !studentAgencyId.trim().equals("")){
				queryString.append(" and model.studentAgencyId= :studentAgencyId");
			}
			if(studentSourceNum != null && !studentSourceNum.trim().equals("null") &&  !studentSourceNum.trim().equals("")){
				queryString.append(" and model.studentSourceNum= :studentSourceNum");
			}
			if(studentSourceName != null && !studentSourceName.trim().equals("null") && !studentSourceName.trim().equals("")){
				queryString.append(" and model.studentSourceName like :studentSourceName");
			}
			if(status != null && !status.trim().equals("null") && !status.trim().equals("")){
				queryString.append(" and model.status= :status");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(studentAgencyId != null && !studentAgencyId.trim().equals("null") && !studentAgencyId.trim().equals("")){
				query.setParameter("studentAgencyId", studentAgencyId);
			}
			
			if(studentSourceNum != null && !studentSourceNum.trim().equals("null") &&  !studentSourceNum.trim().equals("")){
				query.setParameter("studentSourceNum", studentSourceNum);
			}
			if(studentSourceName != null && !studentSourceName.trim().equals("null") && !studentSourceName.trim().equals("")){
				query.setParameter("studentSourceName", "%"+studentSourceName+"%");
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
	public List<UtilObject> getAllStudentSourceInfosByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentSourceName) from StudentSourceInfo model ";
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
		public boolean studentSourceInfoOfficialIsExist(String studentSourceInfoID){
			String queryString = "select model.id from StudentSourceInfoOfficial model where model.studentSourceInfo= :studentSourceInfoID limit 1";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("studentSourceInfoID", studentSourceInfoID);
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
		
		public boolean studentIsExist(String studentSourceInfoID){
			String queryString = "select model.id from StudentInfo model where model.studentSourceInfo= :studentSourceInfoID limit 1";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("studentSourceInfoID",studentSourceInfoID);
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
		
		public boolean studentSourceInfoIsExist(String studentSourceName){
			String queryString = "select model.id from StudentSourceInfo model where model.studentSourceName= :studentSourceName";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("studentSourceName", studentSourceName);
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
		public boolean studentSourceNumIsExist(String studentSourceNum){
			String queryString = "select model.id from StudentSourceInfo model where model.studentSourceNum= :studentSourceNum";
			try{
				Query query = getEntityManager().createNativeQuery(queryString);
				query.setParameter("studentSourceNum", studentSourceNum);
				String result = query.getSingleResult().toString();
				if(result != null){
					return true;  //已存在
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
		
		public String getStudentSourceInfoIDByName(String studentSourceName){
			String queryString = "select model.id from StudentSourceInfo model where model.studentSourceName= :studentSourceName";
			try{
				Query query = getEntityManager().createQuery(queryString);
				query.setParameter("studentSourceName", studentSourceName.trim());
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
 
		public String getStudentSourceInfoNameById(String studentSourceInfoId){

			final String queryString = "select r.studentSourceName from StudentSourceInfo r where r.id= :studentSourceInfoId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("studentSourceInfoId", studentSourceInfoId);
 
				return query.getSingleResult().toString();
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}
	
	public String getStudentSourceInfoIdByName(String studentSourceName){

		final String queryString = "select r.id from StudentSourceInfo r where r.studentSourceName= :studentSourceName";
		try{
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter("studentSourceName", studentSourceName);
 
			return  query.getSingleResult().toString();
		}catch(RuntimeException re){
		throw re;
		}finally{
		getEntityManager().close();
		}
	}
	
	public ArrayList<UtilObject> getAllUtilObjectRpnAndRpIdbySCId(String studentAgencyIdId){
		ArrayList<UtilObject> result = new ArrayList<UtilObject>();
		try{
			String queryBasic = "select distinct new StudentSourceInfo(rp.id,rp.studentSourceName)  from StudentSourceInfo rp  where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(studentAgencyIdId != null  && !studentAgencyIdId.trim().equals("")&&!studentAgencyIdId.equals("null")){
				queryString.append(" and  rp.studentAgencyId= :propertyValue");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
		
			if(studentAgencyIdId != null  && !studentAgencyIdId.trim().equals("")&&!studentAgencyIdId.equals("null")){
				query.setParameter("propertyValue", studentAgencyIdId);
			}
			
			
			for(Object o : query.getResultList()){

				UtilObject uo = new UtilObject();
				uo.setId(((StudentSourceInfo)o).getId());
				uo.setName(((StudentSourceInfo)o).getStudentSourceName());
				result.add(uo);
			}
			return result;
		 }catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
	}
	
	public ArrayList<StudentSourceInfo>  getAllRpnRpIdAndSCId(){
		ArrayList<StudentSourceInfo> rpList = new ArrayList<StudentSourceInfo>();
		try{
			String queryBasic = "select distinct new StudentSourceInfo(rp.id,rp.studentSourceName,rp.studentAgencyId)  from StudentSourceInfo rp  where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);

			Query query = getEntityManager().createQuery(queryString.toString());
			
			for(Object o : query.getResultList()){
				StudentSourceInfo uo = (StudentSourceInfo)o;
				rpList.add(uo);
			}
			return rpList;
		 }catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
	}
	
}
