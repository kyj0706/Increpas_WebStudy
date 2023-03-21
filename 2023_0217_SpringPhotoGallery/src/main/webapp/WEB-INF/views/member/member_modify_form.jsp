<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- 우편번호 검색 --> 
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
  
<style type="text/css">
  #box{
      width: 600px;
      margin: auto;
      margin-top: 50px;
  }
  
</style>  



<script type="text/javascript">
   
   function find_address(){
	   
	   new daum.Postcode({
	        oncomplete: function(data) {
	            //data = { "zonecode":12345 ,"address":"서울시 관악구","roadAddress":"",... }
	        	
	            $("#mem_zipcode").val(data.zonecode);
	            $("#mem_address").val(data.address);
	        	
	        }
	    }).open();
	   
   }
</script>


<script type="text/javascript">
   
   function send(f){
	   
	   //입력값 체크..
	   var mem_name 	= f.mem_name.value.trim();
	   var mem_pwd  	= f.mem_pwd.value.trim();
	   var mem_zipcode  = f.mem_zipcode.value.trim();
	   var mem_address  = f.mem_address.value.trim();
	   
	   if(mem_name==''){
		   alert('이름을 입력하세요!!');
		   f.mem_name.value='';
		   f.mem_name.focus();
		   return;
	   }
	   
	   if(mem_pwd==''){
		   alert('비밀번호를 입력하세요!!');
		   f.mem_pwd.value='';
		   f.mem_pwd.focus();
		   return;
	   }
	   
	   if(mem_zipcode==''){
		   alert('우편번호를 입력하세요!!');
		   f.mem_zipcode.value='';
		   f.mem_zipcode.focus();
		   return;
	   }
	   
	   if(mem_address==''){
		   alert('주소를 입력하세요!!');
		   f.mem_address.value='';
		   f.mem_address.focus();
		   return;
	   }
	   
	   //수정확인
	   if(confirm("정말 수정하시겠습니까?")==false) return;
	   
	   
	   f.action="modify.do";//  MemberModifyAction
	   f.submit();
   }

</script>


<script type="text/javascript">

   //jQuery초기화: $(document).ready(function(){});
   $(function(){
	   //id="mem_grade"
	   $("#mem_grade").val('${ vo.mem_grade }');
	   	   
   });

</script>


</head>
<body>

<form>
  <input type="hidden"  name="mem_idx"  value="${ vo.mem_idx }">
  <div id="box">
    <div class="panel panel-primary">
      <div class="panel-heading"><h4>회원수정</h4></div>
      <div class="panel-body">
         <table class="table">
             <tr>
                <th>이름</th>
                <td><input name="mem_name"  value="${ vo.mem_name }"></td> 
             </tr>
             <tr>
                <th>아이디</th>
                <td><input name="mem_id"  value="${ vo.mem_id }"  readonly="readonly"></td> 
             </tr>
             <tr>
                <th>비밀번호</th>
                <td><input type="password" name="mem_pwd" value="${ vo.mem_pwd }"></td> 
             </tr>  
             
             <tr>
                <th>우편번호</th>
                <td>
                    <input name="mem_zipcode" id="mem_zipcode"  value="${ vo.mem_zipcode }">
                    <input type="button"  value="주소검색" onclick="find_address();">
                </td> 
             </tr> 
             
             <tr>
                <th>주소</th>
                <td><input name="mem_address" id="mem_address" size="60"  value="${ vo.mem_address }"></td> 
             </tr>
             
             <tr>
                <th>회원등급</th>
                <td>
                    <!-- 관리자면 : equal -->
                    <c:if test="${ user.mem_grade eq '관리자' }">
	                    <select name="mem_grade" id="mem_grade">
	                       <option value="일반">일반</option>
	                       <option value="관리자">관리자</option>
	                    </select>
                    </c:if>
                    
                    <!-- 관리자가 아니면 : not equal -->
                    <c:if test="${ user.mem_grade ne '관리자' }">
                        <input name="mem_grade" id="mem_grade"  readonly="readonly">
                    </c:if>
                </td>
             </tr>
             
             
             <tr>
                <td colspan="2" align="center">
                     <input class="btn btn-primary" type="button"  value="회원수정" 
                            onclick="send(this.form);">
                     <input class="btn btn-success" type="button"  value="목록보기"
                            onclick="location.href='../photo/list.do'" >
                </td> 
             </tr>
                          
         </table>
      </div>
	</div>
  </div>
</form>

</body>
</html>