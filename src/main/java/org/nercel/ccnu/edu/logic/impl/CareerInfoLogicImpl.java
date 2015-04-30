package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.dao.CareerInfoDao;
import org.nercel.ccnu.edu.entity.persist.CareerInfo;
import org.nercel.ccnu.edu.logic.CareerInfoLogic;

public class CareerInfoLogicImpl implements CareerInfoLogic {

	private CareerInfoDao dao=new CareerInfoDao();
	
	/*
	 * 得到所有职业的信息
	 * 
	 * */
	
	public List<CareerInfo> getCareerInfoList(){
		return dao.getCareerInfoList();
	}
	/*
	 * 分页显示
	 * */
	public List<CareerInfo> getCareerInfoListPage(String career,int pageNo,int pageSize){
		return dao.getCareerInfoListPage(career,pageNo,pageSize);
	}
	/*
	 * 记录数目
	 * */
	public int getCareerInfoNum(String career){
		return dao.getCareerInfoNum(career);
	}	
	
	/*
	 * 根据id号批量删除职业信息
	 * */
	
	public void deleteCareerInfoByIds(JSONObject ids) throws JSONException{
		dao.deleteCareerInfoByIds(ids);
	}
	/*
	 * 增加职业信息
	 * */
	
	public void addCareerInfo(CareerInfo careerInfo){
		dao.save(careerInfo);
	}
}
