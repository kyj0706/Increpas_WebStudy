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
  	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  	<script type="text/javascript" src="js/member/member_modify.js"></script>

  <style type="text/css">
  #exampleFormControlSelect1{
  width: 10%;
  display: inline-block;
  }
  .custom-control{
  	display: inline-block;
  }
  
  #male1{
  	margin: 0px;
  	padding: 0px;
  }
  #email{
  	border: none;
  }
  #email_check{
  	border: none;
	outline: none;
  }
  </style>
  <c:if test="${result == '1' }">
  	<script type="text/javascript">
  	alert("수정이 완료되었습니다");
	location.href="member_mypage"  	
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
        <DIV id="body_div">
          <div>
            <div id="title_div">
                <h3>마이페이지 정보 수정</h3>
                <hr>
            </div>
            <div id="mem_inform">
              <div id="mem_inform_blank">
              </div>
              <div id="mem_inform_div1">
                  <span>마이페이지 정보 수정</span>
              </div>
              <div id="mem_inform_input">
                <div id="mem_inform_input1">
                  <form action="member_Modify" name="mem_check" method="post">
                    <div class="form-group" id="mem_input">
                      <label for="exampleInputEmail1">회원 아이디</label>
                      <input type="text" class="form-control" placeholder="회원 아이디" name="m_id" value="${memberVo.m_id}" readonly="readonly" >
                      
                      <label for="exampleInputPassword1">회원 이름</label>
                      <input type="text" class="form-control" placeholder="회원 이름" name="m_name"  value="${memberVo.m_name}" >
                      
                      <label for="exampleInputPassword1">회원 닉네임</label>
                      <input type="text" class="form-control" placeholder="회원 닉네임" name="m_nickname" value="${memberVo.m_nickname}">
                      <div>
                      <label for="exampleInputPassword1">생년월일</label>
                      </div>
                      <select class="form-control year" id="exampleFormControlSelect1" name="birth1">
                      </select>

                      <select class="form-control month" id="exampleFormControlSelect1" name="birth2">
                      </select>

                      <select class="form-control day" id="exampleFormControlSelect1" name="birth3">
                      </select>
                      <div>
                      <label for="exampleInputPassword1">성별</label>
                      </div>
						<div>
	                        <span class="custom-control custom-radio">
	                          <input type="radio" id="male" name="gender" class="custom-control-input" value="male">
	                          <label class="custom-control-label" for="male" id="male1" >남자</label>
	                        </span>
	                        <span class="custom-control custom-radio">
	                          <input type="radio" id="female" name="gender" class="custom-control-input" value="female">
	                          <label class="custom-control-label" for="female" >여자</label>
	                        </span>
						</div>
                      
                         
                      <label for="exampleInputPassword1">이메일 [인증받기]</label>
                      <div class="form-control" id="email_div" >
                      <input type="email" placeholder="이메일" id="email" name="email" value="${memberVo.m_email}">
                      <input type="text" value="${memberVo.email_check}" id="email_check" readonly="readonly">
                      <input type="hidden" value="${memberVo.m_id}" id="m_id" readonly="readonly">
                      <c:if test="${memberVo.email_check == 'no' }">
                      <input type="button" id="email_btn" value="인증받기">
                      <input type="text" id="email_num">
                      <input type="button" id="email_btn2" value="인증하기">
                      </c:if> 
                      </div>
                      
                      <label for="exampleInputPassword1">주소</label>
                      <div class="form-control" style="height: auto;">
                      	<div style="margin-bottom: 5px;" >
                      		<input type="text" id="sample6_postcode" name="post" placeholder="우편번호" value="${memberVo.m_post}">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                      	</div>
				      <input type="text" id="sample6_address" name="add1" placeholder="주소" style="width: 50%;" value="${memberVo.m_add1}">
				      -
				      <input type="text" id="sample6_detailAddress" name="add2" placeholder="상세주소" style="width: 20%;" value="${memberVo.m_add2}">
                      </div>
                      
                      <label for="exampleInputPassword1">번호</label>
                      <!-- 정규화 -->
                      <input type="text" class="form-control" placeholder="번호만적어주세요" value="${memberVo.m_phone}" name="phone">
                      
                      
                      
                    </div>

                    <a href="member_mypage" class="btn btn-primary" id="mem_save">돌아가기</a>
                    <button type="button" class="btn btn-primary mem_check" id="mem_save">등록하기</button>
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