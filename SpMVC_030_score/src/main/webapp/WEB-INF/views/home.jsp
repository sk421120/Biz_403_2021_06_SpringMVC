<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale: 1"/>
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	/* viewport의 width만큼 */
	width:100wv;
	height:100vh;
	display: flex;
	flex-direction: column;
}

header {
	height: 30vh;
	background: url("${rootPath}/static/images/header_background.jpg") no-repeat;
	background-size: 100% 100%;
	background-position: top;
	background-attachment: fixed;
	text-align: center;
	text-shadow: 1px 1px 1px black;
	color: white;
	padding: 2rem;
}

nav {
	background-color: black;
	color:white;
	width:100wv;
}

nav.fixed {
	position : fixed;
	top:0;
	left:0;
	right:10px;
	border-bottom-right-radius: 20px; 
	box-shadow: 3px 3px 3px rgba(0,0,0,0.5);
}

nav ul {
	list-style: none;
	display: flex;
	margin:0 20px;
}

nav li {
	padding:16px 12px;
	border-bottom: 3px solid transparent;
	transition:1s;
	cursor: pointer;
}

nav li:hover {
	border-bottom: 3px solid yellow;
}

nav li:nth-last-of-type(2) {
	margin:left;
}

section#main_sec {
	width: 100wv;
	height:70vh;
	display: flex;
	flex-direction: column;
	background: linear-gradient(to bottom, salmon, salmon, #fcdb03);
	background-size: 100% 100%;
	background-attachment: fixed;
	overflow:auto;
}

h2 {
 width:90%;
 color:white;
 margin: 10px auto 0 auto;
 padding:1rem;
 border:1px solid #aaa;
}
table {
	border: 0;
	width: 90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin: 10px auto;
}

tr {
	border-top: 1px solid black;
}

tr:last-child {
	border-bottom: 1px solid black;
}

tr:nth-of-type(odd) {
	background-color:#eee; 
}

tr:nth-of-type(even) {
	background-color: #dfdfdf;
}

tr:hover td {
	background-color: white;
	cursor: pointer;
}

td, th {
	border-right: 1px solid green;
	padding: 8px 12px;
}

td:last-child, th:last-child {
	border: none;
}

td.number {
	text-align: right;
}

/* form */
form {
	width:90%;
	margin:0 auto 10px auto;
}

fieldset {
background-color: #eee;
border:1px solid gray;
border-radius: 10px;
padding:0.7rem;
}

form label, form input {
display: inline-block;
margin:5px;
padding:5px;
}
form label {
width:30%;
text-align: right;
color: darkblue;
font-weight: bold;
}
form input {
width:60%;
outline: 0;
border: 1px solid #aaa;
border-radius: 50px;
}
form input:hover {
background-color: lightsalmon;
}

/* button */
div.btn_box {
	width: 90%;
	/* table의 margin 10px auto로 설정되어 있기 때문에 top-margin은 0으로 bottom-margin은 10px 좌우는 auto */
	margin: 0px auto 10px auto;
	padding: 5px;
	text-align: right;
}

div.btn_box button {
	border: 0;
	outline: 0;
	padding: 12px 16px;
	margin-left: 10px;
	border-radius: 5px;
}

button.home {
	background-color: lightsalmon;
	color:white;
}
	
button.update {
	background-color: lightorange;
}
	
button.delete {
	background-color: darkgreen; 
}

button.insert {
	background-color: orange;
	color: white;
}

button.save {
	background-color: salmon;
	color:white;
}

button.reset {
	background-color: white;
	color:black;
}

button.student.list {
	background-color: lightgreen;
	color:white;
}

button:hover {
	box-shadow: 2px 2px 2px 2px black;
	cursor: pointer;
}


</style>
</head>
<body>
<header>
	<h1>대한고교 성적처리 2021</h1>
	<p>대한고교 성적처리 시스템 2021 V1</p>
</header>
<nav id="main_nav">
	<ul>
		<li>HOME</li>
		<li>로그인</li>
		<li>로그아웃</li>
		<li>관리자</li>
	</ul>
</nav>
	<section id="main_sec">
		<c:choose>
			<c:when test="${BODY == 'SCORE_VIEW'}">
				<%@ include file="/WEB-INF/views/score/list.jsp" %>
			</c:when>
			<c:when test="${BODY == 'STUDENT_LIST'}">
				<%@ include file="/WEB-INF/views/student/list.jsp" %>
			</c:when>
			<c:when test="${BODY == 'STUDENT_INPUT'}">
				<%@ include file="/WEB-INF/views/student/input.jsp" %>
			</c:when>
			<c:when test="${BODY == 'STUDENT_DETAIL'}">
				<%@ include file="/WEB-INF/views/student/detail.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main.jsp" %>
			</c:otherwise>
		</c:choose>
	</section>
</body>

<script>
/*
 * JS 코드에서 event를 등록할때 현재 화면에 없는 DOM 요소에 addEvent를 설정하면
 없는 함수라는 오류가 발생한다. 그 이유는 현재 화면에 없는 DOM 요소를 querySelector하면
 그 결과값이 null이기 때문에 발생하는 문제이다
 
 JS 코드를 통합하여 모음으로 관리할때는 addEvent를 하려고 하는 요소가 있는지 먼저 검사한 후
 addEvent를 수행해 주어야 한다
 */
let std_list = document.querySelector("button.student.list");
let home = document.querySelector("button.student.home");
let insert = document.querySelector("button.student.insert");

if(std_list) {
	std_list.addEventListener("click",(e)=> {
		location.href="${rootPath}/student";
	});
}
if(insert) {
	insert.addEventListener("click",(e)=> {
		location.href="${rootPath}/student/insert";
	});
}
if(home) {
	home.addEventListener("click",(e)=> {
		location.href="${rootPath}/";
	});
}
//document.querySelector("button.student.list").addEventListener("click",(e)=> {
//	location.href="${rootPath}/student";
//});
//document.querySelector("button.student.home").addEventListener("click",(e)=> {
//	location.href="${rootPath}"
//});

let table= document.querySelector("table.detail");
if(table) {
	table.addEventListener("click", (e)=>{
		let target = e.target
		let tagName = target.tagName
	
		if(tagName === "TD") {
			let tr = target.closest("TR")
			let stNum = tr.dataset.stnum
		
			location.href = "${rootPath}/student/detail?st_num="+ stNum
			//alert(stNum)
		}
	})
}

let main_nav = document.querySelector("nav#main_nav")
let main_header = document.querySelector("header")

// header box의 높이가 얼마냐
let main_header_height = main_header.offsetHeight;

document.addEventListener("scroll",()=>{
	// HTML 문서 전체의 크기, 좌표 등을 추출하기
	
	let doc_bound = document.querySelector("HTML")
		.getBoundingClientRect();
	
	let doc_top = doc_bound.top
	
	if(doc_top < main_header_height * -1) {
		main_nav.classList.add("fixed")
	} else {
		main_nav.classList.remove("fixed")		
	}
})
</script>
</html>