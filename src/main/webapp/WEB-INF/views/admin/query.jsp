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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css"
	media="screen" />
<script src="<%=basePath %>js/back/jquery-1.5.2.min.js"></script>




<style type="text/css">
body{
	padding: 0px;
	margin: 0px;
}
#head_content {
    position:relative;
	height: 95px;
	width: 100%;
}

#sidebar_content {
    position:relative;
	width: 23%;
	margin-top: -6px;
	height: 745px;
	background: #E0E0E3 url(<%=basePath %>img/sidebar.png) repeat;
	float: left;
	min-height: 500px;
}
#main_content {
    position:relative;
	width: 76%;
	min-height: 720px;
	overflow:auto;
	background-color: #FFFFFF;
}

#content {
	position: relative;
	margin : 10px auto;
	width: 90%; 
	height:100%;
	overflow: auto;
}

/* 文章的标题  */
.articletitle {
	position: relative;
	width: 75%;
	margin: 10px auto;
	height: 5%;
	text-align: center;
	font-size: 2em;
	font-weight: bold;
}
/* 文章的时间和标题  */
.dateandauthor {
	position: relative;
	width: 75%;
	margin: 5px auto;
	height: 25px;
	text-align: center;
	font-weight: bold;
	background-color: #E3E3E3;
	padding-top: 15px;
}

/* 文章的主题内容   */
#articlecontent {
	position: relative;
	width: 90%;
	height:90%;
	margin: auto;
	font-size: 13pt;
	overflow: auto;

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
		
			<div id="content">
				<div class="articletitle">${querynewscontent.title}</div>
				<div class="dateandauthor">日期：<fmt:formatDate value="${querynewscontent.date}" pattern="yyyy-MM-dd  HH:MM"/>
					【信息来源】作者：${querynewscontent.authorName}</div>
				<div id="articlecontent">${querynewscontent.article}</div>
			</div>
	
	</div>
</body>
</html>