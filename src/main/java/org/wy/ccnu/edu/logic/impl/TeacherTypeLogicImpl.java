package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.wy.ccnu.edu.dao.TeacherTypeDao;
import org.wy.ccnu.edu.entity.persist.TeacherType;
import org.wy.ccnu.edu.logic.TeacherTypeLogic;

/**
 * 教师类别 LogicImpl
 * 
 * @author Demon
 */
public class TeacherTypeLogicImpl implements TeacherTypeLogic {

	private TeacherTypeDao teacherTypeDao = new TeacherTypeDao();

	/**
	 * 查询所有教师列表
	 * 
	 * @author Demon
	 * @return 教师List
	 */
	public List<TeacherType> getAll() {
		return teacherTypeDao.getAll();
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
	public TeacherType findByProperty(String propertyName, String value) {
		return teacherTypeDao.findByProperty(propertyName, value);
	}

	/**
	 * 保存教师类别
	 * 
	 * @author Demon
	 * @param teacherType
	 *            教师类别对象
	 */
	public void save(TeacherType teacherType) {
		teacherTypeDao.save(teacherType);
	}

	/**
	 * 更新教师类别
	 * 
	 * @author Demon
	 * @param teacherType
	 *            教师类别对象
	 */
	public void update(TeacherType teacherType) {
		teacherTypeDao.update(teacherType);
	}

	/**
	 * 根据id查询教师类别
	 * 
	 * @author Demon
	 * @param id
	 *            教师类别id
	 * @return 教师类别对象
	 */
	public TeacherType getById(int id) {
		return teacherTypeDao.getById(id);
	}

	/**
	 * 根据id删除教师类别
	 * 
	 * @author Demon
	 * @param id
	 *            教师类别id
	 */
	public void deleteById(int id) {
		teacherTypeDao.deleteById(id);
	}

}
