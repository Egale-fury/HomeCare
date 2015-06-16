<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/jquery-json/2.5.1/jquery.json.min.js"></script>
</head>
<body>
	<h2>Hello World!</h2>

	<p>
		<a href="communityNews/1.json">点击</a>
		<button onclick="e();">点击</button>
	</p>
	<script type="text/javascript">
		function e() {
			var data = {};
			data.title = "关注企业发展 开创致富道路";
			data.article = "主动适应经济发展新常态，努力开创经济发展新局面。5月15日文化社区党支部带领社区党员、居委会成员和有创业意愿的机关干部、辖区居民到“腾翔农业”参观学习。腾翔农业是我区重点招商引资项目，目前投资1，300百万元，主要以观光旅游、果园采摘、食用菌生产等项目为主。建设葡萄大棚10个，草莓大棚8个，鸡腿菇、平菇、榆黄蘑、金针菇、黑木耳棚30多个。食用菌包车间生产线一套，日产菌包2万包，如添加设备日产菌包能达到10万包。通过参观学习了解到，腾翔农业的食用菌生产设备和生产技术是我区最先进的，生产实力也是非常强的。公司负责人介绍，目前缺少合作的农户，按照“企业+合作社+农户”的新模式，未来有创业意愿的职工群众以“腾翔农业”为龙头可以共同把我区的食用菌种植项目做大做强";
			data.authorName="罗亮";
			$.ajax({
				url : '/Home-BasedCare/communityNews',
				type : 'POST',
				contentType : 'application/json',
				dataType : 'json',
				data:$.toJSON(data),
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
