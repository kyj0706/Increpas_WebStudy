<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	74581267c2a0ae432666aeb188e8e1a9"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>

</head>
<body>

	<div id="map" style="width:100%;height:300px;"></div>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(37.483590, 126.901339), // 지도의 중심좌표
		        level: 4 // 지도의 확대 레벨
		    };
		
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		var content = '<div>인크레파스</div>'
		
		//마커포지션
		var markerPosition  = new kakao.maps.LatLng(37.482126, 126.901364); 
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});
		
	/* 	//글씨?
		var position = new kakao.maps.LatLng(37.482996, 126.901340);  
		var customOverlay = new kakao.maps.CustomOverlay({
		    position: position,
		    content: content   
		}); */
		
		/* customOverlay.setMap(map); */
		marker.setMap(map);
	</script>
	
	<div id="info_location">
		<strong>오시는 길</strong>
		<p>인크레파스로 오시는 길입니다.</p><br>
		서울특별시 관악구 시흥대로 552 석천빌딩 7층 ☎02-869-1080 <br>
		지하철 2호선 구로디지털단지역 6번출구 나와서 우측으로 150m
	</div>
	
	
	
	
	
	
	


</body>
</html>