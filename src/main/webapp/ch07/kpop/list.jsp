<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Girl Group List</title>
<style>
th, td {
	padding: 3px;
}
</style>
</head>
<body style="margin: 50px;">
	<h1>
		걸그룹 목록
		<button onclick="location.href='/jw/ch07/kpop/insertArtist'"
			style="margin-left: 100px">가수 추가</button>
			<button onclick="location.href='/jw/ch07/kpop/insertSong'"
			style="margin-left: 100px">노래 추가</button>
	</h1>

	<hr>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>데뷔일자</th>
			<th>액션</th>
			<th>제목</th>
			<th>가사</th>
			<th>액션</th>
		</tr>
		<c:forEach var="kpop" items="${list}">
			<tr>
				<td>${kpop.aid}</td>
				<td>${kpop.name}</td>
				<td>${kpop.debut}</td>
				<td><a href="/jw/ch07/kpop/updateArtist?id=${kpop.aid}">수정</a> 
				<a href="/jw/ch07/kpop/deleteArtist?id=${kpop.aid}">삭제</a></td>
				<td>${kpop.title}</td>
				<td>${kpop.lyrics}</td>
				<td><a href="/jw/ch07/kpop/updateSong?id=${kpop.sid}">수정</a> <a
					href="/jw/ch07/kpop/deleteSong?id=${kpop.sid}">삭제</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>

