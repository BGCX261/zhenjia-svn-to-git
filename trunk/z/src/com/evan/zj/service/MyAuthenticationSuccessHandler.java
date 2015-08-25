package com.evan.zj.service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import com.evan.zj.dao.UserDao;
import com.evan.zj.vo.TUser;


@Service("authenticationHandler")
public class MyAuthenticationSuccessHandler extends
SavedRequestAwareAuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	protected final Log logger;

	private RequestCache requestCache;

	@Resource
	private UserDao userDao;
	
	public MyAuthenticationSuccessHandler() {
		this.logger = LogFactory.getLog(super.getClass());
		this.requestCache = new HttpSessionRequestCache();
		
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
//		SavedRequest savedRequest = this.requestCache.getRequest(request,
//				response);
		SecurityContext sc = SecurityContextHolder.getContext();
		String userName = sc.getAuthentication().getName();
		
		TUser user = new TUser();
		user.setName(userName);
		user = userDao.getByExample(user);
		request.getSession().setAttribute("user", user);
		
//		String targetUrl = "/";
//		if(request.getSession().getAttribute("referer")!=null){
//			targetUrl = request.getSession().getAttribute("referer").toString();
//		}
			
		super.onAuthenticationSuccess(request, response, authentication);
//		System.out.println("targetUrl:"+targetUrl);
//		super.onAuthenticationSuccess(request, response, authentication);
//		if (savedRequest == null) {
//			super.onAuthenticationSuccess(request, response, authentication);
//			return;
//		}
//		clearAuthenticationAttributes(request);
//		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
	
	
}
