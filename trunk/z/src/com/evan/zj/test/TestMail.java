package com.evan.zj.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.evan.zj.bo.Email;
import com.evan.zj.service.MailService;

public class TestMail extends TestBase{
	
	@Test
	public void testSend() {
		Email e = new Email();
		e.setFrom("faduadmin@fadu.cc");
		String[] to = { "eellusion@126.com" };
		e.setTo(to);
		e.setSubject("测试邮件222");
		e.setContent("这是evan的测试邮件222");
		mailService.sendMail(e, true);
		System.out.println("==========OK============");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		System.out.println("==========OK============");
	}
	
	
	@Resource
	private MailService mailService;
}
