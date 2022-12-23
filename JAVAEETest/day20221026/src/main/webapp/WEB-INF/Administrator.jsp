<%--
  Created by IntelliJ IDEA.
  User: 19137
  Date: 2022/10/31
  Time: 9:17
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
<%
    request.getSession();
    HttpSession httpSession = request.getSession();
    Boolean flag = (Boolean) httpSession.getAttribute("sta");
    if (flag){
%>
    管理员可见,用户名:<%=httpSession.getAttribute("name")%>
    <a href="<%= s%>/logout-session" target="_self">退出登录</a>
<%
    }else {
%>
    <a href="<%= s%>/index.jsp" target="_self">返回登录</a>
<%}%>
</body>
</html>
