package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.nercel.ccnu.edu.entity.AcademicTitleVO;
import org.nercel.ccnu.edu.entity.persist.AcademicTitle;

/**
 * 职称 Logic
 * @author Demon
 *
 */
public interface AcademicTitleLogic {

	/**
	 * 保存职称
	 * @author Demon
	 * @param academicTitle 职称对象
	 */
	public void save(AcademicTitle academicTitle);
	
	/**
	 * 根据id查询职称
	 * @author Demon
	 * @param id 职称id
	 * @return 职称对象
	 */
	public AcademicTitle getById(int id);
	
	/**
	 * 根据属性查询职称
	 * @author Demon
	 * @param propertyName 属性名称
	 * @param value 属性值
	 * @return 职称对象
	 */
	public AcademicTitle findByProperty(String propertyName,String value);
	
	/**
	 * 根据职业id查询职称
	 * @author Demon
	 * @param careerId 职业id
	 * @return 职业-职称VO 列表
	 */
	public List<AcademicTitleVO> getByCareerId(String careerId);
	
	/**
	 * 根据职称id删除职称
	 * @author Demon
	 * @param id 职称id
	 */
	public void deleteById(int id);
	
	/**
	 * 更新职称
	 * @author Demon
	 * @param academicTitle 职称对象
	 */
	public void update(AcademicTitle academicTitle);
}
