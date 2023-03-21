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
                <h3>시설 수정</h3>
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
                  <form action="fac_modify" method="post" enctype="multipart/form-data">
                  	<input type="hidden" name="finfo_no" value="${fac_admin_Vo.finfo_no}">
     			    <input type="hidden" name="finfo_pic1" value="${fac_admin_Vo.finfo_pic1}">
     			    <input type="hidden" name="finfo_pic2" value="${fac_admin_Vo.finfo_pic2}">
     			    <input type="hidden" name="finfo_pic3" value="${fac_admin_Vo.finfo_pic3}">
     			    <input type="hidden" name="finfo_pic4" value="${fac_admin_Vo.finfo_pic4}">
     			    <input type="hidden" name="finfo_pic5" value="${fac_admin_Vo.finfo_pic5}">
                    <div class="form-group" id="fac_input">
                      <label for="exampleInputEmail1">시설 넘버</label>
                      <input type="text" class="form-control" name="finfo_no" value="${fac_admin_Vo.finfo_no}" readonly>
                      
                      <label for="exampleInputEmail1">시설 관리자 아이디</label>
                      <input type="text" class="form-control" name="fm_id" value="${fac_admin_Vo.fm_id}" readonly>

                      <label for="exampleInputPassword1">시설 이름</label>
                      <input type="text" class="form-control" name="finfo_name" value="${fac_admin_Vo.finfo_name}">

                      <label for="select2Single">시설 종목</label>
                      <select class="select2-single form-control" name="finfo_sport" id="select2Single" value="${fac_admin_Vo.finfo_sport}">
                        <option value="">선택하세요</option>
                        <option value="soccer"${fac_admin_Vo.finfo_sport.contains("축구")?"selected":""}>축구</option>
                        <option value="baseball"${fac_admin_Vo.finfo_sport.contains("야구")?"selected":""}>야구</option>
                        <option value="tennis"${fac_admin_Vo.finfo_sport.contains("테니스")?"selected":""}>테니스</option>
                        <option value="badminton"${fac_admin_Vo.finfo_sport.contains("배드민턴")?"selected":""}>배드민턴</option>
                      </select>
                      
                      <label for="exampleInputPassword1">시설 주소</label>
                      <input type="text" class="form-control"  name="finfo_add1" value="${fac_admin_Vo.finfo_add1}">
                      
                      <label for="exampleInputPassword1">시설 가격</label>
                      <input type="text" class="form-control" name="finfo_price" value="${fac_admin_Vo.finfo_price}">
                      
                      
                      <label for="exampleFormControlSelect2">최대 인원</label>
                      <select multiple class="form-control" name="finfo_people" id="exampleFormControlSelect2">
                        <option value="">선택하세요</option>
                        <option value="1" ${fac_admin_Vo.finfo_people == 1 ?"selected":""}>1</option>
                        <option value="2" ${fac_admin_Vo.finfo_people == 2 ?"selected":""}>2</option>
                        <option value="3" ${fac_admin_Vo.finfo_people == 3 ?"selected":""}>3</option>
                        <option value="4" ${fac_admin_Vo.finfo_people == 4 ?"selected":""}>4</option>
                        <option value="5" ${fac_admin_Vo.finfo_people == 5 ?"selected":""}>5</option>
                        <option value="6" ${fac_admin_Vo.finfo_people == 6 ?"selected":""}>6</option>
                        <option value="7" ${fac_admin_Vo.finfo_people == 7 ?"selected":""}>7</option>
                        <option value="8" ${fac_admin_Vo.finfo_people == 8 ?"selected":""}>8</option>
                        <option value="9" ${fac_admin_Vo.finfo_people == 9 ?"selected":""}>9</option>
                        <option value="10" ${fac_admin_Vo.finfo_people == 10 ?"selected":""}>10</option>
                        <option value="11" ${fac_admin_Vo.finfo_people == 11 ?"selected":""}>11</option>
                        <option value="12" ${fac_admin_Vo.finfo_people == 12 ?"selected":""}>12</option>
                        <option value="13" ${fac_admin_Vo.finfo_people == 13 ?"selected":""}>13</option>
                        <option value="14" ${fac_admin_Vo.finfo_people == 14 ?"selected":""}>14</option>
                        <option value="15" ${fac_admin_Vo.finfo_people == 15 ?"selected":""}>15</option>
                        <option value="16" ${fac_admin_Vo.finfo_people == 16 ?"selected":""}>16</option>
                        <option value="17" ${fac_admin_Vo.finfo_people == 17 ?"selected":""}>17</option>
                        <option value="18" ${fac_admin_Vo.finfo_people == 18 ?"selected":""}>18</option>
                        <option value="19" ${fac_admin_Vo.finfo_people == 19 ?"selected":""}>19</option>
                        <option value="20" ${fac_admin_Vo.finfo_people == 20 ?"selected":""}>20</option>
                        <option value="21" ${fac_admin_Vo.finfo_people == 21 ?"selected":""}>21</option>
                        <option value="22" ${fac_admin_Vo.finfo_people == 22 ?"selected":""}>22</option>
                        <option value="23" ${fac_admin_Vo.finfo_people == 23 ?"selected":""}>23</option>
                        <option value="24" ${fac_admin_Vo.finfo_people == 24 ?"selected":""}>24</option>
                        <option value="25" ${fac_admin_Vo.finfo_people == 25 ?"selected":""}>25</option>
                        <option value="26" ${fac_admin_Vo.finfo_people == 26 ?"selected":""}>26</option>
                        <option value="27" ${fac_admin_Vo.finfo_people == 27 ?"selected":""}>27</option>
                        <option value="28" ${fac_admin_Vo.finfo_people == 28 ?"selected":""}>28</option>
                        <option value="29" ${fac_admin_Vo.finfo_people == 29 ?"selected":""}>29</option>
                        <option value="30" ${fac_admin_Vo.finfo_people == 30 ?"selected":""}>30</option>
                      </select>
                     
                      
                      <label for="exampleFormControlTextarea1">상세 정보</label>
                      <textarea class="form-control" id="exampleFormControlTextarea1"  name="finfo_detail" rows="3">${fac_admin_Vo.finfo_detail}</textarea>
                      
                    </div>
                    
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="customFile1" name="files">
                        <label class="custom-file-label" for="customFile1">파일업로드</label>
                      </div>
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="customFile2" name="files">
                        <label class="custom-file-label" for="customFile2">파일업로드</label>
                      </div>
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="customFile3" name="files">
                        <label class="custom-file-label" for="customFile3">파일업로드</label>
                      </div>
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="customFile4" name="files">
                        <label class="custom-file-label" for="customFile4">파일업로드</label>
                      </div>
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="customFile5" name="files">
                        <label class="custom-file-label" for="customFile5">파일업로드</label>
                      </div>
                        
                    
                    <button type="submit" class="btn btn-primary" id="fac_save">재등록</button>
                    <a href="fac_register" class="btn btn-primary" id="fac_save">리스트</a>
                    <a href="fac_view?finfo_no=${fac_admin_Vo.finfo_no}" class="btn btn-primary" id="fac_save">돌아가기</a>
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