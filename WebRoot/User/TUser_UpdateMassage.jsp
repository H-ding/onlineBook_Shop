<%@ page language="java" import="java.util.*,com.itheima.domain.TUser"
	pageEncoding="UTF-8"%>
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

	function ttel() {
		var tel = document.getElementById("tel").value;
		var nulltel = document.getElementById("nulltel")
		var reg = /^1(3|4|5|7|8)\d{9}$/ //表示以1开头，第二位可能是3/4/5/7/8等的任意一个，在加上后面的\d表示数字[0-9]的9位，总共加起来11位结束
		if (tel == null || tel == "") {
			nulltel.innerHTML = "手机号不能为空！！！";
			return false;
		} else if (tel.length != 11 || !reg.test(tel)) {
			nulltel.innerHTML = "请正确填写手机号";
			return false;
		} else {
			nulltel.innerHTML = "";
			return true;
		}
	}

	function reg() {
		if (ttel()) {
			document.forms[0].submit();
			return true;
		} else {
			return false;
		}
	}
</script>
</head>


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
				href="Buyer_CheckOrderListAction?pageNo=1">查看我的订单</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="TUser_UpdatePassword">修改密码</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="buyer_UpdateMassageFisrtAction">修改个人信息</a></li>
			<li class="nav-item px-1"><a class="nav-link"
				href="TUerBackMainPage">返回买家管理主页</a></li>
			<li class="nav-item px-1"><a class="nav-link" href="MainFrame">返回商城主页</a>
			</li>
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
						href="buyer_CheckCarAction?pageNo=1"><i
							class="icon-speedometer"></i> 进入我的购物车 <span
							class="badge badge-info">NEW</span></a></li>

					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle"
						href="Buyer_CheckCollectionListAction?pageNo=1"><em
							class="icon-puzzle"></em>&nbsp;&nbsp;&nbsp;&nbsp;查看收藏夹</a></li>
					<li class="nav-item nav-dropdown"><a
						class="nav-link nav-dropdown-toggle"
						href="Buyer_CheckOrder_ING_Action?pageNo=1"><i
							class="icon-star"></i> 查看正在进行中的订单</a></li>
					<li class="nav-item"><a class="nav-link"
						href="buyer_CheckMassageFisrtAction"><i
							class="icon-calculator"></i> 查看我的个人信息 <span
							class="badge badge-info"></span></a></li>

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
			<%
				TUser tseller = (TUser) request.getSession().getAttribute(
						"buyer_updateFirst_tuser");
				String address = tseller.getUaddresss();
				String tel = tseller.getTel();
			%>
			<form action="Buyer_UpdateMassageAction" method="post" onSubmit="return reg();">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-md-6">
							<div class="card mx-2">
								<div class="card-block p-2">
									<h1>UpdateMassage</h1>
									<p class="text-muted">Update your Massage</p>
									<div class="input-group mb-1">
										<span class="input-group-addon"><i class="icon-user"></i>
										</span> <input type="text" name="username" class="form-control"
											placeholder="Username" value="<%=username%>"
											readonly="readonly">
									</div>
									<div class="input-group mb-1">
										<span class="input-group-addon"><i class="icon-user"></i></span>
										<input type="text" name="address" placeholder="address"
											class="form-control" rows="10" cols="35" value="<%=address%>">
										</textarea>
									</div>

									<div class="input-group mb-1">
										<span class="input-group-addon"><i class="icon-user"></i>
										</span> <input type="text" name="tel" class="form-control"
											placeholder="tel" id="tel" onblur="ttel()">
									</div>
									<div id="nulltel"></div>

									<button type="submit" class="btn btn-block btn-success">Update
										Account</button>
								</div>
								<div class="card-footer p-2">
									<div class="row">
										<div class="col-6">
											<button class="btn btn-block btn-facebook" type="button">
												<span>facebook</span>
											</button>
										</div>
										<div class="col-6">
											<button class="btn btn-block btn-twitter" type="button">
												<span>twitter</span>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
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