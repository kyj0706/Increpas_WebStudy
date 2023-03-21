<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${session_member == 'member' }">
<style>
#ul_nav li{
    display: inline-block;
    font-size: 30px;
    font-weight: bolder;
    height: 100%;
    width: 24%;
    text-align: center;
    float: left;
}	
</style>
</c:if>
<c:if test="${session_member == 'admin' }">
<style>
#ul_nav li{
    display: inline-block;
    font-size: 30px;
    font-weight: bolder;
    height: 100%;
    width: 20%;
    text-align: center;
    float: left;
}	

</style>
</c:if>
	<ul id="ul_nav">
		<c:if test="${session_member == 'seller' || session_member == 'admin'  }">
			<li id = "freeS"><a href="freeBoardSellerList">
			<c:if test="${session_member == 'admin' }">
			판매자 자유 게시판
			</c:if>
			<c:if test="${session_member == 'seller' }">
			자유 게시판
			</c:if>
			</a></li>
		</c:if>
		<c:if test="${session_member == 'member' || session_member == 'admin'  }">
			<li id = "freeM"><a href="freeBoardMemberList">
			<c:if test="${session_member == 'admin' }">
			회원 자유 게시판
			</c:if>
			<c:if test="${session_member == 'member' }">
			자유 게시판
			</c:if>
			</a></li>
		</c:if>
		<li id = "event"><a href="eventBoardList" >이벤트</a></li>
		<li id = "notice"><a href="noticeBoardList">공지사항</a></li>
		<li id = "qna"><a href="qnaBoardList" >문의사항</a></li>
	</ul>
	
	
	