package org.wy.ccnu.edu.logic;

import org.wy.ccnu.edu.entity.TeacherInfoVO;
import org.wy.ccnu.edu.entity.persist.TeacherInfo;
import org.wy.ccnu.edu.util.PageModel;

/**
 * 教师Logic
 * 
 * @author Demon
 * 
 */
public interface TeacherInfoLogic {

	/**
	 * 保存教师
	 * 
	 * @author Demon
	 * @param teacher
	 *            教师对象
	 */
	public void save(TeacherInfo teacher);

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
	public TeacherInfo findByProperty(String propertyName, String value);

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
	public PageModel<TeacherInfoVO> getTeacherInfoByPage(int teacherTypeId,
			int status, String coagencyId, String teachingUnitId, String propertyName,
			String value, String teacherOrigin, int pageNo, int pageSize);

	/**
	 * 根据id删除教师对象
	 * 
	 * @author Demon
	 * @param id
	 *            教师id
	 */
	public void deleteById(int id);

	/**
	 * 更新教师的状态
	 * 
	 * @author Demon
	 * @param id
	 *            教师Id
	 * @param status
	 *            状态(1:启用,0:停用)
	 */
	public void updateStatus(int id, int status);

	/**
	 * 根据id查询教师
	 * 
	 * @author Demon
	 * @param id
	 *            教师id
	 * @return 教师对象
	 */
	public TeacherInfo getById(int id);

	/**
	 * 更新教师信息
	 * 
	 * @author Demon
	 * @param teacher
	 *            教师对象
	 */
	public void update(TeacherInfo teacher);

}
