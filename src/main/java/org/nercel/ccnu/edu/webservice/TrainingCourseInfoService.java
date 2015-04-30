package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.core.MediaType;

import org.nercel.ccnu.edu.entity.persist.TrainingCourseInfo;
import org.nercel.ccnu.edu.logic.TrainingCourseInfoLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingCourseInfoLogicImpl;

@Path("/trainingCourseInfoService")
public class TrainingCourseInfoService {
	
	private TrainingCourseInfoLogic trainingCourseInfoLogic = new TrainingCourseInfoLogicImpl();
	
	/**
	 * 增加培训课程
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("addTrainingCourseInfo")
	@Consumes("application/json")
	public Response addTrainingCourseInfo(JSONObject jsonEntity) throws JSONException,JsonParseException,JsonMappingException,IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		TrainingCourseInfo entity = (TrainingCourseInfo)mapper.readValue(jsonEntity.toString(), TrainingCourseInfo.class);
		this.trainingCourseInfoLogic.save(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除培训课程
	 * @param id
	 * @return
	 */
	@POST
	@Path("deleteTrainingCourseInfo/{id}")
	public Response deleteCourseInfo(@PathParam("id") int id){
		
		TrainingCourseInfo trainingCourseInfo = this.trainingCourseInfoLogic.getTrainingCourseInfoById(id);
		
		this.trainingCourseInfoLogic.delete(trainingCourseInfo);
		
		return Response.ok().build();
		
	}
	
	/**
	 * 修改培训课程
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("updateTrainingCourseInfo")
	@Consumes("application/json")
	public Response updateTrainingCourseInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		TrainingCourseInfo entity = (TrainingCourseInfo)mapper.readValue(jsonEntity.toString(), TrainingCourseInfo.class);
		this.trainingCourseInfoLogic.update(entity);
		return Response.ok().build();
	   
	}
	
	/**
	 * 获取培训课程信息的最大的Id
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getMaxTrainingCourseInfoId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxTrainingCourseInfoId() throws JSONException{
		
		int maxId = this.trainingCourseInfoLogic.getMaxTrainingCourseInfoId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxId", maxId);
   		
   		return object;
		
			
	}
	
	/**
	 * 获取所有培训课程的列表
	 * @return
	 */
	@GET
	@Path("getAllTrainingCourseInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingCourseInfo> getAllTrainingCourseInfo(){
		
		List<TrainingCourseInfo> list = new ArrayList<TrainingCourseInfo>();
		
		list = this.trainingCourseInfoLogic.getAllTrainingCourseInfo();
		
		return list;
		
	}
	
	/**
	 * 根据课程ID获取培训课程课程信息
	 * @param id
	 * @return
	 */
	@GET
	@Path("getTrainingCourseInfoById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingCourseInfo getTrainingCourseInfoById(@PathParam("id") int id){
		TrainingCourseInfo instance = this.trainingCourseInfoLogic.getTrainingCourseInfoById(id);
		return instance;
	}
	

}
