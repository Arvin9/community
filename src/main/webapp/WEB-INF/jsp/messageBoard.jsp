<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-offset-2 col-md-8 col-sm-12">
				<img class="img-responsive" alt="留言板文本分析" title="留言板文本分析" src="${messageBoardAnalysis}"></img>	
			</div>
				
			<div class="col-md-offset-2 col-md-8 col-sm-12">
				<p>
					<textarea class="form-control" rows="4" id="messageContent"
							placeholder="想表达自己的想法？想提出问题？在这里你可以畅所欲言！"></textarea>
				</p>
				<p>
					<button type="button" class="btn btn-lg btn-primary" onclick="submitMessage()">提交留言</button>	
				</p>
			</div>
			<div class="col-md-offset-2 col-md-8 col-sm-12">
				<ul class="media-list list-group" id="messageBoard">
					<!--  留言板样式测试
					<li class="media list-group-item" >
				    	<div class="media-left">
				      		<a href="#">
				        		<img class="media-object" style="height: 40px;width: 40px" src="../resources/images/20160821.png" alt="...">
				      		</a>
				    	</div>
				    	<div class="media-body">
				      		<h4 class="media-heading">Media heading</h4>
				      		<p>
				      			想表达自己的想法？想提出问题？在这里你可以畅所欲言！
				      		</p>
				      		<p>
				      			<em>时间：</em>
				      		</p>
				      		 
				    	</div>
				    	<div class="media-right">
				    		<a onclick="" class="btn btn-danger" role="button">
			        			<span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
	  							<span class="badge" id="sentenceLike"></span>
			        		</a>
				    	</div>
				  	</li>
				  	-->
				</ul>
			</div>
			
			
		</div>
		<!-- /row -->	
		<!-- 静态包含 -->
		<%@include file="include/foot.jsp"%>

	</div>
	<!-- /container -->
	
	<script>
	$(function(){
		getMessageBoard();
	});
	
	function submitMessage(){
		if (!$('#messageContent').val()){
			return;
		}
		$.post("submitMessage", { messageBoardContent: $('#messageContent').val()},function(data){
			$.messager.alert("消息", "留言成功!",'info');
			$('#messageContent').val("");
			$('#messageBoard').children().remove();
			getMessageBoard();
		});
	}
	
	function getMessageBoard(){
		$.get("getMessageBoard",function(data){
			for (var i = 0, len = data.length; i < len; i++){
				var content = '<li class="media list-group-item">'+
								'<div class="media-left">'+
									'<a href="#">'+
										'<img class="media-object" style="height: 40px;width: 40px" src="resources/images/20160821.png" alt="...">'+
									'</a>'+
								'</div>'+
								'<div class="media-body">'+
									'<h4 class="media-heading">'+ data[i].userAccount +'</h4>'+
									'<p>'+ 
										data[i].messageBoardContent + 
									'</p>'+
									'<p>'+
										'<em>时间：'+ data[i].messageBoardAddTime +'</em>'+
									'</p>'+
								'</div>'+
								'<div class="media-right">'+
									'<a onclick="messageBoardSupport('+ data[i].messageBoardId +')" class="btn btn-danger" role="button">'+
										'<span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>&nbsp;&nbsp;'+
										'<span class="badge" id="messageBoardSupportValue'+ data[i].messageBoardId +'">'+ data[i].messageBoardSupport +'</span>'+
									'</a>'+
								'</div>'+
							'</li>';
				$('#messageBoard').append(content);
			}
		});
	}
	function messageBoardSupport(value){
		$.post('submitMessageSupport',{messageBoardId : value},function(data){
			var messageBoardSupportValue = 'messageBoardSupportValue' + value;
			$('#' + messageBoardSupportValue).text(+$('#' + messageBoardSupportValue).text() + 1);
		});
	}
	
</script>
</body>
</html>
