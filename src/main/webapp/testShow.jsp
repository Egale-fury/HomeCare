<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试从数据库中读取html片段显示</title>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/jquery-json/2.5.1/jquery.json.min.js"></script>
</head>
<body>
	<p>
		<button onclick="e();">点击</button>
	</p>
	<div id="content">
	
	</div>

	<script type="text/javascript">
		function e() {
			$.ajax({
				url : '/Home-BasedCare/communityNews/5.json',
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				//data:$.toJSON(data),
				//data : "{\"title\":\"我是帅哥\",\"author\":\"dpc\"}",
				success : function(data) {
					console.log(data.article);
					$("#content").html(data.article);
				},
				error : function(status) {

				}
			});
		}
	</script>
</body>
</html>