<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="./css/find.css">
        <style type="text/css">
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
                <h1 id="title_h1">비밀번호 찾기</h1>
                <div class="button-wrap">
                    <div id="btn"></div>
                    <ul>
                        <li class="togglebtn" id="btn1" onclick="find_mem()">회원
                        </li>
                        <li class="togglebtn" id="btn2" onclick="find_fac()">시설 관리자</li>

                    </ul>
                   
                </div>
                <div id="register_input">
                    <form id="find_mem" action="find_member_pw" class="input-group" method="post" style="left: 50px;">
                       <div>
                        <input type="text" id="m_id" name="m_id" placeholder="아이디">
                        <hr>
                        <input type="text" id="m_email" name="m_email" placeholder="이메일">
                        <hr>
                        <input type="submit" class="submit_btn" value="검색">
                        <br>
                        <span><a href="/login" id="find_id">로그인 페이지로 이동</a></span>
                        <br>
                        <span><a href="Find" id="find_pw">아이디 찾기</a></span>
                    </div>
                    </form>
                    <form id="find_fac" action="find_fmanager_pw" class="input-group" method="post" style="left: 450px;">
                        <div>
                            <input type="text" id="id" name="id" placeholder="아이디">
                            <hr>
                            <input type="text" id="phone" name="phone" placeholder="번호">
                            <hr>
                            <input type="submit" class="submit_btn" value="검색">
                            <br>
                        	<span><a href="/login" id="find_id">로그인 페이지로 이동</a></span>
                        	<br>
                     	   <span><a href="Find" id="find_pw">아이디 찾기</a></span>
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