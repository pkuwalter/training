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
import org.wy.ccnu.edu.entity.TeachingUnitInfoVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.TeachingUnitInfo;
import org.wy.ccnu.edu.logic.TeachingUnitInfoLogic;
import org.wy.ccnu.edu.logic.impl.TeachingUnitInfoLogicImpl;
@Path("/teachingUnitInfo")
public class TeachingUnitInfoService {


	private TeachingUnitInfoLogic teachingUnitInfoLogic = new TeachingUnitInfoLogicImpl();
	
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
	public Response addTeachingUnitInfo(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println("--------ser-----"+jsonEntity.toString());
		TeachingUnitInfo entity = (TeachingUnitInfo)mapper.readValue(jsonEntity.toString(), TeachingUnitInfo.class);
		this.teachingUnitInfoLogic.addTeachingUnitInfo(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除报名点
	 * @param teachingUnitInfoID
	 * @return
	 */
	@DELETE
	@Path("delete/{teachingUnitInfoID}")
	public Response deleteTeachingUnitInfo(@PathParam("teachingUnitInfoID") String teachingUnitInfoID){
		TeachingUnitInfo teachingUnitInfo = this.teachingUnitInfoLogic.getTeachingUnitInfoById(teachingUnitInfoID);
		this.teachingUnitInfoLogic.deleteTeachingUnitInfo(teachingUnitInfo);
		return Response.ok().build();
	}
	
	/**
	 * 批量删除报名点
	 * @param manageCenterIds
	 * @return
	 * @throws JSONException
	 */
	@POST  //DELETE无法接受参数，如JSONObject
	@Path("deletes")
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject batchDeleteTeachingUnitInfo(JSONObject teachingUnitInfoIds) throws JSONException{
		
		boolean successOrNot = this.teachingUnitInfoLogic.batchDeleteTeachingUnitInfo(teachingUnitInfoIds);
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
	public Response updateTeachingUnitInfo(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		TeachingUnitInfo entity = (TeachingUnitInfo)mapper.readValue(jsonEntity.toString(), TeachingUnitInfo.class);
		this.teachingUnitInfoLogic.updateTeachingUnitInfo(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据学习中心ID获得该学习中心下的所有报名点
	 * @param coagencyID
	 * @return
	 */
	@GET
	@Path("teachingUnitInfos/coagency/{coagencyID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyID(@PathParam("coagencyID") String coagencyID){
		List<TeachingUnitInfo> teachingUnitInfoList = this.teachingUnitInfoLogic.getTeachingUnitInfoListByCoagencyID(coagencyID);
		return teachingUnitInfoList;
	}
	
	/**
	 * 根据报名点ID查找报名点
	 * @param registrationPonitID
	 * @return
	 */
	@GET
	@Path("teachingUnitInfos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TeachingUnitInfo getTeachingUnitInfoById(@PathParam("id") String id){
		TeachingUnitInfo instance = this.teachingUnitInfoLogic.getTeachingUnitInfoById(id);
		return instance;
	}
	

	/**
	 * 获得所有的报名点
	 * @return
	 */
	@GET
	@Path("teachingUnitInfosAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfo> getAllTeachingUnitInfos(){
		List<TeachingUnitInfo> result = this.teachingUnitInfoLogic.getAllTeachingUnitInfos();
		return result;
	}
	
	/**
	 * 根据学习中心获得所有的报名点
	 * @param coagencyID
	 * @return
	 */
	@GET
	@Path("allTeachingUnitInfosByByCoagency")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllTeachingUnitInfosByCoagency(@QueryParam("coagencyID") String coagencyID){
		return this.teachingUnitInfoLogic.getAllTeachingUnitInfosByCoagency(coagencyID);
	}
	
	@GET
	@Path("teachingUnitInfoUtilsByByManageCenter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getTeachingUnitInfosByManageCenter(@QueryParam("manageCenterID") String manageCenterID){
		return this.teachingUnitInfoLogic.getTeachingUnitInfosByManageCenter(manageCenterID);
	}
	
	/**
	 * 根据参数查找报名点
	 * @param coagencyName
	 * @param teachingUnitNum
	 * @param teachingUnitName
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("getTeachingUnitInfoVOByConditions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfoVO> getTeachingUnitInfoVOByConditions(
			@DefaultValue("") @QueryParam("coagency") String coagency,
			@DefaultValue("") @QueryParam("teachingUnitNum") String teachingUnitNum,
			@DefaultValue("") @QueryParam("teachingUnitName") String teachingUnitName,
			@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		
		List<TeachingUnitInfoVO> result = this.teachingUnitInfoLogic.getTeachingUnitInfoVOByConditions(coagency, teachingUnitNum, teachingUnitName, status, pageNo, pageSize);
		return result;
	}
	
	/**
	 * 获得所有的报名点UtilObject
	 * @return
	 */
	@GET
	@Path("allTeachingUnitInfosByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllTeachingUnitInfosByUtilObject(){
		return this.teachingUnitInfoLogic.getAllTeachingUnitInfosByUtilObject();
	}
	
	/**
	 * 根据条件查询报名点获得总记录数
	 * @param coagency
	 * @param teachingUnitNum
	 * @param teachingUnitName
	 * @param status
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("teachingUnitInfoCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("coagency") String coagency,
			@DefaultValue("") @QueryParam("teachingUnitNum") String teachingUnitNum,
			@DefaultValue("") @QueryParam("teachingUnitName") String teachingUnitName,
			@DefaultValue("") @QueryParam("status") String status) throws JSONException, UnsupportedEncodingException{
		
		int total = this.teachingUnitInfoLogic.getTotalRecords(coagency, teachingUnitNum,teachingUnitName, status);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	/**
	 * 判断名字是否已存在
	 * @param teachingUnitName
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException 
	 */
	@GET
	@Path("teachingUnitNameIsExist")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject teachingUnitNameIsExist(@QueryParam("teachingUnitName") String teachingUnitName) throws JSONException, UnsupportedEncodingException{		
		boolean successOrNot = this.teachingUnitInfoLogic.teachingUnitNameIsExist(teachingUnitName);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@GET
	@Path("teachingUnitNumIsExist")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject teachingUnitNumIsExist(@QueryParam("teachingUnitNum") String teachingUnitNum) throws JSONException, UnsupportedEncodingException{		
		boolean successOrNot = this.teachingUnitInfoLogic.teachingUnitNumIsExist(teachingUnitNum);
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	@GET
	@Path("propertyIsExistInTable")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject propertyIsExistInTable(
			@QueryParam("teachingUnitNum") String property,
			@QueryParam("teachingUnitNum") String propertyValue,
			@QueryParam("teachingUnitNum") String tableName) throws JSONException, UnsupportedEncodingException{		
		boolean successOrNot = this.teachingUnitInfoLogic.propertyIsExistInTable(property, propertyValue, tableName) ;
		JSONObject object = new JSONObject();
		object.put("successOrNot", successOrNot);
		return object;
	}
	
	@GET
	@Path("teachingUnitInfoIDByName")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTeachingUnitInfoIDByName(@QueryParam("teachingUnitName") String teachingUnitName) throws JSONException, UnsupportedEncodingException{
		String teachingUnitInfoID = this.teachingUnitInfoLogic.getTeachingUnitInfoIDByName(teachingUnitName);
		JSONObject object = new JSONObject();
		object.put("teachingUnitInfoID", teachingUnitInfoID);
		return object;
	}
	
	/**
	 * 根据多选的合作机构的ids和培训批次ids来查询满足条件的教学点
	 * @author yangsen
	 * @date 2014-05-20
	 * @param ids
	 * 			合作结构的ids,例如ids = 1,2,3,4
	 * @param batchIds
	 * 			培训批次的batchIds,例如batchIds = 1,2,3,4
	 * @return
	 * 			教学点列表List<TeachingUnitInfo>
	 */
	@GET
	@Path("getTeachingUnitInfoListByCoagencyIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfo> getTeachingUnitInfoListByCoagencyIds(
			@QueryParam("ids") String ids, @QueryParam("batchIds") String batchIds){
		List<TeachingUnitInfo> list = this.teachingUnitInfoLogic
				.getTeachingUnitInfoListByCoagencyIds(ids,batchIds);
		return list;
	}
	
	@GET
	@Path("getTeachingUnitInfoListByIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeachingUnitInfo> getTeachingUnitInfoListByIds(
			@QueryParam("ids") String ids){
		List<TeachingUnitInfo> list = this.teachingUnitInfoLogic
				.getTeachingUnitInfoListByIds(ids);
		return list;
	}
}
