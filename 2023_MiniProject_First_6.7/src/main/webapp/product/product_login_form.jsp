<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./login.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Space Grotesk';
}

.wrap {
	width: 100%;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	background: rgba(0, 0, 0, 0.1);
}

.login {
	width: 350px;;
	height: 500px;
	background: white;
	border-radius: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

.login_id {
	margin-top: 20px;
	margin: auto;
	width: 80%;
}

.login_id input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid lightgray;
	outline: none;
}

.login_pw {
	margin-top: 20px;
	margin: auto;
	width: 80%;
}

.login_pw input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid lightgray;
	outline: none;
}

.submit {
	margin-top: 30px;
	width: 60%;
}

#btn-join {
	background: #9796f0;
	background: -webkit-linear-gradient(to right, #fbc7d4, #9796f0);
	background: linear-gradient(to right, #fbc7d4, #9796f0);
	width: 40%;
	height: 50px;
	border: 0;
	outline: none;
	border-radius: 40px;
	font-weight: bold;
	font-size: 20px;
	margin: auto;
}

#btn-singup {
	background: #E22121;
	background: -webkit-linear-gradient(to right, #E22121, #E22121);
	background: linear-gradient(to right, #fbc7d4, #E22121);
	width: 40%;
	height: 50px;
	border: 0;
	outline: none;
	border-radius: 40px;
	font-weight: bold;
	font-size: 20px;
	margin: auto;
}

.forgot{
	margin: 10px 0px 10px 0px;
	text-align: center;
	
}


.mb-5 {
	text-align: center;
}

h1 {
	color: black;
	font-size: 40px;
}

.mb-5 > h1 > a {
	text-decoration: none;
	
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		//0.1초후에 호출
		setTimeout(send, 100);
	});
</script>
<script type="text/javascript">
	function send(f) {
		var user_id = f.user_id.value.trim();
		var user_pw = f.user_pw.value.trim();

		if (user_id == '') {

			Swal.fire({
				title : 'ID를 입력하세요',
				html : 'ID 누락',
				icon : 'info',
				returnFocus : false
			}).then(function() {
				//확인버튼 누른후 처리
				f.user_id.value = '';
				f.user_id.focus();
			});
			//f.mem_id.value='';
			//f.mem_id.focus();
			return;
		}

		if (user_pw == '') {
			Swal.fire({
				title : '비밀번호를 입력하세요',
				html : '비밀번호 누락',
				icon : 'info',
				returnFocus : false
			}).then(function() {
				//확인버튼 누른후 처리
				f.user_pw.value = '';
				f.user_pw.focus();
			});
			//f.mem_id.value='';
			//f.mem_id.focus();
			return;
		}

		f.action = "login.do"; //MemberLoginAction
		f.submit();

	}
</script>
</head>
<body>
	<form method="post">
		<div class="wrap">
			<div class="login">
					<div class="mb-5">
					<h1><a href="../product/list.do">Bring It</a></h1>
					</div>
			<div class="row">
				<div class="mb-3 col-sm-12">
					<div class="login_id">
						<h4>ID</h4>
						<input name="user_id" id="user_id" value="${ param.user_id }"
							placeholder="ID">
					</div>
				</div>
				<div class="mb-3 col-sm-12">
					<div class="login_pw">
						<h4>PASSWORD</h4>
						<input type="password" name="user_pw" id="user_pw"
							placeholder="PASSWORD">
					</div>
				</div>
				<div class="mb-3 col-sm-12">
					<div class="forgot">
						<a href="">아이디 찾기 |</a>
						<a href="">비밀번호 찾기</a>
					</div>
				</div>
				<div class="md-3"></div>
					<input type="button" id="btn-join" value="로그인"
									onclick="send(this.form);">
					<input type="button" id="btn-singup" value="회원가입"
									 onclick="location.href='insert_form.do'">
				
					
			</div>
			</div>
		</div>
	</form>
</body>
</html>