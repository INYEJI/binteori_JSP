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
	//1. Cookie 객체 생성
	Cookie cookie = new Cookie("id", "pinksung");
	
	//2. 유효기간 설정
	cookie.setMaxAge(60*60*24*365); //1년
	
	//3. 클라이언트에 쿠키 전송
	response.addCookie(cookie);
	
	//4. 쿠키를 생성하여 클라이언트에 전송
	response.addCookie(new Cookie("pwd", "test1234"));
	response.addCookie(new Cookie("age", "20"));
%>

<h3> 쿠키 설정</h3>
</body>
</html>