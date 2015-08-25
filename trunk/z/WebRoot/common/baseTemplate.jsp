<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="../WEB-INF/tiles-jsp.tld"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="css/cached_front.css" media="screen" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <tiles:insertAttribute name="header" />
      <tiles:insertAttribute name="body" />
      <tiles:insertAttribute name="footer" />
  </body>
</html>
