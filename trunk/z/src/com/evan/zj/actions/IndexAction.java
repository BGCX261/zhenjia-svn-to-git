package com.evan.zj.actions;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.evan.zj.bo.QuestionBO;
import com.evan.zj.bo.SolrResult;
import com.evan.zj.service.QuestionSolrService;
import com.evan.zj.service.TopicService;
import com.evan.zj.util.SearchConstant;
import com.evan.zj.util.page.PageBean;
import com.evan.zj.vo.TTopic;

@InterceptorRefs( { @InterceptorRef("defaultStack") })
@Controller("index")
@Namespace("/")
public class IndexAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "index", results = { @Result(name = "success",location = "/index.jsp")})
	public String index() throws Exception {
		Point p = PageBean.initPageBean(ServletActionContext.getRequest(), 8);
		
		topicList = topicService.list(p);
		
		System.out.println("topicList====:"+topicList.size());
		
		return SUCCESS;
	}

	@Action(value = "s", results = { @Result(name = "success", location = "/list.jsp") })
	public String s() throws Exception {
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put(SearchConstant.q, q);
		
		qResult = questionSolrService.search(paraMap, 0, 10);
		return SUCCESS;
	}

	
	public SolrResult<QuestionBO> getQResult() {
		return qResult;
	}

	public void setQResult(SolrResult<QuestionBO> result) {
		qResult = result;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	private SolrResult<QuestionBO> qResult;
	
	private String q;

	@Resource
	private QuestionSolrService questionSolrService;

	@Resource
	private TopicService topicService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private List<TTopic> topicList;
	

	public List<TTopic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TTopic> topicList) {
		this.topicList = topicList;
	}
}
