<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
	 <link rel="stylesheet" href="<%=basePath %>css/personcenter.css" >
     <title>个人中心</title>
     
<style type="text/css">

.personsidebar{
	position: relative;
	float: left;
	width:14%;
	height:300px;
	margin-left: 40px;
	background: url("../img/titlebg.png");
}
.top-personsidebar{
	position: relative;
	width: 100%;
	height: 30%;
	padding-left: 30px;
	padding-top: 20px;
	
	
}
.middle-personsidebar{
	position: relative;
	width: 100%;
	height: 68%;
	background-color: white;
}
.personmaincontent{
	position: relative;
	float: right;
	width: 77%;
	height: 900px;
	margin-right: 40px;
	background-color:#fef8f3;
}
ul.personallist{
	position: relative;
	list-style: none;
	width: 100%;
	height: 100%;
	-webkit-padding-start: 0px;
}
li{
	width: 100%;
	height:60px;
	padding-left: 50px;
	padding-top: 20px;
}
hr{
	position:relative;
	border-color: black;
	margin:0 auto;
	width: 100%;
}
span.dexing{
    font-family:Tahoma;
	color: white;
	font-size: 25pt;
}
</style>
</head>
<body>
	<div class="top" >
		<div class="toptitle">
			<img src="<%=basePath %>img/titlephoto.png" width="100%" height="100%" />
		</div>
		<div class="menu">
			<div class="menubox">
				<div class="menuboxchoice">
				<a class="title" href="#" > 首页</a> 
				<a class="title" href="/Home-BasedCare/communityNews/listNews/0/15" >社区动态</a> 
				<a class="title" href="#" >服务信息</a> 
				<a class="title" href="/Home-BasedCare/healthTip/listtips/0/15" >健康知识</a> 
				<a class="title" href="#" >文化娱乐</a> 
				<a class="title" href="/Home-BasedCare/user/skiptologin" >个人登录</a> 
				</div>
			</div>
		</div>
		<hr >
	</div>
	
	<div class="personsidebar">
		<div class="top-personsidebar">
			<span class="dexing">德兴社区</span>
		</div>
		<div class="middle-personsidebar">
			<ul class="personallist">
				<li ><a class="b"  href="#" ><span style="font-size: 12pt">基本信息</span></a></li>
				<hr/>
				<li ><a class="b"  href="#" ><span style="font-size: 12pt">信息档案</span></a></li>
				<hr/>
				<li ><a class="b"  href="#" ><span style="font-size: 12pt">在线留言</span></a></li>
				<hr/>
			</ul>
		</div>
	</div>
	
	<div class="personmaincontent">
		
	</div>
	

		
</body>
</html>