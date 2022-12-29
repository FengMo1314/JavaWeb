<%@ page import="db.TableBean" %>
<%@ page import="db.DBhelp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/8
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
</head>
<body>
<%
    response.setHeader("refresh", "5.3");
    String s = (String) session.getAttribute("username");
    if (s == null) {
        out.println("你登录了吗？");
%>
<p>如果已经登录过了——是登录过期了哎!</p>
<h3>
    <a href="./login.html">登录</a>
</h3>
<%
} else {
    Date date = new Date();
    out.println(s + "操作数据库ing" + date);
%>
<div>
    <form action="../rootdel" method="post">
        <%
            DBhelp dbh = new DBhelp("../MySql.properties");
            List<TableBean> users = dbh.selectAllBymyuser();
        %>
        <label for="text">
            <input name="text" type="text" id="text">
            <button name="button" value="1">添加</button>
        </label>
        <button name="button" value="2">修改</button>
        <button name="button" value="3">删除</button>
        <%--        <button name="button" value="4">拉黑</button>--%>
        <table>

            <colgroup>
                <col span="1" style="background-color:olivedrab">
                <col span="5" style="background-color:yellow">
            </colgroup>
            <tr>
                <th>\</th>
                <th>用户id</th>
                <th>用户名</th>
                <th>用户邮箱</th>
                <th>用户生日</th>
            </tr>
            <%for (TableBean user : users) { %>
            <tr>
                <td>
                    <label for="<%=user.getId()%>"><input type="checkbox" id="<%=user.getId()%>" name="usermesg" value="
            <%=user.getId()%>"></label>
                </td>
                <td><%=user.getId()%>
                </td>
                <td><%=user.getUsername()%>
                </td>
                <td><%=user.getEmail()%>
                </td>
                <td>
                    <%=user.getBirthday()%>
                </td>
            </tr>
            <%}%>
        </table>
    </form>
</div>
<%}%>
</body>
</html>
