<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/footer/footer.css">
<link rel="stylesheet" href="resources/css/header/header.css">
<link rel="stylesheet" href="resources/css/main/main.css">
<style>
	#chart_area{
		width: 80%;
		height: 600px;
		margin: auto;
		
	}
	
	#title{
		margin-top: 250px;
		font-family: sans-serif;
		font-size: 50px;
		font-weight: bold;
		text-align: center;
	}
	
	#nowP{
		font-size: 30px;
		font-weight: bolder;
		border: 1px solid silver;
	}
   table{
     width: 1200px;
     border-collapse: collapse;
     width: 80%;
   	 margin: 10px auto;
	}
   table td{
	   text-align: center;
		padding: 4px 10px;
		border-bottom: 1px solid silver;
		height: 90px;
   }
  
   table tbody tr{
      
      text-align: center;
   }
   
   #data{
   	  font-size: 20px;
	  font-weight: bold;
	  font-style: italic;
   }
   
    tbody> tr> td>span {
	font-size: 40px;
}
   
   
</style>

</head>
<body>
	<!-- 헤더 -->
	<header>
		<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
	</header>
	<!-- 메뉴 -->
	<nav>
		<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
	</nav>
	<div>
		<div id="table_div">
			<div id="title">
				<p>TIGER차이나전기차SOLACTIVE</p>
				<hr>
			</div>
		</div>
		<article style="margin: 0 0 100px 0;">
	
			<table>
				
				<tbody>
					<tr>
						<td id="nowP" colspan="2" rowspan="2">${svo1.nowPrice }<br>전일대비

						<c:set value="${fn:substring(svo1.vsyesterday,0,2)}" var="updown"/>
						<c:if test="${fn:startsWith(updown,'상승') }">
							<span style="color: blue;" >↑${fn:substring(svo1.vsyesterday,2,5) } </span>
						</c:if>
						<c:if test="${fn:startsWith(updown,'하락') }">
							<span style="color: red;">↓${fn:substring(svo1.vsyesterday,2,5) } </span>
						</c:if >						
						/
						<c:set value="${fn:substring(svo1.dungRakrate,0,3) }" var="plus"/>
						<c:if test="${fn:startsWith(plus,'플러스') }">
							<span style="color: blue;"> +${fn:substring(svo1.dungRakrate,3,7) }%</span>
						</c:if>
						<c:set value="${fn:substring(svo1.dungRakrate,0,4) }" var="minus"/>
						<c:if test="${fn:startsWith(minus,'마이너스') }" >
							<span style="color: red;"> -${fn:substring(svo1.dungRakrate,4,8) }% </span>
						</c:if>
						</td>
						
						<td id="data">전일 ${svo1.yesterdayPrice }</td>
						<td id="data">고가 ${svo1.highPrice }</td>
						<td id="data">거래량 ${svo1.georaeryang }</td>
					</tr>
					<tr>
						<td id="data">시가 ${svo1.sigaPrice }</td>
						<td id="data">저가 ${svo1.lowPrice }</td>
						<td id="data">거래대금 ${svo1.tradingValue }</td>
				</tbody>
			</table>
		</article>
	</div>
	
<div id="chart_div">
	
	<article>
		<div id="chart_area"></div>
	</article>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="//www.amcharts.com/lib/4/core.js"></script>
<script src="//www.amcharts.com/lib/4/charts.js"></script>
<script src="//www.amcharts.com/lib/4/themes/animated.js"></script>
<script>
	$(function(){
		
		am4core.useTheme(am4themes_animated);
		var chart = am4core.create("chart_area", am4charts.XYChart);
	
		chart.data = [
			
			
			<c:forEach var="vo" items="${ar}">
			{"date":"${vo.date}","sise":${vo.sise}},
			</c:forEach>
			
		];
		
		//X축 만들기
		var x_Axis = chart.xAxes.push(new am4charts.CategoryAxis());
		x_Axis.dataFields.category = "date";
		x_Axis.renderer.labels.template.fonsSize = 11;
		x_Axis.renderer.minGridDistance = 10;
		
		//Y축 만들기
		var y_Axis = chart.yAxes.push(new am4charts.ValueAxis());
		y_Axis.dataFields.category = "sise";
		y_Axis.renderer.labels.template.fonsSize = 11;
		y_Axis.renderer.minGridDistance = 30;
		
		//Series 만들기
		var series = chart.series.push(new am4charts.LineSeries());
		series.dataFields.categoryX = "date";
		series.dataFields.valueY = "sise";
		
		
		var bullet = series.bullets.push(new am4charts.CircleBullet());
		bullet.circle.stroke = am4core.color("#fff");
		bullet.circle.strokeWidth = 2;
		
		chart.legend = new am4charts.Legend();
		chart.cursor = new am4charts.XYCursor();
		
		
	});
</script>
	<footer>
		<jsp:include page="/WEB-INF/views/layout/footer/footer.jsp"></jsp:include>
	</footer>

</body>
</html>