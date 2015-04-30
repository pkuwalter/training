package org.nercel.ccnu.edu.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.nercel.ccnu.edu.entity.persist.TeacherType;
import org.nercel.ccnu.edu.util.PageModel;

@Path("/baseService")
public class BaseService {

	@GET
	@Path("/example")
	@Consumes("application/json")
	public Response example() {

		System.out.println("WebService is OK!");
		return Response.ok().build();
	}

	@GET
	@Path("getTeacherTypeByPage")
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<TeacherType> getTeacherTypeByPage() {

		PageModel<TeacherType> pageModel = new PageModel<TeacherType>();

		List<TeacherType> typeList = new ArrayList<TeacherType>();

		TeacherType teacherType = new TeacherType();
		teacherType.setId(1);
		teacherType.setTeacherTypeName("一班");

		typeList.add(teacherType);

		pageModel.setList(typeList);
		pageModel.setPageNo(1);
		pageModel.setPageSize(10);
		pageModel.setTotalRecords(100);

		return pageModel;

	}
}
