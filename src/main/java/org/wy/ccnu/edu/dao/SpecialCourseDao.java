package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.CourseInfoVO;
import org.wy.ccnu.edu.entity.SpecialCourseVO;
import org.wy.ccnu.edu.entity.persist.CourseInfo;
import org.wy.ccnu.edu.entity.persist.SpecialCourse;
import org.wy.ccnu.edu.util.EntityManagerHelper;

public class SpecialCourseDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 增加学科课程
	 * 
	 * @param entity
	 */
	public void save(SpecialCourse entity) {

		try {
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			//throw re;
		} finally {
			getEntityManager().close();
		}

	}

	/**
	 * 删除学科课程
	 * 
	 * @param entity
	 */
	public void delete(SpecialCourse entity) {

		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(SpecialCourse.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	/**
	 * 修改学科课程信息
	 * 
	 * @param entity
	 */
	public void update(SpecialCourse entity) {

		try {
			EntityManagerHelper.beginTransaction();
			getEntityManager().merge(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

	}

	/**
	 * 获取学科课程信息的最大的Id
	 * 
	 * @return
	 */
	public int getMaxSpecialCourseId() {
		try {

			final String queryString = "select max(model.id) from SpecialCourse model where 1=1";
			Query query = getEntityManager().createQuery(queryString);

			Integer maxId = (Integer) query.getSingleResult();

			return maxId == null ? 0 : maxId;

		} catch (RuntimeException re) {
			throw re;
		}

	}

	/**
	 * 获取所有学科课程的列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialCourse> getAllSpecialCourse() {
		List<SpecialCourse> result = new ArrayList<SpecialCourse>();
		try {
			String queryString = "select model from SpecialCourse model where 1=1";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<SpecialCourse>) query.getResultList();
			return result;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据学科课程ID获取学科课程信息
	 * 
	 * @param specialCourseId
	 * @return
	 */
	public SpecialCourse getSpecialCourseById(int specialCourseId) {
		try {
			SpecialCourse instance = getEntityManager().find(
					SpecialCourse.class, specialCourseId);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据SpecialCourse的属性来查找学科课程信息
	 * 
	 * @param property课程属性
	 * @param proValue属性的值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public SpecialCourse getSpecialCourseByProperty(String property,
			String proValue) {
		String queryString = "from SpecialCourse model where model." + property
				+ " = '" + proValue + "'";
		SpecialCourse courseInfo = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			List list = query.getResultList();
			if (!list.toString().equals("[]")) {
				courseInfo = (SpecialCourse) list.get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return courseInfo;
	}

	/**
	 * 批量删除学科课程信息
	 * 
	 * @param SpecialCourseIds
	 * @return
	 * @throws JSONException
	 */
	public boolean batchDeleteSpecialCourse(JSONObject SpecialCourseIds)
			throws JSONException {
		
		StringBuilder queryString = new StringBuilder();
		for (int i = 0; i < SpecialCourseIds.length(); i++) {
			queryString.append("?");
			if (i < (SpecialCourseIds.length() - 1)) {
				queryString.append(",");
			}
		}
		String sql = "delete SpecialCourse where id in ( "
				+ queryString.toString() + ")";
		Query query = null;
		try {
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for (int i = 0; i < SpecialCourseIds.length(); i++) {
				query.setParameter(i + 1,
						Integer.parseInt(SpecialCourseIds.getString(i + "")));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
			return true;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}


	/**
	 * 条件查询：获取学科课程管理的详细信息-分页查询
	 * 
	 * @param specialId
	 *            专业id
	 * @param courseName
	 *            课程名称（内部）（模糊查询）
	 * @param examTypeCode
	 *            考试方式
	 * @param courseTypeCode
	 *            课程类别
	 * @param courseClassCode
	 *            课程课类
	 * @param stage
	 *            学习阶段（开课学期）
	 * @param scale
	 *            适用对象（模糊查询）
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CourseInfoVO> getAllSpecialCourseInfoVOInPage(String specialId,
			String courseName, String examTypeCode, String courseTypeCode,
			String courseClassCode, String stage, String scale, int pageNo,
			int pageSize) {

		List<CourseInfoVO> list = new ArrayList<CourseInfoVO>();


		String basicString = "select new org.wy.ccnu.edu.entity.CourseInfoVO("
				+ "specialCourse.id,courseInfo.id,courseinfo.courseCode,courseInfo.courseName,coursetype.courseTypeName,"
				+ "courseInfo.credit,"
				+ "courseInfo.learningTime,examType.examTypeName,courseClass.courseClassName,specialCourse.remark) "
				+ "from CourseInfo courseInfo,CourseType courseType,"
				+ "ExamType examType,CourseClass courseClass,SpecialCourse specialCourse,Special special "
				+ "where courseInfo.examTypeCode = examType.examTypeCode "
				+ "and courseInfo.courseClassCode = courseClass.courseClassCode and "
				+ "courseInfo.courseTypeCode = courseType.courseTypeCode and specialCourse.courseId = courseInfo.id and specialCourse.specialId = special.id ";

		StringBuilder queryString = new StringBuilder(basicString);

		if (specialId != null && !specialId.trim().equals("")
				&& !specialId.equals("null")) {

			queryString.append(" and specialCourse.specialId = :specialId");
		}
		if (courseName != null && !courseName.trim().equals("")
				&& !courseName.equals("null")) {

			queryString.append(" and courseInfo.courseName like :courseName");
		}

		if (examTypeCode != null && !examTypeCode.trim().equals("")
				&& !examTypeCode.equals("null")) {

			queryString.append(" and courseInfo.examTypeCode = :examTypeCode");
		}

		if (courseTypeCode != null && !courseTypeCode.trim().equals("")
				&& !courseTypeCode.equals("null")) {

			queryString
					.append(" and courseInfo.courseTypeCode = :courseTypeCode");
		}

		if (courseClassCode != null && !courseClassCode.trim().equals("")
				&& !courseClassCode.equals("null")) {

			queryString
					.append(" and courseInfo.courseClassCode = :courseClassCode");
		}

		/*
		 * if (stage != null && !stage.trim().equals("") &&
		 * !stage.equals("null")) {
		 * 
		 * queryString.append(" and trainingCourseInfo.stage = :stage"); }
		 * 
		 * if (scale != null && !scale.trim().equals("") &&
		 * !scale.equals("null")) {
		 * 
		 * queryString.append(" and trainingCourseInfo.scales like :scale"); }
		 */

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (specialId != null && !specialId.trim().equals("")
					&& !specialId.equals("null")) {

				query.setParameter("specialId", specialId);
			}
			if (courseName != null && !courseName.trim().equals("")
					&& !courseName.equals("null")) {

				query.setParameter("courseName", "%" + courseName + "%");
			}

			if (examTypeCode != null && !examTypeCode.trim().equals("")
					&& !examTypeCode.equals("null")) {
				query.setParameter("examTypeCode", examTypeCode);
			}

			if (courseTypeCode != null && !courseTypeCode.trim().equals("")
					&& !courseTypeCode.equals("null")) {
				query.setParameter("courseTypeCode", courseTypeCode);
			}

			if (courseClassCode != null && !courseClassCode.trim().equals("")
					&& !courseClassCode.equals("null")) {
				query.setParameter("courseClassCode", courseClassCode);

			}

			/*
			 * if (stage != null && !stage.trim().equals("") &&
			 * !stage.equals("null")) { query.setParameter("stage", stage); }
			 * 
			 * if (scale != null && !scale.trim().equals("") &&
			 * !scale.equals("null")) {
			 * 
			 * query.setParameter("scale", "%" + scale + "%"); }
			 */

			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = (List<CourseInfoVO>) query.getResultList();
			if (list.size() == 0) {
				list = null;
			}
			return list;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 条件查询：获取学科课程管理的详细信息的总记录数
	 * 
	 * @param specialId
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @return
	 */
	public int getTotalSpecialCourseInfoVO(String specialId, String courseName,
			String examTypeCode, String courseTypeCode, String courseClassCode,
			String stage, String scale) {
		int total = 0;

		String basicString = "select count(*) "
				+ "from CourseInfo courseInfo,CourseType courseType,"
				+ "ExamType examType,CourseClass courseClass,SpecialCourse specialCourse,Special special "
				+ "where courseInfo.examTypeCode = examType.examTypeCode "
				+ "and courseInfo.courseClassCode = courseClass.courseClassCode and "
				+ "courseInfo.courseTypeCode = courseType.courseTypeCode and specialCourse.courseId = courseInfo.id and specialCourse.specialId = special.id ";
		StringBuilder queryString = new StringBuilder(basicString);

		if (specialId != null && !specialId.trim().equals("")
				&& !specialId.equals("null")) {

			queryString.append(" and specialCourse.specialId = :specialId");
		}
		if (courseName != null && !courseName.trim().equals("")
				&& !courseName.equals("null")) {

			queryString.append(" and courseInfo.courseName like :courseName");
		}

		if (examTypeCode != null && !examTypeCode.trim().equals("")
				&& !examTypeCode.equals("null")) {

			queryString.append(" and courseInfo.examTypeCode = :examTypeCode");
		}

		if (courseTypeCode != null && !courseTypeCode.trim().equals("")
				&& !courseTypeCode.equals("null")) {

			queryString
					.append(" and courseInfo.courseTypeCode = :courseTypeCode");
		}

		if (courseClassCode != null && !courseClassCode.trim().equals("")
				&& !courseClassCode.equals("null")) {

			queryString
					.append(" and courseInfo.courseClassCode = :courseClassCode");
		}

		/*
		 if (stage != null && !stage.trim().equals("") &&
		  !stage.equals("null")) {
		  
		  queryString.append(" and trainingCourseInfo.stage = :stage"); }
		  
		  if (scale != null && !scale.trim().equals("") &&
		  !scale.equals("null")) {
		  
		  queryString.append(" and trainingCourseInfo.scales like :scale"); }
		 */

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (specialId != null && !specialId.trim().equals("")
					&& !specialId.equals("null")) {

				query.setParameter("specialId", specialId);
			}
			if (courseName != null && !courseName.trim().equals("")
					&& !courseName.equals("null")) {

				query.setParameter("courseName", "%" + courseName + "%");
			}

			if (examTypeCode != null && !examTypeCode.trim().equals("")
					&& !examTypeCode.equals("null")) {
				query.setParameter("examTypeCode", examTypeCode);
			}

			if (courseTypeCode != null && !courseTypeCode.trim().equals("")
					&& !courseTypeCode.equals("null")) {
				query.setParameter("courseTypeCode", courseTypeCode);
			}

			if (courseClassCode != null && !courseClassCode.trim().equals("")
					&& !courseClassCode.equals("null")) {
				query.setParameter("courseClassCode", courseClassCode);

			}

			/*
			 * if (stage != null && !stage.trim().equals("") &&
			 * !stage.equals("null")) { query.setParameter("stage", stage); }
			 * 
			 * if (scale != null && !scale.trim().equals("") &&
			 * !scale.equals("null")) {
			 * 
			 * query.setParameter("scale", "%" + scale + "%"); }
			 */

			if (query.getSingleResult() != null) {
				total = Integer.parseInt(query.getSingleResult().toString());
			}

		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

		return total;

	}
	

	
	/**
	 * 根据专业id获取课程id与课程名称列表
	 * @param specialId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialCourseVO> getSpecialCourseVOListBySpecialId(String specialId) {
		
		List<SpecialCourseVO> result = new ArrayList<SpecialCourseVO>();
		try {
			String queryString = "select new org.wy.ccnu.edu.entity.SpecialCourseVO(courseInfo.id,courseInfo.courseName) from SpecialCourse specialCourse,CourseInfo courseInfo where specialCourse.courseId = courseInfo.id and specialCourse.specialId = :specialId";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("specialId", specialId);
			result = (List<SpecialCourseVO>) query.getResultList();
			return result;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}
	

/**
 * 根据专业id和课程id获取学科课程
 * @param specialId
 * @param courseId
 * @return
 */
	@SuppressWarnings("rawtypes")
	public SpecialCourse getSpecialCourseBySpecialIdAndCourseId(String specialId,
			int courseId) {
		
		String queryString = "select model from SpecialCourse model where model.specialId = :specialId and model.courseId = :courseId"; 
		
		SpecialCourse specialCourse = null;
		try {
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("specialId", specialId);
			query.setParameter("courseId", courseId);

			List list = query.getResultList();
			if (!list.toString().equals("[]")) {
				specialCourse = (SpecialCourse) list.get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		return specialCourse;
	}
	
	/**
	 * 根据专业id列表获取课程列表
	 * @param specialIds
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CourseInfo> getCourseInfoListBySpecialIds(String specialIds){
		
		
		List<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
	
		
		String queryBasic = "select distinct courseInfo from CourseInfo courseInfo,SpecialCourse specialCourse" +
				" where courseInfo.id = specialCourse.courseId and specialCourse.specialId in ('"+specialIds.replace(",", "','")+"')";
		

		try{
			Query query = getEntityManager().createQuery(queryBasic);
	
			courseInfoList = (List<CourseInfo>) query.getResultList();
			if (courseInfoList.size() == 0) {
				courseInfoList = null;
			}
			return courseInfoList;
		}catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
		

	}
	
}
