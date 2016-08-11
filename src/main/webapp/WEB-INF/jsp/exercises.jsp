<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
		<%-- 动态包含 --%>
		<jsp:include page="include/top.jsp"></jsp:include>
		<%-- 页面修改内容块start  --%>
		
		<div class="row">
			<div class="col-md-3"></div>
		  	<div class="col-md-6">
		  		<%-- pannel --%>
				<div class="panel panel-info">
					<div class="panel-heading">Panel heading</div>
					<table class="table">
						<tr hidden="hidden">
							<td>gh</td>
							<td>ssss1</td>
						</tr>
						<tr>
							<td>ssss</td>
							<td>ssss</td>
						</tr>
						<tr>
							<td>ssss</td>
							<td>ssss</td>
						</tr>
						<tr>
							<td>ssss</td>
							<td>ssss</td>
						</tr>
					</table>
				</div>
				<%-- /pannel --%>
		  	</div>
		  	<div class="col-md-3"></div>
		</div>

		


		<%-- 页面修改内容块end  --%>
		<%-- 静态包含 --%>
		<%@include file="include/foot.jsp"%>
	</div>
	<%-- /container --%>
</body>
</html>
