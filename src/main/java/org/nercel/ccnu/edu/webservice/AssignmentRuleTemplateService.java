package org.nercel.ccnu.edu.webservice; 

import java.io.IOException;

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
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.AssignmentRuleTemplate;
import org.nercel.ccnu.edu.logic.AssignmentRuleTemplateLogic;
import org.nercel.ccnu.edu.logic.impl.AssignmentRuleTemplateLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

import com.google.gson.Gson;

/** 
 * @author Jo 
 * @version 创建时间：2014年6月19日 下午4:09:13 
 * 类说明 
 */
@Path("assignmentRuleTemplateService")
public class AssignmentRuleTemplateService {
	AssignmentRuleTemplateLogic logic=new AssignmentRuleTemplateLogicImpl();
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
		AssignmentRuleTemplate entity = new Gson().fromJson(jsonEntity.toString(),AssignmentRuleTemplate.class);
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
		AssignmentRuleTemplate entity = new Gson().fromJson(jsonEntity.toString(),AssignmentRuleTemplate.class);
		logic.update(entity);
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
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	public AssignmentRuleTemplate findById(@QueryParam("id") String id) {
		AssignmentRuleTemplate entity = logic.findById(id);
		return entity;

	}
	@GET
	@Path("/findByPage")
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<AssignmentRuleTemplate> findByPage(
			@QueryParam("pageSize")@DefaultValue("20")int pageSize,
			@QueryParam("pageNo")@DefaultValue("1")int pageNo){
		PageModel<AssignmentRuleTemplate> pageModel=logic.findByPage(pageNo, pageSize);
		return pageModel;
		
	}
}
 