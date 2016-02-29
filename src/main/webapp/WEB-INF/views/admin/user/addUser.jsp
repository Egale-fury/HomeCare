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

<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="<%=basePath %>css/flat-ui.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="<%=basePath %>css/layout.css" type="text/css"
	media="screen" />	




<title>主界面</title>


<style type="text/css">
#head_content {
	position: relative;
	height: 95px;
	width: 100%;
}

#sidebar_content {
	position: relative;
	width: 23%;
	margin-top: -6px;
	height: 900px;
	min-height: 500px;
	float: left;
	background: #E0E0E3 url(<%=basePath%>img/sidebar.png) repeat;
}

#main_content {
	position: relative;
	width: 77%;
	min-height: 950px;
	margin-top: -6px;
	float: left;
	padding-top:10px;
	background-color: #F5F5F5;
}
#infotitle{
	position: relative;
	width: 150px;
	height: 40px;
	margin: 5px auto;
	text-align:center;
	font-family: Helvetica, Tahoma, Arial, STXihei, "华文细黑", Heiti, "黑体",
		"Microsoft YaHei", "微软雅黑", SimSun, "宋体", sans-serif;
	font-size:20pt;


}
#basicform{
	position: relative;
	margin:0 auto;
	width: 80%;
	height: 750px;
	padding-top: 5px;
	border-style:solid;
	border-radius:5px;
	border-width:1px;
	border-color: black;
}
#tab{
	position: relative;
	width: 100%;
	height: 100%;
}
.tab_tr{
	position: relative;
	width:100%;
	height: 20px;
}
.tab_td1{
	position: relative;
	width: 30%;
}
.tab_td2{
	position: relative;
	width: 70%;
}
#basicinfo{
	position: relative;
	margin: 20px auto;
	width: 80%;
	height: 80%;
	padding-left: 50px;
}
.eachinfo_div{

	position: relative;
	width: 40%;
	height: 8%;
	margin: 15px auto;

}
span.attribute{
    display:inline-block;
	font-size: 15pt;
	margin-right: 10px;
}
.form-control{
	width: 152px;
	display: inline-block;
}
.gender{
	display: inline-block;
	width: 120px;
	height: 30px;
	padding-left: 20px;
}
.tipfm{
	font-family: Helvetica, Tahoma, Arial, STXihei, "华文细黑", Heiti, "黑体",
		"Microsoft YaHei", "微软雅黑", SimSun, "宋体", sans-serif;
}
.birline{
	position: relative;
	width: 50%;
	height: 40px;
	margin: 15px auto;
	padding: 5px auto;
}
.jiguan{
	position: relative;
	width: 40%;
	height: 40px;
	margin: 15px auto;

}
.bir{
	position: relative;
	width: 40%;
	height: 40px;
	margin: 15px auto;

}
.marriage{
	display: inline-block;
	width: 150px;
	height: 30px;
	padding-left: 20px;
}
.occ{
	position: relative;
	width: 40%;
	height: 40px;
	margin: 15px auto;

}
/*提交按钮的样式*/
#submit_div1{
	position: relative;
	margin: 60px auto;
	width: 90px;
	height: 50px;
}
#sub1{
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
		<jsp:include page="../common/head.jsp"></jsp:include>
	</div>
	<div id="sidebar_content">
		<jsp:include page="../common/sidebar.jsp"></jsp:include>
	</div>
	<div id="main_content">
	<div id="infotitle">基本信息</div>
	<form id="basicform">
		<div id="basicinfo">
		  <div class="eachinfo_div">
			<span class="attribute">姓名</span>
			<input type="text" class="form-control" id="realname" />
		  </div>
		  <div class="eachinfo_div">
			<span class="attribute">密码</span>
			<input type="text" class="form-control" id="password"/>
		  </div>
		   <div class="eachinfo_div">
			<span class="attribute">性别</span>
			<div class="gender">
			<input type="radio" checked="checked" name="human" id="female" value="男">&nbsp;&nbsp;<span style="font-size: 12pt">男</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 			<input type="radio"  name="human" id="male" value="女"><span style="font-size: 12pt">女</span>
 			</div>
           </div>
           <div class="eachinfo_div" >
			<span class="attribute">名族</span>
			<select id="se1" style="width: 90px;height: 30px">
				<option style="width: 90px;height: 30px" value="汉族">汉族</option>
				<option style="width: 90px;height: 30px" value="其他">其他</option>
			</select>
		  </div>
		  <div class="birline">
		  	<span class="attribute">出生日期</span>
		  	<input type="text" style="width: 90px" id="time">&nbsp;&nbsp;如1994-11-06
		  	
		  </div>
		
		 <div class="jiguan">
		 	<span class="attribute">籍贯</span>
		 	<input type="text" style="width: 120px" id="province">
		 </div>
		 <div class="bir">
		 	<span class="attribute">出生地</span>
		 	<input type="text" style="width: 110px" id="birthPlace">
		 </div>
		 <div class="eachinfo_div" style="width: 300px">
			<span class="attribute">婚姻状况</span>
			<div class="marriage">
			<input type="radio" checked="checked" name="marriage" id="married" value="已婚">&nbsp;&nbsp;<span style="font-size: 12pt">已婚</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 			<input type="radio"  name="marriage" id="unmarried" value="未婚"><span style="font-size: 12pt">未婚</span>		
		    </div>
		</div>
		  <div class="occ">
		 	<span class="attribute">职业</span>
		 	<input type="text" style="width: 110px" id="occupation">
		 </div>
		 <div class="occ">
		 	<span class="attribute">受教育水平</span>
		 	<select id="se2"style="width: 90px;height: 30px">
				<option style="width: 90px;height: 30px">小学</option>
				<option style="width: 90px;height: 30px">初中</option>
				<option style="width: 90px;height: 30px">高中</option>
				<option style="width: 90px;height: 30px">本科</option>
				<option style="width: 90px;height: 30px">本科以上</option>
			</select>
		 </div>
		  <div class="occ" style="width: 300px;">
		 	<span class="attribute">住址</span>
		 	<input type="text" style="width: 230px" id="address">
		 </div>
		 <div class="occ" style="width: 300px;"> 
		 	<span class="attribute" >电话</span>
		 	<input type="text" style="width: 150px" id="phoneNum">
		 </div>
		 
		 <div id="submit_div1">
			<button id="sub1" type="submit">
			提交
			</button>
		</div>
	</form>
	</div>
		
	
	
<script src="<%=basePath%>js/back/jquery-1.5.2.min.js"></script>	
<script src="<%=basePath%>js/back/jquery.js"></script>
<script src="<%=basePath%>js/back/jquery.validate.js"></script>
<script src="<%=basePath%>js/test/application.js"></script>
<script src="<%=basePath%>js/test/flat-ui.min.js"></script>	
<script src="<%=basePath%>js/test/jquery.min.js"></script>
<script src="<%=basePath%>js/test/video.js"></script>		
	<script type="text/javascript">
	//input框为空的判断 
	 $().ready(function() {
           $("#sub1").click(function (){
				 $.ajax({
						url : '/Home-BasedCare/user/create',
						type : 'POST',
						contentType : 'application/json',
						dataType : 'json',
						data:JSON.stringify(com()),
						success : function(data) {
							console.log(data);
							window.location.href = "/Home-BasedCare/healthTip/success";
						},
						error : function(status) {
							console.log("failure");
						}
					});
			 });
	 });

		
		function com(){
			console.log("hahhaahahh")
			var json= {
			 "realName":$("#realname").val(),
			 "password":$("#password").val(),
			 "sex":$('input:radio[name="human"]:checked').val(),
			 "ethnicity": $("#se1 option:selected").text(),
			 "bitrhday":$("#time").val(),
			 "nativePlace":$("#province").val(),
			 "birthPlace":$("#birthPlace").val(),
			 "maritalStatus":$('input:radio[name="marriage"]:checked').val(),
			 "cooupation":$("#occupation").val(),
			 "educatedLevel":$('#se2').find('option:selected').text(),
			 "address":$("#address").val(),
			 "phoneNum":$("#phoneNum").val(),
			};
			return json;
		}
	</script>
</body>
</html>