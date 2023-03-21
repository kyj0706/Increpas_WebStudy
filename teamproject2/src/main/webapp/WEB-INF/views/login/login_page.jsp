<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="./css/find.css">
        
        <style type="text/css">
        
        #find_id:hover{
        border: none;
        background-color: gray;
        color: white;
        }
        
        #find_pw:hover{
        border: none;
        background-color: gray;
        color: white;
        }
        
        #admin_page{
        display:inline-block;
        	width: 50px;
        	height: 50px;
        	background-color: rgba(255, 255, 255, 0.15);
        	float: right;
        }
        
      	a{
      		text-decoration: none;
      		color: black;
      		font-weight: bolder;
      	}
      	a:hover {
			text-decoration: underline;
		}
        #logo{
			margin: 30px;
		}
		
        </style>
        
    </head>
    <body>
    	<c:if test="${result == '1' }" >
    	<script type="text/javascript">
    		alert("회원 회원가입에 성공하셨습니다");
    	</script>
    	</c:if>
    	<c:if test="${result1 == '1' }" >
    	<script type="text/javascript">
    		alert("시설관리자 회원가입에 성공하셨습니다");
    	</script>
    	</c:if>
    	<c:if test="${result == '0' }" >
    	<script type="text/javascript">
    		alert("회원가입에 실패하셨습니다");
    	</script>
    	</c:if>

        <div class="wrap">
	        <div id="logo">
				<a href="login"><img src="img/logo.png" alt="" title="" /></a>
		        <a href="admin_login"><span id="admin_page"></span></a>
			</div>
            <div class="form-wrap">
                <h1 id="title_h1">로그인</h1>
                <div class="button-wrap">
                    <div id="btn"></div>
                    <ul>
                        <li class="togglebtn" id="btn1" onclick="find_mem()">회원
                        </li>
                        <li class="togglebtn" id="btn2" onclick="find_fac()">시설관리자</li>

                    </ul>
                   
                </div>
                <div id="register_input">
                    <form id="find_mem" action="login_member" class="input-group" method="post" style="left: 50px;">
                       <div>
                        <input type="text" id="id" name="id" placeholder="ID">
                        <hr>
                        <input type="password" id="pw" name="pw" placeholder="PASSWORD">
                        <hr>
                        <input type="submit" class="submit_btn" value="로그인">
                        <br>
                        <span><a href="/Sign_up_form">"회원가입 가기"</a></span>
                    	<br>
                    	<span><a href="/Find" >아이디 찾기</a>/<a href="/Find_PW" id="find_pw">비밀번호 찾기</a></span>
                    </div>
                    </form>
                    <form id="find_fac" action="login_fac" class="input-group" method="post" style="left: 450px;">
                        <div>
                            <input type="text" id="id" name="id" placeholder="ID">
                            <hr>
                            <input type="password" id="pw" name="pw" placeholder="PASSWORD">
                            <hr>
                            <input type="submit" class="submit_btn" value="로그인">
                            <br>
                       		<span><a href="/Sign_up_form">"회원가입 가기"</a></span>
                    	<br>
                    	<span><a href="/Find" id="find_id">아이디 찾기</a>/<a href="/Find_PW" id="find_pw">비밀번호 찾기</a></span>
                           </div>
                    </form>
                </div>
            </div>
        </div>
        
        
        
        <script>
            var x = document.getElementById("find_mem");
            var y = document.getElementById("find_fac");
            var z = document.getElementById("btn");
            
            
            function find_mem(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }
            function find_fac(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "115px";
            }
        </script>
    </body>
</html>