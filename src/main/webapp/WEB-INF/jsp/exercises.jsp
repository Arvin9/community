<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
		<%-- 动态包含 --%>
		<jsp:include page="include/top.jsp"></jsp:include>
		<%-- 页面修改内容块start  --%>
		
		<div class="row">
			<div class="col-md-3 col-sm-12">
		  		<%-- 排行榜  --%>
		  		<div class="panel panel-danger">
					<div class="panel-heading">
				    	<h3 class="panel-title">实力排行榜</h3>
				  	</div>
				  	<table class="table table-hover">
				  		<thead>
					  		<tr>
					  			<th>#</th>
					  			<th>用户</th>
					  			<th>题数</th>
					  		</tr>
					  	</thead>
					  	<tbody id = "rankContent">
					  		
					  	</tbody>
				 	</table>
				</div>
		  		<%-- /排行榜 --%>
		  	</div>
		  	
		  	<div class="col-md-6 col-sm-12">
		  		<%-- pannel --%>
				<div class="panel panel-info">
					<div class="panel-heading" id="exercisesTitle"></div>
					<form class="form-horizontal">
						<div class="form-group">
							<input id="exercisesId" hidden="hidden"/>
						</div>
						
						 <div class="form-group">
						 	<label class="col-sm-2 control-label" >内容</label>
						    <div class="col-sm-8">
						    	<!--  <div class="form-control" id="exercisesContent">
						    	</div>
						    	-->
						    	<pre class="pre-scrollable" id="exercisesContent">
						    	</pre>
						    	
						    </div>
						 </div>
						 <div class="form-group">
						 	<label class="col-sm-2 control-label" >答案</label>
						    <div class="col-sm-8">
						    	<input id="exercisesAnswer" class="form-control" placeholder="请输入答案"/>
						    </div>
						 </div>
						 <div class="form-group">
						 	<label class="col-sm-2 control-label" ></label>
						    <div class="col-sm-8">
						    	<div id="exercisesHint" class="alert alert-warning" hidden="hidden"></div>
						    </div>
						 </div>
						 <div class="form-group">
						 	<label class="col-sm-2 control-label" ></label>
						    <div class="col-sm-8">
						    	<div id="exercisesError" class="alert alert-danger alert-dismissible" hidden="hidden"></div>
						    </div>
						 </div>
						<div class="form-group">
							<div class="col-sm-1 control-label"></div>
							<div class="col-sm-10 control-label">
								<a role="button"  class="btn btn-block btn-info" onclick="submitExercises()">提交</a>
							</div>
						</div>
					</form>
				</div>
				<%-- /pannel --%>
		  	</div>
		  	<div class="col-md-3 col-sm-12">
		  		<%-- 积分排行榜  --%>
		  		<div class="panel panel-danger">
					<div class="panel-heading">
				    	<h3 class="panel-title">积分排行榜</h3>
				  	</div>
				  	<table class="table table-hover">
				  		<thead>
					  		<tr>
					  			<th>#</th>
					  			<th>用户</th>
					  			<th>积分</th>
					  		</tr>
					  	</thead>
					  	<tbody id = "integralContent">
					  		
					  	</tbody>
				 	</table>
				</div>
		  		<%-- /积分排行榜 --%>
		  	</div>
		</div>
<script>
	$(function(){
		getExercises();
		showDailySentence();
		exercisesRank();
	});
	
	function getExercises(){
		$.ajax({
			url : "getExercisesByUserAccount",
			type : "GET",
			success: function(data){
				if(230 == data.ret){
					$('#exercisesError').text(data.msg);
					$('#exercisesError').show();
					$('#exercisesId').val("");
					$('#exercisesTitle').text("没有题目了!");
					$('#exercisesContent').text("没有题目了,请联系管理员!");
				}
				if(200 == data.ret){
					var obj = $.parseJSON(data.data);
					$('#exercisesId').val(obj.exercisesId);
					$('#exercisesTitle').text(obj.exercisesTitle);
					$('#exercisesContent').text(obj.exercisesContent);
					$('#exercisesHint').text(obj.exercisesHint);
				}
			}
		});
	}
	function submitExercises(){
		var exercisesAnswer = $('#exercisesAnswer').val();
		if( "" == exercisesAnswer){
			$('#exercisesHint').show();
		}else{
			$.ajax({
				url : "submitExercises",
				type : "POST",
				data : {
					exercisesId : $('#exercisesId').val(),
					exercisesAnswer : exercisesAnswer
				},
				success: function(data){
					var data = data;
					console.info(data);
					console.info(data.msg);
					if(200 == data.ret){
						$.messager.alert("消息", "回答正确,进入下一题.");
						getExercises();
					}
					if(400 == data.ret){
						$('#exercisesError').text(data.msg);
						$('#exercisesHint').show();
						$('#exercisesError').show();
					}
				}
			});
		}
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
	
	function exercisesRank(){
		//答题排行榜
		$.get( "getExercisesRank", function(data) {
			for (var i = 0,len = data.length ; i < len ; i++){
				var coutent = '<tr>'+
								'<td>'+ (i+1) +'</td>' +
								'<td>'+ data[i].userAccount +'</td>' +
								'<td>'+ data[i].amount +'</td>' +
								'</tr>';
				$('#rankContent').append(coutent);
			}			
		});
		//积分排行榜
		$.get( "getIntegralRank", function(data) {
			for (var i = 0,len = data.length ; i < len ; i++){
				var coutent = '<tr>'+
								'<td>'+ (i+1) +'</td>' +
								'<td>'+ data[i].userAccount +'</td>' +
								'<td>'+ data[i].integral +'</td>' +
								'</tr>';
				$('#integralContent').append(coutent);
			}			
		});
	}
</script>

		<%-- 页面修改内容块end  --%>
		<%-- 静态包含 --%>
		<%@include file="include/foot.jsp"%>
	</div>
	<%-- /container --%>
</body>
</html>
