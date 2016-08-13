<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
		<%-- 动态包含 --%>
		<jsp:include page="include/top.jsp"></jsp:include>
		<%-- 页面修改内容块start  --%>
		
		<div class="row">
			<div class="col-sm-3"></div>
		  	<div class="col-sm-6">
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
							<div class="col-sm-1 control-label"></div>
							<div class="col-sm-10 control-label">
								<button type="button " class="btn btn-block btn-info" onclick="submitExercises()">提交</button>
							</div>
						</div>
							
				
					</form>
				</div>
				<%-- /pannel --%>
		  	</div>
		  	<div class="col-sm-3">
		  		<%-- showDailySentence  --%>
		  		<div class="thumbnail">
			    	<img src="http://image.wufazhuce.com/Fgxm1O_Gi9ff9K5qx5GawiapTAhR" alt="...">
			    	<div class="caption">
			    		<h3 id="dailySentenceId">每日一句</h3>
			        	<p id="dailySentence"></p>
			        	<p class="pager">
			        		<a onclick="dailySentenceLike()" class="btn btn-danger" role="button">like</a> 
			        		<a onclick="dailySentenceDislike()" class="btn btn-warning" role="button">dislike</a>
			        	</p>
			      	</div>
			    </div>
		  		<%-- /showDailySentence --%>
		  	</div>
		</div>
<script>
	$(function(){
		getExercises();
		showDailySentence();
	});
	
	function getExercises(){
		$.ajax({
			url : "getExercisesByUserAccount",
			type : "GET",
			success: function(data){
				if(!data.data){
					alert("没有题目了");
					return;
				}
				var obj = $.parseJSON(data.data);
				
				$('#exercisesId').val(obj.exercisesId);
				$('#exercisesTitle').text(obj.exercisesTitle);
				$('#exercisesContent').text(obj.exercisesContent);
			}
		});
	}
	function submitExercises(){
		$.ajax({
			url : "submitExercises",
			type : "POST",
			data : {
				exercisesId : $('#exercisesId').val(),
				exercisesAnswer :$('#exercisesAnswer').val()
			},
			success: function(data){
				if(200 == data.status){
					alert(data.msg);
					console.log(data);
				}else{
					alert(data.msg);
				}
			}
		});
	}
	
	function showDailySentence(){
		$.get("getDailySentence", function(data) {
			$("#dailySentenceId" ).val(data.dailySentenceId);
			$("#dailySentence" ).text(data.dailySentence);
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

		<%-- 页面修改内容块end  --%>
		<%-- 静态包含 --%>
		<%@include file="include/foot.jsp"%>
	</div>
	<%-- /container --%>
</body>
</html>
