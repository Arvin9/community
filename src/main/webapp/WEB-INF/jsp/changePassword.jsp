<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<base href="<%=basePath%>">

		<title>忘记密码</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Bootstrap -->
		<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=path%>/resources/css/signin.css" rel="stylesheet">
		<script src="<%=path%>/resources/jquery/1.11.1/jquery.min.js"></script>
		<script src="<%=path%>/resources/js/md5.min.js"></script>
		<script src="<%=path%>/resources/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
		<script src="<%=path%>/resources/bootstrap-jquery/jquery.bootstrap.min.js"></script>
		
		<script src="<%=path%>/resources/js/md5.min.js"></script>
		<!-- 表单验证 -->
		<script src="<%=path%>/resources/dist/jquery.validate.js" type="text/javascript"></script>
		<script src="<%=path%>/resources/dist/additional-methods.js" type="text/javascript"></script>
  </head>
  
  <body>
		<div class="container">
			
			<form class="form-horizontal form-signin" id="signUpFrom" method="POST" action="alterPassword">
				<h2 class="form-signin-heading">
					修改密码
				</h2>
				<div class="form-group">
					<label class="col-sm-4 control-label">当前用户：</label>
					<div class="col-sm-8">
				    	<p class="form-control-static">
				      		<shiro:user>
								<shiro:principal/>
							</shiro:user>
				    	</p>
				    </div>
				</div>
			  	
			  	<div class="form-group">
			  		<label class="col-sm-4 control-label">预留邮箱：</label>
			    	<div class="col-sm-8">
			      		<input type="text" class="form-control" id="email" name="email" placeholder="Email">
			    	</div>
			  	</div>
			  	
			  
			  	<div class="form-group">
			  		<label class="col-sm-4 control-label">新密码：</label>
			    	<div class="col-sm-8">
			      		<input type="password" class="form-control" id="inputNewPassword" name="inputNewPassword" placeholder="Repeat Password">
			    		<div hidden="hidden">
			    			<input type="password" class="form-control" id="newPassword" name="newPassword"/>
			    		</div>
			    	</div>
			  	</div>
			  	<div class="form-group">
			  		<label class="col-sm-4 control-label">确认密码：</label>
			    	<div class="col-sm-8">
			      		<input type="password" class="form-control" id="repetPassword" name="repetPassword" placeholder="Repeat Password">
			    	</div>
			  	</div>
			  	
			  	<div class="form-group">
			    	<div class="col-sm-offset-4 col-sm-4">
			      		<button type="submit" class="btn btn-primary">确认</button>
			    	</div>
			    	<div class=" col-sm-4">
			    		<a class="btn btn-primary" href="index" role="botton">返回</a>
			    	</div>
			  	</div>
			</form>
		</div>
		<!-- /container -->
		
		
<script type="text/javascript">


	$.validator.setDefaults( {
		submitHandler: function () {
			var newPassword = hex_md5($('#inputNewPassword').val());
			$('#newPassword').val(newPassword);
			form.submit();
		}
	} );
	$.extend(jQuery.validator.messages, {
		email: "请输入有效邮箱地址",
		equalTo : "请再次输入相同的密码",
		remote : "该邮箱与预留邮箱不同"
	});
	$().ready(function() {
		$("#signUpFrom").validate( {
			rules: {
				email:{
					required: true,
					email:true,
					remote: {
					    url: "isUserEmail",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					    	email: function() {
					            return $("#email").val();
					        }
					    },
					    dataFilter: function(data){
					    	var obj = $.parseJSON(data);
					    	return obj.msg;
					    }
					}
				},
				inputNewPassword:{
					required: true,
					minlength: 6,
					maxlength: 16,
				},
				repetPassword:{
					required: true,
					minlength: 6,
					maxlength: 16,
					equalTo : "#inputNewPassword"
				}
			},
			messages: {
				inputNewPassword : {
					required : "请输入密码",
					minlength : "密码长度为6至16位"
				},
				repetPassword : {
					required : "请输入密码",
					minlength : "密码长度为6至16位"
				}
			},
		});
	});
	</script>
		
	</body>
</html>
