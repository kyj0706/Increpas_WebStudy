<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 시용하려면 -->    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>	
	
	    
<%
	//JSTL(JSP Standard Tag Library)
	//					태그라이브러리:<c:if>형식의 명령
	//JSTL 종류
	// core : if , foEach , choose
	// fmt  : 숫자 , 날짜
	// fn   : substring,  indexOf....
	// 등등 더 많지만 JSP는 view 용도로만 쓰일거니깐 여기까지만 알아도 충분하다.
	// 추가로 JSTL을 이용하기 위해선 준비과정이 필요하다.
	// JSTL내의 데이터는 EL표현범을 사용한다.
	
	
	//숫자형
	int money = 1200000000;
	
	//날짜형
	Date today = new Date();
	
	
	//문자열형식       0123456789001234567890
	String str_date = "2022-12-21 15:44:50.0";
	
	
	//fmt 해보기
	//pageContext에 데이터를 넣는다
	pageContext.setAttribute("money", money); //new Integer(money) money는 객체만 들어가는데 어떻게 들어갓냐 ? 자동으로 업 ... 
	pageContext.setAttribute("today", today);
	
	pageContext.setAttribute("str_date", str_date);
	
	
	
	
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

내가 소유하고 있는 현금 : ${ money }<br>

<fmt:setLocale value="ko_kr"/>
내가 소유하고 있는 현금 : <fmt:formatNumber type="currency" value="${ money }"/> <br>
<fmt:setLocale value="ja_jp"/>
내가 소유하고 있는 현금 : <fmt:formatNumber type="currency" value="${ money }"/> <br>
<fmt:setLocale value="en_us"/>
내가 소유하고 있는 현금 : <fmt:formatNumber type="currency" value="${ money }"/> <br>


현재의 날짜 : <fmt:formatDate pattern="yyyy년 MM월 dd일 (HH시mm분ss초)" value="${today}"/><br>

문자열 날짜 : ${ fn:substring(str_date,0,16) } <br>




</body>
</html>