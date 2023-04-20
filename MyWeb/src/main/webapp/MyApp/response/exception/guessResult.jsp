<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>猜数结果</h2>

<%
    //获取前端输入的数字
    int webNamb = (Integer) request.getSession().getAttribute("webNb");
    int index = (Integer) request.getSession().getAttribute("index");
    String rest = "";
    if (index == 1) {
        rest = "输入的数大了";
    } else if (index == -1) {
        rest = "输入的数小了";
    } else if (index == 0) {
        rest = "恭喜你猜对了";
    } else {
        rest = "垃圾编程——后台求救";
    }

%>
<h4>您输入的是<%=webNamb %>
</h4>
<%=rest%>
<div>
    <a href="guess.jsp">返回</a>
</div>
</body>
</html>