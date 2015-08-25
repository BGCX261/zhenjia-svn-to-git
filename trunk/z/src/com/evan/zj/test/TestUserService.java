package com.evan.zj.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.evan.zj.service.UserService;
import com.evan.zj.vo.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = false)
public class TestUserService {
	Logger log = Logger.getLogger(this.getClass());

	@Test
	public void testSave() {

		TUser user = new TUser();
		user.setName("QQQQ");
		user.setPassword("123");
		user.setBindtype((short) 0);
		user.setBindId("");
		user.setDisplayname("evan12");
		user.setEnable(true);
		
		userService.save(user);
	}

	@Test
	public void testGet() {
		TUser user = userService.get(new Integer(54));
		log.info("user:" + user.getName());
		TUser user2 = userService.get(new Integer(55));
		log.info("user:" + user2.getName());
		TUser user3 = userService.get(new Integer(54));
		log.info("user:" + user3.getName());
	}

	@Resource
	private UserService userService;

}
