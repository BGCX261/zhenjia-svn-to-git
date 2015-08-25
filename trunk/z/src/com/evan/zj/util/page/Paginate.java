package com.evan.zj.util.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Paginate extends TagSupport {

	public static final String PAGE_GOTO = "REQUEST_KEY_PAGE_GOTO_PAGE";
	
	public static final String PAGE_NOT_FIRST_TIME = "REQUEST_KEY_PAGE_NOT_FIRST_TIME";

	public static final String MY_SESSION_KEY_NAME = "REQUEST_PARAMETER_PAGINATE_MY_SESSION_KEY";
	
	private String action;
	private String param;
	private String sessionKey;
	
	public String getSessionKey() {
		return sessionKey;
	}


	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}


	public String getParam() {
		return param;
	}


	public void setParam(String param) {
		this.param = param;
	}


	private int count;

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}

	
	@Override
	public int doStartTag() throws JspException {
		//用来保存分页信息在Session中储存的key
		String unique = System.nanoTime()+"";
		
		String sessionKey = this.sessionKey==null?PageBean.DEFAULT_SESSION_KEY:this.sessionKey;
		//System.out.println("Paginate::sessionKey = " + sessionKey);
		PageBean bean = (PageBean) this.pageContext.getSession().getAttribute(sessionKey);
		if (bean==null) {
			bean = new PageBean(count);
		}
		if (bean.getCount()==-1) bean.setCount(count);
		
		this.pageContext.getSession().setAttribute(sessionKey, bean);
		
		PageBean be = (PageBean)this.pageContext.getSession().getAttribute(sessionKey);
		//System.out.println(sessionKey+"==========================="+be.getCount()+"pagesize============"+be.getRecordsPerPage());
		String formName = "form_page" + unique;
		String jsFunction = "form_page_goto" + unique;
		String sliderName = "slider" + unique;
		String amountName = "amount" + unique;
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>    	<tr>    		<td>\n");
		sb.append("		<form name=" + formName  +" action=\"" + getAction() + "\" method=post>");
		if (bean.isPreviousPageAvailabe()) {
			sb.append("        <a href=\"#\" onclick=\"javascript:return " + jsFunction + "(1)\">首页</a> ");
			sb.append("        <a href=\"#\" onclick=\"javascript:return " + jsFunction + "(" + (bean.getCurrentPage() - 1)+ ")\">上页</a> ");
		} else {

			sb.append("        <span class=\"disabledLink\">首页</span> ");
			sb.append(" <span class=\"disabledLink\">上页</span> ");
		}
		if (bean.isNextPageAvailable()) {
			sb.append("        <a href=\"#\" onclick=\"javascript:return " + jsFunction + "(" + (bean.getCurrentPage() + 1)+ ")\">下页</a> ");
			sb.append("        <a href=\"#\" onclick=\"javascript:return " + jsFunction + "(" + bean.getTotalPage()+ ")\">尾页</span></a> ");
		} else {
			sb.append(" <span class=\"disabledLink\">下页</span> ");
			sb.append("        <span class=\"disabledLink\">尾页</span> ");
		}
		sb.append("	第<span id=\"" + amountName + "\">" + bean.getCurrentPage() + "</span>页/共" + bean.getTotalPage() + "页");
		if (param!=null && !param.equals("")) {
			String[] params = param.split("&");
			for (int i = 0; i < params.length; i++) {
				String[] t = params[i].split("=");
				String n = t[0];
				String v = (t.length==1)?"":t[1];
				sb.append("<input type=hidden name=\"" + n + "\" value=\"" + v + "\">");
			}
		}
		sb.append("<input type=hidden name=" + PAGE_NOT_FIRST_TIME + " value=\"YES\">");
		sb.append("<input type=hidden name=" + PAGE_GOTO + " value=1>");
		sb.append("<input type=hidden name=" + MY_SESSION_KEY_NAME + " value=\"" + sessionKey + "\">");
		sb.append("</form>\n");
		sb.append("</td></tr><TR><TD>\n");

//		sb.append("<script type=\"text/javascript\">");
//		sb.append("$(function() {");
//		sb.append("	$(\"#" + sliderName + "\").slider({");
//		sb.append("		value: " + bean.getCurrentPage() + ",");
//		sb.append("		min: 1,");
//		sb.append("		max: " + bean.getTotalPage() + ",");
//		sb.append("		slide: function(event, ui) {");
//		sb.append("			$(\"#" + amountName + "\").text(ui.value);");
//		sb.append("		},");
//		sb.append("		stop : function(event, ui) {");
//		sb.append("			if (ui.value==" + bean.getCurrentPage() + ") return;");
//		sb.append("			" + jsFunction + "(ui.value);");
//		sb.append("		}");
//		sb.append("	});");
//		sb.append("});");
//		sb.append("</script>");
		sb.append("<div id=\"" + sliderName + "\"></div>");
		
		sb.append("</td></tr>   </table>\n");
		sb.append("<script>\n");
		sb.append("    function " + jsFunction + "(p) {\n");
		sb.append("         var f = document.forms['" + formName + "'];\n");
		sb.append("         f." + PAGE_GOTO + ".value = p;\n");
		sb.append("         f.submit();\n");
		sb.append("         return false;\n");
		sb.append("    }\n");
		sb.append("</script>\n");

		
		JspWriter out = super.pageContext.getOut();
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			throw new JspException(e);
		}
		return super.doStartTag();
	}


}
