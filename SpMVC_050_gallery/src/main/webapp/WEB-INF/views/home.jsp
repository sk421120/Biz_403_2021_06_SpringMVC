<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
	box-sizing: border-box;
	margin:0;
	padding :0;
	}
	
	h1 {
	height: 10vh;
	background-color: salmon;
	color:white;
	text-align: center;
	line-height: 10vh;
	}
	
	section.gallery_section {
	height: 90vh;
	display:flex;
	flex-direction:column;
	
	overflow:auto;
	}
	
	a {
		text-decoration: none;
		color:inherit;
	}
	
	a.go {
		text-align:center;
		padding:10px;
		background-color: lightsalmon;
		color: white;
	}
	
</style>
</head>
<body>
<h1>내 갤러리</h1>
<section class="gallery_section">
<c:choose>
	<c:when test="${BODY == 'GA_INPUT'}">
		<a href="${rootPath}/gallery" class="go">리스트로</a>
		<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA_LIST'}">
		<a href="${rootPath}/gallery/input" class="go">이미지 등록</a>
		<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA_DETAIL'}">
		<a href="${rootPath}/gallery" class="go">리스트로</a>
		<%@ include file="/WEB-INF/views/gallery/detail.jsp" %>
	</c:when>
	<c:otherwise>
		<a href="${rootPath}/gallery/input" class="go">이미지 등록</a>
	</c:otherwise>
</c:choose>
</section>

<c:if test="${not empty FILES }">
<c:forEach items="${FILES}" var="FILE">
<a href="${rootPath}/files/${FILE}" target="_NEW">
	<img src="${rootPath}/files/${FILE}" width="200px"/>
</a>
</c:forEach>
</c:if>

</body>
</html>