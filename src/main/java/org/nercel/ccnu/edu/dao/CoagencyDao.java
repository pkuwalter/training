package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.CoagencyVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class CoagencyDao extends BaseDaoImpl<Coagency>{
	
	public void save(Coagency entity){
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
	
	public void delete(Coagency entity){
		try{
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(Coagency.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public boolean batchDeleteCoagency(JSONObject coagencyIds) throws JSONException{
		
		String coagencyID = "";
		for(int i = 0;i<coagencyIds.length();i++){
			coagencyID = coagencyIds.getString(i+"");
			//学员信息表暂时没设计，这里先保留
			/*if(coagencyOfficialIsExist(coagencyID) || teachingUnitInfoIsExist(coagencyID) ||studentIsExist(coagencyID)){ //存在关联数据，不能删除
				return false;
			}*/
		}
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<coagencyIds.length();i++){
			queryString.append("?");
			if(i < (coagencyIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete Coagency where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<coagencyIds.length();i++){
				query.setParameter(i+1, coagencyIds.getString(i+""));
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

	public void update(Coagency entity){
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
	
	public Coagency findCoagencyById(String id){
		try{
			Coagency instance = getEntityManager().find(Coagency.class, id);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Coagency> getAllCoagencys(){
		List<Coagency> result = new ArrayList<Coagency>();
		try{
			String queryString = "from Coagency model where model.status=1 order by convert(model.coagencyName,'gbk')";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<Coagency>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UtilObject> getAllCoagencysByUtilObject(){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.coagencyName) from Coagency model where model.status=0 order by convert(model.coagencyName,'gbk')";
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
	public List<UtilObject> getCoagencyUtilByManageCenterID(String manageCenterID){
		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.id,model.coagencyName) from Coagency model where model.manageCenter= :manageCenterID order by convert(model.coagencyName,'gbk')";
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
	public List<Coagency> findCoagencyByConditions(String coagencyNum,String coagencyName,String manageCenterName,String jwNum,int pageNo, int pageSize){
		List<Coagency> result = new ArrayList<Coagency>();
		try{
			String queryBasic = "select model from Coagency model, ManageCenter manageCenter where model.manageCenter = manageCenter.id";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(manageCenterName != null && !manageCenterName.trim().equals("")){
				queryString.append(" and manageCenter.manageCenterName like '%" + manageCenterName + "%'");
			}
			if(coagencyNum != null && !coagencyNum.trim().equals("")){
				queryString.append(" and model.coagencyNum= :coagencyNum");
			}
			if(coagencyName != null && !coagencyName.trim().equals("")){
				queryString.append(" and model.coagencyName= :coagencyName");
			}
			if(jwNum != null && !jwNum.trim().equals("")){
				queryString.append(" and model.jwNum= :jwNum");
			}
			Query query = getEntityManager().createQuery(queryString.toString());
			if(coagencyNum != null && !coagencyNum.trim().equals("")){
				query.setParameter("coagencyNum", coagencyNum);
			}
			if(coagencyName != null && !coagencyName.trim().equals("")){
				query.setParameter("coagencyName", coagencyName);
			}
			if(jwNum != null && !jwNum.trim().equals("")){
				query.setParameter("jwNum", jwNum);
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			for(Object o : query.getResultList()){
				result.add((Coagency)o);
			}
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	*/
	
	/*
	 * 这里provinceCode表示生源地code
	 * 若代码长度2则是省，6位则是市/区
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public List<CoagencyVO> findCoagencyVOByConditions(String coagencyNum,String coagencyName,String manageCenter,String jwNum,String jwName,String provinceCode,int pageNo, int pageSize){
		System.out.println("coagencyNum: "+coagencyNum);
		System.out.println("coagencyName: "+coagencyName);
		try{
			String queryBasic = "select new org.wy.ccnu.edu.entity.CoagencyVO(model.id,model.coagencyNum," +
					"model.coagencyName,'自建管理中心',model.official,model.address,model.mobilePhone," +
					"model.email,model.jwNum,model.jwName,model.status,model.city) from Coagency model " +
					" where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()==2)
					queryString.append(" and model.cityCode like '"+ provinceCode +"____'");
				else
					queryString.append(" and model.cityCode= :provinceCode");				
			}
			
			if(coagencyNum != null && !coagencyNum.trim().equals("null") && !coagencyNum.trim().equals("")){
				queryString.append(" and model.coagencyNum like '%" + coagencyNum+ "%'");
			}
			if(coagencyName != null && !coagencyName.trim().equals("null") && !coagencyName.trim().equals("")){
				queryString.append(" and model.coagencyName like '%" + coagencyName+ "%'");
			}
			if(jwNum != null && !jwNum.trim().equals("null") && !jwNum.trim().equals("")){
				queryString.append(" and model.jwNum like '%" + jwNum+ "%'");
			}
			if(jwName != null && !jwName.trim().equals("null")&& !jwName.trim().equals("")){
				queryString.append(" and model.jwName like '%" + jwName+ "%'");
			}
			
			queryString.append(" order by convert(model.coagencyName, 'gbk')");
			
			Query query = getEntityManager().createQuery(queryString.toString());
			 
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()!=2)
					query.setParameter("provinceCode",provinceCode);
			}
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<CoagencyVO> result = query.getResultList();
			System.out.println("result.size(): "+result.size());
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public int getTotalRecords(String coagencyNum,String coagencyName,String manageCenter,String jwNum,String jwName,String provinceCode){
		int total = 0;
		try{
			String queryBasic = "select count(*) from Coagency model  where 1=1 ";
			StringBuilder queryString = new StringBuilder();
			queryString.append(queryBasic);
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				if(provinceCode.length()==2)
					queryString.append(" and model.cityCode like '"+ provinceCode +"____'");
				else
					queryString.append(" and model.cityCode= :provinceCode");	
			}
			
			if(coagencyNum != null && !coagencyNum.trim().equals("null") && !coagencyNum.trim().equals("")){
				queryString.append(" and model.coagencyNum like '%" + coagencyNum+ "%'");
			}
			if(coagencyName != null && !coagencyName.trim().equals("null") && !coagencyName.trim().equals("")){
				queryString.append(" and model.coagencyName like '%" + coagencyName+ "%'");
			}
			if(jwNum != null && !jwNum.trim().equals("null") && !jwNum.trim().equals("")){
				queryString.append(" and model.jwNum like '%" + jwNum+ "%'");
			}
			if(jwName != null && !jwName.trim().equals("null") && !jwName.trim().equals("")){
				queryString.append(" and model.jwName like '%" + jwName+ "%'");
			}
			
			queryString.append(" order by convert(model.coagencyName,'gbk')");
			
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
	public boolean coagencyOfficialIsExist(String coagencyID){
		String queryString = "select model.id from CoagencyOfficial model where model.coagency= :coagencyID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("coagencyID", coagencyID);
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
	
	public boolean teachingUnitInfoIsExist(String coagencyID){
		String queryString = "select model.id from TeachingUnitInfo model where model.coagencyId= :coagencyID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("coagencyID", coagencyID);
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
	
	public boolean studentIsExist(String coagencyID){
		String queryString = "select model.id from StudentInfo model where model.coagency_registration= :coagencyID limit 1";
		try{
			Query query = getEntityManager().createNativeQuery(queryString);
			query.setParameter("coagencyID", coagencyID);
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
	public String getCoagencyIDByName(String coagencyName){
		String queryString = "select model.id from Coagency model where model.coagencyName= :coagencyName";
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("coagencyName", coagencyName.trim());
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
	public ArrayList<UtilObject> getCoagencyUtilObjectByIdList(ArrayList<String> studycenterlist){
		final String queryString = "select sc.coagencyName  from Coagency sc where sc.id= :studycenterlist  order by convert(sc.coagencyName,'gbk')";
		ArrayList<UtilObject> coagencyByIdList = new ArrayList<UtilObject>();
		try{
			for(Object o : studycenterlist){
				UtilObject uo = new UtilObject();
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("studycenterlist", o.toString());

				List list =  query.getResultList();
				uo.setId(o.toString());
				uo.setName(list.get(0).toString());
				coagencyByIdList.add(uo);
			}
			
			return coagencyByIdList;
		}catch(RuntimeException re){
		throw re;
		}finally{
		getEntityManager().close();
		}
	}
	
	//获取一个学习过程课程信息Id

		public String getCoagencyNameById(String coagencyId){

			final String queryString = "select s.coagencyName from Coagency s where s.id= :coagencyId";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("coagencyId", coagencyId);

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
				String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(sc.id,sc.coagencyName) from Coagency sc order by convert(sc.coagencyName,'gbk')";
				Query query = getEntityManager().createQuery(queryString);
				result = (ArrayList<UtilObject>)query.getResultList();
				return result;
			}catch(RuntimeException re){
				throw re;
			}finally{
				getEntityManager().close();
			}
		}
		
		public String getCoagencyIdByName(String coagencyName){

			final String queryString = "select s.id from Coagency s where s.coagencyName= :coagencyName";
			try{
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter("coagencyName", coagencyName);

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
     * 根据Coagency的属性来查找
     * @author yangsen 2013-12-04
     * @param property
     * 			学习中心属性
     * @param proValue
     * 			学习中心属性的值
     * @return
     * 			学习中心实体
     */
    public Coagency getCoagencyByProperty(String property,String proValue){
    	String queryString = "from Coagency model where model."+property+" = '"+proValue +"'";
    	Coagency coagency = null;
    	try{
    		Query query = getEntityManager().createQuery(queryString);
    		List list = query.getResultList();
    		if(!list.toString().equals("[]")){
    			coagency = (Coagency) list.get(0);
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return coagency;	
    }
    
	/**
	 * 根据Id串"id1,id2..."获取合作机构列表
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Coagency> getCoagencysByIds(String ids) {
		List<Coagency> result = new ArrayList<Coagency>();
		
		try{
			String hql = "from Coagency model where id in ( '" + ids.replace(",", "','") + "')";
			Query query = getEntityManager().createQuery(hql);
			result = (List<Coagency>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
    
	/**
	 * 根据培训批次刷新合作机构列表
	 * @author yangsen
	 * @date 2014-06-18
	 * @param batchIds
	 * 		培训批次batchIds，例如batchIds=1,2,3,4
	 * @return
	 * 		List<Coagency>
	 */
	public List<Coagency> getCoagencysByBatchIds(String batchIds){
		List<Coagency> result = null;
		String hql = "select distinct model from Coagency model, TrainingBatch_coagency tbCoagency " +
				" where tbCoagency.trainingBatchId in ( '" + batchIds.replace(",", "','") + "') " +
				" and model.id = tbCoagency.coagencyId ";
		try {
			Query query = getEntityManager().createQuery(hql);
			result = query.getResultList();
			return result;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
   
}
