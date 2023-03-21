<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>  
<link rel="stylesheet" 
      href="${ pageContext.request.contextPath }/resources/css/c_board.css">

<script type="text/javascript">
	function insert_form(){
		if("${ empty user }" == "true"){//로그인여부체크
		if(confirm("글쓰기는 로그인후에 가능합니다\n로그인 하시겠습니까?")==false) return;
			loation.href='../c_member/login_form.do';
			return;
	  	}
	location.href='insert_form.do'; //글쓰기 폼으로 이동
	}
</script>
<script type="text/javascript">
	//jQuery 초기화
	$(document).ready(function(){
		if("${ not empty param.search }" == "true"){
			$("#search").val('${ param.search }');
		}
		//전체검색이면->검색어는 지워라
		if("${ param.search eq 'all' }"=="true"){
			$("#search_text").val("");
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
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
	</header>
	<!-- 메뉴 -->
	<nav>
		<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
	</nav>
	<div id="box">
	<article style="margin: 200px 0 200px 0;">
		<h1 id="title">유저게시판</h1>
		<div id="login">
        	<!-- 로그인안된상태 -->
        	<c:if test="${ empty sessionScope.user }">
				<input class="btn btn-primary"  type="button"  value="로그인" 
                    onclick="location.href='../c_member/login_form.do'">
         	</c:if>
         
		</div>
	    <div style="margin-bottom: 5px;">
			<input class="btn btn-primary"  type="button" value="글쓰기"  
			onclick="insert_form();">
     	</div>
	     	
		<div class="form-inline" style="text-align: right; margin-bottom: 5px;">
			<select id="search" class="form-control">
				<option value="all">전체</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="name">이름</option>
				<option value="subject_content_name">제목+내용+이름</option>
			</select>
			<input class="form-control"  id="search_text"  value="${ param.search_text }">
			<input class="btn btn-info"  type="button"     value="검색" onclick="search();">
		</div>
     	
		<!-- Data출력 -->
		<table class="table table-success table-striped">
	        <!-- title -->
	        <tr class="success">
				<th width="10%">번호</th>
				<th width="40%">제목</th>
				<th width="20%">작성자</th>
	           	<th width="20%">작성일자</th>
				<th width="10%">조회수</th>
			</tr>
			
	        <!-- data가 없는 경우 -->
	        <c:if test="${ empty list }">
				<tr>
		        	<td colspan="5" align="center">
		            	<span style="color:red;">게시물이 없습니다</span>
		        	</td>
		        </tr>
	        </c:if>
	        
	        <!-- data가 있는 경우 -->
	        <!-- for(BoardVo vo : list)  -->
			<c:forEach var="vo"  items="${ list }">
	        	<tr>
	            	<td>${ vo.c_no }(${ vo.c_b_idx })</td>
	                <td>
	                	<!-- b_depth만큼 들여쓰기 -->
	                    <c:forEach begin="1"  end="${ vo.c_b_depth }">
	                   		&nbsp;&nbsp;&nbsp;
	                    </c:forEach>
	                   
	                    <!--답글이면 붙여라  -->
	                    <c:if test="${ vo.c_b_depth != 0 }">
	                   		<font color="blue">ㄴ[re]</font>
	                    </c:if>
	                   
	                    <!-- 사용중인 경우 : b_use가 y인 경우 -->
	                    <!-- 사용중인 경우 : b_use가 y인 경우 : 답글이 아닌 경우 -->
	                    <c:if test="${ vo.c_b_use eq 'y' }">
	                    	<a href="view.do?c_b_idx=${ vo.c_b_idx }&page=${ (empty param.page) ? 1 : param.page }">
		                		<c:if test="${ vo.c_b_depth <= 0 }">
		                   	    	<font color="#8B4513">
		                   	   	   		${ vo.c_b_subject } 
		                   	   	   			<c:if test="${ vo.c_comment_count > 0 }">
		                   	   	   				(${ vo.c_comment_count })
		                   	   	   			</c:if>
		                   	    	</font>
		               			</c:if>
	                   		</a>
	               	    </c:if>
	               	    
						<!-- 사용중인 경우 : b_use가 y인 경우 : 답글인 경우 -->
	               	    <c:if test="${ vo.c_b_use eq 'y' }">
	                   		<a href="view.do?c_b_idx=${ vo.c_b_idx }&page=${ (empty param.page) ? 1 : param.page }">
	                   	    	<c:if test="${ vo.c_b_depth != 0 }">
	                   	     		<font color="blue">
	                   	   	   			${ vo.c_b_subject }
	                   	   	   				<c:if test="${ vo.c_comment_count > 0 }">
		                   	   	   				(${ vo.c_comment_count })
		                   	   	   			</c:if>
	                   	     		</font>
	                   	   		</c:if>
	                   	 	</a>
	               	    </c:if>
	              
	              
	              
	              
	              
	              
	               	   
	               	    <!-- 삭제된 경우 : b_use가 n인 경우 -->
	                    <c:if test="${ vo.c_b_use eq 'n' }">
	                   		<font color="red"> 
	                   			삭제된 게시물 입니다. : (${ vo.c_b_idx }, ${ vo.c_b_subject })
	                   		</font>
	               	    </c:if>
	               	   
	                </td>
	                <td>
	                	${ vo.c_mem_name }
	                </td>
	                <td>
	               		${ vo.c_b_regdate }
	                </td>
	                <td>
	                	${ vo.c_b_readhit }
	                </td>
	            </tr>
	        </c:forEach>
	        
	        <!-- Page Menu -->
	        <tr> 
	        	<td colspan="5" align="center" style="font-size: 20px;">
	        		<!-- <a href="plus.do?page=">&lt;</a>&nbsp;
	        		<a href="list.do?page=1">1</a>&nbsp;
	        		<a href="list.do?page=2">2</a>&nbsp;
	        		<a href="list.do?page=3">3</a>&nbsp;
	        		<a href="minus.do?page=">&gt;</a>&nbsp; -->
	        		${ pageMenu }
	        	</td>
	        </tr>
     </table>
  </article>
  </div>
	<footer>
		<jsp:include page="/WEB-INF/views/layout/footer/footer.jsp"></jsp:include>
	</footer>
</body>
</html>