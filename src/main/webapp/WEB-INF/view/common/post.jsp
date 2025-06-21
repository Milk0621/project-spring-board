<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<div class="wrap">
		<div class="caption">
			<h2>게시글 상세보기</h2>
		</div>
		<table class="post-detail">
			<tr>
				<th>제목</th>
				<td>${post.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${post.author }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${post.createDate }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${post.content }</td>
			</tr>
		</table>
	
		<c:set var="userTypePath" value="${sessionScope.user.userType eq '0' ? 'admin' : 'customer'}" />
		<c:set var="boardType" value="${param.type}" />
		<c:set var="listUrl" value='/${userTypePath}/${boardType}/list' />

		<div class="post-buttons">
			<a href="<c:url value='${listUrl }' />">목록으로</a>
			<c:if test="${user.id eq post.author or user.userType eq '0'}">
				<a class="btn" href="<c:url value='/common/write?type=${type }&no=${post.no }' />">수정</a>
				<a class="btn" href="<c:url value='/common/delete?type=${type }&no=${post.no }' />">삭제</a>
			</c:if>
		</div>
	</div>
</body>