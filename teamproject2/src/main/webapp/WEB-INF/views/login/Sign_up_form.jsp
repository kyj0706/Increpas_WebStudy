<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="./css/Sign_up.css">
        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="/js/member/sign_up.js"></script>
        <style type="text/css">
        
	       	input {
				color: black;			
			}
			#logo{
				margin: 30px;
			}
        </style>
    </head>
    <body>
        <div class="wrap">
        	<div id="logo">
				<a href="login"><img src="img/logo.png" alt="" title="" /></a>
			</div>
            <div class="form-wrap">
                <h1 id="title_h1">회원가입</h1>
                <div class="button-wrap">
                    <div id="btn"></div>
                    <ul>
                        <li class="togglebtn" id="btn1" onclick="customer()">고객
                        </li>
                        <li class="togglebtn" id="btn2" onclick="corporation()">기업</li>

                    </ul>
                   
                </div>
                <div id="register_input">
                    <form id="customer" action="register_member" class="input-group" method="post" onsubmit="return jbSubmit();" >
                        <div>
                            <input type="text" id="id" name="m_id" placeholder="ID">
                            <button type="button" id="id_chk_btn">중복검사</button>
                            <input type="hidden" id="id_check_value" value="0" readonly="readonly">
                            <hr>
                            <span id="id_check"></span>
                            <input type="password" id="pw" name="m_pw" placeholder="PASSWORD">
                            <hr>
                            <span id="pw_check"></span>
                            <input type="password" id="pw1" name="pw1" placeholder="PASSWORD 재입력">
                            <hr>
                            <span id="pw_check1"></span>
                            <input type="text" id="name" name="m_name" placeholder="이름">
                            <hr>
                            <input type="text" id="nick" name="m_nickname" placeholder="닉네임">
                            <hr>
                            <input type="text" id="email" name="m_email" placeholder="이메일">
                            <button type="button" id="email_chk_btn">인증번호</button>
                            <hr>
                            <div id="email_check"></div><!-- 이메일 인증 입력창 -->
                            <div id="email_check_btn">
                            <input type="hidden" id="email_check_value" value="0">
                            </div><!-- 이메일 인증 확인 -->
                            <span id="email_check"></span>
                            <input type="submit" id="submit_btn" value="SIGN IN">
                            <br>
                        </div>
                    </form>
                    <form id="corporation" action="register_fac" class="input-group" method="post"  onsubmit="return jbSubmit1();">
                        <div>
                            <input type="text" id="fm_id" name="fm_id" placeholder="ID">
                            <button type="button" id="fm_id_chk_btn">중복검사</button>
                            <input type="hidden" id="fm_id_check_value" value="0" readonly="readonly">
                            <hr>
                            <span id="fm_id_check"></span>
                            <input type="password" id="fm_pw" name="fm_pw" placeholder="PASSWORD">
                            <hr>
                            <span id="fm_pw_check"></span>
                            <input type="password" id="fm_pw1" name="pw1" placeholder="PASSWORD 재입력">
                            <hr>
                             <span id="fm_pw_check1"></span>
                            <input type="text" id="ins_name" name="fm_name" placeholder="사업자명">
                            <hr>
                            <input type="text" id="ins_phone" name="fm_phone" placeholder="사업자 전화번호">
                            <hr>
                            <input type="text" id="ins_email" name="fm_email" placeholder="사업자 메일">
                            <button type="button" id="fm_email_chk_btn">인증번호</button>
                            <hr>
                            <div id="fm_email_check"></div><!-- 이메일 인증 입력창 -->
                            <div id="fm_email_check_btn">
                            <input type="hidden" id="fm_email_check_value" value="0" readonly="readonly">
                            </div><!-- 이메일 인증 확인 -->
                            <span id="fm_email_check"></span>
                            <input type="submit" id="submit_btn" value="SIGN IN">
                            <br>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
        var x = document.getElementById("customer");
        var y = document.getElementById("corporation");
        var z = document.getElementById("btn");
        
        
        function customer(){
            x.style.left = "50px";
            y.style.left = "450px";
            z.style.left = "0";
        }

        function corporation(){
            x.style.left = "-400px";
            y.style.left = "50px";
            z.style.left = "115px";
        }
        </script>
    </body>
</html>