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

<!-- sweetalert2 사용설정 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>  
 
<!-- CKEditor 사용설정 -->
<script src="//cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

<script type="text/javascript">

 var toolbar = [
		/*
	    { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'forms' },
		'/', 
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'links' },
		{ name: 'insert' },
		'/', */
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'tools' },
		{ name: 'insert' }/*,
		{ name: 'others' },
		{ name: 'about' }*/
		
		
	] ;

</script> 
  
<style type="text/css">
  #box{
      width: 700px;
      margin: auto;
      margin-top: 30px;
  }
  
  textarea {
	  width: 100%; 
	  resize: none;
  }
  
</style>

<script type="text/javascript">
  function send(f){
	  
	  var name    = f.name.value.trim();
	  //var content = f.content.value.trim();
	  //CKEditor값 체크
	  var content = CKEDITOR.instances.content.getData().trim();
	  
	  var pwd     = f.pwd.value.trim();
	  
	  if(name==''){
		  //alert('이름을 입력하세요');
		  
		  Swal.fire(
			  {
				  html:'<h4>이름을 입력하세요</h4>',
				  icon:'info',
				  returnFocus:false,
				  confirmButtonText: '확인'
			  }
		  ).then(function(){
			  f.name.value='';
			  f.name.focus();
		  });
		  		  
		  return;
	  }
	  
	  if(content==''){
		  
		  Swal.fire(
			  {
				  html:'<h4>내용을 입력하세요</h4>',
				  icon:'info',
				  returnFocus:false
			  }
		  ).then(function(){
			  f.content.value='';
			  f.content.focus();
		  });
	
		  return;
	  }
	  
	  
	  if(pwd==''){
		  
		  Swal.fire(
			  {
				  html:'<h4>비밀번호를 입력하세요</h4>',
				  icon:'info',
				  returnFocus:false
			  }
		  ).then(function(){
			  f.pwd.value='';
			  f.pwd.focus();
		  });
			  
		
		  
		  return;
	  }
	  	  
	  
	  f.action = "insert.do";// VisitInsertAction
	  f.submit();//전송
	  
	  
  }

</script>


</head>
<body>

<%-- 현재 Context경로 : ${ pageContext.request.contextPath } <br> --%>

<form>
  <div id="box">
      <div class="panel panel-primary">
	      <div class="panel-heading"><h4>방명록 글쓰기</h4></div>
	      <div class="panel-body">
	          <table class="table">
	              <tr>
	                  <th width="100">작성자</th>
	                  <td><input name="name"></td>
	              </tr>
	              <tr>
	                  <th>내용</th>
	                  <td>
	                      <textarea  name="content" rows="5" cols="50"></textarea>
	                      <script>
								// Replace the <textarea id="editor1"> with a CKEditor
								// instance, using default configuration.
								CKEDITOR.replace( 'content', {
										filebrowserUploadUrl: '${pageContext.request.contextPath}/ckeditorImageUpload.do',
										enterMode:CKEDITOR.ENTER_BR,
										shiftEnterMode: CKEDITOR.ENTER_P,
										toolbarGroups : toolbar
								});
								
									
								CKEDITOR.on('dialogDefinition', function( ev ){
							           var dialogName = ev.data.name;
							           var dialogDefinition = ev.data.definition;
							         
							           switch (dialogName) {
							               case 'image': //Image Properties dialog
							                   //dialogDefinition.removeContents('info');
							                   dialogDefinition.removeContents('Link');
							                   dialogDefinition.removeContents('advanced');
							                   break;
							           }
							       });
							</script>
	                      
	                  </td>
	              </tr>
	              <tr>
	                  <th>비밀번호</th>
	                  <td><input type="password" name="pwd"></td>
	              </tr>
	              
	              <tr>
	                  <td colspan="2" align="center">
	                      <input class="btn  btn-primary" type="button"  value="글올리기" 
	                             onclick="send(this.form);">
	                      <input class="btn  btn-success" type="button"  value="목록보기" 
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