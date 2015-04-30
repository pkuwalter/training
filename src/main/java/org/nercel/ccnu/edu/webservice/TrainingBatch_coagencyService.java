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
import org.nercel.ccnu.edu.entity.TrainingBatch_coagencyVO;
import org.nercel.ccnu.edu.entity.persist.Coagency;
import org.nercel.ccnu.edu.entity.persist.TrainingBatch_coagency;
import org.nercel.ccnu.edu.logic.TrainingBatch_coagencyLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingBatch_coagencyLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

/** 
 * @author Jo 
 * @version 创建时间：2014年5月23日 下午6:39:54 
 * 类说明 
 */
@Path("/trainingBatch_coagencyService")
public class TrainingBatch_coagencyService {

	TrainingBatch_coagencyLogic logic=new TrainingBatch_coagencyLogicImpl();
	
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
		TrainingBatch_coagency entity = (TrainingBatch_coagency)mapper.readValue(jsonEntity.toString(), TrainingBatch_coagency.class);
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
		TrainingBatch_coagency entity = (TrainingBatch_coagency)mapper.readValue(jsonEntity.toString(), TrainingBatch_coagency.class);
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
	public TrainingBatch_coagency findOne(@QueryParam("id")String id){
		TrainingBatch_coagency entity=logic.findOne(id);
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
	public PageModel<TrainingBatch_coagency> findAll(@QueryParam("pageNo")@DefaultValue("1")int pageNo,
										   @QueryParam("pageSize")@DefaultValue("10")int pageSize){
		List<TrainingBatch_coagency> entityList=logic.findAll();
		int count=logic.countAll();
		PageModel<TrainingBatch_coagency> pageModel=new PageModel<TrainingBatch_coagency>();
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
	public TrainingBatch_coagency findByProperty(@PathParam("property") String property,@PathParam("proValue") String proValue) {
		TrainingBatch_coagency entity = this.logic.findByProperty(proValue, proValue);
		return entity;
	}
	@GET
	@Path("/findAllByBatchId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch_coagency> findAllByBatchId(@QueryParam("id")String id){
		List<TrainingBatch_coagency> entityList=logic.findAllByBatchId(Integer.parseInt(id));
		return entityList;
		
	}
	@GET
	@Path("/getTrainingBatch_coagencyVOListById")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingBatch_coagencyVO> getTrainingBatch_coagencyVOListById(@QueryParam("id")String id){
		List<TrainingBatch_coagencyVO> entityList=logic.getTrainingBatch_coagencyVOListById(Integer.parseInt(id));
		return entityList;
		
	}
	@GET
	@Path("/getUseCoagency")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coagency> getUseCoagency(@QueryParam("id")String id){
		List<Coagency> entityList=logic.getUseCoagency(id);
		return entityList;
		
	}
	@GET
	@Path("/getUnuseCoagency")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coagency> getUnuseCoagency(@QueryParam("id")String id){
		List<Coagency> entityList=logic.getUnuseCoagency(id);
		return entityList;
		
	}
}
 