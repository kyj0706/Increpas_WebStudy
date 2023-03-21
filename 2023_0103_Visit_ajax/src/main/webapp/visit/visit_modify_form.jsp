<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설명 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- 꾸미기 -->
<style type="text/css">
	#box{
		width: 500px;
		margin: auto;
		margin-top: 20px;
	}
	
	textarea {
		width: 100%;
		resize: none;
	}
	
</style>

<!-- 스크립트 -->
<script type="text/javascript">

	function send(f){
		
		var content	= f.content.value.trim();
		var pwd		= f.pwd.value.trim();
		
		
		
		if(content==''){
			alert("내용을 입력해라");
			f.content.value='';
			f.content.focus();
			return;
		}
		if(pwd==''){
			alert("비번을 입력해라");
			f.pwd.value='';
			f.pwd.focus();
			return;
		}
		
		
		//수정확인 확인
		//if(confirm("정말 수정 할거야?")==false)return;
		Swal.fire({
			  icon: 'question',
			  title: '수정할거야 ??',
			  showDenyButton: true,
			  showCancelButton: true,
			  confirmButtonText: '수정해줘',
			  denyButtonText:  '안해래',
			}).then((result) => {
			  /* Read more about isConfirmed, isDenied below */
			  if (result.isConfirmed ===  Swal.fire('수정!', '', 'success')) 
			  {
				  
				 /*  .then((result) => {}); */
					  f.action = "modify.do"
					  f.submit();
					
			  }else if (result.isDenied) {
			    Swal.fire('안한데....', '', 'info')
			  }
			});
			
			/* .then((result) => {});
			  f.action = "modify.do"
				  f.submit(); */
		
	/* 	Swal.fire({
			  title: '수정할꺼야 ?',
			  text: "후회없다잉 ?!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
			  if (result.isConfirmed) {
			    Swal.fire(
			      'Deleted!',
			      'Your file has been deleted.',
			      'success'
			    )
			  }
			}) */
		
		
		
		
	}



</script>



</head>
<body>
<form>
<input type="hidden" name="idx" value="${vo.idx }">
<div id="box">
	<div class="panel panel-danger">
		<div class="panel-heading">방명록 수정하기</div>
		<div class="panel-body">
			
			<table class="table table-striped table-bordered table-hover">
				
				
				<tr>
					<th>작성자</th>
					<td><input name="name" value="${vo.name }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" rows="5" cols="50">${vo.content }</textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" value="${vo.pwd }"></td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
						<input class="btn btn-primary" type="button" value="수정하기" onclick="send(this.form)">
						<input class="btn btn-default" type="button" value="목록보기" onclick="location.href='list.do'">
					</td>
					
				</tr>
			</table>
		
		</div>
	</div>
	

</div>
</form>
</body>
</html>