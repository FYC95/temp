<%--
  Created by IntelliJ IDEA.
  User: 19137
  Date: 2022/12/1
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功管理界面</title>
    欢迎:<%=session.getAttribute("uname")%>
</head>
<body>
<a href="http://localhost:8080/myBatisGenerator_war/a.jsp">登出</a>
</body>
</html>
