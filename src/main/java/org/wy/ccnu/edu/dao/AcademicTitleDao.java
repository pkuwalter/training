package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.wy.ccnu.edu.entity.AcademicTitleVO;
import org.wy.ccnu.edu.entity.persist.AcademicTitle;

/**
 * 职称 Dao
 * 
 * @author Demon
 */
public class AcademicTitleDao extends BaseDaoImpl<AcademicTitle> {

	/**
	 * 根据职业id查询职称
	 * @author Demon
	 * @param careerId 职业id
	 * @return 职业-职称VO 列表
	 */
	public List<AcademicTitleVO> getByCareerId(String careerId) {

		List<AcademicTitleVO> academicTitleVOList = new ArrayList<AcademicTitleVO>();
		try {
			String sql = "select new org.wy.ccnu.edu.entity.AcademicTitleVO(academicTitle.id,"
					+ " academicTitle.name,career.id,career.career) "
					+ " from AcademicTitle academicTitle,CareerInfo career "
					+ " where academicTitle.careerId = career.id "
					+ " and academicTitle.careerId = :careerId ";

			Query query = getEntityManager().createQuery(sql);
			query.setParameter("careerId", careerId);
			academicTitleVOList = query.getResultList();
			
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return academicTitleVOList;
	}
}
