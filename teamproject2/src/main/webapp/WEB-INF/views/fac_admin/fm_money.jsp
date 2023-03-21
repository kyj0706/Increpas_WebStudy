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
   <link href="css/fac_register.css" rel="stylesheet"> 
   <c:if test="${session_member != 'seller' }">
        <script type="text/javascript">
          alert("잘못된 경로입니다")
         location.href="login"
         </script>
     </c:if>
<style type="text/css">
	.cancel_span{
		color: #ca273d;
		font-weight: bold;
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
        
        
        <!-- 정산 시작 -->
        <DIV>
           <div>
              <div id="title_div">
                 <h3 style="margin: 15px;">정산 관리</h3>
                 <hr>
              </div>
              
             <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
               <h6 class="m-0 font-weight-bold text-primary">판매정산 현황</h6>
             </div>
             <table class="table align-items-center table-flush table-hover" style="border:1px solid black; padding: 20px;">
                <thead class="thead-light">
                      <tr>
                        <th>판매 금액(A)</th>
                        <th>환불 금액(B)</th>
                        <th>정산 예정금액(A-B)</th>
                      </tr>
                 </thead>
                 <tbody>
                       <tr>
                        <td>${map.totalPrice }원</td>
                        <td>${map.totalRefund }원</td>
                        <td>${map.totalPrice-map.totalRefund}원</td>
                      </tr>
                 </tbody>
              </table>   
             <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
               <h6 class="m-0 font-weight-bold text-primary">판매 상세내역</h6>
             </div>
             <div class="table-responsive p-3">
               <table class="table align-items-center table-flush table-hover" id="dataTableHover">
                 <thead class="thead-light">
                   <tr>
                     <th>예약 번호</th>
                     <th>구매자 이름</th>
                     <th>결제 상태</th>
                     <th>결제 금액</th>
                     <th>환불 금액</th>
                     <th>결제 완료일</th>
                     <th>환불 완료일</th>
                   </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${map.list }" var = "paymentVo">
                   <c:if test="${paymentVo.pay_status == '0' }">
                   <tr>
                     <td>${paymentVo.reser_no }</td>
                     <td>${paymentVo.m_name }</td>
                     <c:if test="${paymentVo.pay_status == '0' }">
	                     <td>결제완료</td>
                     </c:if>
                     <c:if test="${paymentVo.pay_status == '1' }">
	                     <td>결제취소</td>
                     </c:if>
                     <td>${paymentVo.pay_price }원</td>
                     <td></td>
                     <td>${paymentVo.pay_date }</td>
                     <td></td>
                   </tr>
                   </c:if>
                   <c:if test="${paymentVo.pay_status == '1' }">
                   <tr>
                     <td>${paymentVo.reser_no }</td>
                     <td>${paymentVo.m_name }</td>
                     <td>결제완료</td>
                     <td>${paymentVo.pay_price }원</td>
                     <td></td>
                     <td>${paymentVo.pay_date }</td>
                     <td></td>
                   </tr>
                   <tr>
                     <td>${paymentVo.reser_no }</td>
                     <td>${paymentVo.m_name }</td>
                     <td><span class = "cancel_span">결제취소</span></td>
                     <td></td>
                     <td><span class = "cancel_span">${paymentVo.pay_price }</span>원</td>
                     <td></td>
                     <td>${paymentVo.refund_date }</td>
                   </tr>
                   </c:if>
                 </c:forEach>
                 </tbody>
               </table>
             </div>
           </div>
             
        </DIV>

      </div>
   <!-- 정산 끝 -->
      
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