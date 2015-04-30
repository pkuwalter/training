package org.wy.ccnu.edu.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.StudentInfoVO;
import org.wy.ccnu.edu.entity.persist.StudentInfo;
import org.wy.ccnu.edu.logic.StudentInfoLogic;
import org.wy.ccnu.edu.logic.impl.StudentInfoLogicImpl;
import org.wy.ccnu.edu.util.PageModel;

import com.google.gson.Gson;

/**
 * 学生信息 - 后台Service
 * 
 * @author Demon
 * 
 */
@Path("studentInfo")
public class StudentInfoService {

	StudentInfoLogic studentLogic = new StudentInfoLogicImpl();

	/**
	 * 保存学生信息
	 * 
	 * @author Demon
	 * @param jsonStudent
	 *            学生信息JSON
	 * @return 保存成功HttpStatus 200
	 */
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(JSONObject jsonStudent) {

		// 将JSON转换为StudentInfo对象
		StudentInfo student = new Gson().fromJson(jsonStudent.toString(),
				StudentInfo.class);
		// 前面映射产生的student对象id="",此处设置为null让orm框架为其生成uuid主键
		student.setId(null);
		student.setConfirmDate(null);
		student.setForceUpdateDate(null);
		student.setGraduateTime_former(null);
		student.setWorkdatebegin(null);

		studentLogic.save(student);
		return Response.ok().build();
	}

	/**
	 * 根据属性查询学生信息
	 * 
	 * @author Demon
	 * @param key
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 学生对象
	 */
	@GET
	@Path("findByProperty")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentInfo findByProperty(
			@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value) {
		return studentLogic.findByProperty(propertyName, value);
	}

	/**
	 * 根据培训项目id、培训批次id和证件号码查询是否存在学生 说明：同一培训项目、批次下证件号码唯一
	 * 
	 * @author Demon
	 * @param trainingProjectId
	 *            培训项目id
	 * @param trainingBatchId
	 *            培训批次id
	 * @param credentialNum
	 *            证件号码
	 * @return 存在：true;不存在false
	 * @throws JSONException
	 */
	@GET
	@Path("isExistCredentialNum")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject isExistCredentialNum(
			@QueryParam("trainingProjectId") @DefaultValue("0") int trainingProjectId,
			@QueryParam("trainingBatchId") @DefaultValue("0") int trainingBatchId,
			@QueryParam("credentialNum") @DefaultValue("") String credentialNum)
			throws JSONException {

		boolean flag = studentLogic.isExistCredentialNum(trainingProjectId,
				trainingBatchId, credentialNum);
		return new JSONObject().put("flag", flag);
	}

	/**
	 * 更新学生信息
	 * 
	 * @author Demon
	 * @author Demon
	 * @param jsonStudent
	 *            学生对象JSON格式 学生对象
	 * @return 更新成功 返回Http Status 200
	 */
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonStudent) {

		StudentInfo student = new Gson().fromJson(jsonStudent.toString(),
				StudentInfo.class);
		studentLogic.update(student);

		return Response.ok().build();
	}

	/**
	 * 删除学生信息
	 * 
	 * @author Demon
	 * @param id
	 *            学生id
	 * @return 删除成功 返回Http Status 200
	 */
	@GET
	@Path("deleteById")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteById(@QueryParam("id") @DefaultValue("") String id) {
		studentLogic.deleteById(id);
		return Response.ok().build();
	}

	/**
	 * 分页查询，报名信息查询使用
	 * 
	 * @author Demon
	 * @param trainingProjectId
	 *            培训项目id
	 * @param trainingBatchId
	 *            培训批次id
	 * @param coagencyId
	 *            合作机构id
	 * @param teachingUnitId
	 *            教学点id
	 * @param educationLevelId
	 *            培养类别id
	 * @param specailId
	 *            学科id
	 * @param propertyName
	 *            学生属性名称(取值loginName、credentialNum和realName)
	 * @param value
	 *            学生属性值,对应propertyNum的值
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页大小
	 * @return 学生信息VO 分页模型
	 */
	@GET
	@Path("getStudentByPage")
	@Produces(MediaType.APPLICATION_JSON)
	public PageModel<StudentInfoVO> getStudentByPage(
			@QueryParam("trainingProjectId") @DefaultValue("0") int trainingProjectId,
			@QueryParam("trainingBatchId") @DefaultValue("0") int trainingBatchId,
			@QueryParam("coagencyId") @DefaultValue("") String coagencyId,
			@QueryParam("teachingUnitId") @DefaultValue("") String teachingUnitId,
			@QueryParam("educationLevelId") @DefaultValue("") String educationLevelId,
			@QueryParam("specailId") @DefaultValue("") String specailId,
			@QueryParam("propertyName") @DefaultValue("") String propertyName,
			@QueryParam("value") @DefaultValue("") String value,
			@QueryParam("pageNo") @DefaultValue("1") int pageNo,
			@QueryParam("pageSize") @DefaultValue("20") int pageSize) {
		return studentLogic.getStudentByPage(trainingProjectId,
				trainingBatchId, coagencyId, teachingUnitId, educationLevelId,
				specailId, propertyName, value, pageNo, pageSize);
	}

	/**
	 * 根据id查询学生
	 * 
	 * @param id
	 *            学生id
	 * @return 学生对象
	 */
	@GET
	@Path("getById")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentInfo getById(@QueryParam("id") @DefaultValue("") String id) {
		return studentLogic.getById(id);
	}
}
