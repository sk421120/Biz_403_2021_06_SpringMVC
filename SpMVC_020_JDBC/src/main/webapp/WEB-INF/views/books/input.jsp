<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
form {
	width: 80%;
	margin: 15px auto;
}

fieldset {
	border: 1px solid salmon;
	border-radius: 15px;
}

legend {
	text-align: center;
	padding: 10px 20px;
	background-color: rgb(250, 250, 250);
}

form div {
	width: 80%;
	margin: 5px auto;
}

form label {
	display: inline-block;
	width: 20%;
	text-align: right;
	maring: 4px 5px;
	padding: 8px;
	color: rgb(200, 100, 80);
	font-weight: bold;
}

form input {
	width: 70%;
	border-radius: 25px;
	maring: 4px 5px;
	padding: 8px;
	outline: 0;
	border-color: rgba(20, 220, 20, 20.5);
}

form input:focus {
	border-color: rgba(0, 200, 0, 20.5);
}

form input:hover {
	background-color: lightgreen;
}

button.btn_book_insert {
	background-color: lightsalmon;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>

	<form method="POST">
		<fieldset>
			<legend>도서정보 등록</legend>
			<div>
				<label>ISBN</label> <input name="bk_isbn" id="bk_isbn"
					placeholder="도서의 ISBN을 입력해주세요." />
			</div>
			<div>
				<label>도서명</label> <input name="bk_title" id="bk_title"
					placeholder="도서의 이름을 입력해주세요." />
			</div>
			<div>
				<label>출판사</label> <input name="bk_ccode" id="bk_ccode"
					placeholder="" />
			</div>
			<div>
				<label>저자</label> <input name="bk_acode" id="bk_acode"
					placeholder="" />
			</div>
			<div>
				<label>출판일</label> <input name="bk_date" id="bk_date" placeholder="" />
			</div>
			<div>
				<label>가격</label> <input name="bk_price" id="bk_price"
					placeholder="" />
			</div>
			<div>
				<label>페이지수</label> <input name="bk_pages" id="bk_pages"
					placeholder="" />
			</div>

			<div class="btn_box">
				<button type="button" class="btn_save book">저장</button>
				<button type="reset" class="btn_reset book">새로작성</button>
				<button type="button" class="btn_list book">리스트로</button>
			</div>
		</fieldset>
	</form>
<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
</body>
<script>
document.querySelector("button.btn_book_insert")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/books/insert";
});
</script>
</html>