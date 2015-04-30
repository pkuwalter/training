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
import org.wy.ccnu.edu.entity.CoagencyVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.Coagency;
import org.wy.ccnu.edu.logic.CoagencyLogic;
import org.wy.ccnu.edu.logic.impl.CoagencyLogicImpl;

@Path("/coagencyService")
public class CoagencyService {
	private CoagencyLogic coagencyLogic = new CoagencyLogicImpl();

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
	public Response addCoagency(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Coagency entity = (Coagency)mapper.readValue(jsonEntity.toString(), Coagency.class);
		this.coagencyLogic.addCoagency(entity);
		return Response.ok().build();
	}
	
	/**
	 * 删除学习中心
	 * @param coagencyID
	 * @return
	 */
	@DELETE
	@Path("delete/{coagencyID}")
	public Response deleteCoagency(@PathParam("coagencyID") String coagencyID){
		Coagency coagency = this.coagencyLogic.getCoagencyById(coagencyID);
		this.coagencyLogic.deleteCoagency(coagency);
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
	public JSONObject batchDeleteCoagency(JSONObject coagencyIds) throws JSONException{
		boolean successOrNot = this.coagencyLogic.batchDeleteCoagency(coagencyIds);
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
	public Response updateCoagency(JSONObject jsonEntity) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Coagency entity = (Coagency)mapper.readValue(jsonEntity.toString(), Coagency.class);
		this.coagencyLogic.updateCoagency(entity);
		return Response.ok().build();
	}
	
	/**
	 * 根据学习中心ID查找学习中心
	 * @param coagencyID
	 * @return
	 */
	@GET
	@Path("coagencys/{coagencyID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Coagency getCoagencyById(@PathParam("coagencyID") String coagencyID){
		Coagency instance = coagencyLogic.getCoagencyById(coagencyID);
		return instance;
	}
	
	/**
	 * 获得所有的合作机构
	 * @return
	 */
	@GET
	@Path("coagencysAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coagency> getAllCoagencys(){
		List<Coagency> result = this.coagencyLogic.getAllCoagencys();
		return result;
	}
	
	/**
	 * 获得所有的学习中心UtilObject
	 * @return
	 */
	@GET
	@Path("allCoagencysByUtilObject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getAllCoagencysByUtilObject(){
		return this.coagencyLogic.getAllCoagencysByUtilObject();
	}
	
	@GET
	@Path("coagencyUtilByManageCenterID")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilObject> getCoagencyUtilByManageCenterID(@QueryParam("manageCenterID") String manageCenterID){
		return this.coagencyLogic.getCoagencyUtilByManageCenterID(manageCenterID);
	}
	
	/**
	 * 根据参数查找学习中心
	 * @param coagencyNum
	 * @param coagencyName
	 * @param manageCenterName
	 * @param jwNum
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GET
	@Path("coagencys")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CoagencyVO> getCoagencyByConditions(
			@DefaultValue("") @QueryParam("coagencyNum") String coagencyNum,
			@DefaultValue("") @QueryParam("coagencyName") String coagencyName,
			@DefaultValue("") @QueryParam("manageCenter") String manageCenter,
			@DefaultValue("") @QueryParam("jwNum") String jwNum,
			@DefaultValue("") @QueryParam("jwName") String jwName,
			@DefaultValue("") @QueryParam("provinceCode") String provinceCode,
			@DefaultValue("1") @QueryParam("pageNo") int pageNo,
			@DefaultValue("3") @QueryParam("pageSize") int pageSize) throws UnsupportedEncodingException{
		String studyName = java.net.URLDecoder.decode(coagencyName, "UTF-8");
		String jw_Name = java.net.URLDecoder.decode(jwName, "UTF-8");
		//List<Coagency> result = coagencyLogic.getCoagencyByConditions(coagencyNum, studyName, manageName, jwNum, pageNo, pageSize);
		List<CoagencyVO> result = coagencyLogic.findCoagencyVOByConditions(coagencyNum, studyName, manageCenter, jwNum,jw_Name,provinceCode, pageNo, pageSize);
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
	@Path("coagencyCounts")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTotalRecords(
			@DefaultValue("") @QueryParam("coagencyNum") String coagencyNum,
			@DefaultValue("") @QueryParam("coagencyName") String coagencyName,
			@DefaultValue("") @QueryParam("manageCenterName") String manageCenterName,
			@DefaultValue("") @QueryParam("jwNum") String jwNum,
			@DefaultValue("") @QueryParam("jwName") String jwName,
			@DefaultValue("") @QueryParam("provinceCode") String provinceCode) throws JSONException, UnsupportedEncodingException{
		String studyName = java.net.URLDecoder.decode(coagencyName, "UTF-8");
		String manageName = java.net.URLDecoder.decode(manageCenterName, "UTF-8");
		String jw_Name = java.net.URLDecoder.decode(jwName, "UTF-8");
		int total = this.coagencyLogic.getTotalRecords(coagencyNum, studyName, manageName, jwNum,jw_Name,provinceCode);
		JSONObject object = new JSONObject();
		object.put("total", total);
		return object;
	}
	
	@GET
	@Path("coagencyIDByName")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getCoagencyIDByName(@QueryParam("coagencyName") String coagencyName) throws JSONException, UnsupportedEncodingException{
		String coagencyID = coagencyLogic.getCoagencyIDByName(coagencyName);
		JSONObject object = new JSONObject();
		object.put("coagencyID", coagencyID);
		return object;
	}
	
	/**
     * 根据Coagency的属性来查找
     * @author yangsen 2013-12-04
     * @param property
     * 			学习中心属性
     * @param proValue
     * 			学习中心属性的值
     * @return
     * 			学习中心实体
     */
	@GET
	@Path("getCoagencyByProperty/{property}-{proValue}")
	@Produces(MediaType.APPLICATION_JSON)
    public Coagency getCoagencyByProperty(@PathParam("property") String property,
    								@PathParam("proValue") String proValue){
		System.out.println("property="+property);
    	System.out.println("proValue="+proValue);
		Coagency coagency = this.coagencyLogic
    			.getCoagencyByProperty(property, proValue);
    	return coagency;
    }
	
	
	/**
	 * 根据Id串"id1,id2..."获取合作机构列表
	 * @param ids
	 * @return
	 */
	@GET
	@Path("getCoagencysByIds/{ids}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coagency> getCoagencysByIds(@PathParam("ids") String ids){
		List<Coagency> result = this.coagencyLogic.getCoagencysByIds(ids);
		return result;
	}
	
	/**
	 * 根据培训批次刷新合作机构列表
	 * @author yangsen
	 * @date 2014-06-18
	 * @param batchIds
	 * 		培训批次batchIds，例如batchIds=1,2,3,4
	 * @return
	 * 		List<Coagency>
	 */
	@GET
	@Path("getCoagencysByBatchIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coagency> getCoagencysByBatchIds(
			@QueryParam("batchIds") String batchIds){
		List<Coagency> result = this.coagencyLogic.getCoagencysByBatchIds(batchIds);
		return result;
	}
}
