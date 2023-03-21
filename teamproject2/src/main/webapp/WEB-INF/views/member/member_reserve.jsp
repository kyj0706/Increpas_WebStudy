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
  <link href="css/member/member_register.css" rel="stylesheet">
       <c:if test="${session_member != 'member' }">
 		 <script type="text/javascript">
  	 	 alert("잘못된 경로입니다")
  		 location.href="login"
  		 </script>
  	</c:if>
  
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
        <DIV>
          <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">예약 목록 현황</h6>
          </div>
          <div class="table-responsive p-3">
            <table class="table align-items-center table-flush table-hover" id="dataTableHover">
              <thead class="thead-light">
                <tr>
                  <th>NO.</th>
                  <th>시설 이름</th>
                  <th>시설 가격</th>
                  <th>신청 날짜</th>
                  <th>예약 날짜</th>
                  <th>예약 시간</th>
                  <th>예약상태</th>
                  <th>VIEW</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>NO.</th>
                  <th>시설 이름</th>
                  <th>시설 가격</th>
                  <th>신청 날짜</th>
                  <th>예약 날짜</th>
                  <th>예약 시간</th>
                  <th>예약상태</th>
                  <th>VIEW</th>
                </tr>
              </tfoot>
            <!-- 데이터 들어오는 부분 -->
              <tbody>
              <c:forEach items="${list }" var = "rVo">
                <tr>
                  <td>${rVo.reser_no }</td>
                  <td>${rVo.finfo_name }</td>
                  <td>${rVo.finfo_price }원</td>
                  <td>${rVo.apply_date }</td>
                  <td>${rVo.reser_date }</td>
                  <td>${rVo.reser_time }</td>
                  <c:if test="${rVo.reser_status == '0' }">
                  	<td>예약완료</td>
                  </c:if>
                  <c:if test="${rVo.reser_status == '1' }">
                  	<td>예약취소</td>
                  </c:if>
                  <td><a href="payment?reser_no=${rVo.reser_no }">VIEW</a></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
          
        </DIV>
  
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