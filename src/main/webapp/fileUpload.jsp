<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<meta charset="UTF-8">
<!-- 编辑器配置-->
<script id="container" name="content" type="text/plain"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="./ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="./ueditor/ueditor.all.js"></script>


		

	<p>
		<button onclick="e();">点击</button>
	</p>
	<p>
		<button onclick="t();">点击测试编辑器</button>
	</p>

	
	<div id="edit">
		
	</div>
	<script type="text/javascript">
		function e() {
			var data = {};
			data.title = "关注企业发展 开创致富道路";
			data.article = ue.getContent();
			data.authorName = "罗亮";
			$.ajax({
				url : '/Home-BasedCare/communityNews',
				type : 'POST',
				contentType : 'application/json',
				dataType : 'json',
				data : $.toJSON(data),
				//data : "{\"title\":\"我是帅哥\",\"author\":\"dpc\"}",
				success : function(data) {
					console.log(data);
				},
				error : function(status) {

				}
			});
		}
	</script>
	
	<script type="text/javascript">
	function t(){
		 ue = UE.getEditor('container')
			ue.render("edit"); 
	}

	
	</script>