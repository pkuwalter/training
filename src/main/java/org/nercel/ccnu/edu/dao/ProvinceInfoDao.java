package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.nercel.ccnu.edu.entity.CityInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.CityInfo;
import org.nercel.ccnu.edu.entity.persist.ProvinceInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class ProvinceInfoDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(ProvinceInfo entity){
		try{
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * * @param entity
	 */
	public void delete(ProvinceInfo entity) {
		try {

			EntityManagerHelper.beginTransaction();

			entity = getEntityManager().getReference(ProvinceInfo.class,
					entity.getId());
			getEntityManager().remove(entity);

			EntityManagerHelper.commit();

		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * * @param entity
	 */
	public void update(ProvinceInfo entity){
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
	
	public int getMaxProvinceId(){
		String queryString = "select max(model.id) from ProvinceInfo model ";
		int maxProvinceId=0;
		try{
			Query query= getEntityManager().createQuery(queryString);
			List list =query.getResultList();
			System.out.println("list="+list);
			if(!list.toString().equals("[null]")){
				maxProvinceId = (Integer) list.get(0);
			}
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return maxProvinceId;
	}
	
	public ProvinceInfo getProvinceById(int ProvinceID){
		try{
			ProvinceInfo instance = getEntityManager().find(ProvinceInfo.class, ProvinceID);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * modify by ys 2012-12-12
	 * 以翻页的形式返回某个省下属的市的列表
	 * @param ProvinceID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CityInfoVO> getAllCityInfo(int ProvinceID,int pageNo,int pageSize){
		String queryString = "select new org.wy.ccnu.edu.entity.CityInfoVO(model.id,model.name,model.belongProvinceId," +
				"model.belongCityId,model.code,city.name) " +
				"from CityInfo model,CityInfo city where model.belongProvinceId = :ProvinceID and" +
				" (( model.belongCityId!=-1 and model.belongCityId=city.id) or ( model.belongCityId=-1 and model.id=city.id )) " +
				" order by model.code";
		Query query = null;
		List<CityInfoVO> cityInfoList = new ArrayList<CityInfoVO>();
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("ProvinceID", ProvinceID);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			for(Object o : query.getResultList()){
				cityInfoList.add((CityInfoVO)o);	
			}
			return cityInfoList;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * add by ys 2012-12-12
	 * 取得省下属的城市的总数
	 * @param ProvinceID
	 * @return
	 */
	public int getTotalBelongsCityInfo(int ProvinceID){
		String queryString = "select count(*) from CityInfo model where model.belongProvinceId = :ProvinceID ";
		int total = 0;
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("ProvinceID", ProvinceID);
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ProvinceInfo> getAllprovinces(){
		List<ProvinceInfo> result = new ArrayList<ProvinceInfo>();
		try{
			String queryString = "from ProvinceInfo";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<ProvinceInfo>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	 /**
	 * add by ys 2012-12-12
     * 以翻页的形式返回当前页的省份列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<ProvinceInfo> getAllProvincesInPage(int pageNo, int pageSize){
    
    	List<ProvinceInfo> list = new ArrayList<ProvinceInfo>();
    	
    	try{
			String queryString = "select model from ProvinceInfo model order by model.code";
			Query query = getEntityManager().createQuery(queryString);
			
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			for(Object o : query.getResultList()){
			   list.add((ProvinceInfo)o);	
			}
			return list;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
    }
    
    
    /**
     * add by ys 2012-12-12
     * 返回总数
     * @return
     */
    public int getTotalProvinces(){
    	int total = 0;
		String queryString = "select count(*) from ProvinceInfo ";
		Query query = null;
		try{
			query = getEntityManager().createQuery(queryString);
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
    	
    }
    
    /**
     * 根据省份名称和省份代码模糊查找
     * @param proName
     * 			省份名称
     * @param proCode
     * 			省份代码
     * @param pageNo
     * @param pageSize
     * @return
     * 			返回省份列表
     * @aothor yangsen
     */
    public List<ProvinceInfo> getProvinceInfoListByNameAndCode(String proName,String proCode,int pageNo,int pageSize){
    	String queString = "from ProvinceInfo model where model.provinceName like '%"+proName+"%' and" +
    			" model.code like '%"+proCode+"%' order by model.code";
    	List<ProvinceInfo> provinceInfoList=null;
    	try{
    		Query query = getEntityManager().createQuery(queString);
    		query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
    		provinceInfoList = query.getResultList();
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return provinceInfoList;
    }
    /**
     * 根据省份名称和省份代码模糊查找,返回总记录数
     * @param proName
     * 			省份名称
     * @param proCode
     * 			省份代码
     * @return
     * 			返回查询总记录数
     * @aothor yangsen
     */
    public int getTotalRecordByNameAndCode(String proName,String proCode){
    	String queString = "from ProvinceInfo model where model.provinceName like '%"+proName+"%' and" +
    			" model.code like '%"+proCode+"%' order by model.code";
    	int totalRecord = 0;
    	List<ProvinceInfo> provinceInfoList=null;
    	try{
    		Query query = getEntityManager().createQuery(queString);
    		provinceInfoList = query.getResultList();
    		if(provinceInfoList!=null){
    			totalRecord = provinceInfoList.size();
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return totalRecord;
    }
    
    /**
     * 根据provinceInfo的属性来查找省份信息
     * @param property
     * 			省份属性
     * @param proValue
     * 			属性的值
     * @return
     * 			省份实体
     */
    public ProvinceInfo getProvinceInfoByProperty(String property,String proValue){
    	String queryString = "from ProvinceInfo model where model."+property+" = '"+proValue +"'";
		ProvinceInfo provinceInfo = null;
    	try{
    		Query query = getEntityManager().createQuery(queryString);
    		List list = query.getResultList();
    		if(!list.toString().equals("[]")){
    			provinceInfo = (ProvinceInfo) list.get(0);
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return provinceInfo;	
    }
    
    /**
     * 根据身份代码查询省份
     * @author Demon
     * @param code 省份代码
     * @return 省份对象
     */
    public ProvinceInfo getProvinceByCode(String code){
    	ProvinceInfo provinceInfo = null;
    	try{
    		String sql = "from ProvinceInfo where code =:code";
    		Query query = getEntityManager().createQuery(sql);
    		query.setParameter("code", code);
    		provinceInfo = (ProvinceInfo) query.getSingleResult();
    	}catch(RuntimeException re){
    		re.printStackTrace();
    	}finally{
    		getEntityManager().close();
    	}
    	return provinceInfo;
    }
    /**
     * @author pjz
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
   	public List<UtilObject> getAllProvinceInfosByUtilObject(){
   		String queryString = "select new org.wy.ccnu.edu.entity.UtilObject(model.code,model.provinceName) from ProvinceInfo model order by model.provinceName";
   		try{
   			Query query = getEntityManager().createQuery(queryString);
   			List<UtilObject> results = query.getResultList();
   			System.out.print("-------------333333333");
   			System.out.print(results);
   			return results;
   		}catch(RuntimeException re){
   			throw re;
   		}finally{
   			getEntityManager().close();
   		 
   		}
   	}
	
	/**
	 * add by liyong 20140528
	 * 以翻页的形式返回某个省下属的市的列表, 不包括县区
	 * @param ProvinceID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CityInfoVO> getCitiesNoCountryByProvinceId(int ProvinceID,int pageNo,int pageSize){
		String queryString = "select new org.wy.ccnu.edu.entity.CityInfoVO(model.id,model.name,model.belongProvinceId," +
				"model.belongCityId,model.code,city.name) " +
				"from CityInfo model,CityInfo city where model.belongProvinceId = :ProvinceID and" +
				"  model.belongCityId=-1 and model.id=city.id  " +
				" order by model.code";
		Query query = null;
		List<CityInfoVO> cityInfoList = new ArrayList<CityInfoVO>();
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("ProvinceID", ProvinceID);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			for(Object o : query.getResultList()){
				cityInfoList.add((CityInfoVO)o);	
			}
			return cityInfoList;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
    
}
