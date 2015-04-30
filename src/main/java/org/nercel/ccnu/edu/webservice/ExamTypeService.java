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
import org.nercel.ccnu.edu.entity.persist.ExamType;
import org.nercel.ccnu.edu.entity.persist.ProvinceInfo;
import org.nercel.ccnu.edu.logic.ExamTypeLogic;
import org.nercel.ccnu.edu.logic.impl.ExamTypeLogicImpl;

@Path("/examTypeService")
public class ExamTypeService {
	
	private ExamTypeLogic examTypeLogic = new ExamTypeLogicImpl();
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addExamType(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		ExamType entity = (ExamType)mapper.readValue(jsonEntity.toString(), ExamType.class);
		this.examTypeLogic.addExamType(entity);
		return Response.ok().build();
	}
	
	
	@POST
	@Path("deletes")
	public JSONObject batchDeleteExamType(JSONObject examTypeIds) throws JSONException{
		boolean successOrNot = this.examTypeLogic.batchDeleteExamType(examTypeIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateExamType(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		ExamType entity = (ExamType)mapper.readValue(jsonEntity.toString(), ExamType.class);
		this.examTypeLogic.updateExamType(entity);
		return Response.ok().build();
	}
	
	@GET
	@Path("examTypes/{examTypeID}")
	@Produces(MediaType.APPLICATION_JSON )
	public ExamType getExamTypeById(@PathParam("examTypeID") int examTypeID){
		ExamType instance = examTypeLogic.getExamTypeById(examTypeID);
		return instance;
	}
	
	@GET
	@Path("allExamTypes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExamType> getAllExamTypes(){
		return this.examTypeLogic.getAllExamTypes();
	}
	
	@GET
	@Path("allExamTypesByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllExamTypesByUtilObject(){
		return this.examTypeLogic.getAllExamTypesByUtilObject();
	}
	
	@GET
	@Path("teachingPlanExistOrNot")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject teachingPlanExistOrNot(@QueryParam("examTypeID") String examTypeID) throws JSONException{
		boolean successOrNot = this.examTypeLogic.teachingPlanExistOrNot(examTypeID);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}

	@GET
	@Path("getIdByName/{examTypeName}")
	@Produces(MediaType.APPLICATION_JSON )
	public String getIdByName(@PathParam("examTypeName") String examTypeName){
		String levelId = examTypeLogic.getIdByName(examTypeName);
		return levelId;
	}
	
	@GET
	@Path("getExamTypeByProperty/{property}-{proValue}-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  ExamType getExamTypeByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue,
			@PathParam("id") int id) {
		 System.out.println(proValue+"考试方式service");
		ExamType examType = this.examTypeLogic
				.getExamTypeByProperty(property, proValue,id);
		return examType;
	}
	
	/**
	 * 根据examType的属性来查找考试方式信息（没有id）
	 * @author yangyingjie
	 * @param property
	 * @param proValue
	 * @return
	 */
	@GET
	@Path("getExamTypeByOneProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public  ExamType getExamTypeByOneProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		ExamType examType = this.examTypeLogic.getExamTypeByOneProperty(property, proValue);
		return examType;
	}
	
	@GET
	@Path("getMaxExamTypeId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxExamTypeId() throws JSONException {

		int maxExamTypeId = this.examTypeLogic.getMaxExamTypeId();

		JSONObject object = new JSONObject();

		object.put("maxExamTypeId", maxExamTypeId);

		return object;
	}
}
