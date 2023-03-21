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
        
        <!-- 게시물 라인-->
        <DIV id="body_div">
          <div>
            <div id="title_div">
                <h3>시설 관리자 정보 관리</h3>
                <hr>
            </div>
            <div id="fac_inform">
              <div id="fac_inform_blank">
              </div>
              <div id="fac_inform_div1">
                  <span>시설 관리자 정보</span>
              </div>
              <div id="fac_inform_input">
                <div id="fac_inform_input1">
                  <form>
                    <div class="form-group" id="fac_input">
                      <label for="exampleInputEmail1">시설 관리자 아이디</label>
                      <input type="text" class="form-control" placeholder="시설 관리자 아이디" value="${fVo.fm_id }" readonly="readonly">
                      
                      <label for="exampleInputPassword1">시설관리자 이름</label>
                      <input type="text" class="form-control" placeholder="시설 이름" value="${fVo.fm_name }" readonly="readonly">
                      
                      <label for="exampleInputPassword1">시설관리자 주소</label>
                      <input type="text" class="form-control" placeholder="시설 주소" value="${fVo.fm_add1 }" readonly="readonly">
                      
                      <label for="exampleInputPassword1">시설관리자 번호</label>
                      <input type="text" class="form-control" placeholder="사업자 전화번호" value="${fVo.fm_phone }" readonly="readonly">
                      
                      <label for="exampleInputPassword1">사업자 번호</label>
                      <input type="text" class="form-control" placeholder="사업자 번호" value="${fVo.fm_cor_num }" readonly="readonly">
                      
              
                    <a href="fm_modify" class="btn btn-primary" id="fac_save">수정</a>
                    <a href="fm_main" class="btn btn-primary" id="fac_save">확인</a>
                  </form>
                </div>

              </div>
            </div>
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