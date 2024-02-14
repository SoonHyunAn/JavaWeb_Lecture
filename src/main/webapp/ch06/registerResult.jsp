<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
<style>
td {
	padding: 5px;
}
</style>
</head>
<body style="margin: 50px">
	<h1>회원 가입 결과</h1>
	<hr>
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
			<td>이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>등록일자</td>
			<td>${user.regDate}</td>
		</tr>
		<tr>
			<td>삭제 여부</td>
			<td>${user.isDeleted}</td>
		</tr>
	</table>
	<button onclick="location.href='/jw/ch06/register'">재실행</button>
</body>
</html>