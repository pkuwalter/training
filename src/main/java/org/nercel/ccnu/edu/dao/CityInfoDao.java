package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.nercel.ccnu.edu.entity.CityInfoVO;
import org.nercel.ccnu.edu.entity.persist.CityInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class CityInfoDao {
	
	private EntityManager getEntityManager(){
		return EntityManagerHelper.getEntityManager();
	}
	
	public void save(CityInfo entity){
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
	public void delete(CityInfo entity) {
		try {

			EntityManagerHelper.beginTransaction();

			entity = getEntityManager().getReference(CityInfo.class,
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
	public void update(CityInfo entity){
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
	
	public int getMaxCityId(){
		String queryString = "select max(model.id) from CityInfo model ";
		int maxCityId = 0;
		try{
			Query query= getEntityManager().createQuery(queryString);
			List list =query.getResultList();
			if(list.size()!=0 && list.get(0)!=null){
				maxCityId = (Integer) list.get(0);
			}
			return maxCityId;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	public CityInfo getCityInfoById(int CityID){
		try{
			CityInfo instance = getEntityManager().find(CityInfo.class, CityID);
			return instance;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	/**
	 * modify by ys 2012-12-12
	 * 以翻页的形式返回某个市下属的县区的列表
	 * @param cityId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CityInfo> getAllCountyInfo(int cityId,int pageNo,int pageSize){
		String queryString = "select model from CityInfo model where model.belongCityId = :cityId";
		Query query = null;
		List<CityInfo> cityInfoList = new ArrayList<CityInfo>();
		try{
			query = getEntityManager().createQuery(queryString);
			query.setParameter("cityId", cityId);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			
			for(Object o : query.getResultList()){
				cityInfoList.add((CityInfo)o);	
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
	 * 获取某个市下属县区的总记录数
	 * @param cityId
	 * @return
	 */
	public int getTotalCountyInfo(int cityId){
		String queryString = "select count(*) from CityInfo model where model.belongCityId = :cityId";
		int total=0;
		try{
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("cityId", cityId);
			total = Integer.parseInt(query.getSingleResult().toString());
			return total;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CityInfo> getAllgetCities(){
		List<CityInfo> result = new ArrayList<CityInfo>();
		try{
			String queryString = "from CityInfo";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<CityInfo>)query.getResultList();
			return result;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	
	 /**
     * 根据市区名称和代码模糊查找 总记录数
     * @param cityName
     * 			市区名称
     * @param cityCode
     * 			市区代码
     * @param provinceId 
     * 			市区所属省份id
     * @return
     * 			返回市区总记录数
     * @aothor yangsen
     */
    public int getCountCityByNameAndCode(String cityName,String cityCode,int provinceId){
    	String queString = "from CityInfo model where model.belongProvinceId = "+provinceId+
    			"and model.name like '%"+cityName+"%' and" +
    			" model.code like '%"+cityCode+"%' order by model.code";
    	List<CityInfo> cityInfoList=null;
    	int totalRecord = 0;
    	try{
    		Query query = getEntityManager().createQuery(queString);
    		cityInfoList = query.getResultList();
    		if(cityInfoList!=null){
    			totalRecord = cityInfoList.size();
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return totalRecord;
    }
    /**
     * 根据市区名称和代码模糊查找
     * @param cityName
     * 			市区名称
     * @param cityCode
     * 			市区代码
     * @param provinceId 
     * 			市区所属省份id
     * @param pageNo
     * @param pageSize
     * @return
     * 			返回市区列表
     * @aothor yangsen
     */
    public List<CityInfoVO> getCityInfoListByNameAndCode(String cityName,String cityCode,int provinceId,int pageNo,int pageSize){
    	
    	String queString = "select new org.wy.ccnu.edu.entity.CityInfoVO(model.id,model.name,model.belongProvinceId," +
				"model.belongCityId,model.code,city.name) from CityInfo model,CityInfo city where " +
				"(( model.belongCityId!=-1 and model.belongCityId=city.id) or ( model.belongCityId=-1 and" +
				" model.id=city.id )) and model.belongProvinceId = '"+provinceId+"' " +
				"and model.name like '%"+cityName+"%' and model.code like '%"+cityCode+"%' " +
    			"order by model.code";
    	List<CityInfoVO> cityInfoList=null;
    	try{
    		Query query = getEntityManager().createQuery(queString);
    		query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
    		cityInfoList = query.getResultList();
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return cityInfoList;
    }
    
    /**
     * 根据CityInfo的属性来查找市区信息
     * @param property
     * 			属性名
     * @param proValue
     * 			属性值
     * @return
     * 			CityInfo实体
     */
    public CityInfo getCityInfoByProperty(String property,String proValue){
    	String queryString = "from CityInfo model where model."+property+" = '"+proValue +"'";
    	System.out.println("property="+property);
    	System.out.println("proValue="+proValue);
    	CityInfo cityInfo = null;
    	try{
    		Query query = getEntityManager().createQuery(queryString);
    		List list = query.getResultList();
    		System.out.println("list="+list);
    		if(!list.toString().equals("[]")){
    			cityInfo = (CityInfo) list.get(0);
    			System.out.println("list.get(0)");
    			System.out.println("cityInfo="+cityInfo);
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return cityInfo;	
    }
    
    /**
     * 根据CityInfo的属性来查找市区信息,返回List
     * @param property
     * 			属性名
     * @param proValue
     * 			属性值
     * @return
     * 			CityInfo实体
     */
    public List<CityInfo> getCityListByProperty(String property,String proValue){
    	String queryString = "from CityInfo model where model."+property+" = '"+proValue +"'";
    	List<CityInfo> cityInfoList = null;
    	try{
    		Query query = getEntityManager().createQuery(queryString);
    		List list = query.getResultList();
    		System.out.println("list="+list);
    		if(!list.toString().equals("[]")){
    			cityInfoList = (List<CityInfo>)list;
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return cityInfoList;	
    }
    
}
