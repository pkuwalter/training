package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.nercel.ccnu.edu.util.EntityManagerHelper;

/**
 * Dao基类的支持类(具体实现)
 * 
 * @author Demon
 * 
 * @param <T>
 */
public abstract class BaseDaoSupport<T> {

	public EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 查询所有<对象T>信息
	 * 
	 * @param entityClass
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "hiding" })
	public <T> List<T> getAll(final Class<T> entityClass) {

		List<T> entityList = new ArrayList<T>();

		try {
			CriteriaQuery criteriaQuery = getEntityManager()
					.getCriteriaBuilder().createQuery(entityClass);

			Root<T> root = criteriaQuery.from(entityClass);

			entityList = getEntityManager().createQuery(criteriaQuery)
					.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
			System.out.println("查询所有 " + entityClass + " 失败!");
		} finally {
			getEntityManager().close();
		}
		return entityList;
	}

	/**
	 * 根据id查询对象
	 * 
	 * @param entityClass
	 * @param id
	 *            对象id(主键)
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T> T getById(final Class<T> entityClass, final Object id) {
		T object = getEntityManager().find(entityClass, id);
		return object;
	}

	/**
	 * 根据id删除对象
	 * 
	 * @param entityClass
	 * @param id
	 *            对象id
	 */
	public void deleteById(final Class<T> entityClass, Object id) {
		delete(getById(entityClass, id));
	}

	/**
	 * 删除对象
	 * 
	 * @param entityClass
	 * @param id
	 */
	public void delete(final T entityClass) {

		EntityTransaction tran = getEntityManager().getTransaction();
		try {
			tran.begin();
			getEntityManager().remove(entityClass);
			tran.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
			System.out.println("删除 " + entityClass + " 失败!");
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 保存对象
	 * 
	 * @param entityClass
	 */
	public void save(final T entityClass) {

		EntityTransaction tran = getEntityManager().getTransaction();
		try {
			tran.begin();
			getEntityManager().persist(entityClass);
			tran.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
			System.out.println("保存 " + entityClass + " 失败!");
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 更新对象
	 * 
	 * @param entityClass
	 */
	public void update(final T entityClass) {

		EntityTransaction tran = getEntityManager().getTransaction();
		try {
			tran.begin();
			getEntityManager().merge(entityClass);
			tran.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
			System.out.println("更新 " + entityClass + " 失败!");
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据属性查询对象(用于查询属性唯一的对象)
	 * 
	 * @param entityClass
	 *            需要查询的对象类名(=Object.class)
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 单一对象
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "hiding" })
	public <T> T findByProperty(final Class<T> entityClass,
			String propertyName, Object value) {

		T object = null;

		try {

			// 创建CriteriaQuery查询
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery criteriaQuery = criteriaBuilder
					.createQuery(entityClass);

			// 拼接from条件(结果：from Object)
			Root<T> root = criteriaQuery.from(entityClass);

			// 拼接where条件 (结果：where propertyName=value)
			Predicate condition = criteriaBuilder.equal(root.get(propertyName),
					value);
			criteriaQuery.where(condition);

			// 返回唯一结果
			object = (T) getEntityManager().createQuery(criteriaQuery)
					.getSingleResult();

		} catch (NoResultException ne) {
			System.out.println("dao.findByProperty():没有查询到propertyName:"
					+ propertyName + "=" + value + " " + entityClass.getName());
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return object;
	}
}
