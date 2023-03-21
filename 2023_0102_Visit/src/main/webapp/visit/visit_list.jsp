<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <!--  강사님은 필요없다... 근데. subString을 써야하지 않나 ??라는 개인 의견   -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설명 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<style type="text/css">
	#box{
		width: 500px;
		margin: auto;
		margin-top: 20px;
	}

	#title{
		text-align: center;
		font-size: 50px;
		color: white;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	}
	
	#empty_message{
		text-align: center;
		color: red;
		font-size: 30xp;
		font-weight: 
		
	}
	.content{
		min-height: 50px;
		border: 1px solid gray;
		box-shadow: -1px -1px 1px black;
		padding: 5px;
	}
	.regdate, .pwd{
		border: 1px solid gray;
		box-shadow: 1px 1px 1px black;
		padding: 5px;
		margin-top: 10px;
		text-align: right;
	}

</style>
<script type="text/javascript">

	function del(f){
		
		var idx = f.idx.value;
		var pwd = f.pwd.value; //DB상 pw
		 
		var c_pwd = f.c_pwd.value.trim(); //입력된 pw
		
		//비교
		if(pwd != c_pwd){
			alert("비밀번호가 틀리다 !! ");
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}
		
		//삭제확인
		/* if(confirm("정말 삭제 할거야?")==false)return; */
		
		Swal.fire({
			  title: '삭제할꺼야??',
			  text: "삭제된다?????",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '삭제!',
			  cancelButtonText: '취소!',
		}).then((result) => {
		  if (result.isConfirmed) { //확인버튼 클릭시
			  location.href ="delete.do?idx="+idx;
		  }
		});
		
		
		
		
		//location.href ="delete.do?idx="+idx;
		
		
	}
	
	
	function modify_form(f) {
		
		var idx = f.idx.value;
		var pwd = f.pwd.value; //DB상 pw
		 
		var c_pwd = f.c_pwd.value.trim(); //입력된 pw
		
		//비교
		if(pwd != c_pwd){
			alert("비밀번호가 틀리다 !! ");
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}
		
		/* //수정확인 확인
		if(confirm("정말 수정 할거야?")==false)return; */
		
		
		
		location.href = "modify_form.do?idx=" + idx;
	}




</script>



</head>
<body>
  <div id="box"> 
     <h1 id="title">::::방 명 록::::</h1>
     <div style="text-align: right; margin-bottom: 10px;">
         <input class="btn btn-primary" type="button"  value="글쓰기" onclick="location.href='insert_form.do'">
     </div> 
     
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
        	<input type="hidden" name="pwd" value="${vo.pwd }">
        	<input type="hidden" name="idx" value="${vo.idx }">
	        <!-- 출력 -->
            <div id="v_${vo.idx }" class="panel panel-primary">
			      <div class="panel-heading"><h4><b>${ vo.name }</b>님이 글:</h4></div>
			      <div class="panel-body">
			      		<div class="content">${ vo.content }</div>
			      	
			      	<!-- 시간 & ip -->	
			      		<%-- <div class="regdate">작성일자:${ fn:substring(vo.regdate,0,19) }(${vo.ip })</div> --%>
			      		<div class="regdate">작성일자:${ fn:substring(vo.modifydate,0,19) }(${vo.ip })</div>
			      		<div class="pwd">
			      			비밀번호${vo.pwd }:<input type="password" name="c_pwd">
			      					<input class="btn btn-info" type="button" value="수정" onclick="modify_form(this.form);">
			      					<input class="btn btn-danger" type="button" value="삭제" onclick="del(this.form);">
			      		</div>
			          
			      </div>
			</div>
			</form>
        </c:forEach>
             
     </div>     
  </div>
</body>
</html>