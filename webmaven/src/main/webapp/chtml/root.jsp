<%@ page import="cheng.db.UserDao" %>
<%@ page import="cheng.bean.TableBeanCheng" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<%@ page import="cheng.cuntil.AboutCookies" %><%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/13
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理用户信息</title>
</head>
<body>
<%
    AboutCookies cookies = new AboutCookies(request, response);
    String isLogin = cookies.getCookieForJSP("isLogin");
    out.print("<h1>" + isLogin + "</h1>");
    String username = (String) session.getAttribute("username");
    if ((username == null && isLogin != "true") || isLogin != "true" || username == null) {
        if (username == null) {
            out.print("<h1>与服务器会话失败请登录<h1>");
            response.setHeader("refresh", "2;login.jsp");
        } else {
            out.print("<h1>本地没有登录信息——cookie不符合</h1>");
            response.setHeader("refresh", "2;login.jsp");
        }
%>
<h3>请登录
    <a href="./login.jsp">登录</a>
</h3>
<h3>
    <a href="../cindex.jsp">返回课堂首页</a>
</h3>
<h3>
    <a href="../JSONindex.html">返回商品首页</a>
</h3>
<%
} else {
    String path;
    if (request.getAttribute("select") == null) {
        path = "../crootanduser";
    } else {
        path = "./cselect";
    }
%>
<div>
    <form action="<%=path%>" method="post">
        <label for="text">
            <input name="text" type="text" id="text">
            <button name="button" value="1">查询</button>
        </label>
        <button name="button" value="2">修改</button>
        <button name="button" value="3">删除</button>
        <table>
            <colgroup>
                <col span="1" style="background-color:olivedrab">
                <col span="5" style="background-color:yellow">
            </colgroup>
            <tr>
                <th>\</th>
                <th>用户id</th>
                <th>用户名</th>
                <th>密码</th>
                <%--                <th>修改</th>--%>
            </tr>
            <%
                if (request.getAttribute("select") == null) {
                    UserDao ud = new UserDao();
                    List<TableBeanCheng> tbc = ud.selectAllTableMesgs();
                    for (TableBeanCheng user : tbc) {
            %>
            <tr>
                <td>
                    <label for="<%=user.getId()%>"><input type="checkbox" id="<%=user.getId()%>" name="userid" value="
            <%=user.getId()%>"></label>
                </td>
                <td><%=user.getId()%>
                </td>
                <td><%=user.getUsername()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <%--                <td>--%>
                <%--                    <button name="button" value="3">删除</button>--%>
                <%--                </td>--%>
            </tr>
            <%
                }
            } else {

                List<TableBeanCheng> tbc = (List<TableBeanCheng>) request.getAttribute("somList");
                for (TableBeanCheng user : tbc) {
            %>
            <tr>
                <td>
                    <label for="<%=user.getId()%>"><input type="checkbox" id="<%=user.getId()%>" name="userid" value="
            <%=user.getId()%>"></label>
                </td>
                <td><%=user.getId()%>
                </td>
                <td><%=user.getUsername()%>
                </td>
                <td>
                    <%=user.getPassword()%>
                </td>

            </tr>
            <%
                    }
                }
            %>
        </table>
    </form>
</div>
<%}%>
</body>
</html>
