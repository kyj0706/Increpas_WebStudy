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
  <link href="css/fac_register.css" rel="stylesheet">
  <script type="text/javascript">
  	function fac_delete(){
  		alert("test!");
  		if(confirm("삭제하시겠습니까?")){
  			location.href="fac_delete?finfo_no="+${fac_admin_Vo.finfo_no};
  		}
  	}
  </script>
  <style type="text/css">
  .custom-file{
  	display:inline-block;
  	width: 100px;
  	height: 100px;	
  }
  .img{
  	width: 100px;
  	height: 100px;	
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
             
        <!-- 게시물 라인-->
        <DIV id="body_div">
          <div>
            <div id="title_div">
                <h3>시설 </h3>
                <hr>
            </div>
            <div id="fac_inform">
              <div id="fac_inform_blank">
              </div>
              <div id="fac_inform_div1">
                  <span>시설 정보</span>
              </div>
              <div id="fac_inform_input">
                <div id="fac_inform_input1">
                  <form>
                    <div class="form-group" id="fac_input">
                      <label for="exampleInputEmail1">시설 넘버</label>
                      <input type="text" class="form-control" name="finfo_no" value="${fac_admin_Vo.finfo_no}" readonly>
                      
                      <label for="exampleInputEmail1">시설 관리자 아이디</label>
                      <input type="text" class="form-control" value="${fac_admin_Vo.fm_id}" readonly>
                      
                      <label for="exampleInputPassword1">시설 이름</label>
                      <input type="text" class="form-control" value="${fac_admin_Vo.finfo_name}">

                      <label for="exampleInputPassword1">시설 종목</label>
                      <input type="text" class="form-control" value="${fac_admin_Vo.finfo_sport}">


                      <label for="exampleInputPassword1">시설 주소</label>
                      <input type="text" class="form-control" value="${fac_admin_Vo.finfo_add1}">
                      
                      <label for="exampleInputPassword1">시설 가격</label>
                      <input type="text" class="form-control" value="${fac_admin_Vo.finfo_price}">
					 
                      <label for="exampleInputPassword1">최대 인원</label>
                      <input type="text" class="form-control" value="${fac_admin_Vo.finfo_people}">
                     
                      <label for="exampleFormControlTextarea1">상세 정보</label>
                      <textarea class="form-control" id="exampleFormControlTextarea1"  rows="3">${fac_admin_Vo.finfo_detail}</textarea>
                      
                      <div class="custom-file">
                        <img class="img" src="/finfo/${fac_admin_Vo.finfo_pic1}">
                      </div>
                      <div class="custom-file">
                        <img class="img" src="/finfo/${fac_admin_Vo.finfo_pic2}">
                      </div>
                      <div class="custom-file">
                        <img class="img" src="/finfo/${fac_admin_Vo.finfo_pic3}">
                      </div>
                      <div class="custom-file">
                        <img class="img" src="/finfo/${fac_admin_Vo.finfo_pic4}">
                      </div>
                      <div class="custom-file">
                        <img class="img" src="/finfo/${fac_admin_Vo.finfo_pic5}">
                      </div>
                    </div>
                    
             
                    <br>
                    <a href="fac_modify?finfo_no=${fac_admin_Vo.finfo_no}" class="btn btn-primary" id="fac_save">수정</a>
                    <a href="fac_list" class="btn btn-primary" id="fac_save">리스트</a>
                    <a href="#"  onclick="fac_delete()" class="btn btn-primary" id="fac_save">삭제</a>
                    
                  </form>
                </div>

              </div>
            </div>
          </div>
        </DIV>

  
      </div>

      <!-- 
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by <b><a href="https://indrijunanda.gitlab.io/"
                  target="_blank">indrijunanda</a></b> </span>
          </div>
        </div>
      </footer> -->

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