<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title></title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<style type="text/css">
		 body{
       margin:0;
       padding:0;
       font-family: "Microsoft Yahei";
       font-size:12px;
       background-image: url("<%=basePath %>img/dust.png");
       list-style: none;
       }
       
    /* 头部 */   
	.top{
	   position:relative;
	   width:70%;
	   height:180px;
	   margin: 0 auto;
	   text-align:center;
	}
	
	.toptitle{
		position:absolute;
		display:table-cell;
		vertical-align:middle;
		text-align:center;
		width:100%;
		height:80%;
	}
	
	/* 菜单栏 */
	.menu{
	    position:absolute;
		width:100%;
		height:20%;
		bottom:0;
		background:#FF6600;
		padding-bottom: 5px;
	}
	
	.menubox{
		position:relative;
		width:80%;
		height:80%;
		margin:2px auto 0px;
		background:#FF6600;
	}
	
	.menuboxchoice{
		position:relative;
		width:90%;
		height:70%;
		margin:8px auto;
		background:#FF6600;
		font-size: 15pt;
	}
	
	
	    /* 标题栏中的链接属性设置*/
	    a.title:link{
	    background-color:#FF6600;
	    color:#FFF;
	    text-decoration:none;
	     }
	    a.title:visited {
	     background-color:#FF6600;
	     color:#FFF;
	     text-decoration:none;
	     }
	    a.title:hover {
	    background-color:#FFF;
	    color:#FF6600;}	
        a.title:active {
        background-color:#FF6600;
        color:#FFF;
        }	
	    a.title{
	    display:inline-block;
	    width:100%;
		font-size: 14pt;
	     }
	     
         .titleli{
		 display:inline-block;
		 background:#FF6600) ;
		 width: 15%
		}
		/* 主体部分 */
		.main{
		 position:relative;
		 width: 70%;
		 height: 1000px;
		 margin:10px auto;
		 border: 1px solid #ccc;
		 background-color: #fff;
		}
		.locationinfo{
		 position: absolute;
		 width: 94%;
		 height:30px;
		 top: 2%;
		 left:3%;
		 right: 3%; 
		}
		/*位置链接 */
		a.location:link{
	    background-color:#FFF;
	    color:#000;
	    text-decoration:none;
	     }
	    a.location:visited {
	     background-color:#FFF;
	     color:#000;
	     text-decoration:none;
	     }
	    a.location:hover {
	    background-color:#FFF;
	    color:#FF6600;}	
        a.location:active {
        background-color:#FFF;
        color:#000;
        }	
	    a.location{
		font-size: 12pt;
		
	     }
	     
	     /* 文章的主体部分 */
	     .content{
	     position: absolute;
		 width: 94%;
		 height:95%;
		 top: 5%;
		 left:3%;
		 right: 3%;
		  
	     }
	     
	     /* 文章的标题  */
	     .articletitle{
	     position: relative;
	     width: 75%;
	     margin: 10px auto;
	     height: 5%;
	     text-align: center;
	     font-size: 2em;
	     font-weight: bold;
	     }
	      /* 文章的时间和标题  */
	     .dateandauthor{
	     	position: relative;
	     	width: 75%;
	     	margin: 5px auto;
	     	height: 3%;
	     	text-align: center;
	     	font-weight: bold;
	     	background-color: #E3E3E3;
	     	padding-top: 8px;
	     }
	     
	     /* 文章的主题内容   */
	     .articlecontent{
	     	position: relative;
	     	width: 90%;
	     	margin: 20px auto;
	     	height: 80%;
	     	font-size: 16pt;
	     }
	      /* 底部 */
		.foot{
		position:relative;
		width:70%;
		height:100px;
		margin:10px auto;
		background:url("<%=basePath %>img/titlebg.png");
		}
		
	 	
		.footbasic{
			position: absolute;
			width: 100%;
			height: 30%;
			bottom: 5px;
			background:url("<%=basePath %>img/titlebg.png");
		}
		
		.footbasicinfo{
			position: relative;
			width: 80%;
			height: 100%;
			margin: 0 auto;
			background:url("<%=basePath %>img/titlebg.png");
			text-align: center;
		}
	     
</style>
</head>
<body>
		<div class="top" >
		<div class="toptitle" >
			<img src="<%=basePath %>img/titlephoto.png" width="100%" height="100%"  />
		</div>
		<div class="menu">
			<div class="menubox">
				<ul style="padding-left: 0px;margin-bottom: 0px;">
					<li class="titleli"><a class="title" href="./index.jsp">首页</a></li>
					<li class="titleli"><a class="title" href="#">社区动态</a></li>
					<li class="titleli"><a class="title" href="#">服务信息</a></li>
					<li class="titleli"><a class="title" href="#">健康知识</a></li>
					<li class="titleli"><a class="title" href="#">文化娱乐</a></li>
					<li class="titleli"><a class="title" href="#">个人登录</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="locationinfo">
			<span style="font-size: 12pt">当前位置: ><a class="location"href="./communityservice.jsp" >社区动态</a><span style="font-size: 12pt">>正文</span></span>
		</div>
		<div class="content">
			<div class="articletitle">
			
					${newscontent.title}
				
			</div>
			<div class="dateandauthor">
				日期：${newscontent.date} 【信息来源】作者：${newscontent.authorName}
			</div>
			<div class="articlecontent">
			${newscontent.article}
			</div>
		</div>
	</div>
	<div class="foot">
		<div class="footbasic">
		  <div class="footbasicinfo">
		         <span style="color: white;">版权所有：太仓市城厢镇德兴社区　Copyright @ 2012-2014 All Rights Reserved 　苏ICP备10218904号 </span>
		  </div>
		</div>
	</div>
</body>
</html>