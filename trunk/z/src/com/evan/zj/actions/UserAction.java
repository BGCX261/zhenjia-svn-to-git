package com.evan.zj.actions;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.evan.zj.service.UserService;
import com.evan.zj.vo.TUser;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Namespace("/user")
public class UserAction extends BaseAction {

	@Action(value = "save", results = { @Result(name = "success", location = "/success.jsp") })
	public String execute() throws Exception {
		user.setBindId("");
		short a = 1;
		user.setBindtype(a);
		user.setDisplayname("e");
		user.setEnable(true);
		userService.save(user);
		return "success";
	}

	private static final long serialVersionUID = 5945601801103285355L;
	private Logger log = Logger.getLogger(this.getClass());
	
	private TUser user;
	
	@Autowired
	private UserService userService;

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}
	
}
