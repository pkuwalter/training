package org.wy.ccnu.edu.webservice;

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
import org.wy.ccnu.edu.entity.StudentAgencyOfficialVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentAgencyOfficial;
import org.wy.ccnu.edu.logic.StudentAgencyOfficialLogic;
import org.wy.ccnu.edu.logic.impl.StudentAgencyOfficialLogicImpl;

@Path("/baseInfo/studentAgencyOfficialService")
public class StudentAgencyOfficialService {
	
	private StudentAgencyOfficialLogic studentAgencyOfficialLogic = new StudentAgencyOfficialLogicImpl();
	
	/**
	 * 增加学员单位人员
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudentAgencyOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentAgencyOfficial entity = (StudentAgencyOfficial)mapper.readValue(jsonEntity.toString(), StudentAgencyOfficial.class);
		this.studentAgencyOfficialLogic.addStudentAgencyOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除学员单位人员
	 * @param studentAgencyOfficialID
	 * @return
	 */
	@DELETE
	@Path("delete/{studentAgencyOfficialID}")
	public Response deleteStudentAgencyOfficial(@PathParam("studentAgencyOfficialID") String studentAgencyOfficialID){
		StudentAgencyOfficial studentAgencyOfficial = this.studentAgencyOfficialLogic.getStudentAgencyOfficialById(studentAgencyOfficialID);
		this.studentAgencyOfficialLogic.deleteStudentAgencyOfficial(studentAgencyOfficial);
		return Response.ok().build();
	}
	
	/**
	 * 批量删除学员单位人员
	 * @param studentAgencyOfficialIDs
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response batchDeleteStudentAgencyOfficial(JSONObject studentAgencyOfficialIDs) throws JSONException{
		this.studentAgencyOfficialLogic.batchDeleteStudentAgencyOfficial(studentAgencyOfficialIDs);
		return Response.ok().build();
	}
	
	/**
	 * 更新学员单位人员信息
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudentAgencyOfficial(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentAgencyOfficial entity = (StudentAgencyOfficial)mapper.readValue(jsonEntity.toString(), StudentAgencyOfficial.class);
		this.studentAgencyOfficialLogic.updateStudentAgencyOfficial(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据学员单位人员ID查找学员单位人员
	 * @param studentAgencyOfficialID
	 * @return
	 */
	@GET
	@Path("studentAgencyOfficials/{studentAgencyOfficialID}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentAgencyOfficial getStudentAgencyOfficialById(@PathParam("studentAgencyOfficialID") String studentAgencyOfficialID){
		StudentAgencyOfficial instance = this.studentAgencyOfficialLogic.getStudentAgencyOfficialById(studentAgencyOfficialID);
		return instance;
	}
	
	/**
	 * 根据参数查找学员单位人员
	 * @param studentAgencyName
	 * @param status
	 * @param realName
	 * @param loginName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("studentAgencyOfficials")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentAgencyOfficialVO> getStudentAgencyOfficialByConditions(
			@DefaultValue("") @QueryParam("agency") String agency,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		String real = java.net.URLDecoder.decode(realName, "UTF-8");
		String login = java.net.URLDecoder.decode(loginName, "UTF-8");
		List<StudentAgencyOfficialVO> result = this.studentAgencyOfficialLogic.getStudentAgencyOfficialByConditions(agency, status, real, login, pageNo, pageSize);
		return result;
	}
	
	/**
	 * 根据条件查询学员单位人员获得总记录数
	 * @param gradeName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException 
	 */
	@GET
	@Path("studentAgencyOfficialCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("agency") String agency,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("realName") String realName,
			@DefaultValue("") @QueryParam("loginName") String loginName) throws JSONException, UnsupportedEncodingException{
		
		String real = java.net.URLDecoder.decode(realName, "UTF-8");
		String login = java.net.URLDecoder.decode(loginName, "UTF-8");
		int total = this.studentAgencyOfficialLogic.getTotalRecords(agency, status, real, login);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	/**
	 * 获得所有的学员单位UtilObject
	 * @return
	 */
	@GET
	@Path("allStudentAgencyByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllStudentAgencyByUtilObject(){

		return this.studentAgencyOfficialLogic.getAllStudentAgencyByUtilObject();
	}
    /**
     * 判断用户名是否存在
     * @param loginName
     * @return 1-表示存在，0-表示不存在
     */
    @GET
   	@Path("isLoginNameExist/{loginName}")
   	@Produces(MediaType.APPLICATION_JSON )
	public JSONObject isLoginNameExist(@PathParam("loginName") String loginName)
			 throws JSONException{
    	
    	int flag = this.studentAgencyOfficialLogic.isLoginNameExist(loginName);
    	
    	JSONObject object = new JSONObject();
		
    	object.put("flag", flag);
		 
		return object;
    }
    	
	
}
