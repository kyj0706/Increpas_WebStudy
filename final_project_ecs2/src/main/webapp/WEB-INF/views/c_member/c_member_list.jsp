<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>  
<script type="text/javascript">
</script>
<style type="text/css">
	body {
		background: rgb(0,158,199);
		background: linear-gradient(90deg, rgba(0,158,199,1) 0%, rgba(187,249,213,1) 37%, rgba(249,255,221,1) 73%, rgba(134,235,255,1) 100%);

		height: 1000px;
	}
    #box{
        width: 1000px;
        margin: auto;
        margin-top: 20px; 
    }
    #title{
      text-align: center;
      font-size: 30px;
      font-weight: bold;
      color:  rgb(255, 255, 255);
      
      text-shadow: 1px 1px 3px black;
	}
	#empty_message{
      text-align: center;
      font-size: 30px;
      font-weight: bold;
      color:  rgb(255, 255, 255);
      
      text-shadow: 1px 1px 3px black;
	}  
</style>
<title>Insert title here</title>
<script type="text/javascript">

function del(c_mem_idx){
	 //alert("삭제할 idx : " + idx);
	 
	 //삭제확인
	 if(confirm("정말 삭제하시겠습니까?")==false) return;
	 
	 location.href="delete.do?c_mem_idx=" + c_mem_idx;
}
</script>
</head>
<body>
	<div id="box">
	   <h1 id="title">회 원 목 록</h1>
	   <!-- 로그인 메뉴 -->
       <div>
            <!-- 로그인이 안되었을경우 -->
            <c:if test="${ empty sessionScope.user }">
	            <input class="btn btn-primary" type="button" value="로그인" 
	                   onclick="location.href='login_form.do'">
            </c:if>       
                   
            <!-- 로그인이 되었을경우 -->
            <c:if test="${ not empty sessionScope.user }">
                <b>${ user.c_mem_name }</b>님 환영합니다
                <input class="btn btn-primary" type="button"  value="로그아웃" 
                        onclick="location.href='logout.do'">
            </c:if>
    
       </div>
       
	   <div style="text-align: right; margin-top: 5px; margin-bottom: 5px;">
          <input  class="btn btn-primary" type="button" value="회원가입" 
                  onclick="location.href='insert_form.do'">
       </div> 
		
		<table class="table">
			<!-- table header -->
			<tr class="info">
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>등급</th>
				<th>가입일자</th>
				<th>마일리지</th>
				<th>충전기타입</th>
				<th>가입일자</th>
				<th>편집</th>
			</tr>
			<c:if test="${ empty list }">
            	<tr>
            		<td colspan="9" align="center">
                    <div id="empty_message">가입된 회원정보가 없습니다</div>
                    </td>
                </tr>
            </c:if>
            <c:forEach var="vo" items="${ list }">
            	<tr>
            	
            	
            		<td>${ vo.c_mem_idx      }</td>
            		<td>${ vo.c_mem_name     }</td>
            		<td>${ vo.c_mem_id       }</td>
            		<td>${ vo.c_mem_pwd      }</td>
            		<td>${ vo.c_mem_zipcode  }</td>
            		<td>${ vo.c_mem_address  }</td>
            		<td>${ vo.c_mem_grade    }</td>
            		<td>${ vo.c_mem_regdate    }</td>
            		<td>${ vo.c_mem_mileage    }</td>
            		<td>${ vo.c_mem_chargertype    }</td>
            		<td>${ fn:substring( vo.c_mem_regdate,0,10 ) }</td>
            		<td>
          	        <!-- 편집메뉴의 활성화는 관리자 또는 본인 -->
	          	        <c:if test="${ (user.c_mem_grade eq '관리자') or (user.c_mem_id eq vo.c_mem_id)  }">
		          	    	<input  class="btn btn-info"    type="button"  value="수정" 
		          	                 onclick="location.href='modify_form.do?c_mem_idx=${ vo.c_mem_idx }'"
		          	                 >
		          	    	<input  class="btn btn-danger"  type="button"  value="삭제"  
		          	    			 onclick="del('${ vo.c_mem_idx }');" >  
	          	        </c:if>
          	     	</td>
            	</tr>
            </c:forEach>
		</table>
	</div>
</body>
</html>