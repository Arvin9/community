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
	<title>Nebula</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
	<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/resources/css/footer.css" rel="stylesheet">
		
	<script src="${ctx}/resources/jquery/1.11.1/jquery.min.js"></script>
	<script src="${ctx}/resources/bootstrap/3.3.1/js/bootstrap.min.js"></script>
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
				<a class="navbar-brand" href="${ctx}/index">Nebula</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="${ctx}/index">首页</a>
					</li>
					<li>
						<a href="${ctx}/exercises">练习册</a>
					</li>
					<li>
						<a href="${ctx}/about">About</a>
					</li>
					<li>
						<a href="${ctx}/contact">Contact</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right" >
						<shiro:guest>
							<li >
								<a>欢迎游客访问</a>
							</li>
							<li> 
								<a href="${pageContext.request.contextPath}/signIn">登录</a>
							</li>  
						</shiro:guest> 
						<shiro:user>  
							<li>
								<a href='/index'>欢迎<span id="topUserAccount" style="color:red"><shiro:principal/></span>登录</a>
							</li>
							<li>	
								<a href="logout">退出</a> 
							</li>	
						</shiro:user>
						
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
		</nav>

