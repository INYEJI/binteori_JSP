<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션에 설정된 모든 값 얻어오기</h3>
	
	<%
		Enumeration names  = session.getAttributeNames();
		
		while(names.hasMoreElements()){
			 String key = names.nextElement().toString();
			 String value = session.getAttribute(key).toString();
			 out.println(key + " : " + value + "<br>");
		}
	%>
</body>
</html>