package org.nercel.ccnu.edu.logic;

import java.util.List;



import org.nercel.ccnu.edu.entity.persist.NationInfo;

public interface NationInfoLogic {
    
	/**
	 * 增加民族信息 
	 * @param nationInfo
	 */
	public void addNationInfo(NationInfo nationInfo);
	
	/**
	 * 删除民族信息 
	 * @param nationInfo
	 */
	public void deleteNationInfo(NationInfo nationInfo);
	
	/**
	 * 更新民族信息 
	 * @param nationInfo
	 */
	public void updateNationInfo(NationInfo nationInfo);
	
	
	/**
	 * 根据ID获取民族信息 
	 * @param nationId
	 * @return
	 */
	public NationInfo getNationInfoByID(int nationId);
	
	/**
	 * 获取所有民族信息 
	 * @return
	 */
	public List<NationInfo> getNationInfoList();
	
	public int getMaxNationId();

 
	 /**
     * 以翻页的形式返回当前页的角色列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<NationInfo> getAllNationInPage(int pageNo, int pageSize);
    
    /**
     * 返回总数
     * @return
     */
    public int getTotalNations();
	
	
}
