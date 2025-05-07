<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<form action="mypage.do" method="post" name="frm">
	<table align="center" width="550px">
		<tr>
			<td colspan="2" align="center"><strong>마이페이지</strong></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${loginUser.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${loginUser.name}"></td>
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<select name="lev">
					<option value="A" <c:if test="${result == 0}">selected</c:if>>운영자</option>
					<option value="B" <c:if test="${result == 1}">selected</c:if>>일반회원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<select name="gender">
					<option value="1" <c:if test="${loginUser.gender == 1}">selected</c:if>>남자</option>
					<option value="2" <c:if test="${loginUser.gender == 2}">selected</c:if>>여자</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="${loginUser.phone}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
