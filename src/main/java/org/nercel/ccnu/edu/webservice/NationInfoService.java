package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.ArrayList;
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
 
import org.nercel.ccnu.edu.entity.persist.NationInfo;
import org.nercel.ccnu.edu.logic.NationInfoLogic;
import org.nercel.ccnu.edu.logic.impl.NationInfoLogicImpl;
 



@Path("/nationInfo")
public class NationInfoService {

	
	private NationInfoLogic nationInfoLogic = new NationInfoLogicImpl();
	

	/**
	 * 增加民族信息
	 * @param entity
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("addNationInfo")
	@Consumes("application/json")
	public Response addNationInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		NationInfo entity = (NationInfo)mapper.readValue(jsonEntity.toString(), NationInfo.class);
		
		this.nationInfoLogic.addNationInfo(entity);
		return Response.ok().build();
		
	}
	
	@POST
	@Path("deleteNationInfo/{nationID}")
	public Response deleteNationInfo(@PathParam("nationID") int nationId){
		
		NationInfo nationInfo = this.nationInfoLogic.getNationInfoByID(nationId);
		
		this.nationInfoLogic.deleteNationInfo(nationInfo);
		
		return Response.ok().build();
		
	}
	
	
	@POST
	@Path("updateNationInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNationInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(jsonEntity.toString());
		NationInfo entity = (NationInfo)mapper.readValue(jsonEntity.toString(), NationInfo.class);
		this.nationInfoLogic.updateNationInfo(entity);
		return Response.ok().build();
	   
	}
	
	@GET
	@Path("getNationById/{nationID}")
	@Produces(MediaType.APPLICATION_JSON )
	public NationInfo getNationInfoById(@PathParam("nationID") int nationId){
		//int nationID=Integer.parseInt(nationId);
		System.out.println("nationId           " + nationId); 
		NationInfo nationInfo = this.nationInfoLogic.getNationInfoByID(nationId);
		
		return nationInfo;
			
	}
	
	
	@GET
	@Path("getnationList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NationInfo> getnationList(){
		
		List<NationInfo> nationList = new ArrayList<NationInfo>();
		
		nationList = this.nationInfoLogic.getNationInfoList();
		
		return nationList;
		
	}
	@GET
	@Path("getMaxNationId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxNationId() throws JSONException{
		
		int maxId = this.nationInfoLogic.getMaxNationId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxNationId", maxId);
   		
   		return object;
		
			
	}
	
	 /**
     * 返回民族总数
     * @return
     */
    @GET
   	@Path("getTotalNations")
   	@Produces(MediaType.APPLICATION_JSON)
   	public JSONObject getTotalNations() throws JSONException{
   		int total = this.nationInfoLogic.getTotalNations();
   		JSONObject object = new JSONObject();
   		object.put("total", total);
   		System.out.println("total: "+total);
   		return object;
   	}
	
	   /**
     * 以翻页的形式返回当前页的模块列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GET
	@Path("getAllNationInPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NationInfo> getAllNationInPage(
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize){
		List<NationInfo> result = this.nationInfoLogic.getAllNationInPage(pageNo, pageSize);
		return result;
	}
	
}
	