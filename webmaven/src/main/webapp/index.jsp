<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>


<form action="">
    <div name="box">
        <%
            request.setAttribute("select", "false");
            String s = (String) session.getAttribute("username");
            if (s == null) {
                s = "world";
        %>
        <h2>Hello <%=s%>!</h2>
        <a href="./html/login.html">登录</a>
        <br>
        <a href="./html/regist.html">注册</a>
        <h3>登录享受更多</h3>
        <%
        } else {
        %>
        <h2>Hello <%=s%>!</h2>
        <%--        <a href="./html/login.html">登录</a>--%>
        <%--        <br>--%>
        <%--        <a href="./html/regists.html">注册</a>--%>
        <%--        <br>--%>
        <a href="./html/UserInformation.jsp">我的账号中心</a>
        <br>
        <a href="./html/root&user.jsp">用户管理中心</a>
        <br>

    </div>
    <%}%>
</form>
</body>
</html>
