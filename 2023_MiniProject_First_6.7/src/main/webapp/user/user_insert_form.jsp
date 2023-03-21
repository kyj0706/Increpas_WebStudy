<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>

<!-- 우편번호 검색 -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body {
	min-height: 100%;
	background: #E0EAFC;
	background: -webkit-linear-gradient(to right, #CFDEF3, #E0EAFC);
	background: linear-gradient(to right, #CFDEF3, #E0EAFC);
}

.input-form {
	max-width: 500px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
}

#btn-join {
	background: #9796f0;
	background: -webkit-linear-gradient(to right, #fbc7d4, #9796f0);
	background: linear-gradient(to right, #fbc7d4, #9796f0);
	width: 50%;
	height: 50px;
	border: 0;
	outline: none;
	border-radius: 40px;
	font-weight: bold;
}

#btn-reset {
	background: #E22121;
	background: -webkit-linear-gradient(to right, #E22121, #E22121);
	background: linear-gradient(to right, #fbc7d4, #E22121);
	width: 50%;
	height: 50px;
	border: 0;
	outline: none;
	border-radius: 40px;
	font-weight: bold;
}

#id_msg {
	display: inline-block;
	width: 250px;
	margin-left: 20px;
}

#pwc_msg {
	display: inline-block;
	width: 250px;
	margin-left: 20px;
}

.mb-5 {
	text-align: center;
}

h2 {
	color: black;
	font-size: 2em;
}


.mb-5 > a{
	text-decoration: none;

}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- 중복체크 -->
<script type="text/javascript">
	$(document).ready(function() {

		//아이디 중복 체크
		$("#user_id").keyup(function() {

			var user_id = $(this).val();

			if (user_id.length < 3) {
				$("#id_msg").html("아이디는 3자리 이상 입력 ").css("color", "red");
				return;
			}//if_end
			$("#id_msg").html("");

			$.ajax({
				url : "check_id.do",
				data : {
					"user_id" : user_id
				},
				dataType : "json",
				success : function(result_date) {
					if (result_date.result == true) {
						$("#id_msg").html("사용 가능한 아이디").css("color", "blue");
					} else {
						$("#id_msg").html("이미 사용중 입니다.").css("color", "red");
					}
				},
				error : function(err) {
					alert(err.responseText);
				}

			});//ajax_end
		});//keyup_end

		//비밀번호 확인 체크
		$("#user_pwc").keyup(function() {
			var user_pw = $("#user_pw").val();
			var user_pwc = $("#user_pwc").val();

			$("#pwc_msg").html("");

			if (user_pw != "" || user_pwc != "") {
				if (user_pw == user_pwc) {
					$("#pwc_msg").html("비밀번호가 일치합니다").css("color", "blue");
				} else {
					$("#pwc_msg").html("일치하지 않습니다.").css("color", "red");
				}
			}

		});//keyup_end

	});//jquery_end
</script>

<!-- 다음 주소 API -->
<script type="text/javascript">
	function find_address() {

		new daum.Postcode({
			oncomplete : function(data) {

				$("#user_post").val(data.zonecode);
				$("#user_address1").val(data.address);

			}
		}).open();

	}
</script>

<!-- 정규화 및 submit -->
<script type="text/javascript">
	function send(f) {

		var user_name = f.user_name.value.trim();
		var user_id = f.user_id.value.trim();
		var user_pw = f.user_pw.value.trim();
		var user_pwc = f.user_pwc.value.trim();
		var user_email = f.user_email.value.trim();
		var user_address1 = f.user_address1.value.trim();
		var user_address2 = f.user_address2.value.trim();
		var user_post = f.user_post.value.trim();

		if (user_name == '') {
			alert('이름을 입력해주세요.');
			f.user_name.value
			f.user_name.focus();
			return;
		}
		if (user_id == '') {
			alert('아이디 입력해주세요.');
			f.user_id.value
			f.user_id.focus();
			return;
		}
		if (user_pw == '') {
			alert('비밀번호 입력해주세요.');
			f.user_pw.value
			f.user_pw.focus();
			return;
		}
		if (user_email == '') {
			alert('이메일 입력해주세요.');
			f.user_email.value
			f.user_email.focus();
			return;
		}
		if (user_address1 == '') {
			alert('주소를 입력해주세요.');
			f.user_address1.value
			f.user_address1.focus();
			return;
		}
		if (user_address2 == '') {
			alert('주소를 입력해주세요.');
			f.user_address2.value
			f.user_address2.focus();
			return;
		}
		if (user_post == '') {
			alert('이름을 입력해주세요.');
			f.user_post.value
			f.user_post.focus();
			return;
		}

		f.action = "insert.do";
		f.submit();
	}
</script>

</head>
<body>
	<form>
		<div class="container1">
			<div class="input-form-backgroud row">
				<div class="input-form col-md-10 mx-auto">
					<h2 class="mb-5">
						<a href="../product/list.do">Bring It</a>
					</h2>
					<div class="row">
						<div class="mb-3 col-sm-12">
							<label for="u_grade">등급</label> <select name="user_grade">
								<option>일반</option>
								<option>판매</option>
								<option>관리</option>
							</select>
						</div>
						<div class="row">
							<div class="mb-3 col-sm-12">
								<label for="u_name">이름</label> <input type="text"
									class="form-control" name="user_name" id="user_name"
									placeholder="이름을 입력해주세요." required>

							</div>
							<div class="mb-3 col-sm-12">
								<label>아이디</label> <input type="text" class="form-control"
									name="user_id" id="user_id" placeholder="아이디를 입력해주세요." required><span
									id="id_msg"></span>

							</div>
							<div class="mb-3 col-sm-12">
								<label>비밀번호</label> <input type="password" class="form-control"
									name="user_pw" id="user_pw" required
									placeholder="영문 대/소문자+숫자+특수문자 8~15자">

							</div>
							<div class="mb-3 col-sm-12">
								<label>비밀번호 확인</label> <input type="password"
									class="form-control" name="user_pwc" id="user_pwc" required><span
									id="pwc_msg"></span>
							</div>

							<div class="mb-3 col-sm-12">
								<label>이메일</label> <input type="email" class="form-control"
									name="user_email" id="user_email" placeholder="you@example.com"
									required>

							</div>

							<div class="mb-3 col-sm-12">
								<label>주소</label> <input type="button" value="주소검색"
									onclick="find_address();"> <input type="text"
									class="form-control" name="user_address1" id="user_address1"
									placeholder="서울시 강남구 신사동" required>

							</div>
							<div class="mb-2 col-sm-12">
								<input type="text" class="form-control" name="user_address2"
									id="user_address2" placeholder="상세주소" required>
							</div>
							<div class="mb-3 col-sm-12">
								<label>우편번호</label> <input class="form-control" name="user_post"
									id="user_post" required>

							</div>

							<div class="mb-4 col-sm-12"></div>
							<input type="button" id="btn-join" value="가입하기"
								style="margin: auto;" onclick="send(this.form);"> 
						   <input type="reset" id="btn-reset" value="다시입력" style="margin: auto;">
						</div>

					</div>
				</div>
			</div>
			<footer class="my-3 text-center text-small">
				<p class="mb-1">&copy; 2023 Class01</p>
			</footer>

		</div>
	</form>
</body>

</html>