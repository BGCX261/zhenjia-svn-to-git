package com.evan.zj.test;

import java.awt.Point;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.junit.Test;

import com.evan.zj.dao.TopicDao;
import com.evan.zj.service.TopicService;
import com.evan.zj.vo.TTopic;

public class TestTopic extends TestBase{
	
	
	@Test
	public void testList() {
		Point p = new Point();
		p.x = 0;
		p.y = 10;
		List<TTopic> list = topicSerivce.list(p);
		System.out.println("===================:"+list.size());
		
//		Order[] os = {Order.asc("activity")};
//		List l2 = topicDao.findAll(0, 5,os );
//		System.out.println("===================:"+l2.size());
		
	}
	
	@Resource
	private TopicService topicSerivce;
	
	@Resource
	private TopicDao topicDao;
}
