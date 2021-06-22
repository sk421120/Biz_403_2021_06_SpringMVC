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

form#book_input input.search {
	width:30%;
}
form#book_input span.name{
	color:salmon;
	font-weight: bold;
	margin-left:10px;
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
<script>
	var rootPath = "${rootPath}"
		/*
		 * 동적으로(fetch로 가져온 HTML) 만들어진 DOM에 event 설정하기
		   표준 JS에서는 
		   동적으로 생성된 tag는 document.querySelector()에 의해서
		   선택되지 않는다.
		   이벤트를 document(가장 상위 DOM)에 설정하기
		 */
		document.addEventListener("click",(e)=>{
				let target = e.target
				let tagName = target.tagName 
				
				if(tagName === "TD") {
					let parentTag = target.closest("TR")
					let parentClassName = parentTag.className
					if(parentClassName === "search_comp") {
						
						// let ccode = parentTag.dataset.ccode
						
						// 현재 선택된 tr의 child를 가져와서
						// 각 TD 칼럼에 담겨있는 값을 추출하기
						let tds = parentTag.childNodes
						let ccode = tds[1].textContent
						let ctitle = tds[3].textContent
						let cceo = tds[5].textContent
						let ctel = tds[7].textContent
						let msg = ctitle + ", ";
						msg += cceo + ", ";
						msg += ctel + ", ";
						
						document.querySelector("input#bk_ccode").value = ccode
						document.querySelector("span#cp_title").innerText = msg
						
					} else if(parentClassName === "search_author") {
						// let acode = parentTag.dataset.acode
						let tds = parentTag.childNodes
						let acode = tds[1].textContent
						let aname = tds[3].textContent
						let atel = tds[5].textContent
						
						let msg = aname + ", "
						msg += atel
						document.querySelector("input#bk_acode").value = acode
						document.querySelector("span#au_name").innerText = msg
					}
					
					// pop 닫기
					document.querySelector("div#modal").style.display = "none";
					document.querySelector("div#div_search").innerHTML = "";
					document.querySelector("div#div_search").remove();
					
				}
		});
</script>
<script src="${rootPath}/static/js/book_input.js?ver=2021-06-21-005"></script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>

	<form id="book_input" method="POST">
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
				<label>출판사</label>
				<input class="search" name="bk_ccode" id="bk_ccode" placeholder="" />
				<span id="cp_title" class="name">출판사명</span>
			</div>
			<div>
				<label>저자</label>
				<input class="search" name="bk_acode" id="bk_acode" placeholder="" />
				<span id="au_name" class="name">저자명</span>
			</div>
			<div>
				<label>출판일</label> <input name="bk_date" id="bk_date" placeholder="" />
			</div>
			<div>
				<label>가격</label> <input name="bk_price" id="bk_price" value="0" placeholder="" />
			</div>
			<div>
				<label>페이지수</label> <input name="bk_pages" id="bk_pages" value="0" placeholder="" />
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
</html>