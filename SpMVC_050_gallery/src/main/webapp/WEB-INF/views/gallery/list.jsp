<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />

<style>
	div.gallery_box {
		display:flex;
	}
	
	div.gallery_box div:first-of-type {
		flex:1;
	}
	
	div.gallery_box div:last-of-type {
		flex:3;
	}
</style>

<c:forEach items="${GALLERYS}" var="GALLERY">
<div class="gallery_box">
	<div>
		<img src="${rootPath}/files/${GALLERY.g_image}" width="500px">
	</div>
	<div>
		<h3>${GALLERY.g_subject}</h3>
		<p>${GALLERY.g_content}</p>
	</div>
</div>
</c:forEach>