<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
    
    <!-- Bootstrap -->
	<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/resources/css/signin.css" rel="stylesheet">
	
	
	<script src="<%=path%>/resources/jquery/1.11.1/jquery.min.js"></script>
	<script src="<%=path%>/resources/js/md5.min.js"></script>
	<script src="<%=path%>/resources/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	
	<script src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
	<script src="<%=path%>/resources/bootstrap-jquery/jquery.bootstrap.min.js"></script>
	
    
</head>
<body>

	<div class="container">

		<form class="form-signin" id="form" action="loginIn" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only"> Email address </label> 
			<input	type="text" id="userAccount" name="userAccount"
				class="form-control" required autofocus> 
			<label for="inputPassword" class="sr-only"> Password </label> 
			<input type="password" id="password" name="password" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> 
					<input type="checkbox" value="remember-me">
						Remember me
				</label>
			</div>
			<a class="btn btn-lg btn-primary btn-block" onclick="login()">Sign in</a>
		</form>
	</div>
	<!-- /container -->
	<script>
	$(function(){
		
	});
	var message = "${message}"
	if ("no" == message) {
		$.messager.alert("警告", "无此用户");
	}else if ("error" == message) {
		$.messager.alert("警告", "密码错误");
	}
	function login() {
		var password = md5($('#password').val());
		$('#password').val(password);
		$('#form').submit();
	}
			
	</script>	
</body>
</html>