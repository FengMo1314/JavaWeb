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
    <title>用户信息修改</title>
</head>
<body>
<%
    String id = (String) session.getAttribute("id");
    if (id == null) {
        id = "重新登录";
        response.setHeader("refresh", "2;./login.jsp");
%>
<%=id%>
<%} else {%>
<form action="../cupdatabyuser" method="post">
    <label>
        id:
        <input type="text" name="id" value="${id}" disabled="disabled">
    </label>
    <div>
        <h3>
            <label>
                用户名:
                <input type="text" name="username" value="${username}">
            </label>
        </h3>
        <h4>
            <label>
                密码:
                <input type="password" name="password">
                <br>
                确认密码:
                <input type="password" name="password2">
            </label>
        </h4>
    </div>
    <button>确认修改</button>
</form>
<%}%>
</body>
</html>
