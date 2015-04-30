package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.CityInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.ProvinceInfo;

public interface ProvinceInfoLogic {
	
	/**
	 * 添加省份
	 * @param entity
	 */
	public void addProvinceInfo(ProvinceInfo entity);
	
	
	/**
	 * 删除省份
	 * @param entity
	 */
	public void deleteProvinceInfo(ProvinceInfo entity);
	
	
	/**
	 * 更新省份
	 * @param entity
	 */
	public void updateProvinceInfo(ProvinceInfo entity) ;
	
	/**
	 * 获取最大的ProvinceId值
	 * @return
	 */
	public int getMaxProvinceId() ;
	
  /**
   * 根据ID获取省份
   * @param id
   * @return
   */
	public ProvinceInfo getProvinceById(int id);
	
	/**
	   * 根据id获取省份管辖的城市信息
	   * @return
	   */
	public List<CityInfoVO> getAllCityInfo(int id,int pageNo,int pageSize);
	
	/**
	 * add by ys 2012-12-12
	 * 取得省下属的城市的总数
	 * @param ProvinceID
	 * @return
	 */
	public int getTotalBelongsCityInfo(int ProvinceID);
	
	/**
	 * 获取省份列表
	 * @return
	 */
	public List<ProvinceInfo> getAllprovinces();
	
	/**
	 * add by ys 2012-12-12
     * 以翻页的形式返回当前页的省份列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<ProvinceInfo> getAllProvincesInPage(int pageNo, int pageSize);
   
    /**
     * 返回总数
     * @return
     */
    public int getTotalProvinces();
    
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
    public List<ProvinceInfo> getProvinceInfoListByNameAndCode(String proName,String proCode,int pageNo,int pageSize);
    
    /**
     * 根据provinceInfo的属性来查找省份信息
     * @param property
     * 			省份属性
     * @param proValue
     * 			属性的值
     * @return
     * 			省份实体
     */
    public ProvinceInfo getProvinceInfoByProperty(String property,String proValue);
    
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
    public int getTotalRecordByNameAndCode(String proName,String proCode);
    
    /**
     * 根据身份代码查询省份
     * @author Demon
     * @param code 省份代码
     * @return 省份对象
     */
    public ProvinceInfo getProvinceByCode(String code);
    /**
     * @author pjz
     * @return 省份对象
     */
    public List<UtilObject> getAllProvinceInfosByUtilObject();
	/**
	 * add by liyong 20140528
	 * 以翻页的形式返回某个省下属的市的列表, 不包括县区
	 * @param ProvinceID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<CityInfoVO> getCitiesNoCountryByProvinceId(int ProvinceID,int pageNo,int pageSize);
}
