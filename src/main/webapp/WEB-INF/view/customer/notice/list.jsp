<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrap">
	<div class="caption">
		<h2>공지사항</h2>
	</div>
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="notice" items="${list}">
			<tr>
				<td><a href="<c:url value="/common/post?type=notice&no=${notice.no }" />">${notice.title }</a></td>
				<td>${notice.author }</td>
				<td>${notice.createDate }</td>
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