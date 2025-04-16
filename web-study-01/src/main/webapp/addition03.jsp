<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>더하기 기능</h1>
	${n1} + ${n2} = ${add}
	<br><br>
	<%=request.getAttribute("n1") %> + 
	<%=request.getAttribute("n2") %> =
	<%=request.getAttribute("add") %>
</body>
</html>