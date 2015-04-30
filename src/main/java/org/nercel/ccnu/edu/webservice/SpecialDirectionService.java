package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
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
import org.nercel.ccnu.edu.entity.SpecialDirectionVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.EducationLevel;
import org.nercel.ccnu.edu.entity.persist.SpecialDirection;
import org.nercel.ccnu.edu.logic.SpecialDirectionLogic;
import org.nercel.ccnu.edu.logic.impl.SpecialDirectionLogicImpl;
 

@Path("/specialDirectionService")
public class SpecialDirectionService {
	
	private SpecialDirectionLogic specialDirectionLogic = new SpecialDirectionLogicImpl();
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSpecialDirection(JSONObject jsonEntity) throws JSONException, JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		SpecialDirection entity = (SpecialDirection)mapper.readValue(jsonEntity.toString(), SpecialDirection.class);
		
		this.specialDirectionLogic.addSpecialDirection(entity);
		
		return Response.ok().build();
	
	}
 
		
	    /**
	     * 根据id，单个删除
	     * @param specialDirectionId
	     * @throws JSONException
	     */
	@POST
	@Path("deleteSpecialDirection")
    	public Response deleteSpecialDirection(@DefaultValue("0") @QueryParam("specialDirectionId") int specialDirectionId){
			
		this.specialDirectionLogic.deleteSpecialDirection(specialDirectionId);
		
		return Response.ok().build();
			
		}
		
	@POST
	@Path("updateSpecialDirection")
    	public Response updateSpecialDirection(JSONObject jsonEntity)throws JSONException, JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		SpecialDirection entity = (SpecialDirection)mapper.readValue(jsonEntity.toString(), SpecialDirection.class);
		
		this.specialDirectionLogic.updateSpecialDirection(entity);
		
		return Response.ok().build();
	}
	
	@GET
	@Path("getSpecialDirectionVOById")
	@Produces(MediaType.APPLICATION_JSON)
		public SpecialDirectionVO getSpecialDirectionVOById(@DefaultValue("0") @QueryParam("specialDirectionId") int specialDirectionId){
		
		return this.specialDirectionLogic.getSpecialDirectionVOById(specialDirectionId);
	}
		
		/**
		 * 根据学科方向代码，查询学科方向对象
		 * @param specialDirectionCode
		 * @return
		 */
	@GET
	@Path("getSpecialDirectionVOByCode")
	@Produces(MediaType.APPLICATION_JSON)
		public SpecialDirectionVO getSpecialDirectionVOByCode(@DefaultValue("") @QueryParam("specialDirectionCode") String specialDirectionCode){
		
		return this.specialDirectionLogic.getSpecialDirectionVOByCode(specialDirectionCode);
	}
	
		
		/**
		 * 根据培养学科或专业id,学科方向代码，学科方向名称，组合查询，获取学科方向VO列表
		 * 分页查询
		 * @param specialId
		 * @return
		 */
	@GET
	@Path("getSpecialDirectionVOListByCondition")
	@Produces(MediaType.APPLICATION_JSON)
		public List<SpecialDirectionVO> getSpecialDirectionVOListByCondition(
				@DefaultValue("") @QueryParam("specialId") String specialId,
				@DefaultValue("") @QueryParam("specialDirectionCode") String specialDirectionCode,
				@DefaultValue("") @QueryParam("specialDirectionName") String specialDirectionName,
				@DefaultValue("1") @QueryParam("pageNo") int pageNo,
				@DefaultValue("10") @QueryParam("pageSize") int pageSize
				 ){
		
		return this.specialDirectionLogic.getSpecialDirectionVOListByCondition(specialId, specialDirectionCode, specialDirectionName, pageNo, pageSize);
	}
		
		
		/**
		 * 根据培养学科或专业id,学科方向代码，学科方向名称，获取学科方向VO列表
		 * 分页查询
		 * @param specialId
		 * @return
		 * @throws JSONException 
		 */
	@GET
	@Path("getSpecialDirectionVOListSizeByCondition")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getSpecialDirectionVOListSizeByCondition(
				@DefaultValue("") @QueryParam("specialId") String specialId,
				@DefaultValue("") @QueryParam("specialDirectionCode") String specialDirectionCode,
				@DefaultValue("") @QueryParam("specialDirectionName") String specialDirectionName) throws JSONException{
		
		int total = this.specialDirectionLogic.getSpecialDirectionVOListSizeByCondition(specialId, specialDirectionCode, specialDirectionName);

		JSONObject object = new JSONObject();
   		
    	object.put("total", total);

    	return object;
	}
		
		
	 
}
