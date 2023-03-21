<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  #cmt_content{
     width: 79%;
     height: 50px;
     float:left;
     
     resize: none;
  }
  
  #btn_comment{
     width: 20%;
     height: 50px;
  }

</style>

<script type="text/javascript">
  /* 전역변수 */
  var global_comment_page = 1;
  
  $(document).ready(function(){
	  
	  comment_list(1);
	 
  });
  
  
</script>


<script type="text/javascript">
  function add_comment(){
	  //alert('게시물번호 : ${ vo.b_idx}');
	  if("${ empty user}" == "true"){
		   
		   if(confirm("댓글쓰기는 로그인후 가능합니다\n로그인 하시겠습니까?")==false)return;
		   
		   location.href="../member/login_form.do?url=" 
				           + encodeURIComponent(location.href);
		   return;
	  }
	  
	  var cmt_content = $("#cmt_content").val().trim();
	  if(cmt_content==''){
		  alert('댓글내용을 입력하세요');
		  $("#cmt_content").val("");
		  $("#cmt_content").focus();
		  return;
	  }
	  
	  //Ajax로 전송(댓글추가)
	  $.ajax({
		  url	:	"comment_insert.do",
		  data	:	
		  {
			  "cmt_content" : cmt_content,
			  "b_idx"		: "${ vo.b_idx }",
			  "mem_idx"		: "${ user.mem_idx }",
			  "mem_id"		: "${ user.mem_id }",
			  "mem_name"	: "${ user.mem_name}"
		  },
		  dataType: "json",
		  success : function(result_data){
			  // result_data = { "result" : "success"} or { "result" : "fail"} 
			  
			  //기존작성글 지우기
			  $("#cmt_content").val("");
			  
			  if(result_data.result=='fail'){
				  alert('댓글등록 실패!!');
				  return;
			  }
			  
			  //성공했을경우
			  comment_list(1);
			  
		  },
		  error	  : function(err){
			  alert(err.responseText);
		  }
	  });

  }

  
  function comment_list(page){
	  
	  global_comment_page = page;
	  
	  //Ajax로 목록 요청
	  $.ajax({
		  
		  url		:	"comment_list.do",
		  data		:	{"b_idx": "${ vo.b_idx }", "page" : page},
		  success	:	function(result_data){
			            
			            
			            $("#disp").html(result_data);
			            
		  },
		  error  	:	function(err){
			  alert(err.responseText);
		  }
	  });
	  
  }
</script>



</head>
<body>
<div>
   <textarea id="cmt_content" placeholder="댓글은 로그인 하신후 작성가능합니다" ></textarea> &nbsp;
   <input    id="btn_comment" type="button" value="댓글쓰기" onclick="add_comment();">
</div>
<hr>
<div id="disp"></div>
</body>
</html>