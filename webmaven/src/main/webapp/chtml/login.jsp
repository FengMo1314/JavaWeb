<%@ page import="java.net.URLDecoder" %>
<%@ page import="cheng.cuntil.AboutCookies" %><%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/13
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    AboutCookies cookies=new AboutCookies(request,response);
    String username=cookies.getCookieForJSP("username");
%>
<form action="../clogin" method="post">
    <label>
        <input name="username" placeholder="请输入用户名" type="text" value="<%=username%>">
    </label><br>
    <label>
        <input name="password" placeholder="请输入密码" type="password">
    </label><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
