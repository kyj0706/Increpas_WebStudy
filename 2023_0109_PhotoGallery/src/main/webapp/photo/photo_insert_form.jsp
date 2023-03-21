<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
	#box{
		width: 600px;
		margin:auto;
		margin-top: 30px;
		padding:10px;
		border: 1px solid black;
		box-shadow: 0px 0px 20px black;
		border: none;
	}
	
	#title{
		text-align: center;
		font-size: 50px;
		color: white;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	
	}
	.table>tbody>tr>td {
		vertical-align:middle;
	
	}
	.table>tbody>tr>th {
		vertical-align:middle;
		text-align: center;
	
	}
	textarea{
		width: 100%;
		resize: none;
	
	}

	input[value="메인화면"]{
		float: right;
		margin-bottom: 10px;
	}
	
	input[value="등록하기"]{
		margin-left: 200px;
	}
	
	
</style>
<script type="text/javascript">
	function send(f) {
		
		var p_title 	= f.p_title.value.trim();
		var p_content 	= f.p_content.value.trim();
		var photo		= f.photo.value;
		
		if(p_title==''){
			alert("사진 제목입력해");
			f.p_title.value='';
			f.p_title.focus();
			return;
		}
		if(p_content==''){
			alert("내용 입력해");
			f.p_content.value='';
			f.p_content.focus();
			return;
		}
		if(photo==''){
			alert("사진을 선택하세요");
			return;
		}
		
		f.action ="insert.do";
		f.submit();
		
	}

</script>


</head>
<body>
<form method="post" enctype="multipart/form-data">
	<div id="box">
		 <h2 id="title" >::::사진등록::::</h2>
	  	<br>
		<div class="panel">
			<div class="panel-heading"><span class="glyphicon glyphicon-camera"> 사진</span> 
			<input class="btn btn-default" type="button" value="메인화면" onclick="location.href='../photo/list.do'">
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover" border="1">
					<tr>
						<th>제목</th>
						<td><input name="p_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="p_content" rows="5"></textarea>  </td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input type="file" name="photo"> </td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn btn-success" type="button" value="등록하기" id="btn_join" onclick="send(this.form);">
							<input class="btn btn-danger" type="reset" value="취소하기">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</form>
</body>
</html>