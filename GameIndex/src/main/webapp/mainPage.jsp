<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="GameBack.user,GameBack.game,java.util.*" %>
<html>
<head>
<style>
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
	width:500;
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
.nonebuttonsubmit{
	color:white;
	border:none;
	background:none;
	padding:0;
}
.nonebuttonsubmit:hover {  
        text-decoration: underline;  
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
	margin:auto auto;
	width:70%;
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
</style>
<% user user=(user)request.getAttribute("user"); %>
<% List<game> games=(List<game>)request.getAttribute("games"); 
	Iterator<game> iter = games.iterator(); %>
</head>
<body>
<div class="divtitle">
	<div class="titleleft">
		<div>
		<span class="titletext" >GameIndex</span>
		</div>
		<div class="divfind">
		<form class="find" action="mangerSelect" method="post">
		<input type="hidden"  value="main" name="main">
		<input type="hidden" value="<%=user.getName()%>" name="username">
		<input class="findtext" name="select" type="text" placeholder="搜索.." >
		<input class="findimage" type="image"  src="picture/放大镜3.png">
		</form>
		</div>
	</div>
	<div class="titleright">
		<!-- 这里写title右边的用户页面 -->
		<% if(user.getIsManger().equals("true")){
			%>
			<form class="manger" action="manger" method="post" target="_blank">
			<input type="hidden" value="<%=user.getName()%>" name="username">
			<input class="nonebuttonsubmit 	titletext" type="submit" value="管理">
			</form>
			<%
			}%>
		<h1><%=user.getName()%></h1>
	</div>
</div>
<div class="main">
	<% while(iter.hasNext()){
	game game =iter.next();	%>
	<div class="game">
	<img class="gameimg" src="gameImg\\<%=game.getImage()%>">
	<form action="gameIndex" method="post" target="_blank">
	<input class="nonebuttonsubmit" type="submit" value="<%=game.getName() %>"><br>
	<span class="gametime"><%=game.getDate() %></span>
	<input type="hidden" value="<%=user.getName() %>" name="username">
	<input type="hidden" value="<%=game.getName() %>" name="gamename">
	<input type="hidden" value="<%=game.getDate() %>" name="gametime"></form>
	</div>						
	<%} %>
</div>
</body>
</html>