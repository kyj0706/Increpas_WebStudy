<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<style type="text/css">
#box {
	width: 600px;
	margin: auto;
	margin-top: 30px;
	padding: 10px;
	border: 1px solid black;
	box-shadow: 0px 0px 20px black;
	border: none;
}

#title {
	text-align: center;
	font-size: 50px;
	color: blue;
	font-weight: bold;
	text-shadow: 3px 3px 5px black;
}

.table>tbody>tr>td {
	vertical-align: middle;
}

.table>tbody>tr>th {
	vertical-align: middle;
	text-align: center;
}

textarea {
	width: 100%;
	resize: none;
}

input[value="메인화면"] {
	float: right;
	margin-bottom: 10px;
}

input[value="수정하기"] {
	margin-left: 230px;
}

img {
	width: 120px;
	height: 120px;
	outline: 1px solid black;
}

#my_img {
	
}
</style>
<script type="text/javascript">
	function send(f) {

		var p_title = f.p_title.value.trim();
		var p_content = f.p_content.value.trim();

		if (p_title == '') {
			alert("사진 제목입력해");
			f.p_title.value = '';
			f.p_title.focus();
			return;
		}
		if (p_content == '') {
			alert("내용 입력해");
			f.p_content.value = '';
			f.p_content.focus();
			return;
		}

		f.action = "modify.do";
		f.submit();

	}
</script>
<!-- 수정이미지 미리보기(해본거) -->
<!-- <script>
	function setThumbnail(event) {
		var reader = new FileReader();

		reader.onload = function(event) {
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			document.querySelector("div#image_container").appendChild(img);
		};

		reader.readAsDataURL(event.target.files[0]);
	}
</script> -->

<!-- 수정 ajax(강사님) -->
<script type="text/javascript">
  function ajaxFileUpload(){
	  //업로드용 폼안에 있는 ajaxFile 버튼 클릭
	  $("#ajaxFile").click();
  } 
  
  function ajaxFileChange(){
	  
	  //alert('이미지 교체..');
	  var photo = $("#ajaxFile")[0].files[0];
	  
	  if(photo==undefined) return;
	  
	  //console.log(photo);
	  //alert(photo.name);
	  
	  //서버로 전송
	  //1.전송데이터 포장
	  //var form     = $("#ajaxForm")[0];
	  var formData = new FormData();
	  formData.append("p_idx", "${ vo.p_idx }");
	  formData.append("photo",photo);
	  
	  //2.ajax로 전송(요청)
	  $.ajax({
		  url			: "photo_upload.do",   //PhotoUploadAction
		  type			: "POST",
		  data			: formData,            //photo_upload.do?p_idx=3&photo=a.jpg
		  processData	: false,
		  contentType	: false,
		  dataType		: "json",
		  success		: function(result){
			  //result = {"p_filename": "a.jpg"}
			  //result = {"p_filename": "no_file"}
			  
			  //방법1)
			  //새로고침: location.href=""  =>자신의 페이지를 호출함
			  //location.href="";
			  
			  //방법2)
			  $("#my_img").attr("src","../upload/" + result.p_filename);
		  },
		  error			: function(err){
			  alert(err.responseText);
		  }
	  });
	  
	  
  }

</script>

</head>
<body>
	<!-- 파일업로드용 폼 (따로 만들기) [용도 분리] -->
	<form id="ajaxForm" method="post"  enctype="multipart/form-data" >
		<input style="display: none;" type="file"  id="ajaxFile"
			onchange="ajaxFileChange();">
	</form>


	<form>
		<input type="hidden" name="p_idx" value="${vo.p_idx }">
		<div id="box">
			<h2 id="title">::::사진수정::::</h2>
			<br>
			<div class="panel">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-camera">정보수정</span> <input
						class="btn btn-default" type="button" value="메인화면"
						onclick="location.href='../photo/list.do'">
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover"
						border="1">
						<tr>
							<td colspan="2" align="center">
								<img src="../upload/${vo.p_filename }" id="my_img">
								<br>
								<br>
								<input type="button" value="이미지편집" onclick="ajaxFileUpload();">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input name="p_title" value="${vo.p_title }"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="p_content" rows="5">${vo.p_content }</textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input class="btn btn-success" type="button"
								value="수정하기" id="btn_join" onclick="send(this.form);"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>