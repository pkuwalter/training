package org.nercel.ccnu.edu.webservice;

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
import org.nercel.ccnu.edu.entity.AcademicTitleVO;
import org.nercel.ccnu.edu.entity.persist.AcademicTitle;
import org.nercel.ccnu.edu.logic.AcademicTitleLogic;
import org.nercel.ccnu.edu.logic.impl.AcademicTitleLogicImpl;

import com.google.gson.Gson;

/**
 * 职称 后台Service
 * 
 * @author Demon
 * 
 */
@Path("academicTitle")
public class AcademicTitleService {

	private AcademicTitleLogic academicTitleLogic = new AcademicTitleLogicImpl();

	/**
	 * 保存职称
	 * 
	 * @author Demon
	 * @param academicTitle
	 *            职称对象
	 */
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(JSONObject jsonAcademicTitle) {

		AcademicTitle academicTitle = new Gson().fromJson(
				jsonAcademicTitle.toString(), AcademicTitle.class);

		academicTitleLogic.save(academicTitle);
		return Response.ok().build();
	}

	/**
	 * 根据id查询职称
	 * 
	 * @author Demon
	 * @param Id
	 *            职称id
	 * @return 职称对象
	 */
	@GET
	@Path("getById")
	@Produces(MediaType.APPLICATION_JSON)
	public AcademicTitle getById(@QueryParam("id") @DefaultValue("0") int id) {
		return academicTitleLogic.getById(id);
	}

	/**
	 * 根据属性查询职称
	 * 
	 * @author Demon
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 职称对象
	 */
	@GET
	@Path("findByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public AcademicTitle findByProperty(
			@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value) {
		return academicTitleLogic.findByProperty(propertyName, value);
	}

	/**
	 * 根据职业id查询职称
	 * 
	 * @author Demon
	 * @param careerId
	 *            职业id
	 * @return 职业-职称VO 列表
	 */
	@GET
	@Path("getByCareerId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AcademicTitleVO> getByCareerId(
			@QueryParam("careerId") @DefaultValue("") String careerId) {
		return academicTitleLogic.getByCareerId(careerId);
	}

	/**
	 * 根据职称id删除职称
	 * 
	 * @author Demon
	 * @param id
	 *            职称id
	 * @return 删除成功返回httpStatus 200
	 */
	@GET
	@Path("deleteById")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteById(@QueryParam("id") @DefaultValue("0") int id) {

		academicTitleLogic.deleteById(id);
		return Response.ok().build();
	}

	/**
	 * 更新职称
	 * 
	 * @author Demon
	 * @param academicTitle
	 *            职称对象
	 */
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonAcademicTitle) {

		AcademicTitle academicTitle = new Gson().fromJson(
				jsonAcademicTitle.toString(), AcademicTitle.class);
		
		academicTitleLogic.update(academicTitle);
		return Response.ok().build();
	}
}
