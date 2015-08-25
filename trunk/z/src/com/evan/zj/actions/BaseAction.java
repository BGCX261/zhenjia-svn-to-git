package com.evan.zj.actions;

import org.apache.struts2.ServletActionContext;

import com.evan.zj.vo.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	public String getIp(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	public TUser getUser(){
		return (TUser) (ServletActionContext.getRequest().getSession().getAttribute("user"));
	}
	
	protected Object getA(String key){
		return ServletActionContext.getRequest().getAttribute(key);
	}
	protected void setA(String key,Object value){
		ServletActionContext.getRequest().setAttribute(key,value);
	}
	protected void setS(String key,Object value){
		ServletActionContext.getRequest().getSession().setAttribute(key,value);
	}
	
	protected void getS(String key){
		ServletActionContext.getRequest().getSession().getAttribute(key);
	}
	
	
}
