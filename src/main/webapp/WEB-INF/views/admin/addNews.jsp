<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css"
	media="screen" />
<script src="<%=basePath %>js/back/jquery-1.5.2.min.js"></script>
<script src="<%=basePath %>js/back/hideshow.js" type="text/javascript"></script>
<script src="<%=basePath %>js/back/jquery.tablesorter.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>js/back/jquery.equalHeight.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.all.js"></script>
<title>主界面</title>


<style type="text/css">
#head_content {
	height: 95px;
	width: 100%;
}

#sidebar_content {
	width: 23%;
	margin-top: -6px;
	height: 745px;
	background: #E0E0E3 url(../img/sidebar.png) repeat;
	float: left;
	min-height: 500px;
}

#main_content {
	width: 77%;
	min-height: 720px;
	overflow:auto;
	margin-top: -6px;
	float: left;
	padding-top:20px;
	background-color: #F5F5F5;
}

#add_content {
	position: relative;
	width: 90%;
	height: 85%;
	left: 5%;
	background-color: #F5F5F5;
}

#article_div {
	position: relative;
	width: 80%;
	height: 8%;
	left: 10%;
	background-color: #F5F5F5;
}

#author_div {
	position: relative;
	width: 80%;
	height: 8%;
	left: 10%;
	margin-top: 20px;
	background-color: #F5F5F5;
}
#ueditor_div{
	position: relative;
	width: 100%;
	height: 100%;
	margin-top: 10px;
}
span {
	position: relative;
	width: 10%;
	height: 90%;
	left: 10%;
	top: 5%;
	bottom: 5%;
	background-color: #F5F5F5;
	font-size: 15pt;
}

input {
	position: relative;
	width: 80%;
	height: 80%;
	left: 10%;
	top: 5%;
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
#submit_div{
	position: relative;
	margin: 50px auto;
	width: 90px;
	height: 30px;
}

#sub{
	position: relative;
	width: 100%;
	height: 100%;
	font-size: 15pt;
	background-color: #4169E1;
	cursor:pointer;
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
				<span>标题</span> &nbsp;&nbsp; <input type="text" id="title" name="title">

			</div>
			<div id="author_div">
				<span>作者</span> &nbsp;&nbsp; <input type="text" id="author" name="author">
			</div>
			<div id="ueditor_div">
				<!-- 编辑器配置-->
				
			</div>
		</div>
		<div id="submit_div">
			<button id="sub" onclick="commit()">
			提交
			</button>
		</div>
	</div>

	<script type="text/javascript">
	   var editor = new UE.ui.Editor({ initialFrameHeight:400,initialFrameWidth:950,
		   toolbars: [
	      [  'undo', 'redo', 'bold','indent','snapscreen','italic',
	         'underline','selectall','print','preview','time','date',
	         'cleardoc','fontfamily','fontsize','paragraph', 'simpleupload',
	         'insertimage', 'link','emotion','spechars', 'searchreplace','insertvideo',
	         'justifyleft','justifyright','justifycenter', 'justifyjustify','forecolor',
	         'backcolor','pagebreak','imageleft','imageright','attachment','imagecenter',
	         'wordimage','lineheight','edittip ','touppercase','tolowercase','background',
	         'template', 'scrawl','inserttable','charts',
	         
	         ]
	         ] });
	   editor.render("ueditor_div");


	
	// 上传社区新文 

		function commit(){
			
			$.ajax({
				url : '/Home-BasedCare/communityNews',
				type : 'POST',
				contentType : 'application/json',
				dataType : 'json',
				data:JSON.stringify(com()),
				success : function(data) {
					console.log(data);
					window.location.href = "/Home-BasedCare/communityNews/success";
				},
				error : function(status) {
					comsole.log("failure");
				}
			});
		}
		function com(){
			var json= {
			 "title":$("#title").val(),
		     "article": editor.getContent(),
			 "authorName":$("#author").val()
			};
			return json;
		}
	</script>
</body>
</html>