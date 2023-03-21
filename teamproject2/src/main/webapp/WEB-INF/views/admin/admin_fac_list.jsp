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
  
  
  
  <c:if test="${session_member != 'admin' }">
  <script type="text/javascript">
  	alert("잘못된 경로입니다")
  	location.href="login"
  </script>
  </c:if>
  
  
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
        
        <!-- 구현 부분-->
        <DIV>
          <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">시설관리자 목록 현황</h6>
          </div>
          <div class="table-responsive p-3">
            <table class="table align-items-center table-flush table-hover" id="dataTableHover">
              <thead class="thead-light">
                <tr>
                  <th>NO.</th>
                  <th>시설 아이디</th>
                  <th>시설 관리자 이름</th>
                  <th>시설 주소</th>
                  <th>시설 번호</th>
                </tr>
              </thead>
              <tfoot>
	              <tr>
	                  <th>NO.</th>
	                  <th>시설관리자 아이디</th>
	                  <th>시설관리자 이름</th>
	                  <th>시설 주소</th>
	                  <th>시설 번호</th>
	                </tr>
              </tfoot>
            <!-- 데이터 들어오는 부분 -->
              <tbody>
              <c:forEach  items="${list }" var="fmanagerVo">
                <tr>
                  <td>${fmanagerVo.fm_no }</td>
                  <td>${fmanagerVo.fm_id }</td>
                  <td>${fmanagerVo.fm_name }</td>
                  <td>${fmanagerVo.fm_add1 }</td>
                  <td>${fmanagerVo.fm_phone }</td>
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
