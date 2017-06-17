<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="CoreUI Bootstrap 4 Admin Template">
<meta name="author" content="Lukasz Holeczek">
<meta name="keyword" content="CoreUI Bootstrap 4 Admin Template">
<!-- <link rel="shortcut icon" href="assets/ico/favicon.png"> -->

<title>CoreUI Bootstrap 4 Admin Template</title>

<!-- Icons -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/simple-line-icons.css" rel="stylesheet">

<!-- Main styles for this application -->
<link href="css/style.css" rel="stylesheet">
<!-- JS校验 -->
<script type="text/javascript">  
    function tname(){  
    var name=document.getElementById("userName").value;  
    var nullname=document.getElementById("nullname");  
    var re = /^[A-Za-z0-9]+$/;
    if(name==null||name==""){  
    nullname.innerHTML="用户名不能为空！";  
    return false;  
    }else if(name.length<6||name.length>=12){  
    nullname.innerHTML="用户名长度为6--12个字符长度！";  
    return false;  
    }else if(!re.test(name)){
    nullname.innerHTML="用户名由字母、数字、下划线组成，字母开头，4-16位！";  
    return false;
    }else{  
    nullname.innerHTML="";  
    return true;  
    }       
    }  
      
    function ppwd(){  
    var pwd=document.getElementById("password").value;  
    var nullpwd=document.getElementById("nullpwd");
    var re = /^[A-Za-z0-9]+$/;  
    if(pwd==null||pwd==""){  
    nullpwd.innerHTML="密码不能为空！";  
    return false;  
    }else if(pwd.length<6||pwd.length>=12){  
    nullpwd.innerHTML="密码长度为6--12个字符长度！";  
    return false;  
    }else if(!re.test(pwd)){
    nullpwd.innerHTML="密码由字母、数字、下划线组成，字母开头，4-16位！";  
    return false;
    }else{  
    nullpwd.innerHTML="";  
    return true;  
    }      
    }  
      
   function ttpwd(){  
     var pwd=document.getElementById("password").value;  
       var tpwd=document.getElementById("tpwd").value;  
       var nulltpwd=document.getElementById("nulltpwd");    
       if(tpwd==null||tpwd==""){  
       nulltpwd.innerHTML="确认密码不能为空！！！";  
       return false;  
       }else if(tpwd!=pwd){  
       nulltpwd.innerHTML="两次密码输入不一致";  
       return false;  
       }else{  
       nulltpwd.innerHTML="";  
       return true;  
       }        
   }   
     
     function eemail(){  
   var eamil=document.getElementById("email").value;  
   var nullemail=document.getElementById("nullemail");  
  // var reg=/^[a-zA-Z0-9_-]+@(126|163|qq|sohu|sina+\.)+(com|cn|net|org)$/  
  var reg=/^[a-zA-Z0-9_-]+@(126.com|163.com|qq.com|sohu.com |sina.com|hotmail.com|gmail.com|yahoo.cn)$/;  
   if(eamil==null||eamil==""){  
   nullemail.innerHTML="Email地址不能为空";  
   return false;  
   }else{  
   nullemail.innerHTML="";  
   return true;  
   }  
   }
     
   
   function ttel(){  
   var tel=document.getElementById("tel").value;  
   var nulltel=document.getElementById("nulltel")  
   var reg=/^1(3|4|5|7|8)\d{9}$/  //表示以1开头，第二位可能是3/4/5/7/8等的任意一个，在加上后面的\d表示数字[0-9]的9位，总共加起来11位结束
   if(tel==null||tel==""){  
   nulltel.innerHTML="手机号不能为空！！！";  
   return false;  
   }else if(tel.length!=11||!reg.test(tel)){  
   nulltel.innerHTML="请正确填写手机号";  
   return false;  
   }else {  
   nulltel.innerHTML="";  
   return true;  
   }  
   }  
   
    function reg(){  
    if(tname()&&ppwd()&&ttpwd()&&ttel()&&eemail()){  
    document.forms[0].submit();  
    return true;  
    }else{  
    return false;  
    }  
    }  
    </script>
</head>

<body>
	<!-- class="app flex-row align-items-center" -->

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card mx-2">
					<div class="card-block p-2">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<h4 style="display: inline-block;">
							<a href="SalerRegist">卖家注册</a>
						</h4>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<h4 style="display: inline-block;">
							<a href="#">买家注册</a>
						</h4>
						<h1>BuyerRegister</h1>
						<form action="buyerRegist" method="post" onSubmit="return reg();">
							
								<p class="text-muted">Create your account</p>
						
								<div class="input-group mb-1">
									<span class="input-group-addon"><i class="icon-user"></i>
									</span> <input type="text" id="userName" onblur="tname()" name="username" class="form-control"
										placeholder="Username">
								</div>
								
								<div id="nullname"></div>
								
								
								<div class="input-group mb-1">
									<span class="input-group-addon"><i class="icon-lock"></i>
									</span> <input type="password" name="password" class="form-control"
										placeholder="Password"  id="password" onblur="ppwd()">
								</div>
								
						          <div id="nullpwd"></div>
                               
								<div class="input-group mb-2">
									<span class="input-group-addon"><i class="icon-lock"></i>
									</span> <input type="password" name="repassword" class="form-control"
										placeholder="Repeat password" id="tpwd" onblur="ttpwd()">
								</div>
								
								<div id="nulltpwd"></div>
								
								<div class="input-group mb-1">
									<span class="input-group-addon"><i class="icon-user"></i></span>
									<input type="tel" class="form-control" name="tel"
										placeholder="tel" id="tel" onblur="ttel()">
								</div>
                              
                                <div id="nulltel"></div>
                              
								<div class="input-group mb-1">
									<span class="input-group-addon"><i class="icon-user"></i></span>
									<input type="text" name="address" class="form-control"
										placeholder="address">
								</div>
								
								<div id="nulladdress"></div>
								
								
								<div class="input-group mb-1">
									<span class="input-group-addon"><i class="icon-user"></i></span>
									<input type="email" name="email" class="form-control"
										placeholder="email" id="email" onblur="eemail()">
								</div>
							<div id="nullemail"></div>
						
								
								<button type="submit" class="btn btn-block btn-success">Create
									Account</button>
							
						</form>
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
	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<script src="bower_components/tether/dist/js/tether.min.js"></script>
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>