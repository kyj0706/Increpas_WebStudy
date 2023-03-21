<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
var num_regular = /^[0-9]+$/;

function send(f)
{
   var category = f.category.value;
   var	p_num = f.p_num.value;
   var p_name = f.p_name.value;
   var p_company = f.p_company.value;
   var p_price = f.p_price.value;
   var p_saleprice = f.p_saleprice.value;
   var p_content = f.p_content.value;
   var p_image_s = f.p_image_s.value;
   var p_image_l = f.p_image_l.value;
   
  	
  	
  	//각각의 입력 확인 
  	if(category=='') {
		alert("카테고리 선택 ");
		f.category.value='';
		f.category.focus();
		return;
	}
  	if(p_num=='') {
		alert("제품번호 입력 ");
		f.p_num.value='';
		f.p_num.focus();
		return;
	}
  	if(p_name=='') {
		alert("제품명 입력 ");
		f.p_name.value='';
		f.p_name.focus();
		return;
	}
  	if(p_company=='') {
		alert("판매사 입력 ");
		f.p_company.value='';
		f.p_company.focus();
		return;
	}
  	//가격 부분 숫자만 입력 정규식 
  	if(num_regular.test(p_price)==false){
  		alert("제품가격은 숫자만 입력하세요");
  		f.p_price.value='';
		f.p_price.focus();
		return;
  	}
  	//가격 부분 숫자만 입력 정규식 
  	if(num_regular.test(p_saleprice)==false){
  		alert("할인가격은 숫자만 입력하세요");
  		f.p_saleprice.value='';
		f.p_saleprice.focus();
		return;
  	}
  	if(p_content=='') {
		alert("제품설명 입력 ");
		f.p_content.value='';
		f.p_content.focus();
		return;
	}
	if(p_image_s=='') {
		alert("작은사진 선택해 ");
		return;
	}
	if(p_image_l=='') {
		alert("큰사진 선택해 ");
		return;
	}
  	
   f.action = "insert.do";
   f.submit();
   
}
</script>

<!-- 중복 : 제품번호 ajax -->
<script type="text/javascript">
	$(document).ready(function(){
		
		//제품번호가 입력차에서 키가 눌리고 나오면
		$("#p_num").keyup(function(){
			
			
			//등록버튼 비활성화
			/* $("#btn_join").attr("disabled") */
			var p_num = $(this).val();
			
			$.ajax({
				url			:"check_num.do",
				data		:{"p_num":p_num},
				dataType	:"json",
				success		:function(res_data){
					if(res_data.res==true){
						$("#num_msg").html("사용가능한 제품명 입니다.")
			               .css("color","blue");
						console.log(res_data);
						/* $("btn_join").attr("disabled",false); */
					}else{
						$("#num_msg").html("제품명 중복입니다.")
			               .css("color","red");
						
					}
					
				},
				error		:function(err){
					alert(err.responseText);
				}
				
				
			});//end_ajax
		});//end: key_function
	});//end: fun_ready

</script>
<style type="text/css">
	#num_msg{
		display: inline-block;
		width: 250px;
		margin-left: 20px;
		
	}

</style>
</head>
<body>

<!-- title -->
<%-- <jsp:include page="index.jsp"/> --%>
<%@include file="index.jsp"  %>
<form name="f" method="post" action="insert.do" 
      enctype="multipart/form-data"> 
<table align="center" width="600" border="1" 
    style="border-collapse:collapse;font-size:8pt" bordercolor="navy"
    cellpadding="2" cellspacing="0">
    <tr>
        <td>제품Category</td>
        <td><select name="category">
        		<option value="">카테고리 선택</option>
        		<c:forEach var="category" items="${category_list }">
        			<option value="${category.category_code }">${category.category_name }</option>
        		
        		</c:forEach>
        		
        		
        		<!-- <option value="com001">컴퓨터</option>
        		<option value="ele002">가전제품</option>
        		<option value="sp003">스포츠</option> -->
        </select></td>
    </tr>
    <tr>
        <td>제품번호</td>
        <td><input name="p_num" type="text" id="p_num"><span id="num_msg"></span> </td>
    </tr>
    <tr>
        <td>제품이름</td>
        <td><input name="p_name" type="text" ></td>
    </tr>
    <tr>
        <td>제품 판매사</td>
        <td><input name="p_company" type="text" ></td>
    </tr>
    <tr>
        <td>제품가격</td>
        <td><input name="p_price" type="text" ></td>
    </tr>
    <tr>
        <td>제품할인가격</td>
        <td><input name="p_saleprice" type="text" ></td>
    </tr>    
    <tr>
        <td>제품설명</td>
        <td><TEXTAREA name="p_content" rows="5" cols="50"></TEXTAREA></td>
    </tr>
    <tr>
        <td>제품사진(작은사진)</td>
        <td><input type="file" name="p_image_s">
    </tr>
    <tr>
        <td>제품사진(큰사진)</td>
        <td><input type="file" name="p_image_l">
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="등록" id="btn_join"  onclick="send(this.form);" >
            <input type="reset" value="Clear" >
        </td>
    </tr>    
</table>
</form>
</body>
</html>