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
 
<!-- sweetalert2 사용설정 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  
<style type="text/css">
  #box{
      width: 600px;
      margin: auto;
      margin-top: 30px;
  }
  
  #title{
      text-align: center;
      font-size: 30px;
      font-weight: bold;
      font-family: 휴먼옛체,궁서체,굴림체;
      color: green;
      
      text-shadow: 1px 1px 3px black;
  }
  
  #empty_message{
      text-align: center;
      color: red;
      font-weight: bold;
      font-size: 20px;
      font-family: 휴먼옛체,궁서체,굴림체;
  }
  
  /* 내용 */
  .content{
      min-height: 60px;
      border: 1px solid gray;
      box-shadow: -1px -1px 1px #333333;
      padding: 5px;
  }
  
  /* 날짜/비밀번호 */
  .regdate , .pwd {
      border: 1px solid gray;
      box-shadow: 1px 1px 1px #333333;
      padding: 5px;
      margin-top: 10px;
  }
 
</style>

<script type="text/javascript">

  function modify_form(f){
	  
	  var idx   = f.idx.value;
	  var c_pwd = f.c_pwd.value.trim();//확인비번
	  
	  if(c_pwd==''){
		  
		  Swal.fire({ 
			          title:'비밀번호를 입력하세요',
			          html:'비밀번호 누락',
			          icon:'info',
			          returnFocus:false
			        }
		  ).then(function(){
			  //확인버튼 누른후 처리
	          f.c_pwd.value='';
			  f.c_pwd.focus();
		  });
		  
		  return;
	  }
	  
	  //Ajax이용해서 비밀번호 맞는지 여부 체크
	  $.ajax({
		  url		: "check_pwd.do",               //VisitCheckPwdAction
		  data  	: {"idx":idx, "c_pwd": c_pwd} , //check_pwd.do?idx=10&c_pwd=1234
		  dataType	: "json",
		  success	: function(result_data){
			    //result_data = {"result": true}
			    if(result_data.result==false){
			    	
			    	//alert("비밀번호가 틀립니다");
			    	Swal.fire('비밀번호가 틀립니다','','info');
			    	return;
			    }
			    
			    //수정폼 띄우기 
				location.href = "modify_form.do?idx=" + idx;  //VisitModifyFormAction
			    
		  },
		  error		: function(err){
			  
			  alert(err.responseText);
		  }
	  });
	  
  }//end:modify_form()
  
  

  function del(f){
	  
	  var idx   = f.idx.value;
	  var c_pwd = f.c_pwd.value.trim();//확인비번
	  
	  if(c_pwd==''){
		  
		  Swal.fire({ 
			          title:'비밀번호를 입력하세요',
			          html:'비밀번호 누락',
			          icon:'info',
			          returnFocus:false
			        }
		  ).then(function(){
			  //확인버튼 누른후 처리
	          f.c_pwd.value='';
			  f.c_pwd.focus();
		  });
		  
		  return;
	  }
	  
	  //Ajax이용해서 비밀번호 맞는지 여부 체크
	  $.ajax({
		  url		: "check_pwd.do",               //VisitCheckPwdAction
		  data  	: {"idx":idx, "c_pwd": c_pwd} , //check_pwd.do?idx=10&c_pwd=1234
		  dataType	: "json",
		  success	: function(result_data){
			    //result_data = {"result": true}
			    if(result_data.result==false){
			    	
			    	//alert("비밀번호가 틀립니다");
			    	Swal.fire('비밀번호가 틀립니다','','info');
			    	return;
			    }
			    
			    //삭제실행
			    do_del(idx);
		  },
		  error		: function(err){
			  
			  alert(err.responseText);
		  }
	  });

  }


  
  function do_del(idx){
	  
	  Swal.fire({
		  title: '정말 삭제하시겠습니까?',
		  text: "현재 선택된 게시물이 삭제됩니다",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: '삭제',
		  cancelButtonText: '취소',
	 }).then((result) => {
		  if (result.isConfirmed) {//확인버튼 클릭시
			  
			  location.href="delete.do?idx=" + idx;
			  
		  }
	 });
	  
  }
</script>


<script type="text/javascript">
  
  function search(){
	  
	  var search      = $("#search").val(); //document.getElementById("search").value
	  var search_text = $("#search_text").val().trim();
	  
	  if(search!="all" && search_text==""){
		  alert("검색어를 입력하세요!!");
		  $("#search_text").val("");
		  $("#search_text").focus();
		  return;
	  }
	  
	  //전체검색이면 검색어를 지워라..
	  if(search=='all')
		  search_text = "";
	  
	  //list.do호출
	  location.href = "list.do?search=" + search + 
			          "&search_text=" + encodeURIComponent(search_text);
	  
	  
  }
</script>


<script type="text/javascript">
  
  $(document).ready(function(){
	  
	  if("${ not empty param.search }"=="true"){
	      $("#search").val("${ param.search }");
	  }
  });

</script>

</head>
<body>
  <div id="box"> 
     <h1 id="title">::::방 명 록::::</h1>
     
     <div style="text-align: right; margin-bottom: 10px;">
         <input class="btn btn-primary" type="button"  value="글쓰기" 
                onclick="location.href='insert_form.do'">
     </div> 
     
     <hr>
     <!-- 검색기능 -->
     <div style="margin-bottom: 5px; text-align: center">
         
         <select id="search">
             <option value="all">전체</option>
             <option value="name">이름</option>
             <option value="content">내용</option>
             <option value="name_content">이름+내용</option>
             <option value="modifydate">작성일자</option>
         </select>
         
         <input id="search_text"  value="${ param.search_text }">
         <input type="button"  value="검색"  onclick="search();">
         
     </div>
     
     <hr>
     
     
     <!-- data  -->
     <div>
        <!-- 데이터가 없는경우 -->
        <c:if test="${ empty list }">
          <div id="empty_message">게시물이 없습니다</div>
        </c:if>
        
        <!-- 데이터가 있는경우 -->
        <!--  for(VisitVo vo : list) 동일 -->
        <c:forEach var="vo"  items="${ list }">
	        <form>

	            <input type="hidden"  name="idx"  value="${ vo.idx }">
	            
	            <div id="v_${ vo.idx }"   class="panel panel-primary">
				      <div class="panel-heading"><h4><b>${vo.idx} ${ vo.name }</b>님의 글:</h4></div>
				      <div class="panel-body">
				          
				          <div class="content">${ vo.content }</div>
				          <div class="regdate">작성일자 : ${ fn:substring(vo.modifydate,0,16) }(${ vo.ip })</div>
				          <div class="pwd">
				             비밀번호(${ vo.pwd }):<input type="password"  name="c_pwd">
				                      <input class="btn  btn-info"     type="button"  value="수정"
				                             onclick="modify_form(this.form);">  
				                      <input class="btn  btn-danger"   type="button"  value="삭제" 
				                             onclick="del(this.form);">  
				          </div>			      
				      </div>
				</div>
	        </form>
        </c:forEach>
             
     </div>     
  </div>
</body>
</html>





