package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
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
import org.nercel.ccnu.edu.entity.StudentSourceInfoVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.StudentSourceInfo;
import org.nercel.ccnu.edu.logic.StudentSourceInfoLogic;
import org.nercel.ccnu.edu.logic.impl.StudentSourceInfoLogicImpl;


@Path("/studentSourceInfo")
public class StudentSourceInfoService {

private StudentSourceInfoLogic studentSourceInfoLogic = new StudentSourceInfoLogicImpl();
	
	/**
	 * 增加报名点
	 * @param jsonEntity
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudentSourceInfo(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println("-------ser h------"+jsonEntity);
		StudentSourceInfo entity = (StudentSourceInfo)mapper.readValue(jsonEntity.toString(), StudentSourceInfo.class);
		this.studentSourceInfoLogic.save(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除报名点
	 * @param studentSourceInfoID
	 * @return
	 *//*
	@DELETE
	@Path("delete/{studentSourceInfoID}")
	public Response deleteStudentSourceInfo(@PathParam("studentSourceInfoID") String studentSourceInfoID){
		StudentSourceInfo studentSourceInfo = this.studentSourceInfoLogic.findStudentSourceInfoById(studentSourceInfoID);
		this.studentSourceInfoLogic.batchDeleteStudentSourceInfo((JSONObject)studentSourceInfo);
		return Response.ok().build();
	}*/
	
	/**
	 * 批量删除报名点
	 * @param manageCenterIds
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject batchDeleteStudentSourceInfo(JSONObject studentSourceInfoIds) throws JSONException{
		
		boolean successOrNot = this.studentSourceInfoLogic.batchDeleteStudentSourceInfo(studentSourceInfoIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	/**
	 * 更新报名点 
	 * @param jsonEntity
	 * @return
	 * @throws JSONException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudentSourceInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentSourceInfo entity = (StudentSourceInfo)mapper.readValue(jsonEntity.toString(), StudentSourceInfo.class);
		this.studentSourceInfoLogic.update(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据学习中心ID获得该学习中心下的所有报名点
	 * @param studentAgencyID
	 * @return
	 */
	@GET
	@Path("studentSourceInfos/studentAgency/{studentAgencyID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentSourceInfo> getStudentSourceInfoListByStudentAgencyID(@PathParam("studentAgencyID") String studentAgencyID){
		List<StudentSourceInfo> studentSourceInfoList = this.studentSourceInfoLogic.getStudentSourceInfoListByStudentAgencyID(studentAgencyID);
		return studentSourceInfoList;
	}
	
	/**
	 * 根据报名点ID查找报名点
	 * @param registrationPonitID
	 * @return
	 */
	@GET
	@Path("studentSourceInfos/{studentSourceInfoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentSourceInfo getStudentSourceInfoById(@PathParam("studentSourceInfoID") String studentSourceInfoID){
		StudentSourceInfo instance = this.studentSourceInfoLogic.findStudentSourceInfoById(studentSourceInfoID);
		return instance;
	}
	

	/**
	 * 获得所有的报名点
	 * @return
	 */
	@GET
	@Path("studentSourceInfosAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentSourceInfo> getAllStudentSourceInfos(){
		List<StudentSourceInfo> result = this.studentSourceInfoLogic.getAllStudentSourceInfos();
		return result;
	}
	
	/**
	 * 根据学习中心获得所有的报名点
	 * @param studentAgencyID
	 * @return
	 */
	@GET
	@Path("allStudentSourceInfosByByStudentAgency")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllStudentSourceInfosByStudentAgency(@QueryParam("studentAgencyID") String studentAgencyID){
		return this.studentSourceInfoLogic.getAllStudentSourceInfosByStudentAgency(studentAgencyID);
	}
	
	@GET
	@Path("studentSourceInfoUtilsByByManageCenter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getStudentSourceInfosByManageCenter(@QueryParam("manageCenterID") String manageCenterID){
		return this.studentSourceInfoLogic.getStudentSourceInfosByManageCenter(manageCenterID);
	}
	
	/**
	 * 根据参数查找报名点
	 * @param studentAgencyName
	 * @param studentSourceNum
	 * @param studentSourceName
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("studentSourceInfos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentSourceInfoVO> getStudentSourceInfoVOByConditions(
			@DefaultValue("") @QueryParam("studentAgency") String studentAgency,
			@DefaultValue("") @QueryParam("studentSourceNum") String studentSourceNum,
			@DefaultValue("") @QueryParam("studentSourceName") String studentSourceName,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		
		List<StudentSourceInfoVO> result = this.studentSourceInfoLogic.findStudentSourceInfoVOByConditions(studentAgency, studentSourceNum, studentSourceName, status, pageNo, pageSize);
		return result;
	}
	
	/**
	 * 获得所有的报名点UtilObject
	 * @return
	 */
	@GET
	@Path("allStudentSourceInfosByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllStudentSourceInfosByUtilObject(){
		return this.studentSourceInfoLogic.getAllStudentSourceInfosByUtilObject();
	}
	
	/**
	 * 根据条件查询报名点获得总记录数
	 * @param studentAgency
	 * @param studentSourceNum
	 * @param studentSourceName
	 * @param status
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("studentSourceInfoCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("studentAgency") String studentAgency,
			@DefaultValue("") @QueryParam("studentSourceNum") String studentSourceNum,
			@DefaultValue("") @QueryParam("studentSourceName") String studentSourceName,
			@DefaultValue("") @QueryParam("status") String status) throws JSONException, UnsupportedEncodingException{
		
		int total = this.studentSourceInfoLogic.getTotalRecords(studentAgency, studentSourceNum,studentSourceName, status);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	/**
	 * 判断名称的名字是否已存在
	 * @param studentSourceName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException 
	 */
	@GET
	@Path("studentSourceInfoIsExist")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject studentSourceInfoIsExist(@QueryParam("studentSourceName") String studentSourceName) throws JSONException, UnsupportedEncodingException{		
		boolean successOrNot = this.studentSourceInfoLogic.studentSourceInfoIsExist(studentSourceName);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	/**
	 * 判断编号是否已存在
	 * @param studentSourceName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException 
	 */
	@GET
	@Path("studentSourceNumIsExist")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject studentSourceNumIsExist(@QueryParam("studentSourceNum") String studentSourceNum) throws JSONException, UnsupportedEncodingException{		
		boolean successOrNot = this.studentSourceInfoLogic.studentSourceNumIsExist(studentSourceNum);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@GET
	@Path("studentSourceInfoIDByName")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getStudentSourceInfoIDByName(@QueryParam("studentSourceName") String studentSourceName) throws JSONException, UnsupportedEncodingException{
		String studentSourceInfoID = this.studentSourceInfoLogic.getStudentSourceInfoIDByName(studentSourceName);
		JSONObject object = new JSONObject();
		object.put("studentSourceInfoID", studentSourceInfoID);
		return object;
	}
}
