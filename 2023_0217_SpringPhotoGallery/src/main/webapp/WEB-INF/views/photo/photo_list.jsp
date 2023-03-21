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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<style type="text/css">
   #box{
        width: 765px;
        margin: auto;
        margin-top: 30px; 
   }
   
   #photo_box{
      
      width: 100%;
      height: 450px;
      border: 2px solid blue;
      
      overflow-y: scroll;
   }
   
   #title{
      text-align: center;
      font-size: 28px;
      font-weight: bold;
      color: green;
      text-shadow: 1px 1px 2px black;
   }
   
   #login{
      text-align: right;
      margin-bottom: 5px;
   }
   
   #photo_insert{
      margin-bottom: 5px;
   }
   
   
   .photo_class{
       width: 145px;
       height: 180px;
       border: 1px solid black;
       padding: 10px; 
       
       margin: 20px;
       
       box-shadow: 1px 1px 3px black;
       
       float: left; 
   }
   
   .photo_class:hover{
       border: 1px solid blue;
   }
   
   .photo_class > img{
      
      width: 120px;
      height: 120px;
      border: 1px solid gray;
      outline: 1px solid black;
   }
   
   .photo_title{
     
     width: 98%;
     border: 1px solid gray;
     box-shadow: 1px 1px 1px black;
     padding: 5px;
     margin-top: 5px;
     margin-bottom: 5px;
     
     /* ellipsis */
     overflow:hidden;
     text-overflow:ellipsis;
     white-space:nowrap;
     word-break: break-all;
     
   }
   
   .photo_download{
     text-align: center; 
   }
   
</style>


<script type="text/javascript">
  
   function  photo_insert_form(){
	   
	   if("${ empty user }"=="true"){
		
		   if(confirm("사진등록은 로그인후에 이용가능합니다\n로그인 하시겠습니까?")==false) return;
		   
		   //로그인폼으로 이동
		   location.href="../member/login_form.do";
		   
		   return;
	   }
	   
	   //사진등록폼으로 이동
	   location.href="insert_form.do"; // PhotoInsertFormAction
   }

</script>

<script type="text/javascript">
   
   var global_filename;
   var global_p_idx;
   
   function show_detail(p_idx){
	   
	   //alert(p_idx+" 사진정보 보여줘");
	   $("#photo_popup").show();
	   $("#btn_modify,#btn_delete").hide();
	   
	   //Ajax를 이용해서 p_idx에 해당되는 사진정보 가져오기
	   $.ajax({
		   url		:	"photo_detail.do", //PhotoDetailAction
		   data		:   {"p_idx" : p_idx}, //photo_detail.do?p_idx=3
		   dataType	:   "json",
		   success	:   function(result){
			   //result = { "p_idx":1 , "p_title":"제목", "p_content":"내용", "p_filename":"a.jpg",...}
			   //$("#popup_image").prop("src","../upload/" + result.p_filename);
			   
			   global_p_idx    = result.p_idx;
			   global_filename = result.p_filename;
			   
			   
			   $("#owner_info").html("회원번호 ["+ result.mem_idx  +"]님이 올린 사진");
			   
			   $("#popup_image").attr("src","../resources/upload/" + result.p_filename);
			   
			   $("#popup_title").html(result.p_title);
			   $("#popup_content").html(result.p_content);
			   
			   var str_date = "등록일자 : " + result.p_regdate.substr(0,16) + 
			                  "<br>수정일자 : " + result.p_modifydate.substr(0,16);
			   $("#popup_date").html(str_date);
			   
			   //로그인유저==게시물의 주인 같으면
			   if('${ user.mem_idx }'==result.mem_idx){
				   
				   $("#btn_modify,#btn_delete").show();
			   }
			   
		   },
		   error	:   function(err){
			   alert(err.responseText);
		   }
	   });
	   
	   
	   
	   
   }
   
   function hide_detail(){
		   
	   $("#photo_popup").hide();
   }
   
   function download(){
	   
	   //alert('안녕' +  "/" + encodeURIComponent('안녕') );
	   //alert(global_filename + " 다운로드");
	   //현재경로 : /photo/list.do
		
	   //자바스크립트에서 Query를 통해서 데이터 전송시 인코딩해서 전송해야된다
	   //  encodeURIComponent(값,문자셋) or encodeURIComponent(값)
	   location.href="../FileDownload.do?dir=/resources/upload/&filename=" + 
	   		         encodeURIComponent(global_filename,"utf-8");
	   
	  hide_detail();
		
	  alert("다운로드 완료");
	   
   }
   
   
   function del(){
	   
	   //삭제확인
	   if(confirm("정말 삭제하시겠습니까?")==false)return;
	   //              PhotoDeleteAction 
	   location.href = "delete.do?p_idx=" + global_p_idx;
	   
   }
   
   
   function modify_form(){
	   //수정폼 띄우기  //PhotoModifyFormAction
	   location.href="modify_form.do?p_idx=" + global_p_idx;
	   
   }


</script>



</head>
<body>

  <%@include file="photo_popup_detail.jsp" %>
  
 
  <div id="box">
      <h1 id="title">::::PhotoGallery::::</h1>
      <div id="login">
         <!-- 로그인 안된경우 -->
         <c:if test="${ empty user }">
             <input class="btn  btn-primary" type="button"  value="로그인" 
                    onclick="location.href='../member/login_form.do'">
         </c:if>
      
         <!-- 로그인 된경우 -->
         <c:if test="${ not empty user }">
             <b>${ user.mem_name }</b>님 환영합니다
             <input class="btn  btn-primary" type="button"  value="로그아웃" 
                    onclick="location.href='../member/logout.do'">
         </c:if>
         <c:if test="${user.mem_grade eq '관리자' }">
			<input class="btn" type="button" value="회원리스트" onclick="location.href ='../member/list.do'"> 
		</c:if>
		<c:if test="${user.mem_grade eq '일반' }">
			<input class="btn" type="button" value="정보수정" onclick="location.href='../member/modify_form.do?mem_idx=${user.mem_idx}'">			
		</c:if>
         
      </div>
      
      <div id="photo_insert">
         <input class="btn  btn-primary" type="button"  value="사진등록"
                onclick="photo_insert_form();">  
      </div>
      <div id="photo_box">
      
        <!-- 데이터가 없을경우 -->
        <c:if test="${ empty list }">
           <div style="text-align: center; margin-top: 230px; color:red;">
              등록된 사진이 없습니다
           </div>
        </c:if>
        
        <!-- for(PhotoVo vo : list) -->
        <c:forEach var="vo"  items="${ list }">
           <div class="photo_class">
               <img src="../resources/upload/${ vo.p_filename }"  onclick="show_detail('${ vo.p_idx }');" >
               <div class="photo_title">${ vo.p_title }</div>
               <!-- <div class="photo_download">
                  <input type="button"  value="받기">
               </div> -->
           </div>
        </c:forEach>
         
         
      </div>
  </div>
</body>
</html>