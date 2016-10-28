<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.shiro.SecurityUtils" %>
<%@page import="org.apache.shiro.subject.Subject" %>
<%@page import="org.apache.shiro.session.Session" %>
<%@page import="java.lang.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<head>
	<base href="<%=basePath%>">
	<title>Grocery</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
	<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/resources/css/footer.css" rel="stylesheet">
	<!-- chat css -->
	<link href="<%=path%>/resources/css/chat.css" rel="stylesheet">
		
	<script src="${ctx}/resources/jquery/1.11.1/jquery.min.js"></script>
	<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx}/resources/jquery-easyui/jquery.easyui.min.js"></script>
	<script src="${ctx}/resources/bootstrap-jquery/jquery.bootstrap.min.js"></script>
	
</head>
<body>
	<div class="container">
		<%  
		Subject subject = SecurityUtils.getSubject();
		//String username = subject.getPrincipals().oneByType(String.class);
		%>
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${ctx}/index">Grocery</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="">
						<a href="${ctx}/index">首页</a>
					</li>
					<li>
						<a href="${ctx}/exercises">练习册</a>
					</li>
					<li>
						<a href="${ctx}/exam">考试</a>
					</li>
					<li>
						<a href="${ctx}/serviceRobot">客服机器人</a>
					</li>
					<li>
						<a href="${ctx}/messageBoard">留言板</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right" >
						<shiro:guest>
							<li >
								<a>欢迎游客访问</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/signUp">注册</a> 
							</li>
							
							<li> 
								<a href="${pageContext.request.contextPath}/signIn">登录</a>
							</li>  
						</shiro:guest> 
						<shiro:user>  
							<li>
								<a href='/index'>欢迎<span id="topUserAccount" style="color:red"><shiro:principal/></span>登录</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
									<span class="glyphicon glyphicon-user">
									</span><span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>	
										<a href="changePassword">修改密码</a> 
									</li>	
							    	<li>	
										<a href="logout">退出</a> 
									</li>	
							    </ul>
							</li>
						</shiro:user>
						
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
		</nav>

