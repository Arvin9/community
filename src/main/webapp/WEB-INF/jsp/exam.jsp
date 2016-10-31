<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-offset-2 col-md-8 col-sm-12">
			<ul class="media-list list-group" id="examShow">
			  
			</ul>
		</div>
	</div>

	<!-- 静态包含 -->
	<%@include file="include/foot.jsp"%>
</div>
<!-- /container -->
		
<script type="text/javascript">
	var examList = ${examList};
	
	$(function(){
		examPrint(examList);
		detectionExam();
		timer();
	});
	
	function examPrint(data){
		$.each(data,function(index,obj){
			var content = '<li class="media list-group-item" id="id_'+ obj.id +'">'+
		   	 			      '<div class="media-body">'+
		      				      '<h4 class="media-heading">'+obj.name +'</h4>'+
		                           '<span name="beginTime" class="text-info">'+ obj.beginTime +'</span> &nbsp;~&nbsp;'+
		                           '<span name="endTime" class="text-danger">'+ obj.endTime +'</span>&nbsp;&nbsp;'+
		                           '<button type="button" class="btn btn-primary" id="butt_'+ obj.id +'" onclick="takeExam('+ obj.id +')">进入考试</button>'+
		                           '&nbsp;&nbsp;<span name="beginTime" class="text-info" id="info_'+ obj.id +'"></span>'+
		                       '</div>'+
		                   '</li>';
			$('#examShow').append(content);
		});
	}
	
	function takeExam(id){
		//参加考试,跳转到考试页面
		var beginTime;
		var endTime;
		$.each(examList,function(index,obj){
			if(obj.id == id){
				beginTime = obj.beginTime;
				endTime = obj.endTime;
			}
		});
		console.log(beginTime);
		console.log(endTime);
		var url = "${ctx}/takeExam?id=";
		url += id;
		window.location.href = url;
	}
	
	function detectionExam(){
		//检测是否是考试时间
		//考试之前,按钮显示内容为"即将开始",并显示倒计时
		//考试中,按钮显示内容为"进入考试"
		//考试后,按钮显示内容为"考试结束"
		var now_date = new Date();
		var button;
		now_date = now_date.getTime();
		$.each(examList,function(index,obj){
			if(compareTime(now_date,obj.beginTime)){
				//当前时间小于开始时间,即为"即将开始"
				var beginTime = new Date(Date.parse(obj.beginTime.replace(/-/g, "/")));
				beginTime = beginTime.getTime();
				var info = 'info_' + obj.id;
				button = 'butt_' + obj.id;
				var count_down = beginTime - now_date;
				$('#'+info).text(formatTime(count_down));
				$('#'+button).text("即将开始");
				$('#'+button).attr('disabled','disabled');
			}else{
				if(compareTime(now_date,obj.endTime)){
					//当前时间大于开始时间且小于结束时间,即为"进入考试"
					var info = 'info_' + obj.id;
					button = 'butt_' + obj.id;
					$('#'+button).text("进入考试");
					$('#'+button).removeAttr('disabled');
					$('#'+info).text('');
				}else{
					//考试结束
					button = 'butt_' + obj.id;
					$('#'+button).text("考试结束");
					$('#'+button).attr('disabled','disabled');
					 
				}
			}
		});
	}
	
	function compareTime(previous_date,later_date){
		//日期格式为 yyyy-MM-dd hh:mm:ss
		//比较两个时间,如果previous_date小于later_date返回true,否则返回false
		
		//previous_date = new Date(Date.parse(previous_date.replace(/-/g, "/")));
		//previous_date = previous_date.getTime();
		
		later_date = new Date(Date.parse(later_date.replace(/-/g, "/")));
		later_date = later_date.getTime();
		
		if(previous_date < later_date)
			return true;
		else 
			return false;
	}
	
	function formatTime(time){
		time = Math.ceil(time/1000);
		var ss = time % 60;
		var mm = Math.floor(time/60);
		ss = ss<10?('0'+ss):ss;
		return ''+mm+':'+ss; 
	}
	function timer(){
		detectionExam();
		setTimeout(timer,1000);
	}
		
</script>

</body>
</html>
