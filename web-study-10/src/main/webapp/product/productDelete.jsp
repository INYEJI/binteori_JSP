<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 삭제 - 관리자 페이지</h1>
		
		<form id="deleteForm" action="productDelete.do" method="post">
			<table>
				<tr>
					<td>
						<c:if test="${empty product.pictureUrl }">
							<img src="upload/noimage.gif">
						</c:if>
						<c:if test="${product.pictureUrl }">
							<img src="upload/${product.pictureUrl }">
						</c:if>
					</td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상품명</th>
								<td>${product.name }</td>
							</tr>
							<tr>
								<th>가 격</th>
								<td>${product.price }원</td>
							</tr>
							<tr>
								<th>설 명</th>
								<td><div style="height: 220px; width:100%">${product.description }</div></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="code" value="${product.code }">
			<button type="button" onclick="confirmDelete()">삭제</button>
			<input type="button" value="목록" onclick="location.href='productList.do'">
		</form>
	</div>
	<script>
  function confirmDelete() {
    const confirmed = confirm("정말 삭제하시겠습니까?");
    if (confirmed) {
      document.getElementById("deleteForm").submit();
    } else {
      alert("삭제가 취소되었습니다.");
    }
  }
</script>
</body>
</html>
