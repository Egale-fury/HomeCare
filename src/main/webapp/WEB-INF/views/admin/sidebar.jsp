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
<title>�����</title>
<link rel="stylesheet" href="../css/layout.css" type="text/css" media="screen" />
</head>
<body>
		<div id="sidebar">
		<h3>������̬</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a 
				href="<%= basePath%>common/addarticle.jsp" >����̬</a></li>
			<li class="icn_edit_article"><a href="#">�༭</a></li>
			<li class="icn_categories"><a href="test.jsp">�鿴</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li> -->
		</ul>
		<h3>������Ϣ</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">������Ϣ</a></li>
			<li class="icn_edit_article"><a href="#">�༭</a></li>
			<li class="icn_categories"><a href="#">�鿴</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li> -->
		</ul>
		<h3>����֪ʶ</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">����֪ʶ</a></li>
			<li class="icn_edit_article"><a href="#">�༭</a></li>
			<li class="icn_categories"><a href="#">�鿴</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li>-->
		</ul>
		<h3>�Ļ�����</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">������Ϣ</a></li>
			<li class="icn_edit_article"><a href="#">�༭</a></li>
			<li class="icn_categories"><a href="#">�鿴</a></li>
			<!--<li class="icn_tags"><a href="#">Tags</a></li>-->
		</ul>
		<h3>�û���Ϣ</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">�����û�</a></li>
			<li class="icn_view_users"><a href="#">�༭</a></li>
			<li class="icn_profile"><a href="#">�鿴</a></li>
		</ul>

		<div>
			<hr />
			<p>
				<strong>��Ȩ���У�̫���г������������ Copyright @ 2012-2014 All Rights
					Reserved ��ICP��10218904��</strong>
			</p>
		</div>
	    </div>
</body>
</html>