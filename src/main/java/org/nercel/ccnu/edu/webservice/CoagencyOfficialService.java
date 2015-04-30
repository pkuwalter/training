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
import org.nercel.ccnu.edu.entity.CoagencyOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.CoagencyOfficial;
import org.nercel.ccnu.edu.logic.CoagencyOfficialLogic;
import org.nercel.ccnu.edu.logic.impl.CoagencyOfficialLogicImpl;

@Path("/baseInfo/coagencyOfficialService")
public class CoagencyOfficialService {


	private CoagencyOfficialLogic coagencyOfficialLogic = new CoagencyOfficialLogicImpl();
	
	/**
	 * 增加合作机构人员
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCoagencyOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CoagencyOfficial entity = (CoagencyOfficial)mapper.readValue(jsonEntity.toString(), CoagencyOfficial.class);
		this.coagencyOfficialLogic.addCoagencyOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除合作机构人员
	 * @param coagencyOfficialID
	 * @return
	 */
	@DELETE
	@Path("delete/{coagencyOfficialID}")
	public Response deleteCoagencyOfficial(@PathParam("coagencyOfficialID") String coagencyOfficialID){
		CoagencyOfficial coagencyOfficial = this.coagencyOfficialLogic.getCoagencyOfficialById(coagencyOfficialID);
		this.coagencyOfficialLogic.deleteCoagencyOfficial(coagencyOfficial);
		return Response.ok().build();
	}
	
	/**
	 * 批量删除合作机构人员
	 * @param coagencyOfficialIDs
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response batchDeleteCoagencyOfficial(JSONObject coagencyOfficialIDs) throws JSONException{
		this.coagencyOfficialLogic.batchDeleteCoagencyOfficial(coagencyOfficialIDs);
		return Response.ok().build();
	}
	
	/**
	 * 更新合作机构人员信息
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCoagencyOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CoagencyOfficial entity = (CoagencyOfficial)mapper.readValue(jsonEntity.toString(), CoagencyOfficial.class);
		this.coagencyOfficialLogic.updateCoagencyOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据合作机构人员ID查找合作机构人员
	 * @param coagencyOfficialID
	 * @return
	 */
	@GET
	@Path("coagencyOfficials/{coagencyOfficialID}")
	@Produces(MediaType.APPLICATION_JSON)
	public CoagencyOfficial getCoagencyOfficialById(@PathParam("coagencyOfficialID") String coagencyOfficialID){
		CoagencyOfficial instance = this.coagencyOfficialLogic.getCoagencyOfficialById(coagencyOfficialID);
		return instance;
	}
	
	/**
	 * 根据参数查找合作机构人员
	 * @param coagencyName
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("coagencyOfficials")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CoagencyOfficialVO> getCoagencyOfficialByConditions(
			@DefaultValue("") @QueryParam("coagency") String coagency,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		String real = java.net.URLDecoder.decode(realName, "UTF-8");
		String login = java.net.URLDecoder.decode(loginName, "UTF-8");
		List<CoagencyOfficialVO> result = this.coagencyOfficialLogic.getCoagencyOfficialByConditions(coagency, status, real, login, pageNo, pageSize);
		return result;
	}
	
	/**
	 * 根据条件查询合作机构人员获得总记录数
	 * @param gradeName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException 
	 */
	@GET
	@Path("coagencyOfficialCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("coagency") String coagency,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName) throws JSONException, UnsupportedEncodingException{
		
		String real = java.net.URLDecoder.decode(realName, "UTF-8");
		String login = java.net.URLDecoder.decode(loginName, "UTF-8");
		int total = this.coagencyOfficialLogic.getTotalRecords(coagency, status, real, login);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}

		/**
		 * 获得所有的合作机构UtilObject
		 * @return
		 */
		@GET
		@Path("allCoagencyByUtilObject")
		@Produces(MediaType.APPLICATION_JSON)
		public List<UtilObject> getAllCoagencyByUtilObject(){

			return this.coagencyOfficialLogic.getAllCoagencyByUtilObject();
		}
}
