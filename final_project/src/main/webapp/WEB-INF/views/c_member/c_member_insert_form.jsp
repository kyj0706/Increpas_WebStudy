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

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>  

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 

<style type="text/css">
	#box{
	    width: 600px;
	    margin: auto;
	    margin-top: 50px; 
	}
	#id_msg{
		display: inline-block;
		width: 250px;
		margin-left: 20px;
	}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">
   
   //초기화 이벤트
   $(document).ready(function(){
	   //아이디 입력창에서 키가 눌렸다 때지면 . . .		
	   $("#c_mem_id").keyup(function(){
		   $("#btn_join").attr("disabled", true);
		   var c_mem_id = $(this).val();
		   //console.log(mem_id);
		   if(c_mem_id.length<3){
			   $("#id_msg").html("3자리 이상의 아이디를 입력해주세요.")
			   .css("color","red");
			   return;
		   }
		   $("#id_msg").html("");
		   
		   //Ajax로 아이디 사용을 허락받는다 (중복체크)
		   $.ajax({
				url		 : "check_id.do",               //VisitCheckPwdAction
				data  	 : { "c_mem_id":c_mem_id } , //check_pwd.do?idx=10&c_pwd=1234
			    dataType : "json",
				success	 : function(result_data){
				   //result_data = {"result": true}
					if(result_data.result==true){
				   		$("#id_msg").html("사용가능한 아이디 입니다.")
						   .css("color","blue");
				   		//가입버튼 활성화
				   		$("#btn_join").attr("disabled", false);
					}else{
						$("#id_msg").html("사용이 불가능한 아이디 입니다.")
						   .css("color","red");
					}
				    
					},
				
				error		: function(err){				 
					alert(err.responseText);
				}
			   
			   
		   });
		   
	   });	
	   
	   $("#c_mem_pwd2").focusout(function(){
		   var c_mem_pwd2 = $(this).val();
		   //console.log(c_mem_id);
		   if($('#c_mem_pwd2').val() != $('#c_mem_pwd').val()){
			   $("#id_msg2").html("비밀번호가 일치하지 않습니다.")
			   .css("color","red");
			   $("#btn_join").attr("disabled", true);
		   }else {
			   $("#id_msg2").html("비밀번호가 일치합니다.")
			   .css("color","blue");
			   $("#btn_join").attr("disabled", false);
		   }
		   	
   });
	   $("#c_mem_pwd").keyup(function(){
		   var c_mem_pwd2 = $(this).val();
		   //console.log(c_mem_id);
		   if($('#c_mem_pwd2').val() != $('#c_mem_pwd').val()){
			   $("#id_msg2").html("비밀번호가 일치하지 않습니다.")
			   .css("color","red");
			   $("#btn_join").attr("disabled", true);
		   }else {
			   $("#id_msg2").html("비밀번호가 일치합니다.")
			   .css("color","blue");
			   $("#btn_join").attr("disabled", false);
		   }
		   	
   });	 
   });
</script>
<script type="text/javascript">
   
   function find_address(){
	   
	   new daum.Postcode({
	        oncomplete: function(data) {
	            //data = { "zonecode":12345 ,"address":"서울시 관악구","roadAddress":"",... }
	        	
	            $("#c_mem_zipcode").val(data.zonecode);
	            $("#c_mem_address").val(data.address);
	        	
	        }
	    }).open();

   }

</script>

<script type="text/javascript">
	function send(f){
		var c_mem_name        = f.c_mem_name.value.trim();
		var c_mem_pwd         = f.c_mem_pwd.value.trim();
		var c_mem_zipcode     = f.c_mem_zipcode.value.trim();
		var c_mem_address     = f.c_mem_address.value.trim();
		if(c_mem_name==''){
			//alert('이름을 입력하세요');
			Swal.fire(
				{
					html:'<h4>이름을 입력하세요</h4>',
					icon:'info',
					returnFocus:false
				 }
			     ).then(function(){
				 	f.c_mem_name.value='';
				 	f.c_mem_name.focus();
			     });
			  return;
		}
		if(c_mem_pwd==''){
			//alert('이름을 입력하세요');
			Swal.fire(
				{
					html:'<h4>비밀번호를 입력하세요</h4>',
					icon:'info',
					returnFocus:false
				 }
			     ).then(function(){
				 	f.c_mem_c_mem_value='';
				 	f.c_mem_pwd.focus();
			     });
			  return;
		}
		if(c_mem_zipcode==''){
			//alert('이름을 입력하세요');
			Swal.fire(
				{
					html:'<h4>우편번호를 입력하세요</h4>',
					icon:'info',
					returnFocus:false
				 }
			     ).then(function(){
				 	f.c_mem_zipcode.value='';
				 	f.c_mem_zipcode.focus();
			     });
			  return;
		}
		if(c_mem_address==''){
			//alert('이름을 입력하세요');
			Swal.fire(
				{
					html:'<h4>주소를 입력하세요</h4>',
					icon:'info',
					returnFocus:false
				 }
			     ).then(function(){
				 	f.c_mem_address.value='';
				 	f.c_mem_address.focus();
			     });
			  return;
		}
		f.action="insert.do";
		f.submit();
	}
</script>
</head>
<body>
<form>
	<div id="box">
		<div class="panel panel-primary">
		    <div class="panel-heading"><h4>회원가입</h4></div>
		    <div class="panel-body">
		    </div>
		    <table class="table">
			    <tr>
					<th>이름</th>
					<td><input name="c_mem_name"></td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input name="c_mem_id" id="c_mem_id"><span id="id_msg"></span></td>
					<!-- 네임태그는 서버 아이디는 클라이언트에서 사용 -->
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="c_mem_pwd" id="c_mem_pwd"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="c_mem_pwd2" id="c_mem_pwd2"><span id="id_msg2"></span></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input name="c_mem_zipcode" id="c_mem_zipcode">
					<input type="button" value="주소검색" onclick="find_address();">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input name="c_mem_address" id="c_mem_address" size="60">
					</td>
				</tr>
				<tr>
					<th>충전기 타입</th>
					<td>
					<select name="c_mem_chargertype">
		        		<option value="01">DC차데모</option>
		        		<option value="02">AC완속</option>
		        		<option value="03">DC차데모+AC3상</option>
		        		<option value="04">DC콤보</option>
		        		<option value="05">DC차데모+DC콤보</option>
		        		<option value="06">DC차데모+AC3상+DC콤보</option>
	    	   		</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input class="btn btn-primary" type="button"  value="회원가입" id="btn_join" disabled="disabled" 
                            onclick="send(this.form);">
	                    <input  class="btn btn-danger"  type="button"  value="목록보기" onclick="location.href='list.do'" >
					</td>
				</tr>
			</table>
		</div>
	</div>
	</form>
</body>
</html>