<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<style type="text/css">
   #box{
       width: 400px;
       margin: auto;
       margin-top: 100px;
   }
   
   input[type='button']{
       width: 80px;
   }
</style>

<script type="text/javascript">
 
   function  send(f){
	   
	   var mem_id  = f.mem_id.value.trim();
	   var mem_pwd = f.mem_pwd.value.trim(); 
	   
	   if(mem_id == ''){
		   alert('아이디를 입력하세요!!');
		   f.mem_id.value='';
		   f.mem_id.focus();
		   return;
	   }
	   
	   if(mem_pwd == ''){
		   alert('비밀번호를 입력하세요!!');
		   f.mem_pwd.value='';
		   f.mem_pwd.focus();
		   return;
	   }
	   
	   f.action = "login.do"; //MemberLoginAction
	   f.submit();
	   
   }

</script>
 
  
<script type="text/javascript">

  $(document).ready(function(){
	  //0.1초후에 호출
	  setTimeout(show_message,100);
	  
  });

  function show_message(){
	  
	  
	  if("${ param.reason eq 'fail_id' }" == "true" ){
		  alert("아이디가 틀렸습니다");
	  }
	  
	  if("${ param.reason eq 'fail_pwd' }" == "true" ){
		  alert("비밀번호가 틀렸습니다");
	  }
	  
	  if("${ param.reason eq 'logout' }" == "true" ){
		  alert("로그아웃되었습니다\n로그인 하신후 등록하세요!!");
	  }
	  
  }

</script>  
  

</head>
<body>
<form>
<input type="hidden" name="url" value="${param.url }">
  <div id="box">
     <div class="panel panel-primary">
	    <div class="panel-heading">로그인</div>
	    <div class="panel-body">
	        <table class="table">
	            <tr>
	               <th>아이디</th>
	               <td><input name="mem_id"  value="${ param.mem_id }"></td>
	            </tr>
	            <tr>
	               <th>비밀번호</th>
	               <td><input type="password" name="mem_pwd"></td>
	            </tr>
	            <tr>
	               <td colspan="2" align="center">
	                   <input class="btn  btn-primary" type="button"  value="로그인"   
	                          onclick="send(this.form);">
	                   <input class="btn  btn-success" type="button"  value="메인화면" 
	                          onclick="location.href='../board/list.do'">
	                   <input class="btn  btn-info"    type="button"  value="회원가입" 
	                          onclick="location.href='insert_form.do'">
	               </td>
	            </tr>
	        </table>
	    </div>
	 </div>
  </div>
</form>
</body>
</html>