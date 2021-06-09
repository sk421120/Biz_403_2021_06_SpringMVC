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
<h1>출판사 정보 등록</h1>
<form method="POST">
<div><label>출판사명</label><input name="cp_title"></div>
<div><label>대표자명</label><input name="cp_ceo"></div>
<div><label>전화번호</label><input name="cp_tel"></div>
<div><label>주소</label><input name="cp_addr"></div>
<div><label>주요장르</label><input name="cp_genre"></div>
<div><button>저장</button></div>
</form>
<div><label>삭제할 코드</label><input name="cp_code" id="cp_code">
<button class="btn_delete">삭제</button></div>
<script>
	// const : 상수를 선언하는 키워드
	// 	코드가 진행되는 동안 값이 변경되면 안되는것
	const doc = document;
	
	doc.querySelector("button.btn_delete").addEventListener("click", (e)=>{
		doc.querySelector("input[name='cp_code']");
		const cpcodeObj = doc.querySelector("input#cp_code");
		let cp_code = cpcodeObj.value;
		if(confirm(cp_code + "를 삭제합니다.")) {
			location.replace("${rootPath}/comp/delete?cp_code=" + cp_code)
		}
	})
</script>
</body>
</html>