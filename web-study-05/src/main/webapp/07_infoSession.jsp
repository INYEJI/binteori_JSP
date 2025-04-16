<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 정보를 얻어오는 메소드를 사용하기</h3>
	<%
		String id_str = session.getId();
		long lasttime = session.getLastAccessedTime();
		long createtime = session.getCreationTime();
		
		long time_used = (lasttime - createtime) / 60000;
		int inactive  = session.getMaxInactiveInterval() / 60;
		boolean b_new = session.isNew();		
	%>
	
	세션 id는 <%=session.getId() %><br>
	last : <%= lasttime %><br>
	create : <%= createtime %><br>
	머문 시간 <%= time_used %>분입니다. <br>
	세션 유효시간은 <%=inactive %>분 <br>
	세션이 새로 만들어져나요?<br>
	
	<%
		if(b_new)
			out.println("예!!새로운 세션");
		else
			out.println("아니요! 기존 세션");
	%>
	
</body>
</html>