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
import org.nercel.ccnu.edu.entity.TeachingUnitInfoOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingUnitInfoOfficial;
import org.nercel.ccnu.edu.logic.TeachingUnitInfoOfficialLogic;
import org.nercel.ccnu.edu.logic.impl.TeachingUnitInfoOfficialLogicImpl;

@Path("/baseInfo/teachingUnitInfoOfficialService")
public class TeachingUnitInfoOfficialService {

private TeachingUnitInfoOfficialLogic teachingUnitInfoOfficialLogic = new TeachingUnitInfoOfficialLogicImpl();
	
	/**
	 * 增加教学点人员
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTeachingUnitInfoOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		TeachingUnitInfoOfficial entity = (TeachingUnitInfoOfficial)mapper.readValue(jsonEntity.toString(), TeachingUnitInfoOfficial.class);
		this.teachingUnitInfoOfficialLogic.addTeachingUnitInfoOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除教学点人员
	 * @param teachingUnitInfoOfficialID
	 * @return
	 */
	@DELETE
	@Path("delete/{teachingUnitInfoOfficialID}")
	public Response deleteteachingUnitInfoOfficial(@PathParam("teachingUnitInfoOfficialID") String teachingUnitInfoOfficialID){
		TeachingUnitInfoOfficial teachingUnitInfoOfficial = this.teachingUnitInfoOfficialLogic.getTeachingUnitInfoOfficialById(teachingUnitInfoOfficialID);
		this.teachingUnitInfoOfficialLogic.deleteTeachingUnitInfoOfficial(teachingUnitInfoOfficial);
		return Response.ok().build();
	}
	
	/**
	 * 批量删除教学点人员
	 * @param teachingUnitInfoOfficialIds
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response batchDeleteTeachingUnitInfoOfficial(JSONObject teachingUnitInfoOfficialIds) throws JSONException{
		
		this.teachingUnitInfoOfficialLogic.batchDeleteTeachingUnitInfoOfficial(teachingUnitInfoOfficialIds);
		return Response.ok().build();
	}
	
	/**
	 * 更新教学点人员信息
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTeachingUnitInfoOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		TeachingUnitInfoOfficial entity = (TeachingUnitInfoOfficial)mapper.readValue(jsonEntity.toString(), TeachingUnitInfoOfficial.class);
		this.teachingUnitInfoOfficialLogic.updateTeachingUnitInfoOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据教学点人员ID查找教学点
	 * @param teachingUnitInfoOfficialID
	 * @return
	 */
	@GET
	@Path("teachingUnitInfoOfficials/{teachingUnitInfoOfficialID}")
	@Produces(MediaType.APPLICATION_JSON)
	public TeachingUnitInfoOfficial getTeachingUnitInfoOfficialById(@PathParam("teachingUnitInfoOfficialID") String teachingUnitInfoOfficialID){
		TeachingUnitInfoOfficial instance = this.teachingUnitInfoOfficialLogic.getTeachingUnitInfoOfficialById(teachingUnitInfoOfficialID);
		return instance;
	}
	
	/**
	 * 根据参数查找教学点人员
	 * @param teachingUnitInfoName
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("teachingUnitInfoOfficials")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfoOfficialVO> getTeachingUnitInfoOfficialVOByConditions(
			@DefaultValue("") @QueryParam("teachingUnitInfo") String teachingUnitInfoId,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		List<TeachingUnitInfoOfficialVO> result = this.teachingUnitInfoOfficialLogic.findTeachingUnitInfoOfficialVOByConditions(teachingUnitInfoId, status, realName, loginName, pageNo, pageSize);
		return result;			
	}
	
	/**
	 * 根据条件查询教学点人员获得总记录数
	 * @param teachingUnitInfoId
	 * @param status
	 * @param realName
	 * @param loginName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("teachingUnitInfoOfficialCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("teachingUnitInfo") String teachingUnitInfoId,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName) throws JSONException, UnsupportedEncodingException{
		
		int total = this.teachingUnitInfoOfficialLogic.getTotalRecords(teachingUnitInfoId, status, realName, loginName);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	/**
	 * 根据用户名获取教学点的ID
	 * add 20121101
	 * 
	 * @param loginName
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("teachingUnitInfoID")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTeachingUnitInfoIDByLoginName(
			@DefaultValue("") @QueryParam("loginName") String loginName) throws JSONException{
		String teachingUnitInfoID = this.teachingUnitInfoOfficialLogic.getTeachingUnitInfoIDByLoginName(loginName);
		JSONObject object = new JSONObject();
		object.put("teachingUnitInfoID", teachingUnitInfoID);
		return object;
	}
	
	/**
 * 获得所有的教学点UtilObject
 * @return
 */
@GET
@Path("allTeachingUnitInfoByUtilObject")
@Produces(MediaType.APPLICATION_JSON)
public List<UtilObject> getAllTeachingUnitInfoByUtilObject(){
	return this.teachingUnitInfoOfficialLogic.getAllTeachingUnitInfoByUtilObject();
}
}
