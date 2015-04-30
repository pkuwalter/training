package org.nercel.ccnu.edu.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.CareerInfo;
import org.nercel.ccnu.edu.logic.CareerInfoLogic;
import org.nercel.ccnu.edu.logic.impl.CareerInfoLogicImpl;


@Path("/baseInfo/career")
public class CareerService {

	private CareerInfoLogic careerInfoLogic=new CareerInfoLogicImpl();
	/*
	 * 得到所有职业的信息
	 * 
	 * */
	@GET
	@Path("getCareerInfoList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CareerInfo> getCareerInfoList(){
		return careerInfoLogic.getCareerInfoList();
	}
	
	/*
	 * 分页显示
	 * */
	@POST
	@Path("getCareerInfoListPage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CareerInfo> getCareerInfoListPage(JSONObject json) throws JSONException{
		String career=json.getString("career");
		
		int pageNo=json.getInt("pageNo");
		int pageSize=json.getInt("pageSize");
		return careerInfoLogic.getCareerInfoListPage(career, pageNo, pageSize);
	}
	/*
	 * 记录数目
	 * */
	@POST
	@Path("getCareerInfoNum")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getCareerInfoNum(JSONObject json) throws JSONException{
		String career=json.getString("career");
		int total=0;
		total=careerInfoLogic.getCareerInfoNum(career);
		
		
		JSONObject result=new JSONObject();
		result.put("total", total);
		return result;
		
	}
	
	/*
	 * 根据id号批量删除职业信息
	 * */
	@POST
	@Path("deleteCareerInfoByIds")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCareerInfoByIds(JSONObject ids) throws JSONException{
		careerInfoLogic.deleteCareerInfoByIds(ids);
		return Response.ok().build();
	}
	
	/*
	 * 增加职业信息
	 * 
	 * */
	@POST
	@Path("addCareerInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCareerInfo(JSONObject json) throws JsonParseException, JsonMappingException, IOException{
		CareerInfo careerInfo=null;
		ObjectMapper mapper=new ObjectMapper();
		careerInfo=(CareerInfo)mapper.readValue(json.toString(),CareerInfo.class);
		careerInfoLogic.addCareerInfo(careerInfo);
		return Response.ok().build();
	}

}
