<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

	function bookname() {
		var bookname = document.getElementById("bname").value;
		var nullbookname = document.getElementById("nullbookname");
		if (bookname == null || bookname == "") {
			nullbookname.innerHTML = "书名不能为空！";
			return false;
		} else {
			nullbookname.innerHTML = "";
			return true;
		}
	}

	function author() {
		var authorname = document.getElementById("bauthor").value;
		var nullauthorname = document.getElementById("nullauthor");
		if (authorname == null || authorname == "") {
			nullauthorname.innerHTML = "作者不能为空！";
			return false;
		} else {
			nullauthorname.innerHTML = "";
			return true;
		}
	}

	function price() {
		var price = document.getElementById("bprice").value;
		var nullprice = document.getElementById("nullprice");
		var re = /^[0-9]*[1-9][0-9]*$/;
		if (price == null || price == "") {
			nullprice.innerHTML = "价格不能为空！";
			return false;
		} else if (!re.test(price)) {
			nullprice.innerHTML = "请输入数字";
			return false;
		} else {
			nullprice.innerHTML = "";
			return true;
		}
	}

	function number() {
		var number = document.getElementById("bnumber").value;
		var nullnumber = document.getElementById("nullnumber");
		var re = /^[0-9]*[1-9][0-9]*$/;
		if (number == null || number == "") {
			nullnumber.innerHTML = "数量不能为空！";
			return false;
		} else if (!re.test(number)) {
			nullnumber.innerHTML = "请输入数字";
			return false;
		} else {
			nullnumber.innerHTML = "";
			return true;
		}
	}

	function date() {
		var date = document.getElementById("bdate").value;
		var nulldate = document.getElementById("nulldate");
		var re = /^(\d{4})-(\d{2})-(\d{2})$/;
		if (date == null || date == "") {
			nulldate.innerHTML = "日期不能为空！";
			return false;
		} else if (!re.test(date)) {
			nulldate.innerHTML = "请输入正确的年份，如1995-07-08";
			return false;
		} else {
			nulldate.innerHTML = "";
			return true;
		}
	}

	function place() {
		var place = document.getElementById("bpress").value;
		var nullplace = document.getElementById("nullplace");
		if (place == null || place == "") {
			nullplace.innerHTML = "出版社不能为空！";
			return false;
		} else {
			nullplace.innerHTML = "";
			return true;
		}
	}

	function reg() {
		if (bookname() && author() && price() && number() && date() && place()) {
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
				<form action="UploadBookAction" method="post"
					enctype="multipart/form-data" onSubmit="return reg();">
					<div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="file" name="photo" placeholder="照片"
							style="margin-left:99px"
							accept="image/gif,image/jpeg,image/jpg,image/png,image/svg">
					</div>
					<div>
						图书名：&nbsp;&nbsp;&nbsp;<input type="text" id="bname" name="bname"
							placeholder="书名" onblur="bookname()">
					</div>
					<div id="nullbookname"></div>
					<div>
						图书作者：<input type="text" id="bauthor" name="bauthor"
							placeholder="作者" onblur="author()">
					</div>
					<div id="nullauthor"></div>
					<div>
						图书价格：<input type="text" id="bprice" name="bprice" placeholder="价格"
							onblur="price()">
					</div>
					<div id="nullprice"></div>
					<div>
						图书数量：<input type="text" id="bnumber" name="bnumber"
							placeholder="数量" onblur="number()">
					</div>
					<div id="nullnumber"></div>
					<div>
						图书类别： <select name="btype" id="select_k1"
							style="height:28px;width:156px">
							<option value="历史">历史</option>
							<option value="小说">小说</option>
							<option value="杂志">杂志</option>
							<option value="儿童">儿童</option>
							<option value="科学">科学</option>
							<option value="教育">教育</option>
							<option value="法律">法律</option>
							<option value="音乐">音乐</option>
							<option value="计算机">计算机</option>
						</select>
					</div>
					<div>
						出版如期：<input type="text" id="bdate" name="bdate" placeholder="出版日期"
							onblur="date()">
					</div>
					<div id="nulldate"></div>
					<div>
						出版社：&nbsp;&nbsp;&nbsp;<input type="text" id="bpress" name="bpress"
							placeholder="出版社" onblur="place()">
					</div>
					<div id="nullplace"></div>
					<div>
						图书介绍：<input type="text" name="bintroduce" placeholder="书籍介绍">
					</div>
					<input type="submit" value="确认上传">
					<form>
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