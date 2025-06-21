<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홈</title>
	<link rel="stylesheet" href="<c:url value='/static/css/common/home.css' />" />
</head>
<body>
	<div class="wrap">
		<h1>어서오세요. 관리자님</h1>
		<ul>
			<li><a href="<c:url value='/admin/notice/list'/>">공지사항</a></li>
			<li><a href="<c:url value='/admin/board/list'/>">자유게시판</a></li>
			<li><a href="<c:url value='/admin/management'/>">회원관리</a></li>
			<li><a href="<c:url value='/common/logout'/>">로그아웃</a></li>
		</ul>
	</div>
</body>
</html>