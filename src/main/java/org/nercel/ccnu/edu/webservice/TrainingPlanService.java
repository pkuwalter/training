package org.nercel.ccnu.edu.webservice;

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
import org.nercel.ccnu.edu.entity.TrainingPlanVO;
import org.nercel.ccnu.edu.entity.persist.TrainingPlan;
import org.nercel.ccnu.edu.entity.persist.TrainingType;
import org.nercel.ccnu.edu.logic.TrainingPlanLogic;
import org.nercel.ccnu.edu.logic.TrainingTypeLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingPlanLogicImpl;
import org.nercel.ccnu.edu.logic.impl.TrainingTypeLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

@Path("/trainingPlanService")
public class TrainingPlanService {
	private TrainingPlanLogic trainingPlanLogic = new TrainingPlanLogicImpl();

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
		TrainingPlan entity = (TrainingPlan) mapper.readValue(
				jsonEntity.toString(), TrainingPlan.class);
		this.trainingPlanLogic.create(entity);
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
		TrainingPlan entity = (TrainingPlan) mapper.readValue(
				jsonEntity.toString(), TrainingPlan.class);
		this.trainingPlanLogic.update(entity);
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
		trainingPlanLogic.delete(ids);
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
	public TrainingPlan findOne(@QueryParam("id") String id) {
		TrainingPlan entity = trainingPlanLogic.findOne(id);
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
	public PageModel<TrainingPlan> findAll(
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("10") int pageSize) {
		List<TrainingPlan> entityList = trainingPlanLogic.findAll();
		int count = trainingPlanLogic.countAll();
		PageModel<TrainingPlan> pageModel = new PageModel<TrainingPlan>();
		pageModel.setList(entityList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(count);
		return pageModel;

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
		int count = trainingPlanLogic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;

	}

	/**
	 * 根据给定的属性及属性值来模糊查询培养计划列表
	 * @param property
	 * @param proValue
	 * @return
	 */
	@GET
	@Path("getTrainingPlanListByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlan> getTrainingPlanListByProperty(
			@QueryParam("property") String property,
			@QueryParam("proValue") String proValue) {
		List<TrainingPlan> list = this.trainingPlanLogic
				.getTrainingPlanListByProperty(property, proValue);
		return list;
	}

	/**
	 * 根据给定的属性及属性值来查询指定的培养计划
	 * @param property
	 * @param proValue
	 * @return
	 */
	@GET
	@Path("getTrainingPlanByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingPlan getTrainingPlanByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {

		TrainingPlan entity = this.trainingPlanLogic.getTrainingPlanByProperty(
				property, proValue);
		return entity;
	}

	/**
	 * 查找满足条件的培训计划库
	 * 
	 * @param trainingProjectId
	 *            所属项目id
	 * @param trainingProjectCode
	 *            所属项目的代码
	 * @param trainingPlanId
	 *            培训计划id
	 * @param trainingPlanCode
	 *            培训计划代码
	 * @param specialID
	 *            学科id
	 * @param eduLevelId
	 *            培训类型id
	 * @param version
	 *            培训计划版本
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	@GET
	@Path("searchTrainingPlanInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlanVO> searchTrainingPlanInfo(
			@QueryParam("trainingProjectId") int trainingProjectId,
			@QueryParam("trainingProjectCode") String trainingProjectCode,
			@QueryParam("trainingPlanId") String trainingPlanId,
			@QueryParam("trainingPlanCode") String trainingPlanCode,
			@QueryParam("specialID") String specialID,
			@QueryParam("eduLevelId") String eduLevelId,
			@QueryParam("version") String version,
			@QueryParam("beginTime") String beginTime,
			@QueryParam("endTime") String endTime,
			@QueryParam("pageSize") int pageSize,
			@QueryParam("pageNo") int pageNo) {
		List<TrainingPlanVO> list = this.trainingPlanLogic
				.searchTrainingPlanInfo(trainingProjectId, trainingProjectCode,
						trainingPlanId, trainingPlanCode, specialID,
						eduLevelId, version, beginTime, endTime, pageSize,
						pageNo);
		return list;
	}

	/**
	 * 查找满足条件的培训计划库的记录数
	 * 
	 * @param trainingProjectId
	 *            所属项目id
	 * @param trainingProjectCode
	 *            所属项目的代码
	 * @param trainingPlanId
	 *            培训计划id
	 * @param trainingPlanCode
	 *            培训计划代码
	 * @param specialID
	 *            学科id
	 * @param eduLevelId
	 *            培训类型id
	 * @param version
	 *            培训计划版本
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("countTrainingPlanInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject countTrainingPlanInfo(
			@QueryParam("trainingProjectId") int trainingProjectId,
			@QueryParam("trainingProjectCode") String trainingProjectCode,
			@QueryParam("trainingPlanId") String trainingPlanId,
			@QueryParam("trainingPlanCode") String trainingPlanCode,
			@QueryParam("specialID") String specialID,
			@QueryParam("eduLevelId") String eduLevelId,
			@QueryParam("version") String version,
			@QueryParam("beginTime") String beginTime,
			@QueryParam("endTime") String endTime) throws JSONException {
		int count = trainingPlanLogic.countTrainingPlanInfo(trainingProjectId,
				trainingProjectCode, trainingPlanId, trainingPlanCode,
				specialID, eduLevelId, version, beginTime, endTime);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;
	}
}
