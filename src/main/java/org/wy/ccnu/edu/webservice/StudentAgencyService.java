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
import org.wy.ccnu.edu.entity.StudentAgencyVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.StudentAgency;
import org.wy.ccnu.edu.logic.StudentAgencyLogic;
import org.wy.ccnu.edu.logic.impl.StudentAgencyLogicImpl;

@Path("/studentAgencyService")
public class StudentAgencyService {

	private StudentAgencyLogic studentAgencyLogic = new StudentAgencyLogicImpl();

	/**
	 * 增加学习中心
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudentAgency(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentAgency entity = (StudentAgency)mapper.readValue(jsonEntity.toString(), StudentAgency.class);
		this.studentAgencyLogic.addStudentAgency(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除学习中心
	 * @param studentAgencyID
	 * @return
	 */
	@DELETE
	@Path("delete/{studentAgencyID}")
	public Response deleteStudentAgency(@PathParam("studentAgencyID") String studentAgencyID){
		StudentAgency studentAgency = this.studentAgencyLogic.getStudentAgencyById(studentAgencyID);
		this.studentAgencyLogic.deleteStudentAgency(studentAgency);
		return Response.ok().build();
	}
	
	/**
	 * 批量删除学习中心
	 * @param manageCenterIds
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject batchDeleteStudentAgency(JSONObject studentAgencyIds) throws JSONException{
		boolean successOrNot = this.studentAgencyLogic.batchDeleteStudentAgency(studentAgencyIds);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	/**
	 * 更新学习中心
	 * @param jsonEntity
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudentAgency(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		StudentAgency entity = (StudentAgency)mapper.readValue(jsonEntity.toString(), StudentAgency.class);
		this.studentAgencyLogic.updateStudentAgency(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据学习中心ID查找学习中心
	 * @param studentAgencyID
	 * @return
	 */
	@GET
	@Path("studentAgencys/{studentAgencyID}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentAgency getStudentAgencyById(@PathParam("studentAgencyID") String studentAgencyID){
		StudentAgency instance = studentAgencyLogic.getStudentAgencyById(studentAgencyID);
		return instance;
	}
	
	/**
	 * 获得所有的学习中心
	 * @return
	 */
	@GET
	@Path("studentAgencysAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentAgency> getAllStudentAgencys(){
		List<StudentAgency> result = this.studentAgencyLogic.getAllStudentAgencys();
		return result;
	}
	
	/**
	 * 获得所有的学习中心UtilObject
	 * @return
	 */
	@GET
	@Path("allStudentAgencysByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllStudentAgencysByUtilObject(){
		return this.studentAgencyLogic.getAllStudentAgencysByUtilObject();
	}
	
	@GET
	@Path("studentAgencyUtilByManageCenterID")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getStudentAgencyUtilByManageCenterID(@QueryParam("manageCenterID") String manageCenterID){
		return this.studentAgencyLogic.getStudentAgencyUtilByManageCenterID(manageCenterID);
	}
	
	/**
	 * 根据参数查找学习中心
	 * @param studentAgencyNum
	 * @param studentAgencyName
	 * @param manageCenterName
	 * @param jwNum
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("studentAgencys")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentAgencyVO> getStudentAgencyByConditions(
			@DefaultValue("") @QueryParam("studentAgencyNum") String studentAgencyNum,
			@DefaultValue("") @QueryParam("studentAgencyName") String studentAgencyName,
			@DefaultValue("") @QueryParam("manageCenter") String manageCenter,
			@DefaultValue("") @QueryParam("jwNum") String jwNum,
			@DefaultValue("") @QueryParam("jwName") String jwName,
			@DefaultValue("") @QueryParam("provinceCode") String provinceCode,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		String studyName = java.net.URLDecoder.decode(studentAgencyName, "UTF-8");
		String jw_Name = java.net.URLDecoder.decode(jwName, "UTF-8");
		//List<StudentAgency> result = studentAgencyLogic.getStudentAgencyByConditions(studentAgencyNum, studyName, manageName, jwNum, pageNo, pageSize);
		List<StudentAgencyVO> result = studentAgencyLogic.findStudentAgencyVOByConditions(studentAgencyNum, studyName, manageCenter, jwNum,jw_Name,provinceCode, pageNo, pageSize);
		return result;
	}
	
	/**
	 * 根据条件查询学习中心获得总记录数
	 * @param gradeName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException 
	 */
	@GET
	@Path("studentAgencyCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("studentAgencyNum") String studentAgencyNum,
			@DefaultValue("") @QueryParam("studentAgencyName") String studentAgencyName,
			@DefaultValue("") @QueryParam("manageCenterName") String manageCenterName,
			@DefaultValue("") @QueryParam("jwNum") String jwNum,
			@DefaultValue("") @QueryParam("jwName") String jwName,
			@DefaultValue("") @QueryParam("provinceCode") String provinceCode) throws JSONException, UnsupportedEncodingException{
		String studyName = java.net.URLDecoder.decode(studentAgencyName, "UTF-8");
		String manageName = java.net.URLDecoder.decode(manageCenterName, "UTF-8");
		String jw_Name = java.net.URLDecoder.decode(jwName, "UTF-8");
		int total = this.studentAgencyLogic.getTotalRecords(studentAgencyNum, studyName, manageName, jwNum,jw_Name,provinceCode);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	@GET
	@Path("studentAgencyIDByName")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getStudentAgencyIDByName(@QueryParam("studentAgencyName") String studentAgencyName) throws JSONException, UnsupportedEncodingException{
		String studentAgencyID = studentAgencyLogic.getStudentAgencyIDByName(studentAgencyName);
		JSONObject object = new JSONObject();
		object.put("studentAgencyID", studentAgencyID);
		return object;
	}
	
	/**
     * 根据StudentAgency的属性来查找
     * @author yangsen 2013-12-04
     * @param property
     * 			学习中心属性
     * @param proValue
     * 			学习中心属性的值
     * @return
     * 			学习中心实体
     */
	@GET
	@Path("getStudentAgencyByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
    public StudentAgency getStudentAgencyByProperty(@PathParam("property") String property,
    								@PathParam("proValue") String proValue){
		System.out.println("property="+property);
    	System.out.println("proValue="+proValue);
		StudentAgency studentAgency = this.studentAgencyLogic
    			.getStudentAgencyByProperty(property, proValue);
    	return studentAgency;
    }
}
