package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.wy.ccnu.edu.entity.TeacherInfoVO;
import org.wy.ccnu.edu.entity.persist.TeacherInfo;
import org.wy.ccnu.edu.util.EntityManagerHelper;
import org.wy.ccnu.edu.util.PageModel;

/**
 * 教师Dao
 * 
 * @author Demon
 * 
 */
public class TeacherInfoDao extends BaseDaoImpl<TeacherInfo> {

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
			int status, String coagencyId, String teachingUnitId,
			String propertyName, String value, String teacherOrigin,
			int pageNo, int pageSize) {

		PageModel<TeacherInfoVO> pageModel = new PageModel<TeacherInfoVO>();
		// 设置当前页码和每页记录数
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);

		String sql = "";

		// 当合作机构为空的时候，根据本校和外校来筛选
		if (coagencyId.equals("")) {
			// 本校则筛选合作机构为空的教师
			if (teacherOrigin.equals("本校")) {
				sql = " from TeacherInfo teacher, TeachingUnitInfo teachingUnit , "
						+ " TeacherType type , AcademicTitle academicTitle "
						+ " where teacher.coagencyId = '' "
						+ " and teacher.teachingUnitId = teachingUnit.id "
						+ " and teacher.teacherTypeId = type.id "
						+ " and teacher.academicTitleId = academicTitle.id ";
			} else {
				// 外校取合作机构不为空的教师
				sql = " from TeacherInfo teacher , Coagency agency , "
						+ " TeachingUnitInfo teachingUnit , TeacherType type ,"
						+ " AcademicTitle academicTitle "
						+ " where teacher.coagencyId = agency.id "
						+ " and teacher.teachingUnitId = teachingUnit.id "
						+ " and teacher.teacherTypeId = type.id "
						+ " and teacher.academicTitleId = academicTitle.id ";
			}
		} else {
			sql = " from TeacherInfo teacher , Coagency agency , "
					+ " TeachingUnitInfo teachingUnit , TeacherType type ,"
					+ " AcademicTitle academicTitle ,"
					+ " where teacher.coagencyId = :coagencyId "
					+ " and teacher.coagencyId = agency.id "
					+ " and teacher.teachingUnitId = teachingUnit.id "
					+ " and teacher.teacherTypeId = type.id "
					+ " and teacher.academicTitleId = academicTitle.id ";
		}
		// 如果提供了教师(用户名或姓名)则优先按照此条件查询
		if (!value.equals("")) {
			sql += " and teacher." + propertyName + " like ? ";
		}
		if (teacherTypeId != -1) {
			sql += " and teacher.teacherTypeId = :teacherTypeId ";
		}
		if (!teachingUnitId.equals("")) {
			sql += " and teacher.teachingUnitId = :teachingUnitId ";
		}
		if (status != -1) {
			sql += " and teacher.status= :status";
		}
		// 拼接查询总记录数
		String sql_count = "select count(*) " + sql;

		System.out.println(sql_count);

		try {
			Query query = getEntityManager().createQuery(sql_count);
			if (!coagencyId.equals("")) {
				query.setParameter("coagencyId", coagencyId);
			}
			if (!value.equals("")) {
				query.setParameter(1, "%" + value + "%");
			}
			if (teacherTypeId != -1) {
				query.setParameter("teacherTypeId", teacherTypeId);
			}
			if (!teachingUnitId.equals("")) {
				query.setParameter("teachingUnitId", teachingUnitId);
			}
			if (status != -1) {
				query.setParameter("status", status);
			}
			// 获取总记录数
			int totalRecord = Integer.parseInt(query.getSingleResult()
					.toString());

			// 如果总记录数为0则不继续查询分页记录
			if (totalRecord != 0) {
				String sql_list = " select new org.wy.ccnu.edu.entity.TeacherInfoVO("
						+ " teacher.id, teacher.name, teacher.loginName, teacher.sex, "
						+ " type.teacherTypeName , teacher.departName, teacher.mobilePhone, "
						+ " agency.id, agency.coagencyName, teachingUnit.id, "
						+ " teachingUnit.teachingUnitName, teacher.status, "
						+ " academicTitle.name, teacher.email, type.id, teacher.qq) "
						+ sql;

				// 当查询本校的时候则给coagencyId和coagencyName赋""
				if (coagencyId.equals("")) {
					if (teacherOrigin.equals("本校")) {
						sql_list = " select new org.wy.ccnu.edu.entity.TeacherInfoVO("
								+ " teacher.id, teacher.name, teacher.loginName, teacher.sex, "
								+ " type.teacherTypeName , teacher.departName, teacher.mobilePhone, "
								+ " '', '', teachingUnit.id, "
								+ " teachingUnit.teachingUnitName, teacher.status, "
								+ " academicTitle.name, teacher.email, type.id, teacher.qq) "
								+ sql;
					}
				}

				System.out.println(sql_list);

				query = getEntityManager().createQuery(sql_list);
				if (!coagencyId.equals("")) {
					query.setParameter("coagencyId", coagencyId);
				}
				if (!value.equals("")) {
					query.setParameter(1, "%" + value + "%");
				}
				if (teacherTypeId != -1) {
					query.setParameter("teacherTypeId", teacherTypeId);
				}
				if (!teachingUnitId.equals("")) {
					query.setParameter("teachingUnitId", teachingUnitId);
				}
				if (status != -1) {
					query.setParameter("status", status);
				}

				// 设置分页参数
				query.setFirstResult((pageNo - 1) * pageSize);
				query.setMaxResults(pageSize);

				// 分页模型设置当前页记录
				pageModel.setList(query.getResultList());
				// 分页模型总记录数
				pageModel.setTotalRecords(totalRecord);
			}
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return pageModel;
	}

	/**
	 * 更新教师的状态
	 * 
	 * @param id
	 *            教师Id
	 * @param status
	 *            状态(1:启用,0:停用)
	 */
	public void updateStatus(int id, int status) {

		EntityTransaction tran = getEntityManager().getTransaction();

		try {
			String sql = "update TeacherInfo set status=:status where id=:id";
			tran.begin();

			Query query = getEntityManager().createQuery(sql);
			query.setParameter("status", status);
			query.setParameter("id", id);
			query.executeUpdate();
			tran.commit();
		} catch (RuntimeException re) {
			tran.rollback();
		} finally {
			getEntityManager().close();
		}
	}
}
