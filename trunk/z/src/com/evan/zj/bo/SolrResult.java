package com.evan.zj.bo;

import java.util.List;

import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrResult<T> {
	
	public SolrResult(List<T> list, QueryResponse res) {
		super();
		this.list = list;
		this.res = res;
	}
	
	private List<T> list;
	private QueryResponse res;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public QueryResponse getRes() {
		return res;
	}
	public void setRes(QueryResponse res) {
		this.res = res;
	}
}
