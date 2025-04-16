<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	request.setCharacterEncoding("utf-8");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:mysql://localhost:3306/shopdb";
	String uid = "testuser";
	String pass = "1234";
	
	String sql = "insert into member values(?, ?, ?, ?, ?,?)";
	
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	int admin = Integer.parseInt(request.getParameter("admin"));
	
	
	try{
		//1. 드라이브 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. DB 연결
		conn = DriverManager.getConnection(url,uid, pass);
		//out.println(conn);
		
		//3. prepareStatement 객체 생성 -> sql문을 미리 컴파일해 놓고, 나중에 값만 변경해서 실행한다.
		pstmt = conn.prepareStatement(sql);
		
		//4. 값 바인딩 변수를 채운다
		pstmt.setString(1, name);
		pstmt.setString(2, userid);
		pstmt.setString(3, pwd);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setInt(6,  admin);
		
		//5. SQL구문 실행
		int result = pstmt.executeUpdate();
		//out.println("저장 성공(1), 실패(0) : " + result);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
%>
<h3>회원 가입 성공</h3>
<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>