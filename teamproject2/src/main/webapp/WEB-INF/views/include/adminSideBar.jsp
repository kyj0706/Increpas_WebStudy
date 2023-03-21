<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
       <a class="sidebar-brand d-flex align-items-center justify-content-center" href="admin_main">
        <div class="sidebar-brand-icon">
        </div>
        <div class="sidebar-brand-text mx-3">로고</div>
      </a>
      <hr class="sidebar-divider my-0">
      <li class="nav-item">
        <a class="nav-link" href="admin_main">
          <i class="fas fa-fw fa-tachometer-alt"></i>
        </a>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        <span style="font-size: 25px; color: black;">관리자</span>
      </div>
      <li class="nav-item active">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBootstrap"
          aria-expanded="true" aria-controls="collapseBootstrap">
          <i class="far fa-fw fa-window-maximize"></i>
          <span>회원 관리</span>
        </a>
        <div id="collapseBootstrap" class="collapse show" aria-labelledby="headingBootstrap"
          data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">회원 관리</h6>
            <a class="collapse-item" href="admin_member_list">회원 목록</a>
            <a class="collapse-item" href="admin_fac_list">시설 관리자 목록</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseForm" aria-expanded="true"
          aria-controls="collapseForm">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>게시판 관리</span>
        </a>
        <div id="collapseForm" class="collapse" aria-labelledby="headingForm" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">게시판 관리</h6>
            <a class="collapse-item" href="freeboardmember_list">회원 자유게시판 목록</a>
            <a class="collapse-item" href="freeboardseller_list">시설관리자 자유게시판 목록</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTable" aria-expanded="true"
          aria-controls="collapseTable">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>공지사항 관리</span>
        </a>
       
        <div id="collapseTable" class="collapse" aria-labelledby="headingTable" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">공지사항 관리</h6>
            <a class="collapse-item" href="noticeboard_list">공지 사항 게시판</a>
            <a class="collapse-item" href="askboard_list">문의 사항 게시판</a>
            <a class="collapse-item" href="eventBoard">시설 이벤트 게시판</a>
            <a class="collapse-item" href="qnaboard_list">QNA 게시판</a>
          </div>
        </div>
      </li>
      
        <li class="nav-item">
        <a class="nav-link" href="freeBoardSellerList?m_id=${session_id}">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>게시판 이동</span>
        </a>
      </li>
     
      <hr class="sidebar-divider">

      <div class="version" id="version-ruangadmin"></div>
    </ul>