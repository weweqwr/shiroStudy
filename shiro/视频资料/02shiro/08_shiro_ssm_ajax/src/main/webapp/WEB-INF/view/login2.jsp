<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
</head>
<body>
<h1 align="center">用户登陆</h1>
<hr> 
<form action="${ctx}/login/login.action" method="post">
	<table align="center" width="50%" border="1" cellpadding="2" cellspacing="5">
		<tr>
			<td align="right">用户名:</td>
			<td>
				<input type="text" name="username">
			</td>
		</tr>
		<tr>
			<td align="right">用户名:</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="登陆">
			</td>
		</tr>
	</table>
</form>
</body>
</html>