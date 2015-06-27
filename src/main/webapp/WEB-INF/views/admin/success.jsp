<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css"
	media="screen" />
<script src="<%=basePath %>js/back/jquery-1.5.2.min.js"></script>

<style type="text/css">
#head_content {
	height: 95px;
	width: 100%;
}

#sidebar_content {
	width: 23%;
	margin-top: -6px;
	height: 745px;
	background: #E0E0E3 url(../img/sidebar.png) repeat;
	float: left;
	min-height: 500px;
}

#main_content {
	width: 77%;
	height: 680px;
	margin-top: -6px;
	float: left;
	background-color: #fff;
}
#success_div{
    position:relative;
    margin:300px auto;
	width: 300px;
	height: 125px;
	background-image: url(../img/success.png)
}


</style>
</head>
<body>
	<div id="head_content">
		<jsp:include page="./head.jsp"></jsp:include>
	</div>
	<div id="sidebar_content">
		<jsp:include page="./sidebar.jsp"></jsp:include>
	</div>
	<div id="main_content">
		<div id="success_div"></div>
	</div>


	

</body>
</html>