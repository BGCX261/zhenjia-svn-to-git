<%@ taglib prefix="c" uri="../WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="../WEB-INF/fmt.tld"%>
<%@ taglib prefix="fn" uri="../WEB-INF/fn.tld"%>
<%@ taglib prefix="s" uri="../WEB-INF/struts-tags.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	basePath = "/z/";
	request.setAttribute("path", path);
	request.setAttribute("basePath",basePath);
%>