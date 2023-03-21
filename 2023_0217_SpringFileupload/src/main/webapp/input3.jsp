<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
  
  function send1(f){
	  
	  var title = f.title.value.trim();
	 
	  
	  if(title==''){
		  alert('제목을 입력하세요');
		  f.title.value='';
		  f.title.focus();
		  return;
	  }
	  
	  if(f.photo.files.length==0){
		  alert('사진을 선택하세요');
		  return;
	  }
	  
	   
	  f.action = "upload4.do";
	  f.submit();
  }
  
  

</script>

</head>
<body>

<form method="POST"  enctype="multipart/form-data">
  <div>
     제목:<input name="title">
  </div>
 
  <div>
     사진:<input type="file" name="photo" multiple="multiple">
  </div>
  
  <div>
     <input type="button" value="n개의 멀티화일전송" onclick="send1(this.form);">  
  </div>
</form>

</body>
</html>