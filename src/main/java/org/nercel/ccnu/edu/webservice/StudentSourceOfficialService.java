package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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
import org.nercel.ccnu.edu.entity.StudentSourceOfficialVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentSourceOfficial;
import org.nercel.ccnu.edu.logic.StudentSourceOfficialLogic;
import org.nercel.ccnu.edu.logic.impl.StudentSourceOfficialLogicImpl;

@Path("/baseInfo/studentSourceOfficialService")
public class StudentSourceOfficialService {
	
	private StudentSourceOfficialLogic studentSourceOfficialLogic = new StudentSourceOfficialLogicImpl();
	
	/**
	 * 增加渠道人员
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudentSourceOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentSourceOfficial entity = (StudentSourceOfficial)mapper.readValue(jsonEntity.toString(), StudentSourceOfficial.class);
		this.studentSourceOfficialLogic.addStudentSourceOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除渠道人员
	 * @param studentSourceOfficialID
	 * @return
	 */
	@DELETE
	@Path("delete/{studentSourceOfficialID}")
	public Response deletestudentSourceOfficial(@PathParam("studentSourceOfficialID") String studentSourceOfficialID){
		StudentSourceOfficial studentSourceOfficial = this.studentSourceOfficialLogic.getStudentSourceOfficialById(studentSourceOfficialID);
		this.studentSourceOfficialLogic.deleteStudentSourceOfficial(studentSourceOfficial);
		return Response.ok().build();
	}
	
	/**
	 * 批量删除渠道人员
	 * @param studentSourceOfficialIds
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response batchDeleteStudentSourceOfficial(JSONObject studentSourceOfficialIds) throws JSONException{
		
		this.studentSourceOfficialLogic.batchDeleteStudentSourceOfficial(studentSourceOfficialIds);
		return Response.ok().build();
	}
	
	/**
	 * 更新渠道人员信息
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudentSourceOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentSourceOfficial entity = (StudentSourceOfficial)mapper.readValue(jsonEntity.toString(), StudentSourceOfficial.class);
		this.studentSourceOfficialLogic.updateStudentSourceOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据渠道人员ID查找渠道
	 * @param studentSourceOfficialID
	 * @return
	 */
	@GET
	@Path("studentSourceOfficials/{studentSourceOfficialID}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentSourceOfficial getStudentSourceOfficialById(@PathParam("studentSourceOfficialID") String studentSourceOfficialID){
		StudentSourceOfficial instance = this.studentSourceOfficialLogic.getStudentSourceOfficialById(studentSourceOfficialID);
		return instance;
	}
	
	/**
	 * 根据条件查找渠道人员
	 * @param studentSourceName
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("studentSourceOfficials")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentSourceOfficialVO> getStudentSourceOfficialVOByConditions(
			@DefaultValue("") @QueryParam("agency") String agency,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		List<StudentSourceOfficialVO> result = this.studentSourceOfficialLogic.findStudentSourceOfficialVOByConditions(agency, status, realName, loginName, pageNo, pageSize);
		return result;			
	}
	
	/**
	 * 根据条件查询渠道人员获得总记录数
	 * @param studentSource
	 * @param status
	 * @param realName
	 * @param loginName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("studentSourceOfficialCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("studentSource") String studentSource,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName) throws JSONException, UnsupportedEncodingException{
		
		int total = this.studentSourceOfficialLogic.getTotalRecords(studentSource, status, realName, loginName);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	/**
	 * 渠道录入学生数据根据用户名获取渠道的ID
	 * add 20121101
	 * 
	 * @param loginName
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("studentSourceID")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getStudentSourceIDByLoginName(
			@DefaultValue("") @QueryParam("loginName") String loginName) throws JSONException{
		String studentSourceID = this.studentSourceOfficialLogic.getStudentSourceIDByLoginName(loginName);
		JSONObject object = new JSONObject();
		object.put("studentSourceID", studentSourceID);
		return object;
	}
	/**
	 * 获得所有的生源渠道UtilObject
	 * @return
	 */
	@GET
	@Path("allStudentSourceByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllStudentSourceByUtilObject(){

		return this.studentSourceOfficialLogic.getAllStudentSourceByUtilObject();
	}	
}
