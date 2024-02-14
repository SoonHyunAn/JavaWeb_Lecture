<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alert Message</title>
</head>
<body style="margin: 50px">
</body>
<script>
	let meg = '${user.message}';
	let url = '${url}';
	alert(meg);
	location.href = url;
</script>
</html>