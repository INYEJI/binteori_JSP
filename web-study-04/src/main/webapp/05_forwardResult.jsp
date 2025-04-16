<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	Object name = request.getAttribute("name");	
%>

이름은 <%= name %>이고, 나이는 <%=age %> 입니다.

</body>
</html>