<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
		<div class="row">
			<div class="col-sm-9">
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
						<a class="btn btn-lg btn-primary" href="${ctx}/contact" role="button">Contact me &raquo;</a>
					</p>
				</div>
			</div>
			
			<div class="col-sm-3">
				<br>
				<br>
		  		<%-- showDailySentence  --%>
		  		<div class="thumbnail">
			    	<img id ="dailySentenceUrl" style="filter:chroma(color=#ffffff)" src="" alt="...">
			    	<div class="caption">
			    		<h3 id="dailySentenceId" style="text-align:center"><span style="color:#9932CC">每日一句</span></h3>
			        	<p id="dailySentence"></p>
			        	<p class="pager">
			        		<a onclick="dailySentenceLike()" class="btn btn-danger" role="button">
			        			<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	  							<span class="badge" id="sentenceLike"></span>
			        		</a> 
			        		<a onclick="dailySentenceDislike()" class="btn btn-warning" role="button">
			        			<span class="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span>
			        			<span class="badge" id="sentenceDisLike"></span>
			        		</a>
			        	</p>
			      	</div>
			    </div>
		  		<%-- /showDailySentence --%>
		  	</div>
		</div>
		<!-- 静态包含 -->
		<%@include file="include/foot.jsp"%>

	</div>
	<!-- /container -->
	
	<script>
	$(function(){
		showDailySentence();
	});
	
	function showDailySentence(){
		$.get('getDailySentence', function(data) {
			$('#dailySentenceId').val(data.dailySentenceId);
			$('#dailySentence').text(data.dailySentence);
			$('#dailySentenceUrl').attr('src',data.dailySentenceUrl);
			$('#sentenceLike').text(data.dailySentenceLike);
			$('#sentenceDisLike').text(data.dailySentenceDisLike);
			
		});
	}

	function dailySentenceLike(){
		$.post("dailySentenceLike", { dailySentenceId: $("#dailySentenceId" ).val()},function(data) {
			showDailySentence();
		});
	}
	
	function dailySentenceDislike(){
		$.post("dailySentenceDislike", { dailySentenceId: $("#dailySentenceId" ).val()},function(data) {
			showDailySentence();
		});
	}
</script>
</body>
</html>
