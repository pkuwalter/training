package org.wy.ccnu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.entity.WorkUnitVO;
import org.wy.ccnu.edu.entity.persist.WorkUnit;
import org.wy.ccnu.edu.util.EntityManagerHelper;

/**
 * 工作单位信息维护
 * @author LY
 * 2014.0527
 */
public class WorkUnitDao extends BaseDaoImpl<WorkUnit> {
	
	/**
	 * 根据条件查询工作单位信息列表
	 * @param provinceCode
	 * @param cityCode
	 * @param countryCode
	 * @param workUnitName
	 * @param workUnitCode
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<WorkUnitVO> getWorkUnitByConditions(String provinceCode, String cityCode,
			String countryCode, String workUnitName, String workUnitCode, int pageNo, int pageSize){
		List<WorkUnitVO> result = new ArrayList<WorkUnitVO>();

		StringBuilder hql = new StringBuilder();
		hql.append("select new org.wy.ccnu.edu.entity.WorkUnitVO(model.id, pi.provinceName, " +
				"model.city, model.country, model.workUnitName, model.workUnitCode, model.location) from " +
				"WorkUnit model, ProvinceInfo pi where pi.code = model.province ");
		
		if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
			hql.append(" and model.province = :proviceCode ");
		}
		if(cityCode != null && !cityCode.trim().equals("null") && !cityCode.trim().equals("")){
			hql.append(" and model.city = :cityCode ");
		}
		if(countryCode != null && !countryCode.trim().equals("null") && !countryCode.trim().equals("")){
			hql.append(" and model.country = :countryCode ");
		}
		if(workUnitName != null && !workUnitName.trim().equals("null") && !workUnitName.trim().equals("")){
			hql.append(" and model.workUnitName = :workUnitName ");
		}
		if(workUnitCode != null && !workUnitCode.trim().equals("null") && !workUnitCode.trim().equals("")){
			hql.append(" and model.workUnitCode like '%"+workUnitCode+"%' ");
		}
		
		Query query = null;
		
		try{
			query = getEntityManager().createQuery(hql.toString());
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				query.setParameter("provinceCode", provinceCode);
			}
			if(cityCode != null && !cityCode.trim().equals("null") && !cityCode.trim().equals("")){
				query.setParameter("cityCode", cityCode);
			}
			if(countryCode != null && !countryCode.trim().equals("null") && !countryCode.trim().equals("")){
				query.setParameter("countryCode", countryCode);
			}
			if(workUnitName != null && !workUnitName.trim().equals("null") && !workUnitName.trim().equals("")){
				query.setParameter("workUnitName", workUnitName);
			}
			if(workUnitCode != null && !workUnitCode.trim().equals("null") && !workUnitCode.trim().equals("")){
				query.setParameter("woekUnitCode", workUnitCode);
			}
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			result = query.getResultList();
			if(result.toString().equals("[]"))
				result = null;
			
		}catch(RuntimeException re){
			re.printStackTrace();
		}finally{
			getEntityManager().close();
		}
		return result;
	}
	
	/**
	 * 根据条件得到工作单位记录数
	 * @param provinceCode
	 * @param cityCode
	 * @param countryCode
	 * @param workUnitName
	 * @param woekUnitCode
	 * @return
	 */
	public int getWorkUnitRecords(String provinceCode, String cityCode,
			String countryCode, String workUnitName, String woekUnitCode){
		int count = 0;
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*) from WorkUnit model where 1=1 ");
		
		if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
			hql.append(" and model.province = :provinceCode ");
		}
		if(cityCode != null && !cityCode.trim().equals("null") && !cityCode.trim().equals("")){
			hql.append(" and model.city = :cityCode ");
		}
		if(countryCode != null && !countryCode.trim().equals("null") && !countryCode.trim().equals("")){
			hql.append(" and model.country = :countryCode ");
		}
		if(workUnitName != null && !workUnitName.trim().equals("null") && !workUnitName.trim().equals("")){
			hql.append(" and model.workUnitName = :workUnitName ");
		}
		if(woekUnitCode != null && !woekUnitCode.trim().equals("null") && !woekUnitCode.trim().equals("")){
			hql.append(" and model.woekUnitCode like '%"+woekUnitCode+"%' ");
		}
		
		Query query = null;
		
		try{
			query = getEntityManager().createQuery(hql.toString());
			if(provinceCode != null && !provinceCode.trim().equals("null") && !provinceCode.trim().equals("")){
				query.setParameter("provinceCode", provinceCode);
			}
			if(cityCode != null && !cityCode.trim().equals("null") && !cityCode.trim().equals("")){
				query.setParameter("cityCode", cityCode);
			}
			if(countryCode != null && !countryCode.trim().equals("null") && !countryCode.trim().equals("")){
				query.setParameter("countryCode", countryCode);
			}
			if(workUnitName != null && !workUnitName.trim().equals("null") && !workUnitName.trim().equals("")){
				query.setParameter("workUnitName", workUnitName);
			}
			if(woekUnitCode != null && !woekUnitCode.trim().equals("null") && !woekUnitCode.trim().equals("")){
				query.setParameter("woekUnitCode", woekUnitCode);
			}
			count = Integer.parseInt(query.getSingleResult().toString());
		}catch(RuntimeException re){
			re.printStackTrace();
		}finally{
			getEntityManager().close();
		}
		return count;
	}
	
	/*
	 * 根据id号批量删除工作单位信息
	 * 若没被使用，则删除并返回true
	 * 否则不删除，并返回false
	 * */	
	public boolean batchDeleteByIds(JSONObject ids) throws JSONException{
		
		//if(checkIfInUse(ids)) return false;	//查看工作单位是否被使用
		
		StringBuilder queryString = new StringBuilder();
		for(int i = 0; i<ids.length();i++){
			queryString.append("?");
			if(i < (ids.length() -1)){
				queryString.append(",");
			}
		}
		String sql = "delete WorkUnit where id in ( " + queryString.toString() + ")";
		Query query = null;
		try{
			EntityManagerHelper.beginTransaction();
			query = getEntityManager().createQuery(sql);
			
			for(int i = 0;i<ids.length();i++){
				query.setParameter(i+1, Integer.parseInt(ids.getString(i+"")));
			}
			
			query.executeUpdate();
			EntityManagerHelper.commit();
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return true;
	}
	
	/**
	 * 判断工作单位是否正在使用，是返回true，否则返回false
	 * @param ids
	 * @return
	 * @throws JSONException
	 */
	public boolean checkIfInUse(JSONObject ids) throws JSONException{
		//实现省略。。。
		return false;
	}
	
	/**
	 * 根据属性名模糊查询工作单位列表信息
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<WorkUnit> findListByProperty(String propertyName, Object value){
		List<WorkUnit> list = new ArrayList<WorkUnit>(); 
		String hql = "from WorkUnit model where model."+propertyName+" like '%" + value + "%' ";
		Query query = null;
		
		try{
			query = getEntityManager().createQuery(hql);
			list = query.getResultList();
			if(list.toString().equals("[]"))
				list = null;
		}catch(RuntimeException re){
			throw re;
		}finally{
			getEntityManager().close();
		}
		return list;		
	}
	
	
	
}
