<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<shiro:hasPermission name="user:query">
		<h2>
			<a href="">查询用户</a>
		</h2>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:add">
		<h2>
			<a href="">添加用户</a>
		</h2>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:update">
		<h2>
			<a href="">修改用户</a>
		</h2>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:delete">
		<h2>
			<a href="">删除用户</a>
		</h2>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:export">
		<h2>
			<a href="">导出用户</a>
		</h2>
	</shiro:hasPermission>
</body>
</html>