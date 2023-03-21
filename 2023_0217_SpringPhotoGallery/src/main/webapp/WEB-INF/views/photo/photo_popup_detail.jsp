<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
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
        min-height: 400px;
        padding: 10px;
        /* border: 2px solid blue; */ 
        
        background: #333333;
        color: white;
        
        /* 중앙배치 */
        position: absolute;
        /* 부모기준 */
        left: 50%;
        top:  50%;
        /* 자신기준 */
        transform: translate(-50%,-50%);
        
        z-index: 1000;
        
        display: none;
        
        /* box-shadow: 1px 1px 3px black; */
    }
 
    img#popup_image{
       width: 380px;
       height: 380px;
       border: 1px solid gray;
       outline: 1px solid black;
    }
    
    #popup_title , #popup_date{
       padding: 5px;
       margin-top: 5px;
       border: 1px solid gray; 
       box-shadow: 1px 1px 2px black;
    }
    
    #popup_content{
       min-height: 80px;
       height: auto;
       padding: 5px;
       margin-top: 5px;
       border: 1px solid gray; 
       box-shadow: 1px 1px 2px black;
    }
    
    #popup_button{
       margin-top: 5px;
       text-align: center;
    }
    
    #owner_info{
       color: white;
       font-weight: bold;
    }
   
</style>



</head>
<body>

   <div id="photo_popup">
      <div style="text-align: right; margin-bottom: 3px; color:red;">
           <span id="owner_info"></span>
           <input type="button"  value="x"  onclick="hide_detail();">
      </div>
      <img id="popup_image" src="../upload/으농.png">
      <div id="popup_title">제목작성</div>
      <div id="popup_content">내용작성</div>
      <div id="popup_date">날짜작성</div>
      
      <div id="popup_button">
          <!-- 로그인 상태면 -->
          <c:if test="${ not empty user }">
             <input class="btn btn-primary" type="button"  value="다운로드" 
                    onclick="download();">      
          </c:if>
          
          
          <input id="btn_modify" class="btn btn-info"    type="button"  value="수정하기" 
                 onclick="modify_form();">      
          <input id="btn_delete" class="btn btn-danger"  type="button"  value="삭제하기"
                 onclick="del();" >
                
      </div>
   </div>

</body>
</html>