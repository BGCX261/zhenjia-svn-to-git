<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
		System.out.println(request.getHeader("referer"));
		if(request.getSession().getAttribute("referer")==null){
			request.getSession().setAttribute("referer",request.getHeader("referer"));
		}
%>
<html>
	<head>
		<title>Login Page</title>
	</head>
	<body onload='document.f.j_username.focus();'>
		<h3>
			Login with Username and Password
		</h3>
		<form name='f' action='/z/j_spring_security_check' method='POST'>
			<table>
				<tr>
					<td>
						User:
					</td>
					<td>
						<input type='text' name='j_username' value=''>
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type='password' name='j_password' />
					</td>
				</tr>
				<tr>
					<td colspan='2'>
						<input name="submit" type="submit" />
					</td>
				</tr>
				<tr>
					<td colspan='2'>
						<input name="reset" type="reset" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
