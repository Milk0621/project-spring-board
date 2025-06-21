<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> <tiles:insertAttribute name="title" /> </title>
	<link rel="stylesheet" href="<c:url value='/static/css/common/layout.css' />" />
</head>
<body>
	<!-- header -->
	<tiles:insertAttribute name="header" />
	
	<!-- body -->
	<tiles:insertAttribute name="body" />
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="<c:url value='/static/js/userDelete.js' />"></script>
</html>