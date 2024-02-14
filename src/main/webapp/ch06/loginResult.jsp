<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body style="margin: 50px">
	<h1>로그인 결과</h1>
	<br>
	<table style="text-align: center;" border="1">
		<tr>
			<td>아이디</td>
			<td>${user.uid}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${user.pwd}</td>
		</tr>
		<tr>
			<td>메시지</td>
			<td>${user.message}</td>
		</tr>
	</table>
	<button onclick="location.href='/jw/ch06/login'">재실행</button>
</body>
</html>