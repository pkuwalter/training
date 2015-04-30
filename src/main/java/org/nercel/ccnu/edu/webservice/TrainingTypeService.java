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
import org.nercel.ccnu.edu.entity.persist.TrainingType;
import org.nercel.ccnu.edu.logic.TrainingTypeLogic;
import org.nercel.ccnu.edu.logic.impl.TrainingTypeLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

@Path("/trainingTypeService")
public class TrainingTypeService {
	private TrainingTypeLogic trainingTypeLogic=new TrainingTypeLogicImpl() ;
	
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
		TrainingType entity = (TrainingType)mapper.readValue(jsonEntity.toString(), TrainingType.class);
		this.trainingTypeLogic.create(entity);
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
		TrainingType entity = (TrainingType)mapper.readValue(jsonEntity.toString(), TrainingType.class);
		this.trainingTypeLogic.update(entity);
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
		trainingTypeLogic.delete(ids);
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
	public TrainingType findOne(@QueryParam("id")String id){
		TrainingType entity=trainingTypeLogic.findOne(Integer.parseInt(id));
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
	public PageModel<TrainingType> findAll(@QueryParam("pageNo")@DefaultValue("1")int pageNo,
										   @QueryParam("pageSize")@DefaultValue("10")int pageSize){
		List<TrainingType> entityList=trainingTypeLogic.findAll();
		int count=trainingTypeLogic.countAll();
		PageModel<TrainingType> pageModel=new PageModel<TrainingType>();
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
		int count=trainingTypeLogic.countAll();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		return jsonObject;
		
	}

	@GET
	@Path("getTrainingTypeByProperty/{property}-{proValue}-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingType getTrainingTypeByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue,
			@PathParam("id") int id) {
		TrainingType entity = this.trainingTypeLogic.getTrainingTypeByProperty(property, proValue,id);
		return entity;
	}
	@GET
	@Path("/typeList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingType> typeList(){
		List<TrainingType> typeList=trainingTypeLogic.findAll();
		return typeList;
		
	}
	
}
