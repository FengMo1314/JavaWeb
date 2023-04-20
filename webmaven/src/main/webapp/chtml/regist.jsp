<%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/13
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="../cregist" method="post">
    <label>
        <input name="username" placeholder="请输入用户名" type="text">
    </label><br>
    <label>
        <input name="password" placeholder="请输入密码" type="password">
    </label><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
