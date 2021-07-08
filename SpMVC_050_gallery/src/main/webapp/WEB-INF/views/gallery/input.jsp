<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
	form {
		width:70%;
		margin: 0 auto;
		display: flex;
		flex-direction: column;
	}
	
	form div {
		width:70%;
		margin: 5px auto;
		border-bottom: 1px solid lightgray;
		flex:1;
	}
	form div label {
		display:inline-block;
		width:30%;
	}
	
	form div input, form div textarea, form button{
		border:0;
		outline:0;
		border-radius: 5px;
	}
	
	form div input, textarea{
		padding:5px;
		width:60%;
	}
	
	form button {
		margin:0 auto;
		padding:5px;
		width: 30%;
		background-color: darkorange;
		color: white;
	}

</style>

<form method="POST" enctype="multipart/form-data">
	<div>
		<label>작성자</label>
		<input name="g_writer" value="${CMD.g_writer}"/>
	</div>
	<div>
		<label>작성일자</label>
		<input name="g_date" value="${CMD.g_date}"/>
	</div>
	<div>
		<label>작성시각</label>
		<input name="g_time" value="${CMD.g_time}"/>
	</div>
	<div>
		<label>제목</label>
		<input name="g_subject" value="${CMD.g_subject}"/>
	</div>
	<div>
		<label></label>
		<textarea name="g_content" placeholder="내용을 입력하세요.."></textarea>
	</div>
	<div>
	<label>대표 이미지</label>
	<input type="file" name="one_file">
	</div>
	<div>
	<label>갤러리 이미지</label>
	<input type="file" multiple="multiple" name="m_file">
	</div>
	<button>전송</button>
</form>