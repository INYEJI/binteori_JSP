<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int COUNT=0;
	%>
	
	<%
		int number = 90;
	
		if(number>=90){
	
		out.println("A1");			
		out.println("A2");			
		out.println("A3");			
	
		}else if(number>=80){
	%>
			<h1>B</h1>
	<% 
		}else{
	%>
			<h1>C</h1>
	<%
		}
	%>
	<%= number %>
</body>
</html>