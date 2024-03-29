<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
<style>
th {
	padding: 3px;
	text-align: center;
}

td {
	padding: 3px;
}
</style>
</head>
<body>
	<h1>
		사용자 목록
		<button style="margin-left: 100px"
			onclick="location.href='/jw/ch09/user/register'">회원가입</button>
		<span style="font-size: 16px"> 
			<c:if test="${empty sessUid}">
				<a style="margin-left: 100px" href="/jw/ch09/user/login">로그인</a>
			</c:if> 
			<c:if test="${not empty sessUid}">
				<a style="margin-left: 100px" href="/jw/ch09/user/logout">로그아웃</a>
				<span style="margin-left: 30px"> ${sessUname}님 환영합니다.</span>
			</c:if>
		</span>
	</h1>
	<hr>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>등록일</th>
			<th>액션</th>
			<c:forEach var="user" items="${list}">
				<tr>
					<td>${user.uid}</td>
					<td>${user.uname}</td>
					<td>${user.email}</td>
					<td>${user.regDate}</td>
					<!-- 본인만 수정가능하고, 관리자와 본인이 삭제 가능. 서로 드모르간법칙으로 반대 설정 -->
					<td>
						<c:if test="${user.uid eq sessUid}">
							<a href="/jw/ch09/user/update?uid=${user.uid}">수정</a>
						</c:if> 
						<c:if test="${user.uid ne sessUid}">
							<a href="#" disabled>수정</a>
						</c:if> 
						<c:if test="${user.uid eq sessUid or sessUid eq 'admin'}">
							<a href="/jw/ch09/user/delete?uid=${user.uid}">삭제</a>
						</c:if> 
						<c:if test="${user.uid ne sessUid and sessUid ne 'admin'}">
							<a href="#" disabled>삭제</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>