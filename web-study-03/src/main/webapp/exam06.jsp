<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<%
		for(int i=0; i<3; i++){  //for시작
	%>
		<tr>
			<td>Num</td>
			<td><%=i+1 %></td>
		</tr>	
	<%		
		}  //for 끝
	%>
	</table>
</body>
</html>