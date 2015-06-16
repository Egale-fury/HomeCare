<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="no-cach" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" /> 
    
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/index.css">
    <script src="./js/jquery-2.1.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    

</head>

<body>
	<div class="top" >
		<div class="toptitle">
			<img src="./img/titlephoto.png" width="100%" height="100%" />
		</div>
		<div class="menu">
			<div class="menubox">
				<div class="menuboxchoice">
				<a class="title" href="#" > 首页</a> 
				<a class="title" href="./communityservice.jsp" >社区动态</a> 
				<a class="title" href="#" >服务信息</a> 
				<a class="title" href="#" >健康知识</a> 
				<a class="title" href="#" >文化娱乐</a> 
				<a class="title" href="#" >个人登录</a> 
				</div>
			</div>
		</div>
	</div>
	
	<div class="main">
	 <div class="slideout" >
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators" style="bottom: 0px;">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox" >
    <div class="item active">
      <img src="./img/social1.jpg" width="100%" height="100%" alt="...">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
      <img src="./img/social2.jpg" width="100%" height="100%" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    
    <div class="item">
      <img src="./img/social3.jpg" width="100%" height="100%" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    
    <!-- 在此放置更多的图片 -->
    
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>

  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
		<div class="info" >
		     <!--社区动态  -->
		     <div class="communityservice">
				  <div class="column" >
				    <em>社区动态</em>
				     <a class="a" href="./communityservice.jsp">>>更多</a>
				 </div>
				 <hr class="firstline" />
				 <ul style="padding-right: 4px">
					<li><a class="b"  href="#" >奔驰总设计师：设计不会因技术进步更改</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >咒语吗？日本网友看中文元素周期表崩溃</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >很有文化品味的意大利海边小村庄</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >Angelababy组LOL队 4连胜摆脱青铜段位</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >iPhone也将加入苹果官翻行列：敢买吗？</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >专访《少年四大名捕》演员钱泳辰</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
				</ul>
		   </div>
			
              <!--服务信息 -->
			  <div class="serviceinfo">
				  <div class="column" >
				    <em>服务信息</em>
				     <a class="a" href="#">>>更多</a>
				  </div>
				  <hr class="firstline" />
				  <ul style="padding-right: 4px">
					<li><a class="b"  href="#" >奔驰总设计师：设计不会因技术进步更改</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >咒语吗？日本网友看中文元素周期表崩溃</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >很有文化品味的意大利海边小村庄</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >Angelababy组LOL队 4连胜摆脱青铜段位</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >iPhone也将加入苹果官翻行列：敢买吗？</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >专访《少年四大名捕》演员钱泳辰</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
				</ul>
		     </div>
			
			    <!--健康知识  -->
			  <div class="healthknowledge">
				  <div class="column" >
				    <em>健康知识 </em>
				     <a class="a" href="#">>>更多</a>
				 </div>
				 <hr class="firstline" />
				 <ul style="padding-right: 4px">
					<li><a class="b"  href="#" >奔驰总设计师：设计不会因技术进步更改</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >咒语吗？日本网友看中文元素周期表崩溃</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >很有文化品味的意大利海边小村庄</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >Angelababy组LOL队 4连胜摆脱青铜段位</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >iPhone也将加入苹果官翻行列：敢买吗？</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >专访《少年四大名捕》演员钱泳辰</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
				</ul>
		   </div>
			
			 <!--文化娱乐  -->
			  <div class="culture">
				  <div class="column" >
				    <em>文化娱乐</em>
				     <a class="a" href="#">>>更多</a>
				 </div>
				 <hr class="firstline" />
				 <ul style="padding-right: 4px">
					<li><a class="b"  href="#" >奔驰总设计师：设计不会因技术进步更改</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >咒语吗？日本网友看中文元素周期表崩溃</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >很有文化品味的意大利海边小村庄</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >Angelababy组LOL队 4连胜摆脱青铜段位</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b"  href="#" >iPhone也将加入苹果官翻行列：敢买吗？</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
					<li><a class="b" href="#" >专访《少年四大名捕》演员钱泳辰</a>
					 <div class="timelocate">
				      <span >2015.3.31</span>
				     </div>
					</li>
					<hr class="remainline"/>
				</ul>
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
    