package org.nercel.ccnu.edu.logic;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.nercel.ccnu.edu.entity.TeachingPlanTemplateVO;
import org.nercel.ccnu.edu.entity.UtilObject;
import org.nercel.ccnu.edu.entity.persist.TeachingPlanTemplate;

public interface TeachingPlanTemplateLogic { 
	public void save(TeachingPlanTemplate entity);
	//public void delete(TeachingPlanTemplate entity);
	public boolean batchDelete(JSONObject ids) throws JSONException;
	public void  update(TeachingPlanTemplate entity);
	public TeachingPlanTemplate findTemplateById(String id);
	 
	public int getMaxTpTemplateCode();
	public int getTotalTemplates(int belongProject,String tptName,String tptCode,int deductionModel,int deductionRule);
	public List<TeachingPlanTemplateVO> getTemplate(int belongProject,String tptName,String tptCode,int deductionModel,int deductionRule, int pageNo, int pageSize);
	public int getTotalTemplates();
	public List<UtilObject> getAllCodeAndNameByUtilObject();
	public UtilObject getCodeByNameByUtilObject(String tpTemplateName );
	public boolean checkName(String tpTemplateName,String formalName);
	public boolean checkCode(String tpTemplateCode,String formalCode);
	public List<TeachingPlanTemplate> getTeachingPlanTemplateListByProperty(String property, String proValue);
}
