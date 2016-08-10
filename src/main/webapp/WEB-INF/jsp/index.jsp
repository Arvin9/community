<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<!-- 动态包含 -->
	<jsp:include page="include/top.jsp"></jsp:include>

		<div class="page-header">
			<h1>
				Welcome to 
				<small>Nebula web site</small>
			</h1>
		</div>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>
				Hello World
			</h1>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;
					Wherever you are, and whoever you may be, 
				there is one thing in which you and I are just alike at this monment, 
				and in all the moments of our existence. 
				We are not at rest, we are on a journey. 
				Our life is a movement, a tendency, a steady, ceaseless progress towards an unseen goal.
			</p>
			<p>
				<a class="btn btn-lg btn-primary" href="${ctx}/contact" role="button">Contact me &raquo;</a>
			</p>
		</div>
		
		<!-- 静态包含 -->
		<%@include file="include/foot.jsp"%>

	</div>
	<!-- /container -->
</body>
</html>
