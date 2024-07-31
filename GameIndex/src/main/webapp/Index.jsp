<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>GameIndex</title>
<style type="text/css">
body{
background-image:url('picture//Index.jpg');
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
function check(){
	var name = document.getElementById("name").value;
	var code =document.getElementById("code").value;
	var errorName=document.getElementById("errorTip1");
	var errorCode=document.getElementById("errorTip2");
	errorName.textContent="";
	errorCode.textContent="";
	if(!/^[A-Za-z0-9]{5,20}$/.test(name)){
		errorName.textContent="请输入5到20位的数字或字母作为用户名";
		return false;
	}
	if(!/^[A-Za-z0-9]{5,20}$/.test(code)){
		errorCode.textContent="请输入5到20位的数字或字母作为用户名";
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div style="display:flex;text-align:center;justify-content:center;align-items: center;opacity:1;background-color:rgba(255, 255, 255, 0.5);width:300px;height:300px;margin-top:100px">
<form action="CheckLogin" method="post" onsubmit="return check();" target="_blank" >
<h1>GameIndex</h1><br><br>
<span id="errorTip0"><% 
String check=(String)request.getAttribute("isRepeat");
if(check!=null&&check.equals("false"))out.print("用户名或密码错误");
%></span><br> 
账号<input type="text" id="name" name="name"><br>
<span id="errorTip1"></span><br>
密码<input type="password" id="code" name="code"><br>
<span id="errorTip2"></span><br>
<input type="submit" value="登录">&emsp;&emsp;&emsp;
<input type="button" value="注册" onclick="window.location.href='register.jsp';">
<input type="button" value="修改密码" onclick="window.location.href='changeCode.jsp';">
</form>
</div>
</body>
</html>