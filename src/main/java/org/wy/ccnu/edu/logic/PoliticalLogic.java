package org.wy.ccnu.edu.logic;

import java.util.List;

import org.wy.ccnu.edu.entity.persist.Political;

public interface PoliticalLogic {
	/**
	 * 增加政治面貌信息
	 * @param courseInfo
	 */
	public void addPolitical(Political political);
	
	/**
	 * 删除政治面貌
	 * @param courseInfo
	 */
	public void deletePolitical(Political political);
	
	/**
	 * 更新政治面貌
	 * @param courseInfo
	 */
	public void updatePolitical(Political political);
	
	
	/**
	 * 根据ID获取政治面貌
	 * @param courseId
	 * @return
	 */
	public Political getPoliticalByID(int politicalId);
	
	/**
	 * 获取所有政治面貌
	 * @return
	 */
	public List<Political> getPoliticalList();

	public int getMaxPoliticalId();
	

	 /**
    * 以翻页的形式返回当前页的角色列表
    * @param pageNo
    * @param pageSize
    * @return
    */
   public List<Political> getAllPoliticalInPage(int pageNo, int pageSize);
   
   /**
    * 返回总数
    * @return
    */
   public int getTotalPoliticals();
	
	

	
	
}
