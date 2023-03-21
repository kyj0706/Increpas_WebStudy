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
	  var photo1 = f.photo[0].value;
	  var photo2 = f.photo[1].value;
	  
	  if(title==''){
		  alert('제목을 입력하세요');
		  f.title.value='';
		  f.title.focus();
		  return;
	  }
	  
	  if(photo1==''){
		  alert('사진1을 선택하세요');
		  return;
	  }
	  
	  if(photo2==''){
		  alert('사진2을 선택하세요');
		  return;
	  }
	  
	  f.action = "upload3.do";
	  f.submit();
  }
  
  

</script>

</head>
<body>

<form method="POST"  enctype="multipart/form-data">
  <div>
     제목:<input name="title">
  </div>
  
  <!-- spring fileupload시에는 복수개의 화이업로드시 
       parameter명은 동일하게 부여해야 한다 -->
  <div>
     사진1:<input type="file" name="photo">
  </div>
  <div>
     사진2:<input type="file" name="photo">
  </div>
  <div>
     <input type="button" value="멀티화일전송" onclick="send1(this.form);">  
  </div>
</form>

</body>
</html>