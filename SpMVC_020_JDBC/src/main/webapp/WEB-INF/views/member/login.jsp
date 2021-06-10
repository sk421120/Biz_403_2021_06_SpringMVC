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
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<style>
form#login_form {
width:400px;
padding:40px;
margin :80px auto;
background-color: #dfdfdf;
text-align: center;
border-radius: 30px;
}

form#login_form h2{
color:black;
font-weight:500;
}

form#login_form input {
	border:0;
	outline:0;
	display:block;
	
	width:200px;
	margin:20px auto;
	
	padding: 14px 10px;
	color: black;
	border-radius: 20px;
	background: none;
	border:2px solid gray;
	
	text-align: center;
	transition:0.4s;
}
form#login_form button{
	border:0;
	outline:0;
	background: none;
	display:block;
	margin:2px auto;
	text-align: center;
	border:1px solid gray;
	color:black;
	cursor: pointer;
	transition:0.4s;
}
form#login_form button:hover {
	background-color: lightgray;
}

form#login_form input:focus {
	width:280px;
	border-color: black;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
	
	<form id="login_form" method="POST">
	<h2>로그인</h2>
		<input name="m_username" placeholder="USER ID">
		<input name="m_password" type="password" placeholder="PASSWORD">
		<button>로그인</button>
	</form>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
</body>
</html>