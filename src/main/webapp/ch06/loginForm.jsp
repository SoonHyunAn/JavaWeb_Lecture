<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body style="margin: 50px">
	<h1>로그인</h1>
	<form action="/jw/ch06/login" method="POST">
		<input type="text" name="uid" placeholder="아이디"> <br> <br>
		<input type="password" name="pwd" placeholder="패스워드"> <br>
		<br> <input type="submit" value="로그인"><br>
		<br>
	</form>
</body>
</html>