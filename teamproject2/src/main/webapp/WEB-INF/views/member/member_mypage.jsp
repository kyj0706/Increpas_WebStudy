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
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
       <c:if test="${session_member != 'member' }">
 		 <script type="text/javascript">
  	 	 alert("잘못된 경로입니다")
  		 location.href="login"
  		 </script>
  	</c:if>
  	
  	<style type="text/css">
  	
  	
  	</style>
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
        <DIV id="body_div">
          <div>
            <div id="title_div">
                <h3>마이페이지</h3>
                <hr>
            </div>
            <div id="mem_inform">
              <div id="mem_inform_blank">
              </div>
              <div id="mem_inform_div1">
                  <span>마이페이지</span>
              </div>
              <div id="mem_inform_input">
                <div id="mem_inform_input1">
                  <form method="get">
                    <div class="form-group" id="mem_input">
                      <label for="exampleInputEmail1">회원 아이디</label>
                      <input type="text" class="form-control" placeholder="회원 아이디" value="${memberVo.m_id}" readonly="readonly">
                      
                      <label for="exampleInputPassword1">회원 이름</label>
                      <input type="text" class="form-control" placeholder="회원 이름" value="${memberVo.m_name}" readonly="readonly">
                      
                      <label for="exampleInputPassword1">회원 닉네임</label>
                      <input type="text" class="form-control" placeholder="회원 닉네임" value="${memberVo.m_nickname}" readonly="readonly">
                      
                      <label for="exampleInputPassword1">생년월일</label>
                      <input type="text" class="form-control" placeholder="생년 월일" value="${memberVo.m_birth}" readonly="readonly">
                      
                      <label for="exampleInputPassword1">성별</label>
                      <input type="text" class="form-control" placeholder="성별" value="${memberVo.m_gender}" readonly="readonly">
                      
                      <label for="exampleInputPassword1">이메일[인증 여부]</label>
                      <input type="text" class="form-control" placeholder="이메일"  value="${memberVo.m_email} = 인증여부 [ ${memberVo.email_check} ]" readonly="readonly">
                      
                      <label for="exampleInputPassword1">주소</label>
                        <c:if test="${memberVo.m_post == null}">
	                      <input type="text" class="form-control" placeholder="주소" readonly="readonly">
                        </c:if>
                        <c:if test="${memberVo.m_post != null}">
                        <c:set value="${memberVo.m_post}-${memberVo.m_add1}-${memberVo.m_add2}" var="address" />
	                      <input type="text" class="form-control" placeholder="주소"  value="${address}" readonly="readonly">
                        </c:if>
                      
                      <label for="exampleInputPassword1">번호</label>
                      <input type="text" class="form-control" placeholder="번호"  value="${memberVo.m_phone}" readonly="readonly">
                      
                      
                      
                    </div>

                    <a href="member_Modify" class="btn btn-primary" id="mem_save">수정하기</a>
                    <a href="member_Main" class="btn btn-primary" id="mem_save">메인페이지 이동</a>
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