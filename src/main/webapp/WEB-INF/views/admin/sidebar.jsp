<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>侧边栏</title>
<link rel="stylesheet" href="../css/layout.css" type="text/css" media="screen" />
</head>
<body>
		<div id="sidebar">
		<h3>社区动态</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a 
				href="<%= basePath%>common/addarticle.jsp" >新添动态</a></li>
			<li class="icn_edit_article"><a href="#">编辑</a></li>
			<li class="icn_categories"><a href="test.jsp">查看</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li> -->
		</ul>
		<h3>服务信息</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">新添信息</a></li>
			<li class="icn_edit_article"><a href="#">编辑</a></li>
			<li class="icn_categories"><a href="#">查看</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li> -->
		</ul>
		<h3>健康知识</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">新添知识</a></li>
			<li class="icn_edit_article"><a href="#">编辑</a></li>
			<li class="icn_categories"><a href="#">查看</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li>-->
		</ul>
		<h3>文化娱乐</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">新添信息</a></li>
			<li class="icn_edit_article"><a href="#">编辑</a></li>
			<li class="icn_categories"><a href="#">查看</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li>-->
		</ul>
		<h3>用户信息</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">新添用户</a></li>
			<li class="icn_view_users"><a href="#">编辑</a></li>
			<li class="icn_profile"><a href="#">查看</a></li>
		</ul>

		<div>
			<hr />
			<p>
				<strong>版权所有：太仓市城厢镇德兴社区 Copyright @ 2012-2014 All Rights
					Reserved 苏ICP备10218904号</strong>
			</p>
		</div>
	    </div>
</body>
</html>