<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="main">
        <div class="sidebar-brand-icon">
        </div>
        <div class="sidebar-brand-text mx-3">로고</div>
      </a>
      <hr class="sidebar-divider my-0">
      <li class="nav-item">
        <a class="nav-link" href="fm_main">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span></span></a>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        시설 관리자
      </div>
      <li class="nav-item active">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBootstrap"
          aria-expanded="true" aria-controls="collapseBootstrap">
          <i class="far fa-fw fa-window-maximize"></i>
          <span>시설 관리</span>
        </a>
        <div id="collapseBootstrap" class="collapse show" aria-labelledby="headingBootstrap"
          data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">시설 관리</h6>
            <a class="collapse-item" href="fac_register">시설 등록</a>
            <a class="collapse-item" href="fac_list">시설 목록</a>
            <a class="collapse-item" href="fac_comment">후기 관리</a>
            <a class="collapse-item" href="fac_eventBoard">시설 이벤트 관리</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseForm" aria-expanded="true"
          aria-controls="collapseForm">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>예약</span>
        </a>
        <div id="collapseForm" class="collapse" aria-labelledby="headingForm" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">예약</h6>
            <a class="collapse-item" href="fac_reserve">예약 목록</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="fac_qna">
          <i class="fas fa-fw fa-palette"></i>
          <span>문의 내역</span>
        </a>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        정보
      </div>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePage" aria-expanded="true"
          aria-controls="collapsePage">
          <i class="fas fa-fw fa-columns"></i>
          <span>판매자 정보</span>
        </a>
        <div id="collapsePage" class="collapse" aria-labelledby="headingPage" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">판매자 정보</h6>
            <a class="collapse-item" href="fm_mypage">마이페이지</a>
          </div>
        </div>
      </li>
       
		<li class="nav-item">
        <a class="nav-link" href="freeBoardSellerList?fm_id=${session_id}">
          <i class="fas fa-fw fa-palette"></i>
          <span>게시판 이동</span>
        </a>
      </li>
      <hr class="sidebar-divider">
      <div class="version" id="version-ruangadmin"></div>
    </ul>