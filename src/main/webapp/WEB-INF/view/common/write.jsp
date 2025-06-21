<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<div class="wrap">
		<form action="<c:url value='${mode eq "edit" ? "/common/update" : "/common/write"}' />" method="post">
			<input type="hidden" name="type" value="${type }">
			<input type="hidden" name="no" value="${post.no }">
			<div class="caption">
				<h2>글쓰기</h2>
				<div>
					<button type="submit">${mode eq 'edit' ? '수정' : '등록'}</button>
					<button type="button" onclick="history.back();">취소</button>
				</div>
			</div>
			<div class="content_box">
				<input type="text" name="title" value="${mode eq 'edit' ? post.title : ''}" placeholder="제목을 입력해주세요."><br>
				<textarea name="content" placeholder="내용을 입력하세요">${mode eq 'edit' ? post.content : ''}</textarea>
			</div>
		</form>
	</div>
</body>