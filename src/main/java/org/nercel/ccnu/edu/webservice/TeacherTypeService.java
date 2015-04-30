package org.nercel.ccnu.edu.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.TeacherType;
import org.nercel.ccnu.edu.logic.TeacherTypeLogic;
import org.nercel.ccnu.edu.logic.impl.TeacherTypeLogicImpl;
import org.nercel.ccnu.edu.util.PageModel;

import com.google.gson.Gson;

/**
 * 教师类别 后台Service
 * 
 * @author Demon
 * 
 */
@Path("teacherType")
public class TeacherTypeService {

	private TeacherTypeLogic teacherTypeLogic = new TeacherTypeLogicImpl();

	/**
	 * 查询所有教师列表
	 * 
	 * @author Demon
	 * @return 教师List
	 */
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeacherType> getAll() {

		List<TeacherType> teacherTypeList = teacherTypeLogic.getAll();
		return teacherTypeList;
	}

	/**
	 * 根据属性查询教师类别
	 * 
	 * @author Demon
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 教师类别
	 */
	@GET
	@Path("findByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherType findByProperty(
			@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value) {
		return teacherTypeLogic.findByProperty(propertyName, value);
	}

	/**
	 * 保存教师类别
	 * 
	 * @author Demon
	 * @param teacherType
	 *            教师类别对象
	 */
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(JSONObject jsonTeacherType) {

		TeacherType teacherType = new Gson().fromJson(
				jsonTeacherType.toString(), TeacherType.class);

		teacherTypeLogic.save(teacherType);
		return Response.ok().build();
	}

	/**
	 * 更新教师类别
	 * 
	 * @author Demon
	 * @param teacherType
	 *            教师类别对象
	 */
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonTeacherType) {

		TeacherType teacherType = new Gson().fromJson(
				jsonTeacherType.toString(), TeacherType.class);

		teacherTypeLogic.update(teacherType);
		return Response.ok().build();
	}

	/**
	 * 根据id查询教师类别
	 * 
	 * @author Demon
	 * @param id
	 *            教师类别id
	 * @return 教师类别对象
	 */
	@GET
	@Path("getById")
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherType getById(@QueryParam("id") @DefaultValue("0") int id) {

		TeacherType teacherType = teacherTypeLogic.getById(id);
		return teacherType;
	}

	/**
	 * 删除教师类别
	 * 
	 * @author Demon
	 * @param id
	 *            教师类别id
	 * @return
	 */
	@GET
	@Path("deleteById")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteById(@QueryParam("id") @DefaultValue("0") int id) {

		teacherTypeLogic.deleteById(id);
		return Response.ok().build();
	}

}
