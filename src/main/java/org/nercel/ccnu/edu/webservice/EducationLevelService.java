package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
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
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.EducationLevel;
import org.nercel.ccnu.edu.logic.EducationLevelLogic;
import org.nercel.ccnu.edu.logic.impl.EducationLevelLogicImpl;

@Path("/educationLevelService")
public class EducationLevelService {
	
	private EducationLevelLogic educationLevelLogic = new EducationLevelLogicImpl();
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEducationLevel(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		EducationLevel entity = (EducationLevel)mapper.readValue(jsonEntity.toString(), EducationLevel.class);
		this.educationLevelLogic.addEducationLevel(entity);
		return Response.ok().build();
	}
	
	/*
	@DELETE
	@Path("delete/{educationLevelID}")
	public Response deleteEducationLevel(@PathParam("educationLevelID") String educationLevelID){
		EducationLevel educationLevel = this.educationLevelLogic.getEducationLevelById(educationLevelID);
		this.educationLevelLogic.deleteEducationLevel(educationLevel);
		return Response.ok().build();
	}*/
	
	@POST
	@Path("deletes")
	public JSONObject batchDeleteEducationLevel(JSONObject educationLevelIds) throws JSONException{
		boolean successOrNot = this.educationLevelLogic.batchDeleteEducationLevel(educationLevelIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEducationLevel(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		EducationLevel entity = (EducationLevel)mapper.readValue(jsonEntity.toString(), EducationLevel.class);
		this.educationLevelLogic.updateEducationLevel(entity);
		return Response.ok().build();
	}
	
	@GET
	@Path("educationLevels/{educationLevelID}")
	@Produces(MediaType.APPLICATION_JSON )
	public EducationLevel getEducationLevelById(@PathParam("educationLevelID") String educationLevelID){
		EducationLevel instance = educationLevelLogic.getEducationLevelById(educationLevelID);
		return instance;
	}
	
	@GET
	@Path("allEducationLevels")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EducationLevel> getAllEducationLevels(){
		return this.educationLevelLogic.getAllEducationLevels();
	}
	
	@GET
	@Path("allEducationLevelsByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllEducationLevelsByUtilObject(){
		return this.educationLevelLogic.getAllEducationLevelsByUtilObject();
	}
	
	@GET
	@Path("teachingPlanExistOrNot")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject teachingPlanExistOrNot(@QueryParam("educationLevelID") String educationLevelID) throws JSONException{
		boolean successOrNot = this.educationLevelLogic.teachingPlanExistOrNot(educationLevelID);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}

	//add by zt
	@GET
	@Path("getIdByName/{educationLevelName}")
	@Produces(MediaType.APPLICATION_JSON )
	public String getIdByName(@PathParam("educationLevelName") String educationLevelName){
		String levelId = educationLevelLogic.getIdByName(educationLevelName);
		return levelId;
	}
}
