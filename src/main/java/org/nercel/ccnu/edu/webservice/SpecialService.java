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
import org.nercel.ccnu.edu.entity.persist.Special;
import org.nercel.ccnu.edu.logic.SpecialLogic;
import org.nercel.ccnu.edu.logic.impl.SpecialLogicImpl;

@Path("/specialService")
public class SpecialService {
	
	private SpecialLogic specialLogic = new SpecialLogicImpl();
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSpecial(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Special entity = (Special)mapper.readValue(jsonEntity.toString(), Special.class);
		this.specialLogic.addSpecial(entity);
		return Response.ok().build();
	}
	
	@POST
	@Path("deletes")
	public JSONObject batchDeleteSpecial(JSONObject specialIds) throws JSONException{
		boolean successOrNot = this.specialLogic.batchDeleteSpecial(specialIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@GET
	@Path("teachingPlanExistOrNot")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject teachingPlanExistOrNot(@QueryParam("specialID") String specialID) throws JSONException{
		boolean successOrNot = this.specialLogic.teachingPlanExistOrNot(specialID);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSpecial(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Special entity = (Special)mapper.readValue(jsonEntity.toString(), Special.class);
		this.specialLogic.updateSpecial(entity);
		return Response.ok().build();
	}
	
	@GET
	@Path("specials/{specialID}")
	@Produces(MediaType.APPLICATION_JSON )
	public Special getSpecialById(@PathParam("specialID") String specialID){
		Special instance = this.specialLogic.getSpecialById(specialID);
		return instance;
	}
	
	@GET
	@Path("specialByName")
	@Produces(MediaType.APPLICATION_JSON )
	public Special getSpecialByName(@QueryParam("specialName") String specialName){
		Special instance = this.specialLogic.getSpecialByName(specialName);
		return instance;
	}
	
	@GET
	@Path("specialsByEducationLevelID/{educationLevelID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Special> getSpecialbyEducationLevelID(@PathParam("educationLevelID") String educationLevelID){
		List<Special> result = this.specialLogic.getSpecialbyEducationLevelID(educationLevelID);
		return result;
	}
	
	@GET
	@Path("allSpecials")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Special> getAllSpecials(){
		return this.specialLogic.getAllSpecials();
	}
	
	@GET
	@Path("allSpecialsByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllSpecialsByUtilObject(){
		return this.specialLogic.getAllSpecialsByUtilObject();
	}
	
	@GET
	@Path("allSpecialUtilsByGradeAndEducationLevel")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getSpecialUtilsByGradeAndEducationLevel(@QueryParam("gradeID") String gradeID,@QueryParam("educationLevelID") String educationLevelID){
		return this.specialLogic.getSpecialUtilsByGradeAndEducationLevel(gradeID, educationLevelID);
	}
	
	
	@GET
	@Path("allSpecialsInTeachingPlan")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Special> getAllSpecialsInTeachingPlan(){
		return this.specialLogic.getAllSpecialsInTeachingPlan();
	}
	
	@GET
	@Path("specialsInTeachingPlanByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getSpecialsInTeachingPlanByUtilObject(){
		return this.specialLogic.getSpecialsInTeachingPlanByUtilObject();
	}
}
