<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19137
  Date: 2022/12/1
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>admin修改页</title>
</head>
<body>
admin修改页
<%--展示数据--%>
<form method="post" action="http://localhost:8080/myBatisGenerator_war/admin/update">
    <input readonly="readonly" type="text" name="id" value="${requestScope.admin.id}" placeholder="用户名">
    <input type="text" name="adminname" value="${requestScope.admin.adminname}" placeholder="用户名">
    <input type="text" name="password" value="${requestScope.admin.password}" placeholder="密码">
    <input type="submit" value="修改">
</form>
</body>
</html>
