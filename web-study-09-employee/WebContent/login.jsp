<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<title>로그인 화면</title>
<style>
 td {
 	border: 1px solid black;
 	width: 200px;
 	text-align: center;
 }
</style>
</head>
<body>
<form action="login.do" method="post">
	<table align="center">
		<tr>
			<td colspan="2" align="center"><strong>로그인</strong></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>레벨</td>
			<td>
				<select name="lev">
					<option value="A">운영자</option>
					<option value="B">일반회원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</td>
		</tr>			
	</table>
</form>
</body>
</html>
