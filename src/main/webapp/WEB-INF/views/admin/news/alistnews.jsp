<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<base href="<%=basePath%>">

<title>居家养老服务系统>>社区动态</title>

<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" href="<%=basePath %>css/button.css">

<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/back/jquery.validate.js"></script>

<style type="text/css">
#alistnews_div {
	position: relative;
	width: 100%;
	height: 100%;
}

#news_div {
	position: relative;
	width: 100%;
	height: 80%;
	margin: 0 auto;
}

.newsul {
	position: relative;
	width: 95%;
	height: 90%;
}

.newsli {
	position: relative;
	display: inline-block;
	width: 100%;
	height: 50px;
}



.news {
	display: inline-block;
	font-size: 12pt;
	width: 50%;
	height: 60%;
	padding-top: 10px;
}

.options_div {
	display: inline-block;
	font-size: 12pt;
	width: 40%;
	height: 100%;
	float: right;
}

.pageinfo {
	position: relative;
	margin:0 auto;
	padding-top: 10px;
	padding-left: 20px;
	width: 60%;
	height: 30px;
}



</style>

</head>

<body>

	<body>
	<div id="alistnews_div">
    	<div id="news_div">
    		<ul class="newsul">
    		<c:forEach items="${admin_communityNews_pageInfo.news}" var="list">
    			<li class="newsli">
    				<span style="font-size: 12pt">标题：</span>
    				<div class="news">${list.title}</div>
    				<div class="options_div"> 
    				    <a href="/Home-BasedCare/communityNews/querynews/${list.id}" class="button button-glow button-rounded button-raised button-primary">查看</a>
    				    <a href="/Home-BasedCare/communityNews/editnews/${list.id}" class="button button-glow button-rounded button-raised button-primary">编辑</a>
    				    <a onclick="del(${list.id})"  class="button button-glow button-rounded button-raised button-primary">删除</a>
	 			   </div>
    			</li>
    			<hr style="margin-bottom: 15px;"/>
    			</c:forEach>
    		</ul>
    	</div>
    
    		<div class="pageinfo">
	 		<a id="first" href="/Home-BasedCare/communityNews/query/0/9">首页</a> 
            <a id="former"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.currentPage-1}/15">上一页</a>
	 	    <a id="next"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.currentPage+1}/15">下一页</a>
	 		<a id="last"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.totalPages-1}/15">尾页</a>&nbsp;&nbsp;
	 		<span>共${admin_communityNews_pageInfo.totalCount}条</span>&nbsp;
	 	    <span>每页显示15条</span>&nbsp;
	 	    <div id="page" style="display: inline-block;">第${admin_communityNews_pageInfo.currentPage+1}页</div>
	
    	</div>
    </div>
	<script type="text/javascript">

	//删除 
	function del(id){
		var newsid = id;
		$.ajax({
			url : '/Home-BasedCare/communityNews/deletenews/'+newsid,
			type : 'POST',
			success : function(data) {
				console.log("success");
				window.location.href = "/Home-BasedCare/communityNews/delsuccess";
			},
			error : function(status) {
				comsole.log("failure");
			}
		});
	}

	
		var current = ${admin_communityNews_pageInfo.currentPage}
		if(current==0){
			$("#first").hide();
			$("#former").hide();
		}
		if(current==${admin_communityNews_pageInfo.totalPages-1}){
			console.log("lalal");
			$("#next").hide();
			$("#last").hide();
		}

	
	</script>

</body>


</html>
