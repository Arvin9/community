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
		<!-- Bootstrap -->
		
		<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
		
		 <!-- Custom styles for this template -->
    	<link href="<%=path%>/resources/css/footer.css" rel="stylesheet">
		
		<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="<%=path%>/resources/js/dropdown.js"></script>

	</head>

	<body>
		<div class="container">
			<!-- 动态包含 -->
			<jsp:include page="page/top.jsp"></jsp:include>

			<div class="page-header">
				<h1>
					Welcome to 
					<small>Nebula web site</small>
				</h1>
			</div>

			<!-- Main component for a primary marketing message or call to action -->
			<div class="jumbotron">
				<h1>
					Hello World
				</h1>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;
						Wherever you are, and whoever you may be, 
					there is one thing in which you and I are just alike at this monment, 
					and in all the moments of our existence. 
					We are not at rest, we are on a journey. 
					Our life is a movement, a tendency, a steady, ceaseless progress towards an unseen goal.
				</p>


				<p>
					<a class="btn btn-lg btn-primary" href="<%=path%>/contact" role="button">Contact me &raquo;</a>
				</p>
			</div>


			<!-- 静态包含 -->
			<%@include file="page/foot.jsp"%>

		</div>
		<!-- /container -->
	</body>
</html>
