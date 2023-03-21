<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/c_board.css">

<meta charset="UTF-8">
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
	];
</script> 
<script type="text/javascript">
	function send(f){
		var c_b_subject = f.c_b_subject.value.trim();
		var c_b_content = CKEDITOR.instances.c_b_content.getData().trim();
		
		if(c_b_subject==''){
			alert('제목을 입력하세요!');
			f.c_b_subject.value='';
			f.c_b_subject.focus();
			return;
		   }
		if(c_b_content==''){
			alert('내용을 입력하세요!');
			f.c_b_content.value='';
			f.c_b_content.focus();
			return;
		   }
		f.action="insert.do";
		f.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="hidden"  name="c_mem_idx"  value="${ user.c_mem_idx }">
		<input type="hidden"  name="c_mem_name" value="${ user.c_mem_name }">
		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">글쓰기</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>제목</th>
							<td><input name="c_b_subject"></td>
						</tr>

						<tr>
							<th>내용</th>
							<td>
								<textarea rows="5" cols="50" name="c_b_content"></textarea>
								<script>
								// Replace the <textarea id="editor1"> with a CKEditor
								// instance, using default configuration.
								CKEDITOR.replace( 'c_b_content', {
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
							<td colspan="2" align="center">
								<input  class="btn btn-primary" type="button"  value="글올리기"
				                      onclick="send(this.form);">
				              <input  class="btn btn-success" type="button"  value="목록보기" 
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