package org.nercel.ccnu.edu.webservice;

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
import org.nercel.ccnu.edu.entity.TrainingPlan_StudentVO;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan_Student;
import org.nercel.ccnu.edu.logic.TrainingPlan_StudentLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingPlan_StudentLogicImpl;

@Path("/trainingPlan_Student")
public class TrainingPlan_StudentService {
	TrainingPlan_StudentLogic logic = new TrainingPlan_StudentLogicImpl();
	

	/**
	 * 添加 
	 * @param entity
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("addTrainingPlan_Student")
	@Consumes("application/json")
	public Response addTrainingPlan_Student(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		TrainingPlan_Student entity = (TrainingPlan_Student)mapper.readValue(jsonEntity.toString(), TrainingPlan_Student.class);
		
		this.logic.save(entity);
		return Response.ok().build();
		
	}

	//批量删除
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("batchDeleteTrainingPlan_Student/{ids}")
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject batchDeleteTrainingPlan_Student(@PathParam("ids")String ids) throws JSONException{
		boolean sucessOrNot = this.logic.batchDeleteByIds(ids);
		JSONObject object = new JSONObject();
		object.put("sucessOrNot", sucessOrNot);
		return object;
	}
	
	//更新
	@POST
	@Path("updateTrainingPlan_Student")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTrainingPlan_Student(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		TrainingPlan_Student entity = (TrainingPlan_Student)mapper.readValue(jsonEntity.toString(), TrainingPlan_Student.class);
		this.logic.update(entity); 
		return Response.ok().build();
	   
	}
	
	@GET
	@Path("getTrainingPlan_StudentById/{id}")
	@Produces(MediaType.APPLICATION_JSON )
	public TrainingPlan_Student getTrainingPlan_StudentById(@PathParam("id") String id){
		return this.logic.getById(id);
	}
	
	/**
	 * 根据条件查询学生培训计划信息
	 * @param trainingProjectId
	 * @param trainingPlanId
	 * @param teachingPlanPemplateId
	 * @param trainingBatchId
	 * @param stuInputType
	 * @param stuInputValue
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param educationLevelId
	 * @param specialId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getTrainingPlan_StudentByConditions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlan_StudentVO> getTrainingPlan_StudentByConditions(
			@DefaultValue("0") @QueryParam("belongProject") int belongProject,
			@DefaultValue("") @QueryParam("trainingPlanId") String trainingPlanId,
			@DefaultValue("") @QueryParam("teachingPlanTemplateId") String teachingPlanTemplateId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("0") @QueryParam("stuInputType") int stuInputType,
			@DefaultValue("") @QueryParam("stuInputValue") String stuInputValue,
			@DefaultValue("") @QueryParam("coagencyId") String coagencyId,
			@DefaultValue("") @QueryParam("teachingUnitInfoId") String teachingUnitInfoId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId,
			@DefaultValue("") @QueryParam("specialId") String specialId,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize){
		return this.logic.getTrainingPlan_StudentByConditions(belongProject, trainingPlanId, teachingPlanTemplateId, trainingBatchId, stuInputType, stuInputValue, coagencyId, teachingUnitInfoId, educationLevelId, specialId, pageNo, pageSize);
	}
	
	/**
	 * 根据条件查询学生培训计划信息记录数
	 * @param trainingProjectId
	 * @param trainingPlanId
	 * @param teachingPlanPemplateId
	 * @param trainingBatchId
	 * @param stuInputType
	 * @param stuInputValue
	 * @param coagencyId
	 * @param teachingUnitInfoId
	 * @param educationLevelId
	 * @param specialId
	 * @return
	 */
	@GET
	@Path("getRecordsOfTrainingPlan_StudentByConditions")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getRecordsOfTrainingPlan_StudentByConditions(
			@DefaultValue("0") @QueryParam("belongProject") int belongProject,
			@DefaultValue("") @QueryParam("trainingPlanId") String trainingPlanId,
			@DefaultValue("") @QueryParam("teachingPlanPemplateId") String teachingPlanPemplateId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("0") @QueryParam("stuInputType") int stuInputType,
			@DefaultValue("") @QueryParam("stuInputValue") String stuInputValue,
			@DefaultValue("") @QueryParam("coagencyId") String coagencyId,
			@DefaultValue("") @QueryParam("teachingUnitInfoId") String teachingUnitInfoId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId,
			@DefaultValue("") @QueryParam("specialId") String specialId) throws JSONException{
		
		int maxCode = this.logic.getRecordsOfTrainingPlan_StudentByConditions(belongProject, trainingPlanId, teachingPlanPemplateId, trainingBatchId, stuInputType, stuInputValue, coagencyId, teachingUnitInfoId, educationLevelId, specialId);
		
		JSONObject object = new JSONObject();
		
   		object.put("total", maxCode);
   		
   		return object;
			
	}
	
	/**
	 * 批量设置学生培训计划
	 * @param ids						--学生培训计划ids
	 * @param trainingPlanId				--培训计划库id
	 * @param teachingPlanPemplateId	--培训计划模板库id
	 */
	@POST
	@Path("batchUpdateTrainingPlan_Student")
	@Consumes(MediaType.APPLICATION_JSON)	
	public void batchUpdateTrainingPlan_Student(
			@DefaultValue("") @QueryParam("ids")String ids,
			@DefaultValue("") @QueryParam("trainingPlanId")String trainingPlanId, 
			@DefaultValue("") @QueryParam("teachingPlanPemplateId")String teachingPlanPemplateId) {
		this.logic.batchUpdateTrainingPlan_Student(ids, trainingPlanId, teachingPlanPemplateId);
	}
		
	
	
}
