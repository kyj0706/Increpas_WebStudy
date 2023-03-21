<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/footer/footer.css">
<link rel="stylesheet" href="resources/css/header/header.css">
<link rel="stylesheet" href="resources/css/evstocklist.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table td{
	   text-align: center;
		padding: 4px 10px;
		border-bottom: 1px solid silver;
		height: 90px;
   }
</style> 
</head>
<body>
	${sb }
	<!-- header영역 -->
	<%-- <jsp:include page="header.jsp" /> --%>
	<div>
		<div id="stock_title">
			<div id="title">
				<p>전기차 주식 목록</p>
			</div>
		</div>
		<article style="margin: 0 0 300px 0;">
	<!-- 종목명 | 현재가 | 전일대비 | 등락율 | 고가 | 저가 | 거래량 | 거래대금  -->	
		<table>
		
			<colgroup>
				<col width="*"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="150px"/>
			</colgroup>
			<thead>
				<tr>
					<th>종목명</th>
					<th>현재가</th>
					<th>전일대비</th>
					<th>등락율</th>
					<th>매도호가</th>
					<th>매수호가</th>
					<th>고가</th>
					<th>저가</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="StockChart1">${svo1.name }</a></td>
					<td>${svo1.nowPrice }</td>
					<c:set value="${fn:substring(svo1.vsyesterday,0,2)}" var="updown"/>
					<c:if test="${fn:startsWith(updown,'상승') }">
						<td style="color: blue; font-weight: bold;">↑${fn:substring(svo1.vsyesterday,2,5) } </td>
					</c:if>
					<c:if test="${fn:startsWith(updown,'하락') }">
						<td style="color: red; font-weight: bold;">↓${fn:substring(svo1.vsyesterday,2,5) } </td>
					</c:if >
					<c:set value="${fn:substring(svo1.dungRakrate,0,3) }" var="plus"/>
					<c:if test="${fn:startsWith(plus,'플러스') }">
						<td style="color: blue; font-weight: bold;">+${fn:substring(svo1.dungRakrate,3,7) }%</td>
					</c:if>
					<c:set value="${fn:substring(svo1.dungRakrate,0,4) }" var="minus"/>
					<c:if test="${fn:startsWith(minus,'마이너스') }" >
						<td style="color: red; font-weight: bold;">-${fn:substring(svo1.dungRakrate,4,8) }%</td>
					</c:if>
					
					
					<td>${svo1.highPrice }</td>
					<td>${svo1.lowPrice }</td>
					<td>${svo1.georaeryang }</td>
					<td>${svo1.tradingValue }</td>
				</tr>
				
				<tr>
					<td><a href="StockChart2">${svo2.name }</a></td>
					<td>${svo2.nowPrice }</td>
					<c:set value="${fn:substring(svo2.vsyesterday,0,2)}" var="updown"/>
					<c:if test="${fn:startsWith(updown,'상승') }">
						<td style="color: blue; font-weight: bold;">↑${fn:substring(svo2.vsyesterday,2,8) } </td>
					</c:if>
					<c:if test="${fn:startsWith(updown,'하락') }">
						<td style="color: red; font-weight: bold;">↓${fn:substring(svo2.vsyesterday,2,8) } </td>
					</c:if>
					<c:set value="${fn:substring(svo2.dungRakrate,0,3) }" var="plus"/>
					<c:if test="${fn:startsWith(plus,'플러스') }">
						<td style="color: blue; font-weight: bold;">+${fn:substring(svo2.dungRakrate,3,7) }%</td>
					</c:if>
					<c:set value="${fn:substring(svo2.dungRakrate,0,4) }" var="minus"/>
					<c:if test="${fn:startsWith(minus,'마이너스') }" >
						<td style="color: red; font-weight: bold;">-${fn:substring(svo2.dungRakrate,4,8) }%</td>
					</c:if>
					<td>${svo2.highPrice }</td>
					<td>${svo2.lowPrice }</td>
					<td>${svo2.georaeryang }</td>
					<td>${svo2.tradingValue }</td>
				</tr>
				
				<tr>
					<td><a href="StockChart3">${svo3.name }</a></td>
					<td>${svo3.nowPrice }</td>
					<c:set value="${fn:substring(svo3.vsyesterday,0,2)}" var="updown"/>
					<c:if test="${fn:startsWith(updown,'상승') }">
						<td style="color: blue; font-weight: bold;">↑${fn:substring(svo3.vsyesterday,2,8) } </td>
					</c:if>
					<c:if test="${fn:startsWith(updown,'하락') }">
						<td style="color: red; font-weight: bold;">↓${fn:substring(svo3.vsyesterday,2,8) } </td>
					</c:if>
					<c:set value="${fn:substring(svo3.dungRakrate,0,3) }" var="plus"/>
					<c:if test="${fn:startsWith(plus,'플러스') }">
						<td style="color: blue; font-weight: bold;">+${fn:substring(svo3.dungRakrate,3,7) }%</td>
					</c:if>
					<c:set value="${fn:substring(svo3.dungRakrate,0,4) }" var="minus"/>
					<c:if test="${fn:startsWith(minus,'마이너스') }" >
						<td style="color: red; font-weight: bold;">-${fn:substring(svo3.dungRakrate,4,8) }%</td>
					</c:if>
					<td>${svo3.highPrice }</td>
					<td>${svo3.lowPrice }</td>
					<td>${svo3.georaeryang }</td>
					<td>${svo3.tradingValue }</td>
				</tr>
				
				<tr>
					<td><a href="StockChart4">${svo4.name }</a></td>
					<td>${svo4.nowPrice }</td>
					<c:set value="${fn:substring(svo4.vsyesterday,0,2)}" var="updown"/>
					<c:if test="${fn:startsWith(updown,'상승') }">
						<td style="color: blue; font-weight: bold;">↑${fn:substring(svo4.vsyesterday,2,8) } </td>
					</c:if>
					<c:if test="${fn:startsWith(updown,'하락') }">
						<td style="color: red; font-weight: bold;">↓${fn:substring(svo4.vsyesterday,2,8) } </td>
					</c:if>
					<c:set value="${fn:substring(svo4.dungRakrate,0,3) }" var="plus"/>
					<c:if test="${fn:startsWith(plus,'플러스') }">
						<td style="color: blue; font-weight: bold;">+${fn:substring(svo4.dungRakrate,3,7) }%</td>
					</c:if>
					<c:set value="${fn:substring(svo4.dungRakrate,0,4) }" var="minus"/>
					<c:if test="${fn:startsWith(minus,'마이너스') }" >
						<td style="color: red; font-weight: bold;">-${fn:substring(svo4.dungRakrate,4,8) }%</td>
					</c:if>
					<td>${svo4.highPrice }</td>
					<td>${svo4.lowPrice }</td>
					<td>${svo4.georaeryang }</td>
					<td>${svo4.tradingValue }</td>
				</tr>
				
				<tr>
					<td><a href="StockChart5">${svo5.name }</a></td>
					<td>${svo5.nowPrice }</td>
					<c:set value="${fn:substring(svo5.vsyesterday,0,2)}" var="updown"/>
					<c:if test="${fn:startsWith(updown,'상승') }">
						<td style="color: blue; font-weight: bold;">↑${fn:substring(svo5.vsyesterday,2,8) } </td>
					</c:if>
					<c:if test="${fn:startsWith(updown,'하락') }">
						<td style="color: red; font-weight: bold;">↓${fn:substring(svo5.vsyesterday,2,8) } </td>
					</c:if>
					<c:set value="${fn:substring(svo5.dungRakrate,0,3) }" var="plus"/>
					<c:if test="${fn:startsWith(plus,'플러스') }">
						<td style="color: blue; font-weight: bold;">+${fn:substring(svo5.dungRakrate,3,7) }%</td>
					</c:if>
					<c:set value="${fn:substring(svo5.dungRakrate,0,4) }" var="minus"/>
					<c:if test="${fn:startsWith(minus,'마이너스') }" >
						<td style="color: red; font-weight: bold;">-${fn:substring(svo5.dungRakrate,4,8) }%</td>
					</c:if>
					<td>${svo5.highPrice }</td>
					<td>${svo5.lowPrice }</td>
					<td>${svo5.georaeryang }</td>
					<td>${svo5.tradingValue }</td>
				</tr>
				
				<tr>
					<td><a href="StockChart6">${svo6.name }</a></td>
					<td>${svo6.nowPrice }</td>
					<c:set value="${fn:substring(svo6.vsyesterday,0,2)}" var="updown"/>
					<c:if test="${fn:startsWith(updown,'상승') }">
						<td style="color: blue; font-weight: bold;">↑${fn:substring(svo6.vsyesterday,2,8) } </td>
					</c:if>
					<c:if test="${fn:startsWith(updown,'하락') }">
						<td style="color: red; font-weight: bold;">↓${fn:substring(svo6.vsyesterday,2,8) } </td>
					</c:if>
					<c:set value="${fn:substring(svo6.dungRakrate,0,3) }" var="plus"/>
					<c:if test="${fn:startsWith(plus,'플러스') }">
						<td style="color: blue; font-weight: bold;">+${fn:substring(svo6.dungRakrate,3,7) }%</td>
					</c:if>
					<c:set value="${fn:substring(svo6.dungRakrate,0,4) }" var="minus"/>
					<c:if test="${fn:startsWith(minus,'마이너스') }" >
						<td style="color: red; font-weight: bold;">-${fn:substring(svo6.dungRakrate,4,8) }%</td>
					</c:if>
					<td>${svo6.highPrice }</td>
					<td>${svo6.lowPrice }</td>
					<td>${svo6.georaeryang }</td>
					<td>${svo6.tradingValue }</td>
				</tr>
				
			</tbody>
		
		</table>
	</article>
	<!-- footer -->
		<%-- <jsp:include page="footer.jsp" /> --%>
	</div>
</body>
</html>