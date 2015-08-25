<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>操作结果</title>

		<script type="text/javascript">
	function jumpURL() {
		location.href = '${basePath}<s:property value="#request.jumpURL" />';
	}
	//setTimeout(jumpURL, 3000);
</script>
	</head>

	<body>
		${requestScope.msg}
		<%= request.getParameter("msg")%>
		<br>
		<a href="${basePath}<s:property value="#request.link"/>"> <s:property
				value="#request.linkMsg" /> </a>

	</body>

</html>
