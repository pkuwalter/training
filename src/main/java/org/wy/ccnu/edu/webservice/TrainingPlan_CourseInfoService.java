package org.wy.ccnu.edu.webservice;

import java.io.IOException;
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
import org.wy.ccnu.edu.entity.TrainingPlanCourseInfoVO;
import org.wy.ccnu.edu.entity.persist.TrainingPlan_CourseInfo;
import org.wy.ccnu.edu.logic.TrainingPlan_CourseInfoLogic;
import org.wy.ccnu.edu.logic.impl.TrainingPlan_CourseInfoLogicImpl;

@Path("/trainingPlan_CourseInfoService")
public class TrainingPlan_CourseInfoService {
	private TrainingPlan_CourseInfoLogic trainingPlan_CourseInfoLogic = new TrainingPlan_CourseInfoLogicImpl();

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
		TrainingPlan_CourseInfo entity = (TrainingPlan_CourseInfo) mapper.readValue(
				jsonEntity.toString(), TrainingPlan_CourseInfo.class);
		//entity.setId(null);
		this.trainingPlan_CourseInfoLogic.create(entity);
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
		TrainingPlan_CourseInfo entity = (TrainingPlan_CourseInfo) mapper.readValue(
				jsonEntity.toString(), TrainingPlan_CourseInfo.class);
		this.trainingPlan_CourseInfoLogic.update(entity);
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
		trainingPlan_CourseInfoLogic.delete(ids);
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
	public TrainingPlan_CourseInfo findOne(@QueryParam("id") String id) {
		TrainingPlan_CourseInfo entity = trainingPlan_CourseInfoLogic.findOne(id);
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
	public List<TrainingPlan_CourseInfo> findAll(
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("10") int pageSize) {
		List<TrainingPlan_CourseInfo> entityList = trainingPlan_CourseInfoLogic.findAll();
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
		int count = trainingPlan_CourseInfoLogic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;

	}

	/**
	 * 根据给定的属性及属性值来查询指定的培养计划课程信息
	 * @param property
	 * @param proValue
	 * @return
	 */
	@GET
	@Path("/getTrainingPlan_CourseInfoByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingPlan_CourseInfo getTrainingPlan_CourseInfoByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {

		TrainingPlan_CourseInfo entity = this.trainingPlan_CourseInfoLogic.getTrainingPlan_CourseInfoByProperty(
				property, proValue);
		return entity;
	}
	
	/**
	  * 根据培养计划 的id、课程类别的code和学生id查询培养计划课程信息
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别code
	 * @param studentId
	 * 			学生id
	 * @return
	 * 			培养计划课程信息列表List
	 */
	@GET
	@Path("/getTPCourseVOByPlanIdAndCodeAndStuId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlanCourseInfoVO> getTPCourseVOByPlanIdAndCodeAndStuId(
			@QueryParam("trainingPlanId") String trainingPlanId,  
			@QueryParam("courseTypeCode") String courseTypeCode,
			@QueryParam("studentId") String studentId) {
		List<TrainingPlanCourseInfoVO> list = this.trainingPlan_CourseInfoLogic
				.getTPCourseVOByPlanIdAndCodeAndStuId(trainingPlanId, courseTypeCode, studentId);
		return list;
	}

	/**
	 * 根据培养计划id和课程类别代码来查询该培养计划该课程类别已经选修的学分
	 * @param trainingPlanId
	 * 			培养计划id
	 * @param courseTypeCode
	 * 			课程类别代码
	 * @return
	 * 			返回countCredit
	 * @throws JSONException 
	 */
	@GET
	@Path("/countCreditOfChooseCourseType")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject countCreditOfChooseCourseType(
			@QueryParam("trainingPlanId") String trainingPlanId,  
			@QueryParam("courseTypeCode") String courseTypeCode) throws JSONException {
		int countCredit = trainingPlan_CourseInfoLogic
				.countCreditOfChooseCourseType(trainingPlanId, courseTypeCode);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("countCredit", countCredit);
		return jsonObject;
	}
	
	/**
	 * 根据培养计划id来查询课程信息列表
	 * @param trainingPlanId
	 * 			培养计划id
	 * @return
	 * 			List<TrainingPlan_CourseInfo>
	 */
	@GET
	@Path("/getTrainingPlan_CourseInfoByPlanId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlan_CourseInfo> getTrainingPlan_CourseInfoByPlanId(
			@QueryParam("trainingPlanId") String trainingPlanId){
		List<TrainingPlan_CourseInfo> list = trainingPlan_CourseInfoLogic
				.getTrainingPlan_CourseInfoByPlanId(trainingPlanId);
		return list;
	}
}
