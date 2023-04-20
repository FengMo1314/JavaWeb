<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在此处插入标题</title>
</head>
<body>
<p>
    Soft
    <% String banji = request.getParameter("soft");%>
    <%=banji%>的
    <%String name = request.getParameter("name"); %>
    <%=name %>
</p>
<p>
    您的得分为：
        <%
        String t1=request.getParameter("t1");
        String t2=request.getParameter("t2");
         int sum=0;
		if(t1.equals("request对象")) {
			sum++;
		}
		if(t2.equals("update语句")){
			sum++;
		}
%>
        <%=sum+"分"%>
</body>
</html>