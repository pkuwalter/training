package org.nercel.ccnu.edu.logic.impl;

import java.util.List;

import org.nercel.ccnu.edu.dao.NationInfoDao;
import org.nercel.ccnu.edu.entity.persist.NationInfo;
import org.nercel.ccnu.edu.logic.NationInfoLogic;


public class NationInfoLogicImpl implements NationInfoLogic {
	
	
	private NationInfoDao dao = new  NationInfoDao();

	public void addNationInfo(NationInfo nationInfo) {

       dao.save(nationInfo);

	}

	public void deleteNationInfo(NationInfo nationInfo) {

		dao.delete(nationInfo);
	}

	public void updateNationInfo(NationInfo nationInfo) {
       
		dao.update(nationInfo);
       
	}



	public List<NationInfo> getNationInfoList() {

		return dao.getAllNationInfo();

	}
	

	public int getMaxNationId() {
		// TODO Auto-generated method stub
		return dao.getMaxNationId();
	}

	public NationInfo getNationInfoByID(int nationId) {
		// TODO Auto-generated method stub
		return dao.findNationById(nationId);
	}

	public List<NationInfo> getAllNationInPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getAllNationInPage(pageNo, pageSize);
	}

	public int getTotalNations() {
		// TODO Auto-generated method stub
		return dao.getTotalNations();
	}

	

	


}
