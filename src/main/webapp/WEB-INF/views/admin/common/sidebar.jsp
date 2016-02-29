<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>侧边栏</title>
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css" media="screen" />

<style type="text/css">

</style>
</head>
<body>
		<div id="sidebar">
		<h3>社区动态</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a 
				href="${pageContext.request.contextPath}/communityNews/add">新添动态</a></li>
			<li class="icn_categories"><a href="${pageContext.request.contextPath}/communityNews/query">查看</a></li>
		</ul>
		
		<h3>服务信息</h3>
		
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">新添信息</a></li>
			<li class="icn_categories"><a href="#">查看</a></li>
		</ul>
		
		<h3>健康知识</h3>
		
		<ul class="toggle">
			<li class="icn_new_article"><a href="${pageContext.request.contextPath}/healthTip/add">新添知识</a></li>
			<li class="icn_categories"><a href="${pageContext.request.contextPath}/healthTip/query">查看</a></li>
		</ul>
		
		<h3>文化娱乐</h3>
		
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">新添信息</a></li>
			<li class="icn_categories"><a href="#">查看</a></li>
		</ul>
		
		<h3>用户信息</h3>
		
		<ul class="toggle">
			<li class="icn_add_user"><a href="${pageContext.request.contextPath}/user/add">新添用户</a></li>
			<li class="icn_view_users"><a href="#">健康档案</a></li>
			<li class="icn_profile"><a href="#">查看</a></li>
		</ul>

		<div>
			<hr />
		
			<div class="copyright" style="font-size:15pt;color:#34495e;line-height:1">版权所有：太仓市城厢镇德兴社区 Copyright @ 2012-2014 All Rights
					Reserved 苏ICP备10218904号</div>
			
		</div>
	    </div>
</body>

<script src="<%=basePath %>js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/hideshow.js" type="text/javascript"></script>

</html>