<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" href="<c:url value='/static/css/common/login.css' />" />
</head>
<body>
	<div class="wrap">
		<a class="close" href="<c:url value='/home'/>">x</a>
		<form action="<c:url value='/common/login' />" method="post">
			<input type="text" id="userId" name="id" placeholder="아이디"><br>
			<input type="password" id="userPw" name="pw" placeholder="비밀번호"><br>
			<div>
				<span>아이디가 없으신가요?</span>
				<a href="<c:url value='/common/join'/>">회원가입</a>
			</div>
			<button type="submit">로그인</button>		
		</form>
	</div>
</body>
</html>