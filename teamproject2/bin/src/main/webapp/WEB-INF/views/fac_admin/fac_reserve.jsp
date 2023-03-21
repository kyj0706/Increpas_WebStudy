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
  <link href="css/ruang-admin.min.css" rel="stylesheet">
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  <style>
    .fac_view_btn{
      width: 50px;
      height: 30px;
    }
  </style>
</head>

<body id="page-top">
  <div id="wrapper">
     <!-- Sidebar -->
    <jsp:include page="../include/sellerSideBar.jsp"></jsp:include>
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <!-- TopBar -->
       <jsp:include page="../include/sellerTopBar.jsp"></jsp:include>
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
                  <th>예약 번호</th>
                  <th>예약 회원 이름</th>
                  <th>시설 이름</th>
                  <th>종목</th>
                  <th>예약 날짜</th>
                  <th>예약 시간</th>
                  <th>예약 상태</th>
                  <th>VIEW</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>예약 번호</th>
                  <th>예약 회원 이름</th>
                  <th>시설 이름</th>
                  <th>종목</th>
                  <th>예약 날짜</th>
                  <th>예약 시간</th>
                  <th>예약 상태</th>
                  <th>VIEW</th>
                </tr>
              </tfoot>
            <!-- 데이터 들어오는 부분 -->
              <tbody>
              <c:forEach items="${map.list }" var="reservationVo">
                <tr>
                  <td>${reservationVo.reser_no }</td>
                  <td>${reservationVo.m_name }</td>
                  <td>${reservationVo.finfo_name }</td>
                  <td>${reservationVo.finfo_sport }</td>
                  <td>${reservationVo.reser_date }</td>
                  <td>${reservationVo.reser_time }</td>
                  <c:if test="${reservationVo.reser_status == '0' }">
                  	<td>예약완료</td>
                  </c:if>
                  <c:if test="${reservationVo.reser_status == '1' }">
                  	<td style="color: red;">예약취소</td>
                  </c:if>
                  <td><a href="payment?reser_no=${reservationVo.reser_no }">VIEW</a></td>
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

   <!-- Page level plugins -->
   <script src="vendor/datatables/jquery.dataTables.min.js"></script>
   <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
 
   <!-- Page level custom scripts -->
   <script>
     $(document).ready(function () {
       $('#dataTable').DataTable(); // ID From dataTable 
       $('#dataTableHover').DataTable(); // ID From dataTable with Hover
     });
   </script>
</body>

</html>