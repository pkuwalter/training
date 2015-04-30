package org.wy.ccnu.edu.logic;

import java.util.List;
import org.wy.ccnu.edu.entity.SpecialDirectionVO;
import org.wy.ccnu.edu.entity.persist.SpecialDirection;
 

public interface SpecialDirectionLogic {
	
	
    public void addSpecialDirection(SpecialDirection entity);
	
    /**
     * 根据id，单个删除
     * @param specialDirectionId
     * @throws JSONException
     */
	public void deleteSpecialDirection(int specialDirectionId) ;
	
	public void updateSpecialDirection(SpecialDirection entity);
	
	public SpecialDirectionVO getSpecialDirectionVOById(int specialDirectionId);
	
	/**
	 * 根据学科方向代码，查询学科方向对象
	 * @param specialDirectionCode
	 * @return
	 */
	public SpecialDirectionVO getSpecialDirectionVOByCode(String specialDirectionCode);
	
	/**
	 * 根据培养学科或专业id,学科方向代码，学科方向名称，组合查询，获取学科方向VO列表
	 * 分页查询
	 * @param specialId
	 * @return
	 */
	public List<SpecialDirectionVO> getSpecialDirectionVOListByCondition(
			String specialId,String specialDirectionCode,String specialDirectionName,int pageNo,int pageSize);
	
	
	/**
	 * 根据培养学科或专业id,学科方向代码，学科方向名称，获取学科方向VO列表
	 * 分页查询
	 * @param specialId
	 * @return
	 */
	public int getSpecialDirectionVOListSizeByCondition(
			String specialId,String specialDirectionCode,String specialDirectionName);
	
	
 
	
 
 
	
 
	
 
	
  
}
