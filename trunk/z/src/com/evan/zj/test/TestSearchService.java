package com.evan.zj.test;

import static junit.framework.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.evan.zj.bo.QuestionBO;
import com.evan.zj.bo.SolrResult;
import com.evan.zj.service.QuestionSolrService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class TestSearchService {
	
	@Test
	public void testSearchQuestion() throws Exception{
		String q = "盐";
		Map map  = new HashMap();
		map.put("q", q);
		
		SolrResult<QuestionBO> result = (SolrResult<QuestionBO>) questionSolrService.search(map, 0, 10);
		
		List<QuestionBO> qList  = result.getList();
		
		assertNotNull(qList.get(0).getQuestion());
		assertNotNull(qList.get(0).getTags());
		
		log.info("question:"+qList.get(0).getQuestion());
		log.info("tags:"+qList.get(0).getTags());
	}
	
	
	@Resource
	private QuestionSolrService questionSolrService;


	Logger log = Logger.getLogger(this.getClass());
}
