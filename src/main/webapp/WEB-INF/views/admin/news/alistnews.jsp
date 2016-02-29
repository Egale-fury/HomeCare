<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
	<div id="listinfo_div">
    	<div id="info_div">
    		<ul >
    		<c:forEach items="${admin_communityNews_pageInfo.news}" var="list">
    			<li >
    				<span >标题：</span>
    				<div class="info_title_div">${list.title}</div>
    				<div class="info_options_div"> 
    				    <a href="/Home-BasedCare/communityNews/querynews/${list.id}" class="button button-glow button-rounded button-raised button-primary">查看</a>
    				    <a onclick="del(${list.id})"  class="button button-glow button-rounded button-caution">删除</a>
	 			   </div>
    			</li>
    			<hr />
    			</c:forEach>
    		</ul>
    	</div>
    
    		<div id="pageinfo_div">
	 		<a id="first" href="/Home-BasedCare/communityNews/query/0/9">首页</a> 
            <a id="former"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.currentPage-1}/15">上一页</a>
	 	    <a id="next"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.currentPage+1}/15">下一页</a>
	 		<a id="last"
					href="/Home-BasedCare/communityNews/query/${admin_communityNews_pageInfo.totalPages-1}/15">尾页</a>&nbsp;&nbsp;
	 		<span >共${admin_communityNews_pageInfo.totalCount}条</span>&nbsp;
	 	    <span >每页显示15条</span>&nbsp;
	 	    <span>第${admin_communityNews_pageInfo.currentPage+1}页</span>&nbsp;
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
		var total = ${admin_communityNews_pageInfo.totalPages-1}
		if(current==0){
			$("#first").hide();
			$("#former").hide();
		}
		if(current==total){
			console.log("lalal");
			$("#next").hide();
			$("#last").hide();
		}

	
	</script>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/jquery.validate.js"></script>
</body>


</html>
