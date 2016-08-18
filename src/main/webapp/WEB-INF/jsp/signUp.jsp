<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<base href="<%=basePath%>">

		<title>注册页面</title>
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
			
			<form class="form-horizontal form-signin" id="signUpFrom" method="POST">
				<h2 class="form-signin-heading">
					Register
				</h2>
			  	<div class="form-group">
			    	<div class="col-sm-12">
			      		<input type="text" class="form-control" id="userAccount" name="userAccount" placeholder="User Account" autofocus>
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<div class="col-sm-12">
			      		<input type="text" class="form-control" id="email" name="email" placeholder="Email">
			    	</div>
			  	</div>
			  	
			  	<div class="form-group">
			    	<div class="col-sm-12">
			      		<input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password">
			    	</div>
			    	<div hidden="hidden">
			    		<input type="password" class="form-control" id="password"  />
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<div class="col-sm-12">
			      		<input type="password" class="form-control" id="repetPassword" name="repetPassword" placeholder="Repet Password">
			    	</div>
			  	</div>
			  	
			  	<div class="form-group">
			    	<div class=" col-sm-12">
			      	<button type="submit" class="btn btn-primary btn-block">注册</button>
			    	</div>
			  	</div>
			</form>
		</div>
		<!-- /container -->
		
		
		<script type="text/javascript">

	$.validator.setDefaults( {
		submitHandler: function () {
			debug:true;
			alert( "消息提交成功!" );
			form.submit();
		}
	} );
	$.extend(jQuery.validator.messages, {
		equalTo : "请再次输入相同的密码",
		remote : "该用户名已被使用,换一个试试"
	});
	$().ready(function() {
		$("#signUpFrom").validate( {
			rules: {
				userAccount:{
					required: true,
					minlength: 6,
					maxlength: 16,
					remote: {
					    url: "hasUserAccount",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					    	userAccount: function() {
					            return $("#userAccount").val();
					        }
					    },
					    dataFilter: function(data){
					    	var obj = $.parseJSON(data);
					    	return obj.msg;
					    }
					}
				},
				email:{
					required: true,
					email:true
				},
				inputPassword:{
					required: true,
					minlength: 6,
					maxlength: 16
				},
				repetPassword:{
					required: true,
					minlength: 6,
					maxlength: 16,
					equalTo : "#inputPassword"
				}
			},
			messages: {
				userAccount: {
					required: "请输入您的账号名称(由6~16个英文字母组成)",
					minlength: "您的账号名称至少6个字母,至多16个字母"
				},
				email: "请输入有效邮箱地址",
				inputPassword : {
					required : "请输入密码",
					minlength : "密码长度为6至16位"
				},
				repetPassword : {
					required : "请输入密码",
					minlength : "密码长度为6至16位"
				}
				
			},
			
			
		} );
	} );
	</script>
		
	</body>
</html>
