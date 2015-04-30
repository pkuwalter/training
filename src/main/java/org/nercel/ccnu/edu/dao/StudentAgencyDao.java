package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.StudentAgencyVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentAgency;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class StudentAgencyDao {

	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(StudentAgency entity){
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
	
	public void delete(StudentAgency entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(StudentAgency.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public boolean batchDeleteStudentAgency(JSONObject studentAgencyIds) throws JSONException{
		
		String studentAgencyID = "";
		for(int i = 0;i<studentAgencyIds.length();i++){
			studentAgencyID = studentAgencyIds.getString(i+"");
			if(studentAgencyOfficialIsExist(studentAgencyID) || registrationPointIsExist(studentAgencyID) ||studentIsExist(studentAgencyID)){ //存在关联数据，不能删除
				return false;
			}
		}
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<studentAgencyIds.length();i++){
			queryString.append("?");
			if(i < (studentAgencyIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete StudentAgency where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<studentAgencyIds.length();i++){
				query.setParameter(i+1, studentAgencyIds.getString(i+""));
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

	public void update(StudentAgency entity){
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
	
	public StudentAgency findStudentAgencyById(String id){
		try{
			StudentAgency instance = getEntityManager().find(StudentAgency.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentAgency> getAllStudentAgencys(){
		List<StudentAgency> result = new ArrayList<StudentAgency>();
		try{
			String queryString = "from StudentAgency model where model.status=0 order by convert(model.studentAgencyName,'gbk')";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<StudentAgency>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllStudentAgencysByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentAgencyName) from StudentAgency model where model.status=0 order by convert(model.studentAgencyName,'gbk')";
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
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getStudentAgencyUtilByManageCenterID(String manageCenterID){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.studentAgencyName) from StudentAgency model where model.manageCenter= :manageCenterID order by convert(model.studentAgencyName,'gbk')";
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
	
	/*备用
	public List<StudentAgency> findStudentAgencyByConditions(String studentAgencyNum,String studentAgencyName,String manageCenterName,String jwNum,int pageNo, int pageSize){
		List<StudentAgency> result = new ArrayList<StudentAgency>();
		try{
			String queryBasic = "select model from StudentAgency model, ManageCenter manageCenter where model.manageCenter = manageCenter.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(manageCenterName != null && !manageCenterName.trim().equals("")){
				queryString.append(" and manageCenter.manageCenterName like '%" + manageCenterName + "%'");
			}
			if(studentAgencyNum != null && !studentAgencyNum.trim().equals("")){
				queryString.append(" and model.studentAgencyNum= :studentAgencyNum");
			}
			if(studentAgencyName != null && !studentAgencyName.trim().equals("")){
				queryString.append(" and model.studentAgencyName= :studentAgencyName");
			}
			if(jwNum != null && !jwNum.trim().equals("")){
				queryString.append(" and model.jwNum= :jwNum");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			if(studentAgencyNum != null && !studentAgencyNum.trim().equals("")){
				query.setParameter("studentAgencyNum", studentAgencyNum);
			}
			if(studentAgencyName != null && !studentAgencyName.trim().equals("")){
				query.setParameter("studentAgencyName", studentAgencyName);
			}
			if(jwNum != null && !jwNum.trim().equals("")){
				query.setParameter("jwNum", jwNum);
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			for(Object o : query.getResultList()){
				result.add((StudentAgency)o);
			}
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	*/
	
	@SuppressWarnings("unchecked")
	public List<StudentAgencyVO> findStudentAgencyVOByConditions(String studentAgencyNum,String studentAgencyName,String manageCenter,String jwNum,String jwName,String provinceCode,int pageNo, int pageSize){
		System.out.println("studentAgencyNum: "+studentAgencyNum);
		System.out.println("studentAgencyName: "+studentAgencyName);
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.StudentAgencyVO(model.id,model.studentAgencyNum," +
					"model.studentAgencyName,'自建管理中心',model.official,model.address,model.mobilePhone," +
					"model.email,model.jwNum,model.jwName,model.status,model.city) from StudentAgency model where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()==2)
					queryString.append(" and model.cityCode like '"+ provinceCode +"____'");
				else 
					queryString.append(" and model.cityCode= :provinceCode");	
			}

			if(studentAgencyNum != null && !studentAgencyNum.trim().equals("null")&&!studentAgencyNum.trim().equals("")){
				queryString.append(" and model.studentAgencyNum like '%" + studentAgencyNum+ "%'");
			}
			if(studentAgencyName != null && !studentAgencyName.trim().equals("null") && !studentAgencyName.trim().equals("null")){
				queryString.append(" and model.studentAgencyName like '%" + studentAgencyName+ "%'");
			}
			if(jwNum != null && !jwNum.trim().equals("null") && !jwNum.trim().equals("")){
				queryString.append(" and model.jwNum like '%" + jwNum+ "%'");
			}
			if(jwName != null && !jwName.trim().equals("null") && !jwName.trim().equals("")){
				queryString.append(" and model.jwName like '%" + jwName+ "%'");
			}
			
			queryString.append(" order by convert(model.studentAgencyName,'gbk')");
			
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()!=2)
					query.setParameter("provinceCode",provinceCode);
			}

			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<StudentAgencyVO> result = query.getResultList();
			System.out.println("result.size(): "+result.size());
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String studentAgencyNum,String studentAgencyName,String manageCenter,String jwNum,String jwName,String provinceCode){
		int total = 0;
		try{
			String queryBasic = "select count(*) from StudentAgency model where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()==2)
					queryString.append(" and model.cityCode like '"+ provinceCode +"____'");
				else 
					queryString.append(" and model.cityCode= :provinceCode");
			}
			if(studentAgencyNum != null && !studentAgencyNum.trim().equals("null")){
				queryString.append(" and model.studentAgencyNum like '%" + studentAgencyNum+ "%'");
			}
			if(studentAgencyName != null && !studentAgencyName.trim().equals("null")){
				queryString.append(" and model.studentAgencyName like '%" + studentAgencyName+ "%'");
			}
			if(jwNum != null && !jwNum.trim().equals("null")){
				queryString.append(" and model.jwNum like '%" + jwNum+ "%'");
			}
			if(jwName != null && !jwName.trim().equals("null")){
				queryString.append(" and model.jwName like '%" + jwName+ "%'");
			}
			
			queryString.append(" order by convert(model.studentAgencyName,'gbk')");
			
			Query query = getEntityManager().createQuery(queryString.toString());
			
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()!=2)
					query.setParameter("provinceCode",provinceCode);
			}
			
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	//add 20121211 删除验证 begin
	public boolean studentAgencyOfficialIsExist(String studentAgencyID){
		String queryString = "select model.id from StudentAgencyOfficial model where model.studentAgency= :studentAgencyID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("studentAgencyID", studentAgencyID);
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
	
	public boolean registrationPointIsExist(String studentAgencyID){
		String queryString = "select model.id from RegistrationPoint model where model.studentAgency= :studentAgencyID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("studentAgencyID", studentAgencyID);
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
	
	public boolean studentIsExist(String studentAgencyID){
		String queryString = "select model.id from StudentInfo model where model.studentAgency_registration= :studentAgencyID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("studentAgencyID", studentAgencyID);
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
	public String getStudentAgencyIDByName(String studentAgencyName){
		String queryString = "select model.id from StudentAgency model where model.studentAgencyName= :studentAgencyName";
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("studentAgencyName", studentAgencyName.trim());
			String result = query.getSingleResult().toString();
			return result;
		}
		catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}

	//--------------wxl  begin
	public ArrayList<UtilObject> getStudentAgencyUtilObjectByIdList(ArrayList<String> studycenterlist){
		final String queryString = "select sc.studentAgencyName  from StudentAgency sc where sc.id= :studycenterlist  order by convert(sc.studentAgencyName,'gbk')";
		ArrayList<UtilObject> studentAgencyByIdList = new ArrayList<UtilObject>();
		try{
			for(Object o : studycenterlist){
				UtilObject uo = new UtilObject();
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("studycenterlist", o.toString());

				List list =  query.getResultList();
				uo.setId(o.toString());
				uo.setName(list.get(0).toString());
				studentAgencyByIdList.add(uo);
			}
			
			return studentAgencyByIdList;
		}catch(RuntimeException re){
		throw re;
		}finally{
		getEntityManager().close();
		}
	}
	
	//获取一个学习过程课程信息Id

		public String getStudentAgencyNameById(String studentAgencyId){

			final String queryString = "select s.studentAgencyName from StudentAgency s where s.id= :studentAgencyId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("studentAgencyId", studentAgencyId);

				List list =  query.getResultList();
				
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}


		@SuppressWarnings("unchecked")
		public ArrayList<UtilObject> getAllUtilObjectSCIdAndSCN(){
			ArrayList<UtilObject> result = new ArrayList<UtilObject>();
			try{
				String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(sc.id,sc.studentAgencyName) from StudentAgency sc order by convert(sc.studentAgencyName,'gbk')";
				Query query = getEntityManager().createQuery(queryString);
				result = (ArrayList<UtilObject>)query.getResultList();
				return result;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		
		public String getStudentAgencyIdByName(String studentAgencyName){

			final String queryString = "select s.id from StudentAgency s where s.studentAgencyName= :studentAgencyName";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("studentAgencyName", studentAgencyName);

				List list =  query.getResultList();
				
				return (String) list.get(0);
			}catch(RuntimeException re){
			throw re;
			}finally{
			getEntityManager().close();
			}
		}

	
	//----------wxl end
	
	 /**
     * 根据StudentAgency的属性来查找
     * @author yangsen 2013-12-04
     * @param property
     * 			学习中心属性
     * @param proValue
     * 			学习中心属性的值
     * @return
     * 			学习中心实体
     */
    public StudentAgency getStudentAgencyByProperty(String property,String proValue){
    	String queryString = "from StudentAgency model where model."+property+" = '"+proValue +"'";
    	StudentAgency studentAgency = null;
    	try{
    		Query query = getEntityManager().createQuery(queryString);
    		List list = query.getResultList();
    		if(!list.toString().equals("[]")){
    			studentAgency = (StudentAgency) list.get(0);
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return studentAgency;	
    }
}
