<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    #photo_popup{
      width: 400px;
		margin-top: 30px;
		padding:10px;
		border: 1px solid black;
		box-shadow: 0px 0px 20px black;
		border: none;
		background-color: #FFDAB9;
		
		/* 중앙배치 */
        position: absolute;
        /* 부모기준 */
        left: 50%;
        top:  50%;
        /* 자신기준 */
        transform: translate(-50%,-50%);
        
        z-index: 1000;
        
        display: none;
		
    }
 
    img#popup_image{
       width: 376px;
       height: 376px;
       border: 1px solid gray;
       outline: 1px solid black;
    }
    
    #popup_title , #popup_date{
       padding: 5px;
       margin-top: 5px;
       border: 1px solid gray; 
       box-shadow: 1px 1px 2px black;
       background-color: threedface;
       
    }
    
    #popup_content{
       min-height: 80px;
       height: auto;
       padding: 5px;
       margin-top: 5px;
       border: 1px solid gray; 
       box-shadow: 1px 1px 2px black;
       background-color: threedface;
      
    }
    
    #popup_button{
       margin-top: 5px;
       text-align: center;
    }
    
</style>
<script type="text/javascript">
	var global_filename;
	var global_p_idx;
	
	function download(){
		
		alert(global_filename+"다운로드");
		//기존 [최신 브라우저는 문제없이 된다]
		//location.href ="../FileDownload.do?dir=/upload/&filename=" + global_filename;
		
		//수정 [오래된 브라우저는 한글 파일명을 인식하지 못해서 인코딩을 해줘야 한다.]
		// -> 이렇게 쓰는걸 권장한다. [자바스크립트에서 Query를 통해서 데이터 전송시 인코딩해서 전송해야된다]  
		//			why 사용자의 경우의 수는 파악할 수 없다.
		//			how encodeURIComponent(값,문자) 또는 encodeURIConponet(값)
		location.href ="../FileDownload.do?dir=/upload/&filename=" +
								encodeURIComponent(global_filename,"utf-8");
		
	}



</script>
</head>
<body>

   <div id="photo_popup">
   		
   		
      <div style="text-align: center; margin-bottom: 3px;">
      	<span id="owner_info">작성자</span>
      	<input type="button" style="WIDTH: 60pt; HEIGHT: 30pt" value="x" onclick="hide_detail();">
      </div>
      <img id="popup_image">
      <div id="popup_title">제목작성</div>
      <div id="popup_content">내용작성</div>
      <div id="popup_date">날짜작성</div>
      
      <div id="popup_button">
 	  <!-- 로그인 상태면 -->
 	  <c:if test="${not empty user }">
          <input class="btn btn-primary" type="button"  value="다운로드" onclick="download();">
      </c:if>      
          <input class="btn btn-info"  id="btn_modify"  type="button"  value="수정하기" onclick="modify_form();">      
          <input class="btn btn-danger" id="btn_delete" type="button"  value="삭제하기" onclick="del();">      
      </div>
   </div>

</body>
</html>