<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = "홍길동";
	
	/*
		실제로는 입력받은 id, pwd를 DB에서 조회해서 로그인 성공 여부를 판단해야 함!!
		지금은 임시로 .......
	*/
	if(id.equals("user01") && pwd.equals("1234")){
		session.setAttribute("loginUser", name);
		response.sendRedirect("10_main.jsp"); //로그인 성공시 이동 경로
	}else{
		response.sendRedirect("10_loginForm.jsp"); //로그인 실패시 이동 경로
	}

	
%>