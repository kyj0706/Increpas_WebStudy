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
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
		var c_mem_chargertype = f.c_mem_chargertype.value.trim();
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
				 	f.c_namem_name.focus();
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
				 	f.c_mem_pwd.value='';
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
			    	 c_f.mem_zipcode.value='';
			    	 c_f.mem_zipcode.focus();
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
		if(confirm("정말 수정하시겠습니까?")==false) return;
		f.action="modify.do";
		f.submit();
	}
</script>

</head>
<body>
<form>
	<input type="hidden"  name="c_mem_idx"  value="${ vo.c_mem_idx }">
	<div id="box">
		<div class="panel panel-primary">
		    <div class="panel-heading"><h4>내용 수정</h4></div>
		    <div class="panel-body">
		    </div>
		    <table class="table">
			    <tr>
					<th>이름</th>
					<td><input name="c_mem_name" value="${vo.c_mem_name}"></td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input name="c_mem_id" id="c_mem_id" value="${vo.c_mem_id}" readonly="readonly"></td>
					<!-- 네임태그는 서버 아이디는 클라이언트에서 사용 -->
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="c_mem_pwd" value="${vo.c_mem_pwd}"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input name="c_mem_zipcode" id="c_mem_zipcode" value="${vo.c_mem_zipcode}">
					<input type="button" value="주소검색" onclick="find_address();">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input name="c_mem_address" id="c_mem_address" size="60" value="${vo.c_mem_address}">
					</td>
				</tr>
				<tr>
                <th>회원등급</th>
                <td>
                    <select name="c_mem_grade" id="c_mem_grade">
                       <option value="일반">일반</option>
                       <option value="관리자">관리자</option>
                    </select>
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
	                     <input class="btn btn-primary" type="button"  value="회원수정" 
	                            onclick="send(this.form);">
	                     <input class="btn btn-success" type="button"  value="목록보기"
	                            onclick="location.href='list.do'" >
	                </td> 
             </tr>
			</table>
		</div>
	</div>
	</form>
</body>
</html>