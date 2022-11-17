<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    String address = request.getParameter("where");
    /* 非空判断 */
    if (address != null) {
        if (address.equals("ccit")) {
            response.sendRedirect("http://www.ccit.js.cn");
        } else if (address.equals("xinlang")) {
            response.sendRedirect("https://www.sina.com.cn");
        } else if (address.equals("souhu")) {
            response.sendRedirect("https://www.sohu.com");
        }
    }
%>
</body>
</html>