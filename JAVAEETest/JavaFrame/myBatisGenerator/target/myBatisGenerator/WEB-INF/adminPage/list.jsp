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
    <title>admin列表页</title>
</head>
<body>
admin列表页
<%--展示数据--%>
<a href="http://localhost:8080/myBatisGenerator_war/admin/addF">添加一个管理员</a>
<table border="1">
    <thead>
    <tr>
        <th>序号</th>
        <th>id</th>
        <th>姓名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%--循环产生,JSTL标签库,默认访问4个作用域(scope)page、request、session、context--%>
    <c:forEach items="${requestScope.adminList}" var="admin" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${admin.id}</td>
        <td>${admin.adminname}</td>
        <td>
            <a href="http://localhost:8080/myBatisGenerator_war/admin/upd?no=${status.count}">修改</a>
            <a href="http://localhost:8080/myBatisGenerator_war/admin/del?no=${status.count}">删除</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
