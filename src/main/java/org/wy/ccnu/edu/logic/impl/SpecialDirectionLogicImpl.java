package org.wy.ccnu.edu.logic.impl;

import java.util.List;

import org.wy.ccnu.edu.dao.SpecialDirectionDao;
import org.wy.ccnu.edu.entity.SpecialDirectionVO;
import org.wy.ccnu.edu.entity.persist.SpecialDirection;
import org.wy.ccnu.edu.logic.SpecialDirectionLogic;

public class SpecialDirectionLogicImpl implements SpecialDirectionLogic {

	SpecialDirectionDao dao = new SpecialDirectionDao();
	
 
	public void addSpecialDirection(SpecialDirection entity) {

      dao.save(entity);

	}

	public void deleteSpecialDirection(int specialDirectionId) {

		dao.deleteSpecialDirection(specialDirectionId);

	}

 
	public void updateSpecialDirection(SpecialDirection entity) {
		
		dao.update(entity);

	}

 
	public SpecialDirectionVO getSpecialDirectionVOById(int specialDirectionId) {
 
		return dao.getSpecialDirectionVOById(specialDirectionId);
	}

	 
	public SpecialDirectionVO getSpecialDirectionVOByCode(
			String specialDirectionCode) {
		 
		return dao.getSpecialDirectionVOByCode(specialDirectionCode);
	}

	 
	public List<SpecialDirectionVO> getSpecialDirectionVOListByCondition(
			String specialId, String specialDirectionCode,
			String specialDirectionName, int pageNo, int pageSize) {
		 
		return dao.getSpecialDirectionVOListByCondition(specialId, specialDirectionCode, specialDirectionName, pageNo, pageSize);
	}

	public int getSpecialDirectionVOListSizeByCondition(String specialId,
			String specialDirectionCode, String specialDirectionName) {
 
		return dao.getSpecialDirectionVOListSizeByCondition(specialId, specialDirectionCode, specialDirectionName);
	}

}
