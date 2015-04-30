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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.CourseClass;
import org.nercel.ccnu.edu.logic.CourseClassLogic;
import org.nercel.ccnu.edu.logic.impl.CourseClassLogicImpl;



@Path("/courseClassService")
public class CourseClassService {
	
	private CourseClassLogic courseClassLogic = new CourseClassLogicImpl();
	//增加课程课类
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCourseClass(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CourseClass entity = (CourseClass)mapper.readValue(jsonEntity.toString(), CourseClass.class);
		this.courseClassLogic.addCourseClass(entity);
		return Response.ok().build();
	}
	
	
	/*@DELETE
	@Path("delete/{courseTypeID}")
	public Response deletecourseType(@PathParam("courseTypeID") String courseTypeID){
		CourseType courseType = this.courseTypeLogic.getCourseTypeById(courseTypeID);
		this.courseTypeLogic.deleteCourseTypeLogic(courseType);
		return Response.ok().build();*/
	
	//批量删除课程课类
	@POST
	@Path("deletes")
	public JSONObject batchDeleteCourseClass(JSONObject courseClassIds) throws JSONException{
		boolean successOrNot = this.courseClassLogic.batchDeleteCourseClass(courseClassIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	//更新课程课类信息
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCourseClass(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CourseClass entity = (CourseClass)mapper.readValue(jsonEntity.toString(), CourseClass.class);
		this.courseClassLogic.updateCourseClass(entity);
		return Response.ok().build();
	}
	//通过Id获取课程课类信息
	@GET
	@Path("courseClasss/{courseClassID}")
	@Produces(MediaType.APPLICATION_JSON )
	public CourseClass getCourseClassById(@PathParam("courseClassID") String courseClassID){
		CourseClass instance = courseClassLogic.getCourseClassById(courseClassID);
		return instance;
	}
	//获取所有课程课类信息
	@GET
	@Path("allCourseClasss")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseClass> getAllCourseClasss(){
		return this.courseClassLogic.getAllCourseClasss();
	}
	//获取最大的Id
	@GET
	@Path("getMaxCourseClassId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxCourseClassId() throws JSONException{
		
		int maxId = this.courseClassLogic.getMaxCourseClassId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxCourseClassId", maxId);
   		
   		return object;
		
			
	}
	/**
	 * 根据courseClass的属性来查找课程课类信息
	 * 
	 * @param property
	 *            课程类别属性
	 * @param proValue
	 *            属性的值
	 * @return 课程课类实体
	 */
	@GET
	@Path("getCourseClassByProperty/{property}-{proValue}-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CourseClass getCourseClassByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue,
			@PathParam("id") int id) {
		CourseClass courseClass = this.courseClassLogic
				.getCourseClassByProperty(property, proValue,id);
		return courseClass;
	}
	
	/**
	 * 根据courseTClass的属性来查找课程课类信息（没有id）
	 * @author yangyingjie
	 * @param property
	 * @param proValue
	 * @return
	 */
	@GET
	@Path("getCourseClassByOneProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public CourseClass getCourseClassByOneProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		CourseClass courseClass = this.courseClassLogic.getCourseClassByOneProperty(property, proValue);
		return courseClass;
	}
}
