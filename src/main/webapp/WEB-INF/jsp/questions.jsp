<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>
	<h3 style="text-align:center" id="currentTime"></h3>
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
	      <p>判断题</p>
	    </div>
	    
	    <div id="program" class="tab-pane fade">
	      <h3>程序题</h3>
	      <p>程序题</p>
	    </div>
	</div>

	<!-- 静态包含 -->
	<%@include file="include/foot.jsp"%>

</div>
<!-- /container -->
		
<script type="text/javascript">
	var choiceQuestionList = ${choiceQuestionList};

	$(function(){
		currentTime();
		choiceQuestionPrint(choiceQuestionList);

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
