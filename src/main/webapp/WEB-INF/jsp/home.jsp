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
			<jsp:include page="include/top.jsp"></jsp:include>

			<div class="page-header">
				<h1>
					Welcome to 
					<small>Nebula web site</small>
				</h1>
			</div>

			<div class="row">
	        	<div class="col-md-8" id="showArticle">
	            </div>
	        </div>


			<!-- 静态包含 -->
			<%@include file="include/foot.jsp"%>

		</div>
		<!-- /container -->
		
		<script type="text/javascript">
		
		$(function(){
			$.get( "articleQueryForShow", function(data) {
				articlePrint(data);
			});
		});
		
		function articlePrint(data){
			$.each(data,function(index,obj){
				var content = '<div class="panel panel-default">' +
							  	'<div class="panel-body">' +
							  		'<div class="row">' +
								  		'<div class="col-md-8">' +
								  			'<span class="badge">'+ obj.articlePageView +'</span> &nbsp; <a href="javascript:void(0);" style="font-size:22px;" onclick="articleDetail('+ obj.articleId +')">'+obj.articleCaption+'</a> ' +
								  		'</div>' +
								  		'<div class="col-md-4">' +
								  			'<span class="label label-default">'+ obj.articleUpdateTime +'</span>' +
								  		'</div>' +
								  	'</div>' +
								  	'<div class="row">' +
							  			'<div class="col-md-8">' +
							  				'<blockquote><p >'+obj.articleDigest+'</p></blockquote>' +
							  			'</div>' +
							  		'</div>' +
							  	'</div>' +
							  '</div>';
				console.log(obj.articleId);
				$('#showArticle').append(content);
			});
		}
		function articleDetail(articleId){
			var url = "${ctx}/articleDetail?articleId=";
			url += articleId;
			window.open(url);
		}
		</script>
	</body>
</html>
