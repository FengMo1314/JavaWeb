<%@ page import="cheng.cuntil.AboutCookies" %><%--@elvariable id="username" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/13
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户个人中心</title>
</head>
<body>
<%
    AboutCookies cookies = new AboutCookies(request, response);
    String isLogin = cookies.getCookieForJSP("isLogin");
    out.print("<h1>" + isLogin + "</h1>");
    if (!isLogin.equals("true")) {
%>
<h1>未登录</h1>
<h3>
    <a href="./login.jsp">登录jsp</a>
</h3>
<h3>
    <a href="./login.html">登录html</a>
</h3>
<h3>
    <a href="../cindex.jsp">返回课堂首页jsp</a>
</h3>

<h3>
    <a href="../JSONindex.html">返回商品首页</a>
</h3>
<%} else {%>
<div>
    <h1>欢迎${username}来到您的个人中心</h1>
    <h3>
        <a href="./updataByuser.jsp">修改我的信息</a>
    </h3>
    <h3>
        <a href="/clogout">注销账户</a>
    </h3>
</div>
<%}%>
</body>
</html>
