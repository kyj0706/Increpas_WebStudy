<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설명 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- css -->
<style type="text/css">
	#box{
		width: 400px;
		margin: auto;
		margin-top: 100px;
	}
	
	th, td{
		text-align: center;
	}
	
	.table>tbody>tr>td {
		vertical-align:middle;
	
	}
	
	h3{
		text-align: center;
	}
	input[type="button"] {
		margin: 10px;	
	}
	

</style>

<!-- javascript -->
<script type="text/javascript">

//var regular_num = /^[0-9][0-9]?$|^100$/;
var regular_num = /^[0-9]{1,2}?$|^100$/;

	function send(f) {
		
		var name  = f.name.value.trim();
		var kor   = f.kor.value;
		var eng   = f.eng.value;
		var mat   = f.mat.value;
		
		//입력값에 대한 유효성 검사
		
		//이름
		if(name==''){
			alert("이름을 입력하세요");
			f.name.value='';
			f.name.focus();
			return;
		}
		if(regular_num.test(kor)==false || regular_num.test(kor)==''){
			alert("입력 :["+kor+"]"+" ▶0~100사이◀ 숫자만 입력해주세요.");
			f.kor.value='';
			f.kor.focus();
			return;
		}
		if(regular_num.test(eng)==false || regular_num.test(eng)==''){
			alert("영어");
			
			return;
		}
		if(regular_num.test(mat)==false || regular_num.test(mat)==''){
			alert("수학");
			
			return;
		}
		
		
		f.action = "insert.do";
		f.submit();//전송
	}
	


</script>




</head>
<body>

<form>
	<div id="box">
		<div class="panel panel-success">
			<div class="panel-heading"><h3>:::성적등록:::</h3></div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>이름</th>
						<td><input name="name"></td>
					</tr>
					<tr>
						<th>국어</th>
						<td><input name="kor"></td>
					</tr>
					<tr>
						<th>영어</th>
						<td><input name="eng"></td>
					</tr>
					<tr>
						<th>수학</th>
						<td><input name="mat"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn btn-primary" type="button" value="등록하기" onclick="send(this.form)">
							<input class="btn btn-info" type="button" value="목록보기" onclick="location.href='list.do'">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</form>
</body>
</html>