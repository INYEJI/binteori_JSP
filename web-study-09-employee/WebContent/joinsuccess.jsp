<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정 성공</title>
</head>
<body>
	<table align="center" width="550">
		<tr>
			<td colspan="2" align="center">			 
				<h3>사원 정보</h3>
				<div>회원 등록에 성공했습니다.</div>
			</td>
		</tr>
		<tr>
			<td align="center">아이디</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td>${member.pwd}</td>
		</tr>
		<tr>
			<td align="center">이름</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td align="center">권한</td>
			<td>
				<c:if test="${member.lev == 'A'}">운영자</c:if>
				<c:if test="${member.lev == 'B'}">일반 회원</c:if>
			</td>
		</tr>
		<tr>
			<td align="center">성별</td>
			<td>
				<c:if test="${member.gender == '1'}">남자</c:if>
				<c:if test="${member.gender == '2'}">여자</c:if>
			</td>
		</tr>
		<tr>
			<td align="center">전화번호</td>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="메인 페이지로 이동" onclick="location.href='main.jsp'">
			</td>
		</tr>	
	</table>
</body>
</html>
