<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="GameBack.user,GameBack.game,java.util.*,GameBack.liuyan" %>
<html>
<head>
<meta charset="UTF-8">
<title>GameIndex.gameindex</title>
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
.main{
	display:flex;
	margin-top:30px;
}
.liuyan{
	width:500px;
}
.gametext{
color:white;
}
span.liuyan{
color:white;
font-size:12px;
}
span.liuyantext{
color:white;
	font-size:16px;
}
</style>
<% user user=(user)request.getAttribute("user"); %>
<% game game=(game)request.getAttribute("game"); %>
<% List<liuyan> liuyans=(List<liuyan>)request.getAttribute("liuyans"); 
	Iterator<liuyan> iter=liuyans.iterator(); %>
</head>
<body>
<div class="divtitle">
	<div class="titleleft">
		<div>
		<span class="titletext" >GameIndex</span>
		</div>
	</div>
	<div class="titleright">
		<!-- 这里写title右边的用户页面 -->
		<h1><%=user.getName()%></h1>
	</div>
</div>

<div class="main">
	<div>
	<img src="gameImg\\<%=game.getImage() %>" >
	</div>
	<div>
	<span class="gametext">游戏名：<%=game.getName() %></span><br>
	<span class="gametext">日期：<%=game.getDate() %></span><br>
	<span class="gametext">游戏简介与类型：<%=game.getIntro() %></span><br>
	</div>
</div>
<div>
	<div class="liuyan">
	<h1 style="color:white">评论区</h1>
	<hr>
	<% while(iter.hasNext()){
	liuyan liuyan =iter.next();%>
	<br>
	<span class="liuyan">留言人：<%=liuyan.getLiuyanRen() %>。<%=liuyan.getLiuyantime() %>留：</span><br>
	<span class="liuyantext"><%=liuyan.getLiuyan() %></span><br><br>
	<%} %>
	</div>
	<div>
	<br><br>
	<hr>
	<br>
	<form action="send" method="post" >
	<textarea name="liuyan" >输入文字</textarea>
	<input type="hidden" value="<%=user.getName() %>"  name="username">
	<input type="hidden" value="<%=game.getDate() %>"  name="date">
	<input type="hidden" value="<%=game.getName() %>"  name="gamename">
	<input type="submit" class="nonebuttonsubmit" value="发送">
	</form>
	</div>
</div>

</body>
</html>