<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>개인 정보 수정 성공</title>
<style>
  table {
    margin: auto;
    width: 550px;
    border-collapse: collapse;
  }
  td {
    padding: 8px;
    text-align: center;
  }
  .title {
    font-size: 18px;
    font-weight: bold;
  }
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2">
				<h3 class="title">사원 정보</h3>
				<div>회원 정보가 수정되었습니다.</div>
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${member.pass}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<c:if test="${member.lev == 'A'}">운영자</c:if>
				<c:if test="${member.lev == 'B'}">일반 회원</c:if>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<c:if test="${member.gender == '1'}">남자</c:if>
				<c:if test="${member.gender == '2'}">여자</c:if>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="메인 페이지로 이동" onclick="location.href='main.jsp'">
			</td>
		</tr>	
	</table>
</body>
</html>
