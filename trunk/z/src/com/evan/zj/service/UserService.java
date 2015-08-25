package com.evan.zj.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.evan.zj.dao.UserDao;
import com.evan.zj.vo.TUser;
import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;

@Transactional
@Service("userService")
public class UserService extends
		BaseService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Cacheable(cacheName = "userCache")
	public TUser get(Integer id){
		return userDao.getById(id);
//		return userDao.get(id);
//		return null;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@TriggersRemove(cacheName = "userCache")
	public void save(TUser entity) {
//		userDao.merge(entity);
		userDao.save(entity);
		//throw new RuntimeException("");
	}
	
	@Resource
	private UserDao userDao;

	
}
