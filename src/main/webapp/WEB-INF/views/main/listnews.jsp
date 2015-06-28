<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�Ӽ����Ϸ���ϵͳ>>������̬</title>
    
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<link rel="stylesheet" href="<%=basePath %>css/listcontent.css">
	<script src="<%=basePath %>js/jquery-2.1.1.min.js"></script>



  </head>
  
  <body>
    
	<div class="top" >
		<div class="toptitle" >
			<img src="<%=basePath %>img/titlephoto.png" width="100%" height="100%"  />
		</div>
		<div class="menu">
			<div class="menubox">
				<ul style="padding-left: 0px;margin-bottom: 0px;">
					<li class="titleli"><a class="title" href="./index.jsp">��ҳ</a></li>
					<li class="titleli"><a class="title" href="#">������̬</a></li>
					<li class="titleli"><a class="title" href="#">������Ϣ</a></li>
					<li class="titleli"><a class="title" href="#">����֪ʶ</a></li>
					<li class="titleli"><a class="title" href="#">�Ļ�����</a></li>
					<li class="titleli"><a class="title" href="#">���˵�¼</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main">
	 	<div class="maintitle">
	 		<div class="titlelocationleft">
	 			<div class="arrowimg">
	 		    <img  src="<%=basePath %>img/arrow.png">
	 		    </div>
	 			<div class="fontdiv">������̬
	 			</div>
	 		</div>
	 		<div class="titlelocationright">
	 			<div class="locationinfo">
	 				���λ�� > ������̬
	 			</div>
	 		</div>
	 	</div>
	 	<hr class="topline"/>
	 	<div class="maininfo">
	 		<ul class="ullist">
	 		<c:forEach items="${communityNews_pageInfo.news}" var="list">
	 			<li class="infoli"><img  src="<%=basePath %>img/arrow1.png" >
	 			   <a class="b" href="${pageContext.request.contextPath}/communityNews/${list.id}">${list.title }</a>
	 			   <div class="date"> <fmt:formatDate value="${list.date}" pattern="yyyy-MM-dd HH:MM"/>
	 			   </div>
	 			 </li>
			</c:forEach>
	 		</ul>
	 	</div>
	 	<div class="page_div">
	 		<div class="pageinfo">
	 		<a  id="first" href="/Home-BasedCare/communityNews/listNews/0/15">��ҳ</a> 
            <a id="former" href="/Home-BasedCare/communityNews/listNews/${communityNews_pageInfo.currentPage-1}/15">��һҳ</a>
	 	    <a id="next" href="/Home-BasedCare/communityNews/listNews/${communityNews_pageInfo.currentPage+1}/15">��һҳ</a>
	 		<a id="last" href="/Home-BasedCare/communityNews/listNews/${communityNews_pageInfo.totalPages-1}/15">βҳ</a>&nbsp;&nbsp;
	 		<span>��${communityNews_pageInfo.totalCount}��</span>&nbsp;
	 	    <span>ÿҳ��ʾ15��</span>&nbsp;
	 	    <div id="page" style="display: inline-block;">��${communityNews_pageInfo.currentPage+1}ҳ</div>
	 		</div>
	 	</div>
	</div>
	<div class="foot">
		<div class="footbasic">
		  <div class="footbasicinfo">
		         <span style="color: white;">��Ȩ���У�̫���г��������������Copyright @ 2012-2014 All Rights Reserved ����ICP��10218904�� </span>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
		var current = ${communityNews_pageInfo.currentPage}
		console.log(current);
		console.log(${communityNews_pageInfo.totalPages});
		if(current==0){
			$("#first").hide();
			$("#former").hide();
		}
		if(current==${communityNews_pageInfo.totalPages-1}){
			console.log("lalal");
			$("#next").hide();
			$("#last").hide();
		}

		
	</script>

  </body>
</html>
