package com.evan.zj.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;

public class LogInterceptor implements MethodInterceptor,
InitializingBean{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("========LogInterceptor here=");
		return invocation.proceed();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

}
