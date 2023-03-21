<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<!-- 다음 우편번호 사용 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<style type="text/css">
	#box{
		width: 800px;
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
	
	#mem_sign_up {
		margin-bottom: 5px;
		
	}
	
	#title{
		text-align: center;
		font-size: 50px;
		color: white;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	
	}
	#id_msg{
		display: inline-block;
		width: 250px;
		margin-left: 20px;
		
	}
	
	input[value="목록보기"]{
		float: right;
	}
	
	.form-control{
		width: auto;
	}
	
	
	/* input[type="text"]{
		size: 50px;
	} */
	
	#pw_msg{
		display: inline-block;
		width: 250px;
		margin-left: 20px;
	
	}

</style>

<!-- 아이디 중복확인  -->
<script type="text/javascript">
	$(document).ready(function(){
		
		//아이디 입력창에서 키가 눌렸다 때면
		 $("#mem_id").keyup(function(){
			 
			//기본 비활성화
			$("#btn_join").attr("disabled", true);
			
			   var mem_id = $(this).val();
			   
			   //console.log(mem_id);
			   if(mem_id.length<3){
				   
				   $("#id_msg").html("아이디는 3자리 이상이어야 합니다")
				               .css("color","red");
				   return;
			   }
			   $("#id_msg").html("");
			   
			   $.ajax({
			   		url 		:"check_id.do",
			   		data		:{"mem_id":mem_id},
			   		dataType	:"json",
			   		success		:function(result_data){
			   			//result_data = {"result" : true}
			   			if(result_data.result == true){
			   				$("#id_msg").html("사용가능한 아이디 입니다.")
				               .css("color","blue");
			   				//가입버튼 활성화
			   				$("#btn_join").attr("disabled", false);
			   				
			   			}else{
			   				$("#id_msg").html("이미 사용중인 아이디입니다..")
				               .css("color","red");
			   			}
			   		},
			   		error		:function(err){
			   			alert(err.responseText);
			   		}
			   });
			   
			   
		   });
		
		 $(".pw").keyup(function () {
				
		 		var mem_pwd = $("#mem_pwd").val();
		 		var mem_cpwd = $("#mem_cpwd").val();
		 		
		 	
				   $("#pw_msg").html("");
		 		
		 		
		 		
		 		if(mem_pwd != "" || mem_cpwd != ""){
		 			if(mem_pwd == mem_cpwd){
		 				$("#pw_msg").html("일치")
			               .css("color","blue");
			               
		 			}else{
		 				$("#pw_msg").html("불일치.")
			               .css("color","red");
			               
		 			}
		 			
		 		}
		 		
		
	});		
		 		
		 
		   
	   });
</script>



<!-- 다음 우편번호 -->
<script type="text/javascript">
	
	function find_address(){
		
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            
	            $("#mem_zipcode").val(data.zonecode);
	            $("#mem_address").val(data.address);
	            
	        }
	    }).open();
		
	}



</script>	

<!-- send()-->
<script type="text/javascript">
	function send(f) {
		
		var mem_name = f.mem_name.value.trim();
		var mem_pwd = f.mem_pwd.value.trim();
		var mem_zipcode = f.mem_zipcode.value.trim();
		var mem_address = f.mem_address.value.trim();
		
		if(mem_name=='') {
			alert("이름을 입력하세요");
			f.mem_name.value='';
			f.mem_name.focus();
			return;
		}
		if(mem_pwd=='') {
			alert("비밀번호 입력하세요");
			f.mem_pwd.value='';
			f.mem_pwd.focus();
			return;
		}
		if(mem_zipcode=='') {
			alert("우편번호 입력하세요");
			f.mem_zipcode.value='';
			f.mem_zipcode.focus();
			return;
		}
		if(mem_address=='') {
			alert("주소 입력하세요");
			f.mem_address.value='';
			f.mem_address.focus();
			return;
		}
		
		
		
		
		
		
		
		
		f.action = "insert.do";
		f.submit();
		
	}


</script>


</head>
<body>
<form>
<div id="box">
	  <h2 id="title">::::구르르르 가입::::</h2>
	  <br>
<div class="panel">
      <div class="panel-heading"><span class="glyphicon glyphicon-ok"> 회원가입</span>
      		<input class="btn btn-default" type="button" value="목록보기" onclick="location.href='list.do'">
       </div>
      <div class="panel-body">
      	<table class="table table-striped table-bordered table-hover" border="1">
      		<tr>
      			<th>이름</th>
      			<td><input type="text" class="form-control" name="mem_name" ></td>
      		</tr>
      		<tr>
      			<th>아이디</th>
      			<td><input type="text" class="form-control" name="mem_id" id="mem_id"><span id="id_msg"></span> </td>
      		</tr>
      		<tr>
      			<th>비밀번호</th>
      			<td><input type="password" class="form-control pw" name="mem_pwd" id="mem_pwd"></td>
      		</tr>	
      		<tr>
      			<th>비밀번호 확인</th>
      			<td><input type="password" class="form-control pw" name="mem_cpwd" id="mem_cpwd"><span id="pw_msg"></span></td>
      		</tr>	
      		<tr>
      			<th>우편번호</th>
      			<td>
      				<input type="button" class="btn" value="주소검색" onclick="find_address();">
      				<input type="text" class="form-control input-sm" name="mem_zipcode" id="mem_zipcode" >
      			
      			 </td>
      		</tr>
      		<tr>
      			<th>주소</th>
      			<td><input type="text" class="form-control input-sm" name="mem_address" id="mem_address" size="60"></td>
      		</tr>
			<tr>			
      			<th colspan="2">
      				<input class="btn btn-success" type="button" value="회원가입" id="btn_join" disabled="disabled" onclick="send(this.form);">
      				
      			</th>
      		</tr>
      	</table>
      </div>
</div>
</div>
</form>
</body>
</html>