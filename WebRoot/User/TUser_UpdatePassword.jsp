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

	function ppwd() {
		var pwd = document.getElementById("password").value;
		var nullpwd = document.getElementById("nullpwd");
		var re = /^[A-Za-z0-9]+$/;
		if (pwd == null || pwd == "") {
			nullpwd.innerHTML = "密码不能为空！";
			return false;
		} else if (pwd.length<6||pwd.length>12) {
			nullpwd.innerHTML = "密码长度为6--12个字符长度！";
			return false;
		} else if (!re.test(pwd)) {
			nullpwd.innerHTML = "密码由字母、数字、下划线组成，字母开头，4-16位！";
			return false;
		} else {
			nullpwd.innerHTML = "";
			return true;
		}
	}

	function ttpwd() {
		var pwd = document.getElementById("password").value;
		var tpwd = document.getElementById("tpwd").value;
		var nulltpwd = document.getElementById("nulltpwd");
		if (tpwd == null || tpwd == "") {
			nulltpwd.innerHTML = "确认密码不能为空！！！";
			return false;
		} else if (tpwd != pwd) {
			nulltpwd.innerHTML = "两次密码输入不一致";
			return false;
		} else {
			nulltpwd.innerHTML = "";
			return true;
		}
	}

	function reg() {
		if (ppwd() && ttpwd()) {
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
			<form action="buyer_UpdatepasswordAction" method="post" onSubmit="return reg();">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-md-6">
							<div class="card mx-2">
								<div class="card-block p-2">
									<h1>UpdatePassword</h1>
									<p class="text-muted">Update your Password</p>
									<div class="input-group mb-1">
										<span class="input-group-addon"><i class="icon-user"></i>
										</span> <input type="text" name="username" class="form-control"
											readonly="readonly" value="<%=username%> ">
									</div>
									<div class="input-group mb-1">
										<span class="input-group-addon"><i class="icon-lock"></i></span>
										<input type="password" name="oldpassword" class="form-control"
											placeholder="Old Password">
									</div>

									<div class="input-group mb-1">
										<span class="input-group-addon"><i class="icon-lock"></i>
										</span> <input type="password" name="newpassword" id="password"
											class="form-control" placeholder="New Password"
											onblur="ppwd()">
									</div>
									<div id="nullpwd"></div>

									<div class="input-group mb-2">
										<span class="input-group-addon"><i class="icon-lock"></i>
										</span> <input type="password" name="repeatnewpassword" id="tpwd"
											class="form-control" placeholder="Repeat New password"
											onblur="ttpwd()">
									</div>
									<div id="nulltpwd"></div>

									<button type="submit" class="btn btn-block btn-success">Update
										Password</button>
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