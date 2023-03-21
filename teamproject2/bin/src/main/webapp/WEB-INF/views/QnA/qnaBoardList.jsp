<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/list.css" rel="stylesheet">
<script src="./js/list.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function write_btn(){

	  location.href="qnaBoardWrite?page=${map.page }&searchCategory=${map.searchCategory}&sportsCategory=${map.sportsCategory }&searchWord=${map.searchWord}";
	}
</script>
<style type="text/css">
.list_title_a {
	color: black;
}

.table_category {
	border: 4px solid #ff8595;
	border-radius: 10px;
	color: #ff8595;
	font-weight: bold;
	font-size: 20px;
}

#qna {
	background-color: #f3f0ff;
}

#ul_nav li:first-of-type {
	background-color: white;
}

#qna_list {
	text-align: center;
	list-style: none;
}

#qna_list>li {
	display: inline-block;
	padding: 2px;
}

#qna_nav {
	background: #fbfbfb;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #f8f8f8;
}

#qna_nav a {
	display: block;
	line-height: 30px;
	padding: 0 15px;
	font-size: 14px;
	border-radius: 3px;
	border: 1px solid transparent;
	font-weight: bold;
	color: black;
}

#qna_nav a:hover, #qna_cate a:active {
	text-decoration: none;
	border: 1px solid #999;
}

#qna_nav #li_on {
	z-index: 2;
    background: #242424;
    color: #fff;
    font-weight: bold;
}
/* div{
	border:1px solid black;
} */
#qna_div{
	display: inline-block;
	width:60%;
	height: 100%;
	
}
#qna_outline{
	text-align: center;
	border-top: 2px solid #e5e5e5;
	border-bottom: 2px solid #e5e5e5;
}
.qna_title{
width: 100%;
font-size: 30px;
text-align: left;
margin-bottom: 10px;	
border-bottom: 1px solid #e5e5e5;
}
.qna_content{
	width:100%;
	border-bottom: 1px solid #e5e5e5;
}
.qna_title_logo{
	display:inline-block;
	font-size: 30px;
	margin-left:10px;
}
.qna_title_content{
	display: inline-block;
}
.qna_title_category{
	display: inline-block;
	color: #c89b43;
	font-size:20px;
}
.qna_content_open_btn{
	background-color: white;
	border: 1px solid white;
}
.content_btn_div{
	display: inline-block;
	margin-top: 10px;
}
.qna_content_logo{
	display:inline-block;
	font-size: 30px;
	margin-left:10px;
}
.qna_content{
	text-align: left;
	background-color: #fafafa;
}
.qna_cotent_text{
	width: 70%;
	margin-left: 10px;
	font-size: 25px;
    color: #444;
}
.content_click{
	color:black;
}
.content_click:hover{
	cursor: pointer;
}
.qna_modify_btn,.qna_delete_btn{
	border: 0;
	background-color:white;
	font-size: 16px;
}
#footer_div_btn {
    margin-top: 50px;
    display: inline-block;
    width: 80%;
    text-align: right;
    margin-right: 50px;
}

#logo{
		padding: 30px;
	}
</style>
<script type="text/javascript">

	function open_qna_content(i) {
		if ($("#open"+i).css("display") == "none") {
			$("#open"+i).show("slow");
			$("#close"+i).hide("slow");
			$("#cont"+i).show("slow");
		} else {
			$("#close"+i).show("slow");
			$("#open"+i).hide("slow");
			$("#cont"+i).hide("slow");
		}

	}
	
	function qna_modify(qb_num){
		location.href = "qnaBoardModify?qb_num="+qb_num +"&category=${map.category}";
	}
	function qna_delete(qb_num){
		 $.ajax({
	         url: "qnaBoardDelete",
	         type: "post",
	         data:{
	         	"qb_num":qb_num,
	         	},
	         success: function(data){
	         	location.href = "qnaBoardList?page=${param.page }&category=${param.category}";
	         },
	         error: function(){
	            alert("수정 실패");
	         }
	     }); 
	}
	function qWirte_btn(){
		location.href = "qBoardWrite";
	}
	function qList_btn(){
		location.href = "qBoardList";
	}
</script>
</head>
<body>
	<div id="div">
		<jsp:include page="../include/header.jsp"></jsp:include>
		<div id="body_div">
				<div id="body_nav">
					<div id="div_nav">
					<jsp:include page="../include/nav.jsp"/>
						
								<div id = "qna_nav">
									<ul id = "qna_list">
										<li class = "qnaList"><a href = "qnaBoardList?category&page=${map.page }" <c:if test="${(param.category == '') || (param.category == null)}">id = "li_on"</c:if>>전체</a></li>
										<li class = "qnaList"><a href = "qnaBoardList?category=결제&page=${map.page }" <c:if test="${param.category == '결제'}">id = "li_on"</c:if>>결제</a></li>
										<li class = "qnaList" ><a href = "qnaBoardList?category=예약&page=${map.page }" <c:if test="${param.category == '예약'}">id = "li_on"</c:if>>예약</a></li>
										<li class = "qnaList" ><a href = "qnaBoardList?category=기타&page=${map.page }" <c:if test="${param.category == '기타'}">id = "li_on"</c:if>>기타</a></li>
										<li class = "qnaList"><a></a></li>
									</ul>
								</div>
						
						
					</div>
				</div>
				<div id = "qna_outline">
					<div id = "qna_div">
					<c:forEach items="${map.list }" var = "qnaBoardVo">
						<div class = "qna_all">
							<div class = "qna_title">
								<div class = "qna_title_logo" >Q.</div>
								<a onclick = "open_qna_content(${qnaBoardVo.qb_num})" class = "content_click">
								<span class = "qna_title_category">[${qnaBoardVo.qb_category }]</span>
								${qnaBoardVo.qb_title } 
								</a>
								<c:if test="${session_member == 'admin' }">
									<button class = "qna_modify_btn" onclick = "qna_modify(${qnaBoardVo.qb_num})">수정</button>
									<button class = "qna_delete_btn" onclick = "qna_delete(${qnaBoardVo.qb_num})">삭제</button>
								</c:if>
								<div class = "content_btn_div">
									<a style="display: none"id = "open${qnaBoardVo.qb_num}">▲</a>
									<a id = "close${qnaBoardVo.qb_num}">▼</a>
								</div>
							</div>
							<div class = "qna_content" id = "cont${qnaBoardVo.qb_num}" style = "display: none">
									<div class = "qna_content_logo">A</div>
									<div class = "qna_cotent_text" >
										${qnaBoardVo.qb_content }
									</div>
							</div>
						</div>
					</c:forEach>
						
					</div>
				</div>
				<div id="footer_div_btn">
					<c:if test="${session_member != 'admin' }">
						<button type="button" class="btn btn-outline-secondary" id="btn_write" onclick = "qWirte_btn()">1대1문의</button>
					</c:if>
					</div> 
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
	</div>
</body>
</html>
