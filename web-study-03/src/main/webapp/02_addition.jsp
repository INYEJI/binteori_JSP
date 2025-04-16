<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<h3>Hello JAVA</h3>
	<%
		int num1 = 20;
		int num2 = 10;
		
		int add = num1 + num2;
		
		out.print(num1 + " + " + num2 + " = " + add);
		
		
	%>
</body>
</html>