/User<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

	function tname() {
		var number = document.getElementById("TCount").value;
		var nullnumber = document.getElementById("asa");
		var re = /^[0-9]*[1-9][0-9]*$/;
		if (number == null || number == "") {
			nullnumber.innerHTML = "数量不能为空！";
			return false;
		} else if (!re.test(number)) {
			nullnumber.innerHTML = "请输入正整数";
			return false;
		} else {
			nullnumber.innerHTML = "";
			return true;
		}
	}

	function reg() {
		if (tname()) {
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
			<center>
				<c:forEach var="stu" items="${buyer_tbook}">
					<form action="" name="fm" id="fm" method="post">
						<table width="80%" border="1" height="56">
							<tr>

								<td colspan="2">
									<center>
										<img width="70%" height="65%" alt="图片"
											src="files/${stu.bpicture}">
									</center>
								</td>
							</tr>
							<tr>
								<td>书名</td>
								<td><center>
										<c:out value="${stu.bname}" />
									</center></td>
							</tr>
							<tr>
								<td>作者</td>
								<td><center>
										<c:out value="${stu.bauthor}" />
									</center></td>
							</tr>
							<tr>
								<td>单价</td>
								<td><center>
										<c:out value="${stu.bprice}" />
									</center></td>
							</tr>
							<tr>
								<td>数量</td>
								<td><center>
										<c:out value="${stu.bnumber}" />
									</center></td>
							</tr>
							<tr>
								<td>类型</td>
								<td><center>
										<c:out value="${stu.btype}" />
									</center></td>
							</tr>
							<tr>
								<td>出版日期</td>
								<td><center>
										<c:out value="${stu.bdate}" />
									</center></td>
							</tr>
							<tr>
								<td>出版社</td>
								<td>
									<center>
										<c:out value="${stu.bpress}" />
									</center>
								</td>
							</tr>
							<tr>
								<td>书籍介绍</td>
								<center>
									<td><center>
											<c:out value="${stu.bintroduce}" />
										</center></td>
								</center>
							</tr>
							<tr>
								<td colspan="2">
									<center>
										<input type="radio" name="setmeal" value="套餐一"
											checked="checked" />套餐一 <input type="radio" name="setmeal"
											value="套餐二" />套餐二 <input type="radio" name="setmeal"
											value="套餐三" />套餐三
									</center>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<center>
										<div>
											<input type="text" id="TCount" onblur="tname()" name="TCount"
												placeholder="请输入要购买的数量">
										</div>
										<div id="asa"></div>
									</center>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<center>
										<input type="button" name="btn1"
											onclick="document.fm.action='Buyer_AddCarAction?BId=${stu.BId}';document.fm.submit();"
											value="加入购物车">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" name="btn2"
											onclick="document.fm.action='Buyer_BuyingAction?BId=${stu.BId}&SId=${stu.TSeller.SId}';document.fm.submit();"
											value="直接购买">
									</center>
								</td>
							</tr>

						</table>
					</form>
				</c:forEach>

				<c:forEach var="bs" items="${BookEVList}">
					<table width="85%">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th>客户评价区</th>
						</tr>
						<tr>
							<th>来自<c:out value="${bs.uname}"></c:out>的评价
							</th>
							<th><span>图书质量：<c:out value="${bs.quality}"></c:out></span>
								<span>配送速度：<c:out value="${bs.dispatching}"></c:out></span> <span>服务态度：<c:out
										value="${bs.diservice}"></c:out></span></th>
						</tr>
						<tr>
							<th></th>
							<th><c:out value="${bs.uevaluate}"></c:out></th>
						</tr>
					</table>

				</c:forEach>
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