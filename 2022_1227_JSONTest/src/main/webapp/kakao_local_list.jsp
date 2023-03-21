<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>




<style type="text/css">
	#box{
		width: 1000px;
		margin: auto;
		margin-top: 50px;
	
	}
	
	th{
		text-align: center;
	}
	
	sub{
		color: gray;
	}
</style>

<script type="text/javascript">
	
	//javacript
	window.onload = function() {
		
		if (navigator.geolocation) {
		    navigator.geolocation.getCurrentPosition(showPosition);
		  } else {
		    alert("Geolocation is not supported by this browser.");
		  }
	};
		
	
	function showPosition(position) {
		   document.getElementById("latitude").value = position.coords.latitude;
		   document.getElementById("longitude").value =  position.coords.longitude;
		}
	
	

</script>

<script type="text/javascript">
	function send(f) {
		
		
		
		f.action ="local_search.do";
		f.submit();
	}
	
	
	


</script>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=74581267c2a0ae432666aeb188e8e1a9"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    	mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    	};
	
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
			var map = new kakao.maps.Map(mapContainer, mapOption); 
		</script>





</head>
<body>
	<div id="box">
		<!-- 검색메뉴 -->
		<form action="">
			<input type="hidden" id="latitude" name="latitude" value=""> 
			<input type="hidden" id="longitude" name="longitude" value="">
			 
		검색명 : <input name="keyword">
				 <input type="button" value="검색" onclick="send(this.form);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
		페이지 : 
		<select id="page" name="page">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
		페이지당 조회 : 
		<select id="size" name="size">
			<option value="15">15</option>
			<option value="10">10</option>
			<option value="5">5</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
		검색반경 : 
		<select id="radius" name="radius">
			<option value="200">200m</option>
			<option value="1000">1km</option>
			<option value="500">500m</option>
			<option value="100">100m</option>
		</select>
		
		
		
		</form>
		
	
		<!-- 검색결과 출력 -->
		<table class="table table-striped">
			<tr class="success">
				<th>순번</th>
				<th width="10%">상호</th>
				<th>카테고리</th>
				<th>주소</th>
				<th width="15%">전화</th>
				<th>거리(m)</th>
				<th width="20%">위치(위도/경도)</th>
			</tr>
			
			<c:if test="${empty list }">
			<tr>
				<td	colspan="7" align="center">
					<font color="red">검색 결과가 없습니다.</font>
				</td>
			</tr>
			</c:if>
			
			
			<c:forEach var="lc" items="${list }" varStatus="i">
			<tr>
				<td align="center">${page + i.index }</td>
				<td align="center"><a href="${lc.place_url}"> ${lc.place_name }</a></td>
				<td align="center"><strong> ${lc.category_group_name }</strong><br>
					<sub>${lc.category_name }</sub>
				</td>
				<td><strong>${lc. road_address}</strong> <br>
					<sub>지번 | ${lc.address }</sub>
				</td>
				<td align="center">${lc.phone }</td>
				<td align="center">${lc.distance }m</td>
				<td id="map" style="width:30%; height: 300px;">지도<br>
				<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = { 
			        center: new kakao.maps.LatLng(${lc.latitude }, ${lc.longitude }), // 지도의 중심좌표
			        level: 4 // 지도의 확대 레벨
					    };
					
					// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
					var map = new kakao.maps.Map(mapContainer, mapOption); 
					var content = '<div>${lc.place_name }</div>'
					
					//마커포지션
					var markerPosition  = new kakao.maps.LatLng("${lc.latitude }", "${lc.longitude }"); 
					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
					    position: markerPosition
					});
					marker.setMap(map);
				</script>
					위도 :${lc.latitude } <br>
					경도 :${lc.longitude }
					
				</td>
			</tr>
			</c:forEach>
		
		
		</table>
	
		
		
		</div>
		
			
	
		<!-- <div id="map" style="width:100%;height:350px;"></div> -->
		
</body>
</html>