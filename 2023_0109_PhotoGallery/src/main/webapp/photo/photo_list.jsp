<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style type="text/css">
#box {
	width: 1000px;
	margin: auto;
	margin-top: 30px;
	padding: 10px;
	border: 1px solid black;
	box-shadow: 0px 0px 20px black;
	border: none;
}

#photo_box {
	width: 100%;
	height: 500px;
	border: 1px solid black;
	overflow-y: scroll;
}

#title {
	text-align: center;
	font-size: 50px;
	color: #ffd700;
	font-weight: bold;
	text-shadow: 3px 3px 5px black;
}

.photo_class {
	width: 150px;
	height: 200px;
	padding: 10px;
	margin: 20px;
	float: left;
}

.photo_class_none {
	text-align: center;
	font-size: 30px;
	color: red;
	margin-top: 30px;
}

.photo_class>img {
	width: 120px;
	height: 120px;
	outline: 1px solid black;
	border-radius: 50%;
}

img:active {
	width: 100px;
	transform: scale(2, 1.5);
	transition: transform.3s;
}

/* .photo_class:hover {
		border: 2px solid black;
		box-shadow: 2px 2px 2px purple;
	} */
.photo_title {
	width: 90%;
	border: 1px solid black;
	box-shadow: 1px 1px 1px black;
	margin-top: 5px;
	margin-bottom: 5px;
	margin: auto;
	/* ellipsis */
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	word-break: break-all;
}


#wrapper {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0 auto;
	max-width: 1180px;
	padding: 0 10px;
}

#wrapper a {
	height: 35px;
	width: 35px;
	text-align: center;
	line-height: 35px;
	font-size: 17px;
	color: white;
	background: coral;
	margin: 0 4px;
	border: 2px solid coral;
	transition: all 0.3s ease;
}

#wrapper a:hover {
	color: coral;
}
</style>

<script type="text/javascript">
	/* 사진등록 */
	function photo_insert_form() {

		if ("${empty user}" == "true") {

			if (confirm("사진등록은 로그인하고 가능해.\n 로그인 할꺼야 ?") == false)
				return;

			//로그인폼으로 이동 
			location.href = "../member/login_form.do";
			return;

		}//if_end

		//사진등록폼으로 이동
		location.href = "insert_form.do";

	}
</script>
<script type="text/javascript">
	function show_detail(p_idx) {

		$("#photo_popup").show();
		$("#btn_modify,#btn_delete").hide();

		//Ajax
		$
				.ajax({
					url : "photo_detail.do", //PhotoDetailAction
					data : {
						"p_idx" : p_idx
					}, //photo_detail.do?p_idx=3
					dataType : "json",
					success : function(result) {
						//result = { "p_idx":1 , "p_title":"제목", "p_content":"내용", "p_filename":"a.jpg",...}

						//file다운로드 = photo_popup_detail.jsp 에 있는 것을 가지고 온다 => include 되어있때문에 
						global_filename = result.p_filename;
						global_p_idx	= result.p_idx;

						$("#owner_info").html(
								"회원번호[" + result.mem_idx + "]님이 올린사진");
						$("#popup_image").prop("src",
								"../upload/" + result.p_filename);
						$("#popup_title").html(result.p_title);
						$("#popup_content").html(result.p_content);
						var str_date = "등록일자"
								+ result.p_regdate.substring(0, 16) + "<br>"
								+ "수정일자" + result.p_modifydate.substring(0, 16);
						$("#popup_date").html(str_date);

						//로그인유저 게시물의 주인이 같으면
						if ("${user.mem_idx}" == result.mem_idx) {

							$("#btn_modify,#btn_delete").show();
						}

					},
					error : function(err) {
						alert(err.responseText);
					}
				});

	}

	function hide_detail() {
		$("#photo_popup").hide();
	}
</script>

<!-- 수정 삭제 -->
<script type="text/javascript">
	
	//수정
	function modify_form() {
		//수정폼 띄우기 PhotoModifyFormAction
		location.href ="modify_form.do?p_idx="+global_p_idx;
		
		
	}
	
	//삭제
	function del() {
		//삭제확인
		if (confirm("정말삭제 할거야?")==false) return;
		location.href ="delete.do?p_idx="+global_p_idx;
	}

</script>


</head>
<body>
	<%@include file="photo_popup_detail.jsp"%>
	<div id="box">
		<h1 id="title">:::PhotoGallery:::</h1>

		<div id="login" style="text-align: right; margin-bottom: 5px;">
			<!-- 로그인 안된경우  -->
			<c:if test="${empty user }">
				<input class="btn btn-success" type="button" value="로그인"
					onclick="location.href='../member/login_form.do'">
			</c:if>

			<!-- 로그인 된경우  -->
			<c:if test="${not empty user }">
			${user.mem_name }님 환영한다?
			<input class="btn btn-warning" type="button" value="로그아웃"
					onclick="location.href='../member/logout.do'">
			</c:if>
		</div>

		<div id="photo_insert">
			<input class="btn"
				style="background-color: aquamarine; margin-bottom: 5px;"
				type="button" value="사진등록" onclick="photo_insert_form();">
			<div id="wrapper">
				<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
					class="fab fa-twitter"></i></a> <a href="#"><i
					class="fab fa-instagram"></i></a> <a href="#"><i
					class="fab fa-youtube"></i></a>
			</div>
		</div>
		<div id="photo_box">
			<!-- 데이터가 없을경우 -->
			<c:if test="${empty list }">
				<div class="photo_class_none">등록된 사진이 없다</div>
			</c:if>
			<!-- 데이터가 있을경우 -->
			<c:forEach var="vo" items="${list }">
				<div class="photo_class">
					<img src="../upload/${vo.p_filename }"
						onclick="show_detail('${vo.p_idx}');">
					<div class="photo_title" style="margin-top: 5px;">${vo.p_title }</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>