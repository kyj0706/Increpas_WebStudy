<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

 function send1(f){
	 
	 var name = f.name.value.trim();
	 var age  = f.age.value.trim();
	 var tel  = f.tel.value.trim();
	 
	 if(name==''){
		 alert('이름을 입력하세요');
		 f.name.value='';
		 f.name.focus();
		 return;
	 }
	 
	 if(age==''){
		 alert('나이를 입력하세요');
		 f.age.value='';
		 f.age.focus();
		 return;
	 }
	 
	 if(tel==''){
		 alert('전화번호를 입력하세요');
		 f.tel.value='';
		 f.tel.focus();
		 return;
	 }
	 
	 f.action = "insert1.do";
	 f.submit();//전송
	 	 
	 
 }

</script>
<script type="text/javascript">

 function send2(f){
	 
	 var name = f.name.value.trim();
	 var age  = f.age.value.trim();
	 var tel  = f.tel.value.trim();
	 
	 if(name==''){
		 alert('이름을 입력하세요');
		 f.name.value='';
		 f.name.focus();
		 return;
	 }
	 
	 if(age==''){
		 alert('나이를 입력하세요');
		 f.age.value='';
		 f.age.focus();
		 return;
	 }
	 
	 if(tel==''){
		 alert('전화번호를 입력하세요');
		 f.tel.value='';
		 f.tel.focus();
		 return;
	 }
	 
	 f.action = "insert2.do";
	 f.submit();//전송
	 	 
	 
 }

</script>

<script type="text/javascript">

 function send3(f){
	 
	 var name = f.name.value.trim();
	 var age  = f.age.value.trim();
	 var tel  = f.tel.value.trim();
	 
	 if(name==''){
		 alert('이름을 입력하세요');
		 f.name.value='';
		 f.name.focus();
		 return;
	 }
	 
	 if(age==''){
		 alert('나이를 입력하세요');
		 f.age.value='';
		 f.age.focus();
		 return;
	 }
	 
	 if(tel==''){
		 alert('전화번호를 입력하세요');
		 f.tel.value='';
		 f.tel.focus();
		 return;
	 }
	 
	 f.action = "insert3.do";
	 f.submit();//전송
	 	 
	 
 }

</script>





</head>
<body>
	<form>
	   <div>
	      <label>이름</label>
	      <input type="text"  name="name" value="일길동">
	   </div>
	   <div>
	      <label>나이</label>
	      <input type="text"  name="age"  value="30">
	   </div>
	   <div>
	      <label>전화</label>
	      <input type="text"  name="tel"  value="010-111-1234">
	   </div>
	   <hr>
	   <div style="text-align: left;">
	       <input type="button"  value="낱개로  받기" onclick="send1(this.form);"> 
	       <input type="button"  value="객체로  받기" onclick="send2(this.form);"> 
	       <input type="button"  value="Map으로 받기" onclick="send3(this.form);"> 
	   </div>
	   
	</form>
</body>
</html>