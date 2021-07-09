<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />

<style>
	div.gallery_box {
		display:flex;
		flex-direction:column;
		margin:5px auto;
		padding:10px;
		border:2px solid lightgray;
		border-radius: 20px;
	}
	div.gallery_box img{
		border-radius: 10px;
	}
	
	div.gallery_box div:first-of-type {
		flex:1;
	}
	
	div.gallery_box div:last-of-type {
		margin-top:5px;
		text-align:center;
		flex:3;
	}
	
	div.gallery_box div:last-of-type p{
		color: gray;
	}
</style>

<c:forEach items="${GALLERYS}" var="GALLERY">
<div class="gallery_box">
	<div>
	<a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">
		<c:if test="${empty GALLERY.g_image}">
			<img src="${rootPath}/files/noImage.jpg" width="500px">
		</c:if>
		<c:if test="${not empty GALLERY.g_image}">
			<img src="${rootPath}/files/${GALLERY.g_image}" width="500px">
		</c:if>
	</a>
	</div>
	<div>
		<h3><a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">
			${GALLERY.g_subject}</a></h3>
		<p>${GALLERY.g_content}</p>
	</div>
</div>
</c:forEach>