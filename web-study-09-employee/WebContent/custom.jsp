<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
<style>
	table {
		margin: auto;
		width: 550px;
		border-collapse: collapse;
	}
	td {
		padding: 8px;
		text-align: left;
	}
	tr.title-row td {
		text-align: center;
		font-weight: bold;
		font-size: 18px;
	}
	tr.button-row td {
		text-align: center;
	}
</style>
</head>
<body>
<form action="custom.do" method="post">
	<table>
		<tr class="title-row">
			<td colspan="2">사원등록</td>
		</tr>
		<tr>
			<td><label for="id">아이디</label></td>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<td><label for="pwd">비밀번호</label></td>
			<td><input type="password" name="pwd" id="pwd"></td>
		</tr>
		<tr>
			<td><label for="name">이름</label></td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<select name="lev">
					<option value="A">운영자</option>
					<option value="B">일반회원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<select name="gender">
					<option value="1">남자</option>
					<option value="2">여자</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><label for="phone">전화번호</label></td>
			<td><input type="text" name="phone" id="phone"></td>
		</tr>
		<tr class="button-row">
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
				<input type="button" value="메인 페이지로 이동" onclick="location.href='main.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
