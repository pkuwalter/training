package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.CityInfoVO;
import org.nercel.ccnu.edu.entity.persist.CityInfo;
import org.nercel.ccnu.edu.logic.CityInfoLogic;
import org.nercel.ccnu.edu.logic.impl.CityInfoLogicImpl;

@Path("/cityInfo")
public class CityInfoService {

	
	private CityInfoLogic cityInfoLogic = new CityInfoLogicImpl();
	
	/**
	 * 添加城市信息
	 * @param entity
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("addCityInfo")
	@Consumes("application/json")
	public Response addCityInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
		  ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		  
		  CityInfo entity = mapper.readValue(jsonEntity.toString(),CityInfo.class);
		  
		  this.cityInfoLogic.addCityInfo(entity);
		  
		  return Response.ok().build();	  
		
	}
	
	
	/**
	 * 删除城市信息
	 * @param entity
	 */
	
	@POST
	@Path("deleteCityInfo/{CityInfoID}")
	public Response deleteCityInfo(@PathParam("CityInfoID") int CityInfoID){
		
		CityInfo entity = this.cityInfoLogic.getCityInfoById(CityInfoID);
		
		this.cityInfoLogic.deleteCityInfo(entity);
		
		return Response.ok().build();
		
	}
	

	/**
	 * 更新城市信息
	 * @param entity
	 */
	
	@POST
	@Path("updateCityInfo")
	@Consumes("application/json")
	public Response updateCityInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		CityInfo entity = mapper.readValue(jsonEntity.toString(), CityInfo.class);
		
		this.cityInfoLogic.updateCityInfo(entity);
		
		
		return Response.ok().build();
		
	}
	
	/**
	 * 获取最大的CityId值
	 * @return
	 * @throws JSONException 
	 */
	@GET
	@Path("getMaxCityId")
	@Produces(MediaType.APPLICATION_JSON )
	public JSONObject getMaxCityId() throws JSONException{
		
		int maxCityId = this.cityInfoLogic.getMaxCityId();
		

		JSONObject object = new JSONObject();
		
   		object.put("maxCityId", maxCityId);
   		
   		return object;
	}
		
  
  /**
   * 根据ID查找城市信息
   * @param id
   * @return
   */
	@GET
	@Path("getCityInfoById/{id}")
	@Produces(MediaType.APPLICATION_JSON )
	public CityInfo getCityInfoById(@PathParam("id") int id){
		
		CityInfo entity = this.cityInfoLogic.getCityInfoById(id);
		
		return entity;
		
	}
	
	/**
	 * modify by ys 2012-12-12
	 * 以翻页的形式返回某个市下属的县区的列表
	 * @param cityId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getAllCountyInfo/{id}-{pageNo}-{pageSize}")
	@Produces(MediaType.APPLICATION_JSON )
	public List<CityInfo> getAllCountyInfo(@PathParam("id") int id,
										   @PathParam("pageNo") int pageNo,
										   @PathParam("pageSize") int pageSize){
		
		List<CityInfo> list = new ArrayList<CityInfo>();
		
		list = this.cityInfoLogic.getAllCountyInfo(id,pageNo,pageSize);
		
		return list;
		
	}
	
	/**
	 * add by ys 2012-12-12
	 * 获取某个市下属县区的总记录数
	 * @param cityId
	 * @return
	 * @throws JSONException 
	 */
	@GET
	@Path("getTotalCountyInfo/{cityId}")
	@Produces(MediaType.APPLICATION_JSON )
	public JSONObject getTotalCountyInfo(@PathParam("cityId") int cityId) throws JSONException{
		int total = this.cityInfoLogic.getTotalCountyInfo(cityId);
   		JSONObject object = new JSONObject();
   		object.put("total", total);
   		return object;
		
	}
	
	/**
	 * 获取所有城市信息
	 * @return
	 */
	@GET
	@Path("getAllgetCities")
	@Produces(MediaType.APPLICATION_JSON )
	public List<CityInfo> getAllgetCities(){
		
		List<CityInfo> list = new ArrayList<CityInfo>();
		
		list = this.cityInfoLogic.getAllgetCities();
		
		return list;
		
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
	 * @throws JSONException 
     * @aothor yangsen
     */
	@GET
	@Path("getCountCityByNameAndCode")
	@Produces(MediaType.APPLICATION_JSON )
    public JSONObject getCountCityByNameAndCode(
    		@DefaultValue("") @QueryParam("cityName") String cityName,
    		@DefaultValue("") @QueryParam("cityCode") String cityCode,
    		@QueryParam("provinceId") int provinceId) throws JSONException{
    	int totalRecord = this.cityInfoLogic.getCountCityByNameAndCode(cityName, cityCode, provinceId);
   		JSONObject object = new JSONObject();
   		object.put("totalRecord", totalRecord);
   		return object;
    }
	
	 /**
     * 根据市区名称和代码模糊查找
     * @param cityName
     * 			市区名称
     * @param cityCode
     * 			市区代码
     * @param provinceId 
     * 			市区所属省份id
     * @return
     * 			返回市区列表
     * @aothor yangsen
     */
	@GET
	@Path("getCityInfoListByNameAndCode")
	@Produces(MediaType.APPLICATION_JSON )
    public List<CityInfoVO> getCityInfoListByNameAndCode(
    		@DefaultValue("") @QueryParam("cityName") String cityName,
    		@DefaultValue("") @QueryParam("cityCode") String cityCode,
    		@QueryParam("provinceId") int provinceId,
    		@QueryParam("pageNo") int pageNo,
    		@QueryParam("pageSize") int pageSize){
    	List<CityInfoVO> cityInfoList=this.cityInfoLogic
    			.getCityInfoListByNameAndCode(cityName, cityCode,provinceId,pageNo,pageSize);
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
	@GET
	@Path("getCityInfoByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON )
    public CityInfo getCityInfoByProperty(@PathParam("property") String property,
    			@PathParam("proValue") String proValue){
    	CityInfo cityInfo = this.cityInfoLogic
    			.getCityInfoByProperty(property, proValue);
    	return cityInfo;
    }
	
	/**
     * 根据CityInfo的属性来查找市区信息 , 返回List
     * @param property
     * 			属性名
     * @param proValue
     * 			属性值
     * @return
     * 			List<CityInfo>
     */
	@GET
	@Path("getCityListByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON )
    public List<CityInfo> getCityListByProperty(@PathParam("property") String property,
    			@PathParam("proValue") String proValue){
    	
    	return this.cityInfoLogic.getCityListByProperty(property, proValue);
    }
	
}
