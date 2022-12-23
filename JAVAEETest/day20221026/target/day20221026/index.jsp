<%--
  Created by IntelliJ IDEA.
  User: 19137
  Date: 2022/10/31
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String s = request.getContextPath();%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<form method="get" action="<%= s%>/login-session">
    <input type="text" name="userName" value="zs" /> <br />
    <input type="password" name="password" value="123" />
    <input type="submit" value="提交" />
</form>
<h3></h3>
<script>
    window.onload = function () {
        let str = window.decodeURIComponent(window.location.href);
        document.querySelector("h3").innerHTML = str.split("=")[1];
    }
</script>
</body>
</html>
