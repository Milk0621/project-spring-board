<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrap">
	<div class="caption">
		<h2>자유게시판</h2>
		<a class="write_btn" href="<c:url value='/common/write?type=board' />">글쓰기</a>
	</div>
	<table class="table">
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th colspan="2">날짜</th>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
				<td><a href="<c:url value="/common/post?type=board&no=${board.no }" />">${board.title }</a></td>
				<td>${board.author }</td>
				<td>${board.createDate }</td>
				<td class="admin_btn">
					<a class="btn" href="<c:url value='/common/write?type=board&no=${board.no }' />">수정</a>
					<a class="btn" href="<c:url value='/common/delete?type=board&no=${board.no }' />">삭제</a>
				</td>
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