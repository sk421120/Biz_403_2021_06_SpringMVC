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
	margin: 0;
	padding: 0;
}

section#main_sec {
	width: 100%;
	margin: 5px auto;
	border: 1px solid #999;
	display: flex;
	justify-content: space-around;
}

section#main_sec article {
	flex: 1;
	border: 1px solid green;
	margin: 6px 3px;
	padding: 5px
}

section#main_sec article ul, section#main_sec article ol {
	margin: 0;
	padding: 0;
}

section#main_sec article li {
	margin: 0 20px;
	padding: 0 10px;
}

section#ad_sec {
	width: 100%;
	border: 1px solid #aaa;
	display:flex;
}

section#ad_sec article {
	flex:1;
	margin: 4px 3px;
	height: 200px;
	background-size: 100% 100%; /* cover */
	border-radius: 5px;
}

/*
 어떤 요소의 순서대로 속성을 지정할때
 nth-child(순서), nth-of-type(순서)
 다음과 같이 tag가 구성되어 있을때
 div
 	p 1
 	p 2
 	p 3
 	p 4
 div
 
 nth-child는 무조건 포함된 tag에 모두 일련번호를 부여한다
 div p:nth-child(4) : <p>4 tag에 대하여
 
 nth-of-type는 포함된 tag중에 지정한 tag만 일련번호를 부여한다
 div p:nth-child(3) : <p>4 tag에 대하여
*/
 /*
        ________________________________
        |   0% 0%       /   100% 0%     |
        |                               |
        |   0% 100%     /   100% 100%   |
        ---------------------------------
*/
section#ad_sec article:nth-of-type(1) {
background: url("${rootPath}/static/images/images_1.jpg") no-repeat;
background-position: 30% 30%;
background-size:130%;
}
section#ad_sec article:nth-of-type(2) {
background: url("${rootPath}/static/images/images_2.jpg") no-repeat;
background-size:100%;
}
section#ad_sec article:nth-of-type(3) {
background: url("${rootPath}/static/images/images_3.jpg") no-repeat;
background-position: 0% 10%;
background-size:120%;
}
section#ad_sec article:nth-of-type(4) {
background: url("${rootPath}/static/images/images_4.jpg") no-repeat;
background-size:100%;
}
section#ad_sec article:nth-of-type(5) {
background: url("${rootPath}/static/images/images_5.jpg") no-repeat;
background-position: 30% 50%;
background-size:150%;
}
section#ad_sec article:nth-of-type(6) {
background: url("${rootPath}/static/images/images_6.jpg") no-repeat;
background-size:110%;
}

</style>

</head>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
      <section id="main_sec">
      <article>
         <h3>출판사</h3>
         <ol>
            <li>출판사정보</li>
            <li>출판사정보</li>
            <li>출판사정보</li>
            <li>출판사정보</li>
            <li>출판사정보</li>
         </ol>
      </article>
      <article>
         <h3>도서정보</h3>
         <ul>
            <li>도서정보</li>
            <li>도서정보</li>
            <li>도서정보</li>
            <li>도서정보</li>
            <li>도서정보</li>
         </ul>
      </article>

      <article>
         <h3>저자정보</h3>
      </article>
   </section>
   <section id="ad_sec">
   	<article></article>
   	<article></article>
   	<article></article>
   	<article></article>
   	<article></article>
   	<article></article>
   </section>
   <%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
</body>
</html>