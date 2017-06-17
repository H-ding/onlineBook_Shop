<%@ page language="java" import="java.util.*,com.itheima.domain.TPay"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
</script>
<!--  通过 iframe 嵌入前端定位组件，此处没有隐藏定位组件，使用了定位组件的在定位中视觉特效  -->


<script type="text/JavaScript">
	var loc;
	//var isMapInit = false;
	//监听定位组件的message事件
	window.addEventListener('message', function(event) {
		loc = event.data; // 接收位置信息
		console.log('location', loc);//console显示信息
		var loger = document.getElementById("aaa");
		loger.innerHTML = loc;
	}, false);
	//为防止定位组件在message事件监听前已经触发定位成功事件，在此处显示请求一次位置信息
	document.getElementById("geoPage").contentWindow.postMessage('getLocation',
			'*');

	//设置6s超时，防止定位组件长时间获取位置信息未响应
	setTimeout(function() {
		if (!loc) {
			//主动与前端定位组件通信（可选），获取粗糙的IP定位结果
			document.getElementById("geoPage").contentWindow.postMessage(
					'getLocation.robust', '*');
		}
	}, 6000); //6s为推荐值，业务调用方可根据自己的需求设置改时间，不建议太短
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
				TPay tpay = (TPay) request.getSession().getAttribute("pay");
				String bname = tpay.getBname();
				String sname = tpay.getSname();
				int packet_ = tpay.getPackage_();
				int Count = tpay.getTcount();
				int price = tpay.getMOney();
				String bpicture = tpay.getBpicture();
			%>
			<div>
				<form action="Buyer_Car_BuyingAction" method="post">


					<table width="100%" cellspacing="50">
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>图书：<%=bname%></th>
							<th>卖家：<%=sname%></th>
						</tr>
						<tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<th><img width="100px" height="100px"
							src="files/<%=bpicture%>"></th>
						<th>套餐：套餐<%=packet_%><br> 数量：<%=Count%><br> <%
 	String vip = (String) request.getSession().getAttribute("VIP");
 	if ("否".equals(vip)) {
 %> 价钱 :<%=price%><br> <%
 	} else {
 %> 会员价 :<%=price%><br> <%
 	}
 %>
						</th>
						<th>订单状态：未付款</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th colspan="3"><script language="javascript">
								// 这个脚本是 ie6和ie7 通用的脚本
								function scc() {
									var cs = document
											.getElementById("Taddress");
									cs.innerHTML = document
											.getElementById("geoPage").value;
								}
							</script> <iframe id="geoPage" width="100%" height="3%" frameborder=0
									scrolling="no"
									src="https://apis.map.qq.com/tools/geolocation?key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp&effect=zoom"></iframe>
								<input type="text" id="Taddress" name="Taddress" maxlength="200"
								placeholder="请输入您的收货地址"></th>

						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<th colspan="3"><input type="submit" value="确认购买"></th>
						</tr>
					</table>

				</form>
			</div>

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