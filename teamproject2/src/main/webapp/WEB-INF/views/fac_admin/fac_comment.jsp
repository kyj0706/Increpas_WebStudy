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
  
    <c:if test="${session_member != 'seller' }">
 		 <script type="text/javascript">
  	 	 alert("잘못된 경로입니다")
  		 location.href="login"
  		 </script>
  	</c:if>

<style type="text/css">
	.star_check{
		background-repeat: no-repeat;
    background-image: url(../img/star_on.png);
    display: inline-block;
    width: 20px;
    height: 20px;
    background-size: contain;
}
.star_non_check{
	background-repeat: no-repeat;
    background-image: url(../img/star_none.png);
    display: inline-block;
    width: 20px;
    height: 20px;
    background-size: contain;
	
}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#finfo_name").change(function(){
		$.ajax({
             url: "finfoComment",
             type: "post",
             data:{
             	"finfo_name":$("#finfo_name").val(),
             	"fm_id":"${session_id}"
             	},
             success: function(data){
            	    var reviewVo = data.list;
                    var rHtml = '';
                    for(var i=0; i<reviewVo.length; i++){
                       var r_rate = (reviewVo[i].r_rate);
                       rHtml += '<tr>';
                       rHtml += '<td>'+reviewVo[i].r_no +'</td>';
                       rHtml += '<td>'+reviewVo[i].r_content +'</td>';
                       rHtml += '<td>'+reviewVo[i].m_name +'</td>';
                       rHtml += '<td>'+reviewVo[i].r_date +'</td>';
                       rHtml += '<td>';
                       rHtml += '<div class="rating_star">';
                       for(var j=1; j<=r_rate; j++){
                       rHtml += '<div class = "star_check"></div>';
                       }
                       for(var k=1; k<=5-r_rate; k++){
                       rHtml += '<div class = "star_non_check"></div>';
                       }
                       rHtml += '</div>';
                       rHtml += '</td>';
                       rHtml += '</tr>';
                    }
                 
               $("#review").html(rHtml);
             },
             error: function(){
                alert("실패");
             }
         }); 
	});
});
</script>
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
        <select id = "finfo_name">
        	<option value="" >선택</option>
        	<c:forEach items="${map.finfo_name }" var = "finfo_name">
        	<option value = "${finfo_name }">${finfo_name }</option>
        	</c:forEach>
        </select>
        <DIV>
          <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">후기 댓글 현황</h6>
          </div>
          <div class="table-responsive p-3">
            <table class="table align-items-center table-flush table-hover" id="dataTableHover">
              <thead class="thead-light">
                <tr>
                  <th>NO.</th>
                  <th>후기 내용</th>
                  <th>회원 이름</th>
                  <th>날짜</th>
                  <th>별점</th>
                </tr>
              </thead>
              <tbody id = "review">
              </tbody>
            <!-- 데이터 들어오는 부분 -->
              <tbody>

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