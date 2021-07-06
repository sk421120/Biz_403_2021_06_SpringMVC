<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내 갤러리</h1>
<c:choose>
	<c:when test="${BODY == 'GA_INPUT'}">
		<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA_LIST'}">
		<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
		<a href="${rootPath}/gallery/input">이미지 등록</a>
	</c:when>
	<c:otherwise>
		<a href="${rootPath}/gallery/input">이미지 등록</a>
	</c:otherwise>
</c:choose>

<c:if test="${not empty FILES }">
<c:forEach items="${FILES}" var="FILE">
<a href="${rootPath}/files/${FILE}" target="_NEW">
	<img src="${rootPath}/files/${FILE}" width="200px"/>
</a>
</c:forEach>
</c:if>

<c:if test="${not empty ONEF}">
<a href="${rootPath}/files/${ONEF}" target="_NEW">
<img src="${rootPath}/files/${ONEF}" width="200px"/>
</a>
</c:if>
</body>
</html>