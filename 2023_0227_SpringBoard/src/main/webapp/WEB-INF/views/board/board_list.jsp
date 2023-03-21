<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
 
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
		width: 1000px;
		margin: auto;
		margin-top: 20px;
	}
	
	#title {
		text-align: center;
		font-size: 40px; /* px(가변) vs pt(고정) */
		font-weight: bold;
		color: #6688cc;
		text-shadow: 1px 1px 3px black;
	}
	
	#login{
		text-align: right;
	}
	
	tr> th{
		text-align: center;
		font-size: 16px;
	}
	
	tr >td {
		text-align: center;
	}
	
	a{
		text-decoration: none;
	}
	
</style>

<!-- pagin menu css -->
<!-- <style type="text/css">
	.span_menu{
		display: inline-block;
		width: 30px;
		height: 30px;
		padding: 5px;
		text-align: center;
		font-size: 18px;
	}
	
	.span_menu:hover{
		background: red;
	}

</style> -->

<script type="text/javascript">

	function insert_form(){
		
		//로그인 여부 체크(EL태그)
		if("${empty user }" == "true"){
			if(confirm("글쓰기는 로그인후에 가능합니다. \n 로그인 하시겠습니까?")==false) return;
			
			location.href = '../member/login_form.do';
			
			return;
		}
		
		//글쓰기 폼으로 이동 
		
		location.href = 'insert_form.do';
		
	}


</script>
<!-- 검색 -->
<script type="text/javascript">

	//jQuery 초기화
	$(document).ready(function(){
		
		if("${not empty param.search}"=="true"){
			$('#search').val("${param.search}");
		}
		
		//전체검색이면
		if("${param.search == "all"}"=="true"){
			$('#search_text').val('');
		}
		
	});

	   function  search(){
		   
		   var search      = $("#search").val();
		   var search_text = $("#search_text").val().trim();
		   
		   if(search != "all" && search_text==""){
			   alert("검색어를 입력하세요!!");
			   $("#search_text").val("");
			   $("#search_text").focus();
			   return;
		   }
		   
		   //검색요청
		   location.href="list.do?search=" + search + "&search_text=" + encodeURIComponent(search_text);
		   
	   }
	
	
/* 	
	function search(){
		
		var search		= $('#search').val();
		var search_text	= $('#search_text').val().trim();
		
		if(search='all' && search_text==''){
			alert('검색어를 입력하세요');
			$('#search_text').val('');
			$('#search_text').focus();
			return;
		}
		
		//검색요청
		 location.href="list.do?search=" + search + "&search_text=" + encodeURIComponent(search_text);
	} 
*/

</script>


</head>
<body>
	<div id="box">
		<a href="list.do"><h1 id="title">::::게시판::::</h1></a>
		<div id="login">
			<!-- 로그인의 여부에 따라 진행 -->
			<!-- 로그인 안된상태 -->
			<c:if test="${empty user }">
				<input class="btn btn-primary" type="button" value="로그인" onclick="location.href='../member/login_form.do'">
			</c:if>
			<!-- 로그인 된상태 -->
			<c:if test="${not empty user }">
				<b>${user.mem_name }</b>님 환영합니다.
				<input type="button" value="로그아웃" onclick="location.href='../member/logout.do'">
			</c:if>
			
		</div>
		<div><input class="btn btn-info" type="button" value="글쓰기" onclick="insert_form();"></div><br>
		<div style="text-align: right; margin-bottom: 5px;">
			<select id="search">
				<option value="all">전체</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="name">이름</option>
				<option value="subject_content_name">제목+내용+이름</option>
			</select>
			
			<input id="search_text" value="${param.search_text }">
			<input  type="button" value="검색" onclick="search();">
		</div>
		
		
		<table class="table">
			<tr class="info"> 
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<!-- board 데이터가 없는경우 -->
			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">
						<span style="color: red;">게시물이 없습니다</span>
					</td>				
				</tr>
			</c:if>
			
			<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.no }(${vo.b_idx })</td>
				<td style="text-align: left;">
				
					<!-- b_depth 만클 들여쓰기 -->
					<c:forEach begin="1" end="${vo.b_depth }">
						&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<!-- 답글이면 붙여라 -->
					<c:if test="${vo.b_depth ne 0 }">
					ㄴ[답글]
					</c:if>
					
					<!-- 사용중 : b_use='y' -->
					<c:if test="${vo.b_use eq 'y' }">
						<a href="view.do?b_idx=${vo.b_idx }
									&page=${ (empty param.page) ? 1: param.page}
									&search=${empty param.search ? 'all' : param.search }
									&search_text=${param.search_text}">
						 ${vo.b_subject } 
						 <c:if test="${vo.comment_count gt 0 }">
						 <span class="badge">${vo.comment_count }</span>
						 </c:if>
						</a>
					</c:if>
					<!-- 삭제경우 : b_use='n' -->
					<c:if test="${vo.b_use eq 'n' }">
						<font color="red">${vo.b_subject} [삭제된 게시물 입니다.]</font>
					</c:if>
					
				</td>
				<td>${vo.mem_name }</td>
				<td>${fn:substring(vo.b_regdate,0,16) }</td>
				<td>${vo.b_readhit }</td>
			</tr>
			</c:forEach>
			
			
			<!-- page Menu -->
			<tr>
				<td colspan="5" align="center">
					${pageMenu}
					<!-- <a href="list.do?page=1">1</a>&nbsp;
					<a href="list.do?page=2">2</a>&nbsp; -->
					
				</td>			
			</tr>
		</table>
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>