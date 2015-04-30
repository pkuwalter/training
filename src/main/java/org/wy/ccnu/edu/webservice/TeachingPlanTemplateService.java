package org.wy.ccnu.edu.webservice;

import java.io.IOException;
import java.util.ArrayList;
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
import org.wy.ccnu.edu.entity.TeachingPlanTemplateVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.TeachingPlanTemplate;


import org.wy.ccnu.edu.logic.TeachingPlanTemplateLogic;
import org.wy.ccnu.edu.logic.impl.TeachingPlanTemplateLogicImpl;

@Path("/teachingPlanTemplate")
public class TeachingPlanTemplateService {

	
	private TeachingPlanTemplateLogic teachingPlanTemplateLogic = new TeachingPlanTemplateLogicImpl();
	

	/**
	 * 添加 
	 * @param entity
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("addTeachingPlanTemplate")
	@Consumes("application/json")
	public Response addTeachingPlanTemplate(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		TeachingPlanTemplate entity = (TeachingPlanTemplate)mapper.readValue(jsonEntity.toString(), TeachingPlanTemplate.class);
		
		this.teachingPlanTemplateLogic.save(entity);
		return Response.ok().build();
		
	}
	/*
	@POST
	@Path("deletes")
	public Response deletes(@PathParam("id") String id){
		
		TeachingPlanTemplate teachingPlanTemplate = this.teachingPlanTemplateLogic.findTemplateById(id);
		
		this.teachingPlanTemplateLogic.delete(teachingPlanTemplate);
		
		return Response.ok().build();
		
	}*/
	//批量删除
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject batchDeleteManageCenter(JSONObject ids) throws JSONException{
		boolean sucessOrNot = this.teachingPlanTemplateLogic.batchDelete(ids) ;
		JSONObject object = new JSONObject();
		object.put("sucessOrNot", sucessOrNot);
		return object;
	}
	
	@POST
	@Path("updateTeachingPlanTemplate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNationInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println(jsonEntity.toString());
		TeachingPlanTemplate entity = (TeachingPlanTemplate)mapper.readValue(jsonEntity.toString(), TeachingPlanTemplate.class);
		this.teachingPlanTemplateLogic.update(entity); 
		return Response.ok().build();
	   
	}
	
	@GET
	@Path("findTemplateById/{id}")
	@Produces(MediaType.APPLICATION_JSON )
	public TeachingPlanTemplate findTemplateById(@PathParam("id") String id){
		//int nationID=Integer.parseInt(nationId);
		//System.out.println("nationId           " + nationId); 
		TeachingPlanTemplate teachingPlanTemplate = this.teachingPlanTemplateLogic.findTemplateById(id);
		
		return teachingPlanTemplate;
			
	}
	
	
	@GET
	@Path("getTemplate")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingPlanTemplateVO> getTemplate(
			@DefaultValue("0") @QueryParam("belongProject") int belongProject,
			@DefaultValue("") @QueryParam("tpTemplateName") String tpTemplateName,
			@DefaultValue("") @QueryParam("tpTemplateCode") String tpTemplateCode,
			@DefaultValue("0") @QueryParam("deductionModel") int deductionModel,
			@DefaultValue("0") @QueryParam("deductionRule") int deductionRule,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize){
		
		List<TeachingPlanTemplateVO> TemplateList = new ArrayList<TeachingPlanTemplateVO>();
		
		TemplateList = this.teachingPlanTemplateLogic.getTemplate(belongProject, tpTemplateName, tpTemplateCode, deductionModel, deductionRule, pageNo, pageSize);
		
		return TemplateList;
	}
	@GET
	@Path("getMaxTpTemplateCode")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxTpTemplateCode() throws JSONException{
		
		int maxCode = this.teachingPlanTemplateLogic.getMaxTpTemplateCode();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxCode", maxCode);
   		
   		return object;
		
			
	}
	
    @GET
   	@Path("getTotalTemplatesByConditions")
   	@Produces(MediaType.APPLICATION_JSON)
   	public JSONObject getTotalTemplates(
   			@DefaultValue("0") @QueryParam("belongProject") int belongProject,
			@DefaultValue("") @QueryParam("tpTemplateName") String tpTemplateName,
			@DefaultValue("") @QueryParam("tpTemplateCode") String tpTemplateCode,
			@DefaultValue("0") @QueryParam("deductionModel") int deductionModel,
			@DefaultValue("0") @QueryParam("deductionRule") int deductionRule) throws JSONException{
   		int total = this.teachingPlanTemplateLogic.getTotalTemplates(belongProject, tpTemplateName, tpTemplateCode, deductionModel, deductionRule);
   		JSONObject object = new JSONObject();
   		object.put("total", total);
   		return object;
   	}
	
	 /**
     * 返回总数
     * @return
     */
    @GET
   	@Path("getTotalTemplates")
   	@Produces(MediaType.APPLICATION_JSON)
   	public JSONObject getTotalTemplates() throws JSONException{
   		int total = this.teachingPlanTemplateLogic.getTotalTemplates();
   		JSONObject object = new JSONObject();
   		object.put("total", total);
   		//System.out.println("total: "+total);
   		return object;
   	}
	
	   
    @GET
	@Path("getAllCodeAndNameByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllCodeAndNameByUtilObject(){
		List<UtilObject> result = this.teachingPlanTemplateLogic.getAllCodeAndNameByUtilObject();
		return result;
	}
    @GET
   	@Path("getCodeByNameByUtilObject/{tpTemplateName_code}")
   	@Produces(MediaType.APPLICATION_JSON)
   	public UtilObject getCodeByNameByUtilObject(@PathParam("tpTemplateName_code") String tpTemplateName ){
   		UtilObject result = (UtilObject) this.teachingPlanTemplateLogic.getCodeByNameByUtilObject(tpTemplateName) ;
   		return result;
   	}
    @GET
   	@Path("checkName")
   	@Produces(MediaType.APPLICATION_JSON)
   	public JSONObject checkName(@QueryParam("tpTemplateName") String tpTemplateName ,@QueryParam("formalName") String formalName)throws JSONException{
    	boolean result =  this.teachingPlanTemplateLogic.checkName(tpTemplateName,formalName);
    	int ss;
   		if(result){ss=1;}else{ss=0;}//1表示存在相同的
   		//System.out.println(ss);
   		JSONObject object = new JSONObject();
   		object.put("ss", ss);
   		return object;
   	}
    
    @GET
   	@Path("checkCode")
   	@Produces(MediaType.APPLICATION_JSON)
   	public JSONObject checkCode(@QueryParam("tpTemplateCode") String tpTemplateCode,@QueryParam("formalCode") String formalCode )throws JSONException{
    	boolean result =  this.teachingPlanTemplateLogic.checkCode(tpTemplateCode,formalCode);
    	//System.out.println("---------h s------"+result);
    	int ss;
   		if(result){ss=1;}else{ss=0;}//1表示存在相同的
   		JSONObject object = new JSONObject();
   		object.put("ss", ss);
   		return object;
   	}
    
    @GET
	@Path("getTeachingPlanTemplateListByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingPlanTemplate> getTeachingPlanTemplateListByProperty(
			@DefaultValue("") @QueryParam("property")String property, 
			@DefaultValue("") @QueryParam("proValue") String proValue){
		return this.teachingPlanTemplateLogic.getTeachingPlanTemplateListByProperty(property, proValue);
		
	}
}
	