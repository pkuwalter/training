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
import org.wy.ccnu.edu.entity.persist.Coagency;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.wy.ccnu.edu.entity.persist.TrainingBatch_teachingUnitInfo;
import org.wy.ccnu.edu.logic.TrainingBatch_teachingUnitInfoLogic;
import org.wy.ccnu.edu.logic.impl.TrainingBatch_teachingUnitInfoLogicImpl;
import org.wy.ccnu.edu.util.PageModel;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午6:41:55 
 * 类说明 
 */
@Path("/trainingBatch_teachingUnitInfoService")
public class TrainingBatch_teachingUnitInfoService {

	TrainingBatch_teachingUnitInfoLogic logic=new TrainingBatch_teachingUnitInfoLogicImpl();
	
	/**
	 * 创建
	 * @param entity
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		TrainingBatch_teachingUnitInfo entity = (TrainingBatch_teachingUnitInfo)mapper.readValue(jsonEntity.toString(), TrainingBatch_teachingUnitInfo.class);
		this.logic.create(entity);
		return Response.ok().build();
		
	}
	/**
	 * 修改
	 * @param entity
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		TrainingBatch_teachingUnitInfo entity = (TrainingBatch_teachingUnitInfo)mapper.readValue(jsonEntity.toString(), TrainingBatch_teachingUnitInfo.class);
		this.logic.update(entity);
		return Response.ok().build();
		
	}
	/**
	 * 删除
	 * @param ids
	 * @throws JSONException 
	 */
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("ids")String ids) throws JSONException{
		logic.delete(ids);
		return Response.ok().build();
		
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@GET
	@Path("/findOne")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingBatch_teachingUnitInfo findOne(@QueryParam("id")String id){
		TrainingBatch_teachingUnitInfo entity=logic.findOne(id);
		return entity;
		
	}
	/**
	 * 所有记录
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<TrainingBatch_teachingUnitInfo> findAll(@QueryParam("pageNo")@DefaultValue("1")int pageNo,
										   @QueryParam("pageSize")@DefaultValue("10")int pageSize){
		List<TrainingBatch_teachingUnitInfo> entityList=logic.findAll();
		int count=logic.countAll();
		PageModel<TrainingBatch_teachingUnitInfo> pageModel=new PageModel<TrainingBatch_teachingUnitInfo>();
		pageModel.setList(entityList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(count);
		return pageModel;
		
	}
	/**
	 * 记录总数
	 * @return
	 * @throws JSONException 
	 */
	@GET
	@Path("/countAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject countAll() throws JSONException{
		int count=logic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;
		
	}

	@GET
	@Path("findByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingBatch_teachingUnitInfo findByProperty(@PathParam("property") String property,@PathParam("proValue") String proValue) {
		TrainingBatch_teachingUnitInfo entity = this.logic.findByProperty(proValue, proValue);
		return entity;
	}
	@Path("/findAllByBatchId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch_teachingUnitInfo> findAllByBatchId(@QueryParam("id")String id){
		List<TrainingBatch_teachingUnitInfo> entityList=logic.findAllByBatchId(Integer.parseInt(id));
		return entityList;
		
	}
	@GET
	@Path("/getUseTeachingUnitInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfo> getUseTeachingUnitInfo(@QueryParam("id")String id){
		List<TeachingUnitInfo> entityList=logic.getUseTeachingUnitInfo(id);
		return entityList;
	}
	@GET
	@Path("/findByCoId")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<TrainingBatch_teachingUnitInfo> findByCoId(@QueryParam("id")String id){
		List<TrainingBatch_teachingUnitInfo> entityList=logic.findByCoId(id);
		return entityList;
		
	}
	@GET
	@Path("/findByTeachingUnitId")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingBatch_teachingUnitInfo findByTeachingUnitId(@QueryParam("id")String id){
		TrainingBatch_teachingUnitInfo entity=logic.findByTeachingUnitId(id);
		return entity;
	}
}
 