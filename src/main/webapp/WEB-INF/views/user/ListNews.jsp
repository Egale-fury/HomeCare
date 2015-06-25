<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>居家养老服务系统>>社区动态</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="./css/listcontent.css">
	

  </head>
  
  <body>
    
	<div class="top" >
		<div class="toptitle" >
			<img src="./img/titlephoto.png" width="100%" height="100%"  />
		</div>
		<div class="menu">
			<div class="menubox">
				<ul style="padding-left: 0px;margin-bottom: 0px;">
					<li class="titleli"><a class="title" href="./index.jsp">首页</a></li>
					<li class="titleli"><a class="title" href="#">社区动态</a></li>
					<li class="titleli"><a class="title" href="#">服务信息</a></li>
					<li class="titleli"><a class="title" href="#">健康知识</a></li>
					<li class="titleli"><a class="title" href="#">文化娱乐</a></li>
					<li class="titleli"><a class="title" href="#">个人登录</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main">
	 	<div class="maintitle">
	 		<div class="titlelocationleft">
	 			<div class="arrowimg">
	 		    <img  src="./img/arrow.png">
	 		    </div>
	 			<div class="fontdiv">社区动态
	 			</div>
	 		</div>
	 		<div class="titlelocationright">
	 			<div class="locationinfo">
	 				你的位置 > 社区动态
	 			</div>
	 		</div>
	 	</div>
	 	<hr class="topline"/>
	 	<div class="maininfo">
	 		<ul class="ullist">
	 		<c:forEach items="" var="pagenation">
	 			<li class="infoli"><img  src="./img/arrow1.png" >
	 			   <a class="b" href="./articlecontent.html">奔驰总设计师：设计不会因技术进步更改</a>
	 			   <div class="date">2015.3.31</div>
	 			 </li>
			</c:forEach>
	 		</ul>
	 	</div>
	</div>
	<div class="foot">
		<div class="footbasic">
		  <div class="footbasicinfo">
		         <span style="color: white;">版权所有：太仓市城厢镇德兴社区　Copyright @ 2012-2014 All Rights Reserved 　苏ICP备10218904号 </span>
		  </div>
		</div>
	</div>
  </body>
</html>
