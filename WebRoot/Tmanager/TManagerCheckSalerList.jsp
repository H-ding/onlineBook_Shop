<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Łukasz Holeczek">
<meta name="keyword"
	content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
<link rel="shortcut icon" href="img/favicon.png">

<title>CoreUI - Open Source Bootstrap Admin Template</title>

<!-- Icons -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/simple-line-icons.css" rel="stylesheet">

<!-- Main styles for this application -->
<link href="css/style.css" rel="stylesheet">

</head>
<script language="javascript">
	// 这个脚本是 ie6和ie7 通用的脚本
	function custom_close() {
		if (confirm("您确定要关闭本页吗？")) {
			window.opener = null;
			window.open('', '_self');
			window.close();
		} else {
		}
	}
</script>

<%
	String username = (String) request.getSession().getAttribute(
			"username");
%>
<body
	class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
	<header class="app-header navbar">
		<button class="navbar-toggler mobile-sidebar-toggler hidden-lg-up"
			type="button">☰</button>
		<a class="navbar-brand" href="#"></a>
		<ul class="nav navbar-nav hidden-md-down">
			<li class="nav-item"><a
				class="nav-link navbar-toggler sidebar-toggler" href="#">☰</a></li>

			<li class="nav-item px-1"><a class="nav-link"
				href="TManagerRegister">注册管理员</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="TManagerUpdatPassword">修改密码</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="BackMainPage">返回主页面</a></li>
		</ul>
		<ul class="nav navbar-nav ml-auto">
			<li class="nav-item hidden-md-down"><a class="nav-link" href="#"><i
					class="icon-bell"></i><span class="badge badge-pill badge-danger">0</span></a>
			</li>
			<li class="nav-item hidden-md-down"><a class="nav-link" href="#"><i
					class="icon-list"></i></a></li>
			<li class="nav-item hidden-md-down"><a class="nav-link" href="#"><i
					class="icon-location-pin"></i></a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle nav-link" data-toggle="dropdown"
				href="#" role="button" aria-haspopup="true" aria-expanded="false">
					<img src="img/avatars/6.jpg" class="img-avatar"
					alt="admin@bootstrapmaster.com"> <span class="hidden-md-down"><%=username%></span>
			</a>
				<div class="dropdown-menu dropdown-menu-right">

					<div class="dropdown-header text-center">
						<strong>Account</strong>
					</div>




				</div></li>
			<li class="nav-item hidden-md-down"><a
				class="nav-link navbar-toggler aside-menu-toggler" href="#">☰</a></li>

		</ul>
	</header>

	<div class="app-body">
		<div class="sidebar">
			<nav class="sidebar-nav">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="TManager_CheckAllOrderListAction?pageNo=1"><i
							class="icon-speedometer"></i> 查看所有订单 </a></li>


					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle"
						href="TManager_CheckBookListAction?pageNo=1"><i
							class="icon-star"></i> 修改图书信息</a></li>
					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle"
						href="TManagerCheckMainPageBookList"><i class="icon-star"></i>
							查看主页图书列表</a></li>
					<li class="divider"></li>
					<li class="nav-title">退出系统</li>
					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle" href="#"
						onclick="custom_close()"><i class="icon-star"></i> exit</a></li>
				</ul>
			</nav>
		</div>

		<!-- Main content -->
		<main class="main">
			<center>
				<a href="TManagerCheckSalerList?pageNo=1">首页</a>
				<c:if test="${pageNo>1}">
					<a href="TManagerCheckSalerList?pageNo=${pageNo-1}">上一页</a>
				</c:if>

				<a href="TManagerCheckSalerList?pageNo=${pageNo+1}">下一页</a>

				<table border="1" width="100%">

					<tr>
						<th>卖家id</th>
						<th>用户名</th>
						<th>卖家介绍</th>
						<th>卖家地址</th>
						<th>查看卖家的销售额</th>
					</tr>
					<c:forEach var="stu" items="${managerSalerList}">
						<tr>

							<th><c:out value="${stu.SId}"></c:out></th>
							<th><c:out value="${stu.sname}"></c:out></th>
							<th><c:out value="${stu.sintroduce}"></c:out></th>
							<th><c:out value="${stu.saddress}"></c:out></th>
							<th><a
								href="TManagerCheckSalerAmount?sname=${stu.sname}&pageNo=1&ls=0">查看卖家的销售额</a></th>
						</tr>
					</c:forEach>
				</table>
			</center>
		</main>
		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<script src="bower_components/tether/dist/js/tether.min.js"></script>
		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="bower_components/pace/pace.min.js"></script>
		<script src="bower_components/chart.js/dist/Chart.min.js"></script>
		<script src="js/app.js"></script>
		<script src="js/views/main.js"></script>
</body>
</html>