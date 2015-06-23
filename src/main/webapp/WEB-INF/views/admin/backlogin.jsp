<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
<title>后台登陆界面</title>
<style type="text/css">
body {
	position: relative;
	padding: 0px;
	margin: 0px;
	width: 100%;
	height: 100%;
}

#title {
	position: relative;
	margin: 0 auto;
	width: 940px;
	height: 238px;
	background-image: url(./img/login01.jpg);
}

#content {
	position: relative;
	width: 100%;
	height: 190px;
	margin-top: 0px;
	background-color: white;
}

.content_left {
	position: relative;
	float: left;
	width: 30.83%;
	height: 100%;
	background-color: #1E90FF;
}

.content_middle {
	float: left;
	width: 37.8%;
	height: 100%;
	background-image: url(./img/login03.jpg);
}

.content_right {
	position: relative;
	float: right;
	width: 31.37%;
	height: 100%;
	background-color: #1E90FF;
}

.form_div {
	position: relative;
	margin: 20px auto;
	width: 60%;
	height: 80%;
}

.username_div {
	position: relative;
	top: 5%;
	width: 100%;
	height: 50px;
}

.username_image {
	float: left;
	width: 20%;
	height: 80%;
	padding-top: 10px;
	padding-left: 40px;
}

.username_input {
	float: left;
	padding-top: 10px;
	width: 60%;
	height: 80%;
}

.password_div {
	position: relative;
	margin-top: 2%;
	width: 100%;
	height: 50px;
}

.password_image {
	float: left;
	width: 20%;
	height: 80%;
	padding-top: 10px;
	padding-left: 40px;
}

.password_input {
	float: left;
	padding-top: 10px;
	width: 60%;
	height: 80%;
}

.submit_div {
	position: relative;
	margin: 10px auto;
	width: 80%;
	height: 40%;
	padding-left: 38%;
    
}

#foot {
	position: relative;
	left: 15.43%;
	height: 133px;
	margin: 0 auto;
	background-image: url(./img/login05.jpg);
}
</style>

</head>
<body>

	<div id="title"></div>
	<div id="content">
		<div class="content_left"></div>
		<div class="content_middle">
			<div class="form_div">
				<form action=" ${pageContext.request.contextPath}/admin/login" method="post">
					<div class="username_div">
						<div class="username_image">
							<img src="./img/user.gif" width="32" height="32">

						</div>
						<div class="username_input">
							<input type="text" name="userName" id="userName"
								style="width: 164px; height: 32px;font-family: Verdana, Geneva, sans-serif;"/>
	
						</div>
					</div>
					<div class="password_div">
						<div class="password_image">
							<img src="./img/password.gif" width="32" height="32">
						</div>
						<div class="password_input">
							<input type="password" name="password" id="password"
								style="width: 164px; height: 32px;  font-size: 9pt;"/>
								
						</div>
					</div>
					<div class="submit_div">
						<input type="submit" value=""
							style="background: url(./img/login.gif); width: 95px; height: 34px; left: 20px;cursor:pointer;">
					</div>
				</form>
			</div>
		</div>
		<div class="content_right"></div>
	</div>
	<div id="foot"></div>
	<script type="text/javascript">
	window.onload = function()
    {
     document.getElementById("userName").focus();
    }						
	</script>
</body>
</html>