<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩3.4.1 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#box {
		width: 800px;
		margin: auto;
		margin-top: 20px;
	}
	
	textarea{
		width: 100%;
		resize: none;
	}
	
	input[name='b_subject' ]{
		width: 100%;
	}
	
	th{
		text-align: center;
		vertical-align: middle;
	}

</style>
<script type="text/javascript">

	function send(f){
		
		var b_subject = f.b_subject.value.trim();
		var b_content = f.b_content.value.trim();
		
		if (b_subject==''){
			alert("제목을 입력하세요");
			f.b_subject.value='';
			f.b_subject.focus();
			
			
			return;
		}
		
		if (b_content==''){
			alert("내용을 입력하세요");
			f.b_content.value='';
			f.b_content.focus();
			
			return;
		}
		
		
		
		f.action="update.do";
		f.submit();
		
	}


</script>
</head>
<body>
<form>
	<input type="hidden" name="b_idx" value="${param.b_idx }">
	<input type="hidden" name="page" value="${param.page }">
	<input type="hidden" name="search" value="${param.search }">
	<input type="hidden" name="search_text" value="${param.search_text }">
	<!-- 230303_강ver -->
	<%-- <input type="hidden" name="b_idx" value="${vo.b_idx }"> --%>
	<div id="box">
		<div class="panel panel-danger">
      		<div class="panel-heading">수정하기</div>
      		<div class="panel-body">
      			<table class="table">
      				<tr>
      					<th>제목</th>
      					<td><input class="form-control input-lg" name="b_subject" value="${vo.b_subject }"></td>
      				</tr>
      				<tr>
      					<th>내용</th>
      					<td>
      						<textarea rows="7" cols="" name="b_content">${vo.b_content }</textarea>
      					</td>
      				</tr>
      				<tr>
      					<td colspan="2" align="center">
      						<input class="btn btn-primary" type="button" value="수정하기" onclick="send(this.form);">
      						<input class="btn btn-info" type="button" value="목록보기" onclick="location.href='list.do?page=${param.page}&search=${param.search }&search_text=${param.search_text }'">
      					</td>
      				</tr>
      			</table>
      		</div>
		</div>
	
	
	
	</div>
</form>
</body>
</html>