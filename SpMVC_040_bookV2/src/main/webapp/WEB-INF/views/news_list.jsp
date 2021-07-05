<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>

<c:forEach items="${NEWS_LIST}" var="NEWS">
	<div class="content">
		<div>
			<p class="title">
				<a href="${NEWS.link}" target="_NEW">${NEWS.title}</a>
			</p>
			<p class="desc">${NEWS.description}</p>
			<p class="author">
				<strong>시간</strong>${NEWS.pubDate}</p>
			<p><a href="${NEWS.originallink}" target="_NEW">
			<strong>언론사바로가기</strong></a> </p>
		</div>
	</div>
</c:forEach>