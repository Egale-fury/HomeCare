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
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css" media="screen" />
<!-- 配置文件 -->
<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.all.js"></script>
<title>增加健康信息界面</title>

</head>
<body>
	<div id="head_content">
		<jsp:include page="../common/head.jsp"></jsp:include>
	</div>
	<div id="sidebar_content">
		<jsp:include page="../common/sidebar.jsp"></jsp:include>
	</div>
	<form id="main_content">
		<div id="add_content">
			<div id="article_div">
				<span>标题</span> &nbsp;&nbsp; 
				<input type="text" id="title" name="title"  >
			</div>
			<div id="author_div">
				<span>来源</span> &nbsp;&nbsp; 
				<input type="text" id="source" name="source" >
			</div>
			<div id="ueditor_div">
				<!-- 编辑器配置-->
				
			</div>
		</div>
		<div id="submit_div">
			<button id="sub" type="submit">
			提交
			</button>
		</div>
	</form>

	<script type="text/javascript">
	//input框为空的判断 
	 $().ready(function() {
           $("#main_content").validate({
			 onsubmit:true,
			 onfocusout:false,
			 onkeyup :false,
			 rules:{
				 title:{
					 required:true,
					 maxlength:20
				 },
				 source:{
					 required:true,
					 minlength:1
				 }
				
				 
			 },
			 messages:{
				 title:{
					 required:"请填写标题！",
					 maxlength:"输入不能超过20个字"
				 },
				 source:{
				     required:"请填写来源！ "
				    
			 }
				 
			 },
			 submitHandler: function(form){
				 $.ajax({
						url : '/Home-BasedCare/healthTip/create',
						type : 'POST',
						contentType : 'application/json',
						dataType : 'json',
						data:JSON.stringify(com()),
						success : function(data) {
							console.log(data);
							window.location.href = "/Home-BasedCare/healthTip/success";
						},
						error : function(status) {
							comsole.log("failure");
						}
					});
			 }
		 }
				 
		 );
		});
	
	 //构建编辑器对象
	   var editor = new UE.ui.Editor({ 
		   initialFrameHeight:400,
		   initialFrameWidth:950,
		   scaleEnabled:true,
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


	
		function com(){
			var json= {
			 "title":$("#title").val(),
		     "content": editor.getContent(),
			 "source":$("#source").val()
			};
			return json;
		}
	</script>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>	
<script src="<%=basePath%>js/jquery.validate.js"></script>	
</body>
</html>