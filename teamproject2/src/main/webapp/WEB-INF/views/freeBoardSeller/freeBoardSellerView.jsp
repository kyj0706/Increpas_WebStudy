<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/view1.css" rel="stylesheet">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function write_btn(){

	  location.href="freeBoardSellerWrite?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
	}
	
function returnFreeBoardList(){
	location.href="freeBoardSellerList?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
}
function nextView(){
	location.href = "freeBoardSellerView?fbs_num=${map.nextView.fbs_num}&page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
}
function preView(){
	location.href = "freeBoardSellerView?fbs_num=${map.preView.fbs_num}&page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
	
}
function deleteView(){
	if(confirm("정말로 삭제하시겠습니까?")==true){
		 $.ajax({
             url: "/freeBoardSellerDelete",
             type: "post",
             data:{
             	"fbs_num":${param.fbs_num}
             	},
             success: function(data){
             	location.href = "freeBoardSellerList?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
             },
             error: function(){
                alert("삭제 실패");
             }
         }); 
	
	}
}
function modifyView(){
		location.href = "freeBoardSellerModifyView?fbs_num=${param.fbs_num}&page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
	
}
function commentWrite(){
	alert("댓글 테스트");
		 $.ajax({
            url: "/freeBoardSellerCommentWrite",
            type: "post",
            data:{
            	"c_content": $("#comment_input").val(),
            	"fbs_num":"${param.fbs_num}",
            	"fm_id" :"${session_id}"
            	},
            success: function(data){
            	alert("댓글성공");
            	alert(data.fmsCommentVo.fm_id);
            	var html = '';
            	html += '<div class="body_footer_comment" id = "'+data.fmsCommentVo.c_no+'"> ';
            	html += '<div>';
            	html += '</div>';
            	html += '<div>';
            	html += '<div id="body_footer_inform_div1">';
            	html += '<div id="body_footer_inform_nickname">';
            	html += '<span>'+data.fmsCommentVo.fm_id+'</span>';
            	html += '</div>';
            	html += '<div id="body_footer_inform_comment">';
            	html += '<span>'+data.fmsCommentVo.c_content+'</span>';
            	html += '</div>';
            	html += '<div id="body_footer_inform_date">';
            	html += '<span>';
            	html += data.fmsCommentVo.c_date+'&nbsp;';
            	html += '<a onclick = "commentMoifyBtn('+data.fmsCommentVo.c_no+',\''+data.fmsCommentVo.fm_id+'\',\''+data.fmsCommentVo.c_content+'\',\''+data.fmsCommentVo.c_date+'\','+data.fmsCommentVo.fbs_num+')" class = "comment_fix">수정</a>';
            	html += '&nbsp;<a onclick = "commentDelete('+data.fmsCommentVo.c_no+','+data.fmsCommentVo.fbs_num+')" class = "comment_fix">삭제</a>';
            	html += '</span>';
            	html += '</div>';
            	html += '</div>';
            	html += '</div>';
            	html += '</div>';
            	
							
						
					
					
						$("#body_view_footer1").prepend(html);
						$("#comment_input").val("");
						var count = '';
						count += '&nbsp;'+data.freeBoardSellerCommentCount;
						$(".commentCount").html(count);
            },
            error: function(){
               alert("댓글 실패");
            }
        }); 
}
function commentMoifyBtn(c_no,fm_id,c_content,c_date,fbs_num){
	alert("댓글수정창 열기");
	var html = '';
	html += '<div id="body_footer_comment_write">';
	html += '<div id="body_footer_comment_nickname">';
	html += '<div id="body_footer_comment_nickname1">';
	html += '<span>'+fm_id+'</span><br>';
	html += '<input type="text" placeholder="댓글을 남겨보세요" id = "comment_input_modify" value = "'+c_content+'">';
	html += '</div>';
	html += '<div id="body_footer_comment_btn">';
	html += '<button type="button" class="btn btn-outline-secondary" id="body_footer_comment_click" onclick = "commentModify('+c_no+',\''+fm_id+'\',\''+c_content+'\',\''+c_date+'\','+fbs_num+')">수정</button>';
	html += '<button type="button" class="btn btn-outline-secondary" id="body_footer_comment_click" onclick = "commentModifyCancelBtn('+c_no+',\''+fm_id+'\',\''+c_content+'\',\''+c_date+'\','+fbs_num+')">취소</button>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	
			$("#"+c_no).html(html);
		
		
			
		
}
function commentModifyCancelBtn(c_no,fm_id,c_content,c_date,fbs_num){
	html = '';
	html += '<div>';
	html += '</div>';
	html += '<div>';
	html += '<div id="body_footer_inform_div1">';
	html += '<div id="body_footer_inform_nickname">';
	html += '<span>'+fm_id+'</span>';
	html += '</div>';
	html += '<div id="body_footer_inform_comment">';
	html += '<span>'+c_content+'</span>';
	html += '</div>';
	html += '<div id="body_footer_inform_date">';
	html += '<span>';
	html +=  c_date+'&nbsp;';
	html += '<a onclick = "commentMoifyBtn('+c_no+',\''+fm_id+'\',\''+c_content+'\',\''+c_date+'\','+fbs_num+')" class = "comment_fix">수정</a>';
	html += '&nbsp;<a onclick = "commentDelete('+c_no+','+fbs_num+')" class = "comment_fix">삭제</a>';
	html += '</span>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	
	$("#"+c_no).html(html);

}


function commentModify(c_no,fm_id,fbs_num){
	alert("댓글 수정저장 테스트");
	 $.ajax({
         url: "/freeBoardSellerCommentModify",
         type: "post",
         data:{
        	 "c_no":c_no,
        	 "c_content":$("#comment_input_modify").val()
         	},
         success: function(data){
         	alert("수정성공");
         	var html = '';
         	html += '<div class="body_footer_comment" id = "'+data.fmsCommentVo.c_no+'"> ';
         	html += '<div>';
         	html += '</div>';
         	html += '<div>';
         	html += '<div id="body_footer_inform_div1">';
         	html += '<div id="body_footer_inform_nickname">';
         	html += '<span>'+data.fmsCommentVo.fm_id+'</span>';
         	html += '</div>';
         	html += '<div id="body_footer_inform_comment">';
         	html += '<span>'+data.fmsCommentVo.c_content+'</span>';
         	html += '</div>';
         	html += '<div id="body_footer_inform_date">';
         	html += '<span>';
        	html += data.fmsCommentVo.c_date+'&nbsp;';
        	html += '<a onclick = "commentMoifyBtn('+data.fmsCommentVo.c_no+',\''+data.fmsCommentVo.fm_id+'\',\''+data.fmsCommentVo.c_content+'\',\''+data.fmsCommentVo.c_date+'\','+data.fmsCommentVo.fbs_num+')" class = "comment_fix">수정</a>';
        	html += '&nbsp;<a onclick = "commentDelete('+data.fmsCommentVo.c_no+','+data.fmsCommentVo.fbs_num+')" class = "comment_fix">삭제</a>';
        	html += '</span>';
         	html += '</div>';
         	html += '</div>';
         	html += '</div>';
         	html += '</div>';
         	
					
						$("#"+c_no).html(html);
         },
         error: function(){
            alert("댓글 실패");
         }
     });
}

function commentDelete(c_no,fbs_num){
	if(confirm("댓글을 삭제하시겠습니까?") == true){
		$.ajax({
	         url: "/freeBoardSellerCommentDelete",
	         type: "post",
	         data:{
	        	 "c_no":c_no,
	        	 "fbs_num":fbs_num
	         	},
	         success: function(data){
	         	alert("삭제성공");
	         	$("#"+c_no).remove();
	         	var count = '';
						count += '&nbsp;'+data;
						$(".commentCount").html(count);
	         },
	         error: function(){
	            alert("댓글 실패");
	         }
	     });
	}else{
		return false;
	}
}
</script>
<style type="text/css">
	.comment_fix{
		color: black;
		text-decoration: none;
	}
	.comment_fix:hover{
		cursor: pointer;
	}
	.commentCount{
		font-weight: bold;
	}
	.view_img{
		text-align: center;
	}
	.img{
		display: inline-block;
		
	}
		#img_style{
		width: 1280px;
		height: 960px;
	}
	#logo{
		padding: 30px;
	}
</style>

</head>
<body>
	<div id="div">
		<div id="header_div">
			<div id="header_img">
				<div id="logo">
					<a href="main"><img src="img/logo.png" alt="" title="" /></a>
				</div>
			</div>
		</div>
		<div id="body_div">
			<!--  게시판 뷰 버튼 부분   -->
			<div id="body_view_header_btn">
			<c:if test="${map.nextView.fbs_num != null }">
				<button type="button" class="btn btn-outline-secondary" id="btn_next" onclick = "nextView()">다음글</button>
			</c:if>
			<c:if test="${map.preView.fbs_num != null }">
				<button type="button" class="btn btn-outline-secondary" id="btn_pre" onclick = "preView()">이전글</button>
			</c:if>
				<button type="button" class="btn btn-outline-secondary" id="btn_list" onclick = "returnFreeBoardList()">목록</button>
			</div>
			<!--  게시판 뷰 버튼 부분   -->
			<!--  게시판 뷰 부분   -->
			<div id="body_view_div">
		<!--  게시판 뷰 타이틀 부분   -->
				<div id="body_view_header">
					<div id="body_view_header1">
						<div>
							<div id="body_view_title">
								<span>자유게시판</span>
								<h3>${map.freeBoardSellerVo.fbs_title }</h3>
							</div>
							<div id="body_view_inform">
								<div id="body_view_inform_div1">
									<div id="body_view_inform_nickname">
										<span>${map.freeBoardSellerVo.fm_id }</span>
									</div>
									<div id="body_view_inform_date">
										<span>${map.freeBoardSellerVo.fbs_date }</span>
										<span>조회${map.freeBoardSellerVo.fbs_hit }</span>
									</div>
								</div>
								<div id="body_view_inform_comment">
									<span>댓글</span><span class = "commentCount">&nbsp;${map.freeBoardSellerCommentCount}</span>
								</div>
							</div>
						</div>
					</div>
				</div>
		<!--  게시판 뷰 타이틀 부분   -->
		<!--  게시판 뷰 몸통 부분   -->
				<div id="body_view_body">	
					<div id="body_view_body1">
						<div id="body_view_content">
							${map.freeBoardSellerVo.fbs_content}
							<c:if test="${fn:length(map.imgList) != 0 }">
								<c:forEach items="${map.imgList }" var = "file">
									<div class = "view_img">
										<div class = "img">
											<img id="img_style" src="./freeSeller/${file.img_name }" >
										</div>
									</div>
								</c:forEach>
							</c:if>
						</div>
						<div id="body_view_comment">
							<div id="body_view_comment1">
								<span>댓글</span><span class = "commentCount">&nbsp;${map.freeBoardSellerCommentCount}</span>
							</div>
						</div>
					</div>
				</div>
		<!--  게시판 뷰 몸통 부분   -->
		<!--  게시판 뷰 다리 부분   -->
				<div id="body_view_footer">
					<div id="body_view_footer1">
						<!-- 댓글 view-->
							<c:forEach items="${map.commentList }" var="comment">
						<div class="body_footer_comment" id = "${comment.c_no }">
							<div>
							</div>
								<div>
									<div id="body_footer_inform_div1">
										<div id="body_footer_inform_nickname">
											<span>${comment.fm_id }</span>
										</div>
										<div id="body_footer_inform_comment">
											<span>${comment.c_content }</span>
										</div>
										<div id="body_footer_inform_date">
											<span>
											${comment.c_date }&nbsp;
											<c:if test="${(session_id == comment.fm_id) || (session_id == 'admin')}">
												<a onclick = "commentMoifyBtn(${comment.c_no },'${comment.fm_id }','${comment.c_content }','${comment.c_date }','${comment.fbs_num }')" class = "comment_fix">수정</a>
												&nbsp;<a onclick = "commentDelete(${comment.c_no},${comment.fbs_num })" class = "comment_fix">삭제</a> 
											</c:if>
											</span>
										</div>
									</div>
								</div>
						</div>
							</c:forEach>
						<!-- 댓글 view-->
						<!-- 댓글 write-->
						<div id="body_footer_comment_write">
							<div id="body_footer_comment_nickname">
								<div id="body_footer_comment_nickname1">
									<span>${session_id }</span><br>
									<input type="text" placeholder="댓글을 남겨보세요" id = "comment_input">
								</div>
								<div id="body_footer_comment_btn">
									<button type="button" class="btn btn-outline-secondary" id="body_footer_comment_click" onclick = "commentWrite()">작성</button>
								</div>
							</div>
						</div>
						<!-- 댓글 write-->
					</div>
					
				</div>
		<!--  게시판 뷰 다리 부분   -->
			</div>	
		
		<!--  게시판 뷰 버튼 부분   -->
		<div id="body_view_bottom_btn">
			<div id="body_view_bottom_btn1">
				<div id="body_view_bottom_btn_left">
					<button type="button" class="btn btn-outline-secondary" id="btn_write" onclick = "write_btn()">글쓰기</button>
				</div>
					<div id="body_view_bottom_btn_right">
				<c:if test="${(map.freeBoardSellerVo.fm_id == session_id)}">
						<button type="button" class="btn btn-outline-secondary" id="btn_modify" onclick = "modifyView()">수정</button>
						<button type="button" class="btn btn-outline-secondary" id="btn_delete" onclick = "deleteView()">삭제</button>
				</c:if>
						<c:if test="${session_id == 'admin' }">
								<button type="button" class="btn btn-outline-secondary" id="btn_delete" onclick = "deleteView()">삭제</button>
						</c:if>
					</div>
			</div>
			
		</div>
		
		<!--  게시판 뷰 버튼 부분   -->
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
	</div>
</body>
</html>
