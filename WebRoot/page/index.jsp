<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%
   String username=(String)request.getSession().getAttribute("username");
 %>
<title>My JSP 'ShopIndex.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- js -->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- css -->
<link href="css/MainCss.css" rel="styleSheet" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Main styles for this application -->
<link href="css/style.css" rel="stylesheet">
<script language="javascript">
// 这个脚本是 ie6和ie7 通用的脚本
function custom_close(){
if 
(confirm("您确定要关闭本页吗？")){
window.opener=null;
window.open('','_self');
window.close();
}
else{}
}
</script>
</head>
<body>
	<div class="main">
		<div align="Top">
			<header class="app-header navbar">
			<button class="navbar-toggler mobile-sidebar-toggler hidden-lg-up"
				type="button">☰</button>
			<a class="navbar-brand" href="#"></a>
			<ul class="nav navbar-nav hidden-md-down">
				<li class="nav-item"><a
					class="nav-link navbar-toggler sidebar-toggler" href="#">☰</a></li>
				
				<s:if test="#session.identity==null">
				<li class="nav-item px-1"><a class="nav-link"
					href="LookThtoughOrder">查看我的订单</a></li>
				</s:if>
				<s:if test="#session.identity=='Saler'">
				<li class="nav-item px-1"><a class="nav-link"
					href="LookThtoughOrder?pageNo=1">查看我的订单</a></li>
				</s:if>	
				<s:elseif test="#session.identity=='Buyer'">
				<li class="nav-item px-1"><a class="nav-link"
					href="Buyer_CheckOrderListAction?pageNo=1">查看我的订单</a></li>		
				</s:elseif>	
				
				<s:if test="#session.identity==null">
				<li class="nav-item px-1"><a class="nav-link"
					href="TransLogin">修改密码</a></li>
				</s:if>	
				<s:elseif test="#session.identity=='Buyer'">
				<li class="nav-item px-1"><a class="nav-link"
					href="TUser_UpdatePassword">修改密码</a></li>	
				</s:elseif>	
				
				<s:elseif test="#session.identity=='Saler'">
				<li class="nav-item px-1"><a class="nav-link"
					href="UpdatePasswordTs">修改密码</a></li>	
				</s:elseif>	
			
			<s:if test="#session.identity==null">
				<li class="nav-item px-1"><a class="nav-link"
					href="TransLogin">修改个人信息</a></li>
			</s:if>
			<s:elseif test="#session.identity=='Buyer'">
				<li class="nav-item px-1"><a class="nav-link"
					href="buyer_UpdateMassageFisrtAction">修改个人信息</a></li>
			</s:elseif>
			
			<s:elseif test="#session.identity=='Saler'">
				<li class="nav-item px-1"><a class="nav-link"
					href="UpdateMassageAction">修改个人信息</a></li>
			</s:elseif>
			
			<s:if test="#session.identity=='Saler'">		
				<li class="nav-item px-1"><a class="nav-link"
					href="SalerIndex">进入我的商城管理页面</a></li>
					<li class="nav-item px-1"><a class="nav-link"
					href="BuyerIndex">进入买家个人中心</a></li>
			</s:if>
			<s:elseif test="#session.identity=='Buyer'">		
				<li class="nav-item px-1"><a class="nav-link"
					href="BuyerIndex">进入买家个人中心</a></li>
			</s:elseif>			
			</ul>
			<ul class="nav navbar-nav ml-auto">
				
				<li class="nav-item hidden-md-down"><a class="nav-link"
					href="#"><i class="icon-list"></i></a></li>
				<li class="nav-item hidden-md-down"><a class="nav-link"
					href="#"><i class="icon-location-pin"></i></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle nav-link" data-toggle="dropdown"
					href="#" role="button" aria-haspopup="true" aria-expanded="false">
				  <s:if test="#session.username!=null">
						<img src="img/avatars/6.jpg" class="img-avatar"
						alt="admin@bootstrapmaster.com"><%=username %>，您好 <span
						class="hidden-md-down"></span>
				</a>
					<div class="dropdown-menu dropdown-menu-right">
						<div class="dropdown-header text-center">
							<a href="#" onClick="custom_close()"><strong>退出系统</strong></a>
						</div>
					</div>
					</s:if>
					<s:else>
					<a href="TransLogin"> 您好，请登录</a>
					</s:else>
					</li>
				<li class="nav-item hidden-md-down"><a
					class="nav-link navbar-toggler aside-menu-toggler" href="#">☰</a></li>
			</ul>
			</header>
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="carousel slide" id="carousel-789172">
							<ol class="carousel-indicators">
								<li data-slide-to="0" data-target="#carousel-789172"></li>
								<li data-slide-to="1" data-target="#carousel-789172"></li>
								<li data-slide-to="2" data-target="#carousel-789172"
									class="active"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item">
									<a href="http://www.zhbit.com"> <img alt=""
										src="img/BookImg/BigBook1.jpg " />
									</a>
									<div class="carousel-caption">
										<h4>
											<font color="black">最热书籍，新品上市！！</font>
										</h4>
										<p>
											<font color="black">最新巨作，黄定自传6月1日盛大开卖！！</font>
										</p>
									</div>
								</div>
								<div class="item">
									<a href="http://localhost:8080"> <img alt=""
										src="img/BookImg/BigBook2.jpg" />
									</a>
									<div class="carousel-caption">
										<h4>
											<font color="black"> 万万没想到！，热卖书籍大减价，最低可至3折！</font>
										</h4>
										<p>
											<font color="black">点击进入大减价！gogogo！！！！</font>
										</p>
									</div>
								</div>
								<div class="item active">
									<a href="http://www.baidu.com"> <img alt=""
										src="img/BookImg/BigBook3.jpg" />
									</a>
									<div class="carousel-caption">
										<h4>
											<font color="black">买20送10，多买多送！速速购买！</font>
										</h4>
									</div>
								</div>

							</div>
							<a class="left carousel-control" href="#carousel-789172"
								data-slide="prev"><span
								class="glyphicon glyphicon-chevron-left"></span></a> <a
								class="right carousel-control" href="#carousel-789172"
								data-slide="next"><span
								class="glyphicon glyphicon-chevron-right"></span></a>
						</div>

					</div>
				</div>
			</div>
			<!-- 头部分-->

		</div>

		<div style="height:1px; width:100%; border-bottom:5px #000 solid"></div>
		<!-- 分割线 -->


		<div id="MyMain">
			<!-- 身体部分 -->
			<div id="nav">
				<li><a href="ShowTypeBooks?BType=1&pageNo=1">历史类图书</a></li>
				<li><a href="ShowTypeBooks?BType=2&pageNo=1">小说类图书</a></li>
				<li><a href="ShowTypeBooks?BType=3&pageNo=1">杂志刊物</a></li>
				<li><a href="ShowTypeBooks?BType=4&pageNo=1">儿童书籍</a></li>
				<li><a href="ShowTypeBooks?BType=5&pageNo=1">科学类读物</a></li>
			    <li><a href="ShowTypeBooks?BType=6&pageNo=1">教育类图书</a></li>
				<li><a href="ShowTypeBooks?BType=7&pageNo=1">法律类图书</a></li>
				<li><a href="ShowTypeBooks?BType=8&pageNo=1">音乐类图书</a></li>
				<li><a href="ShowTypeBooks?BType=9&pageNo=1">计算机类图书</a></li>
			</div>


			<div id="BookMain">
			<div align="right">
		    	<s:form action="ShowBooks" method="post">
		    		<s:textfield name="BName" Placeholder="请输入书名"/>
		    		<s:submit value="提交"/>
		    		
		    	</s:form>
		    </div>
		    <c:forEach var="stu" items="${checkMainPageBookList}">
				<div class="Book001">
					<img height="200x" width="100%" alt="图片"
						src="files/${stu.bpicture}">
					<p align="center">
						书名:${stu.bname} <br> 作者:${stu.bauthor} <br> 价格:${stu.bprice}
					</p>
					<a href="Buyer_CheckBookAction?BId=${stu.BId}" style="float:left;">查看详情</a>
					<a href="Buyer_AddCollectionAction?bid=${stu.BId}"
						style="float:right;">添加收藏夹</a>
				</div>
				</c:forEach>
			</div>
		</div>
		<div id="templatemo_footer">
		<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=black SIZE=3>
			<!-- 分割线 -->
		<div><!-- 底部 -->
		<p style="text-align: center">
 		 本系统由何嘉晨、黄定、温毅晓制作<br>
		Copyright @ 2017 ZHBIT All Rights Reserved
 		</p>
		</div>
	</div>
</body>
</html>
