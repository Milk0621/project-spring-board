<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrap">
	<div class="caption">
		<h2>${user.name }님 마이페이지</h2>
		<button type="button" id="userDelete">탈퇴</button>
	</div>
	<table>
		<tr>
			<th>아이디</th>
			<td>${user.id }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${user.name }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${user.phoneNumber }</td>
		</tr>
		<tr>
			<th>가입날짜</th>
			<td>${user.createDate }</td>
		</tr>
	</table>
</div>
<div class="modal_box">
	<div class="modal">
		<form action="<c:url value='/customer/userDelete' />" method="post">
			<h3>비밀번호 확인</h3>
			<input type="password" name="pw" placeholder="비밀번호를 입력해주세요."><br>
			<button type="submit">탈퇴</button>
			<button type="button" id="close">취소</button>
		</form>
	</div>
</div>