<%@page import="springBoard.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Users user = (Users)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홈</title>
	<link rel="stylesheet" href="<c:url value='/static/css/common/home.css' />" />
</head>
<body>
	<div class="wrap">
		<h1>어서오세요. <%=user.getName() %>님</h1>
		<ul>
			<li><a href="<c:url value='/customer/notice/list'/>">공지사항</a></li>
			<li><a href="<c:url value='/customer/board/list'/>">자유게시판</a></li>
			<li><a href="<c:url value='/customer/mypage'/>">마이페이지</a></li>
			<li><a href="<c:url value='/common/logout'/>">로그아웃</a></li>
		</ul>
	</div>
</body>
</html>