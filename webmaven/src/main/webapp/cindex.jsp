<%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/13
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="./css/cindex.css">
</head>
<body>
<script src="js/cindex.js"></script>
<div class="lefts">
    <h5 onclick="shuaxin()"><--</h5>
    <%
        String username = (String) session.getAttribute("username");
        if (username == null) {
            username = "光临";
    %>
    <h1>欢迎<%=username%>
    </h1>
    <h2>
        <a href="chtml/login.jsp">登录</a>
    </h2>
    <h2>
        <a href="chtml/regist.jsp">注册</a>
    </h2>
    <h2>
        <a href="SomBygoods_nameJSON">SomeGoods_info_JSON</a>
    </h2>
    <a href="tjson_user">goodsJSON</a>
    <h2>
        <a href="./chtml/goods.jsp">shopsJSP</a>
    </h2>
    <h2>
        <a href="./chtml/goods.html">shopsHTML</a>
    </h2>
    <h2>
        <a href="./html/Cookie.html">Cookie</a>
    </h2>
    <%} else {%>
    <h1>欢迎<%=username%>
    </h1>
    <h2>
        <a href="chtml/user.jsp">用户中心</a>
    </h2>
    <h2>
        <a href="chtml/root.jsp">管理用户中心</a>
    </h2>
    <h2>
        <a href="./clogout">退出登录</a>
    </h2>
    <h2>
        <a href="SomBygoods_nameJSON">SomeGoods_info_JSON</a>
    </h2>
    <a href="tjson_user">goodsJSON</a>
    <h2>
        <a href="./chtml/goods.jsp">shopsJSP</a>
    </h2>
    <h2>
        <a href="./chtml/goods.html">shopsHTML</a>
    </h2>
    <h2>
        <a href="./html/Cookie.html">Cookie</a>
    </h2>
    <%}%>
</div>

</body>
</html>
