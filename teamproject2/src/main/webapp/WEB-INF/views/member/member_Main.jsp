<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="utf-8">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="img/logo/logo.png" rel="icon">
  <title>Team of Yul</title>
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="css/member/ruang-admin.min.css" rel="stylesheet">



  
      <c:if test="${session_member != 'member' }">
 		 <script type="text/javascript">
  	 	 alert("잘못된 경로입니다")
  		 location.href="login"
  		 </script>
  		</c:if>

<style type="text/css">
.box{
	width: 100%;
	text-align: center;
}
.box_outline{
	display: inline-block;
    width: 500px;
    height: 300px;
    margin-left: 30px;
    margin-top: 50px;
    background-color: white;
    border:1px solid #dadada;
		text-overflow: ellipsis;	
}
.my_title{
	margin-left:20px;
	margin-top:10px;
	font-size:30px;
	font-weight: bold;
	text-align: left;
}
.info_table{
	display: inline-block;
	margin-top:50px;
	font-size:20px;
	text-align: left;
}
.my_info{
	text-align: left;
	margin-left:20px;
}
#info_fix_btn{
	float: left;
	margin-left:20px;
	margin-top:10px;
	padding: 5px 10px;
	background-color: white;
	border:1px solid #dadada;
}
.n_title{
	width:374px;
}
.n_date{
	float: right;
}
.info_a{
	color: #757575;
}
.info_a:hover {
	color: #757575;
	text-decoration: none;
}
.q_td{
	font-size:20px;
}

.box{
	display: inline-block;
	width: 1000px;
	
}

</style>
<script type="text/javascript">
	function my_info_fix(){
		location.href="member_Modify";
	}
</script>
</head>

<body id="page-top">
  <div id="wrapper">
    <!-- Sidebar -->
    <jsp:include page="../include/memberSideBar.jsp"></jsp:include>
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <!-- TopBar -->
       <jsp:include page="../include/memberTopBar.jsp"></jsp:include>
        <!-- Topbar -->
        
        <!-- 구현 부분-->
       <div id = box_div>
  			<div class = box>
  				<div class =box_outline>
  					<div class = "my_title">내정보</div>
  					<div class = "my_info">
  						<table class = "info_table">
  							<tr>
  								<td>이름</td>
  								<td>${map.mVo.m_name }</td>
  							</tr>
  							<tr>
  								<td>번호</td>
  								<td>${map.mVo.m_phone }</td>
  							</tr>
  							<tr>
  								<td>이메일</td>
  								<td>${map.mVo.m_email }</td>
  							</tr>
  						</table>
  					</div>
  						<button id = "info_fix_btn" onclick = "my_info_fix()">수정</button>
  				</div>
  				<div class =box_outline>
  					<div class = "my_title"><a href = "member_reserve" class = "info_a">내 예약내역</a></div>
  					<div class = "my_info">
  						<table class = "info_table">
  						<c:forEach items="${map.rList }" end = "3" var = "rVo">
  							<tr class = "reser_tr">
  								<td><a href = "payment?reser_no=${rVo.reser_no }" class = "info_a">
  								[${rVo.reser_date }]${rVo.finfo_name }(${rVo.reser_time })
  								</a></td>
  							</tr>
  						</c:forEach>
  						</table>
  					</div>
  					
  				</div>
  			</div>
       </div>
  			
  			<div class = box>
  				<div class =box_outline>
  					<div class = "my_title"><a href = member_qua class = "info_a">내 문의내역</a></div>
  					<div class = "my_info">
  						<table class = "info_table">
  						<c:forEach items="${map.qList }" end="3" var = "qBoardVo">
  							<tr class = "reser_tr">
  								<td class = "q_td"><a href = "qBoardView?q_num=${qBoardVo.q_num }" class = "info_a">
  								[
  								<c:if test="${qBoardVo.q_status == '0' }">
  									답변대기
  								</c:if>
  								<c:if test="${qBoardVo.q_status == '1' }">
  									답변완료
  								</c:if>
  								]
  								${qBoardVo.q_title }
  								</a></td>
  							</tr>
  						</c:forEach>
  						</table>
  					</div>
  				</div>
  			</div>
  
      </div>

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by <b><a href="https://indrijunanda.gitlab.io/"
                  target="_blank">indrijunanda</a></b> </span>
          </div>
        </div>
      </footer>

    </div>
  </div>
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/ruang-admin.min.js"></script>
</body>

</html>