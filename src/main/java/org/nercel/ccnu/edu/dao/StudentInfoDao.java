package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nercel.ccnu.edu.entity.StudentInfoVO;
import org.nercel.ccnu.edu.entity.persist.StudentInfo;
import org.nercel.ccnu.edu.util.PageModel;

/**
 * 学生信息 Dao
 * 
 * @author Demon
 * 
 */
public class StudentInfoDao extends BaseDaoImpl<StudentInfo> {

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

		// flag(存在:true;不存在:false),默认为已存在
		boolean flag = true;
		try {
			String sql = "from StudentInfo where trainingProjectId=:trainingProjectId "
					+ " and trainingBatchId=:trainingBatchId "
					+ " and credentialNum=:credentialNum ";

			Query query = getEntityManager().createQuery(sql);
			query.setParameter("trainingProjectId", trainingProjectId);
			query.setParameter("trainingBatchId", trainingBatchId);
			query.setParameter("credentialNum", credentialNum);
			if (query.getResultList().size() == 0) {
				flag = false;
			}
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return flag;
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
	 * @return 学生信息VO 当前页list
	 */
	public List<StudentInfoVO> getStudentByPage_list(int trainingProjectId,
			int trainingBatchId, String coagencyId, String teachingUnitId,
			String educationLevelId, String specailId, String propertyName,
			String value, int pageNo, int pageSize) {

		List<StudentInfoVO> studentList = new ArrayList<StudentInfoVO>();
		try {
			String sql = "select new org.wy.ccnu.edu.entity.StudentInfoVO( "
					+ " stu.id, stu.realName, stu.credentialNum, "
					+ " stu.coagencyId, coagency.coagencyName, "
					+ " stu.teachingUnitId, teachingUnit.teachingUnitName, "
					+ " stu.trainingProjectId, project.trainingProjectName, "
					+ " stu.trainingBatchId, batch.trainingBatchName, "
					+ " stu.educationLevelId, level.educationLevelName, "
					+ " stu.specialId,special.specialName, "
					+ " stu.registration_status, stu.validation_status, stu.enroll_status) "
					+ " from StudentInfo stu , TrainingProjectInfo project , "
					+ " TrainingBatch batch , Coagency coagency, TeachingUnitInfo teachingUnit, "
					+ " EducationLevel level , Special special "
					+ " where stu.trainingProjectId = project.id "
					+ " and stu.trainingBatchId = batch.id "
					+ " and stu.coagencyId = coagency.id "
					+ " and stu.teachingUnitId = teachingUnit.id "
					+ " and stu.educationLevelId = level.id "
					+ " and stu.specialId = special.id ";
			if (!value.equals("")) {
				sql += " and stu." + propertyName + " like ?";
			} else {
				if (trainingProjectId != 0) {
					sql += " and stu.trainingProjectId = :trainingProjectId ";
				}
				if (trainingBatchId != 0) {
					sql += " and stu.trainingBatchId = :trainingBatchId ";
				}
				if (!coagencyId.equals("")) {
					sql += " and stu.coagencyId = :coagencyId ";
				}
				if (!teachingUnitId.equals("")) {
					sql += " and stu.teachingUnitId = :teachingUnitId ";
				}
				if (!educationLevelId.equals("")) {
					sql += " and stu.educationLevelId = :educationLevelId ";
				}
				if (!specailId.equals("")) {
					sql += " and stu.specialId = :specialId";
				}
			}
			
			Query query = getEntityManager().createQuery(sql);
			if (!value.equals("")) {
				query.setParameter(1, "%" + value + "%");
			} else {
				if (trainingProjectId != 0) {
					query.setParameter("trainingProjectId", trainingProjectId);
				}
				if (trainingBatchId != 0) {
					query.setParameter("trainingBatchId", trainingBatchId);
				}
				if (!coagencyId.equals("")) {
					query.setParameter("coagencyId", coagencyId);
				}
				if (!teachingUnitId.equals("")) {
					query.setParameter("teachingUnitId", teachingUnitId);
				}
				if (!educationLevelId.equals("")) {
					query.setParameter("educationLevelId", educationLevelId);
				}
				if (!specailId.equals("")) {
					query.setParameter("specailId", specailId);
				}
			}
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			studentList = query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return studentList;
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
	 * @return 学生信息VO 总记录数
	 */
	public int getStudentByPage_count(int trainingProjectId,
			int trainingBatchId, String coagencyId, String teachingUnitId,
			String educationLevelId, String specailId, String propertyName,
			String value) {

		int count = 0;
		try {
			String sql = "select count(*) from StudentInfo stu where 1 = 1 ";
			if (!value.equals("")) {
				sql += " and stu." + propertyName + " like ?";
			} else {
				if (trainingProjectId != 0) {
					sql += " and stu.trainingProjectId = :trainingProjectId ";
				}
				if (trainingBatchId != 0) {
					sql += " and stu.trainingBatchId = :trainingBatchId ";
				}
				if (!coagencyId.equals("")) {
					sql += " and stu.coagencyId = :coagencyId ";
				}
				if (!teachingUnitId.equals("")) {
					sql += " and stu.teachingUnitId = :teachingUnitId ";
				}
				if (!educationLevelId.equals("")) {
					sql += " and stu.educationLevelId = :educationLevelId ";
				}
				if (!specailId.equals("")) {
					sql += " and stu.specialId = :specialId";
				}
			}
			Query query = getEntityManager().createQuery(sql);
			if (!value.equals("")) {
				query.setParameter(1, "%" + value + "%");
			} else {
				if (trainingProjectId != 0) {
					query.setParameter("trainingProjectId", trainingProjectId);
				}
				if (trainingBatchId != 0) {
					query.setParameter("trainingBatchId", trainingBatchId);
				}
				if (!coagencyId.equals("")) {
					query.setParameter("coagencyId", coagencyId);
				}
				if (!teachingUnitId.equals("")) {
					query.setParameter("teachingUnitId", teachingUnitId);
				}
				if (!educationLevelId.equals("")) {
					query.setParameter("educationLevelId", educationLevelId);
				}
				if (!specailId.equals("")) {
					query.setParameter("specailId", specailId);
				}
			}
			count = Integer.parseInt(query.getSingleResult().toString());
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getEntityManager().close();
		}
		return count;
	}
}
