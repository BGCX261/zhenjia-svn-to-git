package com.evan.zj.service;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.springframework.stereotype.Service;

import com.evan.zj.bo.QuestionBO;
import com.evan.zj.service.AbstractSolrService;
import com.evan.zj.util.Config;
import com.evan.zj.util.SearchConstant;

@Service("questionSolrService")
public class QuestionSolrService extends AbstractSolrService<QuestionBO>{


	@Override
	protected CommonsHttpSolrServer initHttpServer() throws Exception {
		return new CommonsHttpSolrServer(Config.getSOLR_QUESTION());
	}

	@Override
	protected SolrQuery initQuery(Map paraMap, int start, int size) {

		SolrQuery queryTemp = new SolrQuery();
		String q = (String) paraMap.get(SearchConstant.q);
		String queryString = genSolrQueryString(q);
		queryTemp.setQuery(queryString);

		// queryTemp.addFilterQuery("(pageTitle:" + key + " pageContent:" +
		// key+") and status!=1");

		// queryTemp.addFilterQuery("status:2 or status:3 or status:4");
		queryTemp.setHighlight(true);
		queryTemp.setHighlightSnippets(2);
		queryTemp.addHighlightField("question");
		queryTemp.addHighlightField("tags");
		// queryTemp.setHighlightSimplePre("<span class=\"sfonHigh\">");
		// queryTemp.setHighlightSimplePost("</span>");

		queryTemp.setStart(start);
		queryTemp.setRows(size);
		return queryTemp;
	}

	public String genSolrQueryString(String key) {
		return " question:" + key + " tags:" + key + "";
	}


	
	@Override
	protected void processHightLight(
			Map<String, Map<String, List<String>>> highLightMap, List<QuestionBO> list) {
		for (QuestionBO question : list) {
			Map<String, List<String>> submap = highLightMap.get(question.getTid());
			// 获取标题
			if (hasItemInHighLight(submap, "question")) {
				question.setQuestion(submap.get("question").get(0));
			}
			if (hasItemInHighLight(submap, "tags")) {
				// 截取text
				question.setTags(submap.get("tags").get(0));
			} 
		}
	}

}
