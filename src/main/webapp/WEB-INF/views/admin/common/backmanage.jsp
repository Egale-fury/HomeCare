<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css" media="screen" />
<title>后台管理主界面</title>
</head>

<body>
	<div id="head_content">
		<jsp:include page="head.jsp"></jsp:include>
	</div>
	<div id="sidebar_content">
		<jsp:include page="sidebar.jsp"></jsp:include>
	</div>
	<div id="main_content">
		
	</div>
</body>
</html>