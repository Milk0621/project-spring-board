<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<ul>
		<li><a href="<c:url value='/home'/>">홈</a></li>
		<li><a href="<c:url value='/admin/notice/list'/>">공지사항</a></li>
		<li><a href="<c:url value='/admin/board/list'/>">자유게시판</a></li>
		<li><a href="<c:url value='/admin/management'/>">회원관리</a></li>
		<li><a href="<c:url value='/common/logout'/>">로그아웃</a></li>
	</ul>
</header>