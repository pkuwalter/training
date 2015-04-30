package org.wy.ccnu.edu.dao;

import java.util.List;

import org.wy.ccnu.edu.util.GenericUtils;

/**
 * Dao基类的实现
 * 
 * @author Demon
 * @param <T>
 */
public abstract class BaseDaoImpl<T> extends BaseDaoSupport<T> implements
		BaseDao<T> {

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// getClass() 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。
		entityClass = (Class<T>) GenericUtils.getSuperClassGenricType(
				getClass(), 0);
	}

	/**
	 * 查询所有
	 */
	public List<T> getAll() {
		return getAll(entityClass);
	}

	/**
	 * 根据id查询对象
	 */
	public T getById(Object id) {
		return getById(entityClass, id);
	}

	/**
	 * 根据id删除对象
	 */
	public void deleteById(Object id) {
		deleteById(entityClass, id);
	}

	/**
	 * 根据属性查询对象
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findByProperty(String propertyName, Object value) {
		return findByProperty(entityClass, propertyName, value);
	}

}
