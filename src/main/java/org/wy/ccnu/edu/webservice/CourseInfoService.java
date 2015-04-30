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
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import javax.ws.rs.core.MediaType;

import org.wy.ccnu.edu.entity.CourseInfoVO;
import org.wy.ccnu.edu.entity.persist.CourseInfo;
import org.wy.ccnu.edu.logic.CourseInfoLogic;
import org.wy.ccnu.edu.logic.impl.CourseInfoLogicImpl;

@Path("/courseInfoService")
public class CourseInfoService {
	
	private CourseInfoLogic courseInfoLogic = new CourseInfoLogicImpl();
	
	/**
	 * 增加课程
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("addCourseInfo")
	@Consumes("application/json")
	public Response addCourseInfo(JSONObject jsonEntity) throws JSONException,JsonParseException,JsonMappingException,IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		CourseInfo entity = (CourseInfo)mapper.readValue(jsonEntity.toString(), CourseInfo.class);
		this.courseInfoLogic.save(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除课程
	 * @param courseId
	 * @return
	 */
	@POST
	@Path("deleteCourseInfo/{courseId}")
	public Response deleteCourseInfo(@PathParam("courseId") int courseId){
		
		CourseInfo courseInfo = this.courseInfoLogic.getCourseInfoById(courseId);
		
		this.courseInfoLogic.delete(courseInfo);
		
		return Response.ok().build();
		
	}
	
	/**
	 * 修改课程
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("updateCourseInfo")
	@Consumes("application/json")
	public Response updateCourseInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		CourseInfo entity = (CourseInfo)mapper.readValue(jsonEntity.toString(), CourseInfo.class);
		this.courseInfoLogic.update(entity);
		return Response.ok().build();
	   
	}
	
	/**
	 * 获取课程信息的最大的Id
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getMaxCourseInfoId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxCourseInfoId() throws JSONException{
		
		int maxId = this.courseInfoLogic.getMaxCourseInfoId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxId", maxId);
   		
   		return object;
		
			
	}
	
	
	/**
	 * 获取所有课程的列表
	 * @return
	 */
	@GET
	@Path("getAllCourseInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseInfo> getAllCourseInfo(){
		
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		
		list = this.courseInfoLogic.getAllCourseInfo();
		
		return list;
		
	}
	
	/**
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return
	 */
	@GET
	@Path("getCourseInfoById/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CourseInfo getCourseInfoById(@PathParam("courseId") int courseId){
		CourseInfo instance = this.courseInfoLogic.getCourseInfoById(courseId);
		return instance;
	}
	
	/**
	 * 据内部代码获取内部课程名称
	 * @param courseCode
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getCourseNameByCourseCode")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getCourseNameByCourseCode(@DefaultValue("") @QueryParam("courseCode") String courseCode) throws JSONException{

        String courseName = this.courseInfoLogic.getCourseNameByCourseCode(courseCode); 
         
		JSONObject objectMapper = new JSONObject();
		
		objectMapper.put("courseName",courseName);

		return objectMapper;
	}
	
	/**
	 * 根据外部代码获取外部课程名称
	 * @param courseCodeOut
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getCourseNameOutByCourseCodeOut")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getCourseNameOutByCourseCodeOut(@DefaultValue("") @QueryParam("courseCodeOut") String courseCodeOut) throws JSONException{

        String courseNameOut = this.courseInfoLogic.getCourseNameOutByCourseCodeOut(courseCodeOut); 
         
		JSONObject objectMapper = new JSONObject();
		
		objectMapper.put("courseNameOut",courseNameOut);

		return objectMapper;
	}
	
	/**
	 * 条件查询：获取课程管理的详细信息-分页查询
	 * @param courseCode
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path("getAllCourseInfoVOInPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseInfoVO> getAllCourseInfoVOInPage(
			@DefaultValue("") @QueryParam("courseCode") String courseCode,
			@DefaultValue("") @QueryParam("courseName") String courseName,
			@DefaultValue("") @QueryParam("examTypeCode") String examTypeCode,
			@DefaultValue("") @QueryParam("courseTypeCode") String courseTypeCode,
			@DefaultValue("") @QueryParam("courseClassCode") String courseClassCode,
			@DefaultValue("") @QueryParam("stage") String stage,
			@DefaultValue("") @QueryParam("scale") String scale,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("20") @QueryParam("pageSize") int pageSize){
		List<CourseInfoVO> result = this.courseInfoLogic.getAllCourseInfoVOInPage(courseCode, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale, pageNo, pageSize);
		return result;
	}
	
	

	/**
	 * 条件查询：获取课程管理的详细信息的总记录数
	 * @param courseCode
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @return
	 */
	@GET
	@Path("getTotalCourseInfoVO")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalCourseInfoVO(
			@DefaultValue("") @QueryParam("courseCode") String courseCode,
			@DefaultValue("") @QueryParam("courseName") String courseName,
			@DefaultValue("") @QueryParam("examTypeCode") String examTypeCode,
			@DefaultValue("") @QueryParam("courseTypeCode") String courseTypeCode,
			@DefaultValue("") @QueryParam("courseClassCode") String courseClassCode,
			@DefaultValue("") @QueryParam("stage") String stage,
			@DefaultValue("") @QueryParam("scale") String scale)throws JSONException{
		
		int total = this.courseInfoLogic.getTotalCourseInfoVO(courseCode, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale);
		JSONObject object = new JSONObject();
   		object.put("total", total);
   		return object;
	}
	
	
	
	/**
	 * 根据CourseInfo的属性来查找课程信息
	 * @param property课程属性
	 * @param proValue属性的值
	 * @return
	 */
	@GET
	@Path("getCourseInfoByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public CourseInfo getCourseInfoByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		CourseInfo courseInfo = this.courseInfoLogic.getCourseInfoByProperty(property, proValue);
		
		return courseInfo;
	}
	
	/**
	 * 批量删除课程信息
	 * @param CourseIds
	 * @return
	 * @throws JSONException
	 */
	@POST
	@Path("batchDeleteCourseInfo")
	public JSONObject batchDeleteCourseInfo(JSONObject CourseIds) throws JSONException{
		boolean successOrNot = this.courseInfoLogic.batchDeleteCourseInfo(CourseIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	

}
