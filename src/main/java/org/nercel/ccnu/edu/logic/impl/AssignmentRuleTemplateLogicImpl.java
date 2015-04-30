package org.nercel.ccnu.edu.logic.impl; 

import java.util.List;

import org.nercel.ccnu.edu.dao.AssignmentRuleTemplateDao;
import org.nercel.ccnu.edu.entity.TrainingBatchVO;
import org.nercel.ccnu.edu.entity.persist.AssignmentRuleTemplate;
import org.nercel.ccnu.edu.logic.AssignmentRuleTemplateLogic;
import org.nercel.ccnu.edu.util.PageModel;

/** 
 * @author Jo 
 * @version 创建时间：2014年6月19日 下午3:46:54 
 * 类说明 
 */
public class AssignmentRuleTemplateLogicImpl implements AssignmentRuleTemplateLogic {
	AssignmentRuleTemplateDao dao=new AssignmentRuleTemplateDao();

	public AssignmentRuleTemplate findById(String id) {
		return dao.getById(id);
	}

	public void create(AssignmentRuleTemplate entity) {
		dao.save(entity);
	}

	public void update(AssignmentRuleTemplate entity) {
		dao.update(entity);
	}

	public void delete(String ids) {
		dao.delete(ids);
	}
	public void deleteById(String id) {
		dao.deleteById(id);
	}

	public AssignmentRuleTemplate findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	public PageModel<AssignmentRuleTemplate> findByPage(int pageNo,int pageSize) {
		PageModel<AssignmentRuleTemplate> pageModel=new PageModel<AssignmentRuleTemplate>();
		int count=dao.countAll();
		if(count!=0){
			List<AssignmentRuleTemplate> entityList=dao.findByPage(pageNo, pageSize);
			pageModel.setList(entityList);
		}
		pageModel.setTotalRecords(count);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
}
 