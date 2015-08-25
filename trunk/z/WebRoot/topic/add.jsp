<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>新增话题</title>


	</head>

	<body>
		<form action="save.d">
			话题标题：<input name="title" type="text" ></input><br>
			话题描述：<textarea rows="3" cols="20" name="content"></textarea><br>
			左边的观点:<input name="leftopn" type="text"/><br>
			右边的观点:<input name="rightopn" type="text"/><br>
			标签:<input name="tags" type="text"/><br>
			
			<input type="submit">

		</form>
	</body>
</html>
