<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
		<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">文章详情</h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <div class="row">
	        <div class="col-sm-12" id="showArticleDetail">
	        </div>
	    </div>
	                
		<!-- 静态包含 -->
		<%@include file="include/foot.jsp"%>

	</div>
	<!-- /container -->
		<script type="text/javascript">
		var articleDetail = ${articleDetail};
		
		$(function(){
			console.log(articleDetail);
			articleDetailPrint(articleDetail);
		});
		
		function articleLike(articleId){
			var articleId = articleId;
			$.post( "${ctx}/articleLike",{articleId:articleId}, function( data ) {
				$('#showArticleDetail').empty();
				console.log(articleId);
				$.get( "${ctx}/getArticleDetail",{articleId:articleId}, function( data ) {
					console.log(data);
					articleDetailPrint(data);
				});
			});
		}
		function articleDisLike(articleId){
			$.post( "${ctx}/articleDisLike",{articleId:articleId}, function( data ) {
				$('#showArticleDetail').empty();
				$.get( "${ctx}/getArticleDetail",{articleId:articleId}, function( data ) {
					articleDetailPrint(data);
				});
			});
		}
		
		function articleDetailPrint(obj){
			var content  = 	'<div class="panel panel-default">' +
						  		'<div class="panel-body">' +
						  			'<div class="row">' +
							  			'<div class="col-md-8 col-sm-8">' +
											'<span class="badge">'+ obj.articlePageView +'</span> &nbsp; <h3>'+ obj.articleCaption +'</h3>' +
										'</div>' +
										'<div class="col-md-4 col-sm-4">' +
							  				'<span class="label label-default">'+ obj.articleUpdateTime +'</span>' +
							  			'</div>' +
							  		'</div>' +
										'<blockquote>' + obj.articleContent + '</blockquote>' +
									'<div class="row" >' +
										'<div style="margin-left:auto;margin-right:auto;width:40%;">'+
											'<a onclick="articleLike('+ obj.articleId +')" class="btn btn-danger" role="button">' +
							        			'<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>&nbsp;&nbsp;' +
					  							'<span class="badge">'+ obj.articleLike +'</span>' +
							        		'</a> ' +
							        		'<a onclick="articleDisLike('+ obj.articleId +')" class="btn btn-warning" role="button">' +
							        			'<span class="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;' +
							        			'<span class="badge">'+ obj.articleDislike +'</span>' +
							        		'</a>' +
							        	'</div>' +
									'</div>' +
								'</div>'+
							'</div>';
			$('#showArticleDetail').append(content);
			
			
		}
		</script>
		
	</body>
</html>
