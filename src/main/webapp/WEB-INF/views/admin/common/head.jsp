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
<title>ͷ��</title>
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css" media="screen" />
</head>
<body>
	<div id="head">
	<div id="header">

		<div class="site_title">
			<a href="index.html">�������������</a>
		</div>
		<div class="section_title">�������񽡿�����ϵͳ</div>
		<div class="btn_view_site">
			<a href="index.html">ע��</a>
		</div>

	</div>
	<!-- end of header bar -->

	<div id="secondary_bar">
		<div class="user">
			<p>
				������ (<a href="#">3����Ϣ</a>)
			</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<div class="breadcrumbs">
				<a href="index.html">����ϵͳ</a>
				<div class="breadcrumb_divider"></div>
				<a class="current">��Ϣ��</a>
			</div>
		</div>
	</div>
  </div>
</body>
</html>