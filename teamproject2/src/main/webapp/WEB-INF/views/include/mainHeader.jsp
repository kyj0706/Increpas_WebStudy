<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<header id="header">
				<div class="container main-menu">
					<div class="row align-items-center justify-content-between d-flex">
						<div id="logo">
							<h3><a href="main"><img src="img/logo.png" alt="" title="" /></a></h3>
						</div>
						<nav id="nav-menu-container">
							<ul class="nav-menu">
								<li><a href="logout">로그아웃</a></li>
								<c:if test="${session_member == 'member' }">
									<li><a href="freeBoardMemberList">게시판</a></li>
									<li><a href="member_Main">마이페이지</a></li>
								</c:if>
								<c:if test="${session_member == 'seller' }">
									<li><a href="freeBoardSellerList">게시판</a></li>
									<li><a href="fm_main">시설관리 페이지</a></li>
								</c:if>
								<li><a href="bookinglist">전체 시설보기</a></li>
							</ul>
						</nav>					      		  
					</div>
				</div>
			</header>