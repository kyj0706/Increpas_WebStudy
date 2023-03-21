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

var regular_num = /^[0-9][0-9]?$|^100$/;
//var regular_num = /^[0-9]{1}[0-9]{1,9}?$|^100$/;
//var regular_num = /100||^[0-9]{0,2}$/;

	function send(f) {
		
		var idx   = f.idx.value;
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
			alert("국어점수 제대로 입력해 [0~100]숫자만 입력 ");
			f.kor.value='';
			f.kor.focus();
			return;
		}
		if(regular_num.test(eng)==false || regular_num.test(eng)==''){
			alert("영어점수 제대로 입력해 [0~100]숫자만 입력");
			f.eng.value='';
			f.eng.focus();
			return;
		}
		if(regular_num.test(mat)==false || regular_num.test(mat)==''){
			alert("수학점수 제대로 입력해 [0~100]숫자만 입력");
			f.mat.value='';
			f.mat.focus();
			
			return;
		}
		
		
		 //삭제확인
		 if(confirm("정말 수정하시겠습니까?")==false) return;
		 
		 
		f.action = "modify.do";
		f.submit();//전송
	}
	
	
	

		 
		 
		 
	 


</script>




</head>
<body>

<form>
	<div id="box">
		<div class="panel panel-danger">
			<div class="panel-heading"><h3>:::성적수정:::</h3></div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>번호</th>
						<td><input name="idx" value="${vo.idx }" readonly="readonly"></td>
					</tr>
					<tr>
						<th>이름[수정]</th>
						<td><input name="name" value="${vo.name }"></td>
					</tr>
					<tr>
						<th>국어[수정]</th>
						<td><input name="kor" value="${vo.kor }"></td>
					</tr>
					<tr>
						<th>영어[수정]</th>
						<td><input name="eng" value="${vo.eng }"></td>
					</tr>
					<tr>
						<th>수학[수정]</th>
						<td><input name="mat" value="${vo.mat }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn btn-primary" type="button" value="수정하기" onclick="send(this.form)">
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