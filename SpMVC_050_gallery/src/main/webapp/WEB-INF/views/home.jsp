<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/c3834cbadf.js" crossorigin="anonymous"></script>
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
	
	nav#main_nav {
		height:5vh;
		background-color: lightsalmon;
	}
	
	nav#main_nav ul {
		width:550px;
		margin:0 auto;
		
	}
	
	nav#main_nav ul {
		display:flex;
		height: inherit;
	}
	
	nav#main_nav ul li {
		list-style:none;
		text-align:center;
		padding:10px;
		background-color: lightsalmon;
		color: white;
		transition:0.3s;
		position:relative;
	}
	nav#main_nav ul li:hover {
		background-color:rgba(255,255,255,0.2);
		cursor: pointer;
	}
	
	nav li#login, nav li#logout {
		margin-left:auto;
	}
	
	nav li:after {
		content:'';
		position:absolute;
		
		left:0;
		bottom:0;
		height:0;
		width: 0;
		
		transition: width 0.7s
	}
	
	nav li:hover:after {
		border-bottom: 5px solid white;
		width:100%;
	}
	
	section.gallery_section {
		height: 85vh;
		display:flex;
		flex-direction:column;
		overflow:auto;
	}
	
	a {
		text-decoration: none;
		color:inherit;
	}
	
</style>
</head>
<body>
<h1>내 갤러리</h1>
<%@ include file="/WEB-INF/views/include/include_nav.jspf" %>

<section class="gallery_section">
<c:choose>
	<c:when test="${BODY == 'GA_INPUT'}">
		<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA_LIST'}">
		<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA_DETAIL'}">
		<%@ include file="/WEB-INF/views/gallery/detail.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA_DETAIL_V2'}">
		<%@ include file="/WEB-INF/views/gallery/detail2.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'JOIN'}">
		<%@ include file="/WEB-INF/views/member/join.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'LOGIN'}">
		<%@ include file="/WEB-INF/views/member/login.jsp" %>
	</c:when>
	<c:otherwise>
		<a href="${rootPath}/gallery/input" class="go">이미지 등록</a>
	</c:otherwise>
</c:choose>
</section>
</body>
<script>
let main_nav = document.querySelector("nav#main_nav")

if(main_nav) {
	main_nav.addEventListener("click", (e)=>{
		let menu = e.target
		if(menu.tagName ==="LI") {
			
			if(menu.id === "join") {
				location.href="${rootPath}/member/" + menu.id
			} else if(menu.id === "login") {
				location.href="${rootPath}/member/" + menu.id +"/nav"
			} else if(menu.id === "logout") {
				location.href="${rootPath}/member/" + menu.id
			} else if(menu.id === "image_create") {
				location.href="${rootPath}/gallery/input"
			} else if(menu.id === "home") {
				location.href="${rootPath}/"
			}
		}
		
	})
}

</script>

</html>