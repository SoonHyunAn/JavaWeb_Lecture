<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int c = 9;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>City List</title>
</head>
<body>
	<%	if (c % 2 == 0) {%>
			짝수입니다.
	<%	} else {	%>
			홀수입니다.
	<%	}	%>
</body>
</html>