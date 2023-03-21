<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>  
<style type="text/css">

   #box{
		position: relative;
		width: 1100px;
		height: 700px;
		display: flex;
		background: #F5F5F5;
		margin: 0px auto;
   }
   
   #box2{

   }
   /* 메인 이미지 */
   #img1{
   		width: 100%;
		height: 700px;
		float: right;
   }
   
   #box3{
   }
   
   #box2, #box3{
   		flex: 1;
   }
   
   #img2>img{
   		width: 60px;
		height: 100%;
   }
   
   /* 프로젝트 이름 */
   .fpname{
		font-family: 'KCC-Ganpan';
   		src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2') format('woff2');
		font-weight: 400;
		font-size: 18px;
		line-height: 28px;
		
		position: absolute;
		width: 350px;
		height: 30px;
		left: 636px;
		top: 64px;
	}
	
	.fpname:hover{
		color: #5D5D5D;
	}
	
	.ctext{
		position: absolute;
		width: 282px;
		height: 52px;
		left: 640px;
		top: 160px;
		
		font-family: 'NotoSerifKR';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NotoSerifKR.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;

		font-size: 30px;
		line-height: 52px;
	}
	
	.ctext2{
		position: absolute;
		width: 434px;
		height: 28px;
		left: 640px;
		top: 210px;
		
		font-family: 'Space Grotesk';
		font-style: normal;
		font-weight: 400;
		font-size: 16px;
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
		width: 380px;
		height: 50px;
		left: 640px;
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
		width: 380px;
		height: 50px;
		left: 640px;
		top: 380px;
		
		border-bottom: 1px solid #E0E0E0;
	}
	
	#forgotpwd{
		position: absolute;
		width: 138px;
		height: 22px;
		left: 900px;
		top: 450px;
		font-family: 'Space Grotesk';
		font-style: normal;
		font-weight: 400;
		font-size: 15px;
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
		width: 380px;
		height: 60px;
		left: 640px;
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
		left: 765px;
		top: 600px;
		
	}
	
	#join{
		background-color: rgba(0,0,0,0);
		border: none;
		text-decoration-line: underline;
		
	}
	
	#join:hover {
		color: #8C8C8C;
	}
  
  th{
  	width: 100px;
  
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
<!-- 헤더 -->
<header>
	<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
</header>
<!-- 메뉴 -->
<nav>
	<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
</nav>


<div id="box" style="margin-bottom: 50px;">
	<form>
	  <input type="hidden" name="url" value="">
	  	 <div id="box2">
	  	 <span id="img1"><img src="../resources/images/image1.png"></span>
	  	 </div>
	  		
	  		<div class="fpname">
	  			<a href="../main/list.do"><span id="img2"><img src="../resources/images/loginlogo.png"></span></a>
	  			<input type="button" style="background:#F5F5F5; border:0px solid black"
	  			 value="Electric Car Charging Station" onclick="location.href='../main/list.do'"></div>
			<div class="ctext">LOG IN</div>
			<div class="ctext2">Welcome back! Please enter your details.</div>
		        <table class="tb">
		            <tr id="c_mem_id">
		               <th>ID</th>
		               <td><input class="form-control "  name="c_mem_id" value="${ param.c_mem_id }" ></td>
		            </tr>
		            <tr id="c_mem_pwd">
		               <th>PASSWORD</th>
		               <td><input  class="form-control" type="password" name="c_mem_pwd" ></td>
		            </tr>
		            <tr id="forgotpwd">
		            	<th>Forgot Password</th>
		            </tr>
		            <tr class="login">
		               <td>
		                   <input type="button" value="LOG IN" style="background-color: rgba(0,0,0,0); color:#FFFFFF; width:380px; height: 60px;"
		                          onclick="send(this.form);">
		               </td>
		            </tr>
		            <tr class="join">
		               <td>
		                   <!-- <input class="btn" type="button"  value="목록보기" 
		                          onclick="location.href='list.do'"> -->
		                   Don’t have an account?
		                   <input id="join" type="button"  value="Sign up for free"
		                          onclick="location.href='insert_form.do'">
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