<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="CallServlet" method="get">
		<input type="text" name="id" value="test">
		<input type="text" name="pw" value="1234">
		<input type="submit" value="get전송">
	</form>
	<br><br>
	
	<form action="CallServlet" method="post">
		<input type="text" name="id" value="test">
		<input type="text" name="pw" value="1234">
		<input type="submit" value="post전송">
	</form>
</body>
</html>