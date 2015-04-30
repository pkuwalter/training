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
import org.wy.ccnu.edu.entity.TrainingProjectPlanVO;
import org.wy.ccnu.edu.entity.persist.TrainingProjectPlan;
import org.wy.ccnu.edu.logic.TrainingProjectPlanLogic;
import org.wy.ccnu.edu.logic.impl.TrainingProjectPlanLogicImpl;

@Path("/trainingProjectPlanService")
public class TrainingProjectPlanService {
	
	private TrainingProjectPlanLogic trainingProjectPlanLogic = new TrainingProjectPlanLogicImpl();
	
	/**
	 * 增加培训计划信息
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("addTrainingProjectPlan")
	@Consumes("application/json")
	public Response addTrainingProjectPlan(JSONObject jsonEntity) throws JSONException,JsonParseException,JsonMappingException,IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		TrainingProjectPlan entity = (TrainingProjectPlan)mapper.readValue(jsonEntity.toString(), TrainingProjectPlan.class);
		this.trainingProjectPlanLogic.save(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除培训计划信息
	 * @param trainingProjectPlanId
	 * @return
	 */
	@POST
	@Path("deleteTrainingProjectPlan/{trainingProjectPlanId}")
	public Response deleteTrainingProjectPlan(@PathParam("trainingProjectPlanId") int trainingProjectPlanId){
		
		TrainingProjectPlan trainingProjectPlan = this.trainingProjectPlanLogic.getTrainingProjectPlanById(trainingProjectPlanId);
		
		this.trainingProjectPlanLogic.delete(trainingProjectPlan);
		
		return Response.ok().build();
		
	}
	
	/**
	 * 修改培训计划信息
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("updateTrainingProjectPlan")
	@Consumes("application/json")
	public Response updateTrainingProjectPlan(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		TrainingProjectPlan entity = (TrainingProjectPlan)mapper.readValue(jsonEntity.toString(), TrainingProjectPlan.class);
		this.trainingProjectPlanLogic.update(entity);
		return Response.ok().build();
	   
	}
	
	/**
	 * 获取培训计划信息的最大的Id
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getMaxTrainingProjectPlanId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxTrainingProjectPlanId() throws JSONException{
		
		int maxId = this.trainingProjectPlanLogic.getMaxTrainingProjectPlanId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxId", maxId);
   		
   		return object;
		
			
	}
	
	
	/**
	 * 获取所有培训计划的列表
	 * @return
	 */
	@GET
	@Path("getAllTrainingProjectPlan")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingProjectPlan> getAllTrainingProjectPlan(){
		
		List<TrainingProjectPlan> list = new ArrayList<TrainingProjectPlan>();
		
		list = this.trainingProjectPlanLogic.getAllTrainingProjectPlan();
		
		return list;
		
	}
	
	/**
	 * 根据培训计划ID获取培训计划信息
	 * @param specialCourseId
	 * @return
	 */
	@GET
	@Path("getTrainingProjectPlanById/{trainingProjectPlanId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingProjectPlan getTrainingProjectPlanById(@PathParam("trainingProjectPlanId") int trainingProjectPlanId){
		TrainingProjectPlan instance = this.trainingProjectPlanLogic.getTrainingProjectPlanById(trainingProjectPlanId);
		return instance;
	}
	

	/**
	 * 根据TrainingProjectPlan的属性来查找培训计划信息
	 * @param property培训计划属性
	 * @param proValue属性的值
	 * @return
	 */
	@GET
	@Path("getTrainingProjectPlanByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingProjectPlan getTrainingProjectPlanByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		TrainingProjectPlan trainingProjectPlan = this.trainingProjectPlanLogic.getTrainingProjectPlanByProperty(property, proValue);
		
		return trainingProjectPlan;
	}
	
	/**
	 * 批量删除培训计划信息
	 * @param trainingProjectPlanIds
	 * @return
	 * @throws JSONException
	 */
	@POST
	@Path("batchDeleteTrainingProjectPlan")
	public JSONObject batchDeleteSpecialCourse(JSONObject trainingProjectPlanIds) throws JSONException{
		boolean successOrNot = this.trainingProjectPlanLogic.batchDeleteTrainingProjectPlan(trainingProjectPlanIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	

	
	/**
	 * 条件查询：获取培训计划设置的详细信息
	 * @param trainingProjectId
	 * @param trainingProjectCode
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getAllTrainingProjectPlanVOInPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingProjectPlanVO> getAllTrainingProjectPlanVOInPage(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("") @QueryParam("trainingProjectCode") String trainingProjectCode,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("coagencyId") String coagencyId,
			@DefaultValue("") @QueryParam("teachingUnitId") String teachingUnitId,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("20") @QueryParam("pageSize") int pageSize){
		List<TrainingProjectPlanVO> result = this.trainingProjectPlanLogic .getAllTrainingProjectPlanVOInPage(trainingProjectId, trainingProjectCode, trainingBatchId, coagencyId, teachingUnitId, pageNo, pageSize);
		return result;
	}
	
	

	/**
	 * 条件查询：获取培训计划设置的总记录数
	 * @param trainingProjectId
	 * @param trainingProjectCode
	 * @param trainingBatchId
	 * @param coagencyId
	 * @param teachingUnitId
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getTotalTrainingProjectPlanVO")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalTrainingProjectPlanVO(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("") @QueryParam("trainingProjectCode") String trainingProjectCode,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("coagencyId") String coagencyId,
			@DefaultValue("") @QueryParam("teachingUnitId") String teachingUnitId)throws JSONException{
		
		int total = this.trainingProjectPlanLogic.getTotalTrainingProjectPlanVO(trainingProjectId, trainingProjectCode, trainingBatchId, coagencyId, teachingUnitId);
		JSONObject object = new JSONObject();
   		object.put("total", total);
   		return object;
	}
	

	/**
	 * 根据项目id，批次id，合作机构id，教学点id，学科id，类别id获取费用价格
	 * @param trainingProjectId		培训项目id
	 * @param trainingBatchId		培训批次id
	 * @param coagencyId			合作机构id
	 * @param teachingUnitInfoId	教学点id
	 * @param specialId				培训学科id
	 * @param educationLevelId		培训批次类型ID（培养类别）
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getFeeStandardByConditions")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getFeeStandardByConditions(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("coagencyId") String coagencyId,
			@DefaultValue("") @QueryParam("teachingUnitId") String teachingUnitInfoId,
			@DefaultValue("") @QueryParam("specialId") String specialId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId)throws JSONException{
		
		int feeStandard = this.trainingProjectPlanLogic.getFeeStandardByConditions(trainingProjectId, trainingBatchId, coagencyId, teachingUnitInfoId, specialId, educationLevelId);
		JSONObject object = new JSONObject();
   		object.put("feeStandard", feeStandard);
   		return object;
		
	}


}
