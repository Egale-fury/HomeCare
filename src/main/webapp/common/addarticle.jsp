<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../css/layout.css" type="text/css" media="screen" />
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="../js/back/hideshow.js" type="text/javascript"></script>
<script src="../js/back/jquery.tablesorter.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/back/jquery.equalHeight.js"></script>
<!-- 编辑器配置-->
<script id="container" name="content" type="text/plain"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../ueditor/ueditor.all.js"></script>
<title>主界面</title>


<style type="text/css">
#head_content {
	height: 95px;
	width: 100%;
}

#sidebar_content {
	width: 23%;
	margin-top: -6px;
	height: 680px;
	background: #E0E0E3 url(../img/sidebar.png) repeat;
	float: left;
	min-height: 500px;
}
#main_content {
	width:77%;
	height: 680px;
	margin-top: -6px;
	float: left;
	background-color: #F5F5F5 ;
}
	
	#add_content {
		position: relative;
		width: 90%;
		height: 85%;
		left: 5%;
		background-color: #F5F5F5;

	}
	#article_div{
		position: relative;
		width: 80%;
		height: 8%;
		left: 10%;
		top: 5%;
		background-color: #F5F5F5;
	}
	#author_div{
		position: relative;
		width: 80%;
		height: 8%;
		left: 10%;
		margin-top: 5%;
		background-color: #F5F5F5;
	}
	span {

		position: relative;
		width: 10%;
		height: 90%;
		left: 10%;
		top:5%;
		bottom: 5%;
		background-color: #F5F5F5;
		font-size: 15pt;
	}

	input{
		position: relative;
		width: 80%;
		height: 80%;
		left: 10%;
		top:5%;
		bottom: 5%;
		background-color: white;
		font-size: 15pt;
	}
	#ueditor {
		position: relative;
		width: 95%;
		height: 65%;
		left: 5%;
		margin-top: 3%;
		background-color: white;
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
		<div id="add_content">
   			<div id="article_div">
   				<span >标题</span>
   				&nbsp;&nbsp;
   				<input type="text">
   			
   			</div>
   			<div id="author_div">
   				<span >作者</span>
   				&nbsp;&nbsp;
   				<input type="text">
   			</div>
   			<div id="ueditor">
   				
   		    </div>
   		</div>
	</div>
	
	<script type="text/javascript">
	function e(){
		 ue = UE.getEditor('container');
		 console.log("success");
		 ue.render("ueditor"); 
	}
	//加载完页面自动调用一下函数 
	  window.onload=e;
	</script>
</body>
</html>