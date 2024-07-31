<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="GameBack.user,GameBack.game,java.util.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>GameIndex.doRegister</title>
<style type="text/css">
td{
width:200px;
margin-right:20px;
	color:white;
}
body{
	background-color:#121212;
}
.divtitle{
	display:flex;
	width:100%;height:80px;
	background-color:#18181C;
	justify-content:space-between;
	align-items:center;
}
.titleleft{
	height:100px;
	width:550px;
	display:flex;
	align-items:center;
	justify-content:space-around;
}
.titleright{
	margin-right:30px;
	width:300px;
	color:white;
	display:flex;
	justify-content:space-around;
	align-items:center;
}
.titletext{
	color:white;
	font-size:35px;
} 
span.gametime{
	margin-top:0px;
	font-size:10px;
	color:white;
}
.divfind{
	height:40px;
	width:210px;
	display:flex;
	justify-content:center;
	align-items:center;background-color:#4d4d4d;
	border-radius:40px;
}
.findtext{
	color:white;
	border:none;
	background:none;
	outline:none;
	height:30px;
	width:150px;
}
.findimage{
	width:30px;
	height:30px;
}
form.find{
	display: flex;
	height:15px;
	width:180px;
}
.main{
	display:flex;
	flex-wrap: wrap;
}
.game{
	magrin-right:5px;
	magrin-top:10px;
	width:140px;
	height:250px;
}
.gameimg{
	width:130px;
	height:200px;
	}
form.manger{
	height:30px;
}
a{
	text-decoration:none;
	color:white;
}
a:hover{
border:2px solid red;
}
.nonebuttonsubmit{
	color:white;
	border:none;
	background:none;
	padding:0;
}
.nonebuttonsubmit:hover{
	text-decoration:underline;
}
.hiddenform{
position:fixed;
left:35%;
top:10%;
display:none;
text-align:center;
justify-content:center;
align-items: center;
opacity:1;
background-color:rgba(255, 255, 255, 1);
width:300px;
height:300px;
}
</style>
<% List<game> games=(List<game>)request.getAttribute("games");
	Iterator<game> iter = games.iterator(); %>
<% user user=(user)request.getAttribute("user"); %>
<% String path=(String)request.getAttribute("path"); %>
<script>
function display(hiddenform){
	var form=document.getElementById(hiddenform);
	form.style.display="flex";
}
function displaynone(hiddenform){
	var form=document.getElementById(hiddenform);
	form.style.display="none";
}
function populateForm(name, date, intro){
    var form = document.getElementById('hiddenform2');
    
    // 填充输入框
    form.querySelector('[name="name"]').value = name;
    form.querySelector('[name="oldname"]').value = name;
    form.querySelector('[name="date"]').value = date;
    form.querySelector('[name="olddate"]').value = date;
    form.querySelector('[name="intro"]').value = intro;
    
    // 显示表单
    form.style.display = 'flex';
}
function dir(){
	window.location.href = "mainPage.jsp";
}
</script>
</head>
<body>
<div class="hiddenform" id="hiddenform">
	<form action="mangerInsert" method="post" enctype="multipart/form-data">
		<span>填写新游戏信息</span><br>
		<input type="hidden" value="<%=user.getName() %>" name="username" >
		名字：<input type="text" name="name"><br>
		日期：<input type="date" name="date"><br>
		图片：<input style="width:100px" type="file" name="image"><br>
		介绍：<input type="text" name="intro"><br>
		<br><input type="submit" value="添加" >&emsp;&emsp;<input type="button" value="返回" onclick="displaynone('hiddenform')">
	</form>
</div>
<div class="hiddenform" id="hiddenform2">
	<form action="mangerEdit" method="post" enctype="multipart/form-data">
		<span>编辑</span><br>
		<input type="hidden" name="oldname">
		<input type="hidden" name="olddate">
		<input type="hidden" value="<%=user.getName() %>" name="username" >
		名字：<input type="text" name="name"><br>
		日期：<input type="date" name="date"><br>
		图片：<input style="width:100px" type="file" name="image"><br>
		介绍：<input type="text" name="intro"><br>
		<br><input type="submit" value="更改" >&emsp;&emsp;<input type="button" value="返回" onclick="displaynone('hiddenform2')">
	</form>
</div>

<div class="divtitle">
	<div class="titleleft">
		<div>
			<span class="titletext" >GameIndex</span>
		</div>
		<div class="divfind">
			<form class="find" action="mangerSelect" method="post" >
				<input type="hidden" value="<%=user.getName() %>" name="username" >
				<input type="hidden" value="manger" name="main">
				<input class="findtext" type="text" placeholder="搜索.." name="select" >
				<input class="findimage" type="image"  src="picture/放大镜3.png">
			</form>
		</div>
		<div>
			<input class="nonebuttonsubmit" type="button" value="添加新游戏" onclick="display('hiddenform')">
		</div>
	</div>
</div>
	

<div class="main">
	<table>
		<tr>
		<td>游戏名</td>
		<td>上架日期</td>
		<td>图片</td>
		<td>简介</td>
		<td></td>
		<td style="text-align:center;">操作</td>
		</tr>
		<% while(iter.hasNext()){
		game game =iter.next();	%>
		<tr>
		<td><span><%=game.getName() %></span></td>
		<td><span><%=game.getDate() %></span></td>
		<td><span><%=game.getImage() %></span></td>
		<td><span><%=game.getIntro() %></span></td>
		<td></td>
		<td style="text-align:center;">
		<a href="/GameIndex/mangerDelet?gamename=<%=game.getName()%>&gamedate=<%=game.getDate()%>&username=<%=user.getName() %>">删除</a>&emsp;
		<a href="#" onclick="populateForm('<%=game.getName() %>','<%=game.getDate() %>','<%=game.getIntro() %>')">编辑</a>
		</td>
		</tr>
		<%}%>
	</table>
</div>
</body>
</html>