package com.evan.zj.util.page;

import java.awt.Point;

import javax.servlet.http.HttpServletRequest;



public class PageBean {
	public static final int PAGE_SIZE = 20;
	public static final String DEFAULT_SESSION_KEY = "SESSION_KEY_PAGINATE_SINGLE";
	private String sessionKey;
	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	private int count;
	private int currentPage;
	private int recordsPerPage;
	
	public static Point initPageBean(HttpServletRequest request) {
		return initPageBean(request, PAGE_SIZE, DEFAULT_SESSION_KEY);
	}
	public static Point initPageBean(HttpServletRequest request, String sessionKey) {
		return initPageBean(request, PAGE_SIZE, sessionKey);
	}
	public static Point initPageBean(HttpServletRequest request, int pageSize) {
		return initPageBean(request, pageSize, DEFAULT_SESSION_KEY);
	}

	public static Point initPageBean(HttpServletRequest request, int pageSize, String sessionKey) {
		Point p = new Point(0, pageSize);
		//取得当前想要跳转的页面数
		String page= request.getParameter(Paginate.PAGE_GOTO);
		PageBean bean = null;
		if ("YES".equals(request.getParameter(Paginate.PAGE_NOT_FIRST_TIME))) { 
			bean = (PageBean) request.getSession().getAttribute(sessionKey);
			try {
				bean.setRecordsPerPage(pageSize);
				if (sessionKey.equals(request.getParameter(Paginate.MY_SESSION_KEY_NAME))) {
					bean.setCurrentPage(Integer.parseInt(page));
				}
			} catch(NumberFormatException ex) {
			}
			p.x = bean.getFirstRecordPosition();	//修改起始行
			//p.y = bean.getRecordsPerPage();		//修改读取的长度
			p.y = pageSize;
		} else {
			//清除session内容
			bean = new PageBean(-1);
			bean.setRecordsPerPage(pageSize);
			request.getSession().setAttribute(sessionKey, bean);
			//request.getSession().setAttribute(sessionKey, null);
		}
		return p;
	}
	
	public PageBean(int count) {
		this.count = count;
		currentPage = 1;
		this.recordsPerPage = PAGE_SIZE;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalPage() {
		return ((count - 1) / recordsPerPage) + 1;
	}

	public int getRecordsPerPage() {
		if (getFirstRecordPosition() + recordsPerPage > getCount()) return getCount() - getFirstRecordPosition();
		return recordsPerPage;
	}
	
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	
	public boolean isPageNumberValidate(int page) {
		if (page <0 || page > getTotalPage()) return false;
		return true;
	}

	public boolean isNextPageAvailable() {
		if (getTotalPage()<=1) return false;		
		return !(currentPage==getTotalPage());
	}
	
	public boolean isPreviousPageAvailabe() {
		//System.out.println("totalPage = " + getTotalPage());
		if (getTotalPage()<=1) return false;
		return !(currentPage==1);
	}
	
	public int getFirstRecordPosition() {
		return (currentPage - 1)* recordsPerPage ;
	}
}

