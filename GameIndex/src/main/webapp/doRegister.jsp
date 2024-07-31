<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>GameIndex.doRegister</title>
<style type="text/css">
</style>
<script type="text/javascript">
    function redirectPage(isRepeat) {
        if (isRepeat === "true") {
            document.body.innerHTML = "账号名重复，请重新输入";
            setTimeout(function() {
                window.location.href = "register.jsp";
            }, 3000);
        } else {
            document.body.innerHTML = "注册成功，即将返回登录页面";
            setTimeout(function() {
                window.location.href = "Index.jsp";
            }, 3000);
        }
    }
    window.onload = function() {
        var isRepeat = "<%= request.getAttribute("isRepeat") %>";
        redirectPage(isRepeat);
    };
</script>
</head>
<body>
</body>
</html>