<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
		<div class="row">
			<div class="col-sm-9">
				<div class="page-header">
					<h1>
						Welcome to 
						<small>Grocery</small>
					</h1>
				</div>
				<div class="row">
	        	<div class="col-sm-12" id="showArticle">
	            </div>
	        </div>
				
			</div>
			
			<div class="col-sm-3">
				<div class="thumbnail">
			    	<div class="caption">
			    		<h3 style="text-align:center" id="currentTime">2016-09-28 14:34:33</h3>
			        	<p>
			        		<button type="button" class="btn btn-primary btn-lg btn-block">签到</button>
			        	</p>
			      	</div>
			    </div>
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
		$.get( "articleQueryForShow", function(data) {
			console.log(data);
			articlePrint(data);
		});
		showDailySentence();
		//签到模块的当前时间
		currentTime();
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
		var url = "articleDetail?articleId=";
		url += articleId;
		window.open(url);
	}
	
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
	
	function currentTime(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var d = date.getDate();
		var h = date.getHours();
		var m = date.getMinutes();
	    var s = date.getSeconds();
	    month = month>9?month:('0'+month);
	    d = d>9?d:('0'+d);
	    h = h>9?h:('0'+h);
	    m = m>9?m:('0'+m);
	    s = s>9?s:('0'+s);
	    var time = ''+year+'-'+month+'-'+d+' '+h+':'+m+':'+s;
	    $('#currentTime').html(time);
	    t = setTimeout(currentTime,1000); //设定定时器，循环执行  	    
	}
</script>
</body>
</html>
