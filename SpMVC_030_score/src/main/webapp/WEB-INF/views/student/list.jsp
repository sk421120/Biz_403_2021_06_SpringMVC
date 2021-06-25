<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
	/*button.student.insert {
	
	}
	button.home {
	background-color: lightsalmon;
	color:white;
	}*/
</style>
<h2>학생 리스트</h2>
<table class="student_list detail">
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전공</th>
		<th>학년</th>
		<th>전화번호</th>
		<th>주소</th>
	</tr>
	<c:choose>
		<c:when test="${empty STLIST }">
			<tr>
				<td colspan="6">데이터가 없음</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${STLIST}" var="ST">
				<tr data-stnum="${ST.st_num }">
					<td>${ST.st_num }</td>
					<td>${ST.st_name }</td>
					<td>${ST.st_dept }</td>
					<td>${ST.st_grade }</td>
					<td>${ST.st_tel }</td>
					<td>${ST.st_addr }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div class="btn_box">
	<button class="student insert">학생정보 등록</button>
	<button class="student home">처음으로</button>
</div>
<script>
/*
document.querySelector("table.student_list").addEventListener("click", (e)=>{
	let target = e.target
	let tagName = target.tagName
	
	if(tagName === "TD") {
		let tr = target.closest("TR")
		let stNum = tr.dataset.stnum
		
		location.href = "${rootPath}/student/detail?st_num="+ stNum
		//alert(stNum)
	}
})
*/
</script>