<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		width: 500px;
		margin:auto;
		margin-top: 100px;
		padding:50px;
		border: 1px solid black;
		box-shadow: 0px 0px 20px black;
		border: none;
	}
	.table>tbody>tr>td {
		vertical-align:middle;
	
	}
	.table>tbody>tr>th {
		vertical-align:middle;
		text-align: center;
	
	}
	
	#title{
		text-align: center;
		font-size: 50px;
		color: white;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	
	}
	
	input[value="로그인"]{
		margin-right: 20px;
	}
	
	input[value="목록보기"]{
		float: right;
	}

</style>
<script type="text/javascript">
	function send(f) {
		
		var mem_id 	= f.mem_id.value.trim();
		var mem_pwd	= f.mem_pwd.value.trim();
		
		if(mem_id==''){
			
			 Swal.fire({ 
		          html:'<h2 style="color: red;">아이디 비었잖아!</h2>',
		          icon:'info',
		          returnFocus:false
		        }
			  ).then(function(){
				  //확인버튼 누른후 처리
				 f.mem_id.value ='';
				 f.mem_id.focus();
			  });
			return;
		}
		if(mem_pwd==''){
			 Swal.fire({ 
		          html:'<h2 style="color: red;"><p>야 !!!</p> 비밀번호 비었잖아!!<p>똑바로 안해?</p></h2>',
		          icon:'info',
		          returnFocus:false
		        }
			  ).then(function(){
				  //확인버튼 누른후 처리
				 f.mem_pwd.value ='';
				 f.mem_pwd.focus();
			  });
			return;
		}
		
		f.action = "login.do";
		f.submit();
		
	}

</script>
<script type="text/javascript">
	$(document).ready(function () {
		
	
		setTimeout(show_message,100);
		
	});
	
	
	function show_message() {
		
		
		if("${param.reason eq 'fail_id'}" == "true"){
			
			Swal.fire({
				  icon: 'error',
				  title: 'Oops...',
				  html: '<h3>없는 아이디야</h3>',
				}
			  ).then(function(){
				  //확인버튼 누른후 처리
				 $("#mem_id").val('');
				 $("#mem_id").focus();
			
			  });
			
		}
		if("${param.reason eq 'fail_pwd'}" == "true"){
			
			Swal.fire({
				  icon: 'error',
				  title: 'Oops...',
				  html: '<h3>비번이 틀렷다</h3>',
				}
			  ).then(function(){
				  //확인버튼 누른후 처리
				 $("#mem_pwd").val('');
				 $("#mem_pwd").focus();
			
			  });
		}
		
	}
	
	



</script>

</head>
<body>
<form>
<div id="box">
	  <h2 id="title" >::::구르르:::: <p>로그인</p></h2>
	  <br>
<div class="panel">
      <div class="panel-heading"><span class="glyphicon glyphicon-log-in"> 로그인</span> 
      	<input class="btn btn-default" type="button" value="목록보기" onclick="location.href='list.do'">
      </div>
      <div class="panel-body">
      	<table class="table table-striped table-bordered table-hover" border="1">
      		<tr>
      			<th>아이디</th>
      			<td><input type="text" class="form-control" name="mem_id" id="mem_id" value="${param.mem_id }"></td>
      		</tr>
      		<tr>
      			<th>비밀번호</th>
      			<td><input type="password" class="form-control" name="mem_pwd" id="mem_pwd"></td>
      		</tr>	
			<tr>			
      			<th colspan="2">
      				<input class="btn btn-success" type="button" value="로그인" id="btn_join" onclick="send(this.form);">
      				<input class="btn btn-info" type="button" value="회원가입" onclick="location.href='insert_form.do'">
      			</th>
      		</tr>
      	</table>
      </div>
</div>
</div>
</form>
</body>


</html>