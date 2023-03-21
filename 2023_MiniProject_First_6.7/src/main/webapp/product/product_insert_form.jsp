<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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


<!-- 정규화 및 submit -->
<script type="text/javascript">
	function send(f) {

		var product_name = f.product_name.value.trim();
		var product_price = f.product_price.value.trim();
		
		var product_company = f.product_company.value.trim();
		var product_category = f.product_category.value.trim();
		
		var product_image1 = f.product_image1.value.trim();
		var product_image2 = f.product_image2.value.trim();
		var product_image3 = f.product_image3.value.trim();
		var product_image4 = f.product_image4.value.trim();

		if (product_name == '') {
			alert('이름을 입력해주세요.');
			f.product_name.value
			f.product_name.focus();
			return;
		}if (product_price == '') {
			alert('가격을 입력해주세요.');
			f.product_price.value
			f.product_price.focus();
			return;
		}if (product_company == '') {
			alert('제조사을 입력해주세요.');
			f.product_company.value
			f.product_company.focus();
			return;
		}if (product_category == '') {
			alert('카테고리을 입력해주세요.');
			f.product_category.value
			f.product_category.focus();
			return;
		}if (product_image1 == '') {
			alert('이미지을 입력해주세요.');
			f.product_image1.value
			f.product_image1.focus();
			return;
		}if (product_image2 == '') {
			alert('이미지을 입력해주세요.');
			f.product_image2.value
			f.product_image2.focus();
			return;
		}if (product_image3 == '') {
			alert('이미지을 입력해주세요.');
			f.product_image3.value
			f.product_image3.focus();
			return;
		}if (product_image4 == '') {
			alert('이미지을 입력해주세요.');
			f.product_image4.value
			f.product_image4.focus();
			return;
		}
		
		f.action = "insert.do";
		f.submit();
	}
</script>

</head>
<body>
	<form method="POST" action="insert.do"  enctype="multipart/form-data">
		<div class="container1">
			<div class="input-form-backgroud row">
				<div class="input-form col-md-10 mx-auto">
					<h2 class="mb-5">
						<a href="../product/list.do">Bring It</a>
					</h2>
					<div class="row">
						
						<div class="row">
							<div class="mb-3 col-sm-12">
								<label for="p_name">제품 이름</label> 
								<input type="text" class="form-control" name="product_name" id="product_name" >
							</div>
							
							<div class="mb-3 col-sm-12">
								<label>제품 가격</label> <input type="text" class="form-control"
									name="product_price" id="product_price" required
									placeholder="가격을 입력해주세요. (단위 : \\)">
							</div>
							
							<div class="mb-3 col-sm-12">
								<label>제조사</label> 
								<!-- <select>
									<option>로저드 뷔</option>
									<option>노모스</option>
									<option>etc</option>
								</select> -->
								
								
								<input type="text" class="form-control"
									name="product_company" id="product_company" placeholder="제조사를 입력해주세요."
									required>
							</div>

							<div class="mb-3 col-sm-12">
								<label>카테고리</label> 
								<!-- <select>
									<option>Bag</option>
									<option>shoes</option>
									<option>Accessory</option>
								</select> -->
								
								<input type="text" class="form-control"
									name="product_category" id="product_category" placeholder=""
									required>
							</div>

							<div class="mb-3 col-sm-6">
								<label>첫번째 이미지</label> <input type="file" class="form-control"
									name="product_image1" id="product_image1" placeholder=""
									required>
							</div>

							<div class="mb-3 col-sm-6">
								<label>두번째 이미지</label> <input type="file" class="form-control"
									name="product_image2" id="product_image2" placeholder=""
									required>
							</div>

							<div class="mb-3 col-sm-6">
								<label>셋번째 이미지</label> <input type="file" class="form-control"
									name="product_image3" id="product_image3" placeholder=""
									required>
							</div>

							<div class="mb-3 col-sm-6">
								<label>네번째 이미지</label> <input type="file" class="form-control"
									name="product_image4" id="product_image4" placeholder=""
									required>
							</div>

							
							<div class="row-5 mb-3 col-sm-12">
								<label>제품 설명</label><br>
								<textarea name="product_content" rows="10" cols="50"></textarea>
								 <!-- <input type="text" class="form-control"
									name="product_content" id="product_content" placeholder="제품 설명을 입력해주세요." height="100px;" required><span
									id="id_msg"></span> -->
							</div>
								
							
							<div class="mb-4 col-sm-12"></div>
							<input type="button" id="btn-join" value="등록하기"
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