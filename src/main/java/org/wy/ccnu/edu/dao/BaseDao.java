package org.wy.ccnu.edu.dao;

import java.util.List;
import java.util.Map;

/**
 * Dao基类
 * 
 * @author Demon
 * 
 * @param <T>
 */
public interface BaseDao<T> {


	/**
	 * 查询所有
	 * 
	 * @return 对象列表
	 */
	List<T> getAll();
	
	/**
	 * 根据id查询信息
	 * 
	 * @param id
	 *            对象id
	 * @return 对象
	 */
	T getById(Object id);

	/**
	 * 保存对象
	 * @param entityClass
	 */
	void save(T entityClass);

	/**
	 * 更新对象
	 * @param entityClass
	 */
	void update(T entityClass);

	/**
	 * 删除对象
	 * @param entityClass
	 */
	void delete(T entityClass);

	/**
	 * 根据id删除对象
	 * @param id
	 */
	void deleteById(Object id);
	
	/**
	 * 根据属性查询对象
	 * @param property 属性名称
	 * @param value 属性值
	 */
	T findByProperty(String propertyName,Object value);
	
}
