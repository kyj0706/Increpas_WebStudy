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
	    width: 650px;
	    margin: 0px auto;
	    margin-top: 100px;

	    border-radius: 8px;
	    background: #F5F5F5;
	}
	

	th{
		padding-right: 12px;
	    font-family: 'NanumSquareNeo-Variable';
	    font-weight: normal;
	    font-style: normal;
	}
	
	 #img2>img{
   		width: 60px;
		height: 35px;
   }

	#box2{
		padding-top: 16px;
		padding-bottom: 8px;
	    margin-left: 20px;
	    width: 600px;
	    font-size: 20px;
	    border-bottom: 1px solid #E0E0E0;
	}

	#id_msg{
		display: inline-block;
		width: 250px;
		margin-left: 15px;
	}
	
	#id_msg2{
		display: inline-block;
		width: 250px;
		margin-left: 15px;
	}
	
	.mem_tb{
		height: 420px;
		margin-left: 20px;
	}
	
	#text, .btn1{
	    font-family: 'NanumSquareNeo-Variable';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;	
	}
	
	.btn{
		background: #E7E3EB;
		border: 0px solid black;
		border-radius: 4px;
		margin-right: 2px;
		margin-left: 2px;
		height: 35px;
	}
	
	.btn1{
		background: #E7E3EB;
		border: 0px solid black;
		border-radius: 4px;
		margin-left: 3px;
		width: 75px;
		height: 26px;
	}
	
	.btn:hover, .btn1:hover{
		background: #E1DCE6
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
			   $("#id_msg").html("아이디는 3자리 이상 입력해주세요.")
			   .css("color","#DE4F4F");
			   return;
		   }
		   $("#id_msg").html("");
		   
		   //Ajax로 아이디 사용을 허락받는다 (중복체크)
		   $.ajax({
				url		 : "check_id.do",
				data  	 : { "c_mem_id":c_mem_id } ,
			    dataType : "json",
				success	 : function(result_data){
				   //result_data = {"result": true}
					if(result_data.result==true){
				   		$("#id_msg").html("사용 가능한 아이디입니다.")
						   .css("color","#4375DB");
				   		//가입버튼 활성화
				   		$("#btn_join").attr("disabled", false);
					}else{
						$("#id_msg").html("사용 불가능한 아이디입니다.")
						   .css("color","#DE4F4F");
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
		   /* if($('#c_mem_pwd2').val() != $('#c_mem_pwd').val()){
			   $("#id_msg2").html("비밀번호가 일치하지 않습니다.")
			   .css("color","#DE4F4F");
			   $("#btn_join").attr("disabled", true);
		   }else {
			   $("#id_msg2").html("비밀번호가 일치합니다.")
			   .css("color","#4375DB");
			   $("#btn_join").attr("disabled", false);
		   } */
		   
		   if($('#c_mem_pwd2').val() == $('#c_mem_pwd').val()){
	            $("#id_msg2").html("비밀번호가 일치합니다.")
	            .css("color","#4375DB");
	            $("#btn_join").attr("disabled", true);
	         }
			else if($('#c_mem_pwd2').val() != $('#c_mem_pwd').val()){
	            $("#id_msg2").html("비밀번호가 일치하지 않습니다.")
	            .css("color","#DE4F4F");
	            $("#btn_join").attr("disabled", true);
	         }
			else {
	            $("#id_msg2").html("")
	            .css("color","#FFFFFF");
	            $("#btn_join").attr("disabled", false);
	         }
		   	
   });
	   $("#c_mem_pwd").keyup(function(){
		   var c_mem_pwd2 = $(this).val();
		   //console.log(c_mem_id);
		   /* if($('#c_mem_pwd2').val() != $('#c_mem_pwd').val()){
			   $("#id_msg2").html("비밀번호가 일치하지 않습니다.")
			   .css("color","#DE4F4F");
			   $("#btn_join").attr("disabled", true);
		   }else {
			   $("#id_msg2").html("비밀번호가 일치합니다.")
			   .css("color","#4375DB");
			   $("#btn_join").attr("disabled", false);
		   } */
		   
		   if($('#c_mem_pwd2').val() == $('#c_mem_pwd').val()){
	            $("#id_msg2").html("비밀번호가 일치합니다.")
	            .css("color","#4375DB");
	            $("#btn_join").attr("disabled", true);
	         }
			else if($('#c_mem_pwd2').val() != $('#c_mem_pwd').val()){
	            $("#id_msg2").html("비밀번호가 일치하지 않습니다.")
	            .css("color","#DE4F4F");
	            $("#btn_join").attr("disabled", true);
	         }
			else {
	            $("#id_msg2").html("")
	            .css("color","#FFFFFF");
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
<!-- 헤더 -->
<header>
	<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
</header>
<!-- 메뉴 -->
<nav>
	<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
</nav>

<div id="box" style="margin-top: 50px; margin-bottom: 50px;">
	<form>
		<div id="box2">
		<a href="../main/list.do"><span id="img2"><img src="../resources/images/loginlogo.png"></span></a>
		회원가입</div>
		    <table class="mem_tb">
			    <tr>
					<th id="text">이름</th>
					<td><input class="form-control " name="c_mem_name" id="c_mem_name" size="25"></td>
				</tr>
				<tr>
					<th id="text">ID</th>
					<td><input class="form-control " name="c_mem_id" id="c_mem_id" size="25"><span id="id_msg"></span></td>
					<!-- 네임태그는 서버 아이디는 클라이언트에서 사용 -->
				</tr>
				<tr>
					<th id="text">비밀번호</th>
					<td><input class="form-control " type="password" name="c_mem_pwd" id="c_mem_pwd" size="25"></td>
				</tr>
				<tr>
					<th id="text">비밀번호 확인</th>
					<td><input class="form-control " type="password" name="c_mem_pwd2" id="c_mem_pwd2" size="25"><span id="id_msg2"></span></td>
				</tr>
				<tr>
					<th id="text">우편번호</th>
					<td>
					<input class="form-control " name="c_mem_zipcode" id="c_mem_zipcode" size="25">
					<input class="btn1" type="button" value="주소검색" onclick="find_address();">
					</td>
				</tr>
				<tr>
					<th id="text">주소</th>
					<td><input class="form-control " name="c_mem_address" id="c_mem_address" size="60">
					</td>
				</tr>
				<tr>
					<th id="text">충전기 타입</th>
					<td>
					<select id="text" name="c_mem_chargertype">
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
						<input class="btn" type="button"  value="회원가입" id="btn_join"
                            onclick="send(this.form);">
	                    <input  class="btn"  type="button"  value="로그인" onclick="location.href='../c_member/login_form.do'" >
	                    <input  class="btn"  type="button"  value="홈으로" onclick="location.href='../main/list.do'" >
					</td>
				</tr>
			</table>
		
	</form>
</div>
<footer>
		<jsp:include page="/WEB-INF/views/layout/footer/footer.jsp"></jsp:include>
	</footer>

</body>
</html>