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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<%
    AboutCookies cookies = new AboutCookies(request, response);
    String username = cookies.getCookieForJSP("username");
%>
<%--<%=cookies;%>--%>
<form action="../cloginjsp" method="post" id="from">
    <label>
        <input name="username" placeholder="请输入用户名" type="text" value="<%=username%>">
    </label><br>
    <label>
        <input name="password" placeholder="请输入密码" type="password">
    </label><br>
    <input type="text" name="istrue" id="istrue">
    <img src="#" id="code"><a onclick="fresh()">看不清</a>
    <h3 class="h1"></h3>
    <input type="submit" value="验证提交" id="but">
    <%--    <input type="submit">--%>
</form>
<script src="../js/jquery.min.js"></script>
<script>
    fresh();

    function fresh() {
        <%--a = '<%=session.getAttribute("scode")%>';--%>
        var time = new Date();
        document.getElementById("code").src = "../yanzheng?" + time;
    }
</script>
</body>
</html>
