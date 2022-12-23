<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/30
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
123
<form method="post" action="http://localhost:8080/myBatisGenerator_war/hello/h2">
    <input type="submit" value="提交">
</form>
<a href="http://localhost:8080/myBatisGenerator_war/hello/h5?uname=zs&age=18&salary=3000.5&hobby=playGame&hobby=playGuitar&hobby=playTennis">链接法参数传递</a>
<form method="get" action="http://localhost:8080/myBatisGenerator_war/hello/h5">
    uname:<input type="text" name="uname">
    age:<input type="number" name="age">
    salary:<input type="text" name="salary">
    <label>
        <input type="checkbox" name="hobby" value="playGame" />玩游戏
        <input type="checkbox" name="hobby" value="playGuitar" />玩吉他
        <input type="checkbox" name="hobby" value="playTennis" />玩网球
    </label>
    <input type="submit" value="提交">
</form>
<a href="http://localhost:8080/myBatisGenerator_war/hello/h6?username=zs&age=18&salary=3000.5&hobby=playGame&hobby=playGuitar&hobby=playTennis">实体类参数传递</a>
<form method="get" action="http://localhost:8080/myBatisGenerator_war/hello/h6">
    uname:<input type="text" name="uname">
    age:<input type="number" name="age">
    salary:<input type="text" name="salary">
    <label>
        <input type="checkbox" name="hobby" value="playGame" />玩游戏
        <input type="checkbox" name="hobby" value="playGuitar" />玩吉他
        <input type="checkbox" name="hobby" value="playTennis" />玩网球
    </label>
    <input type="submit" value="提交">
</form>
<form method="get" action="http://localhost:8080/myBatisGenerator_war/hello/h7">
    adminname:<input type="text" name="adminname">
    password:<input type="text" name="password">
    info.phone:<input type="text" name="info.phone">
    info.gender:<input type="text" name="info.gender">
    <input type="submit" value="提交实体类传递">
</form>
<form method="get" action="http://localhost:8080/myBatisGenerator_war/admin/index">
    <input type="text" name="adminname">
    <input type="text" name="password">
    <input type="submit" value="提交登录验证">
</form>


<%--restful风格--%>
<p>------------------restful风格------------------</p>
<a href="http://localhost:8080/myBatisGenerator_war/adminrest/opt/1">REST查</a>

<form method="post" action="http://localhost:8080/myBatisGenerator_war/adminrest/opt">
    <input type="text" name="adminname">
    <input type="text" name="password">
    <input type="submit" value="验证REST增加">
</form>
<form method="post" action="http://localhost:8080/myBatisGenerator_war/adminrest/opt/5">
    <input type="hidden" name="_method" value="DELETE" />
    <input type="submit" value="验证REST删除">
</form>
<form method="post" action="http://localhost:8080/myBatisGenerator_war/adminrest/opt/3">
<%--  将method="post"变换为PUT方法进行修改操作  --%>
    <input type="hidden" name="_method" value="PUT" />
    <input type="text" name="adminname">
    <input type="text" name="password">
    <input type="submit" value="验证REST修改">
</form>

<form method="post" action="http://localhost:8080/myBatisGenerator_war/upload/uploads" enctype="multipart/form-data">
    <input type="file" name="upfiles" />
    <input type="file" name="upfiles" />
    <input type="file" name="upfiles" />
    <input type="submit" value="上传多个文件">
</form>











</body>
</html>
