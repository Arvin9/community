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
					<div class="panel-heading">Panel heading</div>
					<form class="form-horizontal">
						<div class="form-group">
							<input id="exercisesId" hidden="hidden"/>
						</div>
						<div class="form-group">
						 	<label class="col-sm-2 control-label" >标题</label>
						    <div class="col-sm-8">
						    	<p class="form-control-static" id="exercisesTitle"></p>
						    </div>
						 </div>
						 <div class="form-group">
						 	<label class="col-sm-2 control-label" >内容</label>
						    <div class="col-sm-8">
						    	<p class="form-control-static" id="exercisesContent"></p>
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
		  	<div class="col-sm-3"></div>
		</div>
<script>
	$(function(){
		getExercises();
	});
	
	function getExercises(){
		$.ajax({
			url : "${ctx}/getExercisesByUserAccount",
			type : "GET",
			data : {
				userAccount : $('#topUserAccount').text()
			},
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
		alert($('#exercisesId').val());
		alert($('#exercisesAnswer').val());
	}

</script>

		<%-- 页面修改内容块end  --%>
		<%-- 静态包含 --%>
		<%@include file="include/foot.jsp"%>
	</div>
	<%-- /container --%>
</body>
</html>
