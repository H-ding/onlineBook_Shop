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

<%
	String username = (String) request.getSession().getAttribute(
			"username");
%>
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
				href="LookThtoughOrder?pageNo=1">查看我的订单</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="UpdatePasswordTs">修改密码</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="UpdateMassageAction">修改个人信息</a></li>
			<li class="nav-item px-1"><a class="nav-link" href="SalerIndex">返回卖家管理主界面</a></li>
			<li class="nav-item px-1"><a class="nav-link" href="MainFrame">返回商城主页</a>
			</li>
		</ul>
		<ul class="nav navbar-nav ml-auto">
			<li class="nav-item hidden-md-down">
				<%
					int list_Size = (Integer) request.getSession().getAttribute(
							"list_Size");
				%> <a class="nav-link" href="WaitingDeliveryAction?pageNo=1"><i
					class="icon-bell"></i><span class="badge badge-pill badge-danger"><%=list_Size%></span></a>
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
					<li class="nav-item"><a class="nav-link" href="UploadBookTs"><i
							class="icon-speedometer"></i> 上传我的图书 <span
							class="badge badge-info">NEW</span></a></li>

					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle"
						href="CheckBookAction?pageNo=1"><em class="icon-puzzle"></em>&nbsp;&nbsp;&nbsp;&nbsp;查看我的图书</a>

					</li>
					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle" href="UpdateBookActionFirst"><i
							class="icon-star"></i> 修改我的图书信息</a></li>
					<li class="nav-item"><a class="nav-link"
						href="DeleteBookListAction?pageNo=1"><i
							class="icon-calculator"></i> 下架我的图书 <span
							class="badge badge-info"></span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="CheckSaleAmount?pageNo=1"><i class="icon-pie-chart"></i>
							查看我的店铺销售额</a></li>
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
				<a href="WaitingDeliveryAction?pageNo=1">首页</a>
				<c:if test="${pageNo>1}">
					<a href="WaitingDeliveryAction?pageNo=${pageNo-1}">上一页</a>
				</c:if>

				<a href="WaitingDeliveryAction?pageNo=${pageNo+1}">下一页</a>

				<table width="80%" border="1" height="56">
					<tr align="center">
						<td>订单ID</td>
						<td>图书图片</td>
						<td>卖家姓名</td>
						<td>买家姓名</td>
						<td>订单完成状态</td>
						<td>物流完成状态</td>
						<td></td>
					</tr>
					<c:forEach var="stu" items="${waitingDeliveryService_list}">
						<tr>
							<td><c:out value="${stu.OId}" /></td>
							<td><img width="30" height="30" alt="图片"
								src="files/${stu.bpicture}"></td>
							<td><c:out value="${stu.sname}" /></td>
							<td><c:out value="${stu.uname}" /></td>
							<td><c:out value="${stu.ostate}" /></td>
							<td><c:out value="${stu.logistics}" /></td>
							</td>
							<td><a href="DeliveryActiona?OId=${stu.OId}"> 发货</a></td>
						</tr>
					</c:forEach>
				</table>
			</center>
		</main>

		<!-- Bootstrap and necessary plugins -->
		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<script src="bower_components/tether/dist/js/tether.min.js"></script>
		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="bower_components/pace/pace.min.js"></script>


		<!-- Plugins and scripts required by all views -->
		<script src="bower_components/chart.js/dist/Chart.min.js"></script>


		<!-- GenesisUI main scripts -->

		<script src="js/app.js"></script>





		<!-- Plugins and scripts required by this views -->

		<!-- Custom scripts required by this view -->
		<script src="js/views/main.js"></script>
</body>

</html>