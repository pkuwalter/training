package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.nercel.ccnu.edu.dao.StudentInfoDao;
import org.nercel.ccnu.edu.entity.StudentInfoVO;
import org.nercel.ccnu.edu.entity.persist.StudentInfo;
import org.nercel.ccnu.edu.logic.StudentInfoLogic;
import org.nercel.ccnu.edu.util.PageModel;

/**
 * 学生 LogicImpl
 * 
 * @author Demon
 * 
 */
public class StudentInfoLogicImpl implements StudentInfoLogic {

	StudentInfoDao studentDao = new StudentInfoDao();

	/**
	 * 保存学生信息
	 * 
	 * @author Demon
	 * @param student
	 *            学生对象
	 */
	public void save(StudentInfo student) {
		studentDao.save(student);
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
	public StudentInfo findByProperty(String propertyName, String value) {
		return studentDao.findByProperty(propertyName, value);
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
	 */
	public boolean isExistCredentialNum(int trainingProjectId,
			int trainingBatchId, String credentialNum) {
		return studentDao.isExistCredentialNum(trainingProjectId,
				trainingBatchId, credentialNum);
	}

	/**
	 * 更新学生信息
	 * 
	 * @author Demon
	 * @param student
	 *            学生对象
	 */
	public void update(StudentInfo student) {
		studentDao.update(student);
	}

	/**
	 * 删除学生信息
	 * 
	 * @author Demon
	 * @param id
	 *            学生id
	 */
	public void deleteById(String id) {
		studentDao.deleteById(id);
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
	public PageModel<StudentInfoVO> getStudentByPage(int trainingProjectId,
			int trainingBatchId, String coagencyId, String teachingUnitId,
			String educationLevelId, String specailId, String propertyName,
			String value, int pageNo, int pageSize) {

		PageModel<StudentInfoVO> pageModel = new PageModel<StudentInfoVO>();
		// 查询总记录数
		int count = studentDao.getStudentByPage_count(trainingProjectId,
				trainingBatchId, coagencyId, teachingUnitId, educationLevelId,
				specailId, propertyName, value);
		
		// 总记录数不为0，则进行分页查询
		if (count != 0) {
			List<StudentInfoVO> studentList = studentDao.getStudentByPage_list(
					trainingProjectId, trainingBatchId, coagencyId,
					teachingUnitId, educationLevelId, specailId, propertyName,
					value, pageNo, pageSize);
			pageModel.setList(studentList);
		}

		pageModel.setTotalRecords(count);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		
		return pageModel;
	}
	
	/**
	 * 根据id查询学生
	 * @param id 学生id
	 * @return 学生对象
	 */
	public StudentInfo getById(String id){
		return studentDao.getById(id);
	}
}
