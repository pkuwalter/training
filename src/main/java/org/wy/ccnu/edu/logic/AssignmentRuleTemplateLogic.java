package org.wy.ccnu.edu.logic; 

import org.wy.ccnu.edu.entity.persist.AssignmentRuleTemplate;
import org.wy.ccnu.edu.util.PageModel;

/** 
 * @author Jo 
 * @version 创建时间：2014年6月19日 下午2:54:17 
 * 类说明 
 */
public interface AssignmentRuleTemplateLogic {
	public AssignmentRuleTemplate findById(String id);
	public void create(AssignmentRuleTemplate entity);
	public void update(AssignmentRuleTemplate entity);
	public void delete(String ids);
	public void deleteById(String id);
	public AssignmentRuleTemplate findByProperty(String propertyName, Object value);
	public PageModel<AssignmentRuleTemplate> findByPage(int pageNo,int pageSize);
}
 