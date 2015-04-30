package org.wy.ccnu.edu.logic.impl;

import java.util.List;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wy.ccnu.edu.dao.TeachingPlanTemplateDao;
import org.wy.ccnu.edu.entity.TeachingPlanTemplateVO;
import org.wy.ccnu.edu.entity.UtilObject;
import org.wy.ccnu.edu.entity.persist.TeachingPlanTemplate;
import org.wy.ccnu.edu.logic.TeachingPlanTemplateLogic;


public class TeachingPlanTemplateLogicImpl implements TeachingPlanTemplateLogic{

	private TeachingPlanTemplateDao dao =new TeachingPlanTemplateDao();

	public void save(TeachingPlanTemplate entity) {
          dao.save(entity);		
	}

	public boolean batchDelete(JSONObject ids)
			throws JSONException { 
		return dao.batchDelete(ids) ;
	}

	public void update(TeachingPlanTemplate entity) {
		  dao.update(entity);
	}

	public TeachingPlanTemplate findTemplateById(String id) {
		return dao.findTemplateById(id);
	}

	public int getMaxTpTemplateCode() {
		return dao.getMaxTpTemplateCode();
	}

	public List<TeachingPlanTemplateVO> getTemplate(int belongProject,String tptName,
			String tptCode, int deductionModel, int deductionRule,
			int pageNo, int pageSize) {
		return dao.getTemplate(belongProject, tptName, tptCode, deductionModel, deductionRule, pageNo, pageSize);
	}
	public int getTotalTemplates(int belongProject,String tptName,String tptCode,int deductionModel,int deductionRule){
		return dao.getTotalTemplates(belongProject, tptName, tptCode, deductionModel, deductionRule);
	}
	public int getTotalTemplates() {
		return dao.getTotalTemplates();
	}

	 
 
	public List<UtilObject> getAllCodeAndNameByUtilObject() {
		return dao.getAllCodeAndNameByUtilObject();
	}

	 
 

	public UtilObject getCodeByNameByUtilObject(String tpTemplateName) {
		return dao.getCodeByNameByUtilObject(tpTemplateName); 
	}

	public boolean checkName(String tpTemplateName,String formalName){
		return dao.checkName(tpTemplateName, formalName);
	}
	public boolean checkCode(String tpTemplateCode,String formalCode){
		return dao.checkCode(tpTemplateCode,formalCode);
	}
	
	public List<TeachingPlanTemplate> getTeachingPlanTemplateListByProperty(String property, String proValue){
		
		return dao.getTeachingPlanTemplateListByProperty(property, proValue);
	}
}
