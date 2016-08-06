<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Nebula</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
	
		 <!-- Custom styles for this template -->
    	<link href="<%=path%>/resources/css/footer.css" rel="stylesheet">
		
		

	</head>

	<body>
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
		<a class="navbar-brand" href="<%=path %>/home">Nebula</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li class="active">
				<a href="/home">Home</a>
			</li>
			<li>
				<a href="http://www.nebulas.site">Blog</a>
			</li>
			<li>
				<a href="<%=path%>/about">About</a>
			</li>
			<li>
				<a href="<%=path%>/contact">Contact</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="<%=path%>/signIn">Sign in<span
					class="sr-only">(current)</span>
				</a>
			</li>
			<li>
				<a href="<%=path%>/home">Sign up</a>
			</li>
		</ul>
	</div>
	<!--/.nav-collapse -->
</div>
<!--/.container-fluid -->
</nav>

	</body>
</html>
