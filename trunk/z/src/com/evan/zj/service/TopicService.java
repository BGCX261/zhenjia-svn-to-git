package com.evan.zj.service;

import java.awt.Point;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.evan.zj.dao.TopicDao;
import com.evan.zj.vo.TTopic;
import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;

@Transactional
@Service("topicService")
public class TopicService extends BaseService {

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@TriggersRemove(cacheName = "topicCache")
	public void save(TTopic topic) {
		topicrDao.save(topic);
	}
	
	@Cacheable(cacheName = "topicCache")
	public List<TTopic> list(Point p) {
		TTopic topic = new TTopic();
		topic.setEnable(true);
		
		Order[] orders = {Order.desc("activity")};
		DetachedCriteria c =  DetachedCriteria.forClass(TTopic.class).add(Property.forName("enable").eq(new Boolean(true)));
		
		
//		return topicrDao.findByCriteria(c, p.x, p.y,orders);
		
		return topicrDao.findByExample(topic,p.x, p.y,orders);
	}
	
	@Resource
	private TopicDao topicrDao;

}
