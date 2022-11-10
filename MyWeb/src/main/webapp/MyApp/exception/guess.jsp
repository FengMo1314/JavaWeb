<%@page import="java.util.Random"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>猜数字游戏</title>
</head>
<body>
<h1>请输入数字</h1>
<form action="${pageContext.request.contextPath}/guessControl" method="get">
<input type="text" name="guess">
<input type="submit" value="提交">
</form>
<%
Random r=new Random();
int nub=r.nextInt(10);
session.setAttribute("nub",nub);
%>
</body>
</html>