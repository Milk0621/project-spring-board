<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrap">
	<div class="caption">
		<h2>회원관리</h2>
	</div>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>가입일</th>
			<th colspan="2">탈퇴일</th>
		</tr>
		<c:forEach var="user" items="${list }">
			<tr>
				<td class="user">${user.id }</td>
				<td>${user.name }</td>
				<td>${user.phoneNumber }</td>
				<td>${user.createDate }</td>
				<td class="user_delete">${user.deleteDate }</td>
				<td class="admin_btn"><a class="btn" href="<c:url value='/admin/userDelete?id=${user.id }' />">탈퇴</a></td>
			</tr>
		</c:forEach>	
	</table>
	<div class="page">
		<c:if test="${curPage > 1}">
			<a href="?p=1">&lt&lt</a>
			<a href="?p=${curPage - 1}">&lt</a>
		</c:if>
		<c:forEach begin="1" end="${totalPage}" var="i">
			<a href="?p=${i}">${i}</a>
		</c:forEach>
		<c:if test="${curPage < totalPage}">
			<a href="?p=${curPage + 1}">&gt</a>
			<a href="?p=${totalPage}">&gt&gt</a>
		</c:if>
	</div>
</div>