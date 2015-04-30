package org.nercel.ccnu.edu.webservice;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TeacherInfoVO;
import org.nercel.ccnu.edu.entity.persist.TeacherInfo;
import org.nercel.ccnu.edu.logic.TeacherInfoLogic;
import org.nercel.ccnu.edu.logic.impl.TeacherInfoLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

import com.google.gson.Gson;

/**
 * 教师后台Service
 * 
 * @author Demon
 */
@Path("teacherInfo")
public class TeacherInfoService {

	private TeacherInfoLogic teacherLogic = new TeacherInfoLogicImpl();

	/**
	 * 保存教师对象
	 * 
	 * @author Demon
	 * @param jsonTeacher
	 * @return 保存成功 http status 为 200
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(JSONObject jsonTeacher) throws JsonParseException,
			JsonMappingException, IOException {

		// 将JSON对象映射为实体类
		ObjectMapper mapper = new ObjectMapper();
		TeacherInfo teacher = (TeacherInfo) mapper.readValue(
				jsonTeacher.toString(), TeacherInfo.class);
		teacherLogic.save(teacher);

		return Response.ok().build();
	}

	/**
	 * 根据属性查询TeacherInfo
	 * 
	 * @author Demon
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return 教师对象
	 */
	@GET
	@Path("findByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherInfo findByProperty(
			@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value) {

		TeacherInfo teacher = teacherLogic.findByProperty(propertyName, value);
		return teacher;
	}

	/**
	 * 分页查询教师信息
	 * 
	 * @author Demon
	 * @param teacherTypeId
	 *            教师类别id
	 * @param status
	 *            教师状态(0:停用，1:启用)
	 * @param coagencyId
	 *            所属机构id
	 * @param teachingUnitId
	 *            教学点id
	 * @param name
	 *            教师姓名
	 * @param loginName
	 *            教师用户名
	 * @param teacherOrigin
	 *            教师来源(本校;外校两类)
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return 教师PageModel<TeacherInfoVO>
	 */
	@GET
	@Path("getTeacherInfoByPage")
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<TeacherInfoVO> getTeacherInfoByPage(
			@QueryParam("teacherTypeId") @DefaultValue("-1") int teacherTypeId,
			@QueryParam("status") @DefaultValue("-1") int status,
			@QueryParam("coagencyId") @DefaultValue("") String coagencyId,
			@QueryParam("teachingUnitId") @DefaultValue("") String teachingUnitId,
			@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value,
			@QueryParam("teacherOrigin") @DefaultValue("") String teacherOrigin,
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("20") int pageSize) {

		return teacherLogic.getTeacherInfoByPage(teacherTypeId, status,
				coagencyId, teachingUnitId, propertyName, value, teacherOrigin,
				pageNo, pageSize);
	}

	/**
	 * 根据id删除教师对象
	 * 
	 * @author Demon
	 * @param id
	 *            教师id
	 * @return 操作成功返回200
	 */
	@GET
	@Path("deleteById")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteById(@QueryParam("id") @DefaultValue("0") int id) {
		teacherLogic.deleteById(id);
		return Response.ok().build();
	}

	/**
	 * 更新教师的状态
	 * 
	 * @param id
	 *            教师Id
	 * @param status
	 *            状态(1:启用,0:停用)
	 */
	@GET
	@Path("updateStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(@QueryParam("id") @DefaultValue("0") int id,
			@QueryParam("status") @DefaultValue("1") int status) {
		teacherLogic.updateStatus(id, status);
		return Response.ok().build();
	}

	/**
	 * 根据id查询教师
	 * 
	 * @author Demon
	 * @param id
	 *            教师id
	 * @return 教师对象
	 */
	@GET
	@Path("getById")
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherInfo getById(@QueryParam("id") @DefaultValue("0") int id) {
		return teacherLogic.getById(id);
	}

	/**
	 * 更新教师信息
	 * 
	 * @param teacher
	 *            教师对象
	 */
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonTeacher) {

		TeacherInfo teacher = new Gson().fromJson(jsonTeacher.toString(),
				TeacherInfo.class);
		teacherLogic.update(teacher);
		return Response.ok().build();
	}
}
