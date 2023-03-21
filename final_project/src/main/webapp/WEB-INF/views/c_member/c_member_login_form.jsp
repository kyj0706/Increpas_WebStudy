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
<style type="text/css">

   #box1{
		position: absolute;
		width: 1400px;
		height: 700px;
		display: flex;
		background: #F5F5F5;
   }
   

   
   table{

   }
   
   #box2{
		width: 300px;
		position: center;
   }
   /* 메인 이미지 */
   #box2 > #img1>img{
		height: 700px;
		width: 700px;
		float:right;
		
   }
   
   #box3{
	   	width: 300px;
   }
   
    #box2, #box3{
   		flex: 1;
   }
   /* 프로젝트 이름 */
   .fpname{
		font-style: normal;
		font-weight: 700;
		font-size: 24px;
		line-height: 33px;
		
		display: flex;
		flex-direction: row;
		align-items: center;
		padding: 0px;
		gap: 8px;
		
		position: absolute;
		width: 166px;
		height: 33px;
		left: 860px;
		top: 64px;
		
	}
	.ctext{
		position: absolute;
		width: 282px;
		height: 52px;
		left: 860px;
		top: 160px;
		
		font-family: 'Manrope';
		font-style: normal;
		font-weight: 800;
		font-size: 32px;
		line-height: 52px;
	}
	
	.ctext2{
		position: absolute;
		width: 434px;
		height: 28px;
		left: 863px;
		top: 216px;
		
		font-family: 'Space Grotesk';
		font-style: normal;
		font-weight: 400;
		font-size: 18px;
		line-height: 28px;
		
	}
	
	#c_mem_id{
		box-sizing: border-box;

		/* Auto layout */
		
		display: flex;
		flex-direction: row;
		align-items: flex-start;
		padding: 11px 0px;
		gap: 8px;
		
		position: absolute;
		width: 430px;
		height: 50px;
		left: 863px;
		top: 328px;
		
		border-top: 1px solid #E0E0E0;
		border-bottom: 1px solid #E0E0E0;
	}
	
	#c_mem_pwd{
		box-sizing: border-box;

		/* Auto layout */
		
		display: flex;
		flex-direction: row;
		align-items: flex-start;
		padding: 11px 0px;
		gap: 8px;
		
		position: absolute;
		width: 430px;
		height: 50px;
		left: 863px;
		top: 380px;
		
		border-bottom: 1px solid #E0E0E0;
	}
	
	#forgotpwd{
		position: absolute;
		width: 138px;
		height: 22px;
		left: 1151px;
		top: 467px;
		font-family: 'Space Grotesk';
		font-style: normal;
		font-weight: 400;
		font-size: 17px;
		line-height: 22px;
		/* identical to box height */
		
		text-decoration-line: underline;
	}
	
	.login{
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		padding: 20px 36px;
		gap: 8px;
		
		position: absolute;
		width: 430px;
		height: 66px;
		left: 863px;
		top: 516px;
		
		background: #060606;
		border-radius: 6px;

	}
	
	.join{
		display: flex;
		flex-direction: row;
		align-items: flex-start;
		padding: 0px;
		gap: 8px;
		
		position: absolute;
		width: 350px;
		height: 23px;
		left: 903px;
		top: 620px;
	}
  
   
</style>  

<script type="text/javascript">
 
   function  send(f){
	   
	   var c_mem_id  = f.c_mem_id.value.trim();
	   var c_mem_pwd = f.c_mem_pwd.value.trim(); 
	   
	   if(c_mem_id == ''){
		   Swal.fire({ 
		          title:'ID를 입력하세요',
		          html:'ID를 정확히 입력해주세요',
		          icon:'info',
		          returnFocus:false
		        }
			).then(function(){
				//확인버튼 누른후 처리
				f.c_mem_id.value='';
				f.c_mem_id.focus();
			});
			   //f.mem_id.value='';
			   //f.mem_id.focus();
			   return;
		   }
	   
	   if(c_mem_pwd == ''){
		   Swal.fire({ 
		          title:'비밀번호를 입력하세요',
		          html:'비밀번호를 정확히 입력해주세요',
		          icon:'info',
		          returnFocus:false
		        }
			).then(function(){
				//확인버튼 누른후 처리
				f.c_mem_pwd.value='';
				f.c_mem_pwd.focus();
			});
			   //f.mem_id.value='';
			   //f.mem_id.focus();
			   return;
	   }
	   
	   f.action = "login.do"; //MemberLoginAction
	   f.submit();
	   
   }

</script>
<script type="text/javascript">
	$(document).ready(function(){
		  //0.1초후에 호출
		  setTimeout(show_msg,100);
		  
	});
	function show_msg() {
		 if("${ param.reason eq 'fail_id' }" == "true" ){
			  alert("아이디가 틀렸습니다");
		  } 
		 if("${ param.reason eq 'fail_pwd' }" == "true" ){
			  alert("비밀번호가 틀렸습니다");
		  }
		 if("${ param.reason eq 'logout' }" == "true" ){
			  alert("로그아웃되었습니다\n로그인 하신후 글을 등록하세요!!");
		  }
	}
</script>

</head>
<body>
<div id="box1" style="margin: auto;">
	  <input type="hidden" name="url" value="">
		  	 <div id="box2">
					
		  	 <span id="img1"><img src="../resources/image/image1.png"></span>
		  	 </div>
	  	   	 
	  	<div id="box3">
	  		
	  		<div class="fpname">project name</div>
			<div class="ctext">Welcome back,</div>
			<div class="ctext2">Welcome back! Please enter your details.</div>
		        <table class="tb">
		            <tr id="c_mem_id">
		               <th>ID</th>
		               <td><input name="c_mem_id"  value="${ param.c_mem_id }"></td>
		            </tr>
		            <tr id="c_mem_pwd">
		               <th>PASSWORD</th>
		               <td><input type="password" name="c_mem_pwd"></td>
		            </tr>
		            <tr id="forgotpwd">
		            	<th>Forgot Password</th>
		            </tr>
		            <tr class="login">
		               <td>
		                   <input type="button" value="Log in"
		                          onclick="send(this.form);">
		               </td>
		            </tr>
		            <tr class="join">
		               <td>
		                   <!-- <input class="btn" type="button"  value="목록보기" 
		                          onclick="location.href='list.do'"> -->
		                   Don’t have an account?
		                   <input type="button"  value="Sign up for free"
		                          onclick="location.href='insert_form.do'">
		               </td>
		            </tr>   
		            
		        </table>
		</div>
</div>
</body>
</html>