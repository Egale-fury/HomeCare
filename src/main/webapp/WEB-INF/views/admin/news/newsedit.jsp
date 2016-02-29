<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/layout.css" type="text/css" media="screen" />
<!-- 配置文件 -->
<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.all.js"></script>
<title>编辑</title>
</head>
<body>
	<div id="head_content">
		<jsp:include page="../common/head.jsp"></jsp:include>
	</div>
	<div id="sidebar_content">
		<jsp:include page="../common/sidebar.jsp"></jsp:include>
	</div>
	<div id="main_content">
		<div id="add_content">
			<div id="article_div">
				<span>标题</span> &nbsp;&nbsp; <input type="text" id="title"
					name="title" value="${editnewscontent.title}">

			</div>
			<div id="author_div">
				<span>作者</span> &nbsp;&nbsp; <input type="text" id="author"
					name="author" value="${editnewscontent.authorName}">
			</div>
			<div id="ueditor_div">
				<!-- 编辑器配置-->

			</div>
		</div>
		<div id="submit_div">
			<button id="sub" onclick="commit()">提交</button>
		</div>
	</div>

	<script type="text/javascript">
		var editor = new UE.ui.Editor({
			initialFrameHeight : 400,
			initialFrameWidth : 950,
			scaleEnabled:true,
			toolbars : [ [ 'undo', 'redo', 'bold', 'indent', 'snapscreen',
					'italic', 'underline', 'selectall', 'print', 'preview',
					'time', 'date', 'cleardoc', 'fontfamily', 'fontsize',
					'paragraph', 'simpleupload', 'insertimage', 'link',
					'emotion', 'spechars', 'searchreplace', 'insertvideo',
					'justifyleft', 'justifyright', 'justifycenter',
					'justifyjustify', 'forecolor', 'backcolor', 'pagebreak',
					'imageleft', 'imageright', 'attachment', 'imagecenter',
					'wordimage', 'lineheight', 'edittip ', 'touppercase',
					'tolowercase', 'background', 'template', 'scrawl',
					'inserttable', 'charts',

			] ]
		});
		editor.addListener("ready", function() {
			editor.setContent('${editnewscontent.article}');

		});
		editor.render("ueditor_div");
	</script>
	<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
	<script src="<%=basePath%>js/back/hideshow.js" type="text/javascript"></script>
</body>
</html>