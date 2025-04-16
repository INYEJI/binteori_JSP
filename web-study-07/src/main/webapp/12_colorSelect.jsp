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
		int id = Integer.parseInt(request.getParameter("color"));
	
		switch(id){
		case 1:
	%>
			<span style="color:red;">빨강</span>
	<%
			break;
		case 2:
	%>
			<span style="color:green;">초록</span>
	<%
			break;
		case 3:
	%>
			<span style="color:blue;">파랑</span>
	<%
			break;
		default:
			
			break;
		}
	%>
</body>
</html>