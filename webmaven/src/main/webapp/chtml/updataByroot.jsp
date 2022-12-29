<%@ page import="java.util.List" %>
<%@ page import="cheng.bean.UpdataBeanCheng" %>
<%@ page import="cheng.bean.TableBeanCheng" %>
<%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/15
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>用户管理修改中心</title>
</head>
<body>

<form action="./cupdatabyroot" method="post">
    <div>
        <table>
            <colgroup>
                <col span="1" style="background-color:olivedrab">
                <col span="5" style="background-color:yellow">
            </colgroup>
            <tr>
                <th>用户id</th>
                <th>用户名</th>
                <th>密码</th>
                <%--                <th>修改</th>--%>
            </tr>
            <%
                List<TableBeanCheng> tbclist = (List<TableBeanCheng>) request.getAttribute("tableList");
                session.setAttribute("TableBeanCheng", tbclist);
                for (TableBeanCheng tbc : tbclist) {
            %>
            <tr>
                <td>
                    <label>
                        <input type="text" name="uid" value="<%=tbc.getId()%>" disabled="disabled">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="username" value="<%=tbc.getUsername()%>">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="password" name="password" value="<%=tbc.getPassword()%>">
                    </label>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
    <button>确认修改</button>
</form>
</body>
</html>
