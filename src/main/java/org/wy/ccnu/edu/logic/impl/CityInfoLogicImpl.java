package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.wy.ccnu.edu.dao.CityInfoDao;
import org.wy.ccnu.edu.entity.CityInfoVO;
import org.wy.ccnu.edu.entity.persist.CityInfo;
import org.wy.ccnu.edu.logic.CityInfoLogic;


public class CityInfoLogicImpl implements CityInfoLogic {

	CityInfoDao dao = new CityInfoDao();
	
	public void addCityInfo(CityInfo entity) {

		dao.save(entity);
	}

	public void deleteCityInfo(CityInfo entity) {

		
		dao.delete(entity);
	}

	public void updateCityInfo(CityInfo entity) {

		dao.update(entity);
	}
	
	public int getMaxCityId(){
		return dao.getMaxCityId();
	}
		
	public CityInfo getCityInfoById(int id) {

		return dao.getCityInfoById(id);
	}

	public List<CityInfo> getAllCountyInfo(int id,int pageNo,int pageSize){
		
		return dao.getAllCountyInfo(id,pageNo,pageSize);
	}
	
	public int getTotalCountyInfo(int cityId){
		return dao.getTotalCountyInfo(cityId);
	}
	
	public List<CityInfo> getAllgetCities() {

		return dao.getAllgetCities();
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
    	return dao.getCountCityByNameAndCode(cityName, cityCode, provinceId);
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
    public List<CityInfoVO> getCityInfoListByNameAndCode(String cityName,
    		String cityCode,int provinceId,int pageNo,int pageSize){
    	return dao.getCityInfoListByNameAndCode(cityName, cityCode,provinceId,pageNo,pageSize);
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
    	return dao.getCityInfoByProperty(property, proValue);
    }
    
    /**
     * 根据CityInfo的属性来查找市区信息,返回List
     * @param property
     * 			属性名
     * @param proValue
     * 			属性值
     * @return
     * 			List<CityInfo>
     */
    public List<CityInfo> getCityListByProperty(String property,String proValue){
    	return dao.getCityListByProperty(property, proValue);
    }
}
