package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
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
import org.nercel.ccnu.edu.entity.persist.SupervisorOfficial;
import org.nercel.ccnu.edu.logic.SupervisorOfficialLogic;
import org.nercel.ccnu.edu.logic.impl.SupervisorOfficialLogicImpl;

@Path("/supervisor/supervisorOfficialService")
public class SupervisorOfficialService {
	
	private SupervisorOfficialLogic supervisorOfficialLogic = new SupervisorOfficialLogicImpl();
	
	 
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudyCenterOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		SupervisorOfficial entity = (SupervisorOfficial)mapper.readValue(jsonEntity.toString(), SupervisorOfficial.class);
		this.supervisorOfficialLogic.save(entity);
		return Response.ok().build();
	}
	
	 
	
	/**
	 * 批量删除 
	 * @param studyCenterOfficialIDs
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStudyCenterOfficial(JSONObject supervisorOfficialIds) throws JSONException{
		this.supervisorOfficialLogic.batchDeleteSupervisorOfficial(supervisorOfficialIds);
		return Response.ok().build();
	}
	
	 
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudyCenterOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		SupervisorOfficial entity = (SupervisorOfficial)mapper.readValue(jsonEntity.toString(), SupervisorOfficial.class);
		this.supervisorOfficialLogic.update(entity);
		return Response.ok().build();
	}
	
	 
	@GET
	@Path("getSupervisorOfficialById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SupervisorOfficial getSupervisorOfficialById(@PathParam("id") String id){
		SupervisorOfficial instance = this.supervisorOfficialLogic.findSupervisorOfficialById(id);
		return instance;
	}
	
	/**
	 * 根据参数查找 
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("findSupervisorOfficialListByConditions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SupervisorOfficial> findSupervisorOfficialListByConditions(
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName,
			@DefaultValue("3") @QueryParam("status") int status,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
//		System.out.println("-----ser-------realName="+realName); 
//		System.out.println("-----ser-------loginName="+loginName);
//		System.out.println("-----ser-------status="+status);
		
		List<SupervisorOfficial> result = this.supervisorOfficialLogic.findSupervisorOfficialListByConditions(realName, loginName, status, pageNo, pageSize);
		return result; 
	}
	
	 
	@GET
	@Path("getTotalRecords")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName,
			@DefaultValue("3") @QueryParam("status") int status) throws JSONException, UnsupportedEncodingException{
		
		 
		int total = this.supervisorOfficialLogic.getTotalRecords(realName, loginName, status);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	@GET
   	@Path("isLoginNameExist/{loginNameString}")
   	@Produces(MediaType.APPLICATION_JSON )
	public JSONObject isLoginNameExist(@PathParam("loginNameString") String loginName)
			 throws JSONException{
//    	System.out.println("------ser-----"+loginName);
    	int flag = this.supervisorOfficialLogic.isLoginNameExist(loginName);
    	
    	JSONObject object = new JSONObject();
		
    	object.put("flag", flag);
		 
		return object;
    }
}
