package com.evan.zj.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.evan.zj.bo.SolrResult;
import com.evan.zj.bo.WebSites;
import com.evan.zj.util.ReflectionUtils;

public abstract class AbstractSolrService<T> {

	protected abstract CommonsHttpSolrServer initHttpServer()throws Exception;

	protected abstract SolrQuery initQuery(Map<String, String> paraMap,
			int start, int size);

	protected Class<T> entityClass;
	
	public AbstractSolrService() {
		entityClass =(Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public SolrResult<T> search(Map<String, String> paraMap, int start, int size) throws Exception {
		CommonsHttpSolrServer solrServer = initHttpServer();
		SolrQuery query = initQuery(paraMap, start, size);
		QueryResponse res = null;
		try {
			log.info("query =" + query.getQuery());
			res = solrServer.query(query);
		} catch (SolrServerException e) {
			log.error("solr query error", e);
			e.printStackTrace();
		}

		Map<String, Map<String, List<String>>> highLightMap = res
				.getHighlighting();
		List<T> list = res.getBeans(entityClass);
		processHightLight(highLightMap, list);
		return new SolrResult<T>(list,res);
	}

	
	protected void processHightLight(
			Map<String, Map<String, List<String>>> highLightMap, List<T> list) {
		for (Object obj : list) {
			WebSites webSites = (WebSites) obj;
			Map<String, List<String>> submap = highLightMap.get(webSites
					.getPageId());
			// 获取标题
			if (hasItemInHighLight(submap, "pageTitle")) {
				webSites.setPageTitle(submap.get("pageTitle").get(0));
			}
			if (hasItemInHighLight(submap, "pageContent")) {
				// 截取text
				webSites.setPageDescription(submap.get("pageContent").get(0));
			} else {
				webSites.setPageDescription(submap.get("pageTitle").get(0));
			}
		}
	}

	protected boolean hasItemInHighLight(Map<String, List<String>> submap,
			String itemName) {
		if (submap != null && submap.get(itemName) != null
				&& submap.get(itemName).size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	private Logger log = Logger.getLogger(this.getClass());
}
