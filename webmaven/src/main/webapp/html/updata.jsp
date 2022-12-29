<%@ page import="db.DBhelp" %>
<%@ page import="db.TableBean" %><%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/13
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<%
    DBhelp dbh = new DBhelp("../MySql.properties");
    String s = (String) session.getAttribute("username");
    TableBean tb = dbh.selectByUserName(s);
    session.setAttribute("id", tb.getId());
%>
<form action="../updata" method="post">
    <label>
        id:
        <input type="text" name="ids" value="<%=tb.getId()%>" disabled="disabled">
    </label>
    <label>
        uId:
        <input type="text" name="uid" value="<%=tb.getUid()%>">
    </label>
    <label>
        用户名:
        <input type="text" name="username" value="<%=tb.getUsername()%>">
    </label>
    <label>
        密码:
        <input type="password" name="pass" value="<%=tb.getPassword()%>">
    </label>
    <label>
        密码确认:
        <input type="password" name="pass2" value="<%=tb.getPassword()%>">
    </label>
    <label>
        email:
        <input type="email" name="email" value="<%=tb.getEmail()%>">
    </label>
    <label>
        birthday:
        <input type="date" name="birthday" value="<%=tb.getBirthday()%>">
    </label>
    <button>提交修改</button>
</form>

</body>
</html>
