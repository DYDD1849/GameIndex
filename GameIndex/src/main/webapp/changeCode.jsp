<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>GameIndex</title>
<style type="text/css">
body{
background-image:url('picture//changeCode.jpg');
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
	var newcode =document.getElementById("newcode").value;
	var errorName=document.getElementById("errorTip1");
	var errorCode=document.getElementById("errorTip2");
	var errornewCode=document.getElementById("errorTip3");
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
	if(!/^[A-Za-z0-9]{5,20}$/.test(newcode)){
		errornewCode.textContent="请输入5到20位的数字或字母作为用户名";
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div style="display:flex;text-align:center;justify-content:center;align-items: center;opacity:1;background-color:rgba(255, 255, 255, 0.5);width:300px;height:300px;margin-top:100px">
<form action="ChangeCode" method="post" onsubmit="return check();">
<h1>修改密码</h1><br><br>
<span id="errorTip0"><% 
String check=(String)request.getAttribute("isWrong");
if(check!=null&&check.equals("true"))out.print("用户名或密码错误");
if(check!=null&&check.equals("false"))out.print("修改成功");
%></span><br>
账&emsp;号<input type="text" id="name" name="name"><br>
<span id="errorTip1"></span><br>
原密码<input type="password" id="code" name="code"><br>
<span id="errorTip2"></span><br>
新密码<input type="password" id="newcode" name="newcode"><br>
<span id="errorTip3"></span><br>
<input type="submit" value="修改">&emsp;&emsp;&emsp;
<input type="button" value="返回" onclick="window.location.href='Index.jsp';">
</form>
</div>
</body>
</html>