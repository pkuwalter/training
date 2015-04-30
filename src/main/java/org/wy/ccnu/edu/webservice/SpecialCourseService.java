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
import org.wy.ccnu.edu.entity.SpecialCourseVO;
import org.wy.ccnu.edu.entity.persist.CourseInfo;
import org.wy.ccnu.edu.entity.persist.SpecialCourse;
import org.wy.ccnu.edu.logic.SpecialCourseLogic;
import org.wy.ccnu.edu.logic.impl.SpecialCourseLogicImpl;

@Path("/specialCourseService")
public class SpecialCourseService {
	
	private SpecialCourseLogic specialCourseLogic = new SpecialCourseLogicImpl();
	
	/**
	 * 增加学科课程
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("addSpecialCourse")
	@Consumes("application/json")
	public Response addSpecialCourse(JSONObject jsonEntity) throws JSONException,JsonParseException,JsonMappingException,IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		SpecialCourse entity = (SpecialCourse)mapper.readValue(jsonEntity.toString(), SpecialCourse.class);
		this.specialCourseLogic.save(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除学科课程
	 * @param specialCourseId
	 * @return
	 */
	@POST
	@Path("deleteSpecialCourse/{specialCourseId}")
	public Response deleteSpecialCourse(@PathParam("specialCourseId") int specialCourseId){
		
		SpecialCourse specialCourse = this.specialCourseLogic.getSpecialCourseById(specialCourseId);
		
		this.specialCourseLogic.delete(specialCourse);
		
		return Response.ok().build();
		
	}
	
	/**
	 * 修改学科课程
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("updateSpecialCourse")
	@Consumes("application/json")
	public Response updateSpecialCourse(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		SpecialCourse entity = (SpecialCourse)mapper.readValue(jsonEntity.toString(), SpecialCourse.class);
		this.specialCourseLogic.update(entity);
		return Response.ok().build();
	   
	}
	
	/**
	 * 获取学科课程信息的最大的Id
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("getMaxSpecialCourseId")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getMaxSpecialCourseId() throws JSONException{
		
		int maxId = this.specialCourseLogic.getMaxSpecialCourseId();
		
		JSONObject object = new JSONObject();
		
   		object.put("maxId", maxId);
   		
   		return object;
		
			
	}
	
	
	/**
	 * 获取所有学科课程的列表
	 * @return
	 */
	@GET
	@Path("getAllSpecialCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpecialCourse> getAllSpecialCourse(){
		
		List<SpecialCourse> list = new ArrayList<SpecialCourse>();
		
		list = this.specialCourseLogic.getAllSpecialCourse();
		
		return list;
		
	}
	
	/**
	 * 根据学科课程ID获取课程信息
	 * @param specialCourseId
	 * @return
	 */
	@GET
	@Path("getSpecialCourseById/{specialCourseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SpecialCourse getSpecialCourseById(@PathParam("specialCourseId") int specialCourseId){
		SpecialCourse instance = this.specialCourseLogic.getSpecialCourseById(specialCourseId);
		return instance;
	}
	

	/**
	 * 条件查询：获取学科课程管理的详细信息-分页查询
	 * @param specialId
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
	@Path("getAllSpecialCourseInfoVOInPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseInfoVO> getAllSpecialCourseInfoVOInPage(
			@DefaultValue("") @QueryParam("specialId") String specialId,
			@DefaultValue("") @QueryParam("courseName") String courseName,
			@DefaultValue("") @QueryParam("examTypeCode") String examTypeCode,
			@DefaultValue("") @QueryParam("courseTypeCode") String courseTypeCode,
			@DefaultValue("") @QueryParam("courseClassCode") String courseClassCode,
			@DefaultValue("") @QueryParam("stage") String stage,
			@DefaultValue("") @QueryParam("scale") String scale,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("20") @QueryParam("pageSize") int pageSize){
		List<CourseInfoVO> result = this.specialCourseLogic.getAllSpecialCourseInfoVOInPage(specialId, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale, pageNo, pageSize);
		return result;
	}
	
	

	/**
	 * 条件查询：获取学科课程管理的详细信息的总记录数
	 * @param specialId
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @return
	 */
	@GET
	@Path("getTotalSpecialCourseInfoVO")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalSpecialCourseInfoVO(
			@DefaultValue("") @QueryParam("specialId") String specialId,
			@DefaultValue("") @QueryParam("courseName") String courseName,
			@DefaultValue("") @QueryParam("examTypeCode") String examTypeCode,
			@DefaultValue("") @QueryParam("courseTypeCode") String courseTypeCode,
			@DefaultValue("") @QueryParam("courseClassCode") String courseClassCode,
			@DefaultValue("") @QueryParam("stage") String stage,
			@DefaultValue("") @QueryParam("scale") String scale)throws JSONException{
		
		int total = this.specialCourseLogic.getTotalSpecialCourseInfoVO(specialId, courseName, examTypeCode, courseTypeCode, courseClassCode, stage, scale);
		JSONObject object = new JSONObject();
   		object.put("total", total);
   		return object;
	}
	
	
	
	/**
	 * 根据SpecialCourse的属性来查找学科课程信息
	 * @param property课程属性
	 * @param proValue属性的值
	 * @return
	 */
	@GET
	@Path("getSpecialCourseByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public SpecialCourse getSpecialCourseByProperty(
			@PathParam("property") String property,
			@PathParam("proValue") String proValue) {
		SpecialCourse specialCourse = this.specialCourseLogic.getSpecialCourseByProperty(property, proValue);
		
		return specialCourse;
	}
	
	/**
	 * 批量删除学科课程信息
	 * @param SpecialCourseIds
	 * @return
	 * @throws JSONException
	 */
	@POST
	@Path("batchDeleteSpecialCourse")
	public JSONObject batchDeleteSpecialCourse(JSONObject SpecialCourseIds) throws JSONException{
		boolean successOrNot = this.specialCourseLogic.batchDeleteSpecialCourse(SpecialCourseIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	
	/**
	 * 根据专业id获取课程id与课程名称列表
	 * @param specialId
	 * @return
	 */
	@GET
	@Path("getSpecialCourseVOListBySpecialId/{specialId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpecialCourseVO> getSpecialCourseVOListBySpecialId(@PathParam("specialId") String specialId){
		
		List<SpecialCourseVO> list = new ArrayList<SpecialCourseVO>();
		
		list = this.specialCourseLogic.getSpecialCourseVOListBySpecialId(specialId);
		
		return list;
		
	}
	
	/**
	 * 根据专业id和课程id获取学科课程
	 * @param specialId
	 * @param courseId
	 * @return
	 */
	@GET
	@Path("getSpecialCourseBySpecialIdAndCourseId")
	@Produces(MediaType.APPLICATION_JSON)
	public SpecialCourse getSpecialCourseBySpecialIdAndCourseId(
			@DefaultValue("") @QueryParam("specialId") String specialId,
			@DefaultValue("0") @QueryParam("courseId") int courseId) {
		SpecialCourse specialCourse = this.specialCourseLogic.getSpecialCourseBySpecialIdAndCourseId(specialId, courseId);
		
		return specialCourse;
	}
	
	/**
	 * 根据专业id列表获取课程列表
	 * @param specialIds
	 * @return
	 */
	@GET
	@Path("getCourseInfoListBySpecialIds/{specialIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseInfo> getCourseInfoListBySpecialIds(@PathParam("specialIds") String specialIds){
		List<CourseInfo> result = this.specialCourseLogic.getCourseInfoListBySpecialIds(specialIds);
		return result;
	}
	
}
