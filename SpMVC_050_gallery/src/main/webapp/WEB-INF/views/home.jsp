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
<form method="POST" enctype="multipart/form-data">
	<div>
	<input type="file" name="one_file">
	</div>
	<div>
	<input type="file" multiple="multiple" name="m_file">
	</div>
	<button>전송</button>
</form>
</body>
</html>