<%--@elvariable id="username" type="String"--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
</head>
<body>
<%
    response.setHeader("refresh", "6");
    String mes = "", del = "";
    String s = (String) session.getAttribute("username");
    if (s == null) {
        mes = "登录已过期";
//        session.invalidate();
        response.setHeader("refresh", "3;../");
    } else {
        mes = "有效登录马上过期！抓紧修改";
        del = "注销账户";
    }
%>
<%--<form action="../UserInformation">--%>
<h1>欢迎${username}来到您的个人中心！</h1>
<h4><%=mes%>
</h4>
<h4>
    <a href="../UserInformation"><%=del%>
    </a>
</h4>
<h4>
    <a href="updata.jsp">
        修改信息
    </a>
</h4>
<h4>
    <a href="../">回到主页</a>
</h4>
<%--</form>--%>
</body>
</html>