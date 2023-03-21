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
	
	th{
		text-align: center;
	}
	
	#mem_sign_up {
		margin-bottom: 5px;
		
	}
	
	#title{
		text-align: center;
		font-size: 50px;
		color: blue;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	
	}
	#id_msg{
		display: inline-block;
		width: 250px;
		margin-left: 20px;
		
	}
	
	
</style>



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
		
		
		//수정 확인 작업
		
		
		
		
		
		f.action = "modify.do";
		f.submit();
		
	}


</script>

<script type="text/javascript">

	//jQuery 초기화  
	//↓(축약) $(document).ready(function(){}); 랑 같은 의미 
	$(function() {
		
		$("#mem_grade").val('${vo.mem_grade}');
		
		
	});


</script>



</head>
<body>
<form>
<input type="hidden" name="mem_idx" value="${vo.mem_idx }">
<div id="box">
	  <h2 id="title">::::회원수정::::</h2>
	  <br>
<div class="panel panel-info">
      <div class="panel-heading">
     	 <span class="glyphicon glyphicon-th-list"> 회원정보</span>
      </div>
      <div class="panel-body">
      	<table class="table table-striped table-bordered table-hover" border="1">
      		<tr>
      			<th>이름</th>
      			<td><input type="text" name="mem_name" value="${vo.mem_name }"></td>
      		</tr>
      		<tr>
      			<th>아이디</th>
      			<td><input type="text" name="mem_id" id="mem_id" readonly="readonly" value="${vo.mem_id }"> </td>
      		</tr>
      		<tr>
      			<th>비밀번호</th>
      			<td><input type="password" name="mem_pwd" value="${vo.mem_pwd }"></td>
      		</tr>	
      		<tr>
      			<th>우편번호</th>
      			<td>
      				<input type="text" name="mem_zipcode" id="mem_zipcode" value="${vo.mem_zipcode }">
      				<input type="button" value="주소검색" onclick="find_address();">
      			
      			 </td>
      		</tr>
      		<tr>
      			<th>주소</th>
      			<td><input type="text" name="mem_address" id="mem_address" size="60" value="${vo.mem_address }"></td>
      		</tr>
      		<tr>
      			<th>등급수정</th>
      			<td>
      			<c:if test="${user.mem_grade eq '관리자' }">
      				<select name="mem_grade" id="mem_grade">
		 				<option value="일반">일반</option>
		 				<option value="관리자">관리자</option>
		 			</select>
      			</c:if>
      			<c:if test="${user.mem_grade ne '관리자' }">
      				<input style="border:none; background: none;" name="mem_grade" id="mem_grade" readonly="readonly">
      			</c:if>
      			
      			
      			
      			</td>
      		</tr>
			<tr>			
      			<th colspan="2">
      				<input class="btn btn-info" type="button" value="정보수정" id="btn_join" onclick="send(this.form);">
      				<input class="btn btn-default" type="button" value="돌아가기" onclick="location.href='list.do'">
      			</th>
      		</tr>
      	</table>
      </div>
</div>
</div>
</form>
</body>
</html>