<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>GameIndex</title>
<style type="text/css">
body{
background-image:url('picture/register.jpg');
background-repeat:no-repeat;
background-position: center;
margin: 0;
background-size: cover;
display:flex;
justify-content:center;
}
span{
	font-size:12px;
	color:red;
}
</style>
<script>
function check()
{
	    var username =  document.getElementById("name").value;  
	    var password = document.getElementById("code").value;  
	    var usernameError = document.getElementById('errorTip1');  
	    var passwordError = document.getElementById('errorTip2');  
	    usernameError.textContent = "";  
	    passwordError.textContent = "";
	    if (!/^[A-Za-z0-9]{5,20}$/.test(username)) {  
	        usernameError.textContent = "请输入5到20位的数字或字母作为用户名";  
	        return false; 
	    }
	    if(!/^[A-Za-z0-9]{5,20}$/.test(password)){
	    	passwordError.textContent="请输入5到20位的数字或字母作为用户名";
	    	return false;
	    }
	    return true;
}
</script>
</head>
<body>
<div style="text-align:center;display:flex;justify-content: center;align-items: center;opacity:1;background-color:rgba(255, 255, 255, 0.7);width:300px;height:300px;margin-top:100px">
<form action="CheckRegister" method="post" onsubmit="return check();">
<h1>注&emsp;册</h1><br><br>
账号<input type="text" id="name" name="name"><br>
<span id="errorTip1"></span><br><br>
密码<input type="password" id="code" name="code"><br>
<span id="errorTip2"></span><br><br>
<input type="submit" value="注册" >&emsp;&emsp;&emsp;
<input type="button" value="返回" onclick="window.location.href='Index.jsp';">	
<br></form>
</div>
</body>
</html>