<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
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


/* ������̬ */
.healthtip_div {

	height: 100%;
	width: 100%;

}
/* �б��еĵ�һ���»���hr����*/
.firstline {
	width: 100%;
	margin-bottom: 10px;
}
/*ÿ����Ϣ�ı��������磺������̬��*/
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
/*�������������*/
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
/* ʱ�����ѡ���� */
.timelocate {
	float: right;
	font-size: 10pt;
	margin-lft: 10px;
}

/* �б��еĵ�һ���»���hr����*/
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
			<em>����֪ʶ</em> <a class="a" href="/Home-BasedCare/healthTip/listtips/0/15">>>����</a>
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