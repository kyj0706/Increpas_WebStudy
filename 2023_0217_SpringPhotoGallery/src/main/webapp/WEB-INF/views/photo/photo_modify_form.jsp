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
  
  img#my_img{
      width: 200px;
  }
</style>


<script type="text/javascript">

  function  send(f){
	  
	  var p_title   = f.p_title.value.trim();
	  var p_content = f.p_content.value.trim();
	  
	  
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
	 
	 
	  
	  f.action = "modify.do"; //PhotoModifyAction
	  f.submit();
  }
</script>

<script type="text/javascript">
  function ajaxFileUpload(){
	  //업로드용 폼안에 있는 ajaxFile 버튼 클릭
	  $("#ajaxFile").click();
  } 
  
  function ajaxFileChange(){
	  
	  //alert('이미지 교체..');
	  var photo = $("#ajaxFile")[0].files[0];
	  
	  if(photo==undefined) return;
	  
	  //console.log(photo);
	  //alert(photo.name);
	  
	  //서버로 전송
	  //1.전송데이터 포장
	  var form     = $("#ajaxForm")[0];
	  var formData = new FormData(form);
	  formData.append("p_idx", "${ vo.p_idx }");
	  formData.append("photo",photo);
	  
	  //2.ajax로 전송(요청)
	  $.ajax({
		  url			: "photo_upload.do",   //PhotoUploadAction
		  type			: "POST",
		  data			: formData,            //photo_upload.do?p_idx=3&photo=a.jpg
		  processData	: false,
		  contentType	: false,
		  dataType		: "json",
		  success		: function(result){
			  //result = {"p_filename": "a.jpg"}
			  //result = {"p_filename": "no_file"}
			  
			  //방법1)
			  //새로고침: location.href=""  =>자신의 페이지를 호출함
			  //location.href="";
			  
			  //방법2)
			  $("#my_img").attr("src","../resources/upload/" + result.p_filename);
		  },
		  error			: function(err){
			  alert(err.responseText);
		  }
	  });

  }

</script>



</head>
<body>

<!-- 화일업로드용 폼 -->
<form id="ajaxForm"  method="POST"  enctype="multipart/form-data"  >
   <!-- 화일선택버튼 숨기기 -->
   <input  style="display:none;"  type="file"  id="ajaxFile" onchange="ajaxFileChange();">
</form>


<form>  
   <input type="hidden" name="p_idx"  value="${ vo.p_idx }"> 
   <div id="box">
        <div class="panel panel-primary">
		      <div class="panel-heading"><h4>정보수정</h4></div>
		      <div class="panel-body">
		          <table class="table">
		              <tr>
		                  <td colspan="2" align="center">
		                      <img src="../resources/upload/${ vo.p_filename }" id="my_img">
                              <br>
                              <br>
                              <input class="btn btn-info"  type="button"  value="이미지편집"  
                                     onclick="ajaxFileUpload();">  		                  
		                  </td>
		              </tr>  
		          
		          
                      <tr>
                          <th>제목</th>
                          <td><input name="p_title"  value="${ vo.p_title }"></td>
                      </tr>
                      
                      <tr>
                          <th>내용</th>
                          <td>
                             <textarea name="p_content" rows="5" cols="">${ vo.p_content }</textarea>
                          </td>
                      </tr>
                      
                      
                      <tr>
                          <td colspan="2" align="center">
                              <input class="btn btn-primary"  type="button"  value="수정하기" 
                                     onclick="send(this.form);">
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