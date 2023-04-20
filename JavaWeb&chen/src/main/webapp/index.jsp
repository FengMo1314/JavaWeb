<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,ip.GetLocalIp,java.util.Date"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="Shortcut Icon" href="imgs/index/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="css/index/index.css">
<title>Liu He's private service</title>
</head>
<body>

	<%
	String ip = GetLocalIp.getLocalIp(request);
	%>
	<div class="box">
	<form name=clock>
		<img alt="完了" src="imgs/index/index.png">
		<h1>
			欢迎<%=ip%>来此
		</h1>
		<h3>
			现在是<% %>
		</h3>
		<h3>柳和</h3>
		</form>
		<form action="">
			<table>
				<tr align="center" style="color: red">
					<td>编号</td>
					<td>内容</td>
					<td>时间</td>
				</tr>
				<tr align="center">
					<td>01</td>
					<td><a href="day01">day01</a></td>
					<td>2022-11-17</td>
				</tr>
				<tr align="center">
					<td>02</td>
					<td>
						<h5>
							<a href="day02">demo</a>
						</h5>
						<h5>
							<a href="day02-1">demo1</a>
						</h5>
						<h5>
							<a href="html/demo.html">demo2</a>
						</h5>
						<h5>
							<a href="day02-3">demo3</a>
						</h5>
						<h5>
							<a href="day02-4">demo4</a>
						</h5>
						<h5>
							<a href="day02-5">demo5</a>
						</h5>
						<h5>
							<a href="day02-6">demo6</a>
						</h5>
					</td>
					<td>2022-11-20</td>
				</tr>
				<tr align="center">
					<td>03</td>
					<td>
						<h5>
							<a href="html/day03.html">day03</a>
						</h5>
						<h5>
							<a href="html/login.html">day03-1</a>
						</h5>
						<h5>
							<a href="html/regist.html">day03-2</a>
						</h5>
					</td>
					<td>2022-11-24</td>
				</tr>
				<%--
			<tr align="center">
			<td>04</td>
			<td><a href="day04">day04</a></td>
			<td>2022-12-13</td>
			</tr>
			<tr align="center">
			<td>05</td>
			<td><a href="day05">day05</a></td>
			<td>2022-12-14</td>
			</tr>
			<tr align="center">
			<td>06</td>
			<td><a href="day06">day06</a></td>
			<td>2022-12-15</td>
			</tr>
			--%>
			</table>
		</form>
	</div>
</body>
</html>