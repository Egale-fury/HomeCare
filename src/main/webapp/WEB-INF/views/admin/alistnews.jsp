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
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>

<style type="text/css">
#alistnews {
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
	width: 90%;
	height: 50px;
}

a.news:link {
	color: black;
	text-decoration: none;
}

a.news:visited {
	color: black;
	text-decoration: none;
}

a.news:hover {
	color: #e58100;
	text-decoration: none;
}

a.news:active {
	color: black;
	text-decoration: none;
}

a.news {
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
	height: 60%;
	padding-top: 10px;
	float: right;
}

.option_href {
	float: right;
	margin-left: 10px;
	font-style: color:black;
}

#page_div {
	position: relative;
	width: 80%;
	height: 20%;
	margin: 0 auto;
}

.pageinfo {
	position: relative;
	float: right;
	padding-top: 10px;
	padding-left: 20px;
	width: 60%;
	height: 30px;
}
a.option_href:link {
	color: black;
	text-decoration: none;
}

a.option_href:visited {
	color: black;
	text-decoration: none;
}

a.option_href:hover {
	color: #e58100;
	text-decoration: none;
}

a.option_href:active {
	color: black;
	text-decoration: none;
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
    				<a class="news" href="">${list.title}</a>
    				<div class="options_div"> 
    					<a class="option_href" href="">删除</a>
    					<a class="option_href" href="">编辑</a>
    					<a class="option_href" href="">查看</a>
	 			   </div>
    			</li>
    			<hr />
    			</c:forEach>
    		</ul>
    	</div>
    	<div id="page_div">
    		<div class="pageinfo">
	 		<a id="first" href="/Home-BasedCare/communityNews/query/0/9">首页</a> 
            <a id="former"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.currentPage-1}/15">上一页</a>
	 	    <a id="next"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.currentPage+1}/15">下一页</a>
	 		<a id="last"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.totalPages-1}/15">尾页</a>&nbsp;&nbsp;
	 		<span>共${admin_communityNews_pageInfo.totalCount}条</span>&nbsp;
	 	    <a>每页显示15条</a>&nbsp;
	 	    <div id="page" style="display: inline-block;">第${admin_communityNews_pageInfo.currentPage+1}页</div>
	 		</div>
    	</div>
    </div>
	<script type="text/javascript">
		var current = ${admin_communityNews_pageInfo.currentPage}
		console.log(current);
		console.log(${admin_communityNews_pageInfo.totalPages});
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
