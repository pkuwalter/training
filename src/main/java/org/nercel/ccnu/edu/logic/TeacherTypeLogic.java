package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.persist.TeacherType;

/**
 * 教师类别Logic
 * @author Demon
 *
 */
public interface TeacherTypeLogic {

	/**
	 * 查询所有教师列表
	 * @author Demon
	 * @return 教师List
	 */
	public List<TeacherType> getAll();

	/**
	 * 根据属性查询教师类别
	 * @author Demon
	 * @param propertyName 属性名称
	 * @param value 属性值
	 * @return 教师类别
	 */
	public TeacherType findByProperty(String propertyName,String value);
	
	/**
	 * 保存教师类别
	 * @author Demon
	 * @param teacherType 教师类别对象
	 */
	public void save(TeacherType teacherType);
	
	/**
	 * 更新教师类别
	 * @author Demon
	 * @param teacherType 教师类别对象
	 */
	public void update(TeacherType teacherType);
	
	/**
	 * 根据id查询教师类别
	 * @author Demon
	 * @param id 教师类别id
	 * @return 教师类别对象
	 */
	public TeacherType getById(int id);
	
	/**
	 * 删除教师类别对象
	 * @author Demon
	 * @param id 教师类别id
	 */
	public void deleteById(int id);
	
}
