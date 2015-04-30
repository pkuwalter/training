package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.CityInfoVO;
import org.nercel.ccnu.edu.entity.persist.CityInfo;


public interface CityInfoLogic {
	
	/**
	 * 添加城市
	 * @param entity
	 */
	public void addCityInfo(CityInfo entity);
	
	
	/**
	 * 删除城市
	 * @param entity
	 */
	public void deleteCityInfo(CityInfo entity);
	
	
	/**
	 * 更新城市
	 * @param entity
	 */
	public void updateCityInfo(CityInfo entity) ;
	
	/**
	 * 获取最大的CityId值
	 * @return
	 */
	public int getMaxCityId();
	
  /**
   * 根据ID获取城市
   * @param id
   * @return
   */
	public CityInfo getCityInfoById(int id);
	
	/**
	 * modify by ys 2012-12-12
	 * 以翻页的形式返回某个市下属的县区的列表
	 * @param cityId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CityInfo> getAllCountyInfo(int id,int pageNo,int pageSize);
	
	/**
	 * add by ys 2012-12-12
	 * 获取某个市下属县区的总记录数
	 * @param cityId
	 * @return
	 */
	public int getTotalCountyInfo(int cityId);
	
	/**
	 * 获取城市列表
	 * @return
	 */
	public List<CityInfo> getAllgetCities();
	
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
    public int getCountCityByNameAndCode(String cityName,String cityCode,int provinceId);
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
    		String cityCode,int provinceId,int pageNo,int pageSize);
    	
    
    /**
     * 根据CityInfo的属性来查找市区信息
     * @param property
     * 			属性名
     * @param proValue
     * 			属性值
     * @return
     * 			CityInfo实体
     */
    public CityInfo getCityInfoByProperty(String property,String proValue);
    
    /**
     * 根据CityInfo的属性来查找市区信息,返回List
     * @param property
     * 			属性名
     * @param proValue
     * 			属性值
     * @return
     * 			List<CityInfo>实体
     */
    public List<CityInfo> getCityListByProperty(String property,String proValue);
	
}
