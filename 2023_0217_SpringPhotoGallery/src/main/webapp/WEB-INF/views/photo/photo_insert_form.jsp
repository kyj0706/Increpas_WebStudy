<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      width: 500px;
      margin: auto;
      margin-top: 50px;
  }
  
  textarea {
	  width: 100%;
	  resize: none;
  }
</style>


<script type="text/javascript">

  function  send(f){
	  
	  var p_title   = f.p_title.value.trim();
	  var p_content = f.p_content.value.trim();
	  var photo     = f.photo.value;
	  
	  if(p_title==''){
		  
		  alert("제목을 입력하세요!!");
		  f.p_title.value='';
		  f.p_title.focus();
		  return;
	  }
	  
	  if(p_content==''){
		  
		  alert("내용을 입력하세요!!");
		  f.p_content.value='';
		  f.p_content.focus();
		  return;
	  }
	  
	  if(photo==''){
		  alert("사진을 선택하세요!!");
		  return;
	  }
	  
	  f.action = "insert.do"; //PhotoInsertAction
	  f.submit();
	  
	  
  }


</script>



</head>
<body>

<!-- 화일업로드시 form속성 : 아래참조 -->
<form method="POST"  enctype="multipart/form-data">   
   <div id="box">
        <div class="panel panel-primary">
		      <div class="panel-heading"><h4>사진등록</h4></div>
		      <div class="panel-body">
		          <table class="table">
                      <tr>
                          <th>제목</th>
                          <td><input name="p_title"></td>
                      </tr>
                      
                      <tr>
                          <th>내용</th>
                          <td>
                             <textarea name="p_content" rows="5" cols=""></textarea>
                          </td>
                      </tr>
                      
                      <tr>
                          <th>사진</th>
                          <td><input type="file"  name="photo"></td>
                      </tr>
                      
                      <tr>
                          <td colspan="2" align="center">
                              <input class="btn btn-primary"  type="button"  value="등록하기" 
                                     onclick="send(this.form);">
                              <input class="btn btn-warning"  type="reset"   value="취소하기">
                              <input class="btn btn-success"  type="button"  value="메인화면" 
                                     onclick="location.href='list.do'">
                          </td>
                      </tr>
                      		             
		          </table>
		      </div>
		</div>
   </div>
</form>
  
</body>
</html>