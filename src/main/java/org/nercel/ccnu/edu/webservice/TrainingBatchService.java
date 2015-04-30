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
import org.nercel.ccnu.edu.entity.TrainingBatchVO;
import org.nercel.ccnu.edu.entity.TrainingBatch_teachingUnitInfoVO;
import org.nercel.ccnu.edu.entity.persist.StudentInfo;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.nercel.ccnu.edu.logic.TrainingBatchLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingBatchLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

import com.google.gson.Gson;

/**
 * @author Jo
 * @version 创建时间：2014年5月23日 下午6:30:48 类说明
 */
@Path("/trainingBatchService")
public class TrainingBatchService {

	TrainingBatchLogic logic = new TrainingBatchLogicImpl();

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
	public Response create(JSONObject jsonEntity) {
		TrainingBatch entity = new Gson().fromJson(jsonEntity.toString(),
				TrainingBatch.class);
		logic.create(entity);
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
		TrainingBatch entity = (TrainingBatch) mapper.readValue(
				jsonEntity.toString(), TrainingBatch.class);
		this.logic.update(entity);
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
		logic.delete(ids);
		return Response.ok().build();

	}
	@GET
	@Path("deleteById")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteById(@QueryParam("id") @DefaultValue("") String id) {
		logic.deleteById(id);
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
	public TrainingBatch findOne(@QueryParam("id") String id) {
		TrainingBatch entity = logic.findOne(Integer.parseInt(id));
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
	public PageModel<TrainingBatch> findAll(
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("10") int pageSize) {
		List<TrainingBatch> entityList = logic.findAll();
		int count = logic.countAll();
		PageModel<TrainingBatch> pageModel = new PageModel<TrainingBatch>();
		pageModel.setList(entityList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(count);
		return pageModel;

	}

	@GET
	@Path("/entityList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch> entityList() {
		List<TrainingBatch> entityList = logic.findAll();
		return entityList;

	}

	@GET
	@Path("/getTrainingBatchVOList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<TrainingBatchVO> getTrainingBatchVOList(
			@QueryParam("pageNo") int pageNo,
			@QueryParam("pageSize") int pageSize) {
		List<TrainingBatchVO> entityList = logic.getTrainingBatchVOList();
		int count = logic.countAll();
		PageModel<TrainingBatchVO> pageModel = new PageModel<TrainingBatchVO>();
		pageModel.setList(entityList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(count);
		return pageModel;
	};
	@GET
	@Path("/getTrainingBatchVOPage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<TrainingBatchVO> getTrainingBatchVOPage(@QueryParam("trainingProjectId")@DefaultValue("0") int trainingProjectId,
			@QueryParam("pageNo")@DefaultValue("1")  int pageNo,
			@QueryParam("pageSize")@DefaultValue("20")  int pageSize) {
		return logic.getTrainingBatchVOPage(pageSize, pageNo, trainingProjectId);
	};

	/**
	 * 记录总数
	 * 
	 * @return
	 * @throws JSONException
	 */
	/*@GET
	@Path("/countAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject countAll() throws JSONException {
		int count = logic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;

	}*/
	@GET
	@Path("/countAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject countAll(@QueryParam("trainingProjectId")int trainingProjectId) throws JSONException {
		int count = logic.countAll(trainingProjectId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;

	}

	@GET
	@Path("findByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingBatch findByProperty(@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value) {
		TrainingBatch entity = this.logic.findByProperty(propertyName, value);
		return entity;
	}

	/**
	 * 根据培训项目id查询培训批次
	 * 
	 * @param id
	 *            培训项目id
	 * @return 培训批次List
	 */
	@GET
	@Path("findByProjectId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch> findByProjectId(
			@QueryParam("id") @DefaultValue("0") String id) {
		List<TrainingBatch> trainingBatchList = this.logic.findByProjectId(id);
		return trainingBatchList;
	}

	@GET
	@Path("findProjectByBatchId")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingProjectInfo findProjectByBatchId(
			@QueryParam("id")String id) {
		TrainingProjectInfo trainingProjectInfo = this.logic.findProjectByBatchId(id);
		return trainingProjectInfo;
	}
	@GET
	@Path("findTrainingBatch_teachingUnitInfoVOBycoagencyId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch_teachingUnitInfoVO> findTrainingBatch_teachingUnitInfoVOBycoagencyId(@QueryParam("id")String id){
		List<TrainingBatch_teachingUnitInfoVO> entityList=logic.findTrainingBatch_teachingUnitInfoVOBycoagencyId(id);
		return entityList;
		
	}
	@GET
	@Path("findByIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch> findByIds(@QueryParam("ids")String ids){
		List<TrainingBatch> entityList=logic.findByIds(ids);
		return entityList;
		
	}
	@GET
	@Path("findByName")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingBatch findByName(@QueryParam("name")String name){
		TrainingBatch entity=logic.findByName(name);
		return entity;
	}
}
