package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.wy.ccnu.edu.dao.ProvinceInfoDao;
import org.wy.ccnu.edu.entity.CityInfoVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.ProvinceInfo;
import org.wy.ccnu.edu.logic.ProvinceInfoLogic;

public class ProvinceInfoLogicImpl implements ProvinceInfoLogic {

	ProvinceInfoDao dao = new ProvinceInfoDao();
	
	public void addProvinceInfo(ProvinceInfo entity) {

		dao.save(entity);
	}

	public void deleteProvinceInfo(ProvinceInfo entity) {

		
		dao.delete(entity);
	}

	public void updateProvinceInfo(ProvinceInfo entity) {

		dao.update(entity);
	}
	
	public int getMaxProvinceId(){
		
		return dao.getMaxProvinceId();
	}
	
	public ProvinceInfo getProvinceById(int id) {

		return dao.getProvinceById(id);
	}
	
	public List<CityInfoVO> getAllCityInfo(int id,int pageNo,int pageSize){
		return dao.getAllCityInfo(id,pageNo,pageSize);
	}
	
	public int getTotalBelongsCityInfo(int ProvinceID){
		
		return dao.getTotalBelongsCityInfo(ProvinceID);
	}

	public List<ProvinceInfo> getAllprovinces() {

		return dao.getAllprovinces();
	}
	
	public List<ProvinceInfo> getAllProvincesInPage(int pageNo, int pageSize){
    	return dao.getAllProvincesInPage(pageNo, pageSize);
    }
	
    public int getTotalProvinces(){
    	return dao.getMaxProvinceId();
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
    	return dao.getProvinceInfoListByNameAndCode(proName, proCode,pageNo,pageSize);
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
    	return dao.getProvinceInfoByProperty(property, proValue);
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
    	return dao.getTotalRecordByNameAndCode(proName, proCode);
    }
    
    /**
     * 根据身份代码查询省份
     * @author Demon
     * @param code 省份代码
     * @return 省份对象
     */
    public ProvinceInfo getProvinceByCode(String code){
    	return dao.getProvinceByCode(code);
    }
    /**pjz
     * @return 返回全部省份名和编码
     */
    public List<UtilObject> getAllProvinceInfosByUtilObject(){
    	return dao.getAllProvinceInfosByUtilObject();
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
    	return dao.getCitiesNoCountryByProvinceId(ProvinceID, pageNo, pageSize);
    }
}
