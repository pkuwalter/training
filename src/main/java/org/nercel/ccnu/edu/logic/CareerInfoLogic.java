package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.persist.CareerInfo;

public interface CareerInfoLogic {

	
	/*
	 * 得到所有职业的信息
	 * 
	 * */
	
	public List<CareerInfo> getCareerInfoList();
		
	/*
	 * 分页显示
	 * */
	public List<CareerInfo> getCareerInfoListPage(String career,int pageNo,int pageSize);
		

	/*
	 * 记录数目
	 * */
	public int getCareerInfoNum(String career);
		

	
	/*
	 * 根据id号批量删除职业信息
	 * 
	 * */
	
	public void deleteCareerInfoByIds(JSONObject ids)throws JSONException;
	
	/*
	 * 增加职业信息
	 * */
	
	public void addCareerInfo(CareerInfo careerInfo);

	
}
