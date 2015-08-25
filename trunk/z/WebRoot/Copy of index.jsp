<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath %>">
    <title>zhenjia</title>
  </head>
  
  <body> 
  <form action="s" method="get">
  	<input type ="text" name="q"/>
  	<input type = "submit">
  </form>
  </body>
</html>
