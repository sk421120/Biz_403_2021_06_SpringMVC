<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
	article.gallery_wrap {
	width:70%;
		margin:0 auto;
		display: flex;
		flex-direction: column;
	}
	
	div#gallery_info {
		width:500px;
		margin:0 auto;
	}
	
	div#gallery_info div.main_img {
	margin:0 auto;
	width:200px;
	}
	
	div#gallery_info div.main_img img{
		margin:8px auto;
		border-radius: 45px;
		width:200px;
	}
	
	div#gallery_files {
		display: flex;
		flex-wrap: wrap;
		flex-direction: column;
	}
	div#gallery_files img{
		margin:2px auto;
		border-radius: 5px;
	}
	
	div.gallery_file:after {
		content :"";
		position : absolute;
		left:0;
		top:0;
		bottom: 0;
		right:0;
		background-color: rgba(0,0,0,0.5);
		
	}
	/*
	box 내의 text의 그려지는 높이를 box의 높이와 같게 만들면
	text가 box의 세로방향 가운데 정렬이 된다
	*/
	div.gallery_file:hover:after {
		content: '\f2ed';
		
		font-size:30px;
		font-family:"Font Awesome 5 Free";
		
		background-color: salmon;
		color:white;
		cursor: pointer;
	}
</style>

<article class="gallery_wrap">
<div class="gallery_button_box">
	<button class="gallery update">수정</button>
	<button class="gallery delete">삭제</button>
</div>
<div id="gallery_info">
	<div class="main_img">
		<c:if test="${ empty GALLERY.g_image}">
		<img src="${rootPath}/files/noImage.jpg">
		</c:if>
		<c:if test="${ not empty GALLERY.g_image}">
		<img src="${rootPath}/files/${GALLERY.g_image}">
		</c:if>
	</div>
	<h3>제목 : ${GALLERY.g_subject}</h3>
	<h5>SEQ : ${GALLERY.g_seq }</h5>
	<p>작성일 : ${GALLERY.g_date}</p>
	<p>작성시각 : ${GALLERY.g_time}</p>
	<p>작성자 : ${GALLERY.g_writer}</p>
	<p>내용 : ${GALLERY.g_content}</p>
</div>

<div id="gallery_files">
	<c:forEach items="${GALLERY.fileList}" var="FILE">
	<div class="gallery_file" data-fseq="${FILE.file_seq}">
		<c:if test="${empty FILE.file_upname}">
		<img src="${rootPath}/files/${noImage.jpg}" width="500px">
		</c:if>
		<c:if test="${not empty FILE.file_upname}">
		<img src="${rootPath}/files/${FILE.file_upname}" width="500px">
		</c:if>
	</div>
	</c:forEach>
</div>
</article>

<script>
let update_button = document.querySelector("button.gallery.update")
let delete_button = document.querySelector("button.gallery.delete")

update_button.addEventListener("click", ()=> {
	// alert("${GALLERY.g_seq}인 게시물을 수정")
	
	/*
	현재 GALLERY.g_seq 값은 숫자형이다
	
	만약 GALLERY.g_seq 값이 S0001 등과 같이 문자열형 이라면
	이 코드는 JS 문법오류가 발생할 것이다
	
	왜 ??
			
	현재 작성한 코드는 JSP 코드이다
	이 코드는 Resonse가 될때 HTML코드로 변환이 되고
	Script부분도 변환이 되는데
	변환되는 과정에서 ${GALLERY.g_seq} 는 담겨있는 문자열인
	S0001 만 단독으로 나타난다
	
	아래 코드는 "/root-context/gallery/update?g_seq=" + S0001 처럼
	변환이 된다
	
	결국 JS 코드가 실행될때 + S0001 처럼 변환되어 변수를 찾게 된다
	그리고 S0001 이라는 변수가 정의 되지 않아
	문법오류가 발생한다
	
	** EL tag를 사용하여
	스크립트 부분에서 직접 값을 부착할때는 DQ("") 부착하여
	문법 오류를 방지하자
	*/
	location.href="${rootPath}/gallery/update?g_seq=${GALLERY.g_seq}"
})

delete_button.addEventListener("click", ()=> {
	if( confirm("${GALLERY.g_seq}인 게시물을 삭제??") ) {
		location.replace("${rootPath}/gallery/delete?g_seq=${GALLERY.g_seq}")
	}
})

/*
 * const : JS에서 상수를 선언하기
 다른 언어에서는 상수 선언이 메모리적 문제를 해결하고 동시성처리(멀티 환경에서
		 서로 변수가 간섭하는 현상을 핸들링)를 쉽게 하기위한 방안으로 사용한다
		 
 상수를 선언하는 이유
 여기에 설정된 값이 코드 중간에 어떤 이유로 변경되는 것을 방지하는 역할
 
 한개의 선언된 변수에 코드 중간에 다른 값이 저장되어(의도하지 않아도)
 논리 적인 오류를 일으킬 수 있다
 그러한 문제를 해결하기 위하여 const 키워드를 상당히 권장한다
 */
const gallery_files = document.querySelector("div#gallery_files")

if(gallery_files){
	gallery_files.addEventListener("click", (e)=>{
		const tag = e.target
		
		// tag에 걸려있는 class 이름을 챙겨서 조건을 걸때
		// tag.className === "gallery_file"와 같이 사용할 수 있지만
		// 혹시 tag에 다수의 클래스가 설정될 수 있기 때문에 조건문이 false가 될 수 있다
		// className.includes() 함수를 사용하여 조건 검사를 하는 것이 좋다
		if(tag.tagName === "DIV" && tag.className.includes("gallery_file")) {
			const seq = tag.dataset.fseq
			if(confirm(seq + "이미지 삭제")) {
				
				// GET method 방식으로 Ajax 요청
				fetch("${rootPath}/gallery/file/delete/"+seq).then( response=>response.text())
				.then(result=> {
					if(result === "OK") {
						alert("삭제 성공")
						// 현재 클릭된 DIV tag 요소를 화면에서 제거
					} else if(result === "NO") {
						alert("서버가 몰라요")
					} else if(result === "FAIL_SEQ"){
						alert("이미지 코드가 잘못되어 삭제할 수 없음")
					} else {
						alert("삭제 실패")
					}
				})
			}
			
		}
	})
}

</script>