<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>

<style type="text/css">
body{
	padding: 0px;
	margin: 0px;
}


/* 社区动态 */
.healthtip_div {

	height: 100%;
	width: 100%;

}
/* 列表中的第一条下划线hr属性*/
.firstline {
	width: 100%;
	margin-bottom: 10px;
}
/*每个信息的标题栏（如：社区动态）*/
.column {
	width: 90%;
	height: 40px;
	font-size: 20pt;
	margin-left: 30px;
	margin-top: 13px;
	margin-right: 5px;
	color: blue;
	font-weight: bold;
}
/*更多的链接设置*/
a.a:link {
	color: #ccc;
}

a.a:visited {
	color: #ccc;
}

a.a:hover {
	color: #000;
}

a.a:active {
	color: #ccc;
}

a.a {
	font-size: 10pt;
	float: right;
	margin-top: 10px;
}
/* 时间的类选择器 */
.timelocate {
	float: right;
	font-size: 10pt;
	margin-lft: 10px;
}

/* 列表中的第一条下划线hr属性*/
.remainline {
	width: "90%";
	margin-bottom: 10px;
	margin-top: 10px;
}
</style>



</head>
<body>
	<div class="healthtip_div">
		<div class="column">
			<em>健康知识</em> <a class="a" href="/Home-BasedCare/healthTip/listtips/0/15">>>更多</a>
		</div>
		<hr class="firstline" />
		<ul style="padding-right: 4px">
			
			 <c:forEach items="${healthtip}" var="list">					
					<li><a class="b"  href="${pageContext.request.contextPath}/healthTip/${list.id} ">${list.title}</a>
					 <div class="timelocate">
				      <span >
				      <fmt:formatDate value="${list.releaseTime}" pattern="yyyy-MM-dd"/>
				     </span>
				     </div>
					</li>
					<hr class="remainline"/>
					
					</c:forEach> 
		</ul>
	</div>
	

</body>
</html>