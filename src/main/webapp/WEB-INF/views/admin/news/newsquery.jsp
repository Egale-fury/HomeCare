<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css" media="screen" />
</head>
<body>
	<div id="head_content">
		<jsp:include page="../common/head.jsp"></jsp:include>
	</div>
	<div id="sidebar_content">
		<jsp:include page="../common/sidebar.jsp"></jsp:include>
	</div>
	<div id="main_content">
		
			<div id="content">
				<div class="articletitle">${querynewscontent.title}</div>
				<div class="dateandauthor">日期：<fmt:formatDate value="${querynewscontent.date}" pattern="yyyy-MM-dd  HH:MM"/>
					【信息来源】作者：${querynewscontent.authorName}</div>
				<div id="articlecontent">${querynewscontent.article}</div>
			</div>
	
	</div>
</body>
</html>