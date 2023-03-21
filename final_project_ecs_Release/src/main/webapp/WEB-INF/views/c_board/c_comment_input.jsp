<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script><link rel="stylesheet" 
      href="${ pageContext.request.contextPath }/resources/css/c_board.css">
<script type="text/javascript">
$(document).ready(function(){
	c_comment_list(1);	
});
</script>
<script type="text/javascript">
function add_comment(){
	
	if("${empty user}" == "true"){
		if(confirm("댓글은 로그인 후 가능합니다.\n 로그인 하시겠습니까?")==false)return;
		location.href="../c_member/login_form.do?url=" + encodeURIComponent(location.href);
		return;
	}
	var c_cmt_content = $("#c_cmt_content").val().trim();
	console.log(c_cmt_content);
	if(c_cmt_content==''){
		alert('댓글을 입력하세요!');
		$("#c_cmt_content").c_cmt_content.value='';
		$("#c_cmt_content").c_cmt_content.focus();
		return;
	   }
	$.ajax({
		url      : "comment_insert.do",
		data     : { "c_cmt_content" : c_cmt_content,
					 "c_b_idx"       : "${ vo.c_b_idx }",
					 "c_mem_idx"	 : "${ user.c_mem_idx }",
					 "c_mem_id"	   	 : "${ user.c_mem_id }",
					 "c_mem_name"	 : "${ user.c_mem_name }"
				   },
		dataType : "json",
		success  : function(result_data){
			//result_data = { "result" : success } or { "result" : "fail" }
			$("#c_cmt_content").val(""); //실패 했을 경우
			if(result_data.result=='fail'){
				alert('댓글등록 실패!!');
				return;
			}
			//성공 했을 경우
			c_comment_list(1);
		},
		error	 : function(err){
			       alert(err.responseText);
			       console.log(11);
		}
	});
}

function c_comment_list(page){
	$.ajax({
		url      : "comment_list.do",
		data     : { 
					 "c_b_idx"       : "${ vo.c_b_idx }",
					 "page"	         : page
				   },
		success  : function(result_data){
				   $("#disp").html(result_data);
		},
		error	 : function(err){
			       alert(err.responseText);
		}
	});
}
</script>



</head>
<body>
<div>
   <textarea id="c_cmt_content" placeholder="댓글은 로그인 하신후 작성가능합니다" ></textarea> &nbsp;
   <input    id="btn_comment" type="button" value="댓글쓰기" onclick="add_comment();">
</div>
<hr>
<div id="disp" style="background-color: rgb(232, 255, 240);"></div>
</body>
</html>