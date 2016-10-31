<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
	<h3 style="text-align:center" id="countDown"></h3>
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation" class="active"><a data-toggle="tab" href="#choice">选择题</a></li>
		<li role="presentation"><a data-toggle="tab" href="#judge">判断题</a></li>
		<li role="presentation"><a data-toggle="tab" href="#program">程序题</a></li>
	</ul>
	<div class="tab-content">
    	<div id="choice" class="tab-pane fade in active">
	    	<h3>选择题</h3>
	    	<ul class="media-list list-group" id="choiceQuestionShow">
			 
		  	</ul>
		  	<button type="button" class="btn btn-primary" onclick="choiceSave()">保存</button>
	    </div>
	    
	    <div id="judge" class="tab-pane fade">
	    	<h3>判断题</h3>
	    	<ul class="media-list list-group" id="judgeQuestionShow">
			 
		  	</ul>
	    </div>
	    
	    <div id="program" class="tab-pane fade">
	    	<h3>程序题</h3>
	    	<ul class="media-list list-group" id="programQuestionShow">
			 
		  	</ul>
	    </div>
	</div>

	<!-- 静态包含 -->
	<%@include file="include/foot.jsp"%>

</div>
<!-- /container -->
		
<script type="text/javascript">
	var choiceQuestionList = ${choiceQuestionList};
	var judgeQuestionList = ${judgeQuestionList};
	var programQuestionList = ${programQuestionList};
	var examEndTime = "${examEndTime}";
	
	var timerHandle;
	
	$(function(){
		examEndTime = new Date(Date.parse(examEndTime.toString().replace(/-/g, "/")));
		examEndTime = examEndTime.getTime();
		countDown();
		choiceQuestionPrint(choiceQuestionList);
		judgeQuestionPrint(judgeQuestionList);
		programQuestionPrint(programQuestionList);
	});
	
	function choiceSave(){
		var choiceAnswer = new Array();
		
		$.each(choiceQuestionList,function(index,obj){
			var choice = new Object();
			var item = $('input[name="optionsRadios_' + obj.id +'"]:checked').val();
			choice.id = obj.id;
			choice.answer = item;
			choiceAnswer.push(choice);
	
		});
		console.log(choiceAnswer);
	}
	
	function programQuestionPrint(data){
		$.each(data,function(index,obj){
			index += 1;
			var content = '<li class="media list-group-item">'+
	   	 						'<div class="media-body">'+
      								'<h4 class="media-heading">'+ index + '、' + obj.question + '</h4>'+
            						'<textarea class="form-control" rows="10" style="width:100%"></textarea>'+
								'</div>'+
     						'</li>';
			$('#programQuestionShow').append(content);
		});
	}
	
	function judgeQuestionPrint(data){
		$.each(data,function(index,obj){
			index += 1;
			var content = '<li class="media list-group-item">'+
	   	 						'<div class="media-body">'+
      								'<h4 class="media-heading">'+ index + '、' + obj.question + '</h4>'+
            						'<div class="radio">'+
										'<label>'+
											'<input type="radio" name="optionsRadios_'+ obj.id +'" value="1" >'+
			    								'对' +
			  							'</label>'+
									'</div>'+
									'<div class="radio">'+
										'<label>'+
			    							'<input type="radio" name="optionsRadios_'+ obj.id +'" value="0">'+
			    								'错' +
			  							'</label>'+
									'</div>'+
								'</div>'+
     						'</li>';
			$('#judgeQuestionShow').append(content);
		});
	}
	
	function choiceQuestionPrint(data){
		$.each(data,function(index,obj){
			index += 1;
			var content = '<li class="media list-group-item">'+
	   	 						'<div class="media-body">'+
      								'<h4 class="media-heading">'+ index + '、' + obj.question + '</h4>'+
            						'<div class="radio">'+
										'<label>'+
											'<input type="radio" name="optionsRadios_'+ obj.id +'" value="1" >'+
			    								obj.choice1 +
			  							'</label>'+
									'</div>'+
									'<div class="radio">'+
										'<label>'+
			    							'<input type="radio" name="optionsRadios_'+ obj.id +'" value="2">'+
			    								obj.choice2 +
			  							'</label>'+
									'</div>'+
									'<div class="radio">'+
										'<label>'+
											'<input type="radio" name="optionsRadios_'+ obj.id +'" value="3">'+
												obj.choice3 +
			  							'</label>'+
									'</div>'+
									'<div class="radio">'+
										'<label>'+
											'<input type="radio" name="optionsRadios_'+ obj.id +'" value="4">'+
												obj.choice4 +
			  							'</label>'+
									'</div>'+
								'</div>'+
     						'</li>';
			$('#choiceQuestionShow').append(content);
		});
	}
	
	function countDown(){
		var currentDate = new Date();
		currentDate = currentDate.getTime();
		
		/*
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
	    */
	    var time = Math.ceil((examEndTime - currentDate)/1000);
	    if (time < 0){
	    	console.log("时间结束");
	    	clearTimeout(timerHandle);
	    	return;
	    }
		var ss = time % 60;
		ss = ss<10?('0'+ss):ss;
		time = Math.floor(time/60);
		var mm = time % 60;
		mm = mm<10?('0'+mm):mm;
		var hh = Math.floor(time/60);
		
		var showTime = ''+hh+':'+mm+':'+ss;
	    $('#countDown').html(showTime);
	    timerHandle = setTimeout("countDown()",1000); //设定定时器，循环执行  	    
	}
		
</script>

</body>
</html>
