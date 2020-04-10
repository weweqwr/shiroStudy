<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/resources/js/jquery-3.1.1.min.js" charset="utf-8"></script>
<title>用户登陆</title>
</head>
<body>
<h1 align="center">用户登陆</h1>
<input type="button" value="登陆" id="login" />
<input type="button" value="查询" id="query" />



<script type="text/javascript">
	$("#login").click(function(){
		$.post("${ctx}/login/login.action",{username:'zhangsan',password:'123456'},function(obj){
			alert(obj.code+"  " +obj.msg);
		});
	});
	$("#query").click(function(){
		$.post("${ctx}/user/queryUser.action",function(obj){
			alert(obj.code+"  " +obj.msg);
		});
	});
</script>

</body>
</html>