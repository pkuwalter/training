package org.wy.ccnu.edu.webservice;

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

import org.wy.ccnu.edu.entity.persist.Political;
import org.wy.ccnu.edu.logic.PoliticalLogic;
import org.wy.ccnu.edu.logic.impl.PoliticalLogicImpl;


@Path("/politicalService")
public class PoliticalService {
	private PoliticalLogic politicalLogic=new PoliticalLogicImpl();
	
//	@POST
//	@Path("addPolitical")
//	@Consumes("application/json")
//	public Response addPolitical(JSONObject jsonEntity) throws JSONException {
//	
//		String politicalId = (String)jsonEntity.get("politicalId");
//		
//		String politicalName = (String)jsonEntity.get("politicalName");
//		
//		Political political = new Political();
//		
//		political.setId(Integer.parseInt(politicalId));	
//		
//		political.setPoliticalName(politicalName);		
//		
//		this.politicalLogic.addPolitical(political);
//		
//		return Response.ok().build();
//		
//	}
	
	@POST
	@Path("addPolitical")
	@Consumes("application/json")
	public Response addPolitical(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Political entity = (Political)mapper.readValue(jsonEntity.toString(), Political.class);
		
		this.politicalLogic.addPolitical(entity);
		return Response.ok().build();
		
	}

	
	@POST
	@Path("deletePolitical/{politicalId}")
	public Response deletePolitical(@PathParam("politicalId") int politicalId){
		
		Political political = this.politicalLogic.getPoliticalByID(politicalId);
		
		this.politicalLogic.deletePolitical(political);
		
		return Response.ok().build();
		
	}
	
	
//	@POST
//	@Path("updatePolitical")
//	@Consumes("application/json")
//	public Response updatePolitical(JSONObject jsonEntity) throws JSONException {
//	
//		String politicalId = (String) jsonEntity.get("politicalId");
//		
//		String politicalName = (String)jsonEntity.get("politicalName");
//		
//		
//
//		
//		Political political = this.politicalLogic.getPoliticalByID(Integer.parseInt(politicalId));
//				
//		political.setId(Integer.parseInt(politicalId));	
//		
//		political.setPoliticalName(politicalName);
//		
//		
//		
//		this.politicalLogic.updatePolitical(political);
//
//		
//		return Response.ok().build();
//		
//	}
	
	@GET
	@Path("getPoliticalByID/{politicalId}")
	@Produces(MediaType.APPLICATION_JSON )
	public Political getPoliticalByID(@PathParam("politicalId") int politicalId){
		//int nationID=Integer.parseInt(nationId);
		System.out.println("politicalId           " + politicalId); 
		Political political = this.politicalLogic.getPoliticalByID(politicalId);
		
		return political;
			
	}
	

	@POST
	@Path("updatePolitical")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePoliticalInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(jsonEntity.toString());
		Political entity = (Political)mapper.readValue(jsonEntity.toString(), Political.class);
		this.politicalLogic.updatePolitical(entity);
		return Response.ok().build();
	   // String nationId = (String)jsonEntity.get("nationId");
			
		//String  nationName = (String)jsonEntity.get("nationName");
		//NationInfo nationInfo = new NationInfo();
					
		//nationInfo.setId(Integer.parseInt(nationId));	
			
		//nationInfo.setNationName(nationName);
		
		//peopleInfo.setId(peopleId);
		
		//this.nationInfoLogic.updateNationInfo(nationInfo);

		
		//return Response.ok().build();
		
	}
	

	
	@GET
	@Path("getpoliticalList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Political> getPoliticalList(){
		
		List<Political> politicalList = new ArrayList<Political>();
		
		politicalList = this.politicalLogic.getPoliticalList();
		
		return politicalList;
		
	}
	@GET
	@Path("getMaxPoliticalId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxNationId() throws JSONException{
		
		int maxId = this.politicalLogic.getMaxPoliticalId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxPoliticalId", maxId);
   		
   		return object;
		
			
	}

	
	 /**
     * 以翻页的形式返回当前页的模块列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GET
	@Path("getAllPoliticalInPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Political> getAllPoliticalInPage(
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize){
		List<Political> result = this.politicalLogic.getAllPoliticalInPage(pageNo, pageSize);
		return result;
	}

    /**
     * 返回政治面貌总数
     * @return
     */
    @GET
   	@Path("getTotalPoliticals")
   	@Produces(MediaType.APPLICATION_JSON)
   	public JSONObject getTotalPoliticals() throws JSONException{
   		int total = this.politicalLogic.getTotalPoliticals();
   		JSONObject object = new JSONObject();
   		object.put("total", total);
   		System.out.println("total: "+total);
   		return object;
   	}
	

	
}
