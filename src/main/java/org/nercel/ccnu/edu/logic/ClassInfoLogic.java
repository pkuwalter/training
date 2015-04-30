package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.persist.ClassInfo;

/**
 * 班级Logic
 * 
 * @author Demon
 * 
 */
public interface ClassInfoLogic {

	/**
	 * 查询所有班级信息
	 * 
	 * @return
	 */
	public List<ClassInfo> getAll();

	/**
	 * 根据id查询班级
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public ClassInfo getById(int id);

	/**
	 * 保存班级
	 * 
	 * @param classInfo
	 *            班级对象
	 */
	public void save(ClassInfo classInfo);

	/**
	 * 更新班级
	 * 
	 * @param classInfo
	 *            班级对象
	 */
	public void update(ClassInfo classInfo);

	/**
	 * 根据删除班级
	 * 
	 * @param id
	 *            班级id
	 */
	public void deleteById(int id);
}
