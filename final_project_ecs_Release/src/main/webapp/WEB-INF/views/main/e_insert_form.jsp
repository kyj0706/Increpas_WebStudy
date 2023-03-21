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
	function send(f){
		var f_content = f.f_content.value.trim();
		if(f_content==''){
			alert('제목을 입력하세요!');
			f.f_content.value='';
			f.f_content.focus();
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
		<input type="hidden"  name="f_statNm"   value="${ param.f_statNm }">
		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">글쓰기</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>내용</th>
							<td><input name="f_content"></td>
						</tr>
						<tr>
					<th>별점</th>
					<td>
					<select name="s_no">
		        		<option value="1">1점</option>
		        		<option value="2">2점</option>
		        		<option value="3">3점</option>
		        		<option value="4">4점</option>
		        		<option value="5">5점</option>
	    	   		</select>
					</td>
					</tr>
						<tr>
							<td colspan="2" align="center">
								<input  class="btn btn-primary" type="button"  value="글올리기"
				                      onclick="send(this.form);">
				              <input  class="btn btn-success" type="button"  value="목록보기" 
				                      onclick="location.href='view.do'">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>