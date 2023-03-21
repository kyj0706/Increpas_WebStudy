<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
  <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Eflyer</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- fonts -->
      <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--  -->
      <!-- owl stylesheets -->
      <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesoeet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
   	  <script type="text/javascript" src="timer.js"></script>
   	  </head>
   	 
   	  
   	  
<body>
   <!-- 배너 -->
   <div class="banner_bg_main2">
      <!-- logo section start -->
      <div class="logo_section">
         <div class="container">
            <div class="row">
               <div class="col-sm-12">
                  <div class="logo"><a href="index.html"><img src="images/logo.png"></a></div>
               </div>
            </div>
         </div>
      </div>
      
      <div class="container1">
        <div class="header_section_top">
           <div class="row">
              <div class="col-sm-12">
                 <div class="custom_menu">
                    <ul>
                       <li><a href="#">인덱스1</a></li>
                       <li><a href="#">인덱스2</a></li>
                       <li><a href="#">인덱스3</a></li>
                       <li><a href="#">인덱스4</a></li>
                       <li><a href="#">인덱스5</a></li>
                    </ul>
                 </div>
              </div>
           </div>
        </div>
     </div>
      
      <!-- logo section end -->
      <!-- header section start -->
      <div class="header_section">
         <div class="container">
            <div class="containt_main">
               <div id="mySidenav" class="sidenav">
                  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                  <a href="index.jsp">Home</a>
                  <a href="fashion.jsp">Fashion</a>
                  <a href="electronic.jsp">Electronic</a>
                  <a href="jewellery.jsp">Jewellery</a>
               </div>
               <span class="toggle_icon" onclick="openNav()"><img src="images/toggle-icon.png"></span>
               <div class="dropdown">
                  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">All Category 
                  </button>
                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                     <a class="dropdown-item" href="#">Action</a>
                     <a class="dropdown-item" href="#">Another action</a>
                     <a class="dropdown-item" href="#">Something else here</a>
                  </div>
               </div>
               <div class="main">
                  <!-- Another variation with a button -->
                  <div class="input-group">
                     <input type="text" class="form-control" placeholder="Search this blog">
                     <div class="input-group-append">
                        <button class="btn btn-secondary" type="button" style="background-color: #f26522; border-color:#f26522 ">
                        <i class="fa fa-search"></i>
                        </button>
                     </div>
                  </div>
               </div>
               <div class="header_box">
                  <!-- 랭귀지 메뉴 -->
                  <!-- <div class="lang_box ">
                     <a href="#" title="Language" class="nav-link" data-toggle="dropdown" aria-expanded="true">
                     <img src="images/flag-uk.png" alt="flag" class="mr-2 " title="United Kingdom"> English <i class="fa fa-angle-down ml-2" aria-hidden="true"></i>
                     </a>
                     <div class="dropdown-menu ">
                        <a href="#" class="dropdown-item">
                        <img src="images/flag-france.png" class="mr-2" alt="flag">
                        French
                        </a>
                     </div>
                  </div> -->
                  <div class="login_menu">
                     <ul>
                        <li><a href="#">
                           <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                           <span class="padding_10">Cart</span></a>
                        </li>
                        <li><a href="#">
                              <i class="fa fa-user" aria-hidden="true"></i>
                              <span class="padding_10">Login</span></a>
                           </li>
                        <li><a href="#">
                           <i class="fa fa-tags" aria-hidden="true"></i>
                           <span class="padding_10">경매 등록</span></a>
                        </li>
                        
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </div>
      
      <div class="banner_section layout_padding">
      <!-- 이곳이 배너의 시작입니다. -->
      
      
      
      
      
      
      
      </div> 
   </div>
   
   <!-- 풋터 시작 -->
   <div class="copyright_section">
      <div class="container">
         <p class="copyright_text">© 2020 All Rights Reserved. Design by <a href="https://html.design">Free html  Templates</a></p>
      </div>
   </div>
   <!-- 풋터 끝 -->
   
   
   <!-- Javascript files-->
   <script src="js/jquery.min.js"></script>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.bundle.min.js"></script>
   <script src="js/jquery-3.0.0.min.js"></script>
   <script src="js/plugin.js"></script>
   
   
   <!-- sidebar -->
   <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
   <script src="js/custom.js"></script>
   <script>
      function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
      }
      
      function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
      }
   </script>
</body>
</html>