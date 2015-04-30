package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.CourseType;
import org.nercel.ccnu.edu.entity.persist.ProvinceInfo;
import org.nercel.ccnu.edu.logic.CourseTypeLogic;
import org.nercel.ccnu.edu.logic.impl.CourseTypeLogicImpl;


@Path("/courseTypeService")
public class CourseTypeService {
	
	private CourseTypeLogic courseTypeLogic = new CourseTypeLogicImpl();
	//增加课程类别
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCourseType(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CourseType entity = (CourseType)mapper.readValue(jsonEntity.toString(), CourseType.class);
		this.courseTypeLogic.addCourseType(entity);
		return Response.ok().build();
	}
	
	
	/*@DELETE
	@Path("delete/{courseTypeID}")
	public Response deletecourseType(@PathParam("courseTypeID") String courseTypeID){
		CourseType courseType = this.courseTypeLogic.getCourseTypeById(courseTypeID);
		this.courseTypeLogic.deleteCourseTypeLogic(courseType);
		return Response.ok().build();*/
	
	//批量删除课程类别
	@POST
	@Path("deletes")
	public JSONObject batchDeleteCourseType(JSONObject courseTypeIds) throws JSONException{
		boolean successOrNot = this.courseTypeLogic.batchDeleteCourseType(courseTypeIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	//更新课程类别
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCourseType(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CourseType entity = (CourseType)mapper.readValue(jsonEntity.toString(), CourseType.class);
		this.courseTypeLogic.updateCourseType(entity);
		return Response.ok().build();
	}
	//通过Id获取课程类别信息
	@GET
	@Path("courseTypes/{courseTypeID}")
	@Produces(MediaType.APPLICATION_JSON )
	public CourseType getCourseTypeById(@PathParam("courseTypeID") String courseTypeID){
		CourseType instance = courseTypeLogic.getCourseTypeById(courseTypeID);
		return instance;
	}
	//获取所有课程类别信息
	@GET
	@Path("allCourseTypes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseType> getAllCourseTypes(){
		return this.courseTypeLogic.getAllCourseTypes();
	}
	//获取最大的Id
	@GET
	@Path("getMaxCourseTypeId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxCourseTypeId() throws JSONException{
		
		int maxId = this.courseTypeLogic.getMaxCourseTypeId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxCourseTypeId", maxId);
   		
   		return object;
		
			
	}
	/**
	 * 根据courseType的属性来查找课程类别信息
	 * 
	 * @param property
	 *            课程类别属性
	 * @param proValue
	 *            属性的值
	 * @return 课程类别实体
	 */
	@GET
	@Path("getCourseTypeByProperty/{property}-{proValue}-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CourseType getCourseTypeByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue,
			@PathParam("id") int id) {
		CourseType courseType = this.courseTypeLogic
				.getCourseTypeByProperty(property, proValue,id);
		return courseType;
	}
	
	/**
	 * 根据courseType的属性来查找课程类别信息 （参数有两个，没有id）
	 * @author yangyingjie
	 * @param property
	 * @param proValue
	 * @return
	 */
	@GET
	@Path("getCourseTypeByOneProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public CourseType getCourseTypeByOneProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		CourseType courseType = this.courseTypeLogic.getCourseTypeByOneProperty(property, proValue);
		return courseType;
	}
}
