<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/import.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
    <c:forEach var="question" items="${requestScope.qResult.list}">  
    	name:${question.question}<br>
    </c:forEach>
  </body>
</html>
