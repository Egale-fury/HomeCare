<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>頁面頂部</title>
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css" media="screen" />
</head>

<body>
	<div id="head">
	<div id="header">

		<div class="site_title">
			<a href="index.html">德兴镇城厢社区</a>
		</div>
		<div class="section_title">社区居民健康管理系统</div>
		<div class="btn_view_site">
			<a href="<%=basePath %>backlogin.html">注销</a>
		</div>

	</div>
	<!-- end of header bar -->

	<div id="secondary_bar">
		<div class="user">
			<p>
				${admin.userName} 
			</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<div class="breadcrumbs">
				<a href="index.html">管理系统</a>
				<div class="breadcrumb_divider"></div>
				<a class="current">信息栏</a>
			</div>
		</div>
	</div>
  </div>
</body>


</html>