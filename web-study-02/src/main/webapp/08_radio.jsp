<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="RadioServlet">
		성별:
		<input type="radio" name="gender" value="남자" checked="checked">남자
		<input type="radio" name="gender" value="여자" >여자<br>
		
		메일정보수신여부 :
		<input type="radio" name="chk_mail" value="yes" checked>수신
		<input type="radio" name="chk_mail" value="no" >거부<br>
		
		가입 인사 : 
		<textarea rows="3" cols="35" name="content"></textarea><br>
		<input type=submit value= "전송">
	</form>
</body>
</html>