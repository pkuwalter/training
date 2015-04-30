package org.wy.ccnu.edu.logic.impl;

import java.util.List;


import org.wy.ccnu.edu.dao.PoliticalDao;
import org.wy.ccnu.edu.entity.persist.Political;
import org.wy.ccnu.edu.logic.PoliticalLogic;

public class PoliticalLogicImpl implements PoliticalLogic {
	private PoliticalDao dao = new PoliticalDao();
	public void addPolitical(Political political) {
		dao.save(political);

	}

	public void deletePolitical(Political political) {
		dao.delete(political);
	}

	public void updatePolitical(Political political) {
		dao.update(political);

	}

	public Political getPoliticalByID(int politicalId) {
		
		return dao.findPoliticalByID(politicalId);
	}

	public List<Political> getPoliticalList() {
		
		return dao.getAllPolitical();
	}

	public int getMaxPoliticalId() {
		return dao.getMaxPoliticalId();
	}

	public List<Political> getAllPoliticalInPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getAllPoliticalInPage(pageNo,pageSize);
	}

	public int getTotalPoliticals() {
		// TODO Auto-generated method stub
		return dao.getTotalPoliticals();
	}

	public Political getPoliticalById(int politicalId) {
		// TODO Auto-generated method stub
		return null;
	}

}