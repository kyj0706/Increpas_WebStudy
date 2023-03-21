<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" 
      href="${ pageContext.request.contextPath }/resources/css/product.css">

<script type="text/javascript">
 window.onload=function(){
      setTimeout(showMessage,200);
	     
 };
 
 //body가 출력되기 전에 window 가 먼저 실행 된다
 
 function showMessage(){
	 
	 if("${ param.error eq 'remain_not' }"=='true')
	 {
		 alert('재고목록에 출고할\n상품이 없습니다');
	 }
	
	 if("${ param.error eq 'remain_lack' }"=='true')
	 {
		 alert('출고할 상품수량이 부족합니다');
	 }
	 
	 if("${ param.error eq 'in_remain_lack' }"=='true')
	 {
		 alert('입고수량과 다르거나 출고된 상품이 있습니다.');
	 }
	 /* if("${ param.error eq 'out_remain_lack' }"=='true')
	 {
		 alert('취소');
	 } */
	 
	 
	 
 }
 
</script>


</head>
<body>

<div id="main_box">
  <h1 id="title">::::상품재고관리 시스템::::</h1>
  <hr id="gap">
  <div id="sub_box">
      <div class="job_box">
        <%@include file="product_in.jsp" %>
      </div>
      <div class="job_box">
        <%@include file="product_remain.jsp" %>
      </div>
      <div class="job_box">
      	<%@include file="product_out.jsp" %>
      </div> 
      
      <!-- 입고/출고작업 -->
      <div class="input_box">
        <%@include file="product_in_form.jsp" %>
      </div>
      
      <div class="input_box" style="border:none;"></div>
      
      <div class="input_box">
        <%@include file="product_out_form.jsp" %>
      </div>
      
  </div>
</div>





</body>
</html>