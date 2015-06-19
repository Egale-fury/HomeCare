<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-cn">

<head>
<meta charset="UTF-8">
<title>ueditor demo</title>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/jquery-json/2.5.1/jquery.json.min.js"></script>
</head>

<body>
	<!-- 加载编辑器的容器 -->
	<script id="container" name="content" type="text/plain">
       
    </script>
	<!-- 配置文件 -->
	<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="ueditor/ueditor.all.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('container')
	</script>

	<p>
		<button onclick="e();">点击</button>
	</p>
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
</body>

</html>