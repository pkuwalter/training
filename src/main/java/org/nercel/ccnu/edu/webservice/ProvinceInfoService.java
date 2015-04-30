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
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.ProvinceInfo;
import org.nercel.ccnu.edu.logic.ProvinceInfoLogic;
import org.nercel.ccnu.edu.logic.impl.ProvinceInfoLogicImpl;

@Path("/provinceInfo")
public class ProvinceInfoService {

	private ProvinceInfoLogic provinceInfoLogic = new ProvinceInfoLogicImpl();

	/**
	 * 添加省份信息
	 * 
	 * @param entity
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@POST
	@Path("addProvinceInfo")
	@Consumes("application/json")
	public Response addProvinceInfo(JSONObject jsonEntity)
			throws JSONException, JsonParseException, JsonMappingException,
			IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		ProvinceInfo entity = mapper.readValue(jsonEntity.toString(),
				ProvinceInfo.class);

		this.provinceInfoLogic.addProvinceInfo(entity);

		return Response.ok().build();

	}

	/**
	 * 删除省份信息
	 * 
	 * @param entity
	 */

	@POST
	@Path("deleteProvinceInfo/{ProvinceInfoID}")
	public Response deleteProvinceInfo(
			@PathParam("ProvinceInfoID") int ProvinceInfoID) {

		ProvinceInfo entity = this.provinceInfoLogic
				.getProvinceById(ProvinceInfoID);

		this.provinceInfoLogic.deleteProvinceInfo(entity);

		return Response.ok().build();

	}

	/**
	 * 更新省份信息
	 * 
	 * @param entity
	 */

	@POST
	@Path("updateProvinceInfo")
	@Consumes("application/json")
	public Response updateProvinceInfo(JSONObject jsonEntity)
			throws JSONException, JsonParseException, JsonMappingException,
			IOException {

		ObjectMapper mapper = new ObjectMapper();

		ProvinceInfo entity = mapper.readValue(jsonEntity.toString(),
				ProvinceInfo.class);

		this.provinceInfoLogic.updateProvinceInfo(entity);

		return Response.ok().build();

	}

	/**
	 * 获取最大的ProvinceId值
	 * 
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getMaxProvinceId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxProvinceId() throws JSONException {

		int maxProvinceId = this.provinceInfoLogic.getMaxProvinceId();

		JSONObject object = new JSONObject();

		object.put("maxProvinceId", maxProvinceId);

		return object;
	}

	/**
	 * 根据ID查找省份信息
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("getProvinceById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProvinceInfo getProvinceById(@PathParam("id") int id) {

		ProvinceInfo entity = this.provinceInfoLogic.getProvinceById(id);

		return entity;

	}

	/**
	 * modify by ys 2012-12-12 以翻页的形式返回某个省下属的市的列表
	 * 
	 * @param id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getAllCityInfo/{id}-{pageNo}-{pageSize}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CityInfoVO> getAllCityInfo(@PathParam("id") int id,
			@PathParam("pageNo") int pageNo, @PathParam("pageSize") int pageSize) {

		List<CityInfoVO> list = new ArrayList<CityInfoVO>();

		list = this.provinceInfoLogic.getAllCityInfo(id, pageNo, pageSize);

		return list;

	}

	/**
	 * add by ys 2012-12-12 取得省下属的城市的总数
	 * 
	 * @param ProvinceID
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getTotalBelongsCityInfo/{provinceID}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalBelongsCityInfo(
			@PathParam("provinceID") int provinceID) throws JSONException {
		int total = this.provinceInfoLogic.getTotalBelongsCityInfo(provinceID);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}

	/**
	 * 获取所有省份信息
	 * 
	 * @return
	 */
	@GET
	@Path("getAllprovinces")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProvinceInfo> getAllprovinces() {

		List<ProvinceInfo> list = new ArrayList<ProvinceInfo>();

		list = this.provinceInfoLogic.getAllprovinces();

		return list;

	}

	/**
	 * 返回省份总数
	 * 
	 * @return
	 */
	@GET
	@Path("getTotalProvinces")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalProvinces() throws JSONException {
		int total = this.provinceInfoLogic.getTotalProvinces();
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}

	/**
	 * 以翻页的形式返回当前页的模块列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getAllProvincesInPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProvinceInfo> getAllProvincesInPage(
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize) {
		List<ProvinceInfo> result = this.provinceInfoLogic
				.getAllProvincesInPage(pageNo, pageSize);
		return result;
	}

	/**
	 * 根据省份名称和省份代码模糊查找
	 * 
	 * @param proName
	 *            省份名称
	 * @param proCode
	 *            省份代码
	 * @param pageNo
	 * @param pageSize
	 * @return 返回省份列表
	 * @aothor yangsen
	 */
	@GET
	@Path("getProvinceInfoListByNameAndCode")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProvinceInfo> getProvinceInfoListByNameAndCode(
			@DefaultValue("") @QueryParam("proName") String proName,
			@DefaultValue("") @QueryParam("proCode") String proCode,
			@QueryParam("pageNo") int pageNo,
			@QueryParam("pageSize") int pageSize) {
		List<ProvinceInfo> list = this.provinceInfoLogic
				.getProvinceInfoListByNameAndCode(proName, proCode, pageNo,
						pageSize);
		return list;
	}

	/**
	 * 根据provinceInfo的属性来查找省份信息
	 * 
	 * @param property
	 *            省份属性
	 * @param proValue
	 *            属性的值
	 * @return 省份实体
	 */
	@GET
	@Path("getProvinceInfoByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProvinceInfo getProvinceInfoByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		ProvinceInfo provinceInfo = this.provinceInfoLogic
				.getProvinceInfoByProperty(property, proValue);
		return provinceInfo;
	}

	/**
	 * 根据省份名称和省份代码模糊查找,返回总记录数
	 * 
	 * @param proName
	 *            省份名称
	 * @param proCode
	 *            省份代码
	 * @return 返回查询总记录数
	 * @throws JSONException
	 * @aothor yangsen
	 */
	@GET
	@Path("getTotalRecordByNameAndCode")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecordByNameAndCode(
			@DefaultValue("") @QueryParam("proName") String proName,
			@DefaultValue("") @QueryParam("proCode") String proCode)
			throws JSONException {
		int totalRecord = this.provinceInfoLogic.getTotalRecordByNameAndCode(
				proName, proCode);
		JSONObject object = new JSONObject();
		object.put("totalRecord", totalRecord);
		return object;
	}

	/**
	 * 根据身份代码查询省份
	 * 
	 * @author Demon
	 * @param code
	 *            省份代码
	 * @return 省份对象
	 * @throws JSONException
	 */
	@GET
	@Path("getProvinceNameByCode")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getProvinceNameByCode(
			@DefaultValue("") @QueryParam("code") String code)
			throws JSONException {

		ProvinceInfo province = provinceInfoLogic.getProvinceByCode(code);
		JSONObject object = new JSONObject();
		object.put("provinceName", province.getProvinceName());
		return object;
	}
	
	/**
	 *  
	 * 
	 * @author pjz
	 * @param code
	 *            省份代码
	 * @return 省份对象
	 * @throws JSONException
	 */
	@GET
	@Path("getAllProvinceInfosByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllProvinceInfosByUtilObject(){
		return this.provinceInfoLogic.getAllProvinceInfosByUtilObject();
	}
	
	/**
	 * add by liyong 20140528
	 * 以翻页的形式返回某个省下属的市的列表, 不包括县区
	 * @param ProvinceID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getCitiesNoCountryByProvinceId/{id}-{pageNo}-{pageSize}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CityInfoVO> getCitiesNoCountryByProvinceId(@PathParam("id") int id,
			@PathParam("pageNo") int pageNo, @PathParam("pageSize") int pageSize) {

		List<CityInfoVO> list = new ArrayList<CityInfoVO>();

		list = this.provinceInfoLogic.getCitiesNoCountryByProvinceId(id, pageNo, pageSize);
		return list;

	}
}
