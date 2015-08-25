package com.evan.zj.actions;

import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.evan.zj.service.MailService;
import com.evan.zj.vo.TUser;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Namespace("/account")
@Scope("session")
public class AccountAction extends BaseAction implements ModelDriven<TUser>{
	@Action(value = "reg1", results = { @Result(name = "success", location = "/account/reg1.jsp") })
	public String reg1() throws Exception {
		return SUCCESS; 
	}
	
	@Action(value = "reg1save", results = { @Result(name = "success", location = "/account/reg1save.jsp") })
	public String reg1save() throws Exception {
		Random rd=new Random();
		String regCodeTemp = String.valueOf(rd.nextLong()) ;
		setS("regCode",regCodeTemp);
		
		mailService.getRegisterMessage().setSubject("注册确认");
		mailService.getRegisterMessage().setText("您好,欢迎注册Zhenjia,请点击下面的链接继续<br>http://localhost:8080/z/account/reg2.d?regCode="+regCodeTemp);
		
		mailService.sendRegisterMail(user.getName());
		ServletActionContext.getRequest().getSession().setAttribute("user",user);
		return SUCCESS; 
	}
	
	@Action(value = "reg2", results = { 
			@Result(name = "success", location = "/account/reg2.jsp"), 
			@Result(name = "error", location = "/common/result.jsp") 
	})
	public String reg2() throws Exception {
		Object regCodeTemp = getA("regCode");
		
		if(regCode==null ||!(regCode.equals(regCodeTemp.toString()))){
			setA("msg","邮箱验证不正确");
			setA("link","account/reg1.d");
			setA("linkMsg","点此重新注册");
			return ERROR;
		}
		return SUCCESS; 
	}
	
	
	@Autowired
	private MailService mailService;
	
	private TUser user = new TUser();

	private String regCode;
	
	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	@Override
	public TUser getModel() {
		return this.user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}
	
}
