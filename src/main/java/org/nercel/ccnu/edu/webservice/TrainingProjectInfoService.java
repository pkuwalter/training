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
import org.nercel.ccnu.edu.entity.TrainingProjectInfoVO;
import org.nercel.ccnu.edu.entity.persist.TrainingProjectInfo;
import org.nercel.ccnu.edu.logic.TrainingProjectInfoLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingProjectInfoLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

@Path("/trainingProjectInfoService")
public class TrainingProjectInfoService {
	TrainingProjectInfoLogic logic = new TrainingProjectInfoLogicImpl();

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
		TrainingProjectInfo entity = (TrainingProjectInfo) mapper.readValue(
				jsonEntity.toString(), TrainingProjectInfo.class);
		this.logic.create(entity);
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
		TrainingProjectInfo entity = (TrainingProjectInfo) mapper.readValue(
				jsonEntity.toString(), TrainingProjectInfo.class);
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

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/findOne")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingProjectInfo findOne(@QueryParam("id") String id) {
		TrainingProjectInfo entity = logic.findOne(Integer.parseInt(id));
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
	public PageModel<TrainingProjectInfo> findAll(
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("10") int pageSize) {
		List<TrainingProjectInfo> entityList = logic.findAll();
		int count = logic.countAll();
		PageModel<TrainingProjectInfo> pageModel = new PageModel<TrainingProjectInfo>();
		pageModel.setList(entityList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(count);
		return pageModel;

	}

	@GET
	@Path("/findAllTrainingProjectInfoVO")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<TrainingProjectInfoVO> findAllTrainingProjectInfoVO(
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("10") int pageSize) {
		List<TrainingProjectInfoVO> entityList = logic
				.getTrainingProjectInfoVOList();
		int count = logic.countAll();
		PageModel<TrainingProjectInfoVO> pageModel = new PageModel<TrainingProjectInfoVO>();
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
		int count = logic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;

	}

	@GET
	@Path("findByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingProjectInfo findByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		TrainingProjectInfo entity = this.logic.findByProperty(proValue,
				proValue);
		return entity;
	}

	@GET
	@Path("entityList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingProjectInfo> entityList() {
		List<TrainingProjectInfo> entityList = this.logic.entityLsit();
		return entityList;
	}

	@GET
	@Path("findByName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingProjectInfo> findByName(
			@QueryParam("name") @DefaultValue("") String name) {
		List<TrainingProjectInfo> entityList = this.logic.findByName(name);
		return entityList;
	}
}
