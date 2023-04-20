<%@ page import="cheng.db.Goods_info_Dao" %>
<%@ page import="cheng.bean.Goods_info_Bean" %>
<%@ page import="cheng.cuntil.AboutCookies" %><%--
  Created by IntelliJ IDEA.
  User: LiuHe
  Date: 2022/12/16
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    AboutCookies cookies = new AboutCookies(request, response);
    String isLogin = cookies.getCookieForJSP("isLogin");
    out.print("<h1>" + isLogin + "</h1>");
    if ((username == null && isLogin != "true") || isLogin != "true" || username == null) {
        if (username == null) {
            out.print("<h1>与服务器会话失败请登录<h1>");
            response.setHeader("refresh", "2;login.jsp");
        } else {
            out.print("<h1>本地没有登录信息——cookie不符合</h1>");
            response.setHeader("refresh", "2;login.jsp");
        }
    } else {
%>
<form action="goods.jsp" method="post">
    <input type="text" name="namee">产品名
    <button>搜索</button>
</form>
<% response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("utf-8");
    String s = request.getParameter("namee");
    out.println(s);
    for (Goods_info_Bean gb :
            Goods_info_Dao.selectSomeByGoods_Name(s)) {%>
<h2><%=gb.getGoods_id()%>
</h2>
<h3><%=gb.getGoods_name()%>
</h3>
<img src="http://localhost:8080/lh.com/static<%=gb.getGoods_cover_img()%>">
<%
        }
    }
%>
</body>
</html>
