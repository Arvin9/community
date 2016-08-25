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
				class="form-control" required autofocus placeholder="用户名"> 
			<label for="inputPassword" class="sr-only"> Password </label> 
			<input type="password" id="bePassword" name="bePassword" class="form-control"
				 required placeholder="密码">
			<input type="password" id="password" name="password" hidden="hidden" >
			<div class="checkbox">
				<label> 
					<input type="checkbox" value="remember-me">
						Remember me
				</label>
			</div>
			<a class="btn btn-lg btn-primary btn-block" onclick="login()">Sign in</a>
			<div>
			  <ul class="pager">
			    <li class="previous"><a href="index">游客</a></li>
			    <li class="next"><a href="signUp">注册</a></li>
			  </ul>
			</div>
		</form>
	</div>
	<!-- /container -->
	<script>
	var message = "${message}"
	if ("no" == message) {
		$.messager.alert("警告", "无此用户");
	}else if ("error" == message) {
		$.messager.alert("警告", "密码错误");
	}else if ("ss" == message) {
		$.messager.alert("信息", "注册成功，请登录");
	}
	function login() {
		var password = hex_md5($('#bePassword').val());
		$('#password').val(password);
		$('#form').submit();
	}
	</script>	
</body>
</html>