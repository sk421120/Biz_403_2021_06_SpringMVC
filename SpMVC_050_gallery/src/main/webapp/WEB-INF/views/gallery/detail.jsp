<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
	article.gallery_wrap {
	width:70%;
		margin:0 auto;
		display: flex;
		flex-direction: column;
	}
	
	div#gallery_info {
		width:500px;
		margin:0 auto;
	}
	
	div#gallery_info div.main_img {
	margin:0 auto;
	width:200px;
	}
	
	div#gallery_info div.main_img img{
		margin:8px auto;
		border-radius: 45px;
		width:200px;
	}
	
	div#gallery_files {
		display: flex;
		flex-wrap: wrap;
		flex-direction: column;
	}
	div#gallery_files img{
		margin:2px auto;
		border-radius: 5px;
	}
</style>

<article class="gallery_wrap">
<div id="gallery_info">
	<div class="main_img">
		<img src="${rootPath}/files/${GFLIST[0].g_image}">
	</div>
	<h3>제목 : ${GFLIST[0].g_subject}</h3>
	<p>작성일 : ${GFLIST[0].g_date}</p>
	<p>작성시각 : ${GFLIST[0].g_time}</p>
	<p>작성자 : ${GFLIST[0].g_writer}</p>
	<p>내용 : ${GFLIST[0].g_content}</p>
</div>

<div id="gallery_files">
	<c:forEach items="${GFLIST}" var="FILE">
		<img src="${rootPath}/files/${FILE.f_upname}" width="500px">
	</c:forEach>
</div>
</article>