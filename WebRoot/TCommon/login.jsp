<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html lang="en">
<%@taglib prefix="s" uri="/struts-tags" %>
  <head>
 <meta >
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

</head>

<script type="text/javascript">     
    function changeValidateCode(obj) {     
           //获取当前的时间作为参数，无具体意义     
        var timenow = new Date().getTime();     
           //每次请求需要一个不同的参数，否则可能会返回同样的验证码     
        //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。     
        obj.src="VerificationCodeUtilAction?d="+timenow;     
    }    
$.ajax({
    method: 'post',
    url: 'LoginAction',
    dataType: 'text',
    // 用户名和密码
    data: {username: $("#username").val(), password: $("#password").val()},
    
    success: function(data){
        // 假设后端传回的 1 表示成功， 0 表示用户名或密码错误
        if (data) {
            alert("验证通过");
        } else {
            alert("用户名或密码错误");
        }
    }
});
</script>

<body class="app flex-row align-items-center">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card mx-2">
                    <div class="card-block p-2">
                       <form action="SalerLoginAction?pageNo=1" method="post">
                        <h1>Login</h1>
                        <p class="text-muted">Login your account</p>
                        <div class="input-group mb-1">
                            <span class="input-group-addon"><i class="icon-user"></i>
                            </span>
                            <input type="text" id="username" name="username" class="form-control" placeholder="Username">
                        </div>
                        <div class="input-group mb-1">
                            <span class="input-group-addon"><i class="icon-lock"></i>
                            </span>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                        </div>
                       <div class="input-group mb-1">
                       <span class="input-group-addon">
                            </span>
                     <tr>
						<td height="24" valign="bottom"><div align="right"><span class="STYLE3">验证码</span></div></td>
						<td width="10" valign="bottom">&nbsp;</td>
						<td width="52" height="24" valign="bottom"><input type="text" maxlength=4 name="yzm" id="textfield3" style="width:50px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; "></td>
						<td width="92" valign="bottom"><div align="center"><img src="${pageContext.request.contextPath}/VerificationCodeUtilAction.action" width="80" height="20" onclick="changeValidateCode(this)"></div></td></tr>
              
                      </div>

                        <button type="submit" class="btn btn-block btn-success">Login Account</button>
                      </form>
                    </div>
                    
                    <div class="card-footer p-2">
                        <div class="row">
                            <div class="col-6">
                                <a href="SalerRegist"><button class="btn btn-block btn-facebook" type="button">
                                    <span>regist</span>
                                </button>
                                </a>
                            </div>
                            <div class="col-6">
                                <button class="btn btn-block btn-twitter" type="button">
                                    <span>forget psaaword?</span>
                                </button>
                            </div>
                   
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap and necessary plugins -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/tether/dist/js/tether.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


</body>

</html>