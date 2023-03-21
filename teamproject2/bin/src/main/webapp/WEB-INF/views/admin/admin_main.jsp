<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <link href="css/ruang-admin.min.css" rel="stylesheet">
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  
  
  <c:if test="${session_member != 'admin' }">
  <script type="text/javascript">
  	alert("잘못된 경로입니다")
  	location.href="login"
  </script>
  </c:if>
  
  <style type="text/css">
		.box_outline{
			display: inline-block;
			width: 100%;
			text-align: center;
		}
		.info_box_outline{
			width:250px;
			height: 250px;
			border-radius: 100%;
			text-align: center;
			background-color: #ffffff;
			display: inline-block;
			border:3px solid #f7f7f7;
			margin:2%;
			
		}
		.info_div{
			margin-top:10%;
			font-size: 20px;
			color: #555;
			font-weight: bold;
			display: inline-block;
			
		}
		.info_count{
			margin-top:35px;
			font-size: 50px;
		}
		.number_span{
			color:#9a61ff; 
			font-weight: bold;
			font-size:55px;
		}
		.box{
	width: 100%;
	text-align: center;
}
.box_outline2{
	display: inline-block;
    width: 740px;
    height: 300px;
    margin-left: 30px;
    margin-top: 50px;
    background-color: white;
    border:1px solid #dadada;
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
overflow:hidden;
		white-space : nowrap;
		text-overflow: ellipsis;
}
.info_a:hover {
	color: #757575;
	text-decoration: none;
}
	</style>
</head>

<body id="page-top">
  <div id="wrapper">
    <!-- Sidebar -->
    <jsp:include page="../include/adminSideBar.jsp"></jsp:include>
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <!-- TopBar -->
        <jsp:include page="../include/adminTopBar.jsp"></jsp:include>
        <!-- Topbar -->
        
        <!-- 구현 부분-->
       <div id = "info_box">
	        <div class = "box_outline">
	        <a href = "admin_member_list">
	        	<div class = "info_box_outline">
	        		<div class = "info_div">회원 수</div>
	        		<div class = "info_count"><span class = "number_span">${map.memberCount }</span>명</div>
	        	</div>
	        </a>
	        	<div class = "info_box_outline">
	        		<div class = "info_div">시설 수</div>
	        		<div class = "info_count"><span class = "number_span">${map.fmanagerCount }</span>개</div>
	        	</div>
	        </div>
	       </div>
	       
	    <div class = box>
  				<div class =box_outline2>
  					<div class = "my_title"><a href = "noticeboard_list" class = "info_a">공지사항</a></div>
  					<div class = "my_info">
  						<table class = "info_table">
  						<c:forEach items="${map.nList }" var = "nVo" end = "3">
  							<tr class = "reser_tr">
  								<td><a href = "noticeBoardView?n_num=${nVo.n_num }" class = "info_a">
  								${nVo.n_title }(${nVo.n_date  })</a></td>
  							</tr>
  						</c:forEach>
  						</table>
  				</div>
 				</div>
  				<div class =box_outline2>
  					<div class = "my_title"><a href = "eventBoard" class = "info_a">이벤트</a></div>
  					<div class = "my_info">
  						<table class = "info_table">
  						<c:forEach items="${map.eList }" var = "eVo" end = "3">
  						<tr>
  						<td><a href = "eventBoardView?eb_num=${eVo.eb_num }" class = "info_a">
  								<fmt:parseDate var="eb_start_date" value="${eVo.eb_start_date}" pattern="yyyy-mm-dd" /> 
  								<fmt:parseDate var="eb_end_date" value="${eVo.eb_end_date}" pattern="yyyy-mm-dd" /> 
  								[${eVo.finfo_name }]${eVo.eb_title }
  								(<fmt:formatDate value="${eb_start_date}" pattern="mm-dd" />~<fmt:formatDate value="${eb_end_date}" pattern="mm-dd" />)
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
