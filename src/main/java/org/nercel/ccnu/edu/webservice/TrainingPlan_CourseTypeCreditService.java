package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan_CourseTypeCredit;
import org.nercel.ccnu.edu.logic.TrainingPlan_CourseTypeCreditLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingPlan_CourseTypeCreditLogicImpl;

@Path("/trainingPlan_CourseTypeCreditService")
public class TrainingPlan_CourseTypeCreditService {
	private TrainingPlan_CourseTypeCreditLogic trainingPlan_CourseTypeCreditLogic = new TrainingPlan_CourseTypeCreditLogicImpl();

	/**
	 * 创建
	 * 
	 * @param entity
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(JSONObject jsonEntity) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TrainingPlan_CourseTypeCredit entity = (TrainingPlan_CourseTypeCredit) mapper.readValue(
				jsonEntity.toString(), TrainingPlan_CourseTypeCredit.class);
		this.trainingPlan_CourseTypeCreditLogic.create(entity);
		return Response.ok().build();

	}

	/**
	 * 修改
	 * 
	 * @param entity
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonEntity) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TrainingPlan_CourseTypeCredit entity = (TrainingPlan_CourseTypeCredit) mapper.readValue(
				jsonEntity.toString(), TrainingPlan_CourseTypeCredit.class);
		this.trainingPlan_CourseTypeCreditLogic.update(entity);
		return Response.ok().build();

	}

	/**
	 * 删除
	 * 
	 * @param ids
	 * @throws JSONException
	 */
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("ids") String ids) throws JSONException {
		trainingPlan_CourseTypeCreditLogic.delete(ids);
		return Response.ok().build();

	}

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/findOne")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingPlan_CourseTypeCredit findOne(@QueryParam("id") String id) {
		TrainingPlan_CourseTypeCredit entity = trainingPlan_CourseTypeCreditLogic.findOne(id);
		return entity;

	}

	/**
	 * 所有记录
	 * 
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlan_CourseTypeCredit> findAll(
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("10") int pageSize) {
		List<TrainingPlan_CourseTypeCredit> entityList = trainingPlan_CourseTypeCreditLogic.findAll();
		return entityList;

	}

	/**
	 * 记录总数
	 * 
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("/countAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject countAll() throws JSONException {
		int count = trainingPlan_CourseTypeCreditLogic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;

	}
	
	/**
	 * 根据培养计划id、课程类别代码和学生id来查询该培养计划该课程类别的最大选修学分
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别代码
	 * @param studentId
	 * 			学生id
	 * @return
	 * 			返回单个对象TrainingPlan_CourseTypeCredit
	 */
	@GET
	@Path("/getTPTypeCreditByPlanIdAndCodeAndStuId")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingPlan_CourseTypeCredit getTPTypeCreditByPlanIdAndCodeAndStuId(
			@QueryParam("trainingPlanId") String trainingPlanId,  
			@QueryParam("courseTypeCode") String courseTypeCode,
			@QueryParam("studentId") String studentId) {
		TrainingPlan_CourseTypeCredit entity = this.trainingPlan_CourseTypeCreditLogic
				.getTPTypeCreditByPlanIdAndCodeAndStuId(trainingPlanId, courseTypeCode, studentId);
		return entity;
	}
	
	/**
	 * 根据培养计划id来查询其所有类别的课程的最大选修学分的信息
	 * @param trainingPlanId
	 * @return
	 */
	@GET
	@Path("/getTrainingPlan_CourseTypeCreditByPlanId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlan_CourseTypeCredit> getTrainingPlan_CourseTypeCreditByPlanId(
			@QueryParam("trainingPlanId") String trainingPlanId){
		List<TrainingPlan_CourseTypeCredit> list = trainingPlan_CourseTypeCreditLogic
				.getTrainingPlan_CourseTypeCreditByPlanId(trainingPlanId);
		return list;
		
	}

}
