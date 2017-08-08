<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
</head>
<body>
	<h1>系统登录，请输入用户名和密码</h1>
	<form action="<%=request.getContextPath() %>/Info" method="post">
		<input type="text" name="name" />
		<input type="text" name="pwd" />
    	<input type="submit" value="登录" />
    </form>
</body>
<script>
	window.onload = function(){
		var msg = "${msg}";
		if(msg != ""){
			alert(msg);
		}
	}
</script>
</html>