package org.wy.ccnu.edu.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import org.wy.ccnu.edu.entity.TrainingSpecialDetailVO;
import org.wy.ccnu.edu.entity.persist.EducationLevel;
import org.wy.ccnu.edu.entity.persist.TrainingProjectPlan;
import org.wy.ccnu.edu.logic.TrainingBatchSpecialLogic;
import org.wy.ccnu.edu.logic.impl.TrainingBatchSpecialLogicImpl;

@Path("/trainingBatchSpecialService")
public class TrainingBatchSpecialService {

	private TrainingBatchSpecialLogic trainingBatchSpecialLogic = new TrainingBatchSpecialLogicImpl();

	@GET
	@Path("getAllSpecialList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingSpecialDetailVO> getAllSpecialList(
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId) {
		List<TrainingSpecialDetailVO> list = new ArrayList<TrainingSpecialDetailVO>();
		list = this.trainingBatchSpecialLogic.getAllSpecialList(educationLevelId);

		return list;
	}

	@GET
	@Path("ifExistTrainingProjectPlanId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject ifExistTrainingProjectPlanId(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId,
			@DefaultValue("") @QueryParam("specialId") String specialId)
			throws JSONException {
		int trainingProjectPlanId = this.trainingBatchSpecialLogic
				.ifExistTrainingProjectPlanId(trainingProjectId,
						trainingBatchId, educationLevelId, specialId);
		JSONObject object = new JSONObject();
		object.put("trainingProjectPlanId", trainingProjectPlanId);
		return object;

	}
	@GET
	@Path("getFeeStandard")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getFeeStandard(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId,
			@DefaultValue("") @QueryParam("specialId") String specialId)
					throws JSONException {
		int feeStandard = this.trainingBatchSpecialLogic
				.getFeeStandard(trainingProjectId,
						trainingBatchId, educationLevelId, specialId);
		JSONObject object = new JSONObject();
		object.put("feeStandard", feeStandard);
		return object;
		
	}
	@GET
	@Path("findByProjectIdBatchId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EducationLevel> findByProjectIdBatchId(
			@QueryParam("projectId") @DefaultValue("0") int projectId,
			@QueryParam("batchId") @DefaultValue("0") int batchId) {
		List<EducationLevel> educationLevelList = this.trainingBatchSpecialLogic
				.findByProjectIdBatchId(projectId, batchId);
		return educationLevelList;
	}

	@GET
	@Path("checkTrainingProjectPlan")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingProjectPlan checkTrainingProjectPlan(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId,
			@DefaultValue("") @QueryParam("specialId") String specialId) {
		TrainingProjectPlan trainingProjectPlan = this.trainingBatchSpecialLogic
				.checkTrainingProjectPlan(trainingProjectId, trainingBatchId,
						educationLevelId, specialId);
		return trainingProjectPlan;

	}

	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTrainingProjectPlan(JSONObject jsonEntity)
			throws JsonParseException, JsonMappingException, IOException,
			JSONException {
		ObjectMapper mapper = new ObjectMapper();
		TrainingProjectPlan entity = (TrainingProjectPlan) mapper.readValue(
				jsonEntity.toString(), TrainingProjectPlan.class);
		this.trainingBatchSpecialLogic.addTrainingProjectPlan(entity);
		return Response.ok().build();
	}

	@GET
	@Path("getTrainingProjectPlanById")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingProjectPlan> getTrainingProjectPlanById(
			@DefaultValue("0") @QueryParam("id") int id) {
		List<TrainingProjectPlan> result = this.trainingBatchSpecialLogic
				.getTrainingProjectPlanById(id);
		return result;
	}

	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTrainingProjectPlan(
			@DefaultValue("0") @QueryParam("trainingProjectPlanId") int trainingProjectPlanId)
			throws JsonParseException, JsonMappingException, IOException {
		TrainingProjectPlan trainingProjectPlanForDelete = trainingBatchSpecialLogic
				.getTrainingProjectPlanByIdForDelete(trainingProjectPlanId);
		this.trainingBatchSpecialLogic.delete(trainingProjectPlanForDelete);
		return Response.ok().build();
	}
	@GET
	@Path("getSpecialByProjectAndBatchAndLevel")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingSpecialDetailVO> getSpecialByProjectAndBatchAndLevel(
			@DefaultValue("0") @QueryParam("trainingProjectId") int trainingProjectId,
			@DefaultValue("0") @QueryParam("trainingBatchId") int trainingBatchId,
			@DefaultValue("") @QueryParam("educationLevelId") String educationLevelId) {
		List<TrainingSpecialDetailVO> list = new ArrayList<TrainingSpecialDetailVO>();
		list = this.trainingBatchSpecialLogic.getSpecialByProjectAndBatchAndLevel(
				trainingProjectId,trainingBatchId, educationLevelId);

		return list;
	}
}
