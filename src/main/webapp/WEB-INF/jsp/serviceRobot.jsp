<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
		<div style="overflow: auto">
		<!-- Area Charts:Morris --><!-- Chat -->
		<div class="col-sm-offset-3 col-sm-6" > 
			<div class="widget-container scrollable chat" style="height: 450px;">
				<div class="heading">
					<i class="icon-comments"></i>客服机器人<i class="icon-smile pull-right"></i>
				</div>
				<div class="widget-content padded" id="scroll">
					<ul id="scrolValue">
						<!--  
						<li>
							<img width="30" height="30" src="images/avatar-male.jpg" />
							<div class="bubble">
								<a class="user-name" href="#">客服机器人</a>
								<p class="message">您好，我是客服机器人，有什么可以帮您的吗？</p>
								<p class="time">
									<strong>今天 </strong>下午 3:53
								</p>
							</div>
						</li>
						<li class="current-user">
							<img width="30" height="30" src="images/avatar-female.jpg" />
							<div class="bubble">
								<a class="user-name" href="#">王晓</a>
								<p class="message">尽管你一脸不真诚，但我听着很高兴。——《梦想照进现实》</p>
								<p class="time">
									<strong>今天 </strong>下午 3:53
								</p>
							</div>
						</li>
						-->
					</ul>
				</div>
				<div class="post-message">
					<input class="form-control" placeholder="请输入您需要发送的信息…" type="text" id="sendMessage"  
							onkeydown='if(event.keyCode==13){sendMessage(); $("#sendMessage").val(""); }'>
					<input type="submit" onclick="sendMessage()"  value="发送">
				</div>
			</div>
		</div>
		<!-- End Chat -->
		</div>
		<!-- 静态包含 -->
		<%@include file="include/foot.jsp"%>
		
	</div>
	<!-- /container -->
	<script >
	$(function(){
		//滚动条置底
		document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		$.post("askRobot", { message: "你好"},function(data){
			var obj = $.parseJSON(data);
			console.log(obj);
			var content = '<li>'+ 
						      '<img width="30" height="30" src="resources/images/icon36.png" />' + 
							  '<div class="bubble">' + 
							     '<a class="user-name" href="#">客服机器人</a>' + 
								 '<p class="message">'+ obj.text +'</p>' + 
								 '<p class="time">' + 
								     '<strong>今天 </strong>' + getTime() + 
								 '</p>' + 
							   '</div>' + 
						  '</li>';
			$('#scrolValue').append(content);
			//滚动条置底
			document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		});
	});
	function sendMessage(){
		var userMessage = $('#sendMessage').val();
		if (!userMessage) return;
		var userAccount = "游客";
		var userContent = '<li class="current-user">'+ 
						      '<img width="30" height="30" src="resources/images/500137.gif" />' + 
							  '<div class="bubble">' + 
							     '<a class="user-name" href="#">'+ userAccount + '</a>' + 
								 '<p class="message">'+ userMessage +'</p>' + 
								 '<p class="time">' + 
								     '<strong>今天 </strong>' +  getTime() + 
								 '</p>' + 
							   '</div>' + 
						  '</li>';
		$('#scrolValue').append(userContent);
		//滚动条置底
		document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		$.post("askRobot", { message: userMessage},function(data){
			var obj = $.parseJSON(data);
			console.log(obj);
			var content = '<li>'+ 
						      '<img width="30" height="30" src="resources/images/icon36.png" />' + 
							  '<div class="bubble">' + 
							     '<a class="user-name" href="#">客服机器人</a>' + 
								 '<p class="message">'+ obj.text +'</p>' + 
								 '<p class="time">' + 
								     '<strong>今天 </strong>' +  getTime() + 
								 '</p>' + 
							   '</div>' + 
						  '</li>';
			$('#scrolValue').append(content);
			//滚动条置底
			document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		});
	}
	
	function getTime(){
		//获得当前时间 如,16:12:30
		var myDate = new Date();
		var hour = myDate.getHours();         //获取当前小时数(0-23)
	    var minute = myDate.getMinutes();     //获取当前分钟数(0-59)
	    minute = minute<10?('0'+minute):minute
		var second = myDate.getSeconds();     //获取当前秒数(0-59)
		second = second<10?('0'+second):minute
		return hour + ':' + minute + ':' + second;
	}
	
	
	</script>
</body>
</html>