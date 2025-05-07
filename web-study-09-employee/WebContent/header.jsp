<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
  td {
    border: 1px solid black;
    width: 200px;
    text-align: center;
    height: 50px;
  }
  table.header td:hover {
    background-color: yellow;
    cursor: pointer;
  }
</style>

<table class="header" align="center">
  <tr>
    <!-- 사용자 이름 또는 빈칸 -->
    <td>
      <c:choose>
        <c:when test="${not empty loginUser}">
          ${loginUser.name}님
        </c:when>
        <c:otherwise>&nbsp;</c:otherwise>
      </c:choose>
    </td>

    <!-- 사용자 권한 또는 빈칸 -->
    <td>
      <c:choose>
        <c:when test="${not empty loginUser}">
          레벨 : ${loginUser.lev}
        </c:when>
        <c:otherwise>&nbsp;</c:otherwise>
      </c:choose>
    </td>

    <!-- 로그인 또는 로그아웃 버튼 -->
    <td onclick="location.href='<c:choose><c:when test="${not empty loginUser}">logout.do</c:when><c:otherwise>login.do</c:otherwise></c:choose>'">
      <c:choose>
        <c:when test="${not empty loginUser}">로그아웃</c:when>
        <c:otherwise>로그인</c:otherwise>
      </c:choose>
    </td>

    <!-- 사원 등록: 관리자만 가능 -->
    <td>
      <c:choose>
        <c:when test="${result == 0}">
          <span onclick="location.href='custom.jsp'">사원 등록</span>
        </c:when>
        <c:otherwise>
          사원 등록<br>(관리자로 로그인 후 사용 가능)
        </c:otherwise>
      </c:choose>
    </td>

    <!-- 마이페이지: 로그인 사용자만 가능 -->
    <td>
      <c:choose>
        <c:when test="${not empty loginUser}">
          <span onclick="location.href='mypage.jsp'">마이페이지</span>
        </c:when>
        <c:otherwise>
          마이페이지<br>(로그인 후 사용 가능)
        </c:otherwise>
      </c:choose>
    </td>
  </tr>
</table>
