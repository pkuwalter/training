package org.nercel.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.CourseInfoVO;
import org.nercel.ccnu.edu.entity.persist.CourseInfo;
import org.nercel.ccnu.edu.util.EntityManagerHelper;

public class CourseInfoDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 增加课程
	 * 
	 * @param entity
	 */
	public void save(CourseInfo entity) {

		try {
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}

	}

	/**
	 * 删除课程
	 * 
	 * @param entity
	 */
	public void delete(CourseInfo entity) {

		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(CourseInfo.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	/**
	 * 修改课程信息
	 * 
	 * @param entity
	 */
	public void update(CourseInfo entity) {

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
	 * 获取课程信息的最大的Id
	 * @return
	 */
	public int getMaxCourseInfoId(){
		try {
			
					
			final String queryString = "select max(model.id) from CourseInfo model where 1=1";
			Query query = getEntityManager().createQuery(queryString);		
			
            Integer maxId = (Integer) query.getSingleResult();
			
			return  maxId==null?0:maxId;	
							
		} catch (RuntimeException re) {
			throw re;
		}
		
		
	}

	/**
	 * 获取所有课程的列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CourseInfo> getAllCourseInfo() {
		List<CourseInfo> result = new ArrayList<CourseInfo>();
		try {
			String queryString = "select model from CourseInfo model where 1=1 order by courseCode asc";
			Query query = getEntityManager().createQuery(queryString);
			result = (List<CourseInfo>) query.getResultList();
			return result;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据课程ID获取课程信息
	 * 
	 * @param CourseId
	 * @return
	 */
	public CourseInfo getCourseInfoById(int courseId) {
		try {
			CourseInfo instance = getEntityManager().find(CourseInfo.class,
					courseId);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据内部代码获取内部课程名称
	 * 
	 * @param courseCode
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String getCourseNameByCourseCode(String courseCode) {
		String queryString = "select model.courseName from CourseInfo model where model.courseCode = courseCode";
		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());
			List list = query.getResultList();
			return (String) list.get(0);
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 根据外部代码获取外部课程名称
	 * 
	 * @param courseCodeOut
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String getCourseNameOutByCourseCodeOut(String courseCodeOut) {
		String queryString = "select model.courseNameOut from CourseInfo model where model.courseCodeOut = courseCodeOut";
		try {
			Query query = getEntityManager().createQuery(queryString);
			List list = query.getResultList();
			
			if(list.size()!=0){
				return (String)list.get(0);
			}
			else return null;
			
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getEntityManager().close();
		}
	}

	/**
	 * 条件查询：获取课程管理的详细信息-分页查询
	 * 
	 * @param courseCode
	 *            课程代码（内部）
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
	public List<CourseInfoVO> getAllCourseInfoVOInPage(String courseCode,
			String courseName, String examTypeCode, String courseTypeCode,
			String courseClassCode, String stage, String scale, int pageNo,
			int pageSize) {
		
		List<CourseInfoVO> list = new ArrayList<CourseInfoVO>();
		

/*		String basicString = "select new org.wy.ccnu.edu.entity.CourseInfoVO(coursetype.courseTypeName,"
				+ "courseInfo.id,courseinfo.courseCode,courseInfo.courseCodeOut,courseInfo.courseName,"
				+ "courseInfo.courseNameOut,trainingCourseInfo.stage,trainingCourseInfo.credit,"
				+ "trainingCourseInfo.learningTime,examType.examTypeName,courseClass.courseClassName,"
				+ "trainingCourseInfo.scales,trainingCourseInfo.remark) "
				+ "from CourseInfo courseInfo,TrainingCourseInfo trainingCourseInfo,CourseType courseType,"
				+ "ExamType examType,CourseClass courseClass "
				+ "where trainingCourseInfo.courseId = courseInfo.id and trainingCourseInfo.examTypeCode = examType.examTypeCode "
				+ "and trainingCourseInfo.courseClassCode = courseClass.courseClassCode and trainingCourseInfo.courseTypeCode = courseType.courseTypeCode ";
*/
	
		String basicString = "select new org.wy.ccnu.edu.entity.CourseInfoVO(coursetype.courseTypeName,"
				+ "courseInfo.id,courseinfo.courseCode,courseInfo.courseCodeOut,courseInfo.courseName,"
				+ "courseInfo.courseNameOut,courseInfo.credit,"
				+ "courseInfo.learningTime,examType.examTypeName,courseClass.courseClassName) "
				+ "from CourseInfo courseInfo,CourseType courseType,"
				+ "ExamType examType,CourseClass courseClass "
				+ "where courseInfo.examTypeCode = examType.examTypeCode "
				+ "and courseInfo.courseClassCode = courseClass.courseClassCode and courseInfo.courseTypeCode = courseType.courseTypeCode ";
		
		StringBuilder queryString = new StringBuilder(basicString);

		if (courseCode != null && !courseCode.trim().equals("")
				&& !courseCode.equals("null")) {

			queryString.append(" and courseInfo.courseCode = :courseCode");
		}
		if (courseName != null && !courseName.trim().equals("")
				&& !courseName.equals("null")) {

			queryString.append(" and courseInfo.courseName like :courseName");
		}

		if (examTypeCode != null && !examTypeCode.trim().equals("")
				&& !examTypeCode.equals("null")) {

			queryString
					.append(" and courseInfo.examTypeCode = :examTypeCode");
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

/*		if (stage != null && !stage.trim().equals("") && !stage.equals("null")) {

			queryString.append(" and trainingCourseInfo.stage = :stage");
		}

		if (scale != null && !scale.trim().equals("") && !scale.equals("null")) {

			queryString.append(" and trainingCourseInfo.scales like :scale");
		}*/

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (courseCode != null && !courseCode.trim().equals("")
					&& !courseCode.equals("null")) {

				query.setParameter("courseCode", courseCode);
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

/*			if (stage != null && !stage.trim().equals("")
					&& !stage.equals("null")) {
				query.setParameter("stage", stage);
			}

			if (scale != null && !scale.trim().equals("")
					&& !scale.equals("null")) {

				query.setParameter("scale", "%" + scale + "%");
			}*/

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
	 * 条件查询：获取课程管理的详细信息的总记录数
	 * 
	 * @param courseCode
	 * @param courseName
	 * @param examTypeCode
	 * @param courseTypeCode
	 * @param courseClassCode
	 * @param stage
	 * @param scale
	 * @return
	 */
	public int getTotalCourseInfoVO(String courseCode, String courseName,
			String examTypeCode, String courseTypeCode, String courseClassCode,
			String stage, String scale) {
		int total = 0;

/*		String basicString = "select count(*) "
				+ "from CourseInfo courseInfo,TrainingCourseInfo trainingCourseInfo,CourseType courseType,"
				+ "ExamType examType,CourseClass courseClass "
				+ "where trainingCourseInfo.courseId = courseInfo.id and trainingCourseInfo.examTypeCode = examType.examTypeCode "
				+ "and trainingCourseInfo.courseClassCode = courseClass.courseClassCode and trainingCourseInfo.courseTypeCode = courseType.courseTypeCode";
				*/

		String basicString = "select count(*) "
				+ "from CourseInfo courseInfo,CourseType courseType,"
				+ "ExamType examType,CourseClass courseClass "
				+ "where courseInfo.examTypeCode = examType.examTypeCode "
				+ "and courseInfo.courseClassCode = courseClass.courseClassCode and courseInfo.courseTypeCode = courseType.courseTypeCode ";
			
		StringBuilder queryString = new StringBuilder(basicString);

		if (courseCode != null && !courseCode.trim().equals("")
				&& !courseCode.equals("null")) {

			queryString.append(" and courseInfo.courseCode = :courseCode");
		} 
		if (courseName != null && !courseName.trim().equals("")
				&& !courseName.equals("null")) {

			queryString.append(" and courseInfo.courseName like :courseName");
		}

		if (examTypeCode != null && !examTypeCode.trim().equals("")
				&& !examTypeCode.equals("null")) {

			queryString
					.append(" and courseInfo.examTypeCode = :examTypeCode");
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

/*		if (stage != null && !stage.trim().equals("") && !stage.equals("null")) {

			queryString.append(" and trainingCourseInfo.stage = :stage");
		}

		if (scale != null && !scale.trim().equals("") && !scale.equals("null")) {

			queryString.append(" and trainingCourseInfo.scales like :scale");
		}*/

		try {
			Query query = getEntityManager()
					.createQuery(queryString.toString());

			if (courseCode != null && !courseCode.trim().equals("")
					&& !courseCode.equals("null")) {
				query.setParameter("courseCode", courseCode);
			}
			if (courseName != null && !courseName.trim().equals("")
					&& !courseName.equals("null")) {
				
				query.setParameter("courseName", "%"+courseName+"%" );
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

/*			if (stage != null && !stage.trim().equals("")
					&& !stage.equals("null")) {
				query.setParameter("stage", stage);
			}

			if (scale != null && !scale.trim().equals("")
					&& !scale.equals("null")) {

				query.setParameter("scale", "%" + scale + "%");
			}*/
			

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
	 * 根据CourseInfo的属性来查找课程信息
	 * @param property课程属性
	 * @param proValue属性的值
	 * @return
	 */
    @SuppressWarnings("rawtypes")
	public CourseInfo getCourseInfoByProperty(String property,String proValue){
    	String queryString = "from CourseInfo model where model."+property+" = '"+proValue +"'" ;
    	CourseInfo courseInfo = null;
    	try{
    		Query query = getEntityManager().createQuery(queryString);
    		List list = query.getResultList();
    		if(!list.toString().equals("[]")){
    			courseInfo = (CourseInfo) list.get(0);
    		}
    	}catch(RuntimeException re){
    		throw re;
    	}finally{
    		getEntityManager().close();
    	}
    	return courseInfo;	
    }
    
    /**
     * 批量删除课程信息
     * @param CourseIds
     * @return
     * @throws JSONException
     */
	public boolean batchDeleteCourseInfo(JSONObject CourseIds) throws JSONException{
		
		System.out.println("Delete---CourseIds"+CourseIds);
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<CourseIds.length();i++){
			queryString.append("?");
			if(i < (CourseIds.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete CourseInfo where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			for(int i = 0;i<CourseIds.length();i++){
				query.setParameter(i+1, Integer.parseInt(CourseIds.getString(i+"")));
			}
			query.executeUpdate();
			EntityManagerHelper.commit();
			return true;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
	}
	

}
