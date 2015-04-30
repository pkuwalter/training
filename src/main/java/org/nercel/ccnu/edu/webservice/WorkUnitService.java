package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import org.nercel.ccnu.edu.entity.WorkUnitVO;
import org.nercel.ccnu.edu.entity.persist.WorkUnit;
import org.nercel.ccnu.edu.logic.WorkUnitLogic;
import org.nercel.ccnu.edu.logic.impl.WorkUnitLogicImpl;

@Path("/workUnitService")
public class WorkUnitService {
	private WorkUnitLogic logic = new WorkUnitLogicImpl();
	
	//添加工作单位
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		WorkUnit entity = (WorkUnit)mapper.readValue(jsonEntity.toString(), WorkUnit.class);
		this.logic.save(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除工作单位
	 * 成功则返回true，否则返回false
	 * @param id -工作单位id
	 * @return
	 * @throws JSONException 
	 */
	@DELETE
	@Path("delete/{id}")
	public JSONObject deleteWorkUnit(@PathParam("id") String id) throws JSONException{
		WorkUnit entity = this.logic.getById(id);
		boolean successOrNot = this.logic.delete(entity);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	/**
	 * 批量删除工作单位
	 * @param manageCenterIds
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("batchDeleteByIds")
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject batchDeleteByIds(JSONObject ids) throws JSONException{
		boolean successOrNot = this.logic.batchDeleteByIds(ids);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	/**
	 * 更新工作单位
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorkUnit(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		WorkUnit entity = (WorkUnit)mapper.readValue(jsonEntity.toString(), WorkUnit.class);
		this.logic.update(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据学习中心ID查找学习中心
	 * @param id
	 * @return
	 */
	@GET
	@Path("getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public WorkUnit getById(@PathParam("id") String id){		
		return logic.getById(Integer.parseInt(id));
	}
	
	/**
	 * 根据条件查询工作单位信息列表
	 * @param provinceCode
	 * @param cityCode
	 * @param countryCode
	 * @param workUnitName
	 * @param woekUnitCode
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getWorkUnitByConditions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WorkUnitVO> getWorkUnitByConditions(
			@DefaultValue("") @QueryParam("provinceCode") String provinceCode,
			@DefaultValue("") @QueryParam("cityCode") String cityCode,
			@DefaultValue("") @QueryParam("countryCode") String countryCode,
			@DefaultValue("") @QueryParam("workUnitName") String workUnitName,
			@DefaultValue("") @QueryParam("workUnitCode") String workUnitCode,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("20") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		workUnitName = java.net.URLDecoder.decode(workUnitName, "UTF-8");
		
		return this.logic.getWorkUnitByConditions(provinceCode, cityCode, countryCode, workUnitName, workUnitCode, pageNo, pageSize);
	}
	
	/**
	 * 根据条件得到工作单位记录数
	 * @param provinceCode
	 * @param cityCode
	 * @param countryCode
	 * @param workUnitName
	 * @param woekUnitCode
	 * @return
	 */
	@GET
	@Path("getTotalRecords")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("provinceCode") String provinceCode,
			@DefaultValue("") @QueryParam("cityCode") String cityCode,
			@DefaultValue("") @QueryParam("countryCode") String countryCode,
			@DefaultValue("") @QueryParam("workUnitName") String workUnitName,
			@DefaultValue("") @QueryParam("workUnitCode") String workUnitCode) throws JSONException, UnsupportedEncodingException{
		workUnitName = java.net.URLDecoder.decode(workUnitName, "UTF-8");
		int total = this.logic.getWorkUnitRecords(provinceCode, cityCode, countryCode, workUnitName, workUnitCode);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	/**
	 * 根据属性名和属性值查询工作单位
	 * 					-若有多个，返回第一个
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@GET
	@Path("findByProperty/{propertyName}-{value}")
	@Produces(MediaType.APPLICATION_JSON )
	public WorkUnit findByProperty(@PathParam("propertyName") String propertyName,
			@PathParam("value") String value) throws UnsupportedEncodingException{
		if(value instanceof String)
			value = java.net.URLDecoder.decode(value.toString(), "UTF-8");
		WorkUnit entity = this.logic.findByProperty(propertyName, value);
		return entity;
	}
	
	/**
	 * 根据属性名模糊查询工作单位列表信息
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@GET
	@Path("findListByProperty/{propertyName}-{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WorkUnit> findListByProperty(@PathParam("propertyName") String propertyName,
			@PathParam("value") String value) throws UnsupportedEncodingException{
		
		if(value instanceof String)
			value = java.net.URLDecoder.decode(value.toString(), "UTF-8");
		
		return this.logic.findListByProperty(propertyName, value);
		
	}
	
	
	
	
}
