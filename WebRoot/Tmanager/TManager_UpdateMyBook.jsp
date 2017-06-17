<%@ page language="java" import="java.util.*,com.itheima.domain.TBook"
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
			<%
				TBook tbook = (TBook) request.getSession().getAttribute("book");
				int BId = tbook.getBId();
				String bname = tbook.getBname();
				String bauthor = tbook.getBauthor();
				int bprice = tbook.getBprice();
				int bnumber = tbook.getBnumber();
				String btype = tbook.getBtype();
				String bdate = tbook.getBdate();
				String bpress = tbook.getBpress();
				String bintroduce = tbook.getBintroduce();
				int SId=tbook.getTSeller().getSId();
			%>
			<center>
				<form action="TManager_UpdateBookActionSecond?BId=<%=BId%>&SId=<%=SId%>"
					method="post">
					书名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text"
						name="bname" value="<%=bname%>"><br>
					作者&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text"
						name="bauthor" value="<%=bauthor%>"><br>
					价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text"
						name="bprice" value="<%=bprice%>"><br>
					数量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text"
						name="bnumber" value="<%=bnumber%>"><br>
					类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text"
						name="btype" value="<%=btype%>"><br> 出版日期：<input
						type="text" name="bdate" value="<%=bdate%>"><br>
					出版社&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" name="bpress"
						value="<%=bpress%>"><br> 书籍介绍：<input type="text"
						name="bintroduce" value="<%=bintroduce%>"><br>
					<button type="submit" value="确认修改">确认修改</button>
				</form>

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